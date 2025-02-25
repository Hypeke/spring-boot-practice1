package org.example.springbootpractice.employees;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    @Bean
    public List<Employee> getAllEmployees() {
        return List.of(
                new Employee(
                        1L,
                        "Nurasil",
                        "nurasyl@mail.ru",
                        LocalDate.of(1999,1,5),
                        25,
                        1500000
                ),
                new Employee(
                        2L,
                        "Nuriza",
                        "nuriza@mail.ru",
                        LocalDate.of(2003,1,5),
                        25,
                        1500000
                )
        );
    }
}
