//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年9月7日，JDK 8.11
//§2.2  线性表的顺序存储和实现
//§2.2.2  顺序表
//5.  顺序表的浅拷贝与深拷贝
//【例2.2】  顺序表的浅拷贝与深拷贝。
//（2） 顺序表的深拷贝
//图2.7（a）（b）  顺序表的深拷贝
//图2.7（c）做不成，因为StringBuffer没有拷贝构造方法

public class SeqList_deepcopy_StringBuffer 
{
    public static void main(String args[])
    {
        //图2.7（a）顺序表的深拷贝
        int n=5;
        SeqList<StringBuffer> lista = new SeqList<StringBuffer>(n-1);  //执行构造方法
        for (int i=0; i<n; i++)
            lista.insert(new StringBuffer((char)('A'+i)+""));          //尾插入，扩容

        SeqList<StringBuffer> listb = new SeqList<StringBuffer>(lista);//执行拷贝构造方法，图2.7（a）
        System.out.println("图2.7（a），lista="+lista.toString()+"，listb="+listb.toString()+
                           "，lista.equals(listb)? "+lista.equals(listb));
        
        //图2.7（b）  顺序表的深拷贝
        lista.insert(new StringBuffer("F"));               //尾插入，图2.7（b），没有影响listb
        lista.remove(10);                                  //序号越界，没删除
        listb.remove(listb.size()-1);                      //尾删除，图2.7（b），没有影响lista
        StringBuffer strbuf = lista.get(0);                //返回引用的对象
        strbuf.setCharAt(0, 'X');                          //修改元素，图2.7（b），影响listb
        System.out.println("图2.7（b），lista="+lista.toString()+"，listb="+listb.toString()+
                           "，lista.equals(listb)? "+lista.equals(listb));        
    }
}

/*
程序运行结果如下：    
图2.7（a），lista=SeqList(A, B, C, D, E) ，listb=SeqList(A, B, C, D, E) ，lista.equals(listb)? true
图2.7（b），lista=SeqList(X, B, C, D, E, F) ，listb=SeqList(X, B, C, D) ，lista.equals(listb)? false

*/

/*    //(3)深度拷贝,不行,StringBuffer没有拷贝构造方法
public static SeqList<StringBuffer> copy(SeqList<StringBuffer> list)//深拷贝构造方法，深拷贝，复制list
{
    SeqList<StringBuffer> result = new SeqList<StringBuffer>(list);//深拷贝构造方法，
    for (int i=0; i<list.count(); i++)          //复制list数组所有元素，O(n)
        result.set(i, new StringBuffer(list.get(i)));             //对象引用赋值，没有创建新对象
    return result; 
}
*/  

//@author：Yeheya。2014-9-7