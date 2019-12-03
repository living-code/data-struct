//《数据结构（Java版）（第4版）试题库》，作者：叶核亚，2015年2月10日
//6.2.6   二叉树的二叉链表实现
//【实验题6-1】BinaryTree<T>二叉树类增加成员方法。

public class BinaryTreeExercise<T> extends BinaryTree<T> 
{
    public BinaryTreeExercise()                          //构造空二叉树
    {
        super();
    }

    //（1） 先根和中根序列表示
    public BinaryTreeExercise(T[] prelist, T[] inlist)             //以先根和中根次序遍历序列构造二叉树
    {
        this.root = create(prelist, inlist, 0, 0, prelist.length);
    }
    //以先根和中根序列创建一棵子树，子树根结点值是prelist[preStart]，n指定子序列长度，
    //返回所创建子树的根结点
    private BinaryNode<T> create(T[] prelist, T[] inlist, int preStart, int inStart, int n)
    {
//        System.out.print("prelist:");
//        print(prelist, preStart, n);
//        System.out.print("，inlist:");
//        print(inlist, inStart, n);
//        System.out.println();
        
        if (n<=0)
            return null;
        T elem=prelist[preStart];                          //根结点值
        BinaryNode<T> p=new BinaryNode<T>(elem);           //创建叶子结点
        int i=0;
        while (i<n && !elem.equals(inlist[inStart+i]))     //在中根序列中查找根值所在位置
            i++;
        p.left = create(prelist, inlist, preStart+1, inStart, i);             //创建左子树
        p.right = create(prelist, inlist, preStart+i+1, inStart+i+1, n-1-i);  //创建右子树
        return p;
    }
    private void print(T[] table, int start, int n)
    {
        for (int i=0; i<n; i++)
    	    System.out.print(table[start+i]);
    }
       
    //【实验6-1】 
    public void leaf()                           //遍历输出叶子结点
    {
        leaf(root);
    }
    //输出以p结点为根的子树的所有叶子结点，先根次序遍历算法，3种遍历次序结果一样
    private void leaf(BinaryNode<T> p)
    {
        if(p!=null)
        {
            if (p.left==null && p.right==null)   //p.isLeaf()
                System.out.print(p.data.toString()+" ");
            leaf(p.left);
            leaf(p.right);
        }
    }
    
    public int leafCount()                       //返回二叉树的叶子结点数
    {
        return leafCount(root);
    }
    private int leafCount(BinaryNode<T> p)       //返回以p结点为根的子树的叶子结点个数
    {
        if (p==null)
            return 0;
        if (p.left==null && p.right==null) 
            return 1;
        return leafCount(p.left)+leafCount(p.right);
    }
    
    //查找并返回先根次序遍历首次出现的关键字为key结点
    public BinaryNode<T> search(T key)
    {
        return search(root, key);
    }
    
    //在以p为根的子树中查找并返回首次出现的关键字为key元素结点，若未找到返回null，先根次序遍历
    private BinaryNode<T> search(BinaryNode<T> p, T key)
    {
        if (p==null || key==null)
            return null;
        if (p.data.equals(key)) 
            return p;                            //查找成功，返回找到结点
        BinaryNode<T> find=search(p.left, key);  //在左子树中查找，递归调用
        if (find==null)                          //若在左子树中未找到
            find=search(p.right, key);           //则继续在右子树中查找，递归调用
        return find;                             //返回查找结果
    }
    public boolean contains(T key)               //判断是否包含关键字为key元素
    {
        return this.search(key)!=null;
    }
    
    //返回node结点的父母结点，若空树、未找到或node为根，则返回null
    public BinaryNode<T> getParent(BinaryNode<T> node)
    {
        if (root==null || node==null || node==root)
            return null; 
        return getParent(root, node);
    }
    //在以p为根的子树中查找并返回node结点的父母结点
    public BinaryNode<T> getParent(BinaryNode<T> p, BinaryNode<T> node)
    {
        if (p==null)
            return null;
        if (p.left==node || p.right==node) 
            return p;
        BinaryNode<T> find = getParent(p.left, node);
        if (find==null)
            find = getParent(p.right, node);
        return find;
    }

    public void replace(T x, T y)                //将首次出现的值为x的结点值替换为y
    {
        BinaryNode<T> find = search(x);
        if (find!=null)
            find.data = y;
    }
    public void replaceAll(T x, T y)                       //将值为x的结点值全部替换为y
    {
        if (x!=null && y!=null)
    	    replaceAll(root, x, y);
    }
    private void replaceAll(BinaryNode<T> p, T x, T y)     //在以p为根的子树中实现全部替换
    {
        if (p!=null)
        {
            if(p.data.equals(x)) 
                p.data = y;
            replaceAll(p.left, x, y);
            replaceAll(p.right, x, y);
        }
    }
    
    //返回x结点所在的层次，若空树或未查找到x返回-1
    public int getLevel(T x)
    {
        return getLevel(root, 1, x);                //令根结点的层次为1
    }
    //在以p结点（层次为i）为根的子树中，求x结点所在的层次
    private int getLevel(BinaryNode<T> p, int i, T x)
    { 
        if (p==null)                             //空树或查找不成功
            return -1;
        if (p.data.equals(x)) 
            return i;                            //查找成功
        int level = getLevel(p.left, i+1, x);       //在左子树查找
        if (level==-1)
            level = getLevel(p.right, i+1, x);      //继续在右子树中查找
        return level;
    }

    public boolean equals(Object obj)             //比较两棵二叉树是否相等 ，覆盖Object类的equals(obj)方法
    {
        return obj==this || obj instanceof BinaryTree && equals(this.root, ((BinaryTree<T>)obj).root);
    }
    //判断以p和q结点为根的两棵子树是否相等，递归方法
    private boolean equals(BinaryNode<T> p, BinaryNode<T> q)
    {
        return p==null && q==null || p!=null && q!=null && p.data.equals(q.data) &&
               equals(p.left, q.left) && equals(p.right, q.right);
    } 
   
    //@author：Yeheya。2015-10-14
    //问题讨论，中根或后根加空子树是否能够确定一棵二叉树？
    
    //以标明空子树的后根遍历序列构造二叉树。
    //算法从右向左，最右边元素是根，先创建右子树，再创建左子树
    private int i;
    public BinaryTreeExercise(T[] postlist)
    {
        i=postlist.length-1;
        this.root = create(postlist);
    }
    //以从i开始的标明空子树的后根序列，创建一棵以postlist[i]为根的子树，返回根结点，递归方法
    private BinaryNode<T> create(T[] postlist)
    {
        BinaryNode<T> p = null;
        if (i>=0)
        {
            T elem=postlist[i];  i--;
            if (elem!=null)
            {
                p = new BinaryNode<T>(elem);     //创建叶子结点
                p.right = create(postlist);      //创建p的右子树，递归调用
                p.left = create(postlist);       //创建p的左子树，递归调用
            }
        }
        return p;
    }
}
/* 以下算法不行
    //以标明空子树的中根遍历序列构造二叉树。
    //算法未成功。从左向右，最右边元素是根，先创建右子树，再创建左子树
    public void createBinaryTree(T[] inlist)
    {
        i=0;
        this.root = createInfix(inlist);
    }
    //以从i开始的标明空子树的中根序列，创建一棵以inlist[i]为根的子树，返回根结点，递归方法
    private BinaryNode<T> createInfix(T[] inlist)
    {
        BinaryNode<T> p=null, left=null;
        if (i<inlist.length)
        {
            T elem=inlist[i];  i++;
            BinaryNode<T> left = createInfix(inlist);       //创建p的左子树，递归调用，实际参数与形式参数相同
            if (elem!=null)
            {
                p = new BinaryNode<T>(elem);               //创建叶子结点
                p.left = left;                  //创建p的左子树，递归调用，实际参数与形式参数相同
                p.right = createInfix(inlist);                 //创建p的右子树，递归调用，实际参数与形式参数相同
            }
        }
        return p;
    }
}*/
//@author：Yeheya。2015-10-14