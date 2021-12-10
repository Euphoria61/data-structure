package com.liujie.Test;

import com.liujie.Operators.*;

/**
 * @author: ❤ Euphoria ❤
 * @title: ArithETest
 * @projectName data structure
 * @description: 算数运算符表达式及运算
 * @date 2021/11/7  13:35
 */

public class ArithETest {
    public static void main(String[] args) {
        String infix="1+2*(6-4)+3|(4-3)";
        new ArithExpression(infix);
    }
}
