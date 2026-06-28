package com.minjun.spring_playground.entity;

import com.minjun.spring_playground.enums.Mood;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Log {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String content;

  @Enumerated(EnumType.STRING)
  private Mood mood;

  protected Log() {}

  public Log(String title, String content, Mood mood) {
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
