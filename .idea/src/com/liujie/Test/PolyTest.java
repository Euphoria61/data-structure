package com.liujie.Test;

import com.liujie.Polynomial.Polynomial;
import com.liujie.Polynomial.TermX;


/**
 * @author: ❤ Euphoria ❤
 * @title: PolyTest
 * @projectName data structure
 * @description: 一元多项式测试
 * @date 2021/11/7  13:44
 */

public class PolyTest {
    public static void main(String[] args) {
        TermX[] atermx = {new TermX(-2, 6), new TermX(3, 3)
                , new TermX(1, 0), new TermX(2, 1),new TermX(4,2)};
        TermX[] btermx = {new TermX(3, 6), new TermX(3, 3)
                , new TermX(-1, 0), new TermX(7, 5)};
        Polynomial apolynomial=new Polynomial(atermx,true);
        Polynomial bpolynomial=new Polynomial(btermx,true);
        System.out.println("A="+apolynomial.toString());
        System.out.println("B="+bpolynomial.toString());
        apolynomial.addAll(bpolynomial);
        System.out.println("A+B="+apolynomial.toString());

    }
}
