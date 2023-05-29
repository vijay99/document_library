package com.nac.controller;

import com.nac.entity.Hello;
import com.nac.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Optional;

@RequestMapping("/hello")
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/test")
    public String test() {
        return "This is for testing";
    }

    @PostMapping("/create")
    public ResponseEntity<Hello> createHello(@RequestBody Hello hello) {
        Hello helloResponse = helloService.saveHello(hello);
        return ResponseEntity.ok(helloResponse);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Hello> getHello(@PathVariable(name = "id") long hello_id) {
        Optional<Hello> HelloResponse = helloService.getHelloById(hello_id);
        Hello helloRes = HelloResponse.get();
        return ResponseEntity.ok(helloRes);
    }
}
