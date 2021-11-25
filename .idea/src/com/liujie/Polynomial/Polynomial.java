package com.liujie.Polynomial;

import com.liujie.list.Node;

/**
 * @author ❤ Euphoria ❤
 * @title Polynomial
 * @projectName data structure
 * @description: 多项式类
 * @date 2021/10/24   19:40
 */
public class Polynomial extends PolySinglyList {
    private PolySinglyList<TermX> list;

    public Polynomial(boolean asc) {
    }

    public Polynomial() {
    }

    public Polynomial(TermX[] terms, boolean asc) {
        super(terms, asc);

    }

    public Polynomial(String polystr) {

    }

    public Polynomial(Polynomial poly) {
        this(poly.list.asc);   //创建空单链表，复制升降序属性
        Node<TermX> rear = this.list.head;//声明尾指针
        for (Node<TermX> p = poly.list.head.next; p != null; p = p.next) {   //p遍历poly单链表
            rear.next = new Node<TermX>(new TermX(p.data), null); //复制结点，复制对象
            rear = rear.next;
        }
    }

    //    public boolean equals(Object obj){
//    };
//    多项式相加,this+=poly
    public void addAll(Polynomial poly) {
        super.addAll(poly);
    }

    //多项式加法，返回this+poly的多项式
    public String toString() {
        String str = "";
        for (Node<TermX> p = this.head.next; p != null; p = p.next) {
            str += p.data.toString() + (p.next != null && p.next.data.coef > 0 ? "+" : "");
        }
        return str;
    }


//    public Polynomial union(Polynomial poly){};
    //多项式相乘，this*=poly
//    public void multi(Polynomial poly) {
//
//    }
}
