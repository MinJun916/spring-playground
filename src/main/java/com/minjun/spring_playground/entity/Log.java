package com.minjun.spring_playground.entity;

import com.minjun.spring_playground.enums.Mood;

public class Log {
  private Long id;
  private String title;
  private String content;
  private Mood mood;

  public Log(Long id, String title, String content, Mood mood) {
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

  public Mood getMood() {
    return mood;
  }

  public void update(String title, String content, Mood mood) {
    this.title = title;
    this.content = content;
    this.mood = mood;
  }
}
