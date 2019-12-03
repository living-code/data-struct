//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月23日
//4.1.1   栈抽象数据类型

//    ADT Stack<T>                            //栈抽象数据类型，T表示数据元素的数据类型
public interface Stack<T>                        //栈接口，描述栈抽象数据类型，T表示数据元素的数据类型
{
    public abstract boolean isEmpty();           //判断栈是否空
    public abstract void push(T x);              //元素x入栈
    public abstract T peek();                    //返回栈顶元素，未出栈
    public abstract T pop();                     //出栈，返回栈顶元素
}
//@author：Yeheya。2014-10-23