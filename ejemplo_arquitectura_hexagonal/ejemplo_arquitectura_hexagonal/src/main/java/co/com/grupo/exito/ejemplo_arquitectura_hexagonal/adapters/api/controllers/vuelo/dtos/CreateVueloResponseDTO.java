package co.com.grupo.exito.ejemplo_arquitectura_hexagonal.adapters.api.controllers.vuelo.dtos;

import co.com.grupo.exito.ejemplo_arquitectura_hexagonal.domain.model.Vuelo;

public class CreateVueloResponseDTO {
    private String id_vuelo;
    private String nombre_cliente;
    private String hora_despegue;

    public CreateVueloResponseDTO(String id_vuelo, String nombre_cliente, String hora_despegue) {
        this.id_vuelo = id_vuelo;
        this.nombre_cliente = nombre_cliente;
        this.hora_despegue = hora_despegue;
    }

    public String getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(String id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getHora_despegue() {
        return hora_despegue;
    }

    public void setHora_despegue(String hora_despegue) {
        this.hora_despegue = hora_despegue;
    }

    public static CreateVueloResponseDTO of(Vuelo vuelo) {
        return new CreateVueloResponseDTO(vuelo.getId_vuelo(), vuelo.getNombre_cliente(), vuelo.getHora_despegue());

    }
}
