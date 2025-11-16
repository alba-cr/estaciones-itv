package is1205.iei.services;

import is1205.iei.models.Estacion;
import is1205.iei.models.Localidad;
import is1205.iei.repository.EstacionRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstacionService {
    private final EstacionRespository estacionRepository;
    private LocalidadService localidadService;

    public EstacionService(EstacionRespository estacionRepository, LocalidadService localidadService) {
        this.estacionRepository = estacionRepository;
        this.localidadService = localidadService;
    }

    public Estacion getEstacion(Long cod_estacion) {
        return estacionRepository.findById(cod_estacion).get();
    }

    public List<Estacion> getEstaciones() {
        return estacionRepository.findAll();
    }

    public Estacion saveEstacion(Estacion estacion) {
        String nombreLoc = estacion.getLocalidad().getNombre();
        String nombreProv = estacion.getLocalidad().getProvincia().getNombre();

        Localidad loc = localidadService.findOrCreate(nombreLoc, nombreProv);

        estacion.setLocalidad(loc);

        return estacionRepository.save(estacion);
    }

    public void deleteEstacion(Long cod_estacion) {
        estacionRepository.deleteById(cod_estacion);
    }
}
