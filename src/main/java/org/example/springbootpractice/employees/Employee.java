package org.example.springbootpractice.employees;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="employee")
@NoArgsConstructor
public class Employee {
    @Id
    @SequenceGenerator(
            name="employee_sequence",
            sequenceName="employee_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    @Transient
    private Integer age;
    private Integer salary;

    public Integer getAge() {
        this.age= Period.between(birthDate, LocalDate.now()).getYears();
        return age;
    }
}
