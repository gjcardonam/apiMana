package com.reposteria.mana.infrastructure.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
public class Health {

        @GetMapping("/health")
        public String health() {
            return "OK";
        }
}
