package com.minjun.spring_playground.entity;

public class Log {
  private Long id;
  private String title;
  private String content;
  private String mood;

  public Log(Long id, String title, String content, String mood) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.mood = mood;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getMood() {
    return mood;
  }

  public void update(String title, String content, String mood) {
    this.title = title;
    this.content = content;
    this.mood = mood;
  }
}
