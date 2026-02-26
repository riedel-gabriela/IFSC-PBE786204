package ads.pbe.messages.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ads.pbe.messages.dto.MessageDTO;
import ads.pbe.messages.dto.PublishRequest;
import ads.pbe.messages.service.MessageService;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/mensageiro/publica/{key}")
    public ResponseEntity<String> postMethodName(@PathVariable String key, @RequestBody PublishRequest request) {
        MessageDTO saved = messageService.saveMessage(key, request);
        return ResponseEntity.ok().body(saved.toString());
    }

    @GetMapping("/mensageiro/acessa/{key}")
    public ResponseEntity<String> getMethodName(@PathVariable String key) {
        MessageDTO dto = messageService.getNextMessage(key);
        return dto != null ? ResponseEntity.ok(dto.message()) : ResponseEntity.notFound().build();
    }
}
