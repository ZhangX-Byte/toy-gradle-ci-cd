package com.toy.config;

import net.devh.boot.grpc.client.autoconfigure.GrpcClientAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;

/**
 * @author Zhang_Xiang
 * @since 2021/8/12 16:26:25
 */
@TestConfiguration
@ImportAutoConfiguration({
        GrpcServerAutoConfiguration.class, // Create required server beans
        GrpcServerFactoryAutoConfiguration.class, // Select server implementation
        GrpcClientAutoConfiguration.class}) // Support @GrpcClient annotation
public class IntegrationTestConfigurations {

}