package com.example.schoolmanagement.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(columnDefinition = "varchar(22) not null")
    private String name;


    @ManyToOne
    @JoinColumn(name="teacher_id",referencedColumnName = "id")
    @JsonIgnore
    private Teacher teacher;
}
