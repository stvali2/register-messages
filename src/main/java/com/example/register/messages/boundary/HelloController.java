package com.example.register.messages.boundary;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@OpenAPIDefinition(
        info = @Info(title = "Hello World API",
                description = "Register messages",
                termsOfService = "Copyright - 2019",
                version = "0.0.1"
        ),
        tags = @Tag(name = "Hello world message")
)
public class HelloController {

    @Operation(tags = "Hello world message", description = "View hello world message")
    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getHelloWorld() {
        log.info("get hello world message");
        return "Hello world!";
    }
}
