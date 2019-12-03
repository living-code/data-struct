//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月3日
//4.2.2  顺序循环队列

//顺序循环队列类，最终类，实现队列接口，T表示数据元素的数据类型
public final class SeqQueue<T>  implements Queue<T>
{
    private Object element[];                              //存储队列数据元素的数组
    private int front, rear;                               //front、rear分别为队列头尾下标

    public SeqQueue(int length)                            //构造容量为length的空队列
    {
        if (length<64)
        	length=64;                                     //设置队列数组容量最小值
        this.element = new Object[length];
        this.front = this.rear = 0;                        //设置空队列
    }
    public SeqQueue()                                      //构造默认容量的空队列
    {
        this(64);
    }

    public boolean isEmpty()                                 //判断队列是否空，若空返回true
    {
        return this.front==this.rear;
    } 

    public boolean add(T x)                                //元素x入队，空对象不能入队
    {
        if (x==null)
            return false;
//            throw new NullPointerException("x==null");     //抛出空对象异常
        if (this.front==(this.rear+1)%this.element.length) //若队列满，则扩充数组
        {
            Object[] temp = this.element;         
            this.element = new Object[temp.length*2];      //重新申请一个容量更大的数组
            int j=0;
            for (int i=this.front;  i!=this.rear;  i=(i+1) % temp.length) //按照队列元素次序复制数组元素
                this.element[j++] = temp[i];
            this.front = 0;
            this.rear = j;
        }
        this.element[this.rear] = x;
        this.rear = (this.rear+1) % this.element.length;
    	return true;
    } 

    public T peek()                                       //返回队头元素，没有删除。若队列空，则返回null
    {
        return this.isEmpty() ? null : (T)this.element[this.front];
    }
    
    public T poll()                                        //出队，返回队头元素，若队列空返回null 
    {
        if (this.isEmpty()) 
            return null;
        T temp = (T)this.element[this.front];
        this.front = (this.front+1) % this.element.length;
        return temp;
    }

    public String toString()                               //返回队列所有元素的描述字符串，形式为“(,)”，按照队列元素次序
    {
        StringBuffer strbuf = new StringBuffer(this.getClass().getName()+"(");
        for (int i=this.front;  i!=this.rear;  i=(i+1)%this.element.length)
            strbuf.append(this.element[i].toString()+","); //按照队列元素次序复制数组元素
        strbuf.setCharAt(strbuf.length()-1, ')');          //将串最后多余的一个字符','改为')'
        return new String(strbuf);                         //由StringBuffer对象构造String对象
    }
}
//@author：Yeheya。2014-9-23