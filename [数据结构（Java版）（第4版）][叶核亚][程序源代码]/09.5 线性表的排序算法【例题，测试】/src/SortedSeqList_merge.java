//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月19日
//9.5.1   顺序表的排序算法
//??
public class SortedSeqList_merge 
{
    public static void main(String[] args) 
    {
/*        Integer[] value1=MyArray.randomInteger(n, size);        //见例1.3
        Integer[] value2=MyArray.random(5);
//        Integer[] value1={90,70,50,30,10};        //自动将int包装成Integer实例
//        Integer[] value2={80,60,40,20};
        SortedSeqList<Integer> slist1 = new SortedSeqList<Integer>(value1);
        SortedSeqList<Integer> slist2 = new SortedSeqList<Integer>(value2);
        System.out.println("slist1="+slist1.toString());
        System.out.println("slist2="+slist2.toString());
        slist2.merge(slist1);                                   //排序顺序表归并
        System.out.println("归并，slist2.merge(slist1)");        
        System.out.println("slist1="+slist1.toString());
        System.out.println("slist2="+slist2.toString());
        
        SortedSeqList<Integer> slist3 = slist1.mergeWith(slist1);      //归并两个排序顺序表
        System.out.println("归并，slist3 = slist1.mergeWith(slist1) ");
        System.out.println("slist1="+slist1.toString());
        System.out.println("slist2="+slist2.toString());
        System.out.println("slist3="+slist3.toString());*/
    }
}

/*     
slist1=(10, 30, 50, 70, 90) 
slist2=(20, 40, 60, 80) 
归并，slist2.merge(slist1)
slist1=(10, 30, 50, 70, 90) 
slist2=(10, 20, 30, 40, 50, 60, 70, 80, 90) 
归并，slist3 = slist1.mergeWith(slist1) 
slist1=(10, 30, 50, 70, 90) 
slist2=(10, 20, 30, 40, 50, 60, 70, 80, 90) 
slist3=(10, 10, 30, 30, 50, 50, 70, 70, 90, 90) 


slist1=(6, 29, 57, 70, 79) 
slist2=(18, 70, 76, 87, 95) 
归并，slist2.merge(slist1)
slist1=(6, 29, 57, 70, 79) 
slist2=(6, 18, 29, 57, 70, 70, 76, 79, 87, 95) 
归并，slist3 = slist1.mergeWith(slist1) 
slist1=(6, 29, 57, 70, 79) 
slist2=(6, 18, 29, 57, 70, 70, 76, 79, 87, 95) 
slist3=(6, 6, 29, 29, 57, 57, 70, 70, 79, 79) 

*/
