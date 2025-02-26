package org.example.springbootpractice.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
}
