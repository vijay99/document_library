package com.nac.service;

import com.nac.entity.Hello;
import com.nac.repo.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;

    public Hello saveHello(Hello hello) {
        return helloRepository.save(hello);
    }

    public Optional<Hello> getHelloById(long hello_id){
        return helloRepository.findById(hello_id);
    }
}
