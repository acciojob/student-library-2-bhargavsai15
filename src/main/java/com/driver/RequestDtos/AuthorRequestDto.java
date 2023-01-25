package com.driver.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class AuthorRequestDto {

    private String name;

    @Column(unique = true)
    private String email;

    private int age;
    private String country;
}
