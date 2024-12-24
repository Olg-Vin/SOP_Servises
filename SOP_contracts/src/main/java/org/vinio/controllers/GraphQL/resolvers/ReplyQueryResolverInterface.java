package org.vinio.controllers.GraphQL.resolvers;

import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import jakarta.validation.constraints.NotNull;
import org.vinio.dtos.inputsQL.ReplyInputDTO;
import org.vinio.dtos.response.ReplyResponse;

/**
 * Интерфейс для резолвера ответов в GraphQL.
 * Предназначен для работы с запросами и мутациями, связанными с ответами на сообщения.
 */
public interface ReplyQueryResolverInterface {

    /**
     * Получить ответ по ID сообщения.
     *
     * @param id Идентификатор сообщения, для которого нужно получить ответ
     * @return ReplyResponseDTO - DTO с данными ответа
     */
    @DgsQuery
    ReplyResponse getReply(@InputArgument @NotNull Long id);

    /**
     * Создать новый ответ на сообщение.
     *
     * @param replyInputDTO Входные данные для создания ответа
     * @return ReplyResponseDTO - DTO с данными созданного ответа
     */
    @DgsMutation
    ReplyResponse createReply(@InputArgument(name = "newReply") @NotNull ReplyInputDTO replyInputDTO);

    /**
     * Обновить ответ по ID.
     *
     * @param id            Идентификатор ответа, который нужно обновить
     * @param replyInputDTO Входные данные для обновления ответа
     * @return ReplyResponseDTO - DTO с обновленными данными ответа
     */
    @DgsMutation
    ReplyResponse updateReply(@InputArgument @NotNull Long id,
                              @InputArgument(name = "newReply") @NotNull ReplyInputDTO replyInputDTO);

    /**
     * Удалить ответ по ID. From Resolver
     *
     * @param id Идентификатор ответа, который нужно удалить
     * @return true, если ответ был удален, иначе false
     */
    @DgsMutation
    boolean deleteReply(@InputArgument @NotNull Long id);
}
