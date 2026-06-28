package com.minjun.spring_playground.dto;

import com.minjun.spring_playground.entity.Log;
import com.minjun.spring_playground.enums.Mood;

public record LogResponseDTO(Long id, String title, String content, Mood mood) {
  public static LogResponseDTO from(Log log) {
    return new LogResponseDTO(log.getId(), log.getTitle(), log.getContent(), log.getMood());
  }
}
