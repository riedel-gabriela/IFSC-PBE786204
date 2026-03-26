package ads.pbe.calculadora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalculadoraService {

    @Autowired
    private CalculadoraRepository repository;

    public List<Calculadora> getAll() {
        return repository.findAll();
    }

    public Optional<Calculadora> getCalculadoraById(Long id) {
        return repository.findById(id);
    }

    public void postCalculadora(Long id) {
        Calculadora calc = new Calculadora(id);
        repository.save(calc);
    }
}
