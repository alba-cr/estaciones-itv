package is1205.iei.services;

import is1205.iei.models.Provincia;
import is1205.iei.repository.ProvinciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinciaService {
    private final ProvinciaRepository provinciaRepository;
    public ProvinciaService(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    public Provincia getProvincia(Long cod_provincia) {
        return provinciaRepository.findById(cod_provincia).get();
    }
    public List<Provincia> getProvincias() {
        return provinciaRepository.findAll();
    }
    public Provincia saveProvincia(Provincia p) {
        return provinciaRepository.save(p);
    }
    public void deleteProvincia(Long cod_provincia) {
        provinciaRepository.deleteById(cod_provincia);
    }
}
