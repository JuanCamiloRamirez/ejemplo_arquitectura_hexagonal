package co.com.grupo.exito.ejemplo_arquitectura_hexagonal.configuration;

import co.com.grupo.exito.ejemplo_arquitectura_hexagonal.adapters.db.mongo.SpringDataMongoVueloRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoVueloRepository.class)
public class MongoDBConfiguration {
}
