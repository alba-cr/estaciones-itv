package is1205.iei.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Localidad {
    @Id
    private Long codigo;
    private String nombre;
}
