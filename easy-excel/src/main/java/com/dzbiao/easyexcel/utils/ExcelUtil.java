package com.dzbiao.easyexcel.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: DZBiao
 * @Date : 2022/2/11
 * @Description : 描述：
 **/


public class ExcelUtil {
    /**
     * 相对路径，文件会生成在与项目平级的目录
     */
    private static final String FILE_PATH = "file/excel";

    private static final String EXCEL_SUFFIX = ".xlsx";

    public static void download(HttpServletResponse response, Class t, List list) throws IOException, IllegalAccessException,InstantiationException {
        response.setContentType("application/vnd.ms-excel");// 设置文本内省
        response.setCharacterEncoding("utf-8");// 设置字符编码
        response.setHeader("Content-disposition", "attachment;filename=demo.xlsx"); // 设置响应头
        EasyExcel.write(response.getOutputStream(), t).sheet("模板").doWrite(list); //用io流来写入数据
    }

    /**
     * 在指定位置生成excel文件
     *
     * @param fileName 文件路径
     * @param clazz    导出数据类型
     * @param list     导出数据
     * @param <T>      可以不加这个也行，但是会有警告，看起来不舒服
     */
    public static <T> void writeToExcel(String fileName, Class<T> clazz, List<T> list) {
        ExcelWriter excelWriter = EasyExcel.write(fileName).build();
        WriteSheet sheet = EasyExcel.writerSheet().head(clazz).build();
        excelWriter.write(list, sheet);
        excelWriter.finish();
    }



    /**
     * 生成excel文件
     *
     * @param fileName
     * @param clazz
     * @param list
     * @param <T>
     * @return
     */
    public static  <T> File generatorExcel(String fileDir,String fileName, Class<T> clazz, List<T> list) {
        generateFilePath(fileDir);
        String fileFullName = fileDir + "/" +fileName + EXCEL_SUFFIX;
        ExcelUtil.writeToExcel(fileFullName, clazz, list);
        return new File(fileFullName);
    }

    private static boolean generateFilePath(String fileDir) {
        File path = new File(fileDir);
        if (path.exists()) {
            return true;
        } else {
            return path.mkdirs();
        }
    }
}
