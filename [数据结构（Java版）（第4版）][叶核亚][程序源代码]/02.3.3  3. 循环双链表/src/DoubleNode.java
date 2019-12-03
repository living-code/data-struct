//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月21日
//2.3.3   双链表
//1. 双链表结点

public class DoubleNode<T>                       //双链表结点类，T指定结点的元素类型
{
    public T data;                               //数据域，存储数据元素
    public DoubleNode<T> prev, next;             //地址域，prev指向前驱结点，next指向后继结点

    //构造结点，data指定元素，prev指向前驱结点，next指向后继结点
    public DoubleNode(T data, DoubleNode<T> prev, DoubleNode<T> next)
    {
        this.data = data;                        //T对象引用赋值
        this.prev = prev;                        //DoubleNode<T>对象引用赋值
        this.next = next;
    }
    public DoubleNode(T data)
    {
        this(data, null, null);
    }
    public DoubleNode()
    {
        this(null, null, null);
    }
    public String toString()                     //返回结点数据域的描述字符串
    {
        return this.data.toString();
    }    
}
//@author：Yeheya。2014-10-9
