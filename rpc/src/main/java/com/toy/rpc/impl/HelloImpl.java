package com.toy.rpc.impl;

import com.toy.proto.GreeterGrpc;
import com.toy.proto.HelloReply;
import com.toy.proto.HelloRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author Zhang_Xiang
 * @since 2021/8/20 15:35:56
 */
@GrpcService
public class HelloImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
