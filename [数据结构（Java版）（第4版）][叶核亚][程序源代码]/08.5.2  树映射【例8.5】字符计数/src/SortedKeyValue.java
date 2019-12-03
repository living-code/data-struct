//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月21日
//8.5.2 树映射

//树映射元素类，继承KeyValue<K, V>映射元素类，K、V分别指定关键字和值的数据类型；
//限定K或K的某个祖先类必须实现Comparable<K>接口；
//本类可比较对象大小，比较对象大小的规则由关键字的类型K约定
public class SortedKeyValue<K extends Comparable<? super K>, V>
    extends KeyValue<K, V>  implements Comparable<SortedKeyValue<K,V>>
{
    public SortedKeyValue(K key, V value)
    {
        super(key,value);
    }    
   
    public int compareTo(SortedKeyValue<K,V> kv) //比较对象大小，仅比较关键字的大小
    {
        return this.key.compareTo(kv.key);
    }
}

