//《数据结构（Java版）（第4版）》，作者：叶核亚，2015年1月30日
//§2.2.3  排序顺序表
//【例2.5】  使用线性表表示集合，实现集合运算。
//（1） （排序）线性表表示集合的特性
        //【实验2.1】  【思考题2-4】SeqList<T>类声明以下方法，子类SortedSeqList<T>是否可用？为什么？
        //方法返回值问题讨论
public class SeqList_union 
{
    public static void main(String args[])
    { 
        Integer[] values1={10,30,50,70,90}, values2={20,40,60,80};
        SeqList<Integer> list1=new SeqList<Integer>(values1);        //顺序表
        SeqList<Integer> list2=new SeqList<Integer>(values2);
        System.out.println("list1="+list1.toString()+"，list2="+list2.toString());        
        System.out.println("list1.union(list2)="+list1.union(list2));//顺序表合并连接，尾插入
        
        list1 = new SortedSeqList<Integer>(values1);                 //父类对象引用子类实例
        list2 = new SortedSeqList<Integer>(values2);
        System.out.println("\nlist1="+list1.toString()+"，list2="+list2.toString());        
        System.out.println("list1.union(list2)="+list1.union(list2));//仍然执行顺序表合并连接，尾插入？？[答]重载，编译时确定

        SortedSeqList<Integer> slist1 = new SortedSeqList<Integer>(values1);
        SortedSeqList<Integer> slist2 = new SortedSeqList<Integer>(values2);
        System.out.println("\nslist1="+slist1.toString()+"，slist2="+slist2.toString());        
        System.out.println("slist1.union(slist2)="+slist1.union(slist2));//排序执行顺序表合并，插入排序

    }
}
/*
程序运行结果如下：  
list1=SeqList(10, 30, 50, 70, 90) ，list2=SeqList(20, 40, 60, 80) 
list1.union(list2)=SeqList(10, 30, 50, 70, 90, 20, 40, 60, 80)                 //合并，首尾相接 

list1=SortedSeqList(10, 30, 50, 70, 90) ，list2=SortedSeqList(20, 40, 60, 80) 
list1.union(list2)=SeqList(10, 30, 50, 70, 90, 20, 40, 60, 80)                 //合并，首尾相接 

slist1=SortedSeqList(10, 30, 50, 70, 90) ，slist2=SortedSeqList(20, 40, 60, 80) 
slist1.union(slist2)=SortedSeqList(10, 20, 30, 40, 50, 60, 70, 80, 90)         //排序，升序

*/