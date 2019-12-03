//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月3日
//4.3 递归
//【例4.5】  用递归算法求Fibonacci数列。

public class Fibonacci
{
    public static int fib(int n)                 //返回Fibonacci数列第n项，递归方法
    {
        if (n<0)
            throw new java.lang.IllegalArgumentException("n="+n); //抛出无效参数异常
        if (n==0 || n==1)                                 //边界条件，递归结束条件
            return n;
        return fib(n-2)+fib(n-1);                          //递归调用，递推通式
    }

    public static void main(String args[])
    {
        for (int i=0; i<=24; i++)
            System.out.print(fib(i)+" ");
        System.out.println();
    }
}
/*
程序运行结果如下：
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368
*/
//author：Yeheya。2014-9-23