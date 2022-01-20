package com.huh.bootcamp.controller;

import com.huh.bootcamp.model.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
public class IndexApiController {
    @GetMapping("/show")
    public ResponseEntity<Department> findBy(){
        Department department = new Department();
        return null;
    }
}
