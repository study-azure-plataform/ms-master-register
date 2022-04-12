package com.study.register.controller.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class CustomerRequest {

    @NotEmpty(message = "first_name cannot be null or empty.")
    @JsonProperty("first_name")
    private String firstName;

    @NotEmpty(message = "last_name cannot be null or empty.")
    @JsonProperty("last_name")
    private String lastName;

    @NotEmpty(message = "document cannot be null or empty.")
    private String document;

    @Email(message = "email should be valid")
    @NotEmpty(message = "email cannot be null or empty")
    private String email;

    @NotEmpty(message = "phone cannot be null or empty")
    @Min(11)
    private String phone;

    @Past(message = "birthdate cannot be value present or future")
    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull(message = "birthdate cannot be null or empty")
    private LocalDate birthdate;
}
