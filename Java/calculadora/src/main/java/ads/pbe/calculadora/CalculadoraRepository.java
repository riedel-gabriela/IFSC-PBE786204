package ads.pbe.calculadora;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CalculadoraRepository extends JpaRepository<Calculadora, Long> {
    @Override
    Optional<Calculadora> findById(Long aLong);

    @Override
    List<Calculadora> findAll();
}
