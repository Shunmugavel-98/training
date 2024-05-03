package com.shun.employeeservice.kafka;

import com.shun.employeeservice.common.Constants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Kafka message consumer service.
 * This class listens for messages from a specific Kafka topic
 * and processes them accordingly.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Service
public class KafkaConsumer {

    /**
     * <p>
     * Kafka message listener method.
     * This method listens for messages from a specific Kafka topic.
     * </p>
     *
     * @param message The message received from the Kafka topic.
     */
    @KafkaListener(topics = Constants.TOPIC_NAME, groupId = Constants.KAFKA_CONSUMER_GROUP)
    public void listen(String message) {
        System.out.println(Constants.RECEIVED_MESSAGE_IN_GROUP.concat(message));
    }
}
