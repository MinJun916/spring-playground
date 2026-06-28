package com.minjun.spring_playground.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateLogRequest(
    @NotBlank(message = "title value is required") String title,
    @NotBlank(message = "content value is required") String content,
    @NotBlank(message = "mood value is required") String mood) {}
