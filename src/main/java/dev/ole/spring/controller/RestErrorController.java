package dev.ole.spring.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class RestErrorController implements ErrorController {

    @GetMapping
    public ResponseEntity<String> handleError() {
        return ResponseEntity.status(404).build();
    }

    public String getErrorPath() {
        return "/error";
    }

}
