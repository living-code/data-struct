//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年9月12日
//§2.3 线性表的链式存储和实现
//3. 带头结点的单链表类
//【例2.5】单链表逆转。

public class SinglyList_reverse 
{
    //构造反序单链表，由values数组提供元素。返回值类型前声明类型参数T。
    //采用头插入，单链表元素次序与数组元素次序相反
    public static <T> SinglyList<T> createReverse(T[] values)
    {
        SinglyList<T> list = new SinglyList<T>();          //创建空单链表，只有头结点
        for (int i=0; i<values.length; i++)
            list.head.next = new Node<T>(values[i], list.head.next);//头插入
        return list;                                       //返回单链表对象引用
    }
    
    //将单链表逆转，泛型方法，返回值类型前声明类型参数T
    public static <T> void reverse(SinglyList<T> list)
    {
        Node<T> p=list.head.next, front=null;              //head必须声明为public 
        while (p!=null)
        {
            Node<T> succ = p.next;                         //succ是p结点的后继结点
            p.next = front;                                //使p.next指向p结点的前驱结点
            front = p;
            p = succ;                                      //p到达后继结点
        }
        list.head.next = front;                  //设置头结点的地址域指向原单链表的最后一个结点
    }
  
    public static void main(String args[])
    {
        String[] values={"A","B","C","D","E","F"};
        SinglyList<String> lista = new SinglyList<String>(values);
        System.out.print("lista = "+lista.toString());
        reverse(lista);
        System.out.println("，逆转后 "+lista.toString());
        
        SinglyList<String> listb = createReverse(values);
        System.out.print("listb = "+listb.toString());
        System.out.println("，lista.equals(listb)? "+lista.equals(listb));        
    }
}
/*
程序运行结果如下：    
list1 = SinglyList(A,B,C,D,E,F)，逆转后 SinglyList(F,E,D,C,B,A)
list2 = SinglyList(F,E,D,C,B,A)，list1.equals(list2)? true

*/
//@author：Yeheya。2014-9-12
    