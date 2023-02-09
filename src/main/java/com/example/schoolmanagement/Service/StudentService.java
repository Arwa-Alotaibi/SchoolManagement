package com.example.schoolmanagement.Service;


import com.example.schoolmanagement.Exception.ApiException;
import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Model.Student;
import com.example.schoolmanagement.Repository.CourseRepository;
import com.example.schoolmanagement.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;


    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository){
        this.studentRepository=studentRepository;
        this.courseRepository=courseRepository;
    }

    public List<Student> GetAll(){
        return studentRepository.findAll();
    }

    public void  AddStudnet(Student student){
        studentRepository.save(student);
    }

    public void UpdateStudent(Integer id, Student student){
        Student OldStudent = studentRepository.findStudentById(id);
        if(OldStudent==null){
            throw new ApiException("student id not found");
        }
        OldStudent.setName(student.getName());
        OldStudent.setAge(student.getAge());
        OldStudent.setMajor(student.getMajor());
        studentRepository.save(OldStudent);
    }

    public void  DeleteStudent(Integer id){
        Student deletestudent = studentRepository.findStudentById(id);
        if(deletestudent==null){
            throw new ApiException("student id not found");
        }
        studentRepository.delete(deletestudent);
    }
    public void AssignStudentToCourses(Integer student_id , Integer course_id){
        Student student =studentRepository.findStudentById(student_id);
        Course course = courseRepository.findCourseById(course_id);
        if(student==null ||  course==null){
            throw  new ApiException("course id or student id not found");
        }

        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }

   //takes student id and major and change the student major
    // ( changing the major will drop all the cousres that the student attended to )

    public void ChangeMajor(Integer student_id , String major){
        Student student = studentRepository.findStudentById(student_id);
        Course course = courseRepository.findCourseByStudentsId(student_id);


        if(student==null){
            throw  new ApiException(" student id not found");
        }
        student.setMajor(major);
        student.getCourses().remove(course);
        studentRepository.save(student);
        course.getStudents().remove(student);
        courseRepository.save(course);
    }

}
