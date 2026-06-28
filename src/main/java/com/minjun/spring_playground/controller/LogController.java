package com.minjun.spring_playground.controller;

import com.minjun.spring_playground.dto.LogCreateRequestDTO;
import com.minjun.spring_playground.dto.LogResponseDTO;
import com.minjun.spring_playground.dto.LogUpdateRequestDTO;
import com.minjun.spring_playground.dto.ResponseDTO;
import com.minjun.spring_playground.service.LogService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class LogController {

  private final LogService logService;

  public LogController(LogService logService) {
    this.logService = logService;
  }

  // @GetMapping
  // public List<LogResponseDTO> getLogs() {
  //   return logService.getLogs();
  // }

  @GetMapping
  public ResponseEntity<ResponseDTO<List<LogResponseDTO>>> getLogs() {
    List<LogResponseDTO> response = logService.getLogs();

    return ResponseEntity.ok(new ResponseDTO<>(true, "GET Success!", response));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseDTO<LogResponseDTO>> getLog(@PathVariable Long id) {
    LogResponseDTO response = logService.getLog(id);

    return ResponseEntity.ok(new ResponseDTO<>(true, "GET Success!", response));
  }

  // @PostMapping
  // public LogResponse createLog(@RequestBody CreateLogRequest request) {
  //   return logService.createLog(request);
  // }

  @PostMapping
  public ResponseEntity<ResponseDTO<LogResponseDTO>> createLog(
      @Valid @RequestBody LogCreateRequestDTO request) {
    LogResponseDTO response = logService.createLog(request);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDTO<>(true, "POST Success!", response));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ResponseDTO<LogResponseDTO>> updateLog(
      @PathVariable Long id, @Valid @RequestBody LogUpdateRequestDTO request) {
    LogResponseDTO response = logService.updateLog(id, request);

    return ResponseEntity.ok(new ResponseDTO<>(true, "PATCH Success!", response));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseDTO<Void>> deleteLog(@PathVariable Long id) {
    logService.deleteLog(id);

    return ResponseEntity.ok(new ResponseDTO<>(true, "DELETE Success!", null));
  }
}
