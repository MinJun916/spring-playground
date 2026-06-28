package com.minjun.spring_playground.service;

import com.minjun.spring_playground.dto.CreateLogRequest;
import com.minjun.spring_playground.dto.LogResponse;
import com.minjun.spring_playground.dto.UpdateLogRequest;
import com.minjun.spring_playground.entity.Log;
import com.minjun.spring_playground.repository.LogRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LogService {

  private final LogRepository logRepository;

  public LogService(LogRepository logRepository) {
    this.logRepository = logRepository;
  }

  public List<LogResponse> getLogs() {
    return logRepository.findAll().stream()
        .map(log -> new LogResponse(log.getId(), log.getTitle(), log.getContent(), log.getMood()))
        .toList();
  }

  public LogResponse getLog(Long id) {
    Log log = findLogById(id);

    return new LogResponse(log.getId(), log.getTitle(), log.getContent(), log.getMood());
  }

  public LogResponse createLog(CreateLogRequest request) {
    Long nextId = logRepository.getNextId();

    Log newLog = new Log(nextId, request.title(), request.content(), request.mood());

    Log savedLog = logRepository.save(newLog);

    return new LogResponse(
        savedLog.getId(), savedLog.getTitle(), savedLog.getContent(), savedLog.getMood());
  }

  public LogResponse updateLog(Long id, UpdateLogRequest request) {
    Log log = findLogById(id);

    log.update(request.title(), request.content(), request.mood());

    return new LogResponse(log.getId(), log.getTitle(), log.getContent(), log.getMood());
  }

  public void deleteLog(Long id) {
    Log log = findLogById(id);

    logRepository.delete(log);
  }

  private Log findLogById(Long id) {
    return logRepository
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Log Not Found"));
  }
}
