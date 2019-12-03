//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月19日
//8.4.2  散列映射
//（1） 映射元素类

public class KeyValue<K, V>                      //映射元素类，K、V分别指定关键字和值的数据类型
{
    final K key;                                 //关键字，最终变量，只能赋值一次 
    V value;                                     //值
    
    public KeyValue(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
    public String toString()                     //返回描述字符串，形式为“(关键字,值)”
    {
        return "("+this.key+","+this.value+")";
    }
    public final int hashCode()                  //返回散列码，覆盖Object类的方法。最终方法，不能被覆盖
    {
        return this.key.hashCode();              //仅以关键字的散列码作为对象的散列码，唯一，正数
    }
    public boolean equals(Object obj)            //比较对象是否相等，仅比较关键字，覆盖Object类的方法
    {
        return obj==this ||
               obj instanceof KeyValue<?,?> && this.key.equals(((KeyValue<K,V>)obj).key);
    }
}
/*
java.util.HashMap<K, V>中内部类：

static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;

    Node(int hash, K key, V value, Node<K,V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final K getKey()        { return key; }
    public final V getValue()      { return value; }
    public final String toString() { return key + "=" + value; }

    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Map.Entry) {
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            if (Objects.equals(key, e.getKey()) &&
                Objects.equals(value, e.getValue()))
                return true;
        }
        return false;
    }
}*/

//@author：Yeheya。2014-8-16
