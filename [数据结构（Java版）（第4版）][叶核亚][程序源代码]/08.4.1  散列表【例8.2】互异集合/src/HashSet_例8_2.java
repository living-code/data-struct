//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月14日
//8.4.1   散列表
//【例8.2】  使用散列表表示互异集合。

public class HashSet_例8_2 
{
    //【实验1-2】声明    
    //产生n个互异的随机数，范围是0～size-1，返回整数对象数组
    public static Integer[] randomDifferent(int n, int size)
    {
        Integer[] values = new Integer[n];
        HashSet<Integer> set = new HashSet<Integer>();     //构造空散列表
        int i=0;
        while (i<n)
        {
            int key = (int)(Math.random()*size);
            if (set.add(key))                              //添加一个随机数到散列表成功
               values[i++]=key;
        }
        return values;                                     //返回数组引用
    }
    //此处散列表的作用是，检查是否重复。一个随机数存储两次。
    //不能用散列表的toArray()方法，一是不能返回Integer[]，只能返回Object[]；二是，破坏了随机次序

    public static void main(String[] args) 
    {
        int n=10, size=100;
        Integer[] values = randomDifferent(n, size);
        System.out.print(n+"个元素0～"+size+"之间的互异随机数集合: ");
        Array1.print(values);                             //见例1.4
    }
}
/*
程序运行结果如下：
x=7，元素重复，未插入。
10个元素0～100之间的互异随机数集合:  7 20 48 75 83 35 28 96 22 23

x=14，元素重复，未插入。
10个元素0～100之间的互异随机数集合:  38 21 42 49 22 16 5 14 54 62

*/
//@author：Yeheya。2014-10-16