package com.server.kafka.service.impl;

import com.server.kafka.service.KafkaAdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Slf4j
@Service
public class KafkaAdminServiceImpl implements KafkaAdminService {

    @Override
    public void createTopics(String bootstrapServers, List<String> topics) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", bootstrapServers);

        try (AdminClient adminClient = AdminClient.create(properties)) {
            topics.forEach(topic -> {
                adminClient.createTopics(List.of(new NewTopic(topic, 1, (short) 1)));
                log.info("topic: {} created", topic);
            });
        }
    }

}
