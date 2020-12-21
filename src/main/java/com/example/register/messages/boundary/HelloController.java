package com.example.register.messages.boundary;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@Api(value = "hello-world-message")
public class HelloController {

    @ApiOperation(value = "View hello world message")
    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getHelloWorld() {
        log.info("get hello world message");
        return "Hello world!";
    }
}
