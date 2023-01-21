package com.dzbiao.easyexcel2.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.OutputStream;
import java.util.List;

public class EasyExcelUtil {
    /**
     * 导出excel
     * @param outputStream 输出流
     * @param dataList     导出的数据
     * @param classT        模板类
     * @param sheetName     sheetName
     * @param cellWriteHandlers    样式处理类
     */
    public static void writeExcelWithModel(OutputStream outputStream, List<? extends Object> dataList, Class<? extends Object> classT, String sheetName,
                                           CellWriteHandler... cellWriteHandlers) {

        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 单元格策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 初始化表格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        //设置内容自动换行
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        ExcelWriterSheetBuilder excelWriterSheetBuilder = EasyExcel.write(outputStream, classT).sheet(sheetName).registerWriteHandler(horizontalCellStyleStrategy);
        if (null != cellWriteHandlers && cellWriteHandlers.length > 0) {
            for (int i = 0; i < cellWriteHandlers.length; i++) {
                excelWriterSheetBuilder.registerWriteHandler(cellWriteHandlers[i]);
            }
        }
        // 开始导出
        excelWriterSheetBuilder.doWrite(dataList);
    }
}

