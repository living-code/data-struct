//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月14日
//8.4.1   散列表
//采用链地址法的散列表类，包括插入、删除、查找、遍历等操作。

public class HashSet<T>  //implements Set<T>           //散列表类，采用链地址法
//extends MyAbstractSet<T> //10.2
{
    private SinglyList<T>[] table;                         //散列表，同义词单链表对象数组
    private int count = 0;                                 //元素个数
    private static final float LOAD_FACTOR = 0.75f;        //装填因子，元素个数与容量之比
//    private static final float MIN_CAPACITY = 16;          //默认最小容
    
    public HashSet(int length)                             //构造容量为length的散列表
    {
        if (length<10)                                     //为了图8.12和图8.14
        	length=10;                                     //设置最小容量
    	this.table = new SinglyList[length];
        for (int i=0; i<this.table.length; i++)
            this.table[i] = new SinglyList<T>();           //构造空单链表
//        this.enlarge(capacity);
    }
    public HashSet()                                       //构造空散列表，默认容量
    {
        this(16); 
    }

    //散列函数，计算关键字为x元素的散列地址。若x==null，Java抛出空对象异常
    private int hash(T x)
    {
        int key = Math.abs(x.hashCode());                  //每个对象的hashCode()方法返回int
        return key % this.table.length;                    //除留余数法，除数是散列表容量
    }
    
    public T search(T key)                       //返回查找到的关键字为key元素，若查找不成功返回null
    {
        Node<T> find = this.table[this.hash(key)].search(key); //在单链表中查找关键字为key元素
        return find==null ? null : find.data;
    }
    public boolean add(T x)                                //插入x元素，若x元素关键字重复，则不插入
    {
        if (this.count>this.table.length*LOAD_FACTOR)      //若散列表满，则扩充容量
        {
            this.printAll();
            System.out.print("\n添加"+x+"，");
            
        	SinglyList<T>[] temp = this.table;             //散列表，同义词单链表对象数组
            this.table = new SinglyList[this.table.length*2];
            for (int i=0; i<this.table.length; i++)
                this.table[i] = new SinglyList<T>(); 
            this.count=0;
            for (int i=0; i<temp.length; i++)              //遍历原各同义词单链表，添加原所有元素
                for (Node<T> p=temp[i].head.next;  p!=null;  p=p.next)
                    this.add(p.data);
        }        
        boolean insert=this.table[this.hash(x)].insertDifferent(x)!=null;
        if (insert)                                        //单链表尾插入关键字不重复元素
            this.count++;
        return insert;
        
        //第5版??    
/*也可        T find = this.search(x);                           //查找
        if (find==null)                                    //查找不成功插入关键字不重复元素，单链表头插入，反序。？？不需要insertDifferent(x)
        {
            this.table[this.hash(x)].insert(0,x);
            this.count++;
            return true;
        }
        return false;*/
        
    } 
        
    public T remove(T key)                                 //删除关键字为key元素，返回被删除元素
    {
        T x = this.table[this.hash(key)].remove(key);      //同义词单链表删除key元素结点
        if (x!=null)
            this.count--;
        return x;
    }

    //以下方法体省略，【思考题8-3】，以下方法声明同Collection<T>接口
    public HashSet(T[] values)                             //构造散列表，由values数组提供元素集合
    {
        this((int)(values.length/HashSet.LOAD_FACTOR));    //构造指定容量的空散列表
        this.addAll(values);                               //插入values数组所有元素
    }
    public int size()                                      //返回元素个数
    {
        return count;
    }
    public boolean isEmpty()                               //判断是否为空
    {
        return this.size()==0;
    }
    
    public boolean contains(T key)                         //判断是否包含关键字为key元素
    {
        return this.search(key)!=null;
    }
    public void addAll(T[] values)                         //插入values数组所有元素
    {
        for (int i=0; i<values.length; i++)
            this.add(values[i]);                           //插入元素
    }
    
    public void clear()                                    //删除所有元素
    {
        for (int i=0; i<this.table.length; i++)            //遍历各同义词单链表
            this.table[i].clear();
    }
    
    public String toString()                               //返回散列表所有元素的描述字符串
    {
        String str=this.getClass().getName()+"(";
        boolean first=true;
        for (int i=0; i<this.table.length; i++)            //遍历各同义词单链表
            for (Node<T> p=this.table[i].head.next;  p!=null;  p=p.next)
            {
                if (!first)
                    str += ",";
                first=false;
                str += p.data.toString();
            }
        return str+")";
    }

    public void printAll()                                 //输出散列表的存储结构，计算ASL成功
    {
        System.out.println("散列表：容量="+this.table.length+"，"+this.count+"个元素"+
                           "，hash(key)=key % "+this.table.length+"，"+this.toString());
        for (int i=0; i<this.table.length; i++)            //遍历各同义词单链表
            System.out.println("table["+i+"]="+this.table[i].toString());

        System.out.print("ASL成功=(");
        int asl=0;
        for (int i=0; i<this.table.length; i++)            //遍历各同义词单链表
        {
            int j=1;
            for (Node<T> p=this.table[i].head.next;  p!=null;  p=p.next,j++)
            {
                System.out.print((asl==0 ? "" : "+")+j);
                asl+=j;
            }
        }
        if (count==0)
            System.out.println(") = 0\n");
        else
            System.out.println(")/"+count+" ="+asl+"/"+count+" ="+((asl+0.0)/count)+"\n");
    }
    
    
    //以下教材没写
    //不行  public T[] toArray()                              //返回包含集合所有元素的数组
    public Object[] toArray()                              //返回包含集合所有元素的数组
    {
        Object[] values = new Object[this.size()];
        int j=0;
        for (int i=0; i<this.table.length; i++)            //遍历各同义词单链表
            for (Node<T> p=this.table[i].head.next;  p!=null;  p=p.next)
                values[j++] = p.data;
        return values;
    }
    public void enlarge(int length)                        //散列表扩充容量为capacity
    {
        this.table = new SinglyList[length];
        for (int i=0; i<this.table.length; i++)
            this.table[i] = new SinglyList<T>();           //构造空单链表
    }
}
/*
public final class Integer
{
    public int hashCode()                //覆盖Object类中方法
    {
        return value;
    }
} 
 **/    

//@author：Yeheya。2015-3-19

