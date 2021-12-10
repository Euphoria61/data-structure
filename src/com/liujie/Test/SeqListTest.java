package com.liujie.Test;

import com.liujie.list.SeqList;

/**
 * @author ❤ Euphoria ❤
 * @title Student
 * @projectName data structure
 * @description:  通讯录顺序表测试
 * @date 2021/10/15   19:01
 */
public class SeqListTest extends SeqList {
    String name;
    Long telephone;

    public SeqListTest() {
    }

    public SeqListTest(String name, long telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", telephone:" + telephone +
                '}';
    }

    public static void main(String[] args) {
        //新建顺序表
        SeqList list =new SeqList();
        System.out.println("新建顺序表是否为空："+list.isEmpty());
        //插入
        list.insert(new SeqListTest("张三",11111111111L));
        list.insert(new SeqListTest("李四",22222222222L));
        list.insert(new SeqListTest("王五",33333333333L));
        System.out.println(list.toString());
        System.out.println("元素个数为："+list.n+"   "+"指定第一处插入");
        list.insert(0,new SeqListTest("刘杰",19811111111L));
        System.out.println(list.toString());
        System.out.println("元素个数为："+list.n+"   "+"指定末尾删除一处");
        //删除
        list.remove(3); System.out.println(list.toString());
        System.out.println("元素个数为："+list.n);
        //查询
        System.out.println("能否查找到：刘杰   是则输出数据，否则输出null");
        System.out.println(list.get(list.search("{name:'刘杰', telephone:19811111111}")));
    }
}
