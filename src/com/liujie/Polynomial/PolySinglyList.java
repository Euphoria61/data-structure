package com.liujie.Polynomial;

import com.liujie.list.Node;
import com.liujie.list.SortedSinglyList;

/**
 * @author ❤ Euphoria ❤
 * @title PolySinglyList
 * @projectName data structure
 * @description: 多项式排序单链表类
 * @date 2021/10/24   19:11
 */
public class PolySinglyList<TermX extends Comparable<? super TermX> & Addible<? super TermX>> extends SortedSinglyList<TermX> {
    public PolySinglyList(boolean asc) {
        super(asc);
    }

    public PolySinglyList() {
    }

    public PolySinglyList(TermX[] values, boolean asc) {
        super(values, asc);
    }

    public PolySinglyList(TermX[] values) {
        super(values);
    }

    //多项式相加，this+=list，不改变list。this，list的升降序必须一致。 重载
    public void addAll(PolySinglyList<TermX> list) {
        Node<TermX> front = this.head;
        Node<TermX> p = front.next;
        Node<TermX> q = list.head.next;
        while (p != null) {
            //p,q指数相同，系数相加
            if (p.data.compareTo(q.data) == 0) {
                p.data.add(q.data);
                //(b)若相加后系数为0，则删除p节点，再使p指向原p的后继节点,q 都向后移动一个节点
                if (p.data.removable()) {
                    p = p.next;
                    front.next = p;
                    q = q.next;
                }
                //（a）
                p = p.next;
                front = front.next;
                q = q.next;
            }

            //（c）若p指数较小，则使front，p向后移动，q不移动
            else if (p.data.compareTo(q.data) < 0) {
                p = p.next;
                front = front.next;
            } else {
//                （d）若p指数较大，则复制q节点并插到p之前；再使front，q向后移动呢
                Node<TermX> temp = new Node<>(q.data, null);
                temp.next = p;
                front.next = temp;
                front = front.next;
                q = q.next;
            }
        }
        while (q != null) {
            Node<TermX> temp = new Node<>(q.data, null);
            front.next = temp;
            front = front.next;
            q = q.next;
//
        }

    }
}
    


