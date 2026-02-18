package com.example.college.service;

import com.example.college.dto.CourseGetDTO;
import com.example.college.dto.CoursePostDTO;
import com.example.college.service.interfacesServ.ICourseService;

import java.util.List;

public class CourseService implements ICourseService {
    @Override
    public List<CourseGetDTO> getCourses() {
        return List.of();
    }

    @Override
    public CoursePostDTO postCourse(CoursePostDTO coursePostDTO) {
        return null;
    }

    @Override
    public CoursePostDTO putCourse(Long id, CoursePostDTO coursePostDTO) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {

    }
}
