package com.server.kafka.configuration;

import com.server.kafka.server.KafkaServer;
import com.server.kafka.service.KafkaAdminService;
import com.server.kafka.utils.ConfigLoader;
import kafka.server.KafkaConfig;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class KafkaServerConf {

    private final KafkaAdminService kafkaAdminService;
    @Value("${kafka.config.file}")
    private String kafkaServerConfigFile;

    @Bean
    public KafkaServer kafkaServer() {
        return new KafkaServer(properties(), kafkaAdminService);
    }

    @SneakyThrows
    private KafkaConfig properties() {
        return new KafkaConfig(ConfigLoader.getConfig(kafkaServerConfigFile));
    }

}
