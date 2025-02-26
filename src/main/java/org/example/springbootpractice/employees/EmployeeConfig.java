package org.example.springbootpractice.employees;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner ( EmployeeRepository employeeRepository ) {
        return (args) -> {
            var employeeList = List.of(
                new Employee(
                        null,
                        "Nurasil",
                        "nurasyl@mail.ru",
                        LocalDate.of(1999,1,5),
                        25,
                        1500000
                ),
                new Employee(
                        null,
                        "Nuriza",
                        "nuriza@mail.ru",
                        LocalDate.of(2003,1,5),
                        25,
                        1500000
                ));
            employeeRepository.saveAll(employeeList);
        };
    }
}
