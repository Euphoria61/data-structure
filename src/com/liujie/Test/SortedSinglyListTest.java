package com.liujie.Test;

import com.liujie.list.SortedSinglyList;

import java.text.Collator;
import java.util.Locale;

/**
 * @author ❤ Euphoria ❤
 * @title com.liujie.Test.StdSortedSinglyList
 * @projectName data structure
 * @description: 通讯录排序单链表测试
 * @date 2021/10/17   13:51
 */
public class SortedSinglyListTest<T extends Comparable<? super T>>extends SortedSinglyList implements Comparable<SortedSinglyListTest> {
    String name;
    Long telephone;

    public SortedSinglyListTest(String name, Long telephone) {
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
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", telephone:" + telephone +
                '}';
    }
    @Override
    public int compareTo(SortedSinglyListTest o) {
        Collator collator = Collator.getInstance(Locale.CHINA);
        return collator.compare(this.name,o.name);
    }

    public static void main(String[] args) {
        // 新建

        SortedSinglyList sortedSinglyList = new SortedSinglyList();
        System.out.println("新建排序单链表是否为空：" + sortedSinglyList.isEmpty());
        //插入
        sortedSinglyList.insert(new SortedSinglyListTest("王五", 66666666666L));
        sortedSinglyList.insert(new SortedSinglyListTest("李四", 55555555555L));
        sortedSinglyList.insert(new SortedSinglyListTest("张三", 74444444444L));
        System.out.println(sortedSinglyList.toString());
        System.out.println("插入刘杰");
        sortedSinglyList.insert(new SortedSinglyListTest("刘杰", 19888888888L));
        System.out.println(sortedSinglyList.toString());
        System.out.println("删除第一处");
        //删除
        sortedSinglyList.remove(0);
        System.out.println(sortedSinglyList.toString());
        //查找
        System.out.println("能否查找到：刘杰   是则输出数据，否则输出null");
        System.out.println(sortedSinglyList.get(sortedSinglyList.search("{name:'刘杰', telephone:19888888888}")));
    }

}
