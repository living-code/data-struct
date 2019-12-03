//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年11月4日
//10.3   算法设计策略
//10.3.4   回溯法
//【例10.5】  集合的幂集、组合与排列。
//（1）回溯法
//递归回溯

public class Backtrack                           //回溯法，求问题的所有解
{
	protected int k, x[], count;                 //k叉树，x[]存储一个解，count存储解的个数
    
    public Backtrack(int k, int n)               //k叉树，一个解的n元组
    {
        this.k = k;
        this.x = new int[n];                     //元素初值为0
//        for (int i=0; i<this.x.length; i++)
//        	x[i]=-1;
        this.count=0;
    }

    public void printAll()                       //输出所有解，遍历解空间k叉树
    {
        this.count=0;
        this.backtrack(0);                       //递归回溯，输出所有解
        System.out.println("  "+count+"个解");
    }
       
    //递归回溯，遍历解空间k叉树，获得解x[i]值，0≤i<x.length。根据约束条件进行剪枝
    protected void backtrack(int i)
    {
        if (i<this.x.length)
            for (int j=0; j<this.k; j++)         //遍历k个子树
            {
                this.x[i]=j;                     //结点取值，范围0～k-1
                if (restrict(i))                 //约束条件
                    this.backtrack(i+1);         //遍历下一棵子树，获得解x[i+1]值，递归调用
            }
        else                                     //到达叶子结点，获得一个解
        {
            this.count++;                        //解计数
            this.print();                        //输出一个解
        }
    }
    protected boolean restrict(int i)            //约束条件，包括约束剪枝和限界剪枝
    {
//      printX(i+1);                           //输出每个测试值，显示树的遍历路径
        return true;                             //若没有约束条件，则解空间树是满k叉树
    }
    protected void print()                       //输出一个解x[]，值为0/1，形式为“(,)”
    {
        System.out.print("(");
        if (this.x.length>0)
        {
            System.out.print(this.x[0]);
            for (int i=1; i<this.x.length; i++)
                System.out.print(","+this.x[i]);
        }
        System.out.print(")，");
    }
    //教材没写
    private void printX(int n)                   //输出一个解的一部分，输出每个测试值，显示树的遍历路径
    {
        System.out.print("("+this.x[0]);
        for (int i=1; i<n; i++)
            System.out.print(","+this.x[i]);
        System.out.print(")");
    }
    
    public static void main(String args[]) 
    {
        new Backtrack(2,3).printAll();              //图10.16，满二叉树，3个元素集合的所有子集，3层
//        new Backtrack(3,3).printAll();           //满3叉树，3个元素的全排列（有重复）
    }
}
/*
程序运行结果如下：
     new Backtrack(2,3).printAll();              //图10.16，满二叉树，3个元素集合的所有子集，3层
(0,0,0)， (0,0,1)， (0,1,0)， (0,1,1)， (1,0,0)， (1,0,1)， (1,1,0)， (1,1,1)，   8个解

        new Backtrack(3,3).printAll();           //满3叉树，3个元素的全排列，有重复的
(0,0,0)，(0,0,1)，(0,0,2)，(0,1,0)，(0,1,1)，(0,1,2)，(0,2,0)，(0,2,1)，(0,2,2)，(1,0,0)，(1,0,1)，(1,0,2)，(1,1,0)，(1,1,1)，(1,1,2)，(1,2,0)，(1,2,1)，(1,2,2)，(2,0,0)，(2,0,1)，(2,0,2)，(2,1,0)，(2,1,1)，(2,1,2)，(2,2,0)，(2,2,1)，(2,2,2)，  27个解

*/
//@author：Yeheya。2014-11-13
