package com.liujie.list;

/**
 * @author ❤ Euphoria ❤
 * @title com.liujie.list.SinglyList
 * @projectName data structure
 * @date 2021/10/14   15:45
 */
public class SinglyList<T> extends Object {
    public Node<T> head;
    public int n;
    public Node<T> next;

    public SinglyList() {                    //构造空单链表
        this.head = new Node<>();
    }

    //构造单链表
    public SinglyList(T[] values) {
        this();//创建空单链表
        Node<T> rear = this.head;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                rear.next = new Node<>(values[i], null);
                rear = rear.next;
            }
        }
    }

    //返回第i个元素
    public T get(int i) {
        Node<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++)
            p = p.next;
        return (i >= 0 && p != null) ? p.data : null;
    }

    //返回字符串
    @Override
    public String toString() {
        String str =  "(";
        for (Node<T> p = this.head.next; p != null; p = p.next)
            str += p.data.toString() + (p.next != null ? "-->" : "");
        return str + ")";
    }

    //单链表插入（头，中，尾部）
    public Node<T> insert(int i, T x) {
        if (x == null)
            throw new NullPointerException("x==null");
        Node<T> front = this.head;
        for (int j = 0; front.next != null && j < i; j++) front = front.next;
        front.next = new Node<T>(x, front.next);
        return front.next;
    }
    public Node<T> insert(T x){
        return insert(Integer.MAX_VALUE,x);
    }

    //删除
    public T remove(int i) {
        Node<T> front = this.head;
        for (int j = 0; front.next != null && j < i; j++) front = front.next;
        if (i >= 0 && front.next != null) {
            T x = front.next.data;
            front.next = front.next.next;
            return x;
        }
        return null;
    }

    //判空
    public boolean isEmpty() {
        return this.head.next == null;
    }

    //长度
    public int size() {

        Node p = this.head.next;
        int lenth = 0;
        while (p != null) {
            p = p.next;
            lenth++;
        }
        return lenth;

    }

    //查找
    public int search(T key) {
        Node<T> front = this.head;
        for (int j = 0; front.next != null; j++){ front = front.next;
        if (key.equals((front.data.toString())))
            return j;}
        return -1;
    }

}

