package org.vinio.dtos.inputsQL;

public class MessageInputDTO {
    private Long userId;
    private String body;
    private String subject;

    public MessageInputDTO() {
    }

    public MessageInputDTO(Long userId, String body, String subject) {
        this.userId = userId;
        this.body = body;
        this.subject = subject;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}