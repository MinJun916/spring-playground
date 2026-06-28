package com.minjun.spring_playground.dto;

import com.minjun.spring_playground.enums.Mood;

public record LogResponseDTO(Long id, String title, String content, Mood mood) {}
