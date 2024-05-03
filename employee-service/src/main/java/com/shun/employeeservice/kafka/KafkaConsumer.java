package com.shun.employeeservice.kafka;

import com.shun.employeeservice.common.Constants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = Constants.TOPIC_NAME, groupId = Constants.KAFKA_CONSUMER_GROUP)
    public void listen(String message) {
        System.out.println("Received message in group - " + message);
    }
}
