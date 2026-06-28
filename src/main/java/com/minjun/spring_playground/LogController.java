package com.minjun.spring_playground;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
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
}