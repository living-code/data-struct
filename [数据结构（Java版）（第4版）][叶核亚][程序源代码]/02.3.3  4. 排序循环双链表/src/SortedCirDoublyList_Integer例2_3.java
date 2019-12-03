//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月19日
//2.2  线性表的顺序存储和实现
//2.3.2   单链表
//6.  排序单链表
//【例2.3】  顺序表与排序顺序表的插入操作。//同SortedSeqList_Integer 

public class SortedCirDoublyList_Integer例2_3 
{
    public static void main(String args[])
    {
        Integer[] value={70,20,80,30,60};        //自动将int包装成Integer实例
        CirDoublyList<Integer> list1 = new CirDoublyList<Integer>(value);
        SortedCirDoublyList<Integer> slist1 = new SortedCirDoublyList<Integer>(list1);  //子类对象引用子类实例，由顺序表构造排序顺序表
        list1.insert(0,10);                      //调用父类的insert(int i, T x)，指定位置插入
        list1.insert(50);                        //调用父类insert(T x)，循环双链表尾插入，将int包装成Integer实例
        slist1.insert(50);                        //子类对象调用子类方法，排序循环双链表按值插入，覆盖
        System.out.print("list1="); list1.print();
        System.out.print("slist1="); slist1.print();
//        slist1.insert(0,90);                      //排序循环双链表插入，抛出异常
        
        //（3） 排序循环双链表的查找和删除操作
        Integer key = 55;                        //自动将int包装成Integer实例
        DoubleNode<Integer> find = slist1.search(key);    //运行时多态，执行子类覆盖的方法
        System.out.println("slist1顺序查找 "+key+"， "+((find==null)?"不":"")+"成功");
        
        list1.remove(1);                         //调用remove(int i)
        key = 1;                                 //自动将int包装成Integer实例
        list1.remove(key);                      //调用remove(T key)
        System.out.print("list1 删除第"+1+"个元素，删除元素"+key+"，list1="); list1.print();
        slist1.remove(1);                         //调用remove(int i)，继承
        slist1.remove(key);                      //调用remove(T key)，继承，其中调用子类覆盖的search(key)，运行时多态
        System.out.print("slist1 删除第"+1+"个元素，删除元素"+key+"，slist1="); slist1.print();
        
        //5. 类型的多态，子类对象即是父类对象
        //（1） 子类对象即是父类对象，赋值相容
        CirDoublyList<Integer> list2 = new CirDoublyList<Integer>(slist1); //单链表深拷贝，由排序单链表构造单链表
        SortedCirDoublyList<Integer> slist2 = new SortedCirDoublyList<Integer>(slist1); //排序单链表深拷贝
        System.out.print("list2="); list2.print();
        System.out.print("slist2="); slist2.print();

        //equals()，继承，父与子均可比
        System.out.println("list1.equals(slist1)？ "+list1.equals(slist1));  //父类equals(子)
        System.out.println("slist1.equals(list1)？ "+slist1.equals(list1));  //子类equals(父)
        System.out.println("slist1.equals(slist2)？ "+slist1.equals(slist2));//子类equals(子)
        
    }
}
/*

list1=(10,70,20,80,30,60,50)，(50,60,30,80,20,70,10)
slist1=(20,30,50,60,70,80)，(80,70,60,50,30,20)
20？30？50？slist1顺序查找 55， 不成功
list1 删除第1个元素，删除元素1，list1=(10,20,80,30,60,50)，(50,60,30,80,20,10)
slist1 删除第1个元素，删除元素1，slist1=(20,50,60,70,80)，(80,70,60,50,20)
list2=(20,50,60,70,80)，(80,70,60,50,20)
slist2=(20,50,60,70,80)，(80,70,60,50,20)
list1.equals(slist1)？ false
slist1.equals(list1)？ false
slist1.equals(slist2)？ true





*/
//@author：Yeheya。2014-8-20


/*
泛型类问题讨论:
程序调试情况如下：
        SinglyLinkedList<Object> list3 = new SinglyLinkedList<Object>();
//        SortedSinglyLinkedList<Object> list4 = new SortedSinglyLinkedList<Object>();
                                         //编译错，Object类不能作为E的实际参数，没有实现实现Comparable<E>接口
        SortedSinglyLinkedList<Integer> list4 = new SortedSinglyLinkedList<Integer>();
//        list4.insert(new Object());     //编译错，参数类型不匹配
*/