//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年11月2日
//10.3   算法设计策略
//10.3.3   贪心法
//5.  Kruskal算法实现
//（3）并查集
public class UnionFindSet                        //并查集类
{
    private int parent[];                        //父指针数组
    
    public UnionFindSet(int n)                   //构造有n个元素的并查集，最初是包含n棵树的森林               
    {
        this.parent = new int[n];
        for (int i=0; i<n; i++)                  //父指针数组元素值为-1，表示每棵树只有一个结点
            this.parent[i]=-1;
//也可        java.util.Arrays.fill(this.parent, -1);  //将数组所有元素值填充为-1
    }

    //查找并返回第i个元素所在树的根下标。算法沿着父指针向上寻找直到根
    public int find(int i)
    {
        while (this.parent[i]>=0)                //若i不是根
            i=this.parent[i];                    //找到父结点下标
        return i;                                //返回根结点下标
    }
    
    //集合并运算，若i、j不在同一棵树中，则合并结点i和j所在的两棵树，返回true；否则返回false
    //首先查找并分别返回结点i和j所在树的根，将结点数较多的一个根作为另一个根的孩子结点
    public boolean union(int i, int j)
    {
        int rooti=find(i), rootj=find(j);                  //rooti、rootj分别获得结点i和j所在树的根
        if (rooti!=rootj)                                  //当i、j不在同一棵树中时，则合并i和j所在的两棵树
            if (parent[rooti]<=parent[rootj])              //若rooti树结点个数（负）较多
            {                                              //将j所在的树合并到i所在的树
                this.parent[rooti]+=this.parent[rootj];    //结点数相加
                this.parent[rootj]=rooti;                  //将rootj作为rooti的孩子，元素为父结点下标
            }
            else                                           //将i所在的树合并到j所在的树
            {
                this.parent[rootj]+=this.parent[rooti];
                this.parent[rooti]=rootj;                  //将rooti作为rootj的孩子结点
            }
        return rooti!=rootj;                               //返回合并与否状态
    }
    
    public String toString()                     //返回并查集所有元素，形式为“(,)”
    {
        String str="(";
        if (this.parent.length>0)
            str += this.parent[0];
        for (int i=1; i<this.parent.length; i++)
            str += ", "+this.parent[i];
        return str+") ";
    }
    
    public static void main(String args[])
    {
        //殷人昆p263图6.4
        UnionFindSet ufset = new UnionFindSet(10);          //并查集
        ufset.union(0,6);
        ufset.union(0,7);
        ufset.union(0,8);
        ufset.union(1,4);
        ufset.union(1,9);        
        System.out.println("并查集："+ufset.toString());
        ufset.union(0,1);
        System.out.println("并查集："+ufset.toString());
    }    
/*
程序运行结果如下：
并查集：(-4, -3, -1, -1, 1, -1, 0, 0, 0, 1) 
并查集：(-7, 0, -1, -1, 1, -1, 0, 0, 0, 1) 
*/

    //查找并返回元素i所在树的根下标，同时按照折叠规则压缩路径。
    //算法沿着父指针向上寻找直到根，将从i到根路径上的所有结点都改成根的孩子
    public int collapsingFind(int i)
    {
        int root=i;
        while (this.parent[root]>=0)                       //找到i所在树的根结点下标
            root=this.parent[root];
        while (root!=i && parent[i]!=root)                 //当i不是根且i不是根的孩子时
        {
            int pa = parent[i];
            parent[i]=root;                                //将i作为root的孩子结点
            i=pa;                                          //向上到i的父结点
        }
        return root;                                       //返回根结点下标
    }
}