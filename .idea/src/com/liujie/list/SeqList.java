package com.liujie.list;

/**
 * @author ❤ Euphoria ❤
 * @title: com.liujie.list.SeqList
 * @projectName data structure
 * @date 2021/10/14  15:42
 */
public class SeqList<T> extends Object {

    public Object[] element;  //对象数组
    public int n;            //元素个数（长度）
    private static final int MIN_CAPACITY = 16;

    //构造空表
    public SeqList(int length) {
        if (length < MIN_CAPACITY) length = MIN_CAPACITY;
        this.element = new Object[length];
        this.n = 0;
    }

    public SeqList()                       //构造方法重载
    {
        this(MIN_CAPACITY);                  //调用本类指定参数列表的构造方法
    }

    //构造顺序表,由values数组提供元素
    public SeqList(T[] values) {
        this(values.length * 2);
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                this.element[this.n++] = values[i];
            }
        }
    }

    //判断是否空
    public boolean isEmpty() {
        return this.n == 0;
    }

    //返回元素个数
    public int size() {
        return this.n;
    }

    //返回描述字符串
    public String toString() {
        String str = this.getClass().getName() + "(";//返回类名
        if (this.n > 0)
            str += this.element[0].toString();
        for (int i = 1; i < this.n; i++)
            str += ", " + this.element[i].toString();
        //执行T类的toString()方法，运行时多态
        return str + ") ";                            //空表返回()
    }

    //返回第i个元素
    public T get(int i) {
        if (i >= 0 && i < this.n) {
            return (T) this.element[i];
        }
        return null;
    }

    //设置第i个元素为x
    public void set(int i, T x) {
        if (x == null) throw new NullPointerException("x==null");
        if (i >= 0 && i < this.n) {
            this.element[i] = x;

        } else throw new IndexOutOfBoundsException(i + "");
    }

    //插入
    public int insert(int i, T x) {
        if (x == null)
            return -1;
        if (i < 0)
            i = 0;
        if (i > this.n)
            i = this.n;
        //数据溢出
        Object[] source = this.element;
        if (this.n == element.length) {
            this.element = new Object[source.length * 2];
            for (int j = 0; j < i; j++) {
                this.element[j] = source[j];
            }
        }
        for (int j = this.n - 1; j >= i; j--)
            this.element[j + 1] = source[j];
        this.element[i] = x;
        this.n++;
        return i;
    }

    public int insert(T x) {
        return this.insert(this.n, x);
    }

    //TODO 越界未处理
    //删除元素
    public T remove(int i) {
        if (i >= 0 && i < this.n) {
            T x = (T) this.element[i];
            for (int j = i; j < this.n - 1; j++)
                this.element[j] = this.element[j + 1];
            this.element[this.n - 1] = null;
            this.n--;
            return x;
        }
        return null;
    }

    //删除所有元素
    public void clear() {
        this.n = 0;
    }

    //查找
    public int search(T key) {
        for (int i = 0; i < this.n; i++)
            if (key.equals((this.element[i].toString())))
                return i;
            return -1;
    }

}
