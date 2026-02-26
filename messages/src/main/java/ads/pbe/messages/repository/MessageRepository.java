package ads.pbe.messages.repository;

import ads.pbe.messages.model.Message;

import java.util.ArrayList;

public interface MessageRepository {
    Message save(Message message);

    ArrayList<Message> peekByKey(String key);

    Message pollByKey(String key);
}
