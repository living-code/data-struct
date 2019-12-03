//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月27日
//10.3   算法设计策略
//10.3.3   贪心法
//5.  Kruskal算法实现
//（2） 最小生成树类

import java.util.Comparator;

public class MinSpanTree     //最小生成树类，存储一个带权无向图最小生成树的边集合，以及最小代价
{
    private Triple[] mst;                                  //存储最小生成树的边集合
    private int cost=0;                                    //最小生成树代价
 
    //以Kruskal算法构造带权无向图的最小生成树并求代价，使用最小堆和并查集。
    //参数n指定图的顶点数，edges数组指定图的所有边（每边只表示一次），comp指定比较器
//    public MinSpanTree(AbstractGraph<T> graph, Comparator<Triple> comp)
    public MinSpanTree(int n, Triple[] edges, Comparator<Triple> comp)
    {
        this.mst = new Triple[n-1];                        //mst存储最小生成树的边集合，边数为顶点数-1
        Heap<Triple> minheap = new Heap<Triple>(true, edges, comp);
                                       //使用最小堆存储一个图的所有边，边按权值比较大小（comp比较器提供）
        UnionFindSet ufset = new UnionFindSet(n);          //并查集
        System.out.println("并查集："+ufset.toString()+"，最小堆："+minheap.toString());
        int i=0;                                           //最小生成树中当前边的序号
        for (int j=0; j<n; j++)                            //共选出“顶点数-1”条边
        {
            Triple minedge = minheap.removeRoot();         //删除最小堆的根，返回权值最小的边
            System.out.print("最小边"+minedge.toString()+"，");
            if (ufset.union(minedge.row, minedge.column)) 
            {                                              //若最小权值边的起点和终点所在的两个集合合并
                this.mst[i++]=minedge;                     //该边加入最小生成树
                this.cost+=minedge.value;                  //计算最小生成树的代价
                System.out.println("插入边"+minedge.toString()+"，"+"并查集："+ufset.toString());
            }
        }
    }

    public String toString()                               //返回最小生成树边集合的描述字符串
    {
        String str="最小生成树的边集合：";
        for (int i=0; i<mst.length; i++)
            str+=mst[i]+" ";
        return str+"，最小代价为"+this.cost;
    }
    private static void print(boolean table[])             //输出一维数组，用于输出一个解
    {
        System.out.print("("+table[0]);
        for (int i=1; i<table.length; i++)
            System.out.print(","+table[i]);
        System.out.println(")");
    }
}
//@author：Yeheya。2014-8-29
/*

 ??   //以Prim算法构造带权图的最小生成树并求代价，//使用最小堆
    //参数n指定顶点数, edges数组指定图的所有边
    public MinSpanTree(int n, Triple[] edges, Comparator<Triple> comp)
    {
        MinHeap<Triple> minheap = new MinHeap<Triple>(edges, comp);  //使用最小堆存储一个图的所有边，边按权值比较大小
        System.out.println("最小堆："+minheap.toString());
        mst = new Triple[n-1];                               //mst存储最小生成树的边集合，边数为顶点数-1
        boolean vertmst[]=new boolean[n];
        print(vertmst);
        int i=0;                                           //最小生成树中当前边的序号
        vertmst[i]=true;   //查找最小权值边的起点所在的集合
        for (int j=1; j<n; j++)                            //共选出“顶点数-1”条边
        {
            Triple minedge = minheap.removeMin();            //删除最小堆的根，返回最小权值的边
            if (!vertmst[minedge.dest])   //最小权值边的起点和终点不在一个集合
            {
               //vertmst[minedge.start]=true;   //查找最小权值边的起点所在的集合
                vertmst[minedge.dest]=true;   //查找最小权值边的起点所在的集合
                this.mst[i++]=minedge;                     //该边加入最小生成树
                this.cost+=minedge.weight;                 //计算最小生成树的代价
                System.out.print("插入边"+minedge.toString()+"，");
                print(vertmst);
            }
        }
    }

*/
