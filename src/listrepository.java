package com.example.To.Do.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.To.Do.App.model.todo_list;
@Repository
public interface listrepository extends JpaRepository<todo_list, Long> {

}
