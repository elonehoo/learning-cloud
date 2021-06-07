package com.inet.code.controller;

import com.inet.code.entity.dto.TopicDTO;
import com.inet.code.entity.po.Result;
import com.inet.code.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 题目控制层
 * @author: hlj
 * @date: 2021-06-06
*/
@Api("题目控制层")
@CrossOrigin
@RestController
public class TopicController {

    @Resource
    TopicService topicService;

    @ApiOperation(value = "搜索题目",notes = "https://leetcode-cn.com,https://www.nowcoder.com,https://nanti.jisuanke.com")
    @PostMapping("/getTopicByTitle")
    public Result getTopicByTitle(@RequestParam String website,@RequestParam String title){
        return new Result().result200(topicService.selectTopicByTitle(website,title),"/getTopic");
    }


    @ApiOperation(value = "搜索题目",notes = "https://leetcode-cn.com")
    @PostMapping("/getTopicById")
    public Result getTopicById(@RequestParam String website,@RequestParam int id){
        return new Result().result200(topicService.selectTopicById(website, id),"/getTopic");
    }

    @ApiOperation(value = "新增题目",notes = "23a23c8c-5abd-41f4-8bd2-5f8b7b52b603")
    @PostMapping("/topicUpload")
    public Result topicUpLoad(@RequestBody TopicDTO topicDTO,@RequestParam String labelId){
        return new Result().result200(topicService.saveTopicFromWebsite(topicDTO, labelId),"/topicUpload");
    }
}
