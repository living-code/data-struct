//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月6日
//5.3   广义表
//5.3.3   广义表双链表示的实现
//广义表双链表示的结点类

public class GenNode<T>                                    //广义表双链表示的结点类，T指定结点的元素类型
{
    public T data;                                         //数据域
    public GenList<T> child;                               //地址域，指向子表
    public GenNode<T> next;                                //地址域，指向后继结点

    //构造结点，data指定元素，child指向子表，next指向后继结点
    public GenNode(T data, GenList<T> child, GenNode<T> next) 
    {
        this.data = data;
        this.child = child;
        this.next = next;
    }
    public GenNode(T data)
    {
        this(data, null, null);
    }
    public GenNode()
    {
        this(null, null, null);
    }
}
//author：Yeheya。2014-7-17
