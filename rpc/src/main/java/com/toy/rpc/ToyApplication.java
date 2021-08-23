package com.toy.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Zhang_Xiang
 * @since 2021/8/20 15:34:58
 */
@SpringBootApplication(scanBasePackages = {"com.toy.*"})
public class ToyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToyApplication.class, args);
    }
}