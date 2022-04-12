package com.study.register.common.exceptions.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Builder
@JsonPropertyOrder({ "status_code", "timestamp", "messages", "message"  })
@JsonInclude(Include.NON_NULL)
public class ErrorMessageFieldsValid {

    @JsonProperty("status_code")
    private String statusCode;

    private LocalDateTime timestamp;

    private Collection<String> messages;

    private String message;

    private String description;

}
