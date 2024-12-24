package org.vinio;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.vinio.grpc.QueueServiceGrpc;
import org.vinio.grpc.UpdateMessage;
import org.vinio.grpc.UserMessage;

import java.util.concurrent.TimeUnit;

public class QueueClient implements AutoCloseable {
    private final ManagedChannel channel;
    private final QueueServiceGrpc.QueueServiceBlockingStub blockingStub;

    public QueueClient(String host, int port) {
        this.channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
        this.blockingStub = QueueServiceGrpc.newBlockingStub(channel);
    }

    public UpdateMessage getAnalyze(String message) throws InvalidProtocolBufferException {
        UserMessage.Builder userMessageBuilder = UserMessage.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(message, userMessageBuilder);
        UserMessage userMessage = userMessageBuilder.build();
        System.out.println("\n3. Получите UserMessage из билдера\n" + userMessage);
        try {
            try {
                return blockingStub.analyzeText(userMessage);
            } catch (StatusRuntimeException e) {
                System.err.println("Failed: " + e.getStatus());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted while shutting down channel");
        }
    }


}