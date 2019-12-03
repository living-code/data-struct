//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月27日
//10.3   算法设计策略
//10.3.1   分治法
//10.3.2   动态规划法
//【例10.3】  采用分治法和动态规划法求组合数。
//（2） 动态规划法

public class CombinationNumber                   //组合数，动态规划法
{
    private int[][] yanghui;                     //杨辉三角
    
    public CombinationNumber(int n)
    {
        this.yanghui = new int[n+1][];           //创建n+1行的杨辉三角，三角形的二维数组
        for (int i=0; i<this.yanghui.length; i++)
        {
            yanghui[i]= new int[i+1];            //每行申请i+1个元素的一维数组
            yanghui[i][0]=yanghui[i][i]=1;       //每行首尾值为1
            for (int j=1; j<i; j++)
                yanghui[i][j]=yanghui[i-1][j-1]+yanghui[i-1][j];
                             //第i行j列元素为其上一行（i-1）前两个元素（j-1、j）之和
        }
    }

    public int get(int m, int n)                 //返回组合数Cmn
    {
        return this.yanghui[n][m];               //从杨辉三角获得组合数。若m、n越界，Java抛出下标越界异常
    }
    
    public void printYanghui()                   //输出杨辉三角
    {
        System.out.print("");
        for (int i=0; i<yanghui.length; i++)
        {
            System.out.print(String.format("%"+(yanghui.length-i+1)*2+"c",' '));//输出前导空格
            for (int j=0; j<yanghui[i].length; j++)
                System.out.print(String.format("%4d",yanghui[i][j]));     //格式化输出
            System.out.println();
        }
    }
    
    public static void main(String args[])
    {
        int n=5;
        CombinationNumber cnum = new CombinationNumber(n);
        cnum.printYanghui();
        for (int m=0; m<=n; m++)
            System.out.println("C("+m+","+n+")="+cnum.get(m, n));
    }
}
/*
程序运行结果如下：
                 1
               1   1
             1   2   1
           1   3   3   1
         1   4   6   4   1
       1   5  10  10   5   1
C(0,5)=1
C(1,5)=5
C(2,5)=10
C(3,5)=10
C(4,5)=5
C(5,5)=1


      //        System.out.println("combination("+m+","+n+")="+combination(m,n));//动态规划法，采用一维数组
*/
//@author：Yeheya。2014-8-27

/*
程序运行结果如下：
   1
   1   1
   1   2   1
   1   3   3   1
   1   4   6   4   1
   1   5  10  10   5   1
   1   6  15  20  15   6   1
   1   7  21  35  35  21   7   1
   1   8  28  56  70  56  28   8   1
   1   9  36  84 126 126  84  36   9   1

                         1
                       1   1
                     1   2   1
                   1   3   3   1
                 1   4   6   4   1
               1   5  10  10   5   1
             1   6  15  20  15   6   1
           1   7  21  35  35  21   7   1
         1   8  28  56  70  56  28   8   1
       1   9  36  84 126 126  84  36   9   1
*/
//@author：Yeheya。2014-8-27