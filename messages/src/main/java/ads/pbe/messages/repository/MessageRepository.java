package ads.pbe.messages.repository;

import ads.pbe.messages.model.Message;

public interface MessageRepository {
    Message save(Message message);

    Message peekByKey(String key);

    Message pollByKey(String key);
}
