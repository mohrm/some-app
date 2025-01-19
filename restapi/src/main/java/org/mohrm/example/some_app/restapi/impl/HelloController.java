package org.mohrm.example.some_app.restapi.impl;

import org.mohrm.example.some_app.restapi.HelloApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloApi {

    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("\"hello\"");
    }
}
