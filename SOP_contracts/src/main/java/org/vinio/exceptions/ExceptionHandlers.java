package org.vinio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    private static final String ERROR_STATUS = "error";

    /**
     * Обработчик для исключений InvalidArgumentException.
     *
     * @param e экземпляр исключения InvalidArgumentException.
     * @return стандартизированный ответ с HTTP-статусом BAD_REQUEST (400).
     */
    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<StatusResponse> handleBadRequestException(InvalidArgumentException e) {
        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Переданны неверные данные: " + e.getMessage()
        );
    }

    /**
     * Обработчик для исключений валидации (MethodArgumentNotValidException).
     *
     * @param ex исключение, содержащее ошибки валидации.
     * @return стандартизированный ответ с HTTP-статусом BAD_REQUEST (400).
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StatusResponse> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .findFirst()
                .orElse("Ошибка валидации");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new StatusResponse("error", "Ошибка валидации: " + errorMessage));
    }

    /**
     * Обработчик для исключений RecordNotFoundException.
     *
     * @param e экземпляр исключения RecordNotFoundException.
     * @return стандартизированный ответ с HTTP-статусом NOT_FOUND (404).
     */
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<StatusResponse> handleRecordNotFoundException(RecordNotFoundException e) {
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                "Запись в базе данных не найдена: " + e.getMessage()
        );
    }

    /**
     * Обработчик для всех остальных исключений.
     *
     * @param e экземпляр исключения Exception.
     * @return стандартизированный ответ с HTTP-статусом INTERNAL_SERVER_ERROR (500).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StatusResponse> handleGlobalException(Exception e) {
        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Внутренняя ошибка сервера: " + e.getMessage()
        );
    }

    /**
     * Обработчик для исключений ConflictException.
     *
     * @param e экземпляр исключения RecordNotFoundException.
     * @return стандартизированный ответ с HTTP-статусом CONFLICT (409).
     */
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<StatusResponse> handleConflictException(ConflictException e) {
        return buildErrorResponse(
                HttpStatus.CONFLICT,
                "Такой ресурс уже есть: " + e.getMessage()
        );
    }

    /**
     * Утилитный метод для построения ответа об ошибке.
     *
     * @param status  HTTP-статус.
     * @param message Сообщение об ошибке.
     * @return Сформированный ResponseEntity.
     */
    private ResponseEntity<StatusResponse> buildErrorResponse(HttpStatus status, String message) {
        return ResponseEntity
                .status(status)
                .body(new StatusResponse(ERROR_STATUS, message));
    }
}
