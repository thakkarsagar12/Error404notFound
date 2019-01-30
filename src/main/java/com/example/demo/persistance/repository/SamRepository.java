package com.example.demo.persistance.repository;

import com.example.demo.persistance.models.Sam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SamRepository extends JpaRepository<Sam, Long> {
}
