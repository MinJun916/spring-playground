package com.minjun.spring_playground;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LogService {

  private final List<LogResponse> logs =
      new ArrayList<>(
          List.of(
              new LogResponse(1L, "Spring Boot 첫 실습", "Controller와 record를 배웠다.", "NERVOUS"),
              new LogResponse(2L, "인턴 첫 출근 준비", "Java 문법과 API 흐름을 복습했다.", "EXCITED")));

  public List<LogResponse> getLogs() {
    return logs;
  }

  public LogResponse getLog(Long id) {
    return logs.stream()
        .filter(log -> log.id().equals(id))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "log not found"));
  }

  public LogResponse createLog(CreateLogRequest request) {
    Long nextId = (long) logs.size() + 1;

    LogResponse newLog =
        new LogResponse(nextId, request.title(), request.content(), request.mood());

    logs.add(newLog);

    return newLog;
  }
}
