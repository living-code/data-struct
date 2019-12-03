//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月26日，JDK 8.25
//10.1  Java集合框架
//【例10.1】  素数集合。//【思考题10-1】

import java.util.*;

public class MyCollections                                 //定义对集合的操作
{
    public static void print(Collection<?> coll)           //输出集合。toString()没有返回类名
    {
        System.out.print(coll.getClass().getName()+"[");   //返回类名
        Iterator<?> it = coll.iterator();                  //返回迭代器对象
        while (it.hasNext())                               //若有后继元素，使用迭代器遍历一个集合
            System.out.print(it.next().toString()+" ");    //返回后继元素
        
//或者        for (Object obj : coll)                 //逐元循环，obj逐个引用coll集合元素，次序同集合迭代
//            System.out.print(obj.toString());
        
        System.out.println("]");
    }

    //【思考题10-1②，习题解答】
    public static int sum(Collection<Integer> coll)        //返回集合coll所有元素之和
    {
        System.out.print("sum("+coll.getClass().getName()+") = ");  //返回类名
        Iterator<Integer> it = coll.iterator();            //获得迭代器对象
        int s=0;
        while (it.hasNext())
        {
            int value=it.next().intValue();
            s += value;
            System.out.print(value);
            if (it.hasNext())
                System.out.print("+");
        }           
        System.out.println("="+s);
        return s;
    }

    //【思考题10-1②，试题库】
    public static List<Integer> random(int n)              //返回存储n个随机数的列表，范围是0～99
    {
        List<Integer> list = new ArrayList<Integer>(n*2);
//    List<Integer> list = new LinkedList<Integer>();
        ListIterator<Integer> it = list.listIterator();    //获得列表迭代器对象
        for (int i=0; i<n; i++)
        {
//          System.out.println("nextIndex="+it.nextIndex());
            it.add(new Integer((int)(Math.random()*100))); //产生随机数通过列表迭代器对象添加元素，可以连续添加
        }
        return list;
    }	
    
    public static TreeSet<Integer> randomSorted(int n)     //返回存储n个互异排序随机数的树集合
    {
        TreeSet<Integer> treeset = new TreeSet<Integer>(); //默认元素可比较
        System.out.print("随机数：");
        for (int i=0; i<n; i++)
        {
            int value = (int)(Math.random()*100);         //产生随机数
            System.out.print(value+" ");
            treeset.add(new Integer(value));               //树集合添加元素
        }
//        System.out.println();
        return treeset;
    }
}
//@author：Yeheya。2015-4-10
