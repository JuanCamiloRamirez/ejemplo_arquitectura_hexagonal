package co.com.grupo.exito.ejemplo_arquitectura_hexagonal.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Vuelo {
    private String id_vuelo;
    private String nombre_cliente;
    private String origen;
    private String destino;
    private String fecha_vuelo;
    private String hora_despegue;
    private String hora_llegada;
    private String matricula_avion;

    public Vuelo(String id_vuelo, String nombre_cliente ) {
        this.id_vuelo = id_vuelo;
        this.nombre_cliente= nombre_cliente;
    }
}
