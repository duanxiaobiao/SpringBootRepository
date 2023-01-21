package com.dzbiao.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.dzbiao.easyexcel.entity.DemoExcel;
import com.dzbiao.easyexcel.entity.SysUser;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DZBiao
 * @Date : 2022/2/13
 * @Description : 描述：
 **/


@Slf4j
public class DemoDataListener extends AnalysisEventListener<SysUser> {
    private List<SysUser> list = new ArrayList();
    @Override
    public void invoke(SysUser data, AnalysisContext context) {
        // 这里取到的data就是单独的一行数据，也可以在这个方法里对数据进行一些简单的处理
        System.out.println(data);
        list.add(data);
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这个方法是在excel解析完成后能对数据进行操作，也能在这里对数据进行各种处理
        log.info("获取数据量：" + list.size());
    }

    public List<SysUser> getList() {
        return list;
    }

    public DemoDataListener setList(List<SysUser> list) {
        this.list = list;
        return this;
    }
}
