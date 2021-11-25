package com.liujie.Test;

import com.liujie.list.SortedSeqList;

import java.text.Collator;
import java.util.Locale;

/**
 * @author ❤ Euphoria ❤
 * @title com.liujie.Test.StdSortedSeqList
 * @projectName data structure
 * @description: 通讯录排序顺序表测试  按姓名首字母排序
 * @date 2021/10/16   19:28
 */
public class SortedSeqListTest extends SortedSeqList implements Comparable<SortedSeqListTest> {
    String name;
    Long telephone;

    public SortedSeqListTest(String name, Long telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }
    @Override
    public int compareTo(SortedSeqListTest o) {
        Collator collator = Collator.getInstance(Locale.CHINA);
        return collator.compare(this.name,o.name);

    }
    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", telephone:" + telephone +
                '}';
    }

    public static void main(String[] args) {
        // 新建

        SortedSeqList sortedSeqList = new SortedSeqList();
        System.out.println("新建排序顺序表是否为空：" + sortedSeqList.isEmpty());
        //插入
        sortedSeqList.insert(new SortedSeqListTest("王五", 66666666666L));
        sortedSeqList.insert(new SortedSeqListTest("李四", 55555555555L));
        sortedSeqList.insert(new SortedSeqListTest("张三", 74444444444L));
        System.out.println(sortedSeqList.toString());
        System.out.println("插入刘杰");
        sortedSeqList.insert(new SortedSeqListTest("刘杰", 19888888888L));
        System.out.println(sortedSeqList.toString());
        System.out.println("删除第一处");
        //删除
        sortedSeqList.remove(0);
        System.out.println(sortedSeqList.toString());
        //查找
        System.out.println("能否查找到：刘杰   是则输出数据，否则输出null");
        System.out.println(sortedSeqList.get(sortedSeqList.search("{name:'刘杰', telephone:19888888888}")));
    }





}

