package com.hlj.code.service.Impl;

import com.hlj.code.entity.po.Result;
import com.hlj.code.service.BackUpsService;
import org.springframework.beans.factory.annotation.Value;

/**
 * 备份
 * @author: hlj
 * @date: 2021-05-23
*/
public class BackUpsServiceImpl implements BackUpsService {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Override
    public boolean dbBackUp(String password) {
        String hostAndPort =url.substring(url.indexOf("//")+2,url.lastIndexOf("/"));
        String host = hostAndPort.substring(0,hostAndPort.indexOf(":"));
        String port = hostAndPort.substring(hostAndPort.indexOf(":")+1);
        String fileName = "backup_" + System.currentTimeMillis() + ".sql";
        //-u后的root为mysql数据库用户名，-p后接的123456为该用户密码，注意不要有空格；dbName填写需要备份数据的数据库名称，大于号后接生成文件路径
        String cmd =  "cmd /c mysqldump -h "+host+" -p "+port+" -u"+user+" -p"+password+" test>D:/dbBackUp/" + fileName;
        try {
            Runtime.getRuntime().exec(cmd);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
