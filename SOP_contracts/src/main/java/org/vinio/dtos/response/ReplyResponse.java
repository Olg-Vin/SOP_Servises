package org.vinio.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Schema(description = "Ответ, представляющий комментарий или ответ на сообщение")
public class ReplyResponse extends RepresentationModel<ReplyResponse> {
    @Schema(description = "Идентификатор ответа", example = "101")
    private Long replyId;
    @Schema(description = "Идентификатор сообщения, к которому относится этот ответ", example = "123")
    private Long messageId;
    @Schema(description = "Текст ответа", example = "Ваше сообщение было передано на обработку. Мы свяжемся с вами в ближайшее время.")
    private String body;
    @Schema(description = "Дата создания ответа", example = "2024-11-15T12:34:56.789Z")
    private Date createdAt;
    @Schema(description = "Имя пользователя или идентификатор, ответственного за обработку", example = "support_agent_01")
    private String handler;

    public ReplyResponse(Long replyId, Long messageId, String body, Date createdAt, String handler) {
        this.replyId = replyId;
        this.messageId = messageId;
        this.body = body;
        this.createdAt = createdAt;
        this.handler = handler;
    }

    public ReplyResponse() {
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    @Override
    public String toString() {
        return "ReplyResponse{" +
                "replyId=" + replyId +
                ", messageId=" + messageId +
                ", body='" + body + '\'' +
                ", createdAt=" + createdAt +
                ", handler='" + handler + '\'' +
                '}';
    }
}
