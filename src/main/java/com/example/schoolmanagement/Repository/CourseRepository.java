package com.example.schoolmanagement.Repository;


import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findCourseById(Integer id);

    Course findCourseByStudentsId(Integer id);

}
