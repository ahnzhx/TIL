package com.java.kafka.ch08;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class Pipe {
    public static void main(String[] args) {
        Properties props = new Properties();
        // APPLICATION_ID_CONFIG: unique identifier of your streams application to distinguish itself
        // with other applications talking to the same Kafka cluster
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-pipe");
        /*
         * BOOTSTRAP_SERVERS_CONFIG : specifies a list of host/port pairs to use
         * for establishing the initial connection to the Kafka cluster
         */
        // sonnie-kafka01 의 internalIP
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "10.128.0.12:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        /*
         * 다음으로 Streams 애플리케이션의 계산 논리를 정의합니다.
         * Kafka Streams 에서 계산 논리는 연결된 프로세서 노드의 토폴로지로 정의됩니다.
         */
        final StreamsBuilder builder = new StreamsBuilder();

        builder.stream("streams-plaintext-input").to("streams-pipe-output");

        final Topology topology = builder.build();
        System.out.println(topology.describe());

        final KafkaStreams streams = new KafkaStreams(topology, props);
        final CountDownLatch latch = new CountDownLatch(1);

        // ctrl+c 를 처리하기 위한 핸들러 추가
        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook"){
            @Override
            public void run() {
                streams.close();
                latch.countDown();
                System.out.println("topology terminated");
            }
        });

        try{
            streams.start();
            System.out.println("topology started");
            latch.await();
        }catch (Throwable e){
            System.exit(1);
        }

        System.exit(0);
    }
}
