package com.minjun.spring_playground;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LogService {

  public List<LogResponse> getLogs() {
    return List.of(
        new LogResponse(1L, "Spring Boot 첫 실습", "Controller와 record를 배웠다.", "NERVOUS"),
        new LogResponse(2L, "인턴 첫 출근 준비", "Java 문법과 API 흐름을 복습했다.", "EXCITED"));
  }

  public LogResponse getLog(Long id) {
    if (id.equals(1L)) {

      return new LogResponse(1L, "Spring Boot 첫 실습", "Controller와 record를 배웠다.", "NERVOUS");
    }

    return new LogResponse(2L, "인턴 첫 출근 준비", "Java 문법과 API 흐름을 복습했다.", "EXCITED");
  }
}
