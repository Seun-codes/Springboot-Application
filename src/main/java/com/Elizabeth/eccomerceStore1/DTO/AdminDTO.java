package com.Elizabeth.eccomerceStore1.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AdminDTO {
    @Size(min = 3, max = 10, message = "Invalid first name!(3 - 10 characters)")
    private String firstName;
    @Size(min = 3, max = 10, message = "Invalid last name!(3 - 10 characters)")
    private String lastName;
    private String username;
    private String email;

    @Size(min = 5, max = 15, message = "Invalid password!(5 - 15 characters)")
    private String password;
    private String repeatPassword;
}
