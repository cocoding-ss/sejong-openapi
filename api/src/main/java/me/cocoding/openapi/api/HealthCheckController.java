package me.cocoding.openapi.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "Healthy!!";
    }
}
