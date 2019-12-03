//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月19日，JDK 8.11
//§2.2  线性表的顺序存储和实现
//§2.2.3 排序顺序表

public class SortedSeqList_String 
{
    public static void main(String args[])
    {
        //2.2.3  排序顺序表
        String values[]={"F","C","B","A","D","E"};
        SortedSeqList<String> lista = new SortedSeqList<String>(values);
        SortedSeqList<String> listb = new SortedSeqList<String>(lista);  //执行拷贝构造方法
        lista.insert("A");                       //按值插入，覆盖
//        lista.insert(0,"G");                   //调用insert(int i, T x)，抛出 UnsupportedOperationException
        listb.remove(0);                         //调用remove(int i)，继承
        System.out.println("排序顺序表lista: "+lista.toString()+"\n排序顺序表listb: "+listb.toString()+//执行子类的toString()
                           "，lista.equals(listb)? "+lista.equals(listb));//子类执行继承父类的equals()
        String key1 = "F";
        System.out.println("  lista顺序查找 "+key1+", "+((lista.search(key1)==-1)?"不":"")+"成功");//执行子类覆盖的方法
   }
}
/*
程序运行结果如下。
排序顺序表lista: (A, A, B, C, D, E, F) 
排序顺序表listb: (B, C, D, E, F) ，lista.equals(listb)? false
SortedSeqList.indexOf(key,start)，A？A？B？C？D？E？F？  lista顺序查找 F, 成功

*/

/*
泛型类问题讨论:？？
程序调试情况如下：
        SinglyLinkedList<Object> list3 = new SinglyLinkedList<Object>();
//        SortedSinglyLinkedList<Object> list4 = new SortedSinglyLinkedList<Object>();
                                         //编译错，Object类不能作为E的实际参数，没有实现实现Comparable<E>接口
        SortedSinglyLinkedList<Integer> list4 = new SortedSinglyLinkedList<Integer>();
//        list4.insert(new Object());     //编译错，参数类型不匹配
*/
