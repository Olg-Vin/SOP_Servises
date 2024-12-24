package org.vinio.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Класс для формирования стандартизированных ответов на ошибки.
 */
@Schema(description = "Стандартизированный ответ для ошибок")
public class StatusResponse {

    @Schema(description = "Статус ответа", example = "error")
    private String status;

    @Schema(description = "Сообщение об ошибке", example = "какая-то проблемка")
    private String message;

    public StatusResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters и Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
