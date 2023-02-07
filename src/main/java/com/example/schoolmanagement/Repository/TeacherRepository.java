package com.example.schoolmanagement.Repository;

import com.example.schoolmanagement.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);

    Teacher findTeacherByName(String name);

   //List<Teacher> findAllById(Integer id);
}
