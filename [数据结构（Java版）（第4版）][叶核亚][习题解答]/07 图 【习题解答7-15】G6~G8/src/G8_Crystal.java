//《数据结构（Java版）（第4版）习题解答》，作者：叶核亚，2015年3月15日
//7.2  图的表示和实现
//【习题解答7-15，课件】 带权无向图G7，输出图的邻接矩阵表示和邻接表表示；删除D操作，输出图的邻接矩阵表示和邻接表表示
//【习题解答7-15，课件】 带权无向图G7，深度优先遍历，画栈；广度优先遍历，画队列

public class G8_Crystal
{
    public static void main(String args[])
    {
        String graphname="G8_Crystal";
        String[] vertices={"A","B","C","D","E","F","G","H"};
        Triple[] edges={new Triple(0,1,12), new Triple(0,2,31),
                        new Triple(1,0,12), new Triple(1,3,23), 
                        new Triple(2,0,31), new Triple(2,3,15),
                        new Triple(3,1,23), new Triple(3,2,15), new Triple(3,4,11), new Triple(3,5,4),
                        new Triple(4,3,11), new Triple(4,5,5),  new Triple(4,6,27), 
                        new Triple(5,3,4),  new Triple(5,4,5),  new Triple(5,6,63), new Triple(5,7,17),
                        new Triple(6,4,27), new Triple(6,5,63), new Triple(6,7,18),
                        new Triple(7,5,17), new Triple(7,6,18)};
        MatrixGraph<String> graph = new MatrixGraph<String>(vertices, edges);
//        AdjListGraph<String> graph = new AdjListGraph<String>(vertices, edges);     //邻接表表示的图
        System.out.print("带权无向图"+graphname+"，"+graph.toString());//输出图的邻接矩阵表示和邻接表表示

/*        int i=3;
        System.out.print("删除顶点"+graph.getVertex(i));
        graph.removeVertex(i);                                //删除顶点D
        System.out.println("，"+graph.toString());*/

        //7.3   图的遍历深度优先遍历，画栈；广度优先遍历，画队列
        Triple[] deleteEdges={new Triple(4,5,5),  new Triple(5,4,5), 
                              new Triple(5,6,63), new Triple(6,5,63), 
                              new Triple(6,7,18), new Triple(7,6,18)};
        for (int i=0; i<deleteEdges.length; i++)
            graph.removeEdge(deleteEdges[i]);               //删除边
        System.out.println("删除边(E,F)，(F,G)，(G,H)，"+graph.toString());

/*        System.out.println("深度优先遍历连通无向图G7：");      //【习题解答7-15，4-0卷】
        for (int i=0; i<graph.vertexCount(); i++)
            graph.DFSTraverse(i);
*/
        System.out.println("广度优先遍历连通图无向图G7：");
        for (int i=0; i<graph.vertexCount(); i++)
            graph.BFSTraverse(i);
        
/*        //7.4.2   最小生成树的构造算法 
        System.out.print("带权无向图"+graphname+"，prim算法：");
        graph.minSpanTree();                //prim   //没有删除结点 
        for (int i=0; i<graph.vertexCount(); i++)
            graph.shortestPath(i);               //顶点vi的单源最短路径，Dijkstra算法

        //7.5.1   非负权值的单源最短路径（Dijkstra算法）//没有删除结点  
        System.out.print("带权无向图"+graphname+"，Dijkstra算法：");
        for (int i=0; i<graph.vertexCount(); i++)       //图10.6
            graph.shortestPath(i);               //顶点vi的单源最短路径，Dijkstra算法
*/        
    }
}
/*
程序运行结果如下：
                                               //MatrixGraph<String>
带权无向图G7，顶点集合：SeqList(A, B, C, D, E, F, G, H) 
邻接矩阵:  
     0    12    31     ∞     ∞     ∞     ∞     ∞
    12     0     ∞    23     ∞     ∞     ∞     ∞
    31     ∞     0    15     ∞     ∞     ∞     ∞
     ∞    23    15     0    11     4     ∞     ∞
     ∞     ∞     ∞    11     0     5    27     ∞
     ∞     ∞     ∞     4     5     0    63    17
     ∞     ∞     ∞     ∞    27    63     0    18
     ∞     ∞     ∞     ∞     ∞    17    18     0

删除顶点D，顶点集合：SeqList(A, B, C, E, F, G, H) 
邻接矩阵:  
     0    12    31     ∞     ∞     ∞     ∞
    12     0     ∞     ∞     ∞     ∞     ∞
    31     ∞     0     ∞     ∞     ∞     ∞
     ∞     ∞     ∞     0     5    27     ∞
     ∞     ∞     ∞     5     0    63    17
     ∞     ∞     ∞    27    63     0    18
     ∞     ∞     ∞     ∞    17    18     0
                                                
                                               //AdjListGraph<String>
带权无向图G7，顶点集合：SeqList(A, B, C, D, E, F, G, H) 
出边表：
0 -> ((0,1,12),(0,2,31))
1 -> ((1,0,12),(1,3,23))
2 -> ((2,0,31),(2,3,15))
3 -> ((3,1,23),(3,2,15),(3,4,11),(3,5,4))
4 -> ((4,3,11),(4,5,5),(4,6,27))
5 -> ((5,3,4),(5,4,5),(5,6,63),(5,7,17))
6 -> ((6,4,27),(6,5,63),(6,7,18))
7 -> ((7,5,17),(7,6,18))

删除顶点D，顶点集合：SeqList(A, B, C, E, F, G, H) 
出边表：
0 -> ((0,1,12),(0,2,31))
1 -> ((1,0,12))
2 -> ((2,0,31))
3 -> ((3,4,5),(3,5,27))
4 -> ((4,3,5),(4,5,63),(4,6,17))
5 -> ((5,3,27),(5,4,63),(5,6,18))
6 -> ((6,4,17),(6,5,18))

                             
带权无向图G7，顶点集合：SeqList(A, B, C, D, E, F, G, H) 
邻接矩阵:  
     0    12    31     ∞     ∞     ∞     ∞     ∞
    12     0     ∞    23     ∞     ∞     ∞     ∞
    31     ∞     0    15     ∞     ∞     ∞     ∞
     ∞    23    15     0    11     4     ∞     ∞
     ∞     ∞     ∞    11     0     5    27     ∞
     ∞     ∞     ∞     4     5     0    63    17
     ∞     ∞     ∞     ∞    27    63     0    18
     ∞     ∞     ∞     ∞     ∞    17    18     0

                      //带权无向图G7，未删除顶点，prim算法
mst边集合：(0,1,12),(0,2,31),(0,3,99999),(0,4,99999),(0,5,99999),(0,6,99999),(0,7,99999),
mst边集合：(0,1,12),(0,2,31),(1,3,23),(0,4,99999),(0,5,99999),(0,6,99999),(0,7,99999),
mst边集合：(0,1,12),(1,3,23),(3,2,15),(3,4,11),(3,5,4),(0,6,99999),(0,7,99999),
mst边集合：(0,1,12),(1,3,23),(3,5,4),(5,4,5),(3,2,15),(5,6,63),(5,7,17),
mst边集合：(0,1,12),(1,3,23),(3,5,4),(5,4,5),(3,2,15),(4,6,27),(5,7,17),
mst边集合：(0,1,12),(1,3,23),(3,5,4),(5,4,5),(3,2,15),(4,6,27),(5,7,17),
mst边集合：(0,1,12),(1,3,23),(3,5,4),(5,4,5),(3,2,15),(5,7,17),(7,6,18),
最小生成树的边集合：(0,1,12) (1,3,23) (3,5,4) (5,4,5) (3,2,15) (5,7,17) (7,6,18) ，最小代价为94
                        
A的单源最短路径：(A,B)长度12，(A,C)长度31，(A,B,D)长度35，(A,B,D,F,E)长度44，(A,B,D,F)长度39，(A,B,D,F,E,G)长度71，(A,B,D,F,H)长度56，
B的单源最短路径：(B,A)长度12，(B,D,C)长度38，(B,D)长度23，(B,D,F,E)长度32，(B,D,F)长度27，(B,D,F,E,G)长度59，(B,D,F,H)长度44，
C的单源最短路径：(C,A)长度31，(C,D,B)长度38，(C,D)长度15，(C,D,F,E)长度24，(C,D,F)长度19，(C,D,F,E,G)长度51，(C,D,F,H)长度36，
D的单源最短路径：(D,B,A)长度35，(D,B)长度23，(D,C)长度15，(D,F,E)长度9，(D,F)长度4，(D,F,E,G)长度36，(D,F,H)长度21，
E的单源最短路径：(E,F,D,B,A)长度44，(E,F,D,B)长度32，(E,F,D,C)长度24，(E,F,D)长度9，(E,F)长度5，(E,G)长度27，(E,F,H)长度22，
F的单源最短路径：(F,D,B,A)长度39，(F,D,B)长度27，(F,D,C)长度19，(F,D)长度4，(F,E)长度5，(F,E,G)长度32，(F,H)长度17，
G的单源最短路径：(G,E,F,D,B,A)长度71，(G,E,F,D,B)长度59，(G,E,F,D,C)长度51，(G,E,F,D)长度36，(G,E)长度27，(G,E,F)长度32，(G,H)长度18，
H的单源最短路径：(H,F,D,B,A)长度56，(H,F,D,B)长度44，(H,F,D,C)长度36，(H,F,D)长度21，(H,F,E)长度22，(H,F)长度17，(H,G)长度18，
                        
      //7.3   图的遍历                                                
删除边(E,F)，(F,G)，(G,H)，顶点集合：SeqList(A, B, C, D, E, F, G, H) 
邻接矩阵:  
     0    12    31     ∞     ∞     ∞     ∞     ∞
    12     0     ∞    23     ∞     ∞     ∞     ∞
    31     ∞     0    15     ∞     ∞     ∞     ∞
     ∞    23    15     0    11     4     ∞     ∞
     ∞     ∞     ∞    11     0     ∞    27     ∞
     ∞     ∞     ∞     4     ∞     0     ∞    17
     ∞     ∞     ∞     ∞    27     ∞     0     ∞
     ∞     ∞     ∞     ∞     ∞    17     ∞     0

删除边(E,F)，(F,G)，(G,H)，顶点集合：SeqList(A, B, C, D, E, F, G, H) 
邻接矩阵:  
     0    12    31     ∞     ∞     ∞     ∞     ∞
    12     0     ∞    23     ∞     ∞     ∞     ∞
    31     ∞     0    15     ∞     ∞     ∞     ∞
     ∞    23    15     0    11     4     ∞     ∞
     ∞     ∞     ∞    11     0     ∞    27     ∞
     ∞     ∞     ∞     4     ∞     0     ∞    17
     ∞     ∞     ∞     ∞    27     ∞     0     ∞
     ∞     ∞     ∞     ∞     ∞    17     ∞     0

深度优先遍历连通无向图G7：
{ A B D C E G F H } 
{ B A C D E G F H } 
{ C A B D E G F H } 
{ D B A C E G F H } 
{ E D B A C F H G } 
{ F D B A C E G H } 
{ G E D B A C F H } 
{ H F D B A C E G } 
广度优先遍历连通图无向图G7：
{ A B C D E F G H } 
{ B A D C E F G H } 
{ C A D B E F G H } 
{ D B C E F A G H } 
{ E D G B C F A H } 
{ F D H B C E A G } 
{ G E D B C F A H } 
{ H F D B C E A G } 

*/

//@author：Yeheya。2015-8-14

      /*        //习题7
      System.out.print("有"+graph.TripleCount()+"条边，");
      i=0;
      System.out.println("顶点"+graph.get(i)+"的入度是"+graph.indegree(i)+
                                             "，出度是"+graph.outdegree(i));
*/
