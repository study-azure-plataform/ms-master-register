package com.study.register.controller;

import com.study.register.controller.data.CustomerRequest;
import com.study.register.controller.data.CustomerResponse;
import com.study.register.usecase.CustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/customer", produces =  MediaType.APPLICATION_JSON_VALUE )
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest request){

        CustomerResponse response = customerUseCase.create(request);
        return ResponseEntity.ok(response);
    }
}
