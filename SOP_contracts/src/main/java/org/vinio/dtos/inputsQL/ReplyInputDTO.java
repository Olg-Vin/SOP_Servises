package org.vinio.dtos.inputsQL;

public class ReplyInputDTO {
    private Long messageId;
    private String body;
    private String handler;

    public ReplyInputDTO() {
    }

    public ReplyInputDTO(Long messageId, String body, String handler) {
        this.messageId = messageId;
        this.body = body;
        this.handler = handler;
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
}