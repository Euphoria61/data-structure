package com.liujie.list;

import java.util.Arrays;

/**
 * @author: ❤ Euphoria ❤
 * @title: SeqQueue
 * @projectName data structure
 * @description: 顺序循环队列类
 * @date 2021/11/14  16:32
 */

public final class SeqQueue<T> implements Queue<T>{
    private Object element[];
    private int front,rear;
    private  static  final  int MIN_CAPACITY=16;
    //构造空队列
    public SeqQueue(int length){
        if(length<MIN_CAPACITY)
            length=MIN_CAPACITY;
        this.element=new Object[length];
        this.front=this.rear=0;
    }
    public SeqQueue(){
        this(MIN_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return this.front==this.rear;
    }

    @Override
    public boolean add(T x) {
        if (x == null)
            return false;
        //若队列满则扩充队列
        if (this.front == (this.rear + 1) % this.element.length) {
            Object[] temp = this.element;
            this.element = new Object[temp.length * 2];
            int j = 0;
            for (int i = this.front; i != this.rear; i = (i + 1) % temp.length)
                this.element[i++] = temp[i];
                this.front = 0;
                this.rear = j;
            }
            this.element[this.rear] = x;
            this.rear = (this.rear + 1) % this.element.length;
            return true;
        }

    @Override
    public T peek() {
        return this.isEmpty()?null:(T)this.element[this.front];
    }

    @Override
    public T poll() {
        if(this.isEmpty())
        return null;
        T temp=(T)this.element[this.front];
        this.front=(this.front+1)%this.element.length;
        return temp;
    }

    @Override
    public String toString() {
        return "SeqQueue{" +
                "element=" + Arrays.toString(element) +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }
}
