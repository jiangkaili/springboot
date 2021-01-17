package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-01-12
 */
@RestController
@RequestMapping("/eduservice/edu-video")
public class EduVideoController {

    @Autowired
    private EduVideoService eduVideoService;

    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo) {
        eduVideoService.save(eduVideo);
        return R.ok();
    }

    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id) {
        eduVideoService.removeById(id);
        return R.ok();
    }
}

