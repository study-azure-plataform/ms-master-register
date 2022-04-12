package com.study.register.controller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerRequest {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String document;

    private String email;

    private String cellphone;

    private LocalDate birthdate;
}
