package com.example.schoolmanagement.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    //Student Class : ID , name , age , major ( all should not be empty )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(columnDefinition = "varchar(22) not null")
    private String name;
    @NotNull
    @Column(columnDefinition = "int NOT NULL")
    private int age;

    @Column(columnDefinition = "varchar(22) not null")
    private String major;

    @ManyToMany
    @JsonIgnore
    private List<Course>courses;



}
