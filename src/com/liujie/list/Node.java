package com.liujie.list;

/**
 * @author ❤ Euphoria ❤
 * @title: com.liujie.list.Node
 * @projectName data structure
 * @date 2021/10/14  15:44
 */
public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node() {
        this(null, null);
    }


}


