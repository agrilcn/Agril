package com.huh.bootcamp.controller;

import com.huh.bootcamp.model.Department;
import com.huh.bootcamp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class DepartemenApiController {
    @Autowired
    private DepartmentRepository repo;

    @GetMapping("/findById/{departemenId}")
    public ResponseEntity<Department> findById(@PathVariable("departemenId") Integer id) {
        try {
            Department department = repo.findById(id);
            return ResponseEntity.ok(department);
        } catch (
                EmptyResultDataAccessException ertdao) {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("list")
    public List<Department> list() {
        return this.repo.list();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Department department) {
        department = this.repo.insert(department);
        if (department.getId() == null) {
            return ResponseEntity.internalServerError().body("Gak Tau Errornya Apa");
        } else {
            return ResponseEntity.ok(department);
        }
    }
}
