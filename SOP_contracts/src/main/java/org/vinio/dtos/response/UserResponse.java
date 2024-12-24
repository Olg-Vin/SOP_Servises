package org.vinio.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.RepresentationModel;

@Schema(description = "Ответ, представляющий информацию о пользователе")
public class UserResponse extends RepresentationModel<UserResponse> {

    @Schema(description = "Идентификатор пользователя", example = "456")
    private Long userId;

    @Schema(description = "Имя пользователя", example = "John Doe")
    private String name;

    @Schema(description = "Электронная почта пользователя", example = "johndoe@example.com")
    private String email;

    public UserResponse() {
    }

    public UserResponse(Long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
