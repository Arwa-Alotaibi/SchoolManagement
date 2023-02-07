package com.example.schoolmanagement.Service;


import com.example.schoolmanagement.Exception.ApiException;
import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.CourseRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository;
    private TeacherRepository teacherRepository;

    public CourseService(CourseRepository courseRepository,TeacherRepository teacherRepository){
        this.courseRepository=courseRepository;
        this.teacherRepository=teacherRepository;
    }

    public List<Course> GetAll(){
        return courseRepository.findAll();
    }

    public void AddCourse(Course course){
        courseRepository.save(course);
    }
    public void  UpdateCourse(Integer id,Course course){
        Course OldCourse= courseRepository.findCourseById(id);
        if(OldCourse==null){
            throw new ApiException("course id not found");
        }

        OldCourse.setName(course.getName());
        courseRepository.save(OldCourse);
    }

    public void DeleteCourse(Integer id){
        Course DeleteCourse = courseRepository.findCourseById(id);
        if(DeleteCourse==null){
            throw new ApiException("course id not found");
        }
        courseRepository.delete(DeleteCourse);
    }

    public void AssignTeacherToCourse(Integer teacher_id,Integer course_id){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);
        if(teacher==null || course==null){
            throw new ApiException("teacher id not found or course id not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    //take course id and return the teacher name for that class
    public String GetTeacherName(Integer id){
        Course course =courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("course id not found");
        }
        return course.getTeacher().getName();
    }
}
