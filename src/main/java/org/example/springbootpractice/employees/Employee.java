package org.example.springbootpractice.employees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class Employee {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private Integer age;
    private Integer salary;

}
