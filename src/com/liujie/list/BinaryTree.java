package com.liujie.list;
import com.liujie.list.*;
/**
 * @author: ❤ Euphoria ❤
 * @title: BinaryTree
 * @projectName data structure
 * @description: 二叉树类
 * @date 2021/11/14  14:56
 */

public class BinaryTree<T> {
    public BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }


    //插入新根结点
    public void insert(T x) {
        if (x != null)
            this.root = new BinaryNode<>(x, this.root, null);
    }

    public BinaryNode<T> insert(BinaryNode<T> p, boolean left, T x) {
        if (x == null || p == null)
            return null;
        if (left)
            return p.left = new BinaryNode<T>(x, p.left, null);
        return p.right = new BinaryNode<T>(x, null, p.right);
    }

    //删除左子树或右子树
    public void remove(BinaryNode<T> p, boolean left) {
        if (p != null) {
            if (left)
                p.left = null;
            else p.right = null;
        }
    }

    //删除所有结点，包括根结点
    public void clear() {
        this.root = null;
    }

    //先根次序遍历 递归
    public void preorder() {
        preorder(this.root);
        System.out.println();
    }

    public void preorder(BinaryNode<T> p) {
        if (p != null) {
            System.out.println(p.data.toString() + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }
    //构造二叉树 递归
    public BinaryTree(T[] prelist) {
        this.root = create(prelist);
    }

    private int i = 0;

    private BinaryNode<T> create(T[] prelist) {
        BinaryNode<T> p = null;
        if (i < prelist.length) {
            T elem = prelist[i++];
            if (elem != null) {
                p = new BinaryNode<T>(elem);
                p.left = create(prelist);
                p.right = create(prelist);
            }
        }
        return p;
    }
    //层次遍历   队列
    // 判断完全二叉树
    public void levelorder() {
        boolean isLeaf = false;
        boolean flag = true;
        if (this.root == null){
            return;}
        Queue<BinaryNode<T>> que = new LinkedQueue<>();
        que.add(this.root);
        while (!que.isEmpty()) {
            BinaryNode<T> p = que.poll();
            System.out.println(p.data + " ");
            if (p.left != null)
                que.add(p.left);
            if (p.right != null)
                que.add(p.right);
            //若为叶子结点但仍有孩子结点 false
            if (isLeaf && (p.left != null || p.right != null))
                flag = false;
            //若左孩子为空但有孩子不为空  false
            if (p.left == null && p.right != null)
                flag = false;
            //判定叶子结点
            if (p.right == null)
                isLeaf = true;
        }
        if (flag)
            System.out.println("是完全二叉数");
        else
            System.out.println("不是完全二叉数");
    }

}
