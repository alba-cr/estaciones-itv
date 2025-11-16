package is1205.iei.services;

import is1205.iei.models.Localidad;
import is1205.iei.models.Provincia;
import is1205.iei.repository.LocalidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocalidadService {
    private final LocalidadRepository localidadRepository;
    private final ProvinciaService provinciaService;
    public LocalidadService(LocalidadRepository localidadRepository, ProvinciaService provinciaService) {
        this.localidadRepository = localidadRepository;
        this.provinciaService = provinciaService;
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

    // public Localidad findOrCreate(String nombreLocalidad, String nombreProvincia) {
    //     Localidad localidad = localidadRepository.findByNombre(nombreLocalidad);

    //     if(localidad == null) {
    //         Provincia prov = provinciaService.findOrCreate(nombreProvincia);
            
    //         localidad = new Localidad();
    //         localidad.setNombre(nombreProvincia);
    //         localidad.setProvincia(prov);
    //     }
    // }
}
