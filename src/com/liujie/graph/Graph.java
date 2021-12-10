package com.liujie.graph;

public interface Graph<T> {
    int vertexCount();
    T get(int i);
    void set(int i ,T X);
    int insert(T x);
    int search(T key);

}
