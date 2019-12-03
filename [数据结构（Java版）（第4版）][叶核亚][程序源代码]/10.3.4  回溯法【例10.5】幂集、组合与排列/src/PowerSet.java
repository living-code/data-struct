//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年11月4日
//10.3   算法设计策略
//10.3.4   回溯法
//【例10.5】  集合的幂集、组合与排列。
//（2）幂集

public class PowerSet  extends Backtrack         //幂集，继承Backtrack类，回溯法求解
{
	protected Object[] set;                      //集合
    
    public PowerSet(Object[] set)                //构造方法，set指定集合
    {
        super(2, set.length);                    //二叉树，集合元素个数是问题规模
        this.set = set;
    }

    protected void print()             //输出一个解（set的子集），x[i]为1/0分别显示/否第i个元素，形式为“{,}”。覆盖
    {
        System.out.print("{");
        boolean first=true;                      //第一个元素
        for (int i=0; i<this.x.length; i++)
        if (this.x[i]==1)
        {
            if (!first)
                System.out.print(",");
            else  first = !first;
            System.out.print(this.set[i].toString());
        }
        System.out.print("}，");
    }
    
    public static void main(String args[]) 
    {
        String[] set={"A","B","C"};
        //Integer[] set = {1,2,3};
        Array1.print(set);                       //输出对象数组，见例1.4
        System.out.println("集合的幂集：");
        new PowerSet(set).printAll();        
    }    
} 
/*
程序运行结果如下：
{}， {C}， {B}， {B,C}， {A}， {A,C}， {A,B}， {A,B,C}，   8个选项
{}，{3}，{2}，{2,3}，{1}，{1,3}，{1,2}，{1,2,3}，  8个选项

*/
//@author：Yeheya。2014-11-13