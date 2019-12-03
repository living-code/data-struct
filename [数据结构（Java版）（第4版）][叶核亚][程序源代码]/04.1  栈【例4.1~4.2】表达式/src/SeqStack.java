//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月1日
//4.1.2   顺序栈

//顺序栈类，最终类，实现栈接口，T表示数据元素的数据类型
public final class SeqStack<T> implements Stack<T>
{
    private SeqList<T> list;                               //使用顺序表（第2章）存储栈元素

    public SeqStack(int length)                            //构造容量为length的空栈
    {
        this.list = new SeqList<T>(length);                //执行顺序表构造方法
    }
    public SeqStack()                                      //构造默认容量的空栈  
    {
        this(64);
    }

    public boolean isEmpty()                               //判断栈是否空，若空返回true
    {
        return this.list.isEmpty();
    } 

    public void push(T x)                                  //元素x入栈，空对象不能入栈
    {
        this.list.insert(x);                               //顺序表尾插入元素x，自动扩充容量
    }
    
    public T peek()                                        //返回栈顶元素（未出栈），若栈空返回null
    {
        return this.list.get(list.size()-1);               //若栈空，get(i)返回null
//        return this.isEmpty() ? null : this.list.get(list.size()-1);
    }

    public T pop()                                         //出栈，返回栈顶元素；若栈空返回null
    {
        return this.list.remove(list.size()-1);            //若栈不空，顺序表尾删除，返回删除元素
//        return this.isEmpty() ? null : this.list.remove(list.size()-1); //若栈不空，顺序表尾删除，返回删除元素
    }
    public String toString()                               //返回栈所有元素的描述字符串，形式为“(,)”
    {
        return this.getClass().getName()+" "+this.list.toString();
    }
}


//@author：Yeheya。2014-7-3

