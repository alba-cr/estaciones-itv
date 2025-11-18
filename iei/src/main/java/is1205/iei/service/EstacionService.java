package is1205.iei.service;

import is1205.iei.model.Estacion;
import is1205.iei.model.Localidad;
import is1205.iei.repository.EstacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstacionService {
    private final EstacionRepository estacionRepository;
    private LocalidadService localidadService;

    public EstacionService(EstacionRepository estacionRepository, LocalidadService localidadService) {
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
