//《数据结构（Java版）（第4版）习题解答》，作者：叶核亚，2015年2月8日
//4.3 递归
//【习题解答例4.1】  用递归算法打印数字塔。

public class DigitTower
{
    public static void line(int i, int n)                         //输出一行，递归方法
    {
        System.out.print(String.format("%3d",i));
        if (i<n)
        { 
            line(i+1, n);
            System.out.print(String.format("%3d",i));
        }
    }
    
    public static void main(String args[])
    {
        int n=9;
        for(int i=1; i<=n; i++)
        {
            System.out.print(String.format("%"+3*(n-i+1)+"c", ' ')); //前导空格
            line(1, i);
            System.out.println();
        }
    }
}
/*
程序运行结果如下：
                             1
                          1  2  1
                       1  2  3  2  1
                    1  2  3  4  3  2  1
                 1  2  3  4  5  4  3  2  1
              1  2  3  4  5  6  5  4  3  2  1
           1  2  3  4  5  6  7  6  5  4  3  2  1
        1  2  3  4  5  6  7  8  7  6  5  4  3  2  1
     1  2  3  4  5  6  7  8  9  8  7  6  5  4  3  2  1

*/
//author：Yeheya。2014-9-23
