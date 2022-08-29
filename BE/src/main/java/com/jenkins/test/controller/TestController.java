package com.jenkins.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<String> testSpringServer() {
        return new ResponseEntity<>("정상적으로 실행중입니다.", HttpStatus.OK);
    }
}
