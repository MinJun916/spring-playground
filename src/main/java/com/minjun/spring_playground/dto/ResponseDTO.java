package com.minjun.spring_playground.dto;

public record ResponseDTO<T>(boolean success, String message, T data) {}
