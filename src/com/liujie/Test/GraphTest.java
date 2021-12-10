package com.liujie.Test;

import com.liujie.graph.AbstractGraph;
import com.liujie.graph.Matrix;
import com.liujie.graph.MatrixGraph;
import com.liujie.graph.Triple;

public class GraphTest {
    public static void main(String[] args) {
        String[] vertexes ={"杭电信工","青山湖地铁站","余杭","西湖区","上城区","滨江区"};
        Triple[] edges ={
                new Triple(0,1,3),
                new Triple(0,3,12),
                new Triple(1,2,4),
                new Triple(1,5,11),
                new Triple(2,3,5),
                new Triple(3,4,4),
                new Triple(4,5,2),
                new Triple(3,5,4),
        };
        MatrixGraph<String> graph = new MatrixGraph<String>(vertexes, edges);
        System.out.println(graph.toString());
        System.out.println("最佳线路：");
        //杭电信工--》余杭
        graph.shortestPath(0,2);
        graph.shortestPath(1,0);
        graph.shortestPath(0,5);
        //
    }
}
