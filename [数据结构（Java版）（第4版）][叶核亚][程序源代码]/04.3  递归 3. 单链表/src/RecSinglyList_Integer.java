//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月11日
//4.4 递归
//3. 单链表的递归算法

public class RecSinglyList_Integer 
{   
    public static void main(String args[])
    {
        Integer value[]={80,70,20,60,30,30};        //自动将int包装成Integer实例
        RecSinglyList<Integer> list1 = new RecSinglyList<Integer>(value);
        RecSinglyList<Integer> list2 = new RecSinglyList<Integer>(list1);   //深拷贝
        System.out.println("list1="+list1.toString());
        System.out.print("list2="+list2.toString());
        System.out.println("，list1.equals(list2)? "+list1.equals(list2));
        
        int key=value[value.length-1];
        System.out.println("查找"+key+"结果："+list1.search(key));
        int x=value[0];
        list2.replaceAll(key, x);
        System.out.println("替换list2中所有"+key+"为"+x);
        System.out.println("list1="+list1.toString());
        System.out.print("list2="+list2.toString());
        System.out.println("，list1.equals(list2)? "+list1.equals(list2));
    }
}
/*
程序运行结果如下：
list1=RecSinglyList(80, 70, 20, 60, 30, 30)
list2=RecSinglyList(80, 70, 20, 60, 30, 30)，list1.equals(list2)? true
查找30结果：30
替换list2中所有30为80
list1=RecSinglyList(80, 70, 20, 60, 30, 30)
list2=RecSinglyList(80, 70, 20, 60, 80, 80)，list1.equals(list2)? false
*/
//author：Yeheya。2014-9-23
