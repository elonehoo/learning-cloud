package com.inet.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.code.entity.atricle.po.Article;
import com.inet.service.DataExcelServer;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.crypto.Data;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
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
        ExportParams params = new ExportParams(title, "sheet0");

        params.setType(ExcelType.XSSF);

        Workbook workbook = ExcelExportUtil.exportBigExcel(params, clazz, mapper.selectList(new QueryWrapper<>()));
        try {
            String fileName = UUID.randomUUID().toString() + ".xlsx";
            String path = "hzpt-abcI/src/main/resources/export/" + fileName;

            workbook.write(new FileOutputStream(path));
            workbook.close();

            InputStream in = new FileInputStream(path);

            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename="
                    + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

            ServletOutputStream out = response.getOutputStream();
            int len;
            byte[] buffer = new byte[1024 * 1024];
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            out.flush();
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
            parts = request.getParts();
            ImportParams params = new ImportParams();
            params.setTitleRows(1);
            params.setHeadRows(1);

            for (Part part : parts) {

                List<T> list = ExcelImportUtil.importExcel(part.getInputStream(), clazz, params);

                for (T o : list) {
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