//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月21日，JDK 8.11
//§2.2  线性表的顺序存储和实现
//§2.2.2 顺序表

public class SeqList_图2_2 
{
    public static void main(String args[])
    {
        //图2.2
        String values[]={"A","B","C","D","E"};
        SeqList<String> lista = new SeqList<String>(values);    //lista引用顺序表实例，元素是String对象
        SeqList<Integer> list1 = new SeqList<Integer>();        //list1引用空顺序表，元素是Integer对象
        System.out.println("lista："+lista.toString());
        System.out.println("list1："+list1.toString());

        list1.insert(null);                                 //抛出空对象异常，程序停止运行
        System.out.println("list1："+list1.toString());
        
        
//        for (String obj : lista)          //语法错，不能逐元循环，因为SeqList<T>类没有实现迭代器              
   }
}
/*
程序运行结果如下：    
lista：SeqList5(A, B, C, D, E) 
list1：SeqList5() 
Exception in thread "main" java.lang.NullPointerException: x==null
    at SeqList.insert(SeqList.java:89)
    at SeqList.insert(SeqList.java:106)
    at SeqList_String.main(SeqList_String.java:10)

*/
//@author：Yeheya。2014-9-7