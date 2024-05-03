package com.shun.employeeservice.config;

import com.shun.employeeservice.common.Constants;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Configuration class for creating Kafka producer-related beans.
 * This class defines beans for configuring Kafka producer properties
 * and setting up the KafkaTemplate for producing messages to Kafka topics.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Configuration
public class KafkaProducerConfig {

    /**
     * <p>
     * Creates and configures a Kafka ProducerFactory bean.
     * </p>
     *
     * @return The configured ProducerFactory bean.
     */
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.KAFKA_SERVER);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(properties);
    }

    /**
     * <p>
     * Creates and configures a KafkaTemplate bean.
     * </p>
     *
     * @return The configured KafkaTemplate bean.
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
