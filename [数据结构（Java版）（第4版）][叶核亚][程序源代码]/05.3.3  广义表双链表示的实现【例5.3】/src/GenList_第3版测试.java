//5.3   广义表
//5.3.2   广义表的存储结构
//2.  广义表的双链表示
//第3版【例5.4】广义表的双链表示及构造算法。
//使用GenList类，(1)由原子数组构造广义表
public class GenList_第3版测试
{    
    public static void main(String args[])
    {
        GenList<String> glist_empty = new GenList<String>();//构造空广义表		
        System.out.print("glist_empty："+glist_empty.toString()+"，  size="+glist_empty.size()); 
        System.out.println("，depth="+glist_empty.depth()); 

        glist_empty.insert(0, new GenList<String>());      //空表中插入空表
        glist_empty.insert(new GenList<String>()); 
        System.out.print("glist："+glist_empty.toString()+"，  size="+glist_empty.size()); 
        System.out.println("，depth="+glist_empty.depth()); 

        String[] gliststr_l = {"b","c","e"};
        GenList<String> glist_L = new GenList<String>(gliststr_l);//由原子数组构造广义表
        glist_L.insert(0, "a");                            //头插入原子
        glist_L.insert(3, "d");                            //中间插入原子
        glist_L.insert("f");                               //尾插入原子
        System.out.print("glist_L："+glist_L.toString()+"，  size="+glist_L.size()); 
        System.out.println("，depth="+glist_L.depth()); 
    
        String[] gliststr_t = {"o","p","q"};
        GenList<String> glist_T = new GenList<String>(gliststr_t);
        glist_T.insert(glist_L);                           //尾插入子表
        System.out.print("glist_T："+glist_T.toString()+"，  size="+glist_T.size()); 
        System.out.println("，depth="+glist_T.depth()); 

        String[] gliststr_g = {"x","y","z"};
        GenList<String> glist_G = new GenList<String>(gliststr_g);
        glist_G.insert(glist_L);
        glist_G.insert(glist_T);                           //尾插入子表，glist_L成为共享子表
        System.out.print("glist_G："+glist_G.toString()+"，  size="+glist_G.size()); 
        System.out.println("，depth="+glist_G.depth()); 
    }
}    
/*
程序运行结果如下：
glist_empty：()，  size=0，depth=1
glist：((),())，  size=2，depth=2
glist_L：(a,b,c,d,e,f)，  size=6，depth=1
glist_T：(o,p,q,(a,b,c,d,e,f))，  size=4，depth=2
glist_G：(x,y,z,(a,b,c,d,e,f),(o,p,q,(a,b,c,d,e,f)))，  size=5，depth=3

*/
//author：Yeheya。2014-10-6