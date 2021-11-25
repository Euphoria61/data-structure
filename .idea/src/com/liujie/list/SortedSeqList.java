package com.liujie.list;

/**
 * @author ❤ Euphoria ❤
 * @title com.liujie.list.SortedSeqList
 * @projectName data structure
 * @date 2021/10/15   8:57
 */
public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T> {
    public SortedSeqList()            //构造空表
    {
        super();                                   //默认调用SeqList()
    }

    public SortedSeqList(int length) //构造空表，容量为length
    {
        super(length);                          //调用SeqList(length)
        //若省略，默认调用super()
    }

    public SortedSeqList(T[] values) //构造排序顺序表，由数组提供元素，
    {
        super(values.length);
        for (T value : values) this.insert(value);         //插入元素
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    // 不支持父类的以下成员方法，将其覆盖并抛出异常
    public void set(int i, T x)           //排序顺序表的教据元素具有只读特性，不支持
    {
        throw new java.lang.UnsupportedOperationException("set(int i, T x)");
    }

    @Override
    public int insert(int i, T x) {
        throw new java.lang.UnsupportedOperationException("insert (int i, T x)");
    }  //覆盖父类插入

    public int insert(T x) {
        int i = 0;
        if (this.isEmpty() || x.compareTo(this.get(this.n - 1)) > 0)
            i = this.n;
        else
            while (i < this.n &&  x.compareTo(this.get(i)) > 0)
                i++;
        super.insert(i, x);
        return i;
    } //重写 插入


//    public int search(T key) {
//
//        for (int i = 0; i < this.n && key.compareTo(this.
//                get(i)) >= 0; i++)
//            if (key.compareTo(this.get(i)) == 0) //对象相等，运行时多态
//                return i;//返回元素序号i(a<1<n)
//        return -1; //空表或未找到时查找不成功，则返回-1,O(n)
//    }    // 顺序查找首个与key 相等的无素，由 key 的 compareTa()方法确定元素的大小和相等;

    public T move(T key) {
        return this.remove(this.search(key));
    }//删除


}
