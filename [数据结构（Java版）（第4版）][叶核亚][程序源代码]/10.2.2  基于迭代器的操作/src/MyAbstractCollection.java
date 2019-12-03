//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月24日
//10.2.2  基于迭代器的操作
//1.  抽象集合类

import java.util.*;                                 //Java迭代器接口

//抽象集合类，实现Iterable<T>可迭代接口，为所有集合提供迭代方式的遍历算法
public abstract class MyAbstractCollection<T> implements java.lang.Iterable<T> 
//public abstract class MyAbstractCollection<T> implements java.util.Collection<T> 
{
    public abstract Iterator<T> iterator();                //获得迭代器对象，抽象方法

    public String toString()                     //返回集合所有元素的字符串描述，形式为“(,)”
    {
//        String str=this.getClass().getName()+"(";          //返回类名
        String str="(";
        Iterator<T> it = this.iterator();                  //it是一个迭代器对象
        while (it.hasNext())                               //若有后继元素
        {
            str += it.next().toString();                   //添加后继元素字符串
            if (it.hasNext())
                str += ",";
        } 
        return str+")";
    }
    //不能用逐元循环，无法判断是否最后一个
    
    public boolean remove(Object key)            //删除首次出现的关键字为key元素
    {
        Iterator<T> it = this.iterator();
        while (it.hasNext())
            if (key.equals(it.next()))
            {
                it.remove();                     //删除迭代器表示的集合当前元素
                return true;
            }
        return false;       
    }
    //不能用逐元循环，无法调用删除方法

    public abstract boolean add(T x);            //增加元素x，抽象方法
    
    //添加c的所有元素，集合并运算。若修改，返回true。    //使用迭代器，算法同 MyAbstractSet<T>
/*    public boolean addAll(Collection<? extends T> c) //算法正确，基于迭代器
    {
        boolean modify=false;
        Iterator<?> it = c.iterator();           //迭代器对象
        while (it.hasNext())                     //遍历各元素
            modify = this.add((T)it.next());     //add(x)运行时多态，由各子类实现
        return modify;
    }*/

    public boolean addAll(Collection<? extends T> c) //算法正确，基于逐元循环
    {
        boolean modify=false;
        for (T obj : c)                          //逐元循环，obj逐个引用c集合中的元素
            modify = this.add(obj);              //add(x)运行时多态，由各子类实现
        return modify;
    }
    
    //【思考题10-5】
    //判断集合是否包含关键字为key元素，若包含返回true。若key==null
/*    public boolean contains(Object key)      //算法正确，基于迭代器
    {
        Iterator<T> it = this.iterator();
        while (it.hasNext())
            if (key.equals(it.next()))
                return true;
        return false;
    }*/
    //逐元循环的条件是数组，或实现迭代器的类
    public boolean contains(Object key)          //算法正确，基于逐元循环
    {
        for (T obj : this)                       //逐元循环，obj逐个引用this当前集合中的元素
            if (key.equals(obj))
                return true;
        return false;
    }
    
    //判断是否包含c的所有元素，判断c是否子集
/*    public boolean containsAll(Collection<?> c)//算法正确，基于迭代器
    {
        Iterator<?> it = c.iterator();
        while (it.hasNext())
            if (!this.contains(it.next()))
                return false;
        return true;
    }*/
    
    public boolean containsAll(Collection<?> c)  //算法正确，基于逐元循环
    {
        for (Object obj : c)                     //逐元循环，obj逐个引用c集合中的元素
            if (!this.contains(obj))
                return false;
        return true;
    }
    
    public abstract int size();                  //返回集合元素个数，抽象方法

    public Object[] toArray()                    //返回包含当前集合中所有元素的数组
    {
        Object[] temp = new Object[this.size()];
        Iterator<T> it = this.iterator();        //迭代器对象
        int i=0; 
        while (it.hasNext())                     //遍历各元素
            temp[i++]=it.next();
        return temp;
    }

    public abstract boolean isEmpty();           //判断集合是否空，抽象方法
    public abstract void clear();                //删除当前集合的所有元素
//    <E> E[] toArray(E[] a);                 //返回E类型数组，参数a指定返回的数组类型

        //以下方法描述集合运算，参数是另一个集合
    public abstract boolean equals(Object obj);            //比较两个集合是否相等
    public abstract boolean removeAll(Collection<?> c);    //删除那些也包含在集合c中的元素，集合差运算
    public abstract boolean retainAll(Collection<?> c);    //仅保留那些也包含在集合c中的元素
}
//@author：Yeheya。2014-10-25
