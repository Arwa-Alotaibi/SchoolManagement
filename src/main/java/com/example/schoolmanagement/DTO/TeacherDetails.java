package com.example.schoolmanagement.DTO;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDetails {
    //DTOs or Data Transfer Objects are objects that carry data between processes in order to reduce the number of methods calls

    private Integer teacher_id;

    @Column(columnDefinition = "varchar(22) not null")
    private String area;
    @Column(columnDefinition = "varchar(22) not null")
    private String street;
    @Column(columnDefinition = "int not null")
    private int buildingNumber;

}
