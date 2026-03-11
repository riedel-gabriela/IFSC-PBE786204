package pbe.caixinha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pbe.caixinha.dto.AvisoRequest;
import pbe.caixinha.service.AvisoService;

import java.time.LocalDateTime;

public class AvisoController {

    @Autowired
    private AvisoService service;

    @PostMapping("/publica/achado")
    public ResponseEntity<Void> publicarAchado(@RequestBody AvisoRequest body) {
        service.saveAviso(body, "achado");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/publica/perdido")
    public ResponseEntity<Void> publicarPerdido(@RequestBody AvisoRequest body) {
        service.saveAviso(body, "perdido");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("avisos/{date}")
    public ResponseEntity<String> acessarAvisos(@PathVariable LocalDateTime date) {
        return service.accessAvisos(date).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
