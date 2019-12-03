//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月21日
//8.5.2 树映射

//树映射类，实现Map<K, V>接口，K、V分别指定关键字和值的数据类型，
//K或K的某个祖先类实现Comparable<K>接口
public class TreeMap<K extends Comparable<? super K>, V>  implements Map<K,V>
{
    BinarySortTree<SortedKeyValue<K,V>> set;               //二叉排序树表示互异的排序集合

    public TreeMap()                                       //构造空树映射
    {
        this.set = new BinarySortTree<SortedKeyValue<K,V>>();//构造空二叉排序树
    }

    public V get(K key)                                    //返回关键字key映射的值
    {
        SortedKeyValue<K,V> kv = new SortedKeyValue<K,V>(key,null);
        SortedKeyValue<K,V> find=this.set.search(kv);      //查找
        return find!=null ? find.value : null;             //查找成功，返回值，否则返回null
    }
    public V put(K key, V value)                           //添加映射元素，关键字相同时，替换值
    {
        SortedKeyValue<K,V> kv = new SortedKeyValue<K,V>(key,value);
        if (!this.set.add(kv))                             //插入不成功，表示关键字重复
            this.set.search(kv).value = value;             //查找关键字重复元素，替换值
        return value;
    }
  
    //以下方法体省略，【实验8-7】
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
  
    public boolean containsKey(K key)                      //判断是否包含关键字为key元素
    {
        return this.get(key)!=null;
    }
  
    public V remove(K key)                                 //删除关键字为key元素，返回被删除元素的值
    {
        return this.set.remove(new SortedKeyValue<K,V>(key,null)).value; 
    }
    public void clear()                                    //删除所有元素
    {
        this.set.clear(); 
    }
    public void printAll()                           //以散列表形式输出所有元素
    {
    	System.out.println(this.set.toString());
        this.set.printASL();
    }

    public BinarySortTree<K> keySet()                      //返回关键字集合
    {
        return null;
    }
    int i=0;
    public Object[] values()                               //返回包含值集合的数组，值可重复
    {
        Object[] value = new Object[this.size()];
        i=0;
        values(value, this.set.root);
        return value;
    }
    //中根次序遍历以p为根的子树，递归算法返回包含值集合的数组，值可重复
    private void values(Object[] value, TriNode<SortedKeyValue<K,V>> p)
    {
        if (p!=null)
        {
            value[i++] = p.data.value;
            values(value,p.left);
            values(value,p.right);
        }
    }
}

    /*以下没实现
    public BinarySortTree<K> keySet()                   //返回关键字集合
    {
        BinarySortTree<K> keyset= new BinarySortTree<K>();
      Object[] keyvalues = this.hashset.toArray();  //如果散列表支持迭代，就不需要使用数组中转了
      for (int i=0; i<keyvalues.length; i++)
          keyset.add(((KeyValue<K,V>)keyvalues[i]).key);
      return keyset;
  }
  
  public boolean containsValue(Object value)         //判断是否包含指定值
  //？？没道理，根据值查找，不同的比较规则
}*/
//@author：Yeheya。2014-10-23
