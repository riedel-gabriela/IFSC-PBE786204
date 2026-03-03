package ads.pbe.messages.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    @Transactional
    public void saveMessage(String key, MessageRequest request) {
        Message msg = new Message();
        msg.setkey(key);
        msg.setContent(request.content());
        msg.setLimitAccess(request.limit_access())

         if (request.ttl() != null) {
            msg.setExpireAt(LocalDateTime.now().plusSeconds(request.ttl()));
        }

        repository.save(msg);
    }

    @Transactional
    public Optional<String> accessNextMessage(String key) {
        List<Message> msgs = repository.findByKeyOrderByCreatedAtAsc(key);

        for (Message msg : msgs) {
            if (msg.getExpireAt() != null && msg.getExpireAt().isBefore(LocalDateTime.now())) {
                repository.delete(msg);
                continue;
            }

            msg.setAccessed();
            String content = msg.getContent();

            if (msg.getLimitAccess() != null && msg.getAccessed() >= msg.getLimitAccess()) {
                repository.delete(msg);
            } else {
                repository.save(msg);
            }

            return Optional.of(conteudo);
        }
        return Optional.empty();
    }
}