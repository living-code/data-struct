//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月19日，JDK 8.05
//6.2.6   二叉树的二叉链表实现
//9.  二叉树的层次遍历与构造
//（2） 以层次遍历序列构造完全二叉树
 
//完全二叉树类，继承二叉树类，二叉链表存储结构
public class CompleteBinaryTree<T> extends BinaryTree<T>
{
    int n;                                                 //结点个数
    
    public CompleteBinaryTree()                            //构造空二叉树
    {
        super();
        this.n=0;
    }

    public CompleteBinaryTree(T[] levellist)               //以层次遍历序列levellist构造完全二叉树
    {
        this.root = create(levellist, 0);
        this.n = levellist.length;
    }

    private BinaryNode<T> create(T[] levellist, int i)     //创建以levellist[i]为根的子树，返回根结点
    {
        BinaryNode<T> p = null;
        if (i<levellist.length)
        {
            p = new BinaryNode<T>(levellist[i]);           //创建叶子结点
            p.left = create(levellist, 2*i+1);             //创建p的左子树
            p.right = create(levellist, 2*i+2);            //创建p的右子树
        }
        return p;
    }
    
    //只支持以下在层次序列最后插入结点、删除子树方法，不支持父类其他插入结点、删除子树方法，覆盖，省略    
    public BinaryNode<T> insert(T x)   //在层次序列最后插入x结点，返回插入结点。方法体省略
    {
        return null;//？？
    }
    public void removeLast()                 //删除层次序列的最后结点。方法体省略
    {           }

    public static void main(String args[])
    {
        //图6.20所示完全二叉树的层次遍历序列
        String[] levellist = {"A","B","C","D","E","F","G","H"};
        CompleteBinaryTree<String> cbitree = new CompleteBinaryTree<String>(levellist);
        cbitree.preorder();
        cbitree.inorder();
        cbitree.postorder();
        cbitree.levelorder();
    }
}
/*
程序运行结果如下：
先根次序遍历二叉树：  A B D H ∧∧∧E ∧∧C F ∧∧G ∧∧
中根次序遍历二叉树：  H D B E A F C G 
后根次序遍历二叉树：  H D E B F G C A 
层次遍历二叉树：  A B C D E F G H 
是否完全二叉树？  true

*/

//author：Yeheya。2014-7-19