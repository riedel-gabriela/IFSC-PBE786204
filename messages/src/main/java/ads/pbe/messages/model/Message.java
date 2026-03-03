package ads.pbe.messages.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String key;
    private String content;
    private LocalDateTime created_at = LocalDateTime.now();

    private LocalDateTime expire_at;
    private Integer limit_access;
    private int accessed = 0;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDateTime getCreatedAt() { return created_at; }
    public LocalDateTime getExpireAt() { return expire_at; }
    public void setExpireAt(LocalDateTime expire_date) { this.expire_at = expire_date; }
    public Integer getLimitAccess() { return limit_access; }
    public void setLimitAccess(Integer limit_access) { this.limit_access = limit_access; }
    public int getAccessed() { return accessed; }
    public void setAccessed() { this.accessed++; }
}
