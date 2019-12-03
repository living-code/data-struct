//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月23日
//4.2.1   队列抽象数据类型

//ADT Queue<T>                        //队列抽象数据类型，T表示数据元素的数据类型
//声明同java.util.Queue<T>

public interface Queue<T>              //队列接口，描述队列抽象数据类型，T表示数据元素的数据类型
{
    public abstract boolean isEmpty();           //判断队列是否空
    public abstract boolean add(T x);            //元素x入队，若添加成功，则返回true；否则返回false
    public abstract T peek();                    //返回队头元素，没有删除。若队列空，则返回null
    public abstract T poll();                    //出队，返回队头元素。若队列空，则返回null
}

//@author：Yeheya。2014-10-26