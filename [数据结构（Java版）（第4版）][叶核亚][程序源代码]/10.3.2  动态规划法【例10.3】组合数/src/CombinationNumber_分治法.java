//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月27日
//10.3   算法设计策略
//10.3.1   分治法
//10.3.2   动态规划法
//【例10.3】  采用分治法和动态规划法求组合数。
        //（1） 分治法，分治策略递归算法

public class CombinationNumber_分治法
{
    public static int combine(int m, int n)                //返回组合数Cmn，分治策略递归算法
    {
        if (n>0 && (m==0 || m==n))                         //边界条件
            return 1;                                      //直接解决问题，没有递归调用
        if (m>0 && n>m)                                    //递归条件
            return combine(m-1, n-1) + combine(m, n-1);  
                                       //分解成2个子问题，递归调用，返回各子问题合并后的解
        throw new IllegalArgumentException("m="+m+"，n="+n);//抛出无效参数异常
    }

    public static void main(String args[]) 
    {
//        System.out.println("combine("+0+","+(-5)+")="+combine(0,-5));      //异常
//        System.out.println("combine("+(-5)+","+0+")="+combine(-5,0));      //异常
        int n=5;
        for (int m=0; m<=n; m++)
            System.out.println("combine("+m+","+n+")="+combine(m,n));      //分治策略递归算法
    }
}
/*
程序运行结果如下：
combine(0,5)=1
combine(1,5)=5
combine(2,5)=10
combine(3,5)=10
combine(4,5)=5
combine(5,5)=1
*/
  //@author：Yeheya。2014-11-4
