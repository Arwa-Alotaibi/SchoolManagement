package com.example.schoolmanagement.Controller;


import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {


    private CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }
    @GetMapping("/get")
    public ResponseEntity GetAll(){
        List<Course> courseList =courseService.GetAll();
        return ResponseEntity.status(200).body(courseList);
    }

    @PostMapping("/add")
    public ResponseEntity AddCourse(@Valid @RequestBody Course course){
        courseService.AddCourse(course);
        return ResponseEntity.status(200).body("course added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity UpdateCourse(@PathVariable Integer id ,@Valid @RequestBody Course course){
        courseService.UpdateCourse(id,course);
        return ResponseEntity.status(200).body("course updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteCourse(@PathVariable Integer id){
        courseService.DeleteCourse(id);
        return ResponseEntity.status(200).body("course deleted");
    }

    @PutMapping("/teacher/{teacher_id}/course/{course_id}")
    public ResponseEntity Assign(@PathVariable Integer teacher_id , @PathVariable Integer course_id){
        courseService.AssignTeacherToCourse(teacher_id,course_id);
        return ResponseEntity.status(200).body("assign successfully");
    }

  @GetMapping("/get/{id}")
    public ResponseEntity GetName(@PathVariable Integer id){
      return ResponseEntity.status(200).body(courseService.GetTeacherName(id));

  }
}
