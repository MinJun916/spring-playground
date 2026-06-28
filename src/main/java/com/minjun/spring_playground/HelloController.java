package com.minjun.spring_playground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/health")
  public HealthResponse health() {
    return new HealthResponse("OK", "Server is running");
  }
}
