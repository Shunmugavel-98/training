package com.shun.employeeservice.config;

import com.shun.employeeservice.common.Constants;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Configuration class for creating Kafka consumer-related beans.
 * This class defines beans for configuring Kafka consumer properties
 * and setting up the Kafka message listener container factory.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    /**
     * <p>
     * Creates and configures a Kafka ConsumerFactory bean.
     * </p>
     *
     * @return The configured ConsumerFactory bean.
     */
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.KAFKA_SERVER);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, Constants.KAFKA_CONSUMER_GROUP);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(properties);
    }

    /**
     * <p>
     * Creates and configures a ConcurrentKafkaListenerContainerFactory bean.
     * </p>
     *
     * @return The configured ConcurrentKafkaListenerContainerFactory bean.
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
