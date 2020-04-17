package com.example.register.messages.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.io.Serializable;

@Value
public class MessageDto implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("text")
    private String text;
}
