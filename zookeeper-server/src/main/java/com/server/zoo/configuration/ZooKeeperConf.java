package com.server.zoo.configuration;

import com.server.zoo.server.ZooKeeperServer;
import com.server.zoo.utils.ConfigLoader;
import lombok.SneakyThrows;
import org.apache.zookeeper.server.ServerConfig;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZooKeeperConf {

    @Value("${zookeeper.config.file}")
    private String zookeeperConfigFile;

    @Bean
    public ZooKeeperServer zooKeeperServer() {
        return new ZooKeeperServer(properties());
    }

    @SneakyThrows
    private ServerConfig properties() {
        QuorumPeerConfig quorumConfiguration = new QuorumPeerConfig();
        quorumConfiguration.parseProperties(ConfigLoader.getConfig(zookeeperConfigFile));

        ServerConfig configuration = new ServerConfig();
        configuration.readFrom(quorumConfiguration);

        return configuration;
    }

}
