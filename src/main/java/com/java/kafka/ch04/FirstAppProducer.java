package com.java.kafka.ch04;



import org.apache.kafka.clients.producer.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.Properties;

public class FirstAppProducer {
    private static String topicName = "first-app";

    public static void main(String[] args) {
        //1. KafkaProducer에 필요한 설정
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "10.128.0.8:9092,10.128.0.12:9092,10.128.0.13:9092");
        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //2. 카프카 클러스터에 메시지를 송신(produce)하는 객체 생성
        Producer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<String, String>("sonnie-topic", "say hello to sonnie's first apache kafka"));
        //5. KafkaProducer를 닫고 종료
        producer.close();
    }

}
