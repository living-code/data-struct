//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年9月7日，JDK 8.11
//§2.2  线性表的顺序存储和实现
//§2.2.2  顺序表
//5.  顺序表的浅拷贝与深拷贝
//【例2.2】  顺序表的浅拷贝与深拷贝。
//（1）顺序表的浅拷贝
//图2.6  顺序表的浅拷贝及其错误

public class SeqList_copy_String 
{
    public static void main(String[] args) 
    {
        String[] values={"A","B","C","D","E"};
        SeqList<String> lista = new SeqList<String>(values);
        SeqList<String> listb = new SeqList<String>(lista);//执行拷贝构造方法
        
        System.out.println("图2.6（a），lista="+lista.toString()+"，listb="+listb.toString());
        lista.remove(0);                                   //浅拷贝时，有错，图2.6（b）
        System.out.println("图2.6（b），lista="+lista.toString()+"，listb=");
        System.out.println(listb.toString());        
    }    
}

/*
程序运行结果如下：
图2.6（a），lista=SeqList(A, B, C, D, E) ，listb=SeqList(A, B, C, D, E) 
图2.6（b），lista=SeqList(B, C, D, E) ，listb=
Exception in thread "main" java.lang.NullPointerException
    at SeqList.toString(SeqList.java:78)
    at SeqList_copy.main(SeqList_copy.java:19)
*/


//@author：Yeheya。2014-9-7