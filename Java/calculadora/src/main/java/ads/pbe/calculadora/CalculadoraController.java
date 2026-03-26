package ads.pbe.calculadora;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CalculadoraController {

    @Autowired
    private CalculadoraService service;

    @GetMapping("/caculadora")
    public ResponseEntity<List<Calculadora>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/calculadora/{id}")
    public ResponseEntity<Optional<Calculadora>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCalculadoraById(id));
    }

    @PostMapping("/calculadora/{id}")
    public void postCalculadora(@PathVariable Long id) {
        service.postCalculadora(id);
    }

}
