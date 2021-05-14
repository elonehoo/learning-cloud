package com.inet.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/12 14:18
 */
public interface DataExcelServer {
    /**
     * 导出Excel
     *
     * @param mapper 数据库对应的Mapper接口
     * @param clazz PO的class
     * @param title Excel的标题
     * @param response 响应对象
     * @return 是否成功
     */
    boolean exportExcel(BaseMapper<?> mapper, Class<?> clazz, String title, HttpServletResponse response);

    /**
     * 导入Excel
     *
     * @param mapper 数据库对应的Mapper接口
     * @param clazz PO的class
     * @param request 请求对象
     * @param <T> PO类
     * @return 是否成功
     */
    <T> boolean importExcel(BaseMapper<T> mapper, Class<T> clazz, HttpServletRequest request);
}
