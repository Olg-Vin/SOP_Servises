package org.vinio.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Schema(description = "Ответ, представляющий сообщение, хранящееся в системе")
public class MessageResponse extends RepresentationModel<MessageResponse> {
    @Schema(description = "Идентификатор сообщения", example = "123")
    private Long messageId;
    @Schema(description = "Идентификатор пользователя, отправившего сообщение", example = "456")
    private Long userId;
    @Schema(description = "Категория сообщения (например, 'complaint', 'suggestion')", example = "complaint")
    private String category;
    @Schema(description = "Тема сообщения", example = "Ошибка в работе калькулятора")
    private String subject;
    @Schema(description = "Приоритет сообщения, используемый для обработки", example = "1")
    private int priority;
    @Schema(description = "Полный текст сообщения", example = "Калькулятор возвращает неверный результат для выражения 2+2.")
    private String body;
    @Schema(description = "Дата создания сообщения", example = "2024-11-15T12:34:56.789Z")
    private Date createdAt;
    @Schema(description = "Статус обработки сообщения (например, 'new', 'in progress', 'resolved')", example = "new")
    private String status;

    public MessageResponse(Long messageId, Long userId, String category, String subject, int priority,
                           String body, Date createdAt, String status) {
        this.messageId = messageId;
        this.userId = userId;
        this.category = category;
        this.subject = subject;
        this.priority = priority;
        this.body = body;
        this.createdAt = createdAt;
        this.status = status;
    }

    public MessageResponse() {
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "messageId=" + messageId +
                ", userId=" + userId +
                ", category='" + category + '\'' +
                ", subject='" + subject + '\'' +
                ", priority=" + priority +
                ", body='" + body + '\'' +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                '}';
    }
}
