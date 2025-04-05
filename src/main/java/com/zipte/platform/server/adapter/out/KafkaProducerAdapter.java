package com.zipte.platform.server.adapter.out;

import com.zipte.platform.server.application.out.mq.ProducerPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerAdapter<T> implements ProducerPort<T> {

    /*
        현재는 제네릭으로 처리하지만,
        문제가 생긴다면, 개별로 만들어도 될 것 같다.
     */

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
