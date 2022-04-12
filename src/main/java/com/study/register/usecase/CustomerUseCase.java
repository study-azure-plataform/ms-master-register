package com.study.register.usecase;

import com.study.register.controller.data.CustomerRequest;
import com.study.register.controller.data.CustomerResponse;
import com.study.register.gateway.db.CustomerGateway;
import com.study.register.usecase.data.CustomerDataUseCase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerUseCase {

    private final ModelMapper modelMapper;

    private final CustomerGateway gateway;

    public CustomerResponse create(CustomerRequest request) {
        CustomerDataUseCase useCase = gateway.create(modelMapper.map(request, CustomerDataUseCase.class));
        return modelMapper.map(useCase, CustomerResponse.class);
    }
}
