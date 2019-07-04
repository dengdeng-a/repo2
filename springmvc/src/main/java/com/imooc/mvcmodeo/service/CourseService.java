package com.imooc.mvcmodeo.service;

import com.imooc.mvcmodeo.model.Course;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    Course getCoursebyId(Integer courseId);
}
