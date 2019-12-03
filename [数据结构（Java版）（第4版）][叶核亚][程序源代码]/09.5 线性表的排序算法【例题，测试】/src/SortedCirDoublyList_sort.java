//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月20日
//第9章 9.5.3 循环双链表的排序算法
//循环双链表的快速排序算法、直接插入排序、直接选择排序

public class SortedCirDoublyList_sort 
{
    public static void main(String args[])
    {
        //由循环双链表构造排序循环双链表，快速排序算法 
        Integer[] value1={37,82,16,93,25,70};          //图9.15
        CirDoublyList<Integer> list1 = new CirDoublyList<Integer>(value1);
        System.out.print("list1= "); list1.print();        
        SortedCirDoublyList<Integer> slist1 = new SortedCirDoublyList<Integer>(list1);
        System.out.print("slist1= "); slist1.print(); 

        //由单链表构造排序循环双链表。直接插入排序
        Integer[] value2=Array1.randomInteger(5, 100);        //见例1.4
        SinglyList<Integer> list2 = new SinglyList<Integer>(value2);
        System.out.println("\nlist2= "+list2.toString());        
        SortedCirDoublyList<Integer> slist2 = new SortedCirDoublyList<Integer>(list2);
        System.out.print("slist2= "); slist2.print(); 

        //由数组构造排序循环双链表，直接选择排序
        Integer[] value3=Array1.randomInteger(5, 100);        //见例1.4
        System.out.print("\n关键字序列：");  Array1.print(value3);
        SortedCirDoublyList<Integer> slist3 = new SortedCirDoublyList<Integer>(value3);
        System.out.print("slist3= "); slist3.print(); 
 
    }
}
/*
程序运行结果如下：    
 //第9章，由循环双链表构造排序循环双链表，快速排序算法      图9.15
list1= (37,82,16,93,25,70)，(70,25,93,16,82,37)
循环双链表的快速排序
25..70,  vot=37  SortedCirDoublyList(25,16,37,93,82,70)
16..25,  vot=25  SortedCirDoublyList(16,25,37,93,82,70)
70..93,  vot=93  SortedCirDoublyList(16,25,37,70,82,93)
70..82,  vot=70  SortedCirDoublyList(16,25,37,70,82,93)
slist1= (16,25,37,70,82,93)，(93,82,70,37,25,16)

list2= SinglyList(58,67,54,52,29)
循环双链表的直接插入排序
SortedCirDoublyList(58)，p=58
SortedCirDoublyList(58,67)，p=67
SortedCirDoublyList(54,58,67)，p=54
SortedCirDoublyList(52,54,58,67)，p=52
SortedCirDoublyList(29,52,54,58,67)，p=29
slist2= (29,52,54,58,67)，(67,58,54,52,29)

list2= SinglyList(39,8,53,11,79)
循环双链表的直接插入排序
SortedCirDoublyList(39)，p=39
SortedCirDoublyList(8,39)，p=8
SortedCirDoublyList(8,39,53)，p=53
SortedCirDoublyList(8,11,39,53)，p=11
SortedCirDoublyList(8,11,39,53,79)，p=79
slist2= SortedCirDoublyList(8,11,39,53,79)

关键字序列： 71 90 80 71 55
循环双链表的直接选择排序
slist3= (55,71,71,80,90)，(90,80,71,71,55)

关键字序列： 11 71 62 4 8
循环双链表的直接选择排序
SortedCirDoublyList(4,71,62,11,8)
SortedCirDoublyList(4,8,62,11,71)
SortedCirDoublyList(4,8,11,62,71)
SortedCirDoublyList(4,8,11,62,71)
SortedCirDoublyList(4,8,11,62,71)
slist3= SortedCirDoublyList(4,8,11,62,71)


list1= CirDoublyList(45,75,16,80,14,87,14,36,58)，快速排序
36..58,  vot=45  SortedCirDoublyList(36,14,16,14,45,87,80,75,58)
14..36,  vot=36  SortedCirDoublyList(14,14,16,36,45,87,80,75,58)
14..16,  vot=14  SortedCirDoublyList(14,14,16,36,45,87,80,75,58)
14..16,  vot=14  SortedCirDoublyList(14,14,16,36,45,87,80,75,58)
58..87,  vot=87  SortedCirDoublyList(14,14,16,36,45,58,80,75,87)
58..75,  vot=58  SortedCirDoublyList(14,14,16,36,45,58,80,75,87)
75..80,  vot=80  SortedCirDoublyList(14,14,16,36,45,58,75,80,87)
slist1= SortedCirDoublyList(14,14,16,36,45,58,75,80,87)


*/
//@author：Yeheya。2014-8-20
