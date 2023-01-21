package com.dzbiao.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.dzbiao.easyexcel.entity.DemoExcel;
import com.dzbiao.easyexcel.entity.SysUser;
import com.dzbiao.easyexcel.listener.DemoDataListener;
import com.dzbiao.easyexcel.service.SysService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author: DZBiao
 * @Date : 2022/2/10
 * @Description : 描述：
 **/

@Slf4j
@RestController
@RequestMapping("/sys")
public class SysController {

    @Resource
    private SysService sysService ;


    @GetMapping("/list")
    public void list(HttpServletResponse response) throws Exception {

        sysService.list(response);

    }


    @GetMapping("/download")
    public void download(HttpServletResponse response) {
        // 模拟从数据库查询数据，不一定要转成demoExcel对象，只要字段能对应上就行
        List<DemoExcel> list = getList();
        try {
            // 导出数据  System.currentTimeMillis() downloadExcel
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode(System.currentTimeMillis() + "_downloadExcel", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), DemoExcel.class).sheet("sheet1")
                    .doWrite(list);
        } catch (Exception e) {
            log.debug("导出文件失败:{}", e.getMessage());
            throw new RuntimeException("导出文件失败");
        }
    }



    private List<DemoExcel> getList() {
        Random random = new Random(1000);
        List<DemoExcel> ls = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            DemoExcel excel = new DemoExcel();
            excel.setDate(new Date());
            excel.setdData(random.nextDouble());
            excel.setString(System.currentTimeMillis() + "_downloadExcel");
            ls.add(excel);
        }
        return ls ;
    }

    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) throws IOException {
       /* DemoDataListener listener = new DemoDataListener();
        //headRowNumber(1)从第二行读数据
        //sheet()默认读第一个sheet页,当然想读第二页就往里填个1
        EasyExcel.read(file.getInputStream(), SysUser.class, listener).sheet().headRowNumber(1).doRead();
        List<SysUser> list = listener.getList();
        // 我们取到了excel中的数据后就能用来进行想要的操作了
        list.forEach(s -> {
            log.info("读取到数据------" + s);
        });*/
    }
}
