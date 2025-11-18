package is1205.iei.controller;

import is1205.iei.model.Localidad;
import is1205.iei.service.LocalidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localidades")
public class LocalidadController {
    private final LocalidadService localidadService;

    LocalidadController(LocalidadService localidadService) {
        this.localidadService = localidadService;
    }

    @PostMapping
    public ResponseEntity<Localidad> save(@RequestBody Localidad localidad) {
        return ResponseEntity.status(201).body(localidadService.saveLocalidad(localidad));
    }

    @GetMapping
    public ResponseEntity<List<Localidad>> findAll() {
        return ResponseEntity.ok(localidadService.getLocalidades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localidad> findById(@PathVariable Long id) {
        return ResponseEntity.ok(localidadService.getLocalidad(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        localidadService.deleteLocalidad(id);
    }


}


