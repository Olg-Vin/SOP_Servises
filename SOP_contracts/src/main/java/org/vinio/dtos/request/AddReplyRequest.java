package org.vinio.dtos.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddReplyRequest {
    @NotNull(message = "Необходимо указать для какого сообщения написан ответ")
    private Long messageId;
    @NotNull(message = "Ответ не должен быть пустым, иначе какой смысл")
    @Size(max = 10_000, message = "Превышено количество символов для ответа")
    private String body;
    @NotNull(message = "Укажите id ответственного сотрудника")
    private String handler;

    public AddReplyRequest(Long messageId, String body, String handler) {
        this.messageId = messageId;
        this.body = body;
        this.handler = handler;
    }

    public AddReplyRequest() {
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    @Override
    public String toString() {
        return "AddReplyRequest{" +
                "messageId=" + messageId +
                ", body='" + body + '\'' +
                ", handler='" + handler + '\'' +
                '}';
    }
}
