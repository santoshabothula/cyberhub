package com.sg.cyberhub.repository;

import com.sg.cyberhub.entity.LogTrace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogTraceRepository extends JpaRepository<LogTrace, String> {}
