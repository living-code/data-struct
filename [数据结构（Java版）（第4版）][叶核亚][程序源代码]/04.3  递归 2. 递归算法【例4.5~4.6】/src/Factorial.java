//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月11日
//4.3 递归
//【思考题4-4】  求n！。

public class Factorial
{
    public static int factorial(int n)                     //求阶乘n!，递归方法
    {
        if (n<0)
            throw new java.lang.IllegalArgumentException("n="+n); //抛出无效参数异常
        if (n==0 || n==1)                                  //边界条件，递归结束条件
            return 1;
        return n*factorial(n-1);                           //递归调用，递推通式
    }

    public static void main(String args[])
    {
        int n=5;
        System.out.println(n+"!="+factorial(n));           //5!=120
        
        //习题4
        System.out.println(n+"!="+toString(n)+factorial(n));
    }
    
    
    //习题4
    public static String toString(int n)                   //求阶乘n!
    {
        if (n>=0)
        	return toString(n, "");
        throw new java.lang.IllegalArgumentException("n="+n); //抛出无效参数异常
    }
    private static String toString(int n, String str)      //求阶乘n!，递归方法
    {
        if (n==0 || n==1)
            return "";
        else
        {
            str += n+"*"+(n-1)+"!="+toString(n-1, str);
            return str;
        }
    }
}
/*
程序运行结果如下：
5!=120      
5!=5*4*3*2*1=120
*/
//author：Yeheya。2014-9-23
