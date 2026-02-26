package ads.pbe.messages.repository;

import java.util.*;

import ads.pbe.messages.dto.MessageDTO;
import org.springframework.stereotype.Repository;

import ads.pbe.messages.model.Message;

@Repository
public class InMemoryMessageRepository implements MessageRepository {
    private final HashMap<String, ArrayList<Message>> messages;

    public InMemoryMessageRepository() {
        this.messages = new HashMap<>();
    }

    @Override
    public Message save(Message message) {
        if (messages.containsKey(message.getKey())) {
            messages.get(message.getKey()).add(message);
        } else {
            ArrayList<Message> lista = new ArrayList<>();
            lista.add(message);
            messages.putIfAbsent(message.getKey(), lista);
        }
        return message;
    }

    @Override
    public ArrayList<Message> peekByKey(String key) {
        if (!messages.containsKey(key)) {
            throw new Error("Key not found");
        }
        return messages.get(key);
    }

    @Override
    public Message pollByKey(String key) {
        if (!messages.containsKey(key)) {
            throw new Error("Key not found");
        }
        return messages.get(key).removeLast();
    }
}
