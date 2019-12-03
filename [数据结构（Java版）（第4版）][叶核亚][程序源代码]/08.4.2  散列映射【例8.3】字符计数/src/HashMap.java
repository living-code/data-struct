//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月19日
//8.4.2  散列映射
//使用散列表作为成员变量，可行

//散列映射类，实现Map<K, V>接口，K、V分别指定元素的关键字和值的数据类型
public class HashMap<K, V> implements Map<K,V>
{
    HashSet<KeyValue<K,V>> set;                            //散列表，元素是KeyValue<K,V>

    public HashMap(int length)                             //构造容量为length的散列映射
    {
        this.set = new HashSet<KeyValue<K,V>>(length);
    }
    public HashMap()                                       //构造默认容量的散列映射
    {
        this.set = new HashSet<KeyValue<K,V>>();           //构造默认容量的散列表
    }

    public boolean isEmpty()                               //判断是否空
    {
        return this.set.isEmpty(); 
    }
    public int size()                                      //返回元素个数
    {
        return this.set.size(); 
    }
    public String toString()                               //返回所有元素的描述字符串
    {
        return this.set.toString(); 
    }
    
    public V get(K key)                                    //返回关键字key映射的值
    {
        KeyValue<K,V> find=this.set.search(new KeyValue<K,V>(key,null));  //查找
        return find!=null ? find.value : null;             //查找成功，返回值，否则返回null
    }
    
    public V put(K key, V value)                           //添加映射元素(键,值)，关键字相同时，替换值
    {
        KeyValue<K,V> kv = new KeyValue<K,V>(key,value);
        if (!this.set.add(kv))                             //插入不成功，表示关键字重复
            this.set.search(kv).value = value;             //查找关键字重复元素，替换值
        return value;
    }
    
    public V remove(K key)                                 //删除关键字为key元素，返回被删除元素的值
    {
        return this.set.remove(new KeyValue<K,V>(key,null)).value; 
    }

    public boolean containsKey(K key)                      //判断是否包含关键字为key元素
    {
        return this.get(key)!=null;
    }
    
    public void clear()                                    //删除所有元素
    {
        this.set.clear(); 
    }

    //【实验10-4】
    public HashSet<K> keySet()                             //返回关键字集合
    {
        HashSet<K> keyset= new HashSet<K>();
        Object[] keyvalues = this.set.toArray();           //如果散列表支持迭代，就不需要使用数组中转了
        for (int i=0; i<keyvalues.length; i++)
            keyset.add(((KeyValue<K,V>)keyvalues[i]).key);
        return keyset;
    }
    
    public Object[] values()                               //返回包含值集合的数组，值可重复
    {
        Object[] values = new Object[this.size()];
        Object[] keyvalues = this.set.toArray();
        for (int i=0; i<keyvalues.length; i++)
            values[i] = ((KeyValue<?,?>)keyvalues[i]).value;
        return values;
    }
    //不能返回HashSet<V>，因为值重复。Map<K,V>声明如下
    //public Collection<V> values()                  //返回值集合

    public void printAll()                           //以散列表形式输出所有元素
    {
        this.set.printAll();
    }
    
}
/*以下没实现
    public boolean containsValue(Object value)         //判断是否包含指定值
    {
        return this.hashset.contains(new KeyValue<K,V>(null,(V)value));
    }//？？没道理，根据值查找，不同的比较规则
}*/
//@author：Yeheya。2014-10-19
