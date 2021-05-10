package com.inet.code.service.impl;

import com.inet.code.entity.gitLog.po.GitLog;
import com.inet.code.mapper.GitLogMapper;
import com.inet.code.service.GitLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户提交记录表
 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Service
public class GitLogServiceImpl extends ServiceImpl<GitLogMapper, GitLog> implements GitLogService {

}
