package com.example.schoolmanagement.Controller;


import com.example.schoolmanagement.Model.Student;
import com.example.schoolmanagement.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/all")
    public ResponseEntity GetAllStudent(){
        List<Student> studentList =studentService.GetAll();
        return ResponseEntity.status(200).body(studentList);
    }

    @PostMapping("/add")
    public ResponseEntity AddStudent(@Valid @RequestBody Student student){
        studentService.AddStudnet(student);
        return ResponseEntity.status(200).body("student added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity UpdateStudent(@PathVariable Integer id , @Valid @RequestBody Student student){
        studentService.UpdateStudent(id, student);
        return ResponseEntity.status(200).body("student updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteStudent(@PathVariable Integer id){
        studentService.DeleteStudent(id);
        return ResponseEntity.status(200).body("student deleted!");
    }

    @PutMapping("/students/{student_id}/courses/{course_id}")
    public ResponseEntity Assgin(@PathVariable Integer student_id ,@PathVariable Integer course_id){
        studentService.AssignStudentToCourses(student_id, course_id);
        return ResponseEntity.status(200).body("assign");
    }

    @PutMapping("/change/{student_id}/{major}")
    public ResponseEntity ChangeMajor(@PathVariable Integer student_id , @PathVariable String major){
        studentService.ChangeMajor(student_id,major);
        return ResponseEntity.status(200).body("change major");

    }
}
