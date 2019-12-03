//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月11日
//4.4 递归
//3. 单链表的递归算法
//【思考题4-6】
//单链表没有rear尾指针

public class RecSinglyList<T> extends Object               //单链表类，T为数据元素类型，第4章
{
    public Node<T> head;                                   //头指针，指向单链表的头结点

    //（1）构造方法
    public RecSinglyList()                                 //构造方法，构造空单链表
    {
        this.head = new Node<T>();                         //创建头结点，data和next值均为null
    }
    
    //功能及参数：由values数组元素构造单链表。
    //特殊情况：若values数组长度为0，构造空单链表。若values为空对象，Java将抛出空对象异常。
    //算法：结点尾插入。递归算法
    public RecSinglyList(T[] values)
    {
        this();                                  //创建空单链表，只有头结点
        this.head.next = create(values,0);
    }

    private Node<T> create(T[] values, int i)    //返回从value数组第i个元素开始构造的子单链表，即返回第i个结点。 递归算法
    {
        Node<T> p=null;
        if (i<values.length)                     //递归执行条件：存在第i个元素
        {
            p = new Node<T>(values[i], null);    //创建第i个结点
            p.next = create(values, i+1);        //递归调用，递归通式：创建从第i+1个元素开始的子单链表，作为p的后继
        }
        return p;
    } 

    //功能及参数：返回单链表所有元素的描述字符串，形式为“(,)”，覆盖Object类的toString()方法。
    //特殊性情况：空表返回“()”
    //递归算法。
    public String toString()
    {
        return this.getClass().getName()+"("+ this.toString(this.head.next) +")";
    }
    private String toString(Node<T> p)           //返回从p结点开始的子单链表描述字符串，递归方法
    {
         if (p==null)                            //递归结束条件：空单链表返回空串 
             return "";
         String str=p.data.toString();
         if (p.next!=null) 
             str+=", "; 
         return str+toString(p.next);            //递归调用，递归通式：连接从p后继开始的子表串
    }

    //【思考题4-6】  
    public int size()                            //返回单链表长度
    {
        return size(this.head.next);
    }
    public int size(Node<T> p)                   //返回从p结点开始的单链表长度，递归方法
    {
        if (p==null)                             //递归结束条件：空单链表的长度为0
            return 0;
        return 1+size(p.next);                   //递归调用，递归通式：当前结点计数为1，加上从p后继开始的子表长度
    }

    //功能及参数：返回首个与key相等元素，若查找不成功返回null。
    //特殊情况：若key为空对象，Java将抛出空对象异常。
    //算法：顺序查找；递归算法。
    //顺序查找首个关键字为key元素，返回首次出现的元素，若查找不成功返回null
    public T search(T key)
    {
        return search(this.head.next, key);
    }
    private T search(Node<T> p, T key)           //在从p开始的子单链表中顺序查找与key相等元素，递归方法
    {
        if (p==null)
            return null;
        if (key.equals(p.data))                  //执行T类的equals(Object)方法，运行时多态
            return p.data;
        return search(p.next, key);
    }    

    //功能及参数：将所有与key相等的元素替换为x。
    //特殊情况：若key为空对象，Java将抛出空对象异常；若x空对象，不替换，抛出空对象异常。
    //算法：顺序查找；递归算法。
    public void replaceAll(T key, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //抛出空对象异常
        replaceAll(this.head.next, key, x);
    }
    private void replaceAll(Node<T> p, T key, T x)    //在以p开始的子单链表中，将所有与key相等的元素替换为x。递归方法
    {
        if (p!=null)
        {
            if (p.data.equals(key))
                p.data = x;
            replaceAll(p.next, key, x);
        }
    }
    
    public boolean equals(Object obj)            //比较this与obj引用的单链表是否相等，覆盖Object类的equals(obj)方法
    {
        if (obj == this)
            return true;
        if (obj instanceof RecSinglyList<?>)    
            return equals(this.head.next, ((RecSinglyList<T>)obj).head.next);
        return false;
    }
    private boolean equals(Node<T> p, Node<T> q) //比较分别从p、q结点的两条子单链表是否相等，递归方法
    {
        return p==null && q==null || 
               p!=null && q!=null && p.data.equals(q.data) && equals(p.next, q.next);
    }

    //功能及参数：单链表拷贝构造方法，深拷贝。创建单链表，复制list中的所有元素且次序相同    
    public RecSinglyList(RecSinglyList<T> list)
    {
        this();
        this.head.next = copy(list.head.next);
    }
    private Node<T> copy(Node<T> p)              //复制从p结点开始的子单链表，返回所复制子单链表的首结点。递归方法
    {
        Node<T> q=null;
        if (p!=null)                             //递归执行条件 
        {
            q = new Node<T>(p.data, null);       //创建与p结点同值的结点
            q.next = copy(p.next);               //递归调用，复制从p后继开始的子表，作为q的后继 
        }
        return q;
    }
}
//author：Yeheya。2015-10-14
