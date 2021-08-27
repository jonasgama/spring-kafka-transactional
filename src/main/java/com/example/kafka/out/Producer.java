package com.example.kafka.out;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Producer {

    @Autowired
    @Qualifier("myTemplate")
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public void send(ConsumerRecord<Object, Object> event)  {
        this.kafkaTemplate.executeInTransaction(template -> template.send("a2", event.value()));
    }
}
