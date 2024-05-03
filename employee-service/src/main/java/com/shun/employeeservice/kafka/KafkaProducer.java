package com.shun.employeeservice.kafka;

import com.shun.employeeservice.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Kafka message producer service.
 * This class sends messages to a Kafka topic using a KafkaTemplate.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * <p>
     * Sends a message to the configured Kafka topic.
     * </p>
     *
     * @param message The message to be sent.
     */
    public void sendMessage(String message) {
        kafkaTemplate.send(Constants.TOPIC_NAME, message);
    }
}
