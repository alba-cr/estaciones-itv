package is1205.iei.services;

import is1205.iei.models.Localidad;
import is1205.iei.repository.LocalidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocalidadService {
    private final LocalidadRepository localidadRepository;
    public LocalidadService(LocalidadRepository localidadRepository) {
        this.localidadRepository = localidadRepository;
    }

    public Localidad getLocalidad(Long cod_localidad) {
        return localidadRepository.findById(cod_localidad).get();
    }
    public List<Localidad> getLocalidades() {
        return localidadRepository.findAll();
    }
    public Localidad saveLocalidad(Localidad localidad) {
        return localidadRepository.save(localidad);
    }
    public void deleteLocalidad(Long cod_localidad) {
        localidadRepository.deleteById(cod_localidad);
    }
}
