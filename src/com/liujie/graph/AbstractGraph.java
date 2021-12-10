package com.liujie.graph;

import com.liujie.list.SeqList;
import com.liujie.list.SinglyList;

//抽象图类
public abstract class AbstractGraph<T> implements Graph<T> {
    protected static final int MAX_WEIGHT = 0X0000fffff; //最大权值
    protected SeqList<T> vertexlist; //定点顺序表
    protected MatrixGraph matrixGraph;

    public AbstractGraph() {
        this.vertexlist = new SeqList<T>(); // 构造空顺序表，默认容量
    }

    public int vertexCount() {
        return this.vertexlist.size();
    }

    public String toString() {
        return "顶点顺序表:" + this.vertexlist.toString() + "\n";
    }

    public T get(int i) {
        return this.vertexlist.get(i);
    }

    public void set(int i, T x) {
        this.vertexlist.set(i, x);

    }

    public int search(T key) {
        return this.vertexlist.search(key);
    }

    public int weight(int i, int j) {
        return this.matrixGraph.weight(i, j);
    }


    //Floyd算法求最短路径及其路径长度  公交线路图
    public void shortestPath(int start ,int end) {
        int n = this.vertexCount();
        int[][] path = new int[n][n], dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = this.weight(i, j);
                path[i][j] = (i != j && dist[i][j] < MAX_WEIGHT) ? i : -1;
            }
        }
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                if (i != k)
                    for (int j = 0; j < n; j++)
                        if (j != k && j != i && dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            path[i][j] = path[k][j];
                        }
        System.out.println(toPath(path[start], start, end)  + "  "+ (dist[start][end] == MAX_WEIGHT ?"暂无线路" :"票价:"+ dist[start][end]));
    }
    public String toPath(int[] path, int i, int j) {
        SinglyList<T> link = new SinglyList<T>();
        link.insert(this.get(j));
        for (int k = path[j]; k != i && k != j && k != -1; k=path[k])
            link.insert(0, this.get(k));
        link.insert(0, this.get(i));
        return link.toString();
    }
}
