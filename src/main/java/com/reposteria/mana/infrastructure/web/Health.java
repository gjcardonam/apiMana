package com.reposteria.mana.infrastructure.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://reposteriamana.onrender.com", allowCredentials = "true", maxAge = 3600)
@RestController
public class Health {

        @GetMapping("/health")
        public String health() {
            return "OK";
        }
}
