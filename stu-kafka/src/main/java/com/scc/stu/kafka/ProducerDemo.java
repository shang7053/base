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

    private static Properties properties = null;

    static {
        properties = new Properties();
        properties.put("bootstrap.servers", "hadoop-d1:9092");
        properties.put("producer.type", "sync");
        properties.put("request.required.acks", "1");
        properties.put("serializer.class", "kafka.serializer.DefaultEncoder");
        properties.put("partitioner.class", "kafka.producer.DefaultPartitioner");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        // properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        // properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    }

    public void produce() {
        KafkaProducer<byte[], byte[]> kafkaProducer = new KafkaProducer<byte[], byte[]>(properties);
        ProducerRecord<byte[], byte[]> kafkaRecord = new ProducerRecord<byte[], byte[]>("test", "kkk".getBytes(),
                "ssss".getBytes());
        kafkaProducer.send(kafkaRecord, new Callback() {
            public void onCompletion(RecordMetadata metadata, Exception e) {
                if (null != e) {
                    LOG.info("the offset of the send record is {" + metadata.offset() + "}");
                    LOG.error(e.getMessage(), e);
                }
                LOG.info("complete!");
            }
        });
        kafkaProducer.close();
    }

    public static void main(String[] args) {
        ProducerDemo kafkaProducerTest = new ProducerDemo();
        for (int i = 0; i < 10; i++) {
            kafkaProducerTest.produce();
        }
    }

}
