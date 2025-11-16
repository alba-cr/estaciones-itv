package is1205.iei.controller;

import is1205.iei.models.Provincia;
import is1205.iei.services.ProvinciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {
    private final ProvinciaService provinciaService;

    ProvinciaController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    @PostMapping
    public ResponseEntity<Provincia> save(@RequestBody Provincia provincia) {
        return ResponseEntity.status(201).body(provinciaService.saveProvincia(provincia));
    }

    @GetMapping
    public ResponseEntity<List<Provincia>> findAll() {
        return ResponseEntity.ok(provinciaService.getProvincias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provincia> findById(@PathVariable Long id) {
        return ResponseEntity.ok(provinciaService.getProvincia(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        provinciaService.deleteProvincia(id);
    }
}
