package org.vinio;

import io.grpc.stub.StreamObserver;
import org.vinio.grpc.QueueServiceGrpc;
import org.vinio.grpc.UpdateMessage;
import org.vinio.grpc.UserMessage;

public class QueueService extends QueueServiceGrpc.QueueServiceImplBase {
    public QueueService() {
    }

    @Override
    public void analyzeText(UserMessage request, StreamObserver<UpdateMessage> responseObserver) {
        if (request.getBody().isBlank()) {
            responseObserver.onError(new Throwable("message body is blank!"));
        }
        System.out.println("Получено сообщение:\n" + request);
        UpdateMessage.Builder updateMessage = UpdateMessage.newBuilder();
        updateMessage.setMessageId(request.getMessageId());
        updateMessage.setCategory("It is spam may be");
        updateMessage.setPriority(1);
        updateMessage.setSubject("SuperLongSubject" + request.getBody());
        System.out.println("Анализ:\n" + updateMessage);
        responseObserver.onNext(updateMessage.build());
        responseObserver.onCompleted();
    }
}
