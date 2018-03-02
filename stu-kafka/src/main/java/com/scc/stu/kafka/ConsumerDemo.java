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

	private static final String topic = "test_kafka_message_size";

	public static void main(String[] args) {

		Properties props = new Properties();

		props.put("zookeeper.connect", "172.16.40.5:2181");

		props.put("group.id", "flume2");

		props.put("zookeeper.session.timeout.ms", "40000");
		props.put("zookeeper.sync.time.ms", "200");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");

		ConsumerConfig config = new ConsumerConfig(props);

		ConsumerConnector consumer = Consumer.createJavaConsumerConnector(config);

		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();

		topicCountMap.put(topic, 1);

		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);

		List<KafkaStream<byte[], byte[]>> streams = consumerMap.get("test_kafka_message_size");

		for (final KafkaStream<byte[], byte[]> kafkaStream : streams) {

			new Thread(new Runnable() {

				@Override
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
