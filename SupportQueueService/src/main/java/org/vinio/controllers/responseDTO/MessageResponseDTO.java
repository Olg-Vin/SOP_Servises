package org.vinio.controllers.responseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.Link;
import org.vinio.dtos.response.MessageResponse;

import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
public class MessageResponseDTO extends MessageResponse {
    @JsonProperty("_actions")
    private List<Link> actions = new ArrayList<>();

    public void addActions(Link... links) {
        actions.addAll(List.of(links));
    }

    public List<Link> getActions() {
        return actions;
    }
}