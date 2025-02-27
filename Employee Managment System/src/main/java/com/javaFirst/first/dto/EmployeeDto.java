package com.javaFirst.first.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
