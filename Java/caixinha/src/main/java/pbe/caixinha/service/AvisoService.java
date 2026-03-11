package pbe.caixinha.service;

import org.springframework.beans.factory.annotation.Autowired;
import pbe.caixinha.dto.AvisoRequest;
import pbe.caixinha.model.Aviso;
import pbe.caixinha.repository.AvisosRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class AvisoService {

    @Autowired
    private AvisosRepository repository;

    public void saveAviso(AvisoRequest request, String status) {
        Aviso avs = new Aviso();
        avs.setContact(request.contact());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        avs.setDate(LocalDateTime.parse(now.format(formatter)));
        avs.setLocal(request.local());
        avs.setDescription(request.description());
        avs.setStatus(status);

        repository.save(avs);
    }

    public Optional<String> accessAvisos(LocalDateTime date) {
        List<Aviso> avs = repository.findByDateOrderByDateAsc(date);
        return Optional.of(avs.toString());
    }
}
