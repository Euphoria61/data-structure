package com.liujie.list;

/**
 * @author ❤ Euphoria ❤
 * @title com.liujie.list.SortedSinglyList
 * @projectName data structure
 * @date 2021/10/16   10:49
 */
public class SortedSinglyList<T extends Comparable<? super T>> extends SinglyList<T> {
    public boolean asc;

    public SortedSinglyList(boolean asc)  //构造空表，asc指定升/降序
    {
        super();                                       //调用父类构造方法SinglyList()
        this.asc = asc;
    }

    public SortedSinglyList()                //构造空表，默认升序
    {
        this(true);
    }

    public SortedSinglyList(T[] values, boolean asc) {
        if(asc) {
            for (int i = 0; i < values.length; i++) {
                this.insert(values[i]);
            }
        }
        else  for (int i = 0; i < values.length; i++) {
               this.insert(values[values.length-i-1]);
        }


    }//构造，按值插入

    public SortedSinglyList(T[] values) {

    }     //构造，按值插入，升序

    public Node<T> insert(T x) {
        if (x == null)
            return null;
        Node<T> front = this.head, p = front.next;
        while (p != null && (this.asc ? x.compareTo(p.data) <= 0 : x.compareTo(p.data) > 0)) {
            front = p;
            p = p.next;
        }
        front.next = new Node<>(x, p);
        return front.next;
    }
}
