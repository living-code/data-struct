//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年9月15日
//§2.4   线性表的应用：多项式的表示及运算
//§2.4.1   一元多项式的表示及运算
//2.  一元多项式的排序单链表实现

public interface Addible<T>                      //可相加接口，T表示数据元素的数据类型
{
    public void add(T t);                        //+=加法，约定两元素相加规则
    public boolean removable();                  //约定删除元素条件
}
