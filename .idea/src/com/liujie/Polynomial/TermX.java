package com.liujie.Polynomial;
import com.liujie.Polynomial.TermX;
/**
 * @author ❤ Euphoria ❤
 * @title TermX
 * @projectName data structure
 * @description: 一元多项式的项类
 * @date 2021/10/24   19:15
 */
public class TermX implements Comparable<TermX>, Addible<TermX> {
    protected int coef, xexp;

    //构造函数
    public TermX(int coef, int xexp) {

        this.coef = coef;
        this.xexp = xexp;
    }

    //拷贝构造
    public TermX(TermX term) {
        coef = term.coef;
        xexp = term.xexp;
    }

    @Override
    public String toString() {

        if (coef == 1 && xexp > 0) return "x^" + xexp;
        if (coef == -1 && xexp > 0) return "-x^" + xexp;
        if (xexp == 1) return coef + "x";
        if (xexp == 0) return coef+"";
        return coef + "x^" + xexp;
    }

    //按系数和指数比较两项是否相等
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(obj instanceof TermX&&this.xexp==((TermX) obj).xexp&&this.coef== ((TermX) obj).coef)return true;
        return false;
    }

    //按x指数比较两项大小，实现 Comparable<TermX>
    //如果新小-1，新大1
    @Override
    public int compareTo(TermX o) {
        if(this.coef==o.coef)
            return 0;
        if (this.xexp < o.xexp){
            return -1;
        }
        else if (this.xexp == o.xexp){
            return 0;
        }
        else {
            return 1;
        }
    }

    //相加，this+=term，若指数相同，则系数相加， ->Addible<TermX>
    @Override
    public void add(TermX tobj) {
      if(this.xexp==tobj.xexp){
          this.coef+=tobj.coef;
      }
    }

    //若系数为0，则删除元素，-> Addible<TermX>
    //可相加则true
    @Override
    public boolean removable() {
        if (coef == 0) return true;
        return false;
    }
}
