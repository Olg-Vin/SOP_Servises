package org.vinio.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddUserRequest {
    @NotNull(message = "Имя не может быть пустым")
    @Size(max = 50, message = "Имя не должно быть длиннее 50 символов")
    private String name;
    @NotNull(message = "Email не может быть пустым")
    @Email(message = "Проверьте правильность введённого email")
    private String email;

    public AddUserRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public AddUserRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AddUserRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
