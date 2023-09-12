package zuhaprogrammer.spring.core.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zuhaprogrammer.spring.core.repository.CustomerRepository;

@Component
public class CustomerService {
    @Getter
    @Autowired
    private CustomerRepository customerRepository;
}
