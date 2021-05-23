package com.inet.code.controller;

import com.inet.code.entity.dto.ArticleDTO;
import com.inet.code.entity.po.Result;
import com.inet.code.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: 文章控制层
 * @author: hlj
 * @date: 2021-05-17
*/
@Api(tags = "文章控制层")
@CrossOrigin
@RestController
public class ArticleController {

    @Resource
    ArticleService articleService;

    @ApiOperation("新增算法文章")
    @PostMapping("/createArticle")
    public Result articleUpLoad(@RequestBody ArticleDTO articleDTO){
        Result result = new Result().result200(articleService.saveArticle(articleDTO),"/createArticle");
        return result;
    }
    @ApiOperation("根据选择的文章类型与排序依据进行排序展示文章")
    @PostMapping("/showArticle")
    public Result showArticle(@RequestPart String articleTypeId ,@RequestPart String sortBy){
        Result result = new Result().result200(articleService.showArticle(articleTypeId,sortBy),"/showArticle");
        return result;
    }

}
