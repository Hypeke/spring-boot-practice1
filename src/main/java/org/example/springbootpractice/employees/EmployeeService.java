package org.example.springbootpractice.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Bean
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        if(employee.getEmail() == null){
            throw new IllegalArgumentException("Employee cannot be null");
        }
        if(employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new RuntimeException("Employee already exists");
        }
        if(employee.getSalary() < 5000){
            throw new RuntimeException("Salary cannot be bigger than 5000");
        }
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        if(employeeRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Employee not found by id=%s".formatted(id));
        }

        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, String email, Integer salary) {
        if(employeeRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Employee not found by id=%s".formatted(id));
        }
        if(email != null && !email.isEmpty()) {
            Optional<Employee> employee = employeeRepository.findByEmail(email);
            if(employee.isPresent()) {
                throw new RuntimeException("Employee already exists");
            }
            employeeRepository.findById(id).get().setEmail(email);
        }
        if(salary != null ) {
            if(salary < 5000) {
                throw new IllegalArgumentException("Salary cannot be smaller than 5000");
            }
            employeeRepository.findById(id).get().setSalary(salary);
        }
        return employeeRepository.save(employeeRepository.findById(id).get());
    }
}
