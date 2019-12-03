//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月23日
//6.5.3   树的父母孩子兄弟链表实现
//第4版程序，树结点有层次属性

public class Tree<T>                             //树类，树的父母孩子兄弟链存储结构，T指定结点的元素类型
{
    public TreeNode<T> root;                     //根结点，树的父母孩子兄弟链表结点类型

    public Tree()                                //构造空树
    {
        this.root=null;         
    }
    public boolean isEmpty()                     //判断是否空树
    {
        return this.root==null;
    }
    
    //3. 树的横向凹入表示法
    public String toString()                     //返回树的横向凹入表示字符串，以先根次序遍历树
    {
        return "树的横向凹入表示： \n "+toString(root,"");
    }
    //先根次序遍历以p为根的子树，tab指定缩进量，返回子树的横向凹入表示字符串，递归算法
    private String toString(TreeNode<T> p, String tab)
    {
        if (p==null)
            return "";
        return tab+p.data.toString()+"\n" + toString(p.child,tab+"\t") + toString(p.sibling,tab);//递归调用
    }
    //【例6.6】   以树的横向凹入表示构造一棵城市树（森林）。
   
    
    //以下第4版教材未给出
    //树的先根和后根次序遍历算法
    public void preorder()                                 //输出树的先根次序遍历序列，算法同二叉树
    {
        System.out.print("树的先根次序遍历序列：  ");   
        preorder(root);
        System.out.println();   
    }    
    private void preorder(TreeNode<T> p)                   //先根次序遍历以p为根的子树，递归算法
    {
        if (p!=null)
        {
            System.out.print(p.data+" ");
            preorder(p.child);                             //递归调用
            preorder(p.sibling);
        }
    }
    public void postorder()                                //输出树的后根次序遍历序列
    {
        System.out.print("树的后根次序遍历序列：  ");   
        postorder(root);
        System.out.println();   
    }
    private void postorder(TreeNode<T> p)                  //后根次序遍历以p为根的子树，递归算法，算法同二叉树的中根次序遍历
    {
        if (p!=null)
        {
            postorder(p.child);
            System.out.print(p.data+" ");
            postorder(p.sibling);
        }
    }

    public int size()                                      //返回树的结点个数，算法同二叉树
    {
        return size(root);
    }
    public int size(TreeNode<T> p)                         //返回以p结点为根的子树的结点个数
    {
        if (p==null)
            return 0;
        return 1+size(p.child)+size(p.sibling);
    }
    
    public Tree(Tree<T> tree)                              //拷贝构造方法，算法同三叉链表存储的二叉树
    {   this.root = copy(tree.root, null);
    }
    //深拷贝，复制以p根的子树，parent是复制子树的父母结点，返回新建子树的根结点
    public TreeNode<T> copy(TreeNode<T> p, TreeNode<T> parent)
    {
        if (p==null)
            return null;
        TreeNode<T> q = new TreeNode<T>(p.data, p.level, parent, null, null);
        q.child = copy(p.child, q);                        //复制孩子子树，递归调用
        q.sibling = copy(p.sibling, q);                    //复制兄弟子树，递归调用
        return q;                                          //返回建立子树的根结点
    }
    
    public TreeNode<T> insertRoot(T x)                     //插入元素x作为根结点，原根结点作为其孩子结点，返回插入结点
    {
        this.root = new TreeNode<T>(x, 1, null, this.root, null);
        if (this.root.child!=null)
        {
            this.root.child.parent = this.root;
            setLevel(this.root.child, this.root.level+1);  //设置以this.root.child为根子树的所有结点层次
        }
        return this.root;
    }
    
    protected void setLevel(TreeNode<T> p, int level)      //设置以p结点为根子树的所有结点层次
    {
        if (p!=null)
        {
            p.level = level;
            setLevel(p.child, level+1);                    //递归调用
            setLevel(p.sibling, level);                    //递归调用
        }
    }
    
    public void clear()                                    //删除树的所有结点
    {
        this.root = null;
    }
}
//@author  Yeheya。2015-3-7
