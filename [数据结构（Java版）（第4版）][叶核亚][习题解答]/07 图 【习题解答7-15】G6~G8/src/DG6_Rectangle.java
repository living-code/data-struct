//《数据结构（Java版）（第4版）习题解答》，作者：叶核亚，2015年3月15日
//7.5.1 单源最短路径，Dijkstra算法
//7.5.2 每对顶点间的最短路径，Floyd算法
//【习7-15】 带权无向图G8，DG6_Rectangle表示
//【习题解答7-15，课件】 单源最短路径，Dijkstra算法
//【试题7】存储结构、Floyd算法

public class DG6_Rectangle
{
    public static void main(String args[])
    {
        String graphname="DG6_Rectangle";
        String[] vertices={"A","B","C","D","E","F"};
        Triple[] edges={new Triple(0,1,20), new Triple(0,2,38), 
                        new Triple(1,0,9),  new Triple(1,2,15), new Triple(1,3,37),
                        new Triple(2,3,18), new Triple(2,4,5), 
                        new Triple(3,0,23), new Triple(3,5,13), 
                        new Triple(4,3,11), new Triple(4,5,8),
                        new Triple(5,2,19)};
//        MatrixGraph<String> graph = new MatrixGraph<String>(vertices, edges);
        AdjListGraph<String> graph = new AdjListGraph<String>(vertices, edges);     //邻接表表示的图
        System.out.print("带权有向图"+graphname+"，"+graph.toString());

        System.out.print("深度优先遍历有向图"+graphname+"：");
        for (int i=0; i<graph.vertexCount(); i++)
            graph.DFSTraverse(i);

        System.out.print("广度优先遍历有向图"+graphname+"：");
        for (int i=0; i<graph.vertexCount(); i++)
            graph.BFSTraverse(i);
        
/*        System.out.println("带权有向图"+graphname+"，"+"Dijkstra算法");
        for (int i=0; i<graph.vertexCount(); i++)
            graph.shortestPath(i);               //顶点vi的单源最短路径，Dijkstra算法
//        graph.shortestPath();                    //调用Floyd算法求带权图每对顶点间的最短路径
 */
        //带权无向图??
//??        System.out.print("带权无向图"+graphname+"，prim算法：");
//??        graph.minSpanTree();


    }
}
/*
程序运行结果如下：
                          
带权有向图DG6_Rectangle，顶点集合：SeqList(A, B, C, D, E, F) 
邻接矩阵:  
     0    20    38     ∞     ∞     ∞
     9     0    15    37     ∞     ∞
     ∞     ∞     0    18     5     ∞
    23     ∞     ∞     0     ∞    13
     ∞     ∞     ∞    11     0     8
     ∞     ∞    19     ∞     ∞     0
出边表：
0 -> ((0,1,20),(0,2,38))
1 -> ((1,0,9),(1,2,15),(1,3,37))
2 -> ((2,3,18),(2,4,5))
3 -> ((3,0,23),(3,5,13))
4 -> ((4,3,11),(4,5,8))
5 -> ((5,2,19))

深度优先遍历有向图DG6_Rectangle：
{ A B C D F E } 
{ B A C D F E } 
{ C D A B F E } 
{ D A B C E F } 
{ E D A B C F } 
{ F C D A B E } 
广度优先遍历有向图DG6_Rectangle：
{ A B C D E F } 
{ B A C D E F } 
{ C D E A F B } 
{ D A F B C E } 
{ E D F A C B } 
{ F C D E A B } 
     
     //Dijkstra算法
A的单源最短路径：(A,B)长度20，(A,B,C)长度35，(A,B,C,E,D)长度51，(A,B,C,E)长度40，(A,B,C,E,F)长度48，
B的单源最短路径：(B,A)长度9，(B,C)长度15，(B,C,E,D)长度31，(B,C,E)长度20，(B,C,E,F)长度28，
C的单源最短路径：(C,E,D,A)长度39，(C,E,D,A,B)长度59，(C,E,D)长度16，(C,E)长度5，(C,E,F)长度13，
D的单源最短路径：(D,A)长度23，(D,A,B)长度43，(D,F,C)长度32，(D,F,C,E)长度37，(D,F)长度13，
E的单源最短路径：(E,D,A)长度34，(E,D,A,B)长度54，(E,F,C)长度27，(E,D)长度11，(E,F)长度8，
F的单源最短路径：(F,C,E,D,A)长度58，(F,C,E,D,A,B)长度78，(F,C)长度19，(F,C,E,D)长度35，(F,C,E)长度24，
                          
  //调用Floyd算法
带权有向图G10，顶点集合：(A, B, C, D, E, F) 
邻接矩阵:  
  0  20  38  ∞  ∞  ∞
  9  0  15  37  ∞  ∞
  ∞  ∞  0  18  5  ∞
  23  ∞  ∞  0  ∞  13
  ∞  ∞  ∞  11  0  8
  ∞  ∞  19  ∞  ∞  0
初值path数组
  -1  0  0  -1  -1  -1
  1  -1  1  1  -1  -1
  -1  -1  -1  2  2  -1
  3  -1  -1  -1  -1  3
  -1  -1  -1  4  -1  4
  -1  -1  5  -1  -1  -1
dist数组
  0  20  38  ∞  ∞  ∞
  9  0  15  37  ∞  ∞
  ∞  ∞  0  18  5  ∞
  23  ∞  ∞  0  ∞  13
  ∞  ∞  ∞  11  0  8
  ∞  ∞  19  ∞  ∞  0

以A作为中间顶点
(B,C)路径长度15，替换为(B,A),(A,C)路径长度47？否
(B,D)路径长度37，替换为(B,A),(A,D)路径长度100008？否
(B,E)路径长度99999，替换为(B,A),(A,E)路径长度100008？否
(B,F)路径长度99999，替换为(B,A),(A,F)路径长度100008？否
(C,B)路径长度99999，替换为(C,A),(A,B)路径长度100019？否
(C,D)路径长度18，替换为(C,A),(A,D)路径长度199998？否
(C,E)路径长度5，替换为(C,A),(A,E)路径长度199998？否
(C,F)路径长度99999，替换为(C,A),(A,F)路径长度199998？否
(D,B)路径长度99999，替换为(D,A),(A,B)路径长度43？是，d31=43，p31=0
(D,C)路径长度99999，替换为(D,A),(A,C)路径长度61？是，d32=61，p32=0
(D,E)路径长度99999，替换为(D,A),(A,E)路径长度100022？否
(D,F)路径长度13，替换为(D,A),(A,F)路径长度100022？否
(E,B)路径长度99999，替换为(E,A),(A,B)路径长度100019？否
(E,C)路径长度99999，替换为(E,A),(A,C)路径长度100037？否
(E,D)路径长度11，替换为(E,A),(A,D)路径长度199998？否
(E,F)路径长度8，替换为(E,A),(A,F)路径长度199998？否
(F,B)路径长度99999，替换为(F,A),(A,B)路径长度100019？否
(F,C)路径长度19，替换为(F,A),(A,C)路径长度100037？否
(F,D)路径长度99999，替换为(F,A),(A,D)路径长度199998？否
(F,E)路径长度99999，替换为(F,A),(A,E)路径长度199998？否
path数组
  -1  0  0  -1  -1  -1
  1  -1  1  1  -1  -1
  -1  -1  -1  2  2  -1
  3  0  0  -1  -1  3
  -1  -1  -1  4  -1  4
  -1  -1  5  -1  -1  -1
dist数组
  0  20  38  ∞  ∞  ∞
  9  0  15  37  ∞  ∞
  ∞  ∞  0  18  5  ∞
  23  43  61  0  ∞  13
  ∞  ∞  ∞  11  0  8
  ∞  ∞  19  ∞  ∞  0

以B作为中间顶点
(A,C)路径长度38，替换为(A,B),(B,C)路径长度35？是，d02=35，p02=1
(A,D)路径长度99999，替换为(A,B),(B,D)路径长度57？是，d03=57，p03=1
(A,E)路径长度99999，替换为(A,B),(B,E)路径长度100019？否
(A,F)路径长度99999，替换为(A,B),(B,F)路径长度100019？否
(C,A)路径长度99999，替换为(C,B),(B,A)路径长度100008？否
(C,D)路径长度18，替换为(C,B),(B,D)路径长度100036？否
(C,E)路径长度5，替换为(C,B),(B,E)路径长度199998？否
(C,F)路径长度99999，替换为(C,B),(B,F)路径长度199998？否
(D,A)路径长度23，替换为(D,A,B),(B,A)路径长度52？否
(D,A,C)路径长度61，替换为(D,A,B),(B,C)路径长度58？是，d32=58，p32=1
(D,E)路径长度99999，替换为(D,A,B),(B,E)路径长度100042？否
(D,F)路径长度13，替换为(D,A,B),(B,F)路径长度100042？否
(E,A)路径长度99999，替换为(E,B),(B,A)路径长度100008？否
(E,C)路径长度99999，替换为(E,B),(B,C)路径长度100014？否
(E,D)路径长度11，替换为(E,B),(B,D)路径长度100036？否
(E,F)路径长度8，替换为(E,B),(B,F)路径长度199998？否
(F,A)路径长度99999，替换为(F,B),(B,A)路径长度100008？否
(F,C)路径长度19，替换为(F,B),(B,C)路径长度100014？否
(F,D)路径长度99999，替换为(F,B),(B,D)路径长度100036？否
(F,E)路径长度99999，替换为(F,B),(B,E)路径长度199998？否
path数组
  -1  0  1  1  -1  -1
  1  -1  1  1  -1  -1
  -1  -1  -1  2  2  -1
  3  0  1  -1  -1  3
  -1  -1  -1  4  -1  4
  -1  -1  5  -1  -1  -1
dist数组
  0  20  35  57  ∞  ∞
  9  0  15  37  ∞  ∞
  ∞  ∞  0  18  5  ∞
  23  43  58  0  ∞  13
  ∞  ∞  ∞  11  0  8
  ∞  ∞  19  ∞  ∞  0

以C作为中间顶点
(A,B)路径长度20，替换为(A,B,C),(C,B)路径长度100034？否
(A,B,D)路径长度57，替换为(A,B,C),(C,D)路径长度53？是，d03=53，p03=2
(A,E)路径长度99999，替换为(A,B,C),(C,E)路径长度40？是，d04=40，p04=2
(A,F)路径长度99999，替换为(A,B,C),(C,F)路径长度100034？否
(B,A)路径长度9，替换为(B,C),(C,A)路径长度100014？否
(B,D)路径长度37，替换为(B,C),(C,D)路径长度33？是，d13=33，p13=2
(B,E)路径长度99999，替换为(B,C),(C,E)路径长度20？是，d14=20，p14=2
(B,F)路径长度99999，替换为(B,C),(C,F)路径长度100014？否
(D,A)路径长度23，替换为(D,A,B,C),(C,A)路径长度100057？否
(D,A,B)路径长度43，替换为(D,A,B,C),(C,B)路径长度100057？否
(D,E)路径长度99999，替换为(D,A,B,C),(C,E)路径长度63？是，d34=63，p34=2
(D,F)路径长度13，替换为(D,A,B,C),(C,F)路径长度100057？否
(E,A)路径长度99999，替换为(E,C),(C,A)路径长度199998？否
(E,B)路径长度99999，替换为(E,C),(C,B)路径长度199998？否
(E,D)路径长度11，替换为(E,C),(C,D)路径长度100017？否
(E,F)路径长度8，替换为(E,C),(C,F)路径长度199998？否
(F,A)路径长度99999，替换为(F,C),(C,A)路径长度100018？否
(F,B)路径长度99999，替换为(F,C),(C,B)路径长度100018？否
(F,D)路径长度99999，替换为(F,C),(C,D)路径长度37？是，d53=37，p53=2
(F,E)路径长度99999，替换为(F,C),(C,E)路径长度24？是，d54=24，p54=2
path数组
  -1  0  1  2  2  -1
  1  -1  1  2  2  -1
  -1  -1  -1  2  2  -1
  3  0  1  -1  2  3
  -1  -1  -1  4  -1  4
  -1  -1  5  2  2  -1
dist数组
  0  20  35  53  40  ∞
  9  0  15  33  20  ∞
  ∞  ∞  0  18  5  ∞
  23  43  58  0  63  13
  ∞  ∞  ∞  11  0  8
  ∞  ∞  19  37  24  0

以D作为中间顶点
(A,B)路径长度20，替换为(A,B,C,D),(D,A,B)路径长度96？否
(A,B,C)路径长度35，替换为(A,B,C,D),(D,A,B,C)路径长度111？否
(A,B,C,E)路径长度40，替换为(A,B,C,D),(D,A,B,C,E)路径长度116？否
(A,F)路径长度99999，替换为(A,B,C,D),(D,F)路径长度66？是，d05=66，p05=3
(B,A)路径长度9，替换为(B,C,D),(D,A)路径长度56？否
(B,C)路径长度15，替换为(B,C,D),(D,A,B,C)路径长度91？否
(B,C,E)路径长度20，替换为(B,C,D),(D,A,B,C,E)路径长度96？否
(B,F)路径长度99999，替换为(B,C,D),(D,F)路径长度46？是，d15=46，p15=3
(C,A)路径长度99999，替换为(C,D),(D,A)路径长度41？是，d20=41，p20=3
(C,B)路径长度99999，替换为(C,D),(D,A,B)路径长度61？是，d21=61，p21=0
(C,E)路径长度5，替换为(C,D),(D,A,B,C,E)路径长度81？否
(C,F)路径长度99999，替换为(C,D),(D,F)路径长度31？是，d25=31，p25=3
(E,A)路径长度99999，替换为(E,D),(D,A)路径长度34？是，d40=34，p40=3
(E,B)路径长度99999，替换为(E,D),(D,A,B)路径长度54？是，d41=54，p41=0
(E,C)路径长度99999，替换为(E,D),(D,A,B,C)路径长度69？是，d42=69，p42=1
(E,F)路径长度8，替换为(E,D),(D,F)路径长度24？否
(F,A)路径长度99999，替换为(F,C,D),(D,A)路径长度60？是，d50=60，p50=3
(F,B)路径长度99999，替换为(F,C,D),(D,A,B)路径长度80？是，d51=80，p51=0
(F,C)路径长度19，替换为(F,C,D),(D,A,B,C)路径长度95？否
(F,C,E)路径长度24，替换为(F,C,D),(D,A,B,C,E)路径长度100？否
path数组
  -1  0  1  2  2  3
  1  -1  1  2  2  3
  3  0  -1  2  2  3
  3  0  1  -1  2  3
  3  0  1  4  -1  4
  3  0  5  2  2  -1
dist数组
  0  20  35  53  40  66
  9  0  15  33  20  46
  41  61  0  18  5  31
  23  43  58  0  63  13
  34  54  69  11  0  8
  60  80  19  37  24  0

以E作为中间顶点
(A,B)路径长度20，替换为(A,B,C,E),(E,D,A,B)路径长度94？否
(A,B,C)路径长度35，替换为(A,B,C,E),(E,D,A,B,C)路径长度109？否
(A,B,C,D)路径长度53，替换为(A,B,C,E),(E,D)路径长度51？是，d03=51，p03=4
(A,B,C,E,D,F)路径长度66，替换为(A,B,C,E),(E,F)路径长度48？是，d05=48，p05=4
(B,A)路径长度9，替换为(B,C,E),(E,D,A)路径长度54？否
(B,C)路径长度15，替换为(B,C,E),(E,D,A,B,C)路径长度89？否
(B,C,D)路径长度33，替换为(B,C,E),(E,D)路径长度31？是，d13=31，p13=4
(B,C,E,D,F)路径长度46，替换为(B,C,E),(E,F)路径长度28？是，d15=28，p15=4
(C,D,A)路径长度41，替换为(C,E),(E,D,A)路径长度39？是，d20=39，p20=3
(C,D,A,B)路径长度61，替换为(C,E),(E,D,A,B)路径长度59？是，d21=59，p21=0
(C,D)路径长度18，替换为(C,E),(E,D)路径长度16？是，d23=16，p23=4
(C,E,D,F)路径长度31，替换为(C,E),(E,F)路径长度13？是，d25=13，p25=4
(D,A)路径长度23，替换为(D,A,B,C,E),(E,D,A)路径长度97？否
(D,A,B)路径长度43，替换为(D,A,B,C,E),(E,D,A,B)路径长度117？否
(D,A,B,C)路径长度58，替换为(D,A,B,C,E),(E,D,A,B,C)路径长度132？否
(D,F)路径长度13，替换为(D,A,B,C,E),(E,F)路径长度71？否
(F,C,D,A)路径长度60，替换为(F,C,E),(E,D,A)路径长度58？是，d50=58，p50=3
(F,C,D,A,B)路径长度80，替换为(F,C,E),(E,D,A,B)路径长度78？是，d51=78，p51=0
(F,C)路径长度19，替换为(F,C,E),(E,D,A,B,C)路径长度93？否
(F,C,D)路径长度37，替换为(F,C,E),(E,D)路径长度35？是，d53=35，p53=4
path数组
  -1  0  1  4  2  4
  1  -1  1  4  2  4
  3  0  -1  4  2  4
  3  0  1  -1  2  3
  3  0  1  4  -1  4
  3  0  5  4  2  -1
dist数组
  0  20  35  51  40  48
  9  0  15  31  20  28
  39  59  0  16  5  13
  23  43  58  0  63  13
  34  54  69  11  0  8
  58  78  19  35  24  0

以F作为中间顶点
(A,B)路径长度20，替换为(A,B,C,E,F),(F,C,E,D,A,B)路径长度126？否
(A,B,C)路径长度35，替换为(A,B,C,E,F),(F,C)路径长度67？否
(A,B,C,E,D)路径长度51，替换为(A,B,C,E,F),(F,C,E,D)路径长度83？否
(A,B,C,E)路径长度40，替换为(A,B,C,E,F),(F,C,E)路径长度72？否
(B,A)路径长度9，替换为(B,C,E,F),(F,C,E,D,A)路径长度86？否
(B,C)路径长度15，替换为(B,C,E,F),(F,C)路径长度47？否
(B,C,E,D)路径长度31，替换为(B,C,E,F),(F,C,E,D)路径长度63？否
(B,C,E)路径长度20，替换为(B,C,E,F),(F,C,E)路径长度52？否
(C,E,D,A)路径长度39，替换为(C,E,F),(F,C,E,D,A)路径长度71？否
(C,E,D,A,B)路径长度59，替换为(C,E,F),(F,C,E,D,A,B)路径长度91？否
(C,E,D)路径长度16，替换为(C,E,F),(F,C,E,D)路径长度48？否
(C,E)路径长度5，替换为(C,E,F),(F,C,E)路径长度37？否
(D,A)路径长度23，替换为(D,F),(F,C,E,D,A)路径长度71？否
(D,A,B)路径长度43，替换为(D,F),(F,C,E,D,A,B)路径长度91？否
(D,A,B,C)路径长度58，替换为(D,F),(F,C)路径长度32？是，d32=32，p32=5
(D,F,C,E)路径长度63，替换为(D,F),(F,C,E)路径长度37？是，d34=37，p34=2
(E,D,A)路径长度34，替换为(E,F),(F,C,E,D,A)路径长度66？否
(E,D,A,B)路径长度54，替换为(E,F),(F,C,E,D,A,B)路径长度86？否
(E,D,A,B,C)路径长度69，替换为(E,F),(F,C)路径长度27？是，d42=27，p42=5
(E,D)路径长度11，替换为(E,F),(F,C,E,D)路径长度43？否
path数组
  -1  0  1  4  2  4
  1  -1  1  4  2  4
  3  0  -1  4  2  4
  3  0  5  -1  2  3
  3  0  5  4  -1  4
  3  0  5  4  2  -1
dist数组
  0  20  35  51  40  48
  9  0  15  31  20  28
  39  59  0  16  5  13
  23  43  32  0  37  13
  34  54  27  11  0  8
  58  78  19  35  24  0

每对顶点间的最短路径如下：
(A,B)长度为20
(A,B,C)长度为35
(A,B,C,E,D)长度为51
(A,B,C,E)长度为40
(A,B,C,E,F)长度为48
(B,A)长度为9
(B,C)长度为15
(B,C,E,D)长度为31
(B,C,E)长度为20
(B,C,E,F)长度为28
(C,E,D,A)长度为39
(C,E,D,A,B)长度为59
(C,E,D)长度为16
(C,E)长度为5
(C,E,F)长度为13
(D,A)长度为23
(D,A,B)长度为43
(D,F,C)长度为32
(D,F,C,E)长度为37
(D,F)长度为13
(E,D,A)长度为34
(E,D,A,B)长度为54
(E,F,C)长度为27
(E,D)长度为11
(E,F)长度为8
(F,C,E,D,A)长度为58
(F,C,E,D,A,B)长度为78
(F,C)长度为19
(F,C,E,D)长度为35
(F,C,E)长度为24

*/
//@author：Yeheya。2015-8-15

