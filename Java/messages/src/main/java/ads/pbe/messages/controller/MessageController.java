package ads.pbe.messages.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mensageiro")
public class MensageiroController {

    @Autowired
    private MessageService service;

    @PostMapping("/publica/{key}")
    public ResponseEntity<Void> publicar(@PathVariable String key, @RequestBody String content) {
        service.saveMessage(key, content);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/acessa/{key}")
    public ResponseEntity<String> acessar(@PathVariable String key) {
        return service.accessNextMessage(key)
                .map(content -> ResponseEntity.ok(content))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
