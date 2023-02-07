package com.example.schoolmanagement.Service;


import com.example.schoolmanagement.Exception.ApiException;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;
    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository=teacherRepository;
    }

    public List<Teacher> GetAllTeacher(){
       return teacherRepository.findAll();
    }

    public void AddTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public  void  UpdateTeacher(Integer id,Teacher teacher){
        Teacher OldTeacher= teacherRepository.findTeacherById(id);
        if(OldTeacher==null){
            throw new ApiException("teacher id not found!!");
        }
        //id , name , age , email , salary ( Add all required validation )
        OldTeacher.setName(teacher.getName());
        OldTeacher.setAge(teacher.getAge());
        OldTeacher.setEmail(teacher.getEmail());
        OldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(OldTeacher);
    }
    public  void  DeleteTeacher(Integer id){
        Teacher DeleteTeacher = teacherRepository.findTeacherById(id);
        if(DeleteTeacher==null){
            throw new ApiException("teacher id not found!!");
        }
        teacherRepository.delete(DeleteTeacher);
    }
}
