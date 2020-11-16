package com.example.register.messages.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.io.Serializable;

@Value
public class MessageDto implements Serializable {

    @JsonProperty("id")
    String id;

    @JsonProperty("text")
    String text;
}
