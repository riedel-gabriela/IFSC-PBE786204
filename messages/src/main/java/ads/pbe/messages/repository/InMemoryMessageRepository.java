package ads.pbe.messages.repository;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

import org.springframework.stereotype.Repository;

import ads.pbe.messages.model.Message;

@Repository
public class InMemoryMessageRepository implements MessageRepository {
    private final HashMap<String, Queue<Message>> messages;

    public InMemoryMessageRepository() {
        this.messages = new HashMap<>();
    }

    @Override
    public Message save(Message message) {
        this.messages.putIfAbsent(message.getKey(), new ArrayDeque<>());
        this.messages.get(message.getKey()).offer(message);
        return message;
    }

    @Override
    public Message peekByKey(String key) {
        Queue<Message> queue = this.messages.getOrDefault(key, new ArrayDeque<>());
        return queue.peek();
    }

    @Override
    public Message pollByKey(String key) {
        Queue<Message> queue = this.messages.getOrDefault(key, new ArrayDeque<>());
        return queue.poll();
    }
}
