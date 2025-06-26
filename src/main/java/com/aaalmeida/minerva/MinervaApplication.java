package com.aaalmeida.minerva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@SpringBootApplication
public class MinervaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinervaApplication.class, args);
    }

    //    TODO: remover depois
    @GetMapping("/hello")
    public String hello() {
        LocalDateTime l = LocalDateTime.now();
        return "1-----------" + l.toString();
    }

    @GetMapping("/h1")
    public String h1() {
        return "1";
    }
}
