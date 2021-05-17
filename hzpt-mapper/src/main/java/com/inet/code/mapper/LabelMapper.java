package com.inet.code.mapper;

import com.inet.code.entity.label.po.Label;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 题目标签表
 Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Mapper
public interface LabelMapper extends BaseMapper<Label> {
    /**
     * 根据题目id修改标签表的网站名name
     * @param id 需要修改的题目id
     * @param name 需要修改的网站名
     * @return 是否修改成功
     */
    boolean updateLabelNameByTopicId(String id, String name);
}
