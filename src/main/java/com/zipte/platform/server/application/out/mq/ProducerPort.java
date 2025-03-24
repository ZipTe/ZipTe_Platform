package com.zipte.platform.server.application.out.mq;

public interface ProducerPort<T> {

    boolean send(String topic, T record);
}
