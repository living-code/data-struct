//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月20日
//第9章 9.5.3   双链表的排序算法
//图9.17 循环双链表的归并排序算法
//4-0卷读程1

public class SortedCirDoublyList_merge 
{
    public static void main(String[] args) 
    {
//        Integer[] value1={15,21,36,53}, value2={11,36,47,76,99}; //图9.17
        Integer[] value1={26,37,61,81}, value2={18,53,75,86,90};   //4-0卷读程1
        SortedCirDoublyList<Integer> slist1 = new SortedCirDoublyList<Integer>(value1);
        SortedCirDoublyList<Integer> slist2 = new SortedCirDoublyList<Integer>(value2);
        System.out.println("slist1= "+slist1.toString());        
        System.out.println("slist2= "+slist2.toString());    
        slist1.merge(slist2);                              //归并两条排序循环双链表
        System.out.println("归并，slist2.merge(slist1)");        
        System.out.print("slist1=");  slist1.print();
        System.out.print("slist2=");  slist2.print();

/*        Integer[] value3=Array1.randomInteger(5, 100);        //见例1.4
        Integer[] value4=Array1.randomInteger(5, 100);
        SortedCirDoublyList<Integer> slist3 = new SortedCirDoublyList<Integer>(value3);
        SortedCirDoublyList<Integer> slist4 = new SortedCirDoublyList<Integer>(value4);
        System.out.println("\nslist3="+slist3.toString());
        System.out.println("slist4="+slist4.toString());
        SortedCirDoublyList<Integer> slist5 = slist3.mergeWith(slist4);      //归并两个排序顺序表
        System.out.println("归并，slist5 = slist3.mergeWith(slist4) ");
        System.out.println("slist3="+slist3.toString());
        System.out.println("slist4="+slist4.toString());
        System.out.print("slist5=");  slist5.print();*/
    }
}

/* 
程序运行结果如下：    
      //图9.17
slist1= SortedCirDoublyList(15,21,36,53)
slist2= SortedCirDoublyList(11,36,47,76,99)
归并，slist2.merge(slist1)
slist1=(11,15,21,36,36,47,53,76,99)，(99,76,53,47,36,36,21,15,11)
slist2=()，()

   //4-0卷读程1
slist1= SortedCirDoublyList(26,37,61,81)
slist2= SortedCirDoublyList(18,53,75,86,90)
归并，slist2.merge(slist1)
slist1=(18,26,37,53,61,75,81,86,90)，(90,86,81,75,61,53,37,26,18)
slist2=()，()

slist3=SortedCirDoublyList(1,1,29,53,66)
slist4=SortedCirDoublyList(0,9,36,38,42)
归并，slist5 = slist3.mergeWith(slist4) 
slist3=SortedCirDoublyList(1,1,29,53,66)
slist4=SortedCirDoublyList(0,9,36,38,42)
slist5=(0,1,1,9,29,36,38,42,53,66)，(66,53,42,38,36,29,9,1,1,0)
*/


//@author：Yeheya。2014-8-22



