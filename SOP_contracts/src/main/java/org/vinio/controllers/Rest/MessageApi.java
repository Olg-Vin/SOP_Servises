package org.vinio.controllers.Rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vinio.dtos.request.AddMessageRequest;
import org.vinio.dtos.response.MessageResponse;
import org.vinio.exceptions.StatusResponse;

import java.util.List;

@Tag(name = "messages", description = "API для управления сообщениями")
@ApiResponses({
        @ApiResponse(
                responseCode = "400",
                description = "Ошибка валидации",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = StatusResponse.class)
                )
        ),
        @ApiResponse(
                responseCode = "200",
                description = "Успешная обработка запроса",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = StatusResponse.class)
                )
        ),
        @ApiResponse(
                responseCode = "404",
                description = "Ресурс не найден",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = StatusResponse.class)
                )
        ),
        @ApiResponse(
                responseCode = "409",
                description = "Конфликт. Совпадение.",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = StatusResponse.class)
                )
        ),
        @ApiResponse(
                responseCode = "500",
                description = "Внутренняя ошибка сервера",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = StatusResponse.class)
                )
        )
})
public interface MessageApi {
    @Operation(summary = "Получить сообщение по его ID")
    @GetMapping(value = "/messages/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<MessageResponse> getMessageById(@PathVariable("id") Long id);

    @Operation(summary = "Получить сообщение по ID ответа")
    @GetMapping(value = "/messages/reply/{replyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<MessageResponse> getMessageByReplyId(@PathVariable("replyId") Long id);

    @Operation(summary = "Получить список сообщений пользователя по ID пользователя")
    @GetMapping(value = "/messages/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CollectionModel<MessageResponse>> getMessagesByUserId(@PathVariable("userId") Long userId);

    @Operation(summary = "Создать новое сообщение")
    @PostMapping(value = "/messages/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<MessageResponse> createMessage(@RequestBody AddMessageRequest messageDTO);

    @Operation(summary = "Обновить сообщение")
    @PutMapping(value = "/messages/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<MessageResponse> updateMessage(@PathVariable("id") Long id, @RequestBody AddMessageRequest updatedMessage);

    @Operation(summary = "Удалить сообщение")
    @DeleteMapping(value = "/messages/delete/{id}")
    ResponseEntity<Void> deleteMessage(@PathVariable("id") Long id);
}
