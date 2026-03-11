package pbe.caixinha.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pbe.caixinha.model.Aviso;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AvisosRepository extends JpaRepository<Aviso, Long> {
    List<Aviso> findByDateOrderByDateAsc(LocalDateTime date);
}