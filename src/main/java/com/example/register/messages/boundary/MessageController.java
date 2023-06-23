package com.example.register.messages.boundary;

import com.example.register.messages.entity.MessageDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@OpenAPIDefinition(
        info = @Info(title = "Register messages API",
                description = "Register messages Spring WebMvc",
                termsOfService = "Copyright - 2019",
                version = "0.0.1"
        ),
        tags = @Tag(name = "Register messages")
        // http://localhost:8080/swagger-ui.html
)
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Operation(tags = "Register messages", description = "View a list of available messages")
    @GetMapping(value = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MessageDto> getAll() {
        log.info("find all messages");
        return messageService.getAll();
    }

    @Operation(tags = "Register messages", description = "Create a message")
    @PostMapping(value = "/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDto create(@RequestBody MessageDto messageDto) {
        log.info("create message: {}", messageDto);
        return messageService.create(messageDto);
    }

    @Operation(tags = "Register messages", description = "Read a message")
    @GetMapping("/messages/{id}")
    public Optional<MessageDto> read(@PathVariable String id) {
        log.info("get message with id : {}", id);
        return messageService.read(id);
    }

    @Operation(tags = "Register messages", description = "Update a message")
    @PutMapping("/messages/{id}")
    public Optional<MessageDto> update(@RequestBody MessageDto messageDto, @PathVariable String id) {
        log.info("update message with id : {} and message : {}", id, messageDto);
        return messageService.update(messageDto, id);
    }

    @Operation(tags = "Register messages", description = "Delete a message")
    @DeleteMapping("/messages/{id}")
    public void delete(@PathVariable String id) {
        log.debug("delete message with id : {}", id);
        messageService.delete(id);
    }
}
