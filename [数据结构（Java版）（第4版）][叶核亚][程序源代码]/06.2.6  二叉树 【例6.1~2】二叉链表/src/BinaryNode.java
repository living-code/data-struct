//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月18日
//6.2.6   二叉树的二叉链表实现
//1.  二叉链表结点类

public class BinaryNode<T>                       //二叉树的二叉链表结点类，T指定结点的元素类型
{
    public T data;                               //数据域，存储数据元素
    public BinaryNode<T> left, right;            //链域，分别指向左、右孩子结点

    //构造结点，data指定元素，left、right分别指向左孩子和右孩子结点
    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public BinaryNode(T data)                    //构造元素为data的叶子结点
    {
        this(data, null, null);
    }
    public String toString()                     //返回结点数据域的描述字符串
    {
        return this.data.toString();
    }
    public boolean isLeaf()                      //判断是否叶子结点
    {
        return this.left==null && this.right==null;
    }
    //以上6.2.6节
}
/*
//注意：BinaryNode<T>类必须实现toString()方法，因为，否则输出Object类的toString()方法。
    SeqStack<BinaryNode<ExpData>> stack = new SeqStack<BinaryNode<ExpData>>();
    LinkedStack<BinaryNode<ExpData>> stack = new LinkedStack<BinaryNode<ExpData>>();

    //可声明以下方法
    public BinaryNode()
    {
        this(null, null, null);
    }

    public boolean equals(Object obj)            //比较两个结点值是否相等，覆盖Object类的equals(obj)方法
    {
        return obj==this || obj instanceof BinaryNode<?> && this.data.equals(((BinaryNode<T>)obj).data);
    }    
*/
//@author：Yeheya。2014-10-9
