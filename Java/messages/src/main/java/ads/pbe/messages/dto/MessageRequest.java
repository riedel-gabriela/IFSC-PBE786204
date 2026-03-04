public record MessageRequest(
    String content,
    Long ttl,
    Integer limit_access
) {}
