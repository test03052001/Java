package com.example.demo.service;

import com.example.demo.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private DepartmentRepository departmentRepository;

    public User save(User user, Long departmentId) {
        user.setDepartment(resolveDepartment(departmentId));
        return repo.save(user);
    }

    public User update(Long id, User patch, Long departmentId) {
        User existing = repo.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        if (patch.getName() != null) existing.setName(patch.getName());
        if (patch.getEmail() != null) existing.setEmail(patch.getEmail());
        if (patch.getPassword() != null) existing.setPassword(patch.getPassword());
        if (departmentId != null) existing.setDepartment(resolveDepartment(departmentId));
        return repo.save(existing);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private Department resolveDepartment(Long departmentId) {
        if (departmentId == null) return null;
        return departmentRepository.findById(departmentId).orElse(null);
    }
}