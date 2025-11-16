package is1205.iei.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Estacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_estacion;

    private String nombre;
    private Tipo tipo;
    private String direccion;
    private int codigo_postal;
    private Double longitud;
    private Double latitud;
    private String descripcion;
    private String horario;
    private String contacto;
    private String url;

    @ManyToOne
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;
}