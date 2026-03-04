package ads.pbe.cpf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ads.pbe.cpf.service.CPFService;

@RestController
public class CPFController {
    @Autowired
    CPFService cpfService;

    @GetMapping("/api/verificador/{cpf}")
    public ResponseEntity<String> handleURI(@PathVariable String cpf) {
        return verify(cpf);
    }

    @GetMapping("/api/verificador")
    public ResponseEntity<String> handleGetRequest(@RequestParam String cpf) {
        return verify(cpf);
    }

    @PostMapping("/api/verificador")
    public ResponseEntity<String> handlePostRequest(@RequestParam String cpf) {
        return verify(cpf);
    }

    private ResponseEntity<String> verify(String cpf) {
        if (cpfService.assertValid(cpf))
            return ResponseEntity.ok(cpf);

        return ResponseEntity.badRequest().body("inválido");
    }
}
