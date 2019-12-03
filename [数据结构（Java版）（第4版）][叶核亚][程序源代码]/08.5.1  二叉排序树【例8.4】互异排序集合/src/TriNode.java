//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年11月5日
//8.5.1   二叉排序树
//6.2.7   二叉树的三叉链表实现（教材未写）
//1.  三叉链表结点类

public class TriNode<T>                          //二叉树的三叉链表结点类，T指定结点的元素类型
{
    public T data;                               //数据域，存储数据元素
    public TriNode<T> parent, left, right;       //地址域，分别指向父母结点、左和右孩子结点

    //构造结点，参数分别指定元素、父母结点、左和右孩子结点
    public TriNode(T data, TriNode<T> parent, TriNode<T> left, TriNode<T> right)
    {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    public TriNode(T data)                       //构造指定值的叶子结点
    {
        this(data, null, null, null);
    }
    public TriNode()
    {
        this(null, null, null, null);
    }
    
    public String toString()
    {
        return this.data.toString();
    }
    public boolean isLeaf()                      //判断是否叶子结点
    {
        return this.left==null && this.right==null;
    }
}
/*
    //可声明以下方法
    public boolean equals(Object obj)            //比较两个结点值是否相等，覆盖Object类的equals(obj)方法
    {
        return obj==this || obj instanceof TripleNode && this.data.equals(((TripleNode<T>)obj).data);
    }    
*///@author：Yeheya。2014-11-5