//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月19日
//9.5.2   单链表的排序算法

public class SortedSinglyList_selectsort 
{
    public static void main(String args[])
    {
        //由单链表list构造排序单链表，直接选择排序
//        Integer[] value1=ObjectArray.random(5);        //见例1.3
        Integer[] value={26,66,97,11,19,49,38};        //图9.14
        SinglyList<Integer> list1 = new SinglyList<Integer>(value);
        SortedSinglyList<Integer> slist1 = new SortedSinglyList<Integer>(list1);
        System.out.println("单链表list1: "+list1.toString());        
        System.out.println("排序单链表slist1: "+slist1.toString());    
    }
}
/*
程序运行结果如下：    
 //第9章，由单链表list构造排序单链表，选择排序       //图9.14
(11,66,97,26,19,49,38)
(11,19,97,26,66,49,38)
(11,19,26,97,66,49,38)
(11,19,26,38,66,49,97)
(11,19,26,38,49,66,97)
(11,19,26,38,49,66,97)
单链表list1: (26,66,97,11,19,49,38)
排序单链表slist1: (11,19,26,38,49,66,97)

*/
//@author：Yeheya。2014-8-19
