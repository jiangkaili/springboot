package com.atguigu.eduservice.controller.front;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.chapter.ChapterVo;
import com.atguigu.eduservice.entity.frontvo.CourseFrontVo;
import com.atguigu.eduservice.entity.frontvo.CourseWebVo;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/eduservice/coursefront")
@CrossOrigin
public class CourseFrontController {


    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduChapterService chapterService;


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


    @GetMapping("getFrontCourseInfo/{courseId}")
    public R getFrontCourseInfo(@PathVariable String courseId) {
        // 根据课程id， 编写sql语句来查询课程信息
        CourseWebVo courseWebVo = courseService.getBaseCourseInfo(courseId);
        List<ChapterVo> chapterVideoList = chapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("courseWebVo", courseWebVo).data("chapterVideoList", chapterVideoList);
    }
}
