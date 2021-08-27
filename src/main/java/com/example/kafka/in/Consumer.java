package com.example.kafka.in;

import com.example.kafka.out.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class Consumer {

    @Autowired
    private Producer producer;

    @KafkaListener(id="al1", topics="al1")
    public void onMessage(ConsumerRecord<Object, Object> consumerRecord) throws IOException {
        log.info("consuming... {}", consumerRecord);
        producer.send(consumerRecord);
    }
}
