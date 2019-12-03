//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月24日，JDK 7.60
//10.1.3   Java集合框架
import java.util.*;

public class MyCollections_ex 
{
    public static void main(String args[])
    {
        int n=8;
        List<Integer> list = MyCollections.random(n);     	//随机数集合
        list.add(list.get(list.size()-1));                  //添加最后一个元素，包含关键字相同元素
        System.out.println("随机数集合 list="+list.toString());
        MyCollections.sum(list);                        	//ArrayList<Integer>是Collection<Integer>的子类

        TreeSet<Integer> treeset = new TreeSet<Integer>(list);     //由列表集合list构造树集合，排序、互异
        System.out.print("互异排序树集合 treeset="+treeset.toString()+"，");
        System.out.println("treeset.comparator()="+treeset.comparator()); //null
        MyCollections.sum(treeset);                      //TreeSet<Integer>是Collection<Integer>的子类
    	
        treeset = MyCollections.randomSorted(n);
        System.out.println("，互异排序树集合 treeset="+treeset.toString());
        MyCollections.sum(treeset);                      //TreeSet<Integer>是Collection<Integer>的子类
    }
}
/*
程序运行结果如下： 
随机数集合 list=[87, 73, 37, 62, 95, 18, 42, 86, 86]
sum(java.util.ArrayList) = 87+73+37+62+95+18+42+86+86=586
互异排序树集合 treeset=[18, 37, 42, 62, 73, 86, 87, 95]，treeset.comparator()=null
sum(java.util.TreeSet) = 18+37+42+62+73+86+87+95=500
随机数：97 53 41 95 24 17 43 6 ，互异排序树集合 treeset=[6, 17, 24, 41, 43, 53, 95, 97]
sum(java.util.TreeSet) = 6+17+24+41+43+53+95+97=376


*/
//@author：Yeheya。2015-4-10

