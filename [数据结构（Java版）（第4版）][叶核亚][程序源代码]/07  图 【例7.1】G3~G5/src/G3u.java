//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月24日
//7.2   图的表示和实现
//7.2.1   图的邻接矩阵表示和实现
//【例7.1】 带权无向图G3的构造、插入及删除操作。
//7.5.2 每对顶点间的最短路径
//【习题解答7-16】 Floyd算法

public class G3u
{
    public static void main(String args[])
    {
        //【例7.1】  带权图的存储及操作。
        String[] vertices={"A","B","C","D","E"};           //带权无向图G3的顶点集合（除F） ，图7.13
        Triple[] edges={new Triple(0,1,45), new Triple(0,2,28), new Triple(0,3,10),
                    new Triple(1,0,45), new Triple(1,2,12), new Triple(1,4,21),
                    new Triple(2,0,28), new Triple(2,1,12), new Triple(2,3,17), new Triple(2,4,26),
                    new Triple(3,0,10), new Triple(3,2,17), new Triple(3,4,15), 
                    new Triple(4,1,21), new Triple(4,2,26), new Triple(4,3,15)};//G3的边集合（除F）
        MatrixGraph<String> graph = new MatrixGraph<String>(vertices, edges);  //邻接矩阵表示的图
//        AdjListGraph<String> graph = new AdjListGraph<String>(vertices, edges);     //邻接表表示的图
//        System.out.println("带权无向图G3（除顶点F），"+graph.toString());

        //（1）插入边（2）插入顶点
        System.out.println("插入顶点F，插入边(D,F,13)和(E,F,11)");//图7.14
        int i=graph.insertVertex("F");                     //插入顶点F，扩容
        graph.insertEdge(3,i,13);                          //插入边(D,F,13)
        graph.insertEdge(new Triple(i,3,13));              //插入边(F,D,13)
        graph.insertEdge(4,i,11);                          //插入边(E,F,11)
        graph.insertEdge(new Triple(i,4,11));              //插入边(F,E,11)
        System.out.println("带权无向图G3，"+graph.toString());
//        graph.insertEdge(5,6,0);                           //插入边，序号越界
        
        //（3）删除边（4）删除顶点
//        graph.removeEdge(5,6);                             //删除边，序号越界
/*        graph.removeEdge(4,i);                             //删除边(E,F,11)
        graph.removeEdge(new Triple(i,4,0));               //删除边(F,E,11)
        System.out.println("删除边(E,F,11)，图7.21（a）无向图G1，"+graph.toString());
  
        //以下语句正确，有F顶点时遍历
        graph.removeVertex(3);                             //删除顶点D，图7.15
        i=graph.insertVertex("G");                         //插入顶点G
        System.out.println("删除顶点D，插入顶点G，"+graph.toString());
*/

        //7.3   图的遍历
/*        System.out.println("深度优先遍历连通无向图G3：");  //图7.22（a），【思考题7-1，7-2】遍历序列【思考题7-3，习题解答】生成树
        for (i=0; i<graph.vertexCount(); i++)
            graph.DFSTraverse(i);

        System.out.println("广度优先遍历连通图无向图G3：");
        for (i=0; i<graph.vertexCount(); i++)
            graph.BFSTraverse(i);

        //@author：Yeheya。2014-8-4
*/        
        //7.4.2   最小生成树的构造算法
        System.out.println("带权无向图G3，prim算法");
        graph.minSpanTree();                //prim

        //7.5.1   非负权值的单源最短路径（Dijkstra算法）
        System.out.println("带权无向图G3，Dijkstra算法");
//        for (i=0; i<graph.vertexCount(); i++)       //图10.6
//            graph.shortestPath(i);               //顶点vi的单源最短路径，Dijkstra算法

        /*        //习题7
        System.out.print("有"+graph.edgeCount()+"条边，");
        i=0;
        System.out.println("顶点"+graph.get(i)+"的入度是"+graph.indegree(i)+
                                               "，出度是"+graph.outdegree(i));
*/    }
}

/*
程序运行结果如下：
                                                 //MatrixGraph<String>
带权无向图G3（除顶点F），顶点集合：(A, B, C, D, E)            //图7.13
邻接矩阵:  
     0    45    28    10     ∞
    45     0    12     ∞    21
    28    12     0    17    26
    10     ∞    17     0    15
     ∞    21    26    15     0

插入顶点F，插入边(D,F,13)和(E,F,11)                            //图7.13
带权无向图G3，顶点集合：(A, B, C, D, E, F) 
邻接矩阵:  
     0    45    28    10     ∞     ∞
    45     0    12     ∞    21     ∞
    28    12     0    17    26     ∞
    10     ∞    17     0    15    13
     ∞    21    26    15     0    11
     ∞     ∞     ∞    13    11     0

删除边(E,F,11)，顶点集合：(A, B, C, D, E, F) 
邻接矩阵:  
     0    45    28    10     ∞     ∞
    45     0    12     ∞    21     ∞
    28    12     0    17    26     ∞
    10     ∞    17     0    15    13
     ∞    21    26    15     0     ∞
     ∞     ∞     ∞    13     ∞     0

删除顶点D，插入顶点G，顶点集合：(A, B, C, E, F, G) 
邻接矩阵:  
     0    45    28     ∞     ∞     ∞
    45     0    12    21     ∞     ∞
    28    12     0    26     ∞     ∞
     ∞    21    26     0     ∞     ∞
     ∞     ∞     ∞     ∞     0     ∞
     ∞     ∞     ∞     ∞     ∞     0

                                                 //AdjListGraph<String>
带权无向图G3（除顶点F），顶点集合：(A, B, C, D, E)            //图7.16
出边表：
0 -> ((0,1,45),(0,2,28),(0,3,10))
1 -> ((1,0,45),(1,2,12),(1,4,21))
2 -> ((2,0,28),(2,1,12),(2,3,17),(2,4,26))
3 -> ((3,0,10),(3,2,17),(3,4,15))
4 -> ((4,1,21),(4,2,26),(4,3,15))

插入顶点F，插入边(D,F,13)和(E,F,11)
带权无向图G3，顶点集合：(A, B, C, D, E, F) 
出边表：
0 -> ((0,1,45),(0,2,28),(0,3,10))
1 -> ((1,0,45),(1,2,12),(1,4,21))
2 -> ((2,0,28),(2,1,12),(2,3,17),(2,4,26))
3 -> ((3,0,10),(3,2,17),(3,4,15),(3,5,13))
4 -> ((4,1,21),(4,2,26),(4,3,15),(4,5,11))
5 -> ((5,3,13),(5,4,11))

删除顶点D，插入顶点G，顶点集合：(A, B, C, E, F, G)              //图7.18
出边表：
0 -> ((0,1,45),(0,2,28))
1 -> ((1,0,45),(1,2,12),(1,3,21))
2 -> ((2,0,28),(2,1,12),(2,3,26))
3 -> ((3,1,21),(3,2,26),(3,4,11))
4 -> ((4,3,11))
5 -> ()

    //@author：Yeheya。2014-8-3


深度优先遍历连通无向图G3：
{ A B C D E F }                                            //图7.22(a)，【思考题7-1，7-2】遍历序列【思考题7-3，习题解答】生成树
{ B A C D E F } 
{ C A B E D F } 
{ D A B C E F } 
{ E B A C D F } 
{ F D A B C E } 
广度优先遍历连通图无向图G3：
{ A B C D E F } 
{ B A C E D F } 
{ C A B D E F } 
{ D A C E F B } 
{ E B C D A F } 
{ F D A C E B } 

带权无向图G3，mst数组：(0,1,45)(0,2,28)(0,3,10)(0,4,65535)(0,5,65535)      //图7.28
mst数组：(0,3,10)(3,2,17)(0,1,45)(3,4,15)(3,5,13)
mst数组：(0,3,10)(3,5,13)(0,1,45)(5,4,11)(3,2,17)
mst数组：(0,3,10)(3,5,13)(5,4,11)(4,1,21)(3,2,17)
mst数组：(0,3,10)(3,5,13)(5,4,11)(3,2,17)(2,1,12)
mst数组：(0,3,10)(3,5,13)(5,4,11)(3,2,17)(2,1,12)
最小生成树的边集合：(0,3,10) (3,5,13) (5,4,11) (3,2,17) (2,1,12) ，最小代价为63

    //@author：Yeheya。2014-8-7
           //图10.9
A的单源最短路径：(A,D,C,B)长度39，(A,D,C)长度27，(A,D)长度10，(A,D,E)长度25，(A,D,F)长度23，
B的单源最短路径：(B,C,D,A)长度39，(B,C)长度12，(B,C,D)长度29，(B,E)长度21，(B,E,F)长度32，
C的单源最短路径：(C,D,A)长度27，(C,B)长度12，(C,D)长度17，(C,E)长度26，(C,D,F)长度30，
D的单源最短路径：(D,A)长度10，(D,C,B)长度29，(D,C)长度17，(D,E)长度15，(D,F)长度13，
E的单源最短路径：(E,D,A)长度25，(E,B)长度21，(E,C)长度26，(E,D)长度15，(E,F)长度11，
F的单源最短路径：(F,D,A)长度23，(F,E,B)长度32，(F,D,C)长度30，(F,D)长度13，(F,E)长度11，

    //@author：Yeheya。2014-8-29

*/
