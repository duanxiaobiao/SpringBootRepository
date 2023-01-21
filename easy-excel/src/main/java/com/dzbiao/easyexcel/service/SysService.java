package com.dzbiao.easyexcel.service;

import com.alibaba.excel.EasyExcel;
import com.dzbiao.easyexcel.dao.SysMapper;
import com.dzbiao.easyexcel.entity.SysUser;
import com.dzbiao.easyexcel.utils.ExcelUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: DZBiao
 * @Date : 2022/2/10
 * @Description : 描述：
 **/

@Service
public class SysService {

    @Resource
    private SysMapper sysMapper ;


    public void list(HttpServletResponse response) throws IllegalAccessException, IOException, InstantiationException {

        List<SysUser> list = sysMapper.list();
        //


        ExcelUtil.download(response,SysUser.class,list);
//        String fileDir = "D:/fileTest";
//        File file = ExcelUtil.generatorExcel(fileDir, System.currentTimeMillis()+"", SysUser.class, list);
//        file.createNewFile();
        //设置excel文件和文件名称
//        String fileName="D:\\fileTest\\用户信息.xls";
//        File file = new File(fileName);
//        if (!file.exists()){
//            file.createNewFile();
//        }
//        SysUser sysUser = new SysUser();
//        sysUser.setId(10);
//        sysUser.setGNum(2012);
//        sysUser.setGoodName("XXXXXXXNAME");
//        sysUser.setGoodPrice(1230.02);
//        sysUser.setGoodUrl("http://www.baidu.com");
//        sysUser.setBuyNum(10000);
//        list.add(sysUser);
//        for (SysUser s : list) {
//            System.out.println(s);
//        }
//        //调用方法实现操作
//        EasyExcel.write(fileName,SysUser.class).sheet("用户信息")
//                .doWrite(list);

    }
}
