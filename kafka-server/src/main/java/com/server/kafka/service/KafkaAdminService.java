package com.server.kafka.service;

import java.util.List;

public interface KafkaAdminService {
    void createTopics(String bootstrapServers, List<String> topics);
}
