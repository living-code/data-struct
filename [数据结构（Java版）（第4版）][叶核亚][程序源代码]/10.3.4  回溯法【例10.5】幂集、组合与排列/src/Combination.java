//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年11月4日
//10.3   算法设计策略
//10.3.4   回溯法
//【例10.5】  集合的幂集、组合与排列。
//（3） 组合
//递归回溯，算法遍历解空间二叉树进行约束剪枝和限界剪枝的子树。
//行约束剪枝和限界剪枝的子树。

public class Combination  extends PowerSet       //组合，继承幂集
{
    CombinationNumber cnum;                      //组合数，见例10.3

    public Combination(Object[] set)             //构造方法，set指定集合
    {
        super(set);
        this.cnum = new CombinationNumber(set.length);
    }

    public void printAll(int m)                  //输出从set集合的所有元素中选择m个元素的所有组合。重载
    {
        System.out.print("C("+m+","+set.length+")="+cnum.get(m, set.length)+"，组合：");
        this.backtrack(m,0,0);
        System.out.println();
    }
    
    //从set集合的所有元素中选择m个元素的所有组合，获得解的x[i]值，0≤i<x.length；
    //（num≥0）表示x[]中取值为1的个数。
    //递归回溯，算法遍历解空间二叉树进行约束剪枝和限界剪枝的子树。重载
    protected void backtrack(int m, int i, int num) 
    {
        if (i<this.x.length)
        {
            if (num+this.x.length-i>m)           //限界剪枝，仅当num加剩余n-i个选择可能得到解时
            {
                this.x[i]=0;                     //左孩子结点取值
                backtrack(m, i+1, num);          //遍历左子树，获得解x[i+1]值，num+0，递归调用
            }
            if (num<m)                           //约束剪枝，仅当满足约束条件时
            {
                this.x[i]=1;                     //右孩子结点取值
                backtrack(m, i+1, num+1);        //遍历右子树，获得解x[i+1]值，num+1，递归调用
            }
        }
        else                                     //到达叶子结点，获得一个解
        {
//            this.count++;                        //解计数
            print();                             //输出set的一个子集
        } 
    }

    public static void main(String args[]) 
    {
        String[] setstr={"A","B","C"};
        Combination set = new Combination(setstr);
        for (int m=0; m<=setstr.length; m++)
            set.printAll(m);
        set.printAll();                          //调用父类的方法，输出所有子集
    }
}
/*
程序运行结果如下：
C(0,3)=1，组合：{} 
C(1,3)=3，组合：{C} {B} {A} 
C(2,3)=3，组合：{B,C} {A,C} {A,B} 
C(3,3)=1，组合：{A,B,C} 
*/

  //@author：Yeheya。2014-11-15
