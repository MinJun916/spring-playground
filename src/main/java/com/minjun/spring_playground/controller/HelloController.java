package com.minjun.spring_playground.controller;

import com.minjun.spring_playground.dto.HealthResponseDTO;
import com.minjun.spring_playground.dto.ResponseDTO;
import com.minjun.spring_playground.dto.WelcomeResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/health")
  public ResponseDTO<HealthResponseDTO> health() {
    HealthResponseDTO response = new HealthResponseDTO("OK", "Server is Running");

    return new ResponseDTO<>(true, "Health Check Complete", response);
  }

  @GetMapping("/intro")
  public ResponseDTO<WelcomeResponseDTO> welcome() {
    WelcomeResponseDTO response = new WelcomeResponseDTO("Dev Log API", "인턴 개발자의 성장 기록", "v1");

    return new ResponseDTO<>(true, "Get Intro Success", response);
  }
}
