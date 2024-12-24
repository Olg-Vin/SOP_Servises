package org.vinio.dtos.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddMessageRequest {
    @NotNull
    private Long userId;
    @Size(max = 1024, message = "Тема должна кратко описывать содержимое сообщения")
    private String subject;
    @NotNull
    @Size(max = 10_000, message = "Превышено количество символов для сообщения")
    private String body;

    public AddMessageRequest(@NotNull Long userId, String subject, @NotNull String body) {
        this.userId = userId;
        this.subject = subject;
        this.body = body;
    }

    public AddMessageRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "AddMessageRequest{" +
                "userId=" + userId +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
