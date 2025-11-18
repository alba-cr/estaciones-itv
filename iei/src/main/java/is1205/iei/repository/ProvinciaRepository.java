package is1205.iei.repository;

import is1205.iei.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
    Provincia findByNombre(String nombre);
}
