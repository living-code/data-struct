//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月22日，JDK 8.11
//§1.1.3   数据类型与抽象数据类型
//【例1.1】  集合的表示与实现。

//ADT Set<T>                                               //集合抽象数据类型
public interface Set<T>                                    //集合接口
{
 // 数据：集合中的数据元素，数据元素的数据类型为T
 // 操作：
    public abstract boolean isEmpty();                     //判断集合是否为空
    public abstract int size();                            //返回元素个数
    public abstract T search(T key);                       //返回查找到的关键字为key元素
    public abstract boolean contains(T key);               //判断是否包含关键字为key元素
    public abstract boolean add(T x);                      //增加元素x，若增加，返回true
    public abstract T remove(T key);                       //删除关键字为key元素，返回被删除元素
    public abstract void clear();                          //删除所有元素
    public abstract String toString();                     //返回集合所有元素的描述字符串
    public abstract boolean equals(Object obj);            //比较this与obj引用集合是否相等
    public abstract Object[] toArray();                    //返回包含集合所有元素的数组
    
    //以下方法描述集合运算，参数是另一个集合
    public abstract boolean containsAll(Set<?> set);       //判断是否包含set的所有元素（是否子集）
    public abstract boolean addAll(Set<? extends T> set);  //添加set的所有元素，集合并运算。若修改，返回true
    public abstract boolean removeAll(Set<?> set);         //删除也包含在set的元素，集合差
    public abstract boolean retainAll(Set<?> set);         //仅保留那些也包含在set的元素，集合差
}
//@author：Yeheya。2014-10-16
//无法实现？？    <E> E[] toArray(E[] a);                      //返回E类型数组，参数a指定返回的数组类型
