package com.example.schoolmanagement.Controller;


import com.example.schoolmanagement.DTO.TeacherDetails;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Service.TeacherDetailsService;
import com.example.schoolmanagement.Service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    private TeacherService teacherService;
    private TeacherDetailsService teacherDetailsService;

    public TeacherController(TeacherService teacherService,TeacherDetailsService teacherDetailsService){
        this.teacherService=teacherService;
        this.teacherDetailsService=teacherDetailsService;
    }

    @GetMapping("/get")
    public ResponseEntity GetALL(){
        List<Teacher> teacherList =teacherService.GetAllTeacher();
        return ResponseEntity.status(200).body(teacherList);
    }

    @PostMapping("/add")
    public ResponseEntity AddTeacher(@Valid @RequestBody Teacher teacher){
       teacherService.AddTeacher(teacher);
        return ResponseEntity.status(200).body("teacher added!");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity EditTeacher(@PathVariable Integer id ,@Valid @RequestBody Teacher teacher){
        teacherService.UpdateTeacher(id,teacher);
        return ResponseEntity.status(200).body("teacher updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteTeacher(@PathVariable Integer id){
        teacherService.DeleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted!");

    }

    @PostMapping("/add/details")
    public ResponseEntity AddTeacherDetails(@Valid @RequestBody TeacherDetails teacherDetails){
        teacherDetailsService.AddTeacherDetails(teacherDetails);
        return ResponseEntity.status(200).body("teacher details added!");
    }

    @PutMapping("/edit/details/{id}")
    public ResponseEntity UpdateDetails(@PathVariable Integer id , @Valid @RequestBody TeacherDetails teacherDetails ){
        teacherDetailsService.UpdateTeacherDetails(teacherDetails,id);
        return ResponseEntity.status(200).body("teacher details updated!");
    }

    @DeleteMapping("/delete/details/{id}")
    public ResponseEntity DeleteDetails(@PathVariable Integer id){
        teacherDetailsService.DeleteTeacherDetails(id);
        return ResponseEntity.status(200).body("teacher details deleted!");
    }
//Create endpoint that takes teacher id and return All teacher details
    @GetMapping("/getdetails/{id}")
    public ResponseEntity GetDeatils(@PathVariable Integer id){
        Teacher teacher= teacherService.alldetails(id);
        return ResponseEntity.status(200).body(teacher);

    }
}
