package ads.pbe.messages.dto;

public record PublishRequest(String message, Integer ttl, Integer maxAccesses) {

}
