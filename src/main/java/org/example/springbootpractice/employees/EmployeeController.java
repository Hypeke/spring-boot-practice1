
package org.example.springbootpractice.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EmployeeController {
    @GetMapping()
    public List<Employee> getEmployees() {
        return List.of(
                new Employee(
                        1L,
                        "Nurasil",
                        "nurasyl@mail.ru",
                        LocalDate.of(1999,1,5),
                        25,
                        1500000
                )
        );
    }
}
