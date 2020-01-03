package com.southwind;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 *
 */
@SpringBootApplication //声明该类是springboot服务人口
@EnableEurekaServer    //声明该类是一个eureka Serve微服务，提供服务注册和服务发现，即注册中心
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }

}
