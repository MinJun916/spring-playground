package com.minjun.spring_playground.repository;

import com.minjun.spring_playground.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {}
