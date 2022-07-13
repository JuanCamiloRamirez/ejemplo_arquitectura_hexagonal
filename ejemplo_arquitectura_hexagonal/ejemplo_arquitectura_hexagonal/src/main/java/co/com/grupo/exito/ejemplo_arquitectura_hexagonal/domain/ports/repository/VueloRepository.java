package co.com.grupo.exito.ejemplo_arquitectura_hexagonal.domain.ports.repository;

import co.com.grupo.exito.ejemplo_arquitectura_hexagonal.domain.model.Vuelo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VueloRepository {
    void save(Vuelo vuelo);

    Page<Vuelo> findAll(Pageable pageable);
}
