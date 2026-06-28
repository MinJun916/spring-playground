package com.minjun.spring_playground.controller;

import com.minjun.spring_playground.dto.HealthResponseDTO;
import com.minjun.spring_playground.dto.WelcomeResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/health")
  public HealthResponseDTO health() {
    return new HealthResponseDTO("OK", "Server is running");
  }

  @GetMapping("/intro")
  public WelcomeResponseDTO welcome() {
    return new WelcomeResponseDTO("Dev Log API", "인턴 개발자의 성장 기록", "v1");
  }
}
