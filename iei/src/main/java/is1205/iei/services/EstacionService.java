package is1205.iei.services;

import is1205.iei.models.Estacion;
import is1205.iei.repository.EstacionRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstacionService {
    private final EstacionRespository estacionRepository;
    public EstacionService(EstacionRespository estacionRepository) {
        this.estacionRepository = estacionRepository;
    }
    public Estacion getEstacion(Long cod_estacion) {
        return estacionRepository.findById(cod_estacion).get();
    }
    public List<Estacion> getEstaciones() {
        return estacionRepository.findAll();
    }
    public Estacion saveEstacion(Estacion estacion) {
        return estacionRepository.save(estacion);
    }
    public void deleteEstacion(Long cod_estacion) {
        estacionRepository.deleteById(cod_estacion);
    }
}
