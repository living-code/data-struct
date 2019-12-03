//《数据结构（Java版）（第4版）》，作者：叶核亚。2014年7月3日。JDK 8.11。
//§1.2.3   算法设计
//【例1.3】 求两个整数的最大公约数。
//4.3 递归【实验4-5】递归算法

public class Gcd
{
    public static int gcd1(int a, int b)          //返回a与b的最大公因数
    {
        while (b!=0)
        {
            int temp = a%b;
            a = b;
            b = temp; 
        }
        return a;
    }
    
    //4.3 递归【实验4-5】递归算法
    public static int gcd2(int a, int b)          //返回a,b的最大公因数，递归方法
    {
        if(b==0)
            return a;
        if(a<0)
            return gcd2(-a, b);
        if(b<0)
            return gcd2(a, -b);
        return gcd2(b, a%b);
    }
    
    public static void main(String args[]) 
    {
        int a=12, b=18, c=24;
        System.out.println("gcd1("+a+","+b+","+c+")="+gcd1(gcd2(a,b), c));
    }
}
/*
程序运行结果如下:
gcd1(12,18,24)=6

*/
//author：Yeheya。2014-7-3
