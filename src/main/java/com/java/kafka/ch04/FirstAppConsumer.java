package com.java.kafka.ch04;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class FirstAppConsumer {

    public static void main(String[] args) {
        //1. kafka consumer에 필요한 설정
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "10.128.0.8:9092,10.128.0.12:9092,10.128.0.13:9092");
        props.setProperty("group.id", "sonnie-consumer");
        props.setProperty("enable.auto.commit", "true"); // offset을 읽어온 위치를 저장한다. 원래 코드단에서 커밋을 해줘야 한다.
        props.setProperty("auto.offset.reset", "latest");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        //2. 카프카 클러스터에서 메시지를 수신(consume)하는 객체 생성
        Consumer<String, String> consumer = new KafkaConsumer<>(props);

        //3. 구독(subscribe)하는 Topic 등록
        consumer.subscribe(Arrays.asList("sonnie-topic"));

            try {
                while(true){
                    ConsumerRecords<String, String> records = consumer.poll(100);
                    for (ConsumerRecord<String, String> record : records){
                        System.out.printf("Topic: %s, Partition: %, Offset:%d, Key:%s, Value: %s\n",
                                record.topic(), record.partition(), record.offset(), record.key(), record.value());
                    }
                }
            }finally {
                // 6. KafkaConsumer를 닫고 종료
                consumer.close();
            }

    }
}
