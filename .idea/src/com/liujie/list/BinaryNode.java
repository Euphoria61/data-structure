package com.liujie.list;

/**
 * @author: ❤ Euphoria ❤
 * @title: BinaryNode
 * @projectName data structure
 * @description:  二叉链表结点类
 * @date 2021/11/14  14:47
 */

public class BinaryNode<T>{
    public T data;
    public BinaryNode<T> left,right;
    //构造函数
    public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right){
        this.data=data;
        this.left=left;
        this.right=right;

    }
    //构造元素为data的叶子结点
    public BinaryNode(T data){
    this.data=data;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    //判断是否为叶子结点
    public boolean isLeaf(){
        if(this.left==null&&this.right==null){
            return true;
        }
        return false;
    }
}
