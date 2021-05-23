package com.inet.code.controller;

import com.inet.code.entity.po.Result;
import com.inet.code.service.BackUpsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 数据库备份
 * @author: hlj
 * @date: 2021-05-18
*/
@RestController
@CrossOrigin
@Api
public class BackUpsController {

    @Resource
    BackUpsService backUpsService;
    @ApiOperation("数据库备份")
    @PostMapping("/dbBackUp")
    public Result dbBackUp(@RequestPart String password){
        return new Result().result200(backUpsService.dbBackUp(password),"/dbBackUp");
    }
}
