package com.example.mproject;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 不配置数据库时增加 exclude= {DataSourceAutoConfiguration.class}
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableJms //开启支持jms
public class MprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(MprojectApplication.class, args);
    }

}
