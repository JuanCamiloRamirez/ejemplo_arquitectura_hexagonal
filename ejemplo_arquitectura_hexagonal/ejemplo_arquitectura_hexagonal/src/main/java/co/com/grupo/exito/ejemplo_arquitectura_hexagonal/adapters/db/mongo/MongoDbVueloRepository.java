package co.com.grupo.exito.ejemplo_arquitectura_hexagonal.adapters.db.mongo;

import co.com.grupo.exito.ejemplo_arquitectura_hexagonal.domain.model.Vuelo;
import co.com.grupo.exito.ejemplo_arquitectura_hexagonal.domain.ports.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Primary
public class MongoDbVueloRepository implements VueloRepository {
    private final SpringDataMongoVueloRepository vueloRepository;

    @Autowired
    public MongoDbVueloRepository(final SpringDataMongoVueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    public Optional<Vuelo> findById(final UUID id) {
        return vueloRepository.findById(id);
    }

    public void save( Vuelo vuelo) {
        vueloRepository.save(vuelo);
    }

    @Override
    public Page<Vuelo> findAll(Pageable pageable) {
        return vueloRepository.findAll(pageable);
    }
}
