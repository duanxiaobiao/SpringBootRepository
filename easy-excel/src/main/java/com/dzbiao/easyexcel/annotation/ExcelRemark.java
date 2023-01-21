package com.dzbiao.easyexcel.annotation;



import java.lang.annotation.*;

/**
 * 设置表头的批注, 需要配合{@link ExcelRemarkHandler}使用
 *
 * @author li
 * @date 2022/09/24
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelRemark {
    /**
     * 一般使用此属性的值进行批注的填充
     *
     * @return {@link String[]}
     */
    String value() default "";

    /**
     * 慎用此属性，建议使用value
     * 此处值应为一个SpEL，返回值需要是一个String
     * 此表达式若有值(无论是否调用是否成功)，则会忽略value属性
     * 使用示例：#root.getBean('userService')?.getSelectedList('2')
     * 此处的使用示例中的 #root指的是applicationContext
     *
     * @return {@link String}
     */
    String dynamicAccess() default "";

    /**
     * 批注所在行,一般不用设置，代码自动判断
     * -1表示自动获取头的最后一个行
     *
     * @return int
     */
    int remarkRow() default -1;

    /**
     * 批注行高, 一般不用设置
     *
     * @return
     */
    int remarkRowHigh() default 0;

    /**
     * 批注列宽, 根据导出情况调整
     *
     * @return
     */
    int remarkColumnWide() default 0;

}
