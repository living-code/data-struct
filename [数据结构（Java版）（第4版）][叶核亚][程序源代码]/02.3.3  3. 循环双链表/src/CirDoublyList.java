//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月23日
//2.3.3   双链表
//3. 循环双链表

//循环双链表类，实现ADT List<T>声明的方法，T表示数据元素的数据类型
public class CirDoublyList<T>
{
    public DoubleNode<T> head;                             //头指针

    public CirDoublyList()                                 //构造空循环双链表
    {
        this.head = new DoubleNode<T>();                   //创建头结点，3个域值均为null
        this.head.prev = this.head;
        this.head.next = this.head;
    }
    public boolean isEmpty()                               //判断循环双链表是否空
    {
        return this.head.next==this.head;
    }

    //插入x作为第i个元素，返回插入结点。若x==null，抛出空对象异常。
    //对序号i采取容错措施，若i<0，插入x在最前；若i>n，插入x在最后。O(n)
    public DoubleNode<T> insert(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //抛出空对象异常
        DoubleNode<T> front=this.head;      
        for (int j=0; front.next!=this.head && j<i; j++)   //寻找第i-1个结点或最后一个（front指向）
            front = front.next; 
        //以下在front之后插入x结点，包括头插入（i≤0）、中间/尾插入（i>0）
        DoubleNode<T> q=new DoubleNode<T>(x, front, front.next);
        front.next.prev = q;
        front.next = q;
        return q;                                          //返回插入结点
    }
    public DoubleNode<T> insert(T x)             //尾插入x元素，返回x结点。算法在头结点之前插入，O(1)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //抛出空对象异常
        DoubleNode<T> q = new DoubleNode<T>(x, head.prev, head); 
        head.prev.next = q;                                //在头结点之前插入，相当于尾插入
        head.prev = q;
        return q;
    }
    
    //以下【思考题2-8】，成员方法的功能同单链表，第4版教材省略    
    public CirDoublyList(T[] values)                       //构造循环双链表，由values数组提供元素，尾插入
    {
        this();                                            //创建空循环双链表，只有头结点
        DoubleNode<T> rear=this.head;
        for (int i=0; i<values.length; i++)
        {
            rear.next=new DoubleNode<T>(values[i], rear, this.head);   //尾插入
            rear = rear.next; 
        }
        this.head.prev = rear;
    }
    
    public CirDoublyList(CirDoublyList<T> list)            	//深拷贝构造方法，复制循环双链表
    {
        this();                                          	//创建空循环双链表，只有头结点
        DoubleNode<T> rear = this.head;
        for (DoubleNode<T> p=list.head.next;  p!=list.head;  p=p.next)
        {
        	rear.next = new DoubleNode<T>(p.data, rear, this.head);
            rear = rear.next; 
        }
        this.head.prev = rear;
    }

    
    //【思考题2-】以下教材没写
    public T get(int i)                            //返回第i个元素，0≤i<长度。若i越界，返回null。O(n)
    {
        DoubleNode<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++)
            p = p.next;
        return (i>=0 && p!=null) ? p.data : null;          //若p指向第i个结点，返回其元素值
    }
    
    //设置第i个元素为x，0≤i<长度。若i越界，抛出序号越界异常；若x==null，抛出空对象异常。O(n)
    public void set(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //抛出空对象异常
        DoubleNode<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++)
            p = p.next;
        if (i>=0 && p!=null)
            p.data = x;                                    //p指向第i个结点
        else throw new IndexOutOfBoundsException(i+"");    //抛出序号越界异常
    }
    
    public int size()                                      //返回循环双链表长度
    {
        int i=0; 
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)//循环条件与单链表不同
            i++;
        return i;
    }   
    
    public String toString()           //返回循环双链表所有元素的描述字符串，循环双链表遍历算法，O(n)
    {
        String str=this.getClass().getName()+"(";          //返回类名
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)
        {
            str += p.data.toString();
            if (p.next!=this.head) 
                str += ",";
        }
        return str+")";                                    //空表返回()
    }
    
    //以下为循环双链表增加的成员方法
    //返回循环双链表所有元素的描述字符串（元素次序从后向前），O(n)。必需，优先队列用
    public String toPreviousString()
    {
        String str=this.getClass().getName()+"(";          //返回类名
        for (DoubleNode<T> p=this.head.prev; p!=this.head;  p=p.prev)
        {
            str += p.data.toString();
            if (p.prev!=this.head) 
                str += ",";
        }
        return str+")";                                    //空表返回()
    }    
    public void print()                                    //输出双向
    {
        System.out.print("(");
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)
        {
            System.out.print(p.data.toString());
            if (p.next!=this.head) 
                System.out.print(",");
        }
        System.out.print(")，(");
        for (DoubleNode<T> p=this.head.prev; p!=this.head;  p=p.prev)
        {
            System.out.print(p.data.toString());
            if (p.prev!=this.head) 
                System.out.print(",");
        }
        System.out.println(")");
    }
    
    //删除第i个元素，返回被删除元素；0≤i<n，若i越界，不删除，返回null。O(n)
    public T remove(int i)
    {
        DoubleNode<T> p=this.head.next;
        for (int j=0; p!=head && j<i; j++)                 //遍历寻找第i个结点（p指向）
            p = p.next;
        if (p!=head && i>=0)
        {
            p.prev.next = p.next;                          //删除p结点，由JVM稍后释放
            p.next.prev = p.prev;
            return p.data;                                 //返回p结点元素
        }
        return null;                                       //当i<0或i>表长时
//        throw new IndexOutOfBoundsException(i+"");         //抛出序号越界异常
    }
    public void clear()                                    //删除循环双链表所有元素
    {
        this.head.prev = head;
        this.head.next = head;
    }

    //删除最后一个元素，返回被删除元素。若链表空，返回null。
    //算法删除头结点的前驱结点，O(1)。必需，优先队列用
    public T removeLast()
    {
        DoubleNode<T> p=this.head.prev;                    //p指向头结点的前驱结点，待删除
        if (p!=head)
        {
            p.prev.next = this.head;                       //删除p结点，由JVM稍后释放
            this.head.prev = p.prev;
            return p.data;                                 //返回p结点元素
        }
        return null;                                       //当i<0或i>表长时
//        throw new IndexOutOfBoundsException(i+"");         //抛出序号越界异常
    }
    
    
    //顺序查找首次出现的与key相等元素，返回结点，若查找不成功返回null。算法同单链表
    public DoubleNode<T> search(T key) 
    {
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)
            if (key.equals(p.data))
                return p;
        return null;
    }
    public DoubleNode<T> insertDifferent(T x)             //插入不重复元素。查找不成功时尾插入
    {
    	return null;//??
    }
    
    //删除首个与key相等元素结点，返回被删除元素，查找不成功返回null。O(n)。
    //算法调用查找方法。排序子类不需要覆盖，search(key)方法运行时多态
    public T remove(T key)
    {
        DoubleNode<T> find=search(key);                    //顺序查找，返回结点
        if (find!=null)
        {
            find.prev.next = find.next;                    //删除find结点自己
            find.next.prev = find.prev;
            return find.data;
        }
        return null;
    }

    //比较两条循环双链表是否相等，覆盖Object类的equals(obj)方法。算法同单链表
    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;
        if (!(obj instanceof CirDoublyList<?>))
            return false;
        DoubleNode<T> p=this.head.next;
        CirDoublyList<T> list = (CirDoublyList<T>)obj;
        DoubleNode<T> q=list.head.next;
        while (p!=head && q!=list.head && p.data.equals(q.data))
        {
            p=p.next;
            q=q.next;
        }
        return p==head && q==list.head;
    }    
    //以上实现ADT List<T>

    
    //【习题解答例2.2】
    //以下4个方法提供迭代遍历循环双链表方式
    public DoubleNode<T> first()                           //返回循环双链表第一个结点（非头结点），O(1)
    {
        return (head.next==head) ? null : head.next;
    }
    public DoubleNode<T> next(DoubleNode<T> p)             //返回p的后继结点，O(1)
    {
        return (head.next==head || p==null || p==head || p==head.prev) ? null : p.next;
    }
    public DoubleNode<T> previous(DoubleNode<T> p)         //返回p的前驱结点，O(1)
    {
        return (head.next==head || p==null || p==head || p==head.next) ? null : p.prev;
    }
    public DoubleNode<T> last()                            //返回循环双链表最后一个结点，O(1)
    {
        return (head.prev==head) ? null : head.prev;
    }
    
    //【习题解答例2.3】两表操作
    //在this循环双链表之后，合并连接list中所有结点，并设置list为空
    public void addAll(CirDoublyList<T> list) 
    {
        DoubleNode<T> rear=head.prev; 
        rear.next = list.head.next;
        list.head.next.prev = rear;
        rear=list.head.prev;
        rear.next = this.head;
        this.head.prev = rear;
        list.head.prev = list.head; 
        list.head.next = list.head; 
    }    
}