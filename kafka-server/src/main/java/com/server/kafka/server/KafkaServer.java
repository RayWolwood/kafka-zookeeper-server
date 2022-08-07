package com.server.kafka.server;

import com.server.kafka.service.KafkaAdminService;
import kafka.server.KafkaConfig;
import kafka.server.KafkaServerStartable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class KafkaServer {

    private final KafkaConfig kafkaConfig;
    private final KafkaAdminService kafkaAdminService;

    @Value("${kafka.topics.name}")
    private List<String> topics;

    @PostConstruct
    private void init() {
        KafkaServerStartable kafka = new KafkaServerStartable(kafkaConfig);
        kafka.startup();
        log.info("Kafka broker started!!!");

        String bootstrapServers = kafkaConfig.getString("host.name") + ":" + kafkaConfig.getInt("port");
        kafkaAdminService.createTopics(bootstrapServers, topics);
    }

}
