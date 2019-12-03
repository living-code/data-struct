//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年11月15日
//10.3   算法设计策略
//10.3.4   回溯法
//【例10.5】  求一个集合的幂集。
//（4）排列。【思考题10-7】 

//P(m,n)排列，求从set集合n个元素中选择m个元素的所有排列，当m=n时， 称为全排列。默认全排列，回溯法
public class Permutation  extends Backtrack
{
    protected Object[] set;                      //集合

    //构造方法，set指定集合，从set.length个元素中选择m个元素的所有排列。
    public Permutation(Object[] set, int m)
    {
        super(set.length, m);                    //构造set.length叉树，树高度为m，即解x[]元素个数为m
        this.set = set;
    }
    public Permutation(Object[] set)             //构造方法，set指定集合，默认全排列
    {
        this(set, set.length);                   //树高度为集合元素个数
    }

    public void printAll()                       //输出从set集合的所有元素中选择m个元素的所有排列。重载
    {
        System.out.print("P("+this.x.length+","+set.length+")排列：");
        super.printAll();                        //调用父类被覆盖的同名方法
    }

    protected  boolean restrict(int i)           //约束条件，元素不重复，遍历m层n叉树
    {
        for (int j=0; j<i; j++)
            if (x[j]==x[i])                      //元素重复
                return false;
        return true;
    }

    protected void print()                       //输出一个解（集合），形式为“{,}”。覆盖
    {
        System.out.print("{");
        if (this.x.length>0)
        {
            System.out.print(this.set[x[0]]);
            for (int i=1; i<this.x.length; i++)
                System.out.print(","+this.set[x[i]]);
        }
        System.out.print("}，");
    }

    public static void main(String args[]) 
    {
        String[] setstr={"A","B","C"};
        for (int m=0; m<=setstr.length; m++)
            new Permutation(setstr,m).printAll();//排列
    }
}

/*
程序运行结果如下：
P(0,3)排列：{}，  1个解
P(1,3)排列：{A}，{B}，{C}，  3个解
P(2,3)排列：{A,B}，{A,C}，{B,A}，{B,C}，{C,A}，{C,B}，  6个解
P(3,3)排列：{A,B,C}，{A,C,B}，{B,A,C}，{B,C,A}，{C,A,B}，{C,B,A}，  6个解


//没有声明restrict(int i)
//结果同，输出形式不同。        new Backtrack(3,3).printAll();           //满3叉树，3个元素的全排列，有重复的，n^n个解
{A,A,A}，{A,A,B}，{A,A,C}，{A,B,A}，{A,B,B}，{A,B,C}，{A,C,A}，{A,C,B}，{A,C,C}，{B,A,A}，{B,A,B}，{B,A,C}，{B,B,A}，{B,B,B}，{B,B,C}，{B,C,A}，{B,C,B}，{B,C,C}，{C,A,A}，{C,A,B}，{C,A,C}，{C,B,A}，{C,B,B}，{C,B,C}，{C,C,A}，{C,C,B}，{C,C,C}，  27个选项

*/
//@author：Yeheya。2014-11-15
