package com.liujie.Test;

import com.liujie.list.SinglyList;

/**
 * @author ❤ Euphoria ❤
 * @title StudentSinglyList
 * @projectName data structure
 * @description: 通讯录单链表测试
 * @date 2021/10/16   15:11
 */
public class SinglyListTest {

    String name;
    Long telephone;

    public SinglyListTest() {
    }

    public SinglyListTest(String name, long telephone) {
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
        // 新建
        SinglyList singlyList = new SinglyList();
        System.out.println("新建单链表是否为空：" + singlyList.isEmpty());
        //插入
        singlyList.insert(0, new SinglyListTest("张三", 44444444444L));
        singlyList.insert(1, new SinglyListTest("李四", 55555555555L));
        singlyList.insert(2, new SinglyListTest("王五", 66666666666L));
        System.out.println(singlyList.toString());
        System.out.println("单链表长度为：" + singlyList.size() + "   " + "指定第二处插入");
        singlyList.insert(1, new SeqListTest("刘杰", 19888888888L));
        System.out.println(singlyList.toString());
        System.out.println("单链表长度为：" + singlyList.size() + "   " + "指定删除第一处");
        //删除
        singlyList.remove(0);
        System.out.println(singlyList.toString());
        System.out.println("单链表长度为：" + singlyList.size());
        //查找
        System.out.println("能否查找到：刘杰   是则输出数据，否则输出null");
        System.out.println(singlyList.get(singlyList.search("{name:'刘杰', telephone:19888888888}")));
    }
}
