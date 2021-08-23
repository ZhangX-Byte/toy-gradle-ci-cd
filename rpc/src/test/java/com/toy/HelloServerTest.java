package com.toy;

import com.toy.config.IntegrationTestConfigurations;
import com.toy.proto.GreeterGrpc;
import com.toy.proto.HelloReply;
import com.toy.proto.HelloRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhang_Xiang
 * @since 2021/8/20 16:02:41
 */
@SpringBootTest(properties = {
        "grpc.server.inProcessName=test", // Enable inProcess server
        "grpc.server.port=-1", // Disable external server
        "grpc.client.inProcess.address=in-process:test" // Configure the client to connect to the inProcess server
})
@SpringJUnitConfig(classes = {IntegrationTestConfigurations.class})
@DirtiesContext
public class HelloServerTest {

    @GrpcClient("inProcess")
    private GreeterGrpc.GreeterBlockingStub blockingStub;

    @Test
    @DirtiesContext
    public void sayHello_replyMessage() {
        HelloReply reply = blockingStub.sayHello(HelloRequest.newBuilder().setName("Zhang").build());
        assertEquals("Hello Zhang", reply.getMessage());
    }
}
