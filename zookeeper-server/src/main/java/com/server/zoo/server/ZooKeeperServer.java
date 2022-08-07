package com.server.zoo.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.server.ServerConfig;
import org.apache.zookeeper.server.ZooKeeperServerMain;

import java.io.IOException;

@Slf4j
public class ZooKeeperServer {

    public ZooKeeperServer(ServerConfig configuration) {
        try {
            ZooKeeperServerMain zooKeeper = new ZooKeeperServerMain();
            zooKeeper.runFromConfig(configuration);
        } catch (IOException e) {
            log.error("Zookeeper start failed, with exception {}", e.getMessage());
            e.printStackTrace();
        }
        log.info("ZooKeeper started");
    }

}
