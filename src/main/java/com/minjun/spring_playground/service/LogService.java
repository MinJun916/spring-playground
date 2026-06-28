package com.minjun.spring_playground.service;

import com.minjun.spring_playground.dto.LogCreateRequestDTO;
import com.minjun.spring_playground.dto.LogResponseDTO;
import com.minjun.spring_playground.dto.LogUpdateRequestDTO;
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

  public List<LogResponseDTO> getLogs() {
    return logRepository.findAll().stream().map(log -> LogResponseDTO.from(log)).toList();
  }

  public LogResponseDTO getLog(Long id) {
    Log log = findLogById(id);

    return LogResponseDTO.from(log);
  }

  public LogResponseDTO createLog(LogCreateRequestDTO request) {
    Log newLog = new Log(request.title(), request.content(), request.mood());

    Log savedLog = logRepository.save(newLog);

    return LogResponseDTO.from(savedLog);
  }

  public LogResponseDTO updateLog(Long id, LogUpdateRequestDTO request) {
    Log log = findLogById(id);

    log.update(request.title(), request.content(), request.mood());

    return LogResponseDTO.from(log);
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
