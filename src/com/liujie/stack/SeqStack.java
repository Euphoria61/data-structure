package com.liujie.stack;

import com.liujie.list.SeqList;

/**
 * @author: ❤ Euphoria ❤
 * @title: SeqStack
 * @projectName data structure
 * @description:  顺序栈  实现栈接口
 * @date 2021/11/6  17:46
 */

public final class SeqStack<T> implements Stack<T>{
    //顺序栈
    private SeqList<T> list;
    //构造空栈
    public SeqStack(int length){
        this.list=new SeqList<T>(length);
    }
    //默认容量
    public SeqStack(){
        this(64);
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
    //入栈
    @Override
    public void push(T x) {
        this.list.insert(x);
    }
    //返回栈顶元素
    public T peek(){
        return this.list.get(list.size()-1);
    }
    //非空删除表尾元素并返回
    @Override
    public T pop() {
        return this.list.remove(list.size()-1);
    }
    //public String toString(){};
}
