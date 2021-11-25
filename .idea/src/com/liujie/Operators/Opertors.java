package com.liujie.Operators;

import com.liujie.list.SeqList;

/**
 * @author: ❤ Euphoria ❤
 * @title: Opertors
 * @projectName data structure
 * @description:  运算符集合类
 * @date 2021/11/6  16:22
 */

public class Opertors implements java.util.Comparator<String>
{ //运算符
   private String[] operator={"*","/","%","+","-","&","^","|"};
   //运算符优先级
    private int[] priority={3,3,3,4,4,8,9,10};
    private SeqList<String> operlist;
    public Opertors(){
        this.operlist=new SeqList<String>(this.operator);
    }

    @Override
    public int compare(String o1, String o2) {
        int i=operlist.search(o1),j=operlist.search(o2);
        return  this.priority[i]-this.priority[j];
    }
    //运算
    public int operate(int x,int y,String oper){
        int value=0;
        switch(oper)
        {
            case "+": value =x+y;break;
            case "-": value =x-y;break;
            case "*": value =x*y;break;
            case "/": value =x/y;break;
            case "%": value =x%y;break;
            case "&": value =x&y;break;
            case "^": value =x^y;break;
            case "|": value =x|y;break;
        }
        return value;
    }

}
