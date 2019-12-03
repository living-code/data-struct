//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月24日
//10.2.2   基于迭代器的操作
//2.  抽象列表类

import java.util.Iterator;                                 //Java迭代器接口

//抽象列表类，继承MyAbstractCollection<T>类，为线性表提供基于迭代器的遍历算法
//不能使用列表迭代器，否则不能作为单链表的父类
public abstract class MyAbstractList<T>  extends MyAbstractCollection<T> 
{
    public boolean equals(Object obj)                      //比较两个集合对象是否相等
    {
        if (obj == this)
            return true;
        if (!(obj instanceof MyAbstractList<?>))
            return false;
        java.util.Iterator<T> it1 = this.iterator();
        java.util.Iterator<T> it2 = ((MyAbstractList<T>)obj).iterator();
        while (it1.hasNext() && it2.hasNext()) 
            if (!(it1.next().equals(it2.next())))          //比较集合元素，本书声明的集合中没有null对象
                return false;
        return !it1.hasNext() && !it2.hasNext();           //两个空集合也相等
    }
}
//【思考题10-5】
/*    //删除第i个元素，返回被删除元素。使用迭代器。//？？算法不行
    public T remove(int i)
    {
        Iterator<T> it = this.iterator();        //获得迭代器对象
        T value=null;
        int j=0;
        for (j=-1; j<i && it.hasNext(); j++)
            value = it.next();
        if (j==i)
            it.remove();       //此句不行，方法体调用SeqList的remove(i)，相互调用
        return value;
    }*/

//@author：Yeheya。2014-8-24
