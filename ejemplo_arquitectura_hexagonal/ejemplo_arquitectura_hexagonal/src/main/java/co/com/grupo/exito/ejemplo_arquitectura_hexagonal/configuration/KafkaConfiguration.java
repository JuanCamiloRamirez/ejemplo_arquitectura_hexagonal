package co.com.grupo.exito.ejemplo_arquitectura_hexagonal.configuration;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    @Value("${spring.kafka.boostrap-server}")
    String boostrapServer;

    @Bean
    //  public ProducerFactory<String, MessageTransportGuide> messageKafkaGuideproducerFactory(){
    public ProducerFactory<String, String> messageKafkaGuideproducerFactory(){
        Map<String,Object> configProps=new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,boostrapServer);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializer.class.getName());
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    //public KafkaTemplate<String, MessageTransportGuide> messagekafkaGuideTemplate(){
    public KafkaTemplate<String, String> messagekafkaGuideTemplate(){
        return new KafkaTemplate<>(messageKafkaGuideproducerFactory());
    }

}
