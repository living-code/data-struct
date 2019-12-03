//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月11日
//4.2.5   优先队列

//优先队列类（升序或降序），最终类，实现队列接口。使用排序循环双链表存储队列元素，元素按优先级升序排列
public final class PriorityQueue<T extends Comparable<? super T>>  implements Queue<T> 
{
    private SortedCirDoublyList<T> list;         //使用排序循环双链表存储优先队列元素
    private boolean asc;                         //asc指定升序（true）或降序（false）
    
    public PriorityQueue(boolean asc)            //构造空队列，asc指定升序（true）或降序（false）
    {
        this.list = new SortedCirDoublyList<T>();
        this.asc = asc;
    }
    public PriorityQueue()                       //构造空队列，默认升序
    {
        this(true); 
    }
    public boolean isEmpty()                     //判断队列是否空，若空返回true
    {
        return this.list.isEmpty();
    }

    public boolean add(T x)                      //元素x入队，空对象不能入队
    {
        return this.list.insert(x)!=null;        //排序循环双链表按值插入
    } 

    public T peek()                              //返回队头元素，没有删除。若队列空，则返回null
    {
        return this.asc ? this.list.get(0) : this.list.head.prev.data;
                   //根据优先队列的升序或降序属性，升序时，返回队头元素；降序时，返回队尾元素
    } 

    public T poll()                              //出队，返回队头元素，若队列空返回null
    {
        return this.asc ? this.list.remove(0) : this.list.removeLast();
                   //根据优先队列的升序或降序属性，升序时，返回队头元素，删除队头结点；降序时，返回队尾元素，删除队尾结点
    } 

    public String toString()                     //返回队列所有元素的描述字符串
    {
        return this.getClass().getName()+" "+
               (this.asc ? this.list.toString() : this.list.toPreviousString());
    }
}



//@author：Yeheya。2014-7-11
