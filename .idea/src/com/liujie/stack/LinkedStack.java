package com.liujie.stack;

import com.liujie.list.SinglyList;

/**
 * @author: ❤ Euphoria ❤
 * @title: LinkedStack
 * @projectName data structure
 * @description:    链式栈
 * @date 2021/11/6  17:52
 */

public final class LinkedStack<T> implements Stack<T> {
    private SinglyList<T> list;
    //构造空单链表
    public LinkedStack() {
        this.list = new SinglyList<T>();
    }
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
    //表头插入   入栈
    @Override
    public void push(T x) {
        this.list.insert(0, x);
    }
    //返回表头元素
    @Override
    public T peek() {
        return this.list.get(0);
    }
    //出栈  表头元素删除元素
    @Override
    public T pop() {
        return this.list.remove(0);
    }
}
