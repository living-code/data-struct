//《数据结构（Java版）（第4版）习题解答》，作者：叶核亚，2014年12月26日
//【习题解答习2-11】

//1、DLinkNode<T>不能声明如下，因为next类型为Node<T>，而不是DLinkNode<T>。
public class DLinkNode<T> extends Node<T> 
{
    public DLinkNode<T> pred;                    //prev指向前驱结点
    
    public DLinkNode(T data, DLinkNode<T> pred, DLinkNode<T> next)
    {
        super(data, next);                       //语义错，父类中next类型为Node<T>，结点结构不对
//        this.data = data;
//        this.next = next;                        //语义错，this.next类型为Node<T>，结点结构不对
        this.pred = pred;
    }
    public DLinkNode()
    {
//        super();                          //错，父类中next类型为Node<T>，结点结构不对，且没有prev域
        this(null, null, null);
    }
}
/*
2、从语法上DLinkNode<T>可以声明如下，但双链表结点与单链表结点，并不是两个具有包含关系的概念。
public class DLinkNode<T> extends Node<T> 
{
    public DLinkNode<T> pred, next;              //prev指向前驱结点，next指向后继结点
    public DLinkNode(T data, DLinkNode<T> pred, DLinkNode<T> next)
    {
//        super(data, next);                     //错，父类中next类型为Node<T>，结点结构不对
      super(data, null);                         //对
//        this.data = data;
        this.next = next;                        //对，this.next隐藏super.next（类型为Node<T>）
        this.pred = pred;
    }
    public DLinkNode()
    {
        this(null, null, null);
    }
}*/
