package com.dzbiao.easyexcel2.common.handler;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.StyleUtil;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import java.util.HashMap;
import java.util.List;

@Slf4j
public class TitleHandler implements CellWriteHandler {

    //操作列
    private List<Integer> columnIndexs;
    //颜色
    private Short colorIndex;
    // 批注<列的下标,批注内容>
    private HashMap<Integer,String> annotationsMap;

    public TitleHandler(List<Integer> columnIndexs, Short colorIndex, HashMap<Integer, String> annotationsMap) {
        this.columnIndexs = columnIndexs;
        this.colorIndex = colorIndex;
        this.annotationsMap = annotationsMap;
    }

    public TitleHandler(List<Integer> columnIndexs, Short colorIndex) {
        this.columnIndexs = columnIndexs;
        this.colorIndex = colorIndex;
    }

    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer columnIndex, Integer relativeRowIndex, Boolean isHead) {
    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
    }

    @Override
    public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, Cell cell, Head head, Integer integer, Boolean aBoolean) {

    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        if(isHead){
            // 设置列宽
            Sheet sheet = writeSheetHolder.getSheet();
            sheet.setColumnWidth(cell.getColumnIndex(), 14 * 256);
            writeSheetHolder.getSheet().getRow(0).setHeight((short)(1.8*256));
            Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
            Drawing<?> drawing = sheet.createDrawingPatriarch();

            // 设置标题字体样式
            WriteCellStyle headWriteCellStyle = new WriteCellStyle();
            WriteFont headWriteFont = new WriteFont();
            headWriteFont.setFontName("宋体");
            headWriteFont.setFontHeightInPoints((short)14);
            headWriteFont.setBold(true);
            if (CollectionUtils.isNotEmpty(columnIndexs) &&
                    colorIndex != null &&
                    columnIndexs.contains(cell.getColumnIndex())) {
                // 设置字体颜色
                headWriteFont.setColor(colorIndex);
            }
            headWriteCellStyle.setWriteFont(headWriteFont);
            headWriteCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            CellStyle cellStyle = StyleUtil.buildHeadCellStyle(workbook, headWriteCellStyle);
            cell.setCellStyle(cellStyle);

            if (null != annotationsMap && annotationsMap.containsKey(cell.getColumnIndex())) {
                // 批注内容
                String context = annotationsMap.get(cell.getColumnIndex());
                // 创建绘图对象
                Comment comment=drawing.createCellComment(new XSSFClientAnchor(0, 0, 0,0, (short) cell.getColumnIndex(), 0, (short) 5, 5));
                comment.setString(new XSSFRichTextString(context));
                cell.setCellComment(comment);
            }
        }
    }
}

