//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月27日
//10.3   算法设计策略
//10.3.3   贪心法
//4.  最小/大堆

import java.util.Comparator;                     //比较器接口

//堆类，包含最小/大堆。使用顺序表存储堆元素，T指定元素类型。
//支持两种比较对象大小方式，每个堆只需使用一种方式。
//①指定Comparator<T>比较器；
//②未指定比较器，默认T extends java.lang.Comparable<? super T>，即T或T的某个祖先类实现Comparable<T>接口
//，否则Java抛出类型强制转换异常
public class Heap<T>
{
    private boolean minheap;                               //指定最小堆或最大堆属性
    private SeqList<T> heap;                               //堆元素顺序表
    private final Comparator<? super T> comp;              //比较器，最终变量
    
    public Heap(boolean minheap, Comparator<? super T> comp)  //构造空堆，min指定最小/大堆，comp指定比较器
    {
        this.minheap = minheap;
        this.heap = new SeqList<T>();                       //创建顺序表，默认容量
        this.comp = comp;   
    } 
    
    public Heap(boolean minheap)                           //构造空堆，min指定最小/大堆，比较器为空对象
    {
        this(minheap, null);
    }
    public Heap()                                          //构造最小堆，空堆，比较器为空对象
    {
        this(true, null);
    }
    public Heap(boolean minheap, T[] values, Comparator<? super T> comp) //构造堆，value数组提供元素
    {
        this(minheap, comp);
        for (int i=0; i<values.length; i++)
            this.insert(values[i]);                        //堆插入元素
    }

    public boolean isEmpty()                               //判断是否空堆，若空返回true
    {
        return this.heap.isEmpty();
    }
    public int size()                                      //返回堆元素个数
    {
        return this.heap.size();
    }
    public String toString()                               //返回堆元素描述字符串，形式为“(,)”
    {
        return this.heap.toString();
    }
    
    public void insert(T x)                                //将x插入到堆中，不能插入null
    {
        this.heap.insert(x);                               //堆顺序表尾插入，顺序表自动计数和扩容，不能插入null
        for (int i=this.heap.size()/2-1; i>0; i=(i-1)/2)   //自下而上调整各子二叉树为堆
            sift(i);                                       //将以i为根的子树调整成最小/大堆
        sift(0);                                           //调整堆的根值。以上循环，当i==0时，i=(i-1)/2结果i=0，则死循环
        System.out.println("插入"+x+"，最"+(minheap ? "小":"大")+"堆："+this.toString());
    }
    
    //将以parent为根的子树调整成最小/大堆；或T是可比较大小的，或由比较器comp比较T对象大小。
    //私有方法，只插入、删除时调用，确保parent在范围内
    //与第9章堆排序中sift(,parent,,)方法的算法相同
    private void sift(int parent)
    {
        int end=this.size()-1;                             //堆序列的右边界
        int child = 2*parent+1;                            //child为子树根parent结点的左孩子
        T value = this.heap.get(parent);                   //获得根parent的元素值
        while (child<=end)                                 //沿较小/大值孩子结点向下筛选
        {
            int comp=0;                                    //记录比较对象的结果值
            if (child<end)
            {
                T left=this.heap.get(child), right=this.heap.get(child+1); //左右孩子结点值
                if (this.comp==null)
                    comp = ((Comparable<T>)left).compareTo(right); //默认T对象可比较大小，否则Java抛出类型强制转换异常
                else comp = this.comp.compare(left, right);//由comp比较器比较T对象大小
                if (this.minheap ? comp>0 : comp<0)        //若最小堆，则比小；否则比大
                    child++;                               //child为左右孩子的较小/大者
            }
            if (this.comp==null)                           //根结点与孩子结点值比较，寻找原根值value的最终位置
                comp = ((Comparable<T>)value).compareTo(this.heap.get(child));
            else  comp = this.comp.compare(value, this.heap.get(child));
            if (this.minheap ? comp>0 : comp<0)            //若父母结点与孩子结点值不符合堆特性
            {
                this.heap.set(parent,this.heap.get(child));//则将孩子结点中的值较小/大者上移
                parent = child;                            //parent、child向下一层
                child = 2*parent+1;
            }
            else break;
        }
        this.heap.set(parent,value);                       //将当前子树的原根值value调整到最终位置
    }
   
    public T removeRoot()                                  //返回最小/大值，删除根元素并调整为最小/大堆
    {
        if (this.isEmpty())
            return null;
        T x = (T)this.heap.get(0);                         //获得堆根结点元素
        this.heap.set(0, this.heap.get(this.heap.size()-1));  //将最后位置元素移到根，即删除根元素
        this.heap.remove(this.heap.size()-1);              //顺序表尾删除，长度自动减1
        if (this.heap.size()>1)
            sift(0);                                       //调整根结点值到堆的合适位置
        System.out.println("删除"+x+"，最"+(minheap ? "小":"大")+"堆："+this.toString());
        return x;
    }    
}
 
//@author：Yeheya。2014-8-28