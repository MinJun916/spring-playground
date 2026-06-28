package com.minjun.spring_playground.repository;

import com.minjun.spring_playground.entity.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class LogRepository {

  private final List<Log> logs =
      new ArrayList<>(
          List.of(
              new Log(1L, "Spring Boot 첫 실습", "Controller와 record를 배웠다.", "NERVOUS"),
              new Log(2L, "인턴 첫 출근 준비", "Java 문법과 API 흐름을 복습했다.", "EXCITED")));

  public List<Log> findAll() {
    return logs;
  }

  public Optional<Log> findById(Long id) {
    return logs.stream().filter(log -> log.getId().equals(id)).findFirst();
  }

  public Log save(Log log) {
    logs.add(log);

    return log;
  }

  public void delete(Log log) {
    logs.remove(log);
  }

  public Long getNextId() {
    return (long) logs.size() + 1;
  }
}
