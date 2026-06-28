package com.minjun.spring_playground;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

  private final LogService logService;

  public LogController(LogService logService) {
    this.logService = logService;
  }

  @GetMapping("/logs")
  public List<LogResponse> getLogs() {
    return logService.getLogs();
  }

  @GetMapping("/logs/{id}")
  public LogResponse getLog(@PathVariable Long id) {
    return logService.getLog(id);
  }

  @PostMapping("/logs")
  public LogResponse createLog(@RequestBody CreateLogRequest request) {
    return logService.createLog(request);
  }

  @PatchMapping("/logs/{id}")
  public LogResponse updateLog(@PathVariable Long id, @RequestBody UpdateLogRequest request) {
    return logService.updateLog(id, request);
  }

  @DeleteMapping("/logs/{id}")
  public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
    logService.deleteLog(id);
    return ResponseEntity.noContent().build();
  }
}
