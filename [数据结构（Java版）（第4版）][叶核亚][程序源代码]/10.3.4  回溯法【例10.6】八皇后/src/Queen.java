//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年11月15日
//10.3   算法设计策略
//10.3.4   回溯法
//【例10.6】 八皇后。

public class Queen  extends Backtrack            //求解n皇后问题，默认八皇后；继承Backtrack类，回溯法求解
{
    public Queen(int n)                                    //构造方法，n指定棋盘大小即皇后个数
    {
        super(n,n);
        if (n<=0 || n>8)
            throw new java.lang.IllegalArgumentException("n="+n); //抛出无效参数异常
        System.out.println("Queen("+n+")：");
    }
    public Queen()                                         //构造方法，默认八皇后
    {
        this(8);
    }
    
    protected boolean restrict(int i)                      //隐约束条件，测试x[i]位置是否可放皇后。覆盖
    {
//        printX(i+1);                                     //输出每个测试值，显示树的遍历路径
        for (int j=0; j<i; j++)
            if (x[j]==x[i] || Math.abs(i-j)==Math.abs(x[j]-x[i]))
                return false;
        return true;
    }
    
    public static void main(String args[])
    {
        new Queen(4).printAll();       	                   //四皇后
//        new Queen(8).printAll();       	               //八皇后
    }
    
    public void printAll()                                 //输出所有解，遍历解空间k叉树。覆盖
    {
        this.count=0;
        this.backtrack();                                  //迭代回溯，输出所有解
        System.out.println("  "+count+"个解");
    }
    
    private void backtrack()                               //迭代回溯，输出所有解。重载
    {
        this.x[0]=-1;
        int i=0;
        while (i>=0)
        {
            do
                this.x[i]++;
            while (x[i]<x.length && !restrict(i));         //寻找第i个皇后位置
            
            if (x[i]<x.length)                             //找到第i个皇后位置为x[i]
                if (i!=x.length-1)
                    x[++i]=-1;                             //继续寻找第i+1个皇后位置
                else                                       //求得一个解
                {
                    this.count++;
                    print();                               //输出一个解
                }
            else i--;                                      //没有找到第i个皇后位置，退回到第i-1个皇后位置，继续搜索其他路径
        }
    }
}

/*
程序运行结果如下：
Queen(1)：
(1)
count=1

Queen(2)：
count=0

Queen(3)：
count=0

Queen(4)：
(1,3,0,2)，(2,0,3,1)，2个解


Queen(5)：
(0,2,4,1,3)
(0,3,1,4,2)
(1,3,0,2,4)
(1,4,2,0,3)
(2,0,3,1,4)
(2,4,1,3,0)
(3,0,2,4,1)
(3,1,4,2,0)
(4,1,3,0,2)
(4,2,0,3,1)
10个解

Queen(6)：
(1,3,5,0,2,4)
(2,5,1,4,0,3)
(3,0,4,1,5,2)
(4,2,0,5,3,1)
4个解

Queen(7)：
(0,2,4,6,1,3,5)
(0,3,6,2,5,1,4)
(0,4,1,5,2,6,3)
(0,5,3,1,6,4,2)
(1,3,0,6,4,2,5)
(1,3,5,0,2,4,6)
(1,4,0,3,6,2,5)
(1,4,2,0,6,3,5)
(1,4,6,3,0,2,5)
(1,5,2,6,3,0,4)
(1,6,4,2,0,5,3)
(2,0,5,1,4,6,3)
(2,0,5,3,1,6,4)
(2,4,6,1,3,5,0)
(2,5,1,4,0,3,6)
(2,6,1,3,5,0,4)
(2,6,3,0,4,1,5)
(3,0,2,5,1,6,4)
(3,0,4,1,5,2,6)
(3,1,6,4,2,0,5)
(3,5,0,2,4,6,1)
(3,6,2,5,1,4,0)
(3,6,4,1,5,0,2)
(4,0,3,6,2,5,1)
(4,0,5,3,1,6,2)
(4,1,5,2,6,3,0)
(4,2,0,5,3,1,6)
(4,6,1,3,5,0,2)
(4,6,1,5,2,0,3)
(5,0,2,4,6,1,3)
(5,1,4,0,3,6,2)
(5,2,0,3,6,4,1)
(5,2,4,6,0,3,1)
(5,2,6,3,0,4,1)
(5,3,1,6,4,2,0)
(5,3,6,0,2,4,1)
(6,1,3,5,0,2,4)
(6,2,5,1,4,0,3)
(6,3,0,4,1,5,2)
(6,4,2,0,5,3,1)
40个解

Queen(8)：
(0,4,7,5,2,6,1,3)
(0,5,7,2,6,3,1,4)
(0,6,3,5,7,1,4,2)
(0,6,4,7,1,3,5,2)
(1,3,5,7,2,0,6,4)
(1,4,6,0,2,7,5,3)
(1,4,6,3,0,7,5,2)
(1,5,0,6,3,7,2,4)
(1,5,7,2,0,3,6,4)
(1,6,2,5,7,4,0,3)
(1,6,4,7,0,3,5,2)
(1,7,5,0,2,4,6,3)
(2,0,6,4,7,1,3,5)
(2,4,1,7,0,6,3,5)
(2,4,1,7,5,3,6,0)
(2,4,6,0,3,1,7,5)
(2,4,7,3,0,6,1,5)
(2,5,1,4,7,0,6,3)
(2,5,1,6,0,3,7,4)
(2,5,1,6,4,0,7,3)
(2,5,3,0,7,4,6,1)
(2,5,3,1,7,4,6,0)
(2,5,7,0,3,6,4,1)
(2,5,7,0,4,6,1,3)
(2,5,7,1,3,0,6,4)
(2,6,1,7,4,0,3,5)
(2,6,1,7,5,3,0,4)
(2,7,3,6,0,5,1,4)
(3,0,4,7,1,6,2,5)
(3,0,4,7,5,2,6,1)
(3,1,4,7,5,0,2,6)
(3,1,6,2,5,7,0,4)
(3,1,6,2,5,7,4,0)
(3,1,6,4,0,7,5,2)
(3,1,7,4,6,0,2,5)
(3,1,7,5,0,2,4,6)
(3,5,0,4,1,7,2,6)
(3,5,7,1,6,0,2,4)
(3,5,7,2,0,6,4,1)
(3,6,0,7,4,1,5,2)
(3,6,2,7,1,4,0,5)
(3,6,4,1,5,0,2,7)
(3,6,4,2,0,5,7,1)
(3,7,0,2,5,1,6,4)
(3,7,0,4,6,1,5,2)
(3,7,4,2,0,6,1,5)
(4,0,3,5,7,1,6,2)
(4,0,7,3,1,6,2,5)
(4,0,7,5,2,6,1,3)
(4,1,3,5,7,2,0,6)
(4,1,3,6,2,7,5,0)
(4,1,5,0,6,3,7,2)
(4,1,7,0,3,6,2,5)
(4,2,0,5,7,1,3,6)
(4,2,0,6,1,7,5,3)
(4,2,7,3,6,0,5,1)
(4,6,0,2,7,5,3,1)
(4,6,0,3,1,7,5,2)
(4,6,1,3,7,0,2,5)
(4,6,1,5,2,0,3,7)
(4,6,1,5,2,0,7,3)
(4,6,3,0,2,7,5,1)
(4,7,3,0,2,5,1,6)
(4,7,3,0,6,1,5,2)
(5,0,4,1,7,2,6,3)
(5,1,6,0,2,4,7,3)
(5,1,6,0,3,7,4,2)
(5,2,0,6,4,7,1,3)
(5,2,0,7,3,1,6,4)
(5,2,0,7,4,1,3,6)
(5,2,4,6,0,3,1,7)
(5,2,4,7,0,3,1,6)
(5,2,6,1,3,7,0,4)
(5,2,6,1,7,4,0,3)
(5,2,6,3,0,7,1,4)
(5,3,0,4,7,1,6,2)
(5,3,1,7,4,6,0,2)
(5,3,6,0,2,4,1,7)
(5,3,6,0,7,1,4,2)
(5,7,1,3,0,6,4,2)
(6,0,2,7,5,3,1,4)
(6,1,3,0,7,4,2,5)
(6,1,5,2,0,3,7,4)
(6,2,0,5,7,4,1,3)
(6,2,7,1,4,0,5,3)
(6,3,1,4,7,0,2,5)
(6,3,1,7,5,0,2,4)
(6,4,2,0,5,7,1,3)
(7,1,3,0,6,4,2,5)
(7,1,4,2,0,6,3,5)
(7,2,0,5,1,4,6,3)
(7,3,0,2,5,1,6,4)
92个解


Queen(4)：
(0)
(0,0)
(0,1)
(0,2)
(0,2,0)
(0,2,1)
(0,2,2)
(0,2,3)
(0,3)
(0,3,0)
(0,3,1)
(0,3,1,0)
(0,3,1,1)
(0,3,1,2)
(0,3,1,3)
(0,3,2)
(0,3,3)
(1)
(1,0)
(1,1)
(1,2)
(1,3)
(1,3,0)
(1,3,0,0)
(1,3,0,1)
(1,3,0,2)
(1,3,0,2)
(1,3,0,3)
(1,3,1)
(1,3,2)
(1,3,3)
(2)
(2,0)
(2,0,0)
(2,0,1)
(2,0,2)
(2,0,3)
(2,0,3,0)
(2,0,3,1)
(2,0,3,1)
(2,0,3,2)
(2,0,3,3)
(2,1)
(2,2)
(2,3)
(3)
(3,0)
(3,0,0)
(3,0,1)
(3,0,2)
(3,0,2,0)
(3,0,2,1)
(3,0,2,2)
(3,0,2,3)
(3,0,3)
(3,1)
(3,1,0)
(3,1,1)
(3,1,2)
(3,1,3)
(3,2)
(3,3)
2个解


*/

