//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月23日
//6.5.3   树的父母孩子兄弟链表实现
//1. 树的父母孩子兄弟链表结点类

public class TreeNode<T>                         //树的父母孩子兄弟链表结点类，T指定结点的元素类型
{
    public T data;                               //数据域
    public TreeNode<T> parent, child, sibling;   //父母结点链、孩子结点链、兄弟结点链
    public int level;                            //结点层次
    
    //构造结点，参数分别指定元素、结点层次、父母结点、孩子结点和兄弟结点
    public TreeNode(T data, int level, TreeNode<T> parent, TreeNode<T> child, TreeNode<T> sibling)
    {
        this.data = data;
        this.level = level;
        this.parent = parent;
        this.child = child;
        this.sibling = sibling;
    }
    public TreeNode(T data, int level)           //构造指定值和层次的叶子结点
    {
        this(data, level, null, null, null);
    }
    public String toString()                     //返回结点数据域的描述字符串
    {
        return this.data.toString();
    }    
    
    public boolean isLeaf()                      //判断是否叶子结点
    {
        return this.child==null;
    }    
}
/*
    //可声明以下方法
    public TreeNode()
    {
        this(null, 0, null, null, null);
    }
    public boolean equals(Object obj)            //比较两个结点值是否相等，覆盖Object类的equals(obj)方法
    {
        return obj==this || obj instanceof TreeNode<?> && this.data.equals(((TreeNode<T>)obj).data);
    }    
*/
//@author  Yeheya。2014-7-23
