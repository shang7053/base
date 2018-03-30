/**   
 *
 * @Title: ConsumerDemo.java 
 * @Package com.scc.stu.kafka 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年3月15日 下午2:50:09   
 */
package com.scc.stu.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;

/**
 *
 * @ClassName: ConsumerDemo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年3月15日 下午2:50:09
 * 
 */
public class ConsumerDemo2 {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "119.90.32.181:9092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "thirdCDN");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
		props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, "10485760");
		props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");// 一次只取1条
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);

		Consumer<byte[], byte[]> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("119_90_32_181_9092-voole_vrm-vrm_sp_authorlist_20151019_mp4"));
		ConsumerRecords<byte[], byte[]> records = consumer.poll(1);

		while (true) {
			consumer.subscribe(Arrays.asList("119_90_32_181_9092-voole_vrm-vrm_sp_authorlist_20151019_mp4"));
			records = consumer.poll(1000);
			for (ConsumerRecord<byte[], byte[]> record : records) {
				// System.out.printf("offset = %d", record.offset());
				// System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(),
				// record.value());
				System.out.println(new String(record.value()));
			}
		}
	}
}
