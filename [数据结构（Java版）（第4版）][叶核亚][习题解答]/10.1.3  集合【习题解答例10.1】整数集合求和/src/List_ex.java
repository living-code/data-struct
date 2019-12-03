//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月24日，JDK 7.60
//10.1.3   Java集合框架

import java.util.*;

public class List_ex 
{
    public static void sum(List<Integer> list)
    {
    	ListIterator<Integer> it = list.listIterator();      //获得列表迭代器对象
        System.out.print("nextIndex="+it.nextIndex()+"，");   //0
        int sum=0, value=0;
        while (it.hasNext())
        {
            value = it.next().intValue();
        	sum += value;
    	    System.out.print(value);
        	if (it.hasNext())
        	    System.out.print("+");
        }        	
        System.out.println("="+sum);//)+"，nextIndex="+it.nextIndex());-1
//        it.next();                    //抛出java.util.NoSuchElementException
        
        sum=0;
        System.out.print("nextIndex="+it.previousIndex()+"，");
        while (it.hasPrevious())                           //仅作用于列表迭代器对象
        {
            value=it.previous().intValue();
        	sum += value;
    	    System.out.print(value);
        	if (it.hasPrevious())
        	    System.out.print("+");
        }        	
        System.out.println("="+sum+"，nextIndex="+it.previousIndex());
//        it.previous();                    //抛出java.util.NoSuchElementException
    }
	
    //删除list<T>的第i个元素，返回被删除元素。使用迭代器
    public static <T> T remove(List<T> list, int i)
    {
        Iterator<T> it = list.iterator();        //获得迭代器对象
        T value=null;
        int j=0;
        for (j=-1; j<i && it.hasNext(); j++)
            value = it.next();
        if (j==i)
            it.remove();                         //删除第i个元素
        return value;
    }
    
	public static void main(String args[])
    {
    	List<Integer> list1;// = new ArrayList();             //空表
//        System.out.println("list1="+list1.toString()+"，");
//    	sum(list1);

    	int n=10;
    	list1 = MyCollections.random(n);
        System.out.println("list1="+list1.toString()+"，");
    	sum(list1);
        System.out.println("删除"+remove(list1,0)+"，"+list1.toString());
        System.out.println("删除"+remove(list1,n-2)+"，"+list1.toString());
        System.out.println("删除"+remove(list1,1)+"，"+list1.toString());
    	
/*    	List<Integer> list2 = new LinkedList(list1);    	//深拷贝到对象??
        System.out.println("list2:"+list1.toString()+"，");
    	ListIterator<Integer> lit = list2.listIterator();  //获得列表迭代器对象
        System.out.print("nextIndex="+lit.nextIndex()+"，");
    	Integer value = lit.next();
    	lit.remove();                                       //删除第一个元素
                                //若不执行it.next();，则抛出java.lang.IllegalStateException异常
        System.out.println("删除"+value+"，list2:"+list2.toString()+"， ");
        System.out.print("nextIndex="+lit.nextIndex()+"，");
    	value = lit.next();
        lit.remove();                                       //删除第一个元素
        System.out.println("删除"+value+"，list2:"+list2.toString());
    	sum(list2);                              //同时有两个迭代器
       
        System.out.print("nextIndex="+lit.nextIndex()+"，");
//        lit.previous();
        lit.add(value);                                    //插入第一个元素
                         //若先执行it.previous();，则抛出java.lang.IllegalStateException异常
        System.out.println("插入"+value+"，list2:"+list2.toString());

        System.out.print("nextIndex="+lit.nextIndex()+"，");
        value = new Integer(100);
        lit.next();                               //插入或删除后调用next确定返回元素
        lit.set(value);          //将集合当前元素替换为x，当前元素序号未改变
        System.out.println("替换"+value+"，list2:"+list2.toString());
        value = new Integer(200);
    	lit.set(value);                    //可以连续替换
        System.out.println("替换"+value+"，list2:"+list2.toString());*/
    }
}
/*
程序运行结果如下：    
list1:[]，
nextIndex=0，=0，nextIndex=0
nextIndex=-1，=0，nextIndex=-1
list1:[83, 37, 48, 21, 36, 7, 81, 45, 27, 59]，
nextIndex=0，83+37+48+21+36+7+81+45+27+59=444，nextIndex=10
nextIndex=9，59+27+45+81+7+36+21+48+37+83=444，nextIndex=-1
list2:[83, 37, 48, 21, 36, 7, 81, 45, 27, 59]，
nextIndex=0，删除83，list2:[37, 48, 21, 36, 7, 81, 45, 27, 59]， 
nextIndex=0，删除37，list2:[48, 21, 36, 7, 81, 45, 27, 59]
nextIndex=0，48+21+36+7+81+45+27+59=324，nextIndex=8
nextIndex=7，59+27+45+81+7+36+21+48=324，nextIndex=-1
nextIndex=0，插入37，list2:[37, 48, 21, 36, 7, 81, 45, 27, 59]
nextIndex=1，替换100，list2:[37, 100, 21, 36, 7, 81, 45, 27, 59]
替换200，list2:[37, 200, 21, 36, 7, 81, 45, 27, 59]

*/
