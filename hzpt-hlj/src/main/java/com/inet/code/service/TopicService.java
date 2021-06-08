package com.inet.code.service;

import com.inet.code.entity.dto.TopicDTO;
import com.inet.code.entity.vo.TopicVO;

import java.util.List;

/**
 * 题目服务层
 * @author: hlj
 * @date: 2021-06-04
*/

public interface TopicService {
    /**
     * 根据题目标题进行题目的查找，支持模糊查询,每次查询4个题目
     * @param website 拉取题目的网页
     * @param title 题目标题，支持模糊查询
     * @return String 返回搜索到的题目
    */
    List<TopicVO> selectTopicByTitle(String website, String title);
    /**
     * 根据题目ID进行查找，目前只有力扣网支持，其他网站我找不到ID
     * @param website 拉取题目的网页
     * @param id 题目标题，支持模糊查询
     * @return String 返回搜索到的题目
     */
    TopicVO selectTopicById(String website,int id);
    /**
     * 增加一条来自网页的题目
     * @param topicDTO 题目传输类
     * @param labelId 题目标签ID
     * @return boolean 返回插入是否成功
    */
    boolean saveTopicFromWebsite(TopicDTO topicDTO, String labelId);
}
