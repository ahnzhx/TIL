package com.java.kafka.ch04;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class FirstAppConsumer {
    private static String topicName = "first-app";

    public static void main(String[] args) {
        //1. kafka consumer에 필요한 설정
        Properties conf = new Properties();
        conf.setProperty("bootstrap.servers", "kafka-broker01:9092,kafka-broker02:9092,kafka-broker03:9092");
        conf.setProperty("group.id", "FirstAppConsumerGroup");
        conf.setProperty("enable.auto.commit", "false"); // offset을 읽어온 위치를 저장한다. 원래 코드단에서 커밋을 해줘야 한다.
        conf.setProperty("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
        conf.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        //2. 카프카 클러스터에서 메시지를 수신(consume)하는 객체 생성
        Consumer<Integer, String> consumer = new KafkaConsumer<>(conf);

        //3. 구독(subscribe)하는 Topic 등록
        consumer.subscribe(Collections.singletonList(topicName));

        for (int count = 0 ; count < 300; count++){
            //4.메시지를 수신하여 콘솔에 표시
            ConsumerRecords<Integer, String> records = consumer.poll(1); // 하나씩 가져온다
            for(ConsumerRecord<Integer, String> record : records){
                String msgString = String.format("key: %d, value: %s", record.key(), record.value());
                System.out.println(msgString);

                // 5. 처리가 완료된 메시지의 오프셋을 커밋
                TopicPartition tp = new TopicPartition(record.topic(), record.partition());
                OffsetAndMetadata oam = new OffsetAndMetadata(record.offset() + 1);
                Map<TopicPartition, OffsetAndMetadata> commitInfo = Collections.singletonMap(tp, oam);
                consumer.commitSync(commitInfo);
            }

            try {
                Thread.sleep(1000);
            }catch (InterruptedException ex ){
                ex.printStackTrace();
            }
        }
        // 6. KafkaConsumer를 닫고 종료
        consumer.close();
    }
}
