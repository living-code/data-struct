//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月19日
//9.5.2   单链表的排序算法
        //3.  归并两条排序单链表

public class SortedSinglyList_merge 
{
    public static void main(String[] args) 
    {
        Integer[] value1={15,21,36,53};                    //图9.15
        Integer[] value2={11,36,47,76,99};                 //图9.15
        SortedSinglyList<Integer> slist1 = new SortedSinglyList<Integer>(value1);
        SortedSinglyList<Integer> slist2 = new SortedSinglyList<Integer>(value2);
        System.out.println("slist1= "+slist1.toString());        
        System.out.println("slist2= "+slist2.toString());    
        slist1.merge(slist2);                           //归并两条排序单链表
        System.out.println("归并，slist2.merge(slist1)");        
        System.out.println("slist1="+slist1.toString());
        System.out.println("slist2="+slist2.toString());
        
        Integer[] value3=Array1.randomInteger(5, 100);        //见例1.4
        Integer[] value4=Array1.randomInteger(5, 100); 
        SortedSinglyList<Integer> slist3 = new SortedSinglyList<Integer>(value3);
        SortedSinglyList<Integer> slist4 = new SortedSinglyList<Integer>(value4);
        System.out.println("\nslist3="+slist3.toString());
        System.out.println("slist4="+slist4.toString());
        SortedSinglyList<Integer> slist5 = slist3.mergeWith(slist4);      //归并两个排序顺序表
        System.out.println("归并，slist5 = slist3.mergeWith(slist4) ");
        System.out.println("slist3="+slist3.toString());
        System.out.println("slist4="+slist4.toString());
        System.out.println("slist5="+slist5.toString());
    }
}

/* 
程序运行结果如下：    
      //图9.15
slist1: (15,21,36,53)
slist2: (11,36,47,76,99)
归并，slist2.merge(slist1)
slist1=(11,15,21,36,36,47,53,76,99)
slist2=()

slist3=(8,20,55,57,86)
slist4=(1,46,72,88,95)
归并，slist5 = slist3.mergeWith(slist4) 
slist3=(8,20,55,57,86)
slist4=(1,46,72,88,95)
slist5=(1,8,20,46,55,57,72,86,88,95)


slist3=(8,11,23,27,83)
slist4=(36,39,43,51,55)
归并，slist5 = slist3.mergeWith(slist4) 
slist3=(8,11,23,27,83)
slist4=(36,39,43,51,55)
slist5=(8,11,23,27,36,39,43,51,55,83)


slist3=SortedSinglyList(48,55,64,68,92)
slist4=SortedSinglyList(33,34,69,76,82)
归并，slist5 = slist3.mergeWith(slist4) 
slist3=SortedSinglyList(48,55,64,68,92)
slist4=SortedSinglyList(33,34,69,76,82)
slist5=SortedSinglyList(33,34,48,55,64,68,69,76,82,92)


slist3=SortedSinglyList(6,58,80,96,97)
slist4=SortedSinglyList(10,37,54,69,74)
归并，slist5 = slist3.mergeWith(slist4) 
slist3=SortedSinglyList(6,58,80,96,97)
slist4=SortedSinglyList(10,37,54,69,74)
slist5=SortedSinglyList(6,10,37,54,58,69,74,80,96,97)


slist3=SortedSinglyList(17,36,44,56,82)
slist4=SortedSinglyList(35,36,39,50,62)
归并，slist5 = slist3.mergeWith(slist4) 
slist3=SortedSinglyList(17,36,44,56,82)
slist4=SortedSinglyList(35,36,39,50,62)
slist5=SortedSinglyList(17,35,36,36,39,44,50,56,62,82)

//@author：Yeheya。2014-8-19


*/
