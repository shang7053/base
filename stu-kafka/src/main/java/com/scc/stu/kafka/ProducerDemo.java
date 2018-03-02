/**   
 *
 * @Title: KafkaProducerTest.java 
 * @Package com.scc.stu.kafka 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年3月15日 下午2:17:51   
 */
package com.scc.stu.kafka;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
		properties.put("bootstrap.servers", "172.16.40.4:9092");
		properties.put("acks", "1");
		properties.put("retries", 0);
		properties.put("batch.size", 16384);
		properties.put("linger.ms", 1);
		properties.put("max.request.size", 12695150);
		properties.put("buffer.memory", 33554432);
		properties.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
	}

	public void produce(byte[] data) {
		KafkaProducer<byte[], byte[]> kafkaProducer = new KafkaProducer<byte[], byte[]>(properties);
		ProducerRecord<byte[], byte[]> kafkaRecord = new ProducerRecord<byte[], byte[]>("test_kafka_message_size",
				data);
		kafkaProducer.send(kafkaRecord, new Callback() {
			@Override
			public void onCompletion(RecordMetadata metadata, Exception e) {
				if (null != e) {
					LOG.error(e.getMessage(), e);
					e.printStackTrace();
				} else {
					LOG.info("complete!");
				}
			}
		});
		// kafkaProducer.close();
	}

	public static void main(String[] args) throws InterruptedException {
		ProducerDemo kafkaProducerTest = new ProducerDemo();
		for (int j = 0; j < 50; j++) {
			kafkaProducerTest.produce(fileToBytes("/Users/shangchengcai/Pictures/QQ20180208-095400@2x.png"));
			// kafkaProducerTest.produce("sss".getBytes());
			Thread.sleep(1000L);

		}
	}

	public static byte[] fileToBytes(String filePath) {
		byte[] buffer = null;
		File file = new File(filePath);

		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;

		try {
			fis = new FileInputStream(file);
			bos = new ByteArrayOutputStream();

			byte[] b = new byte[1024];

			int n;

			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}

			buffer = bos.toByteArray();
		} catch (FileNotFoundException ex) {
			LOG.log(null, ex);
		} catch (IOException ex) {
			LOG.log(null, ex);
		} finally {
			try {
				if (null != bos) {
					bos.close();
				}
			} catch (IOException ex) {
				LOG.log(null, ex);
			} finally {
				try {
					if (null != fis) {
						fis.close();
					}
				} catch (IOException ex) {
					LOG.log(null, ex);
				}
			}
		}

		return buffer;
	}
}
