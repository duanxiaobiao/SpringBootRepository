package com.dzbiao.springbootcommonutils.utils;

import java.util.*;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/02/12 15:15
 * @Description:
 */
public class ListBuilder<T> {

    private List<T> list;


    public static <T> ListBuilder<T> builder(){
        ListBuilder<T> listBuilder = new ListBuilder<>();
        listBuilder.list = new ArrayList<>();
        return listBuilder;
    }


    public static <T> ListBuilder<T> builder(Collection<? extends T> c){
        ListBuilder<T> listBuilder = new ListBuilder<>();
        listBuilder.list = new ArrayList<>();
        listBuilder.addAll(c);
        return listBuilder;
    }


    public ListBuilder<T> add(T t){
        this.list.add(t);
        return this;
    }

    public ListBuilder<T> addAll(Collection<? extends T> c){
        if (Objects.nonNull(c) && c.size() > 0){
            this.list.addAll(c);
        }
        return this;
    }

    public List<T> build(){
        return list;
    }


    public static void main(String[] args) {
        List<String> list = ListBuilder.<String>builder().add("1").addAll(Arrays.asList("3", "4")).build();
        System.out.println(list);
    }
}
