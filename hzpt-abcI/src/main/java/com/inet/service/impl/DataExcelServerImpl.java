package com.inet.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.service.DataExcelServer;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/12 14:18
 */
@Service
public class DataExcelServerImpl implements DataExcelServer {

    /**
     * 导出Excel
     *
     * @param mapper 数据库对应的Mapper接口
     * @param clazz PO的class
     * @param title Excel的标题
     * @param response 响应对象
     * @return 是否成功
     */
    @Override
    public boolean exportExcel(BaseMapper<?> mapper, Class<?> clazz, String title, HttpServletResponse response) {
        // 设置导出参数
        ExportParams params = new ExportParams(title, "sheet0");
        // 使用".xlsx"文件
        params.setType(ExcelType.XSSF);

        /* 从数据库获取数据，封装入工作簿
         *
         * ExportParams 导出参数
         * Class 数据库对应类的Class
         * Collection 查询数据库的结果
         */
        Workbook workbook = ExcelExportUtil.exportBigExcel(params, clazz, mapper.selectList(new QueryWrapper<>()));
        try {
            // Excel名
            String fileName = UUID.randomUUID().toString() + ".xlsx";
            // Excel位置
            String path = "hzpt-abcI/src/main/resources/export/" + fileName;

            // 将数据写入工作簿
            workbook.write(new FileOutputStream(path));
            workbook.close();

            // 获取输入流
            InputStream in = new FileInputStream(path);

            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename="
                    + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

            // 获取输出流
            ServletOutputStream out = response.getOutputStream();

            // 将导出的Excel发送向前端
            int len;
            byte[] buffer = new byte[1024 * 1024];
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            out.flush();

            // 关闭流
            out.close();
            in.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 导入Excel
     *
     * @param mapper 数据库对应的Mapper接口
     * @param clazz PO的class
     * @param request 请求对象
     * @param <T> PO类
     * @return 是否成功
     */
    @Override
    public <T> boolean importExcel(BaseMapper<T> mapper, Class<T> clazz,
                                   HttpServletRequest request) {

        Collection<Part> parts;
        try {
            // 获取前端上传的文件
            parts = request.getParts();

            // 导入参数设置
            ImportParams params = new ImportParams();
            // 标签行
            params.setTitleRows(1);
            // 头部行
            params.setHeadRows(1);

            for (Part part : parts) {

                /* 导入Excel
                 *
                 * InputStream 上传文件输入流
                 * Class 数据库对应类的Class
                 * ImportParams 导入参数
                 */
                List<T> list = ExcelImportUtil.importExcel(part.getInputStream(), clazz, params);

                for (T o : list) {
                    // 从Excel获取的数据存入数据库
                    mapper.insert(o);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}