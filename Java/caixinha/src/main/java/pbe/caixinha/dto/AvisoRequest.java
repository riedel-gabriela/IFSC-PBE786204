package pbe.caixinha.dto;

public record AvisoRequest(
        String status,
        String description,
        String local,
        String contact
){}
