package is1205.iei.controller;

import is1205.iei.models.Estacion;
import is1205.iei.services.EstacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estaciones")
public class EstacionController {

    private final EstacionService estacionService;

    EstacionController(EstacionService estacionService) {
        this.estacionService = estacionService;
    }

    @PostMapping
    public ResponseEntity<Estacion> save(@RequestBody Estacion estacion) {
        return  ResponseEntity.status(201).body(estacionService.saveEstacion(estacion));
    }

    @GetMapping
    public ResponseEntity<List<Estacion>> findAll() {
        return ResponseEntity.ok(estacionService.getEstaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estacion> findById(@PathVariable Long id) {
        return ResponseEntity.ok(estacionService.getEstacion(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        estacionService.deleteEstacion(id);
    }
}
