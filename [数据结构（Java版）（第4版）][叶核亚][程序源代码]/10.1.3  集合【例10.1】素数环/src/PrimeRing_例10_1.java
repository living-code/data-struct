//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月26日
//10.1 集合框架
//10.1.3 集合
//【例10.1】  使用集合求解素数环。同【例4.3】 求解素数环问题。

import java.util.*;

public class PrimeRing_例10_1 
{
    public PrimeRing_例10_1(int max)                        //求1～max素数环
    {
        Collection<Integer> primeset = createPrime(max);   //素数集合
        System.out.println("素数集合: "+primeset.getClass().getName()+primeset.toString());
        
        List<Integer> ring = new ArrayList<Integer>(max);  //数组列表，存储素数环
        ring.add(1);                                       //素数环添加Integer(1)

        Queue<Integer> que = new LinkedList<Integer>();    //创建空链表，作为队列
        for (int i=2; i<=max; i++)                         //2～max全部入队
            que.add(i);                                    //入队
        System.out.println("队列: "+que.getClass().getName()+que.toString());
 
        int i=0;
        while (!que.isEmpty()) 
        {
            int key = que.poll();                          //出队
//            System.out.print("出队: "+key+"\t");
            if (primeset.contains(ring.get(i)+key))        //判断素数，集合包含元素
            {
                i++;
                ring.add(key);                             //素数环添加Integer(key)
            }
            else
                que.add(key);                              //key再次入队
//            System.out.println("队列: "+que.toString());
        }
        System.out.println("1～"+max+"素数环: "+ring.getClass().getName()+ring.toString());
    }
    
    //返回包含2～max中所有素数的集合。算法同例4.3
    public Collection<Integer> createPrime(int max)
    {
        if (max<=0)
            return null;
//        Collection<Integer> primeset=new ArrayList<Integer>(max*2);    //数组列表，顺序表存储，没有排序
//        Collection<Integer> primeset=new LinkedList<Integer>(); //链表，循环双链表存储，没有排序
        Collection<Integer> primeset=new TreeSet<Integer>();    //树集合，平衡二叉树，排序
        primeset.add(2);                                   //添加已知的最小素数2
        for (int key=3;  key<max*2;  key+=2)               //测试奇数，其他偶数不需测试
        {
            boolean yes=true;
            Iterator<Integer> it = primeset.iterator();    //返回迭代器对象
            while (yes && it.hasNext())                    //若有后继元素，使用迭代器遍历一个集合
                yes = key % it.next()!=0;                  //用primes中的素数测试key
            if (yes)                                       //key是素数
                primeset.add(key);                         //添加到集合
        }
        return primeset;
    } 
    
    public static void main(String args[])
    {
         new PrimeRing_例10_1(10);
    }
}

/*
程序运行结果如下：
素数集合: java.util.TreeSet[2, 3, 5, 7, 11, 13, 17, 19]
队列: java.util.LinkedList[2, 3, 4, 5, 6, 7, 8, 9, 10]
1～10素数环: java.util.ArrayList[1, 2, 3, 4, 7, 10, 9, 8, 5, 6]


*/

/*
//不能声明静态成员变量如下，因为参数要从构造方法获得。
//    static Collection<Integer> primeset; //素数集合

 
 //先根次序遍历平衡二叉树。用于确定二叉树结构
public static <T> void preorder(TreeSet<T> treeset)
{
}
//做不到，其中，包含一个TreeMap对象map，map中有root，三叉链表结构。
//单步可见树结构，但私有临时变量，无法写函数

*/
//@author：Yeheya。2014-10-26