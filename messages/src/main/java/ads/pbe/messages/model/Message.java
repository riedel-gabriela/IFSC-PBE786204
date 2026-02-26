package ads.pbe.messages.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private String key;
    private String text;
    private Instant expiresAt;
    private Integer maxAccesses;
    private int accessCount;
}
