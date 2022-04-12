package com.study.register.controller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@JsonPropertyOrder({"id","is_active","first_name","last_name","document","email","cellphone","birthdate"})
public class CustomerResponse {

    private UUID id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String document;

    private String email;

    private String phone;

    private LocalDate birthdate;

    @JsonProperty("is_active")
    private Boolean isActive;

}
