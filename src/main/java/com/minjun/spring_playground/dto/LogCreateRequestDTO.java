package com.minjun.spring_playground.dto;

import com.minjun.spring_playground.enums.Mood;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LogCreateRequestDTO(
    @NotBlank(message = "title value is required") String title,
    @NotBlank(message = "content value is required") String content,
    @NotNull(message = "mood value is required") Mood mood) {}
