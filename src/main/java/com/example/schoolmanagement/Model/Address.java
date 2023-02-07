package com.example.schoolmanagement.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Address {

    //area , street , buildingNumber ( Add all required validation )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(columnDefinition = "varchar(22) not null")
    private String area;
    @Column(columnDefinition = "varchar(22) not null")
    private String street;
    @Column(columnDefinition = "int not null")
    private int buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
