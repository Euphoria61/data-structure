package com.liujie.Polynomial;

/*
可相加接口  ，T 表示数据元素的数据类型
 */
public interface Addible<T> {
    public void add(T tobj);    //+=相加，约定元素相加规则
    public  boolean removable();//约定删除元素的条件

}
