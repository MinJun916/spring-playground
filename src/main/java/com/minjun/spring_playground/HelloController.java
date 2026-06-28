package com.minjun.spring_playground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/health")
  public HealthResponse health() {
    return new HealthResponse("OK", "Server is running");
  }

  @GetMapping("/intro")
  public WelcomeResponse welcome() {
    return new WelcomeResponse("Dev Log API", "인턴 개발자의 성장 기록", "v1");
  }
}
