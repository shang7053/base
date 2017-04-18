/**   
 *
 * @Title: ConsumerDemo.java 
 * @Package com.scc.stu.kafka 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年3月15日 下午2:50:09   
 */
package com.scc.stu.kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

/**
 *
 * @ClassName: ConsumerDemo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年3月15日 下午2:50:09
 * 
 */
public class ConsumerDemo {

    private static final String topic = "canal-t_canal";

    private static final Integer threads = 3;

    public static void main(String[] args) {

        Properties props = new Properties();

        props.put("zookeeper.connect", "hadoop-n:2181");

        props.put("group.id", "1111");

        props.put("auto.offset.reset", "smallest");

        ConsumerConfig config = new ConsumerConfig(props);

        ConsumerConnector consumer = Consumer.createJavaConsumerConnector(config);

        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();

        topicCountMap.put(topic, 1);

        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);

        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get("canal-t_canal");

        for (final KafkaStream<byte[], byte[]> kafkaStream : streams) {

            new Thread(new Runnable() {

                public void run() {

                    for (MessageAndMetadata<byte[], byte[]> mm : kafkaStream) {

                        String msg = new String(mm.message());

                        System.out.println(msg);

                    }

                }

            }).start();

        }

    }

}