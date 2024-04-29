package com.disrupting.television.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disrupting.television.entity.Canal;

public interface CanalRepository extends JpaRepository<Canal, Integer> {

}
