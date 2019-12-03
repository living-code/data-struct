//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月19日
//8.4.2  散列映射
//（2） 映射接口

public interface Map<K, V>                       //映射接口，K、V分别指定映射元素的关键字和值的数据类型
{
    public abstract boolean isEmpty();           //判断是否空
    public abstract int size();                  //返回元素个数
    public abstract String toString();           //返回所有元素的描述字符串
    public abstract V get(K key);                //返回关键字key映射的值
    public abstract V put(K key, V value);       //添加映射元素(键,值)，关键字相同时，替换值    
    public abstract V remove(K key);             //删除关键字为key元素，返回被删除元素的值
    public abstract boolean containsKey(K key);  //判断是否包含关键字为key元素
    public abstract void clear();                //删除所有元素
    public abstract Object[] values();           //返回包含值集合的数组，值可重复
}
/*没实现以下，java.util.Map<K,V>声明
    public boolean containsValue(Object value)         //判断是否包含指定值
    //？？没道理，根据值查找，不同的比较规则，且不唯一
*/
//@author：Yeheya。2014-10-23
