package com.example.schoolmanagement.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    //id , name , age , email , salary ( Add all required validation )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(columnDefinition = "varchar(22) not null")
    private String name;
    @Column(columnDefinition = "int NOT NULL")
    private int age;

    @Column(columnDefinition = "varchar(22) not null")
    private String email;
    @Column(columnDefinition=" int NOT NULL")
    private int salary;


    @OneToOne(cascade =CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(cascade = CascadeType.ALL ,mappedBy ="teacher")
    private List<Course> courseList;




}
