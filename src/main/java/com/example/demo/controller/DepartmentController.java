package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository repo;

    @PostMapping
    public Department create(@RequestBody Department department) {
        return repo.save(department);
    }

    @GetMapping
    public List<Department> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted";
    }
}

