//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年11月9日
//8.5.1   二叉排序树
//【例8.4】  使用二叉排序树表示互异的排序集合。
//二叉排序树的插入、查找操作。

public class BinarySortTree_random例8_4
{
    //【实验1-2】声明    
    //Integer[] randomIntegerDifferentSorted(int n, int size)	//返回n个互异的排序的随机数

    //产生n个互异的排序的随机数，范围是0～size－1，返回二叉排序树
    public static BinarySortTree<Integer> random(int n, int size)
    {
        BinarySortTree<Integer> set = new BinarySortTree<Integer>(); //二叉排序树存储集合元素
        int i=0;
        while (i<n)
        {
            int key = (int)(Math.random()*size);
            System.out.print(key+" ");  
            if (set.add(key))                    //添加一个随机数到二叉排序树成功
               i++;
        }
        return set;                              //返回二叉排序树
    }
    //不能调用addAll([])，因为要计数。
    
    public static void main(String args[])
    {
        System.out.print("关键字序列：");
        BinarySortTree<Integer> set=random(10, 100);
        System.out.println("\n二叉排序树："+set.toString());  //中根次序遍历二叉排序树，输出按关键字升序排列的元素序列
        set.inorderPrevious();                     //以反向的中根次序遍历二叉树，输出所有结点元素
    }
}
/*
程序运行结果如下：
关键字序列：72 49 49 91 79 17 88 38 12 12 87 8 
二叉排序树：[8 12 17 38 49 72 79 87 88 91 ]
[91 88 87 79 72 49 38 17 12 8 ]


关键字序列：63 32 22 69 55 31 45 66 34 54 
二叉排序树：[22 31 32 34 45 54 55 63 66 69 ]
[69 66 63 55 54 45 34 32 31 22 ]
*/
//@author：Yeheya。2014-11-9
