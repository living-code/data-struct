//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月1日
//4.1.3   链式栈

//链式栈类，最终类，实现栈接口，T表示数据元素的数据类型
public final class LinkedStack<T> implements Stack<T>
{
    private SinglyList<T> list;                            //使用单链表（第2章）存储栈元素
    
    public LinkedStack()                                   //构造空栈
    {
        this.list = new SinglyList<T>();                   //构造空单链表
    }

    public boolean isEmpty()                               //判断栈是否空，若空返回true
    {
        return this.list.isEmpty();
    }
    public void push(T x)                                  //元素x入栈，空对象不能入栈
    {
        this.list.insert(0, x);                            //单链表头插入元素x
    } 
    
    public T peek()                                        //返回栈顶元素（未出栈）；若栈空返回null
    {
        return this.list.get(0);
    }
    public T pop()                                         //出栈，返回栈顶元素；若栈空返回null
    {
        return this.list.remove(0);                        //若栈不空，单链表头删除，返回删除元素
    }
    
    public String toString()                               //返回栈所有元素的描述字符串，形式为“(,)”
    {
        return this.getClass().getName()+" "+this.list.toString();
    }
}
//@author：Yeheya。2014-7-3

