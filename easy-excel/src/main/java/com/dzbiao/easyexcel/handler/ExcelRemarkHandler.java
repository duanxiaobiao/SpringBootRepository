package com.dzbiao.easyexcel.handler;



import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.handler.RowWriteHandler;

import com.alibaba.excel.write.handler.context.RowWriteHandlerContext;
import com.dzbiao.easyexcel.annotation.ExcelRemark;
import com.dzbiao.easyexcel.utils.SpringContextUtil;
import lombok.Data;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 设置表头的批注, 需要配合注解{@link ExcelRemark}使用
 * eg：EasyExcel.write(fileName, Person.class).registerWriteHandler(new ExcelRemarkHandler(Person.class))
 *
 * @author lxh
 * @date 2022/9/24 17:30
 */
public class ExcelRemarkHandler<T> implements RowWriteHandler {

    /** 解析后的下拉数据 */
    private Map<Integer, ExcelRemarkResolve> excelRemarkResolveMap;

    /** spring表达式解析器 */
    private SpelExpressionParser spelExpressionParser;

    /** 标准上下文 */
    private StandardEvaluationContext standardEvaluationContext;

    /** 需要解析的类 */
    private Class<T> clazz;

    public ExcelRemarkHandler(Class<T> clazz) {
        this.clazz = clazz;
        //解析注解
        this.analysisAnnotation();
    }


    @Override
    public void afterRowCreate(RowWriteHandlerContext context) {
        if (CollectionUtils.isEmpty(excelRemarkResolveMap)) {
            return;
        }

        if (context.getHead()) {
            Sheet sheet = context.getWriteSheetHolder().getSheet();
            Drawing<?> drawingPatriarch = sheet.createDrawingPatriarch();
            excelRemarkResolveMap.forEach((column, v) -> {
                //若当前行与解析数据后的批注行不一样，则跳过
                if (v.row != context.getRow().getRowNum()) {
                    return;
                }
                //v.column, v.row决定批注放在哪个单元格, v.remarkColumnWide, v.remarkRowHigh决定单元个的长宽
                Comment comment =
                        drawingPatriarch.createCellComment(
                                new XSSFClientAnchor(0, 0, 0, 0,
                                        v.column, v.row, v.remarkColumnWide, v.remarkRowHigh));

                // 输入批注信息
                comment.setString(new XSSFRichTextString(v.getRemarkValue()));
                // 将批注添加到单元格对象中,这后面的的代码不知何用，删除的话，批注也能添加上
                Row row = sheet.getRow(v.row);
                if (row == null) {
                    row = sheet.createRow(v.row);
                }
                Cell cell = row.getCell(v.column);
                if (cell == null) {
                    cell = row.createCell(v.column);
                }
                cell.setCellComment(comment);

            });


        }

    }

    /**
     * 解析注释
     *
     * @return {@link List}<{@link ExcelRemarkResolve}>
     */
    private Map<Integer, ExcelRemarkResolve> analysisAnnotation() {
        Map<Integer, ExcelRemarkResolve> map = new TreeMap<>();

        //SpEL解析器
        //getDeclaredFields(): 返回全部声明的属性；getFields(): 返回public类型的属性
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            //解析注解信息
            ExcelIgnore ignore = field.getAnnotation(ExcelIgnore.class);
            if (ignore != null) {
                continue;
            }

            //解析注解信息
            ExcelRemark remark = field.getAnnotation(ExcelRemark.class);
            if (remark != null) {
                ExcelRemarkResolve resolve = new ExcelRemarkResolve();
                String dynamicAccess = remark.dynamicAccess();
                if (dynamicAccess == null || dynamicAccess.isEmpty()) {
                    //直接获取注解中的值
                    resolve.setRemarkValue(remark.value());
                } else {
                    //调用SpEL解析器
                    resolve.setRemarkValue(this.getrRemarkValueFormApplicationContext(dynamicAccess));
                }
                if (resolve.getRemarkValue() == null || resolve.getRemarkValue().length() <= 0) {
                    continue;
                }

                //解析注解信息
                ExcelProperty property = field.getAnnotation(ExcelProperty.class);
                if (property != null && property.index() >= 0) {
                    resolve.setColumn(property.index());
                } else {
                    resolve.setColumn(i);
                }

                resolve.setRemarkRowHigh(remark.remarkRowHigh());
                resolve.setRemarkColumnWide(remark.remarkColumnWide());
                //设置批注所在行,若都没执行，***则使用int初始化的默认值0***
                if (remark.remarkRow() != -1) {
                    resolve.setRow(remark.remarkRow());
                } else if (property != null) {
                    //length属性为元素个数,此处需转换算成index
                    resolve.setRow(property.value().length - 1);
                }

                //将参数放入集合
                map.put(resolve.getColumn(), resolve);
            }
        }

        this.excelRemarkResolveMap = map;

        return map;

    }

    /**
     * 调用上下文中的方法，动态获取下拉值
     *
     * @param dynamicAccess 动态访问
     * @return {@link String}
     */
    private String getrRemarkValueFormApplicationContext(String dynamicAccess) {
        if (spelExpressionParser == null) {
            this.spelExpressionParser = new SpelExpressionParser();
        }

        if (standardEvaluationContext == null) {
            standardEvaluationContext = new StandardEvaluationContext(SpringContextUtil.getApplicationContext());
        }

        Expression expression = spelExpressionParser.parseExpression(dynamicAccess);
        Object value = expression.getValue(standardEvaluationContext);

        return value.toString();
    }

    @Data
    private class ExcelRemarkResolve {

        /** 列号 */
        private Integer column;

        /** 批注值 */
        private String remarkValue;

        /** 批注行高 */
        int remarkRowHigh;

        /** 批注列宽 */
        int remarkColumnWide;

        /**
         * 批注所在行
         *
         * @return int
         */
        int row;
    }
}
