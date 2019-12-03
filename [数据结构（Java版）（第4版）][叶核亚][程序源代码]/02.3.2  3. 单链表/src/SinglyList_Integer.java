//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月11日
//§2.3 线性表的链式存储和实现
//3. 带头结点的单链表类

public class SinglyList_Integer 
{   
    public static void main(String args[])
    {
//        Integer[] values=MyArray.randomInteger(5, 100);        //见例1.3
        Integer[] values={80,70,20,60,30};        //自动将int包装成Integer实例
        SinglyList<Integer> list1 = new SinglyList<Integer>(values);
        list1.insert(0,90);                      //调用insert(i,x)，单链表插入
        list1.insert(1);                         //调用insert(x)，单链表尾插入，将int包装成Integer实例
        System.out.println("list1="+list1.toString());
        
        //5. 单链表的浅拷贝与深拷贝
        //【思考题2-6】
        SinglyList<Integer> list2 = new SinglyList<Integer>(list1);   //深拷贝
        System.out.print("list2="+list2.toString());
        System.out.println("，list1.equals(list2)? "+list1.equals(list2));

        list2.set(0, new Integer(list1.get(0).intValue()+100));
        list2.remove(list2.size()-1);                      //删除最后一个元素
        list2.remove(100);                                 //序号越界，没删除
        System.out.print("list2="+list2.toString());
        System.out.println("，list1.equals(list2)? "+list1.equals(list2));
    }
}
/*
程序运行结果如下：
list1=SinglyList(90,80,70,20,60,30,1)
list2=SinglyList(90,80,70,20,60,30,1)，list1.equals(list2)? true
list2=SinglyList(190,80,70,20,60,30)，list1.equals(list2)? false
*/
//@author：Yeheya。2014-9-12