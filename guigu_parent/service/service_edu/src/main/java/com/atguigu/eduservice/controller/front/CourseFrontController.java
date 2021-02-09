package com.atguigu.eduservice.controller.front;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.frontvo.CourseFrontVo;
import com.atguigu.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/eduservice/coursefront")
@CrossOrigin
public class CourseFrontController {


   @Autowired
    private EduCourseService courseService;


   @PostMapping("getFrontCourseList/{page}/{limit}")
    public R getFrontCourseList(
           @PathVariable long page,
           @PathVariable long limit,
           @RequestBody(required = false) CourseFrontVo courseFrontVo
           ) {
       Page<EduCourse> pageCourse = new Page<>(page, limit);
       Map<String, Object> map = courseService.getCourseFrontList(pageCourse, courseFrontVo);
       return R.ok().data(map);
   }


}
