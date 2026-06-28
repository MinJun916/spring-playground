package com.minjun.spring_playground.service;

import com.minjun.spring_playground.dto.CreateLogRequest;
import com.minjun.spring_playground.dto.LogResponse;
import com.minjun.spring_playground.dto.UpdateLogRequest;
import com.minjun.spring_playground.entity.Log;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LogService {

  private final List<Log> logs =
      new ArrayList<>(
          List.of(
              new Log(1L, "Spring Boot 첫 실습", "Controller와 record를 배웠다.", "NERVOUS"),
              new Log(2L, "인턴 첫 출근 준비", "Java 문법과 API 흐름을 복습했다.", "EXCITED")));

  public List<LogResponse> getLogs() {
    return logs.stream()
        .map(log -> new LogResponse(log.getId(), log.getTitle(), log.getContent(), log.getMood()))
        .toList();
  }

  public LogResponse getLog(Long id) {
    Log log = findLogById(id);

    return new LogResponse(log.getId(), log.getTitle(), log.getContent(), log.getMood());
  }

  public LogResponse createLog(CreateLogRequest request) {
    Long nextId = (long) logs.size() + 1;

    Log newLog = new Log(nextId, request.title(), request.content(), request.mood());

    logs.add(newLog);

    return new LogResponse(
        newLog.getId(), newLog.getTitle(), newLog.getContent(), newLog.getMood());
  }

  public LogResponse updateLog(Long id, UpdateLogRequest request) {
    Log log = findLogById(id);

    log.update(request.title(), request.content(), request.mood());

    return new LogResponse(log.getId(), log.getTitle(), log.getContent(), log.getMood());
  }

  public void deleteLog(Long id) {
    boolean removed = logs.removeIf(log -> log.getId().equals(id));

    if (!removed) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Log not found");
    }
  }

  private Log findLogById(Long id) {
    return logs.stream()
        .filter(log -> log.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Log Not Found"));
  }
}
