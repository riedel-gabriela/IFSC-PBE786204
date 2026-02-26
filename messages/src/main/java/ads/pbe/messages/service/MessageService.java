package ads.pbe.messages.service;

import java.time.Instant;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ads.pbe.messages.dto.MessageDTO;
import ads.pbe.messages.dto.PublishRequest;
import ads.pbe.messages.model.Message;
import ads.pbe.messages.repository.MessageRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageDTO saveMessage(String key, PublishRequest request) {
        Instant expiresAt = request.ttl() != null ? Instant.now().plusSeconds(request.ttl()) : null;
        Message message = new Message(key, request.message(), expiresAt, request.maxAccesses(), 0);
        Message saved = messageRepository.save(message);
        return new MessageDTO(saved.getKey(), saved.getText());
    }

    public String getMessage(String key) {
        while (true) {
            ArrayList<Message> messages = messageRepository.peekByKey(key);
            if (messages == null) {
                return null;
            }
            Message message = messages.getFirst();

            if (message.getExpiresAt() != null && Instant.now().isAfter(message.getExpiresAt())) {
                messageRepository.pollByKey(key);
                continue;
            }

            message.setAccessCount(message.getAccessCount() + 1);

            if (message.getMaxAccesses() == null || message.getAccessCount() >= message.getMaxAccesses()) {
                messageRepository.pollByKey(key);
            }

            return messages.toString();
        }
    }
}
