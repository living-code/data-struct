//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月6日
//5.3   广义表
//5.3.3   广义表双链表示的实现
//【例5.3】广义表的双链表示及构造算法。
//（1） 构造广义表及对广义表的操作

public class GenList_insert
{    
    public static void main(String args[])
    {
        String[] atoms={"a","b"};
        GenList<String> glist_L = new GenList<String>(atoms); //由原子数组构造广义表L
        System.out.println("L="+glist_L.toString()+"，size="+glist_L.size()+"，depth="+glist_L.depth()); 
        
        GenList<String> glist_T = new GenList<String>();   //构造空广义表T
        glist_T.insert("c");                               //插入原子c
        glist_T.insert(glist_L);                           //尾插入子表L
        System.out.println("T="+glist_T.toString()+"，size="+glist_T.size()+"，depth="+glist_T.depth()); 
        
        GenList<String> glist_G = new GenList<String>();   //构造空广义表G  
        glist_G.insert("d");                               //插入原子d
        glist_G.insert(glist_L);                           //尾插入子表L
        glist_G.insert(glist_T);                           //尾插入子表T，glist_L成为共享子表
        System.out.println("G="+glist_G.toString()+"，size="+glist_G.size()+"，depth="+glist_G.depth()); 
    }
}
/*
程序运行结果如下：
L=(a,b)，size=2，depth=1
T=(c,(a,b))，size=2，depth=2
G=(d,(a,b),(c,(a,b)))，size=3，depth=3

*/
//author：Yeheya。2014-10-6