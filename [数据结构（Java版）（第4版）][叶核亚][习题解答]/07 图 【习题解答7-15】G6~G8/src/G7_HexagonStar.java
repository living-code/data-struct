//《数据结构（Java版）（第4版）习题解答》，作者：叶核亚，2015年8月12日
//7.4.2   最小生成树的构造算法
//【习7-15】 带权无向图G6，G7_Hexagon表示7个顶点，正六边星形
//【习题解答7-15，课件】 Prim算法
//7.5.1 单源最短路径，Dijkstra算法
//【试题7】Dijkstra算法

public class G7_HexagonStar 
{
    public static void main(String args[])
    {
        String graphname="G7_HexagonStar";
        String[] vertices={"A","B","C","D","E","F","G"};
        Triple[] edges={new Triple(0,1,7),  new Triple(0,5,13), new Triple(0,6,6),
                        new Triple(1,0,7),  new Triple(1,2,12), new Triple(1,6,4),
                        new Triple(2,1,12), new Triple(2,3,5),  new Triple(2,6,19), 
                        new Triple(3,2,5),  new Triple(3,4,11), new Triple(3,6,20),
                        new Triple(4,3,11), new Triple(4,5,10), new Triple(4,6,16),
                        new Triple(5,0,13), new Triple(5,4,10), new Triple(5,6,15),
                        new Triple(6,0,6),  new Triple(6,1,4),  new Triple(6,2,19),
                        new Triple(6,3,20), new Triple(6,4,16), new Triple(6,5,15)};
//        MatrixGraph<String> graph = new MatrixGraph<String>(vertices, edges);
      AdjListGraph<String> graph = new AdjListGraph<String>(vertices, edges);     //邻接表表示的图
//        System.out.print("带权无向图"+graphname+"，"+graph.toString());

        System.out.print("广度优先遍历图"+graphname+"：");
        for (int i=0; i<graph.vertexCount(); i++)
            graph.BFSTraverse(i);
        
/*        System.out.print("带权无向图"+graphname+"，prim算法：");
        graph.minSpanTree();

        System.out.print("带权无向图"+graphname+"，Dijkstra算法：");
        for (int i=0; i<graph.vertexCount(); i++)
            graph.shortestPath(i);               //顶点vi的单源最短路径，Dijkstra算法
            */
    }
}
/*
程序运行结果如下：
带权有向图G6_G7_Hexagon，顶点集合：SeqList(A, B, C, D, E, F, G) 
邻接矩阵:  
     0     7     ∞     ∞     ∞    13     6
     7     0    12     ∞     ∞     ∞     4
     ∞    12     0     5     ∞     ∞    19
     ∞     ∞     5     0    11     ∞    20
     ∞     ∞     ∞    11     0    10    16
    13     ∞     ∞     ∞    10     0    15
     6     4    19    20    16    15     0
     出边表：
0 -> ((0,1,7),(0,5,13),(0,6,6))
1 -> ((1,0,7),(1,2,12),(1,6,4))
2 -> ((2,1,12),(2,3,5),(2,6,19))
3 -> ((3,2,5),(3,4,11),(3,6,20))
4 -> ((4,3,11),(4,5,10),(4,6,16))
5 -> ((5,0,13),(5,4,10),(5,6,15))
6 -> ((6,0,6),(6,1,4),(6,2,19),(6,3,20),(6,4,16),(6,5,15))

广度优先遍历图G7_HexagonStar：{ A B F G C E D } 
{ B A C G F D E } 
{ C B D G A E F } 
{ D C E G B F A } 
{ E D F G C A B } 
{ F A E G B D C } 
{ G A B C D E F } 

prim算法：
mst边集合：(0,1,7),(0,2,99999),(0,3,99999),(0,4,99999),(0,5,13),(0,6,6),
mst边集合：(0,6,6),(6,2,19),(6,3,20),(6,4,16),(0,5,13),(6,1,4),
mst边集合：(0,6,6),(6,1,4),(6,3,20),(6,4,16),(0,5,13),(1,2,12),
mst边集合：(0,6,6),(6,1,4),(1,2,12),(6,4,16),(0,5,13),(2,3,5),
mst边集合：(0,6,6),(6,1,4),(1,2,12),(2,3,5),(0,5,13),(3,4,11),
mst边集合：(0,6,6),(6,1,4),(1,2,12),(2,3,5),(3,4,11),(4,5,10),
最小生成树的边集合：(0,6,6) (6,1,4) (1,2,12) (2,3,5) (3,4,11) (4,5,10) ，最小代价为48

Dijkstra算法：
A的单源最短路径：(A,B)长度7，(A,B,C)长度19，(A,B,C,D)长度24，(A,G,E)长度22，(A,F)长度13，(A,G)长度6，
B的单源最短路径：(B,A)长度7，(B,C)长度12，(B,C,D)长度17，(B,G,E)长度20，(B,G,F)长度19，(B,G)长度4，
C的单源最短路径：(C,B,A)长度19，(C,B)长度12，(C,D)长度5，(C,D,E)长度16，(C,D,E,F)长度26，(C,B,G)长度16，
D的单源最短路径：(D,C,B,A)长度24，(D,C,B)长度17，(D,C)长度5，(D,E)长度11，(D,E,F)长度21，(D,G)长度20，
E的单源最短路径：(E,G,A)长度22，(E,G,B)长度20，(E,D,C)长度16，(E,D)长度11，(E,F)长度10，(E,G)长度16，
F的单源最短路径：(F,A)长度13，(F,G,B)长度19，(F,E,D,C)长度26，(F,E,D)长度21，(F,E)长度10，(F,G)长度15，
G的单源最短路径：(G,A)长度6，(G,B)长度4，(G,B,C)长度16，(G,D)长度20，(G,E)长度16，(G,F)长度15，
                        
*/
//@author：Yeheya。2015-8-12

