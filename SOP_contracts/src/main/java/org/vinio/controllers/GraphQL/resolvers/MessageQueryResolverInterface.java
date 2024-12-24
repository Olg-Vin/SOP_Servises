package org.vinio.controllers.GraphQL.resolvers;

import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import jakarta.validation.constraints.NotNull;
import org.vinio.dtos.inputsQL.MessageInputDTO;
import org.vinio.dtos.response.MessageResponse;

/**
 * Интерфейс для резолвера сообщений в GraphQL.
 * Предназначен для работы с запросами и мутациями, связанными с сообщениями.
 */
public interface MessageQueryResolverInterface {

    /**
     * Получить сообщение по ID.
     *
     * @param id Идентификатор сообщения
     * @return MessageResponseDTO - DTO с данными сообщения
     */
    @DgsQuery
    MessageResponse getMessage(@InputArgument @NotNull Long id);

    /**
     * Создать новое сообщение.
     *
     * @param messageInputDTO Входные данные для создания сообщения
     * @return MessageResponseDTO - DTO с данными созданного сообщения
     */
    @DgsMutation
    MessageResponse createMessage(@InputArgument(name = "newMessage") @NotNull MessageInputDTO messageInputDTO);

    /**
     * Обновить сообщение по ID.
     *
     * @param id              Идентификатор сообщения, которое нужно обновить
     * @param messageInputDTO Входные данные для обновления сообщения
     * @return MessageResponseDTO - DTO с обновленными данными сообщения
     */
    @DgsMutation
    MessageResponse updateMessage(@InputArgument @NotNull Long id,
                                  @InputArgument(name = "updateMessage") @NotNull MessageInputDTO messageInputDTO);

    /**
     * Удалить сообщение по ID.
     *
     * @param id Идентификатор сообщения, которое нужно удалить
     * @return true, если сообщение было удалено, иначе false
     */
    @DgsMutation
    boolean deleteMessage(@InputArgument @NotNull Long id);
}
