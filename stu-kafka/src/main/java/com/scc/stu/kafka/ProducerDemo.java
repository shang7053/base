/**   
 *
 * @Title: KafkaProducerTest.java 
 * @Package com.scc.stu.kafka 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年3月15日 下午2:17:51   
 */
package com.scc.stu.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;

/**
 *
 * @ClassName: KafkaProducerTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年3月15日 下午2:17:51
 * 
 */
public class ProducerDemo {

	private static final Logger LOG = Logger.getLogger(ProducerDemo.class);

	private static Properties properties = new Properties();

	static {
		properties.put("bootstrap.servers", "172.16.41.151:9092");
		properties.put("acks", "1");
		properties.put("retries", 0);
		properties.put("batch.size", 16384);
		properties.put("linger.ms", 1);
		properties.put("buffer.memory", 33554432);
		properties.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
	}

	public void produce(byte[] data) {
		KafkaProducer<byte[], byte[]> kafkaProducer = new KafkaProducer<byte[], byte[]>(properties);
		ProducerRecord<byte[], byte[]> kafkaRecord = new ProducerRecord<byte[], byte[]>("test-stop", data);
		kafkaProducer.send(kafkaRecord, new Callback() {
			@Override
			public void onCompletion(RecordMetadata metadata, Exception e) {
				if (null != e) {
					LOG.error(e.getMessage(), e);
					e.printStackTrace();
				}
				LOG.info("complete!");
			}
		});
		kafkaProducer.close();
	}

	public static void main(String[] args) {
		for (int j = 0; j < 100; j++) {
			new Thread(() -> {
				while (true) {
					final ProducerDemo kafkaProducerTest = new ProducerDemo();
					kafkaProducerTest.produce(String.valueOf(Math.random()).getBytes());
				}

			}).start();
		}
	}

}
