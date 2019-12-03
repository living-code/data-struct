//《数据结构（Java版）（第4版）试题库》，作者：叶核亚，2014年8月22日，JDK 8.25
//10.1.2   Arrays数组类
// Arrays排序和查找算法。

import java.util.Arrays;

public class Arrays_sort 
{
    public static void main(String args[])
    {  
        //int整数数组排序和二分法查找
        int[] value1=Array1.randomInt(10,100);                 //返回整数随机数数组，见例1.4
        System.out.print("随机数序列： ");  Array1.print(value1);        
        java.util.Arrays.sort(value1);                     //int[]排序（升序）      
        System.out.print("排序序列： ");   Array1.print(value1);        
        int key=100;
        int i=java.util.Arrays.binarySearch(value1, key);
        System.out.println("二分法查找"+key+"，结果是"+i+"，查找"+(i>=0 && i<value1.length?"":"不")+"成功");

        //Integer整数对象数组排序和二分法查找
        Integer[] value2=Array1.randomInteger(10,100);        //返回整数对象随机数数组，见例1.4
        System.out.print("\n随机数序列： ");  Array1.print(value2);
        java.util.Arrays.sort(value2);                               //Integer[]排序（升序）      
        System.out.print("排序序列： ");   Array1.print(value2); 
        key=50;
        i=java.util.Arrays.binarySearch(value2, key);
        System.out.println("二分法查找"+key+"，结果是"+i+"，查找"+(i>=0 && i<value2.length?"":"不")+"成功");
    }
}
/* 
程序运行结果如下：
随机数序列：  2 54 61 67 96 29 91 95 76 79
排序序列：  2 29 54 61 67 76 79 91 95 96
二分法查找100，结果是-11，查找不成功

随机数序列：  28 22 34 49 41 66 49 1 77 98
排序序列：  1 22 28 34 41 49 49 66 77 98
二分法查找50，结果是-8，查找不成功

*/
//@author：Yeheya。2014-8-22
