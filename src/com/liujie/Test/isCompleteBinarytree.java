package com.liujie.Test;
import com.liujie.list.*;


/**
 * @author: ❤ Euphoria ❤
 * @title: isCompleteBinarytree
 * @projectName data structure
 * @description: 完全二叉树判断测试
 * @date 2021/11/14  15:20
 */

public class isCompleteBinarytree {
    public static void main(String[] args) {
        String[] prelist1 = {"a", "b", "d",null,null,"e",null,null, "c",null,null,null};//完全二叉树
        String[] prelist2={"a", "b", "d",null,null,null, "c","e",null,null,null};
        BinaryTree<String> bit1=new BinaryTree<String>(prelist1);
        BinaryTree<String> bit2=new BinaryTree<String>(prelist2);
        //层次遍历
        bit1.levelorder();
        bit2.levelorder();





    }

}
