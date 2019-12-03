//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月29日
//10.3   算法设计策略
//10.3.3   贪心法
//5.  Kruskal算法实现
//（1） 边的比较器类

//三元组的比较器类，按值比较T对象大小；图的边的比较器类，按权值比较T对象大小
public class TripleComparator implements java.util.Comparator<Triple>
{
    public int compare(Triple t1, Triple t2)     //比较T对象相等和大小
    { 
        return (int)(t1.value - t2.value);       //三元组按值比较；图的边按权值比较
    }
}
//@author：Yeheya。2014-8-29

