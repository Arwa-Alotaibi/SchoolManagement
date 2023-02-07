package com.example.schoolmanagement.Service;


import com.example.schoolmanagement.DTO.TeacherDetails;
import com.example.schoolmanagement.Exception.ApiException;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.AddressRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherDetailsService {


    private TeacherRepository teacherRepository;

    private AddressRepository addressRepository;

    public TeacherDetailsService(TeacherRepository teacherRepository,AddressRepository addressRepository){
        this.teacherRepository=teacherRepository;
        this.addressRepository=addressRepository;
    }

    public void AddTeacherDetails(TeacherDetails teacherDetails){
        Teacher teacher = teacherRepository.findTeacherById(teacherDetails.getTeacher_id());
        if(teacher==null){
            throw new ApiException("teacher id not found!!");
        }

        Address teacherDetails1 = new Address(null,teacherDetails.getArea(),teacherDetails.getStreet(),teacherDetails.getBuildingNumber(),teacher);
        addressRepository.save(teacherDetails1);
    }

    public void UpdateTeacherDetails(TeacherDetails teacherDetails,Integer id){
        Address address =addressRepository.findAddressById(teacherDetails.getTeacher_id());
        if(address==null){
            throw new ApiException("teacher id not found!!");
        }
        //area , street , buildingNumber ( Add all required validation )
        address.setStreet(teacherDetails.getStreet());
        address.setArea(teacherDetails.getArea());
        address.setBuildingNumber(teacherDetails.getBuildingNumber());
        addressRepository.save(address);
    }

    public void  DeleteTeacherDetails(Integer id){
        Address address = addressRepository.findAddressById(id);
        if(address==null){
            throw new ApiException("address id not found!!");
        }
        addressRepository.delete(address);
    }

    public Address alldetails(Integer id){
        Address address = addressRepository.findAddressById(id);
        if(address==null){
            throw new ApiException("address id not found!!");
        }

        return address;
    }
}
