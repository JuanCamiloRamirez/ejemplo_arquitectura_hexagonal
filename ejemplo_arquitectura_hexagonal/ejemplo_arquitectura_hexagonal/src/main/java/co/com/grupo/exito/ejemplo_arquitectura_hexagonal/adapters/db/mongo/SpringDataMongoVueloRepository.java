package co.com.grupo.exito.ejemplo_arquitectura_hexagonal.adapters.db.mongo;

import co.com.grupo.exito.ejemplo_arquitectura_hexagonal.domain.model.Vuelo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SpringDataMongoVueloRepository extends MongoRepository<Vuelo, UUID> {
}
