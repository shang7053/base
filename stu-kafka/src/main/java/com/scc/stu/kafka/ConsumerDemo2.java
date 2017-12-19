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
import org.apache.kafka.common.serialization.StringDeserializer;

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
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.16.40.4:9092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "flume");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

		Consumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("log_data_sync_base"));
		ConsumerRecords<String, String> records = consumer.poll(1);

		while (true) {
			consumer.subscribe(Arrays.asList("log_data_sync_base", "log_data_sync_base2"));
			records = consumer.poll(1);
			for (ConsumerRecord<String, String> record : records) {
				// System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(),
				// record.value());
				System.out.println(record.value());
			}
		}
	}
}
