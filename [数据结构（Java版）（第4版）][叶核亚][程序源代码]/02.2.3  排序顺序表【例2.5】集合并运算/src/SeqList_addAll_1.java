//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月15日
//§2.2.3  排序顺序表
//【例2.5】  使用线性表表示集合，实现集合运算。
//（1） （排序）线性表表示集合的特性

public class SeqList_addAll_1 
{
    public static void main(String args[])
    {
        //两个SeqList<String>合并，首尾相接 
        String[] stra={"E","D"}, strb={"C","B","A"};        
        SeqList<String> lista = new SeqList<String>(stra);        
        SeqList<String> listb = new SeqList<String>(strb);           
        lista.addAll(listb);                               //两个SeqList<String>合并，首尾相接 
        System.out.println("lista="+lista.toString()+"，listb="+listb.toString());

        //两个SortedSeqList<String>合并，插入排序 
        lista = new SortedSeqList<String>(stra);           //父类对象引用子类实例     
        listb = new SortedSeqList<String>(strb);           
        lista.addAll(listb);                               //两个SortedSeqList<String>合并，插入排序 
        System.out.println("lista="+lista.toString()+"，listb="+listb.toString());
    }
}
/*
程序运行结果如下：  
lista=(E, D, C, B, A) ，listb=(C, B, A)                     //合并，首尾相接 
lista=(A, B, C, D, E) ，listb=(A, B, C)                     //排序，升序
*/