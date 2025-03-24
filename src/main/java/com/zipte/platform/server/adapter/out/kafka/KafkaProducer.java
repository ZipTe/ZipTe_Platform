package com.zipte.platform.server.adapter.out.kafka;

import com.zipte.platform.server.application.out.mq.ProducerPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer<T> implements ProducerPort<T> {

    private final KafkaTemplate<String, T> kafkaTemplate;

    @Override
    public boolean send(String topic, T record) {
        try {
            kafkaTemplate.send(topic, record);
            log.info("카프카 메시지 전송 완료! topic={}, data={}", topic, record);
            return true;
        } catch (Exception e) {
            log.error("[KafkaProducer] 메세지 전송에 실패했습니다: {}", e.getMessage());

            return false;
        }
    }

}
