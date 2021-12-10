package com.liujie.Operators;


import com.liujie.stack.LinkedStack;
import com.liujie.stack.SeqStack;
import com.liujie.stack.Stack;

/**
 * @author: ❤ Euphoria ❤
 * @title: ArithExpression
 * @projectName data structure
 * @description: 算数表达式类
 * @date 2021/11/6  17:16
 */

public class ArithExpression {
    private static Opertors opertors;

    static {
        opertors = new Opertors();
    }

    public ArithExpression(String infix) {
        //转换成后缀表达式
        StringBuffer postfix = toPostfix(infix);
        System.out.println("postfix=\"" + postfix + "\"\nvalue=" + toValue(postfix));
    }

    //转换成后缀表达式
    public StringBuffer toPostfix(String infix) {
        //运算符栈
        Stack<String> stack = new SeqStack<String>(infix.length());
        //后缀表达式字符串
        StringBuffer postfix = new StringBuffer(infix.length() * 2);
        int i = 0;
        while (i < infix.length()) {
            char ch = infix.charAt(i);
            if (ch >= '0' && ch <= '9') {
                while (i < infix.length() && (ch = infix.charAt(i)) >= '0' && ch <= '9') {
                    postfix.append(ch + "");
                    i++;
                }
                postfix.append(" ");
            } else {
                switch (ch) {
                    case ' ': //跳过空格
                        i++;
                        break;
                    case '(': //左括号入栈
                        stack.push(ch + "");
                        i++;
                        break;
                    case ')':  //右括号出栈  直到出栈为左括号
                        String out = "";
                        while ((out = stack.pop()) != null && !out.equals("(")) postfix.append(out);
                        i++;
                        break;
                    default:   //将要入栈元素与栈顶运算优先级比较，若高则栈顶元素出栈并加入后缀表达式
                        while (!stack.isEmpty() && !stack.peek().equals("(") && opertors.compare(ch + "", stack.peek()) >= 0)
                            postfix.append(stack.pop());
                        stack.push(ch + "");
                        i++;
                }
            }
        }
        while(!stack.isEmpty())
            postfix.append(stack.pop());
            return postfix;
    }
    //运算
    public int toValue(StringBuffer postfix){
        Stack<Integer> stack=new LinkedStack<Integer>();
        int value=0;
        for (int i = 0; i < postfix.length(); i++) {
            char ch=postfix.charAt(i);
            if(ch>='0'&&ch<='9')
            {
                value=0;
                while(ch>='0'&&ch<='9'){
                    value=value*10+ch-'0';
                    ch=postfix.charAt(++i);

                }
                stack.push(value);
            }
            else
            {
                if(ch!=' '){
                    int y=stack.pop(), x=stack.pop();
                    value=opertors.operate(x,y,ch+"");
                    System.out.println(x+(ch+"")+y+"="+value+", ");
                    stack.push(value);
                }
            }
        }
        return stack.pop();
    }



}
