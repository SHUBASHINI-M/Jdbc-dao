package com.hexaware.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.hexaware.app.Entity.Student;


public interface RepStudent extends JpaRepository<Student, Integer> {
    List<Student> findByNameContaining(String name);
}
