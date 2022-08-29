package com.Elizabeth.eccomerceStore1.entitites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="admin_id")
    private long id;
    private String firstName;
    private String lastName;
    private String username;

    @Column(nullable = false,unique = true)
    private String email;

    private String password;


}
