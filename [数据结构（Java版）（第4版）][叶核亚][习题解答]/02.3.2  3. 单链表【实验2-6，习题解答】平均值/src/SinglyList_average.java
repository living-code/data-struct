//《数据结构（Java版）（第4版）习题解答》，作者：叶核亚，2014年12月26日
//§2.3 线性表的链式存储和实现
//【实验2-7，习题解答】求单链表元素的平均值。

public class SinglyList_average 
{
    //算法可行，但效率低，时间复杂度是O(n*n)。
    public static double average(SinglyList<Integer> list) //求所有元素的平均值
    {
        int sum=0;
        for(int i=0; i<list.size(); i++)                   //size()的时间是O(n)
            sum += list.get(i).intValue();                 //get(i)的时间是O(n)
        return (double)sum/list.size();                    //实数除，存在除数为0错误
    }
	
    public static double averageAll(SinglyList<Integer> list)//求所有元素的平均值，时间复杂度是O(n)
    {
        int sum=0, count=0;
//        for (Node<Integer> p=list.head.next;  p!=null;  p=p.next)   //遍历单链表，O(n)，要求head和next权限必须是public
        for (Node<Integer> p=list.first();  p!=null;  p=list.next(p))   //以迭代方式遍历单链表。O(n)
        {
            sum += p.data.intValue();                      //元素值求和
            count++;                                       //统计元素个数
        }
        if (list.isEmpty())
            throw new IllegalArgumentException("不能对空单链表计算平均值。"); //抛出无效参数异常
        return (double)sum/count;                          //返回平均值。实数除，避免了除数为0错误
    }
    
    public static void main(String args[])
    {
        Integer[] values={10,20,30}; 
    	SinglyList<Integer> list = new SinglyList<Integer>(values);//Array1.random(10,100));//见例1.4//返回产生n个随机数的数组
        System.out.println("list="+list.toString());
        System.out.println("average(list)="+average(list));
        System.out.println("averageAll(list)="+averageAll(list));
        System.out.println("averageExceptMaxMin(list)="+averageExceptMaxMin(list));
    }

    //【实验2-7】  （第3版例2.3）
    //去掉最高分和最低分，再求平均值，O(n)
    public static double averageExceptMaxMin(SinglyList<Integer> list)
    {
        if (list.isEmpty())
            throw new IllegalArgumentException("不能对空单链表计算平均值。"); //抛出无效参数异常
        int sum=0, i=0, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        Node<Integer> p=list.head.next;               //要求head权限必须是public
        while (p!=null)                               //遍历单链表
        {
            int value = p.data.intValue();
            sum += value; 
            if (value>max)
                max = value;
            if (value<min)
                min = value;
            p = p.next;
            i++;
        }
        if (i==1 || i==2)
            return (double)sum/i;                     //返回两个元素的平均值，避免了除数为0错误
        return (double)(sum-max-min)/(i-2);           //返回去掉最高分和最低分后的平均值
    }
}
/*
程序运行结果如下：    
list=(10,20,30)
average(list)=20.0
averageAll(list)=20.0
averageExceptMaxMin(list)=20.0

*/
/*修改
double average(SeqList<Student> list)                   //求平均值
{
    int n=stulist.length();                         //顺序表长度
    double sum=0;
    for (int i=0; i<n; i++)
         sum += stulist.get(i).score;               //此处get(i)返回Student结构类型
    return n>0 ? sum/n: 0;                          //给出0个元素结果，避免除数为0错误
}
double average(SinglyList<Student> list)    //求平均值
{
    int n=stulist.length();                           //单链表长度
    if (n>0)
    {
        double sum=0;
        for (int i=0; i<n; i++)
             sum += stulist.get(i).score;             //此处get(i)返回Student结构类型
        return sum/n;
    }
    return 0.0;                                       //给出0个元素的结果，避免除数为0错误
}
*/


