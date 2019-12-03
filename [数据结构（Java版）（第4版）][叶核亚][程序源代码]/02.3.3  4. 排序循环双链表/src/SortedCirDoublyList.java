//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月23日
//2.3.3   双链表
//4.  排序循环双链表
//第9章 9.5.3   双链表的排序算法

//排序循环双链表类（升序），T或T的某个祖先类必须实现Comparable<T>接口；继承循环双链表类
public class SortedCirDoublyList<T extends Comparable<? super T>>
    extends CirDoublyList<T>
{
    //构造方法，参数和方法体同排序单链表，第4版省略
    public SortedCirDoublyList()                           //构造空循环双链表
    {
        super();                                           //默认调用父类无参数构造方法，构造空循环双链表，可省略
    }
/*    public SortedCirDoublyList(T[] values)               //构造，按值插入values数组元素。直接插入排序算法   //【实验题9-4】 
    {
        super();
        for (int i=0; i<values.length; i++)                //直接插入排序算法 
            this.insert(values[i]);                        //按值插入
    }*/
    public SortedCirDoublyList(SortedCirDoublyList<T> list)//排序循环双链表的深拷贝构造方法
    {
        super(list);                                       //调用父类同参数的构造方法，不可省略
    }   
    //由单链表list构造排序循环双链表，重载深拷贝构造方法。直接插入排序，算法同由单链表构造排序单链表
    public SortedCirDoublyList(SinglyList<T> list)
    {
        super();                                           //构造空循环双链表
        for (Node<T> p=list.head.next;  p!=list.head;  p=p.next)//直接插入排序算法
            this.insert(p.data);                           //按值插入
    }
    
    //不支持父类的set(int i, T x)和insert(int i, T x)方法，将其覆盖并抛出异常。第4版省略
    public void set(int i, T x)
    {
        throw new UnsupportedOperationException("set(int i, T x)");
    }
    public DoubleNode<T> insert(int i, T x)
    {
        throw new UnsupportedOperationException("insert(int i, T x)");
    }
    
    //第4版
    //插入x，x!=null，根据x对象大小顺序查找确定插入位置，插入在等值结点之前。
    //返回插入结点。O(n)。覆盖父类的insert(x)方法
    public DoubleNode<T> insert(T x)
    {
        if (this.isEmpty() || x.compareTo(this.head.prev.data)>0)
            return super.insert(x);               //调用父类被覆盖的insert(T)方法，最大值插入在头结点之前，即尾插入，O(1)
        DoubleNode<T> p=this.head.next;
        while (p!=head && x.compareTo(p.data)>0)           //寻找插入位置（p指向）
            p = p.next;
        DoubleNode<T> q = new DoubleNode<T>(x, p.prev, p); //在p结点之前插入值为x结点
        p.prev.next = q;
        p.prev = q;
        return q;                                          //返回插入结点
    }

    //第4版【实验2-9】
    //顺序查找首个与key相等元素，返回结点，若查找不成功返回null，O(n)。覆盖，比较规则不同
    //算法同排序单链表
    public DoubleNode<T> search(T key) 
    {
        for (DoubleNode<T> p=this.head.next;  p!=head && key.compareTo(p.data)>=0;  p=p.next)
        {
            System.out.print(p.data+"？");
            if (key.compareTo(p.data)==0)                  //由compareTo()提供比较对象大小和相等的依据
                return p;
        }
        return null; 
    }

    public DoubleNode<T> insertDifferent(T x)              //插入不重复元素，返回插入结点；覆盖，不能调用查找方法
    {
        DoubleNode<T> p=this.head.next;
        while (p!=this.head && x.compareTo(p.data)>0)      //查找与x相等元素结点（p指向），寻找插入位置
            p = p.next;
        if (p!=this.head && x.compareTo(p.data)==0)
            return null;                                   //不插入重复元素
        DoubleNode<T> q = new DoubleNode<T>(x, p.prev, p); //在p结点之前插入值为x结点
        p.prev.next = q;
        p.prev = q;
        return q;                                          //返回插入结点
    }
    
    //删除首个与key相等元素结点，返回被删除元素，查找不成功返回null。O(n)。
    //继承，其中，调用的查找方法执行子类的方法实现，比较规则不同。
//    public T remove(T key)
//  public void removeALL(T key)

    //以上第2章ADT
    
    //第9章 9.5.3 循环双链表的排序算法
    //重载深拷贝构造方法，由循环双链表list构造排序循环双链表，快速排序算法 
    public SortedCirDoublyList(CirDoublyList<T> list)
    {
        super(list);                                       //深拷贝list循环双链表
        System.out.println("循环双链表的快速排序");
        quickSort(head.next, head.prev);
    }    
    //一趟快速排序，begin、end指定子序列的开始和最后结点，递归算法
    private void quickSort(DoubleNode<T> begin, DoubleNode<T> end)
    {
        if (begin!=end && begin!=end.next)                 //排除空和单结点链表情况
        {
            DoubleNode<T> front=begin, rear=end;
            T vot=front.data;                              //第一个值作为基准值
            while (front!=rear)                            //一趟排序
            {
                while (front!=rear && rear.data.compareTo(vot)>=0) //从后向前寻找较小值
                    rear=rear.prev;
                if (front!=rear)
                {
                    front.data = rear.data;                //较小元素向前移动
                    front=front.next;
                }
                while (front!=rear && front.data.compareTo(vot)<=0) //从前向后寻找较大值
                    front=front.next;
                if (front!=rear)
                {
                    rear.data = front.data;                //较大元素向后移动
                    rear=rear.prev;
                }
            }
            front.data=vot;                                //基准值到达最终位置
            System.out.println(begin.data+".."+end.data+",  vot="+vot+"  "+this.toString());
            quickSort(begin, rear.prev);                   //前端子序列再排序，递归调用
            quickSort(front.next, end);                    //后端子序列再排序，递归调用
        }
    }

    
    //【实验9-4】由数组构造排序循环双链表，直接选择排序，交换元素算法
    //n-1趟，每趟遍历单链表寻找到最小值结点，交换结点元素到前面，不删除和插入结点。算法同排序单链表
    public SortedCirDoublyList(T[] values)                 //将数组中所有对象插入构造排序循环双链表
    {
        super(values);                                     //由数组构造循环双链表，尾插入
        System.out.println("循环双链表的直接选择排序");
        for (DoubleNode<T> first=head.next;  first!=head;  first=first.next) //first指向待排序双链表第一个结点  
        {                              //n-1趟，每趟遍历双链表寻找到最小值结点，交换结点元素到前面
            DoubleNode<T> min=first;                        //min指向最小值结点
            for (DoubleNode<T> p=min.next;  p!=head;  p=p.next) //p遍历循环双链表一趟，找出最小值结点
                if (p.data.compareTo(min.data)<0)          //比较，min记住最小值结点
                    min = p;
            if (min!=first)                                //交换min结点元素到前面
            {
                T temp = min.data;
                min.data = first.data;
                first.data = temp;
            }
//            System.out.println(this.toString());
        }
    }
    
    //【实验9-4】归并两条排序循环双链表，将list中所有结点归并到this中，合并后设置list为空
    public void merge(SortedCirDoublyList<T> list)  
    {
//        System.out.println("归并排序循环双链表merge");
        DoubleNode<T> p=this.head.next;                    //p遍历this循环双链表，不需要记得前驱结点
        DoubleNode<T> q=list.head.next;                    //q遍历list循环双链表
        while (p!=this.head && q!=list.head)               //遍历两条排序循环双链表
            if ((p.data).compareTo(q.data)<0)              //若p结点值小，则p继续前进
                p = p.next;
            else                                           //否则，将q结点插入到p结点之前
            {
                q.prev = p.prev;
                p.prev.next = q;
                p.prev = q;
                q = q.next;
                q.prev.next = p;
            }
        if (q!=list.head)                                  //将list链表中剩余结点并入this尾
        {
            q.prev = this.head.prev;
            this.head.prev.next = q;
            list.head.prev.next=this.head;                 //使this与list的最后结点连接成为环形
            this.head.prev = list.head.prev;
        }
        list.head.prev = list.head;                        //合并后设置list为空
        list.head.next = list.head;
    }
    //返回this和list归并后的排序循环双链表（升序），不改变this和list，一次归并算法
    public SortedCirDoublyList<T> mergeWith(SortedCirDoublyList<T> list)  
    {
//        System.out.println("归并排序循环双链表mergeWith");
        DoubleNode<T> p=this.head.next, q=list.head.next;  //p、q分别遍历this、list
        SortedCirDoublyList<T> result = new SortedCirDoublyList<T>();
        DoubleNode<T> rear=result.head;                    //rear指向result链表尾，准备插入
        while (p!=this.head || q!=list.head)               //遍历两条排序循环双链表
            if (p!=this.head && (q!=list.head && (p.data).compareTo(q.data)<=0 || q==list.head))
            {                                              //复制this结点，若p结点值小，或q已结束
                rear.next = new DoubleNode<T>(p.data, rear, null);
                rear = rear.next;
                p = p.next;
            }
            else if (q!=list.head && (p!=this.head && (p.data).compareTo(q.data)>0 || p==this.head))
            {                                              //否则，复制list结点，若q结点值小，或p已结束
                rear.next = new DoubleNode<T>(q.data, rear, null);
                rear = rear.next;
                q = q.next;
            }
        result.head.prev = rear;                           //设置result链成环形
        rear.next = result.head;
        return result;
    }
}
//@author：Yeheya。2014-8-21


