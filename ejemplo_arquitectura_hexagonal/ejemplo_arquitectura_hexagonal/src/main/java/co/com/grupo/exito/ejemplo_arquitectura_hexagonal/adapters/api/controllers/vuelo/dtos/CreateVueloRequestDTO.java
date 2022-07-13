package co.com.grupo.exito.ejemplo_arquitectura_hexagonal.adapters.api.controllers.vuelo.dtos;

import co.com.grupo.exito.ejemplo_arquitectura_hexagonal.domain.model.Vuelo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter

public class CreateVueloRequestDTO {

    @NotBlank(message = "id is mandatory")
    private String id_vuelo;

    @NotBlank(message = "nombre_cliente es obligatorio")
    private String nombre_cliente;

    @NotBlank(message = "origen es obligatorio")
    private String origen;

    @NotBlank(message = "destino es obligatorio")
    private String destino;

    @NotBlank(message = "fecha_vuelo es obligatorio")
    private String fecha_vuelo;

    @NotBlank(message = "hora_despegue es obligatorio")
    private String hora_despegue;

    @NotBlank(message = "hora_llegada es obligatorio")
    private String hora_llegada;

    @NotBlank(message = "matricula_avion es obligatorio")
    private String matricula_avion;

    public Vuelo getVuelo() {
        return  new Vuelo(this.id_vuelo, this.nombre_cliente);
    }
}
