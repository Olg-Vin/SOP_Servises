package org.vinio.controllers.GraphQL.resolvers;

import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import jakarta.validation.constraints.NotNull;
import org.vinio.dtos.inputsQL.UserInputDTO;
import org.vinio.dtos.response.UserResponse;

import java.util.List;

/**
 * Интерфейс для резолвера пользователей в GraphQL.
 * Предназначен для работы с запросами и мутациями, связанными с пользователями.
 */
public interface UserQueryResolverInterface {

    /**
     * Получить пользователя по ID.
     *
     * @param id Идентификатор пользователя
     * @return UserResponseDTO - DTO с данными пользователя
     */
    @DgsQuery
    UserResponse getUser(@InputArgument @NotNull Long id);

    /**
     * Получить список всех пользователей.
     *
     * @return Список DTO с данными всех пользователей
     */
    @DgsQuery
    List<UserResponse> getUsers();

    /**
     * Создать нового пользователя.
     *
     * @param userInputDTO Входные данные для создания пользователя
     * @return UserResponseDTO - DTO с данными созданного пользователя
     */
    @DgsMutation
    UserResponse createUser(@InputArgument(name = "newUser") @NotNull UserInputDTO userInputDTO);

    /**
     * Обновить данные пользователя по ID.
     *
     * @param id           Идентификатор пользователя, которого нужно обновить
     * @param userInputDTO Входные данные для обновления пользователя
     * @return UserResponseDTO - DTO с обновленными данными пользователя
     */
    @DgsMutation
    UserResponse updateUser(@InputArgument @NotNull Long id,
                            @InputArgument(name = "update") @NotNull UserInputDTO userInputDTO);

    /**
     * Удалить пользователя по ID.
     *
     * @param id Идентификатор пользователя, которого нужно удалить
     * @return true, если пользователь был удален, иначе false
     */
    @DgsMutation
    boolean deleteUser(@InputArgument @NotNull Long id);
}
