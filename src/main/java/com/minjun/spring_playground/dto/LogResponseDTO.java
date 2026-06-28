package com.minjun.spring_playground.dto;

import com.minjun.spring_playground.entity.Log;
import com.minjun.spring_playground.enums.Mood;
import java.time.LocalDateTime;

public record LogResponseDTO(
    Long id,
    String title,
    String content,
    Mood mood,
    LocalDateTime createdAt,
    LocalDateTime updatedAt) {
  public static LogResponseDTO from(Log log) {
    return new LogResponseDTO(
        log.getId(),
        log.getTitle(),
        log.getContent(),
        log.getMood(),
        log.getCreatedAt(),
        log.getUpdatedAt());
  }
}
