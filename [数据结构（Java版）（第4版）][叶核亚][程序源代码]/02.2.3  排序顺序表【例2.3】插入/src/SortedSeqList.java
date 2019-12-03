//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月22日，JDK 8.11
//§2.2  线性表的顺序存储和实现
//§2.2.3  排序顺序表
//第3版用，5.2.2  稀疏矩阵三元组顺序表 用升序，第4版没写
//§9.5.1   顺序表的排序算法

//排序顺序表类（升序），T或T的某个祖先类必须实现Comparable<T>接口；继承顺序表类
public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T>
{
    //构造方法
    public SortedSeqList()                                 //构造空排序顺序表
    {
        super();                                           //默认调用父类构造方法SeqList()
    }
    public SortedSeqList(int length)                       //构造空排序顺序表，容量为length
    {
        super(length);                                     //调用父类构造方法SeqList(length)。若省略，默认调用super()
    }
    public SortedSeqList(T[] values)                       //构造排序顺序表，由values数组提供元素，O(n2)
    {
        super(values.length);                              //创建空排序顺序表，指定容量
        for (int i=0; i<values.length; i++)                //直接插入排序，每趟插入1个元素（//9.5.1 顺序表的排序算法）
            this.insert(values[i]);                        //插入元素，根据对象大小确定插入位置，O(n)
    }
    
    //拷贝构造方法
    //由顺序表list构造排序顺序表。直接插入排序算法，O(n*n)。    //SeqList<T>中的T，就是SortedSeqList<T>中的T，可比较大小
    public SortedSeqList(SeqList<? extends T> list)
    {
        super();                                           //创建空排序顺序表，默认调用父类构造方法SeqList()
        for (int i=0; i<list.n; i++)             //2.2.3
            this.insert(list.get(i));                      //调用子类覆盖的insert(T)方法，按值插入，O(n)
//      this.addAll(list);                       //for也可写成，教材此时还没有讲到addAll()；//9.5.1

//不行           this(list.element);                                //调用SortedSeqList(T[] values) 
//不行，list.element类型是Object[]，不是T[]
    }//9.5.1   顺序表的排序算法 又写

    public SortedSeqList(SortedSeqList<? extends T> list)  //排序顺序表的拷贝构造方法，深拷贝，O(n)
    {
        super(list);                                       //调用SeqList(SeqList<T>)，list引用子类实例，参数类型赋值相容
    }
    //调用toPreviousString()方法得到降序排序的线性表

    //不支持父类的以下两个方法，将其覆盖并抛出异常
    public void set(int i, T x)
    {
        throw new UnsupportedOperationException("set(int i, T x)");
    }

    //子类需要用，若覆盖，子类调用则抛出异常？？
    public int insert(int i, T x)
    {        
        throw new java.lang.UnsupportedOperationException("insert(int i, T x)");
    }
    
    //顺序查找首次出现的与key相等元素，返回元素序号i（0≤i<n）；若查找不成功返回-1，O(n)。覆盖
    public int search(T key)
    {
//        System.out.print(this.getClass().getName()+".indexOf("+key+","+start+")，");
        for (int i=0; i<this.n && key.compareTo(this.get(i))>=0; i++)//（升序）
        {
//            System.out.print(this.element[i]+"？");
            if (key.compareTo(this.get(i))==0)             //对象相等，运行时多态
                return i;
        }
        return -1;                                         //空表或未找到时
    }
    
    //插入x，x!=null，根据x对象大小顺序查找确定插入位置（升序），插入在等值结点之前，返回x序号，O(n)。
    //调用T的compareTo()方法比较对象大小。覆盖父类insert(x)，参数列表和返回值相同
    public int insert(T x)
    {
        int i=0;
        if (this.isEmpty() || x.compareTo(this.get(this.n-1))>0)//compareTo(T)比较大小
            i=this.n;                                      //最大值尾插入，O(1) 
        else
            while (i<this.n && x.compareTo(this.get(i))>0) //寻找插入位置（升序）
                i++;
        super.insert(i, x);                      //调用父类被覆盖的insert(i,x)方法，插入x作为第i个元素 
        return i;
    }

    //继承，运行时多态
/*    public T remove(T key)                                 //删除首次出现的与key相等元素，返回被删除元素；查找不成功返回null。覆盖
    {
        return this.remove(this.search(key));              //先查找，再remove(i)。若查找返回-1，则不删除
                                                           //其中this.search(key)调用子类的查找方法
    }*/
    //2015年1月30日测试，校清样，正确，不需要重写。

    
    //【思考题2-4】习题解答
//    public void addAll(SeqList<? extends T> list)      //继承

//    public SeqList<T> union(SeqList<? extends T> list)     //继承
    public SortedSeqList<T> union(SeqList<? extends T> list) //覆盖，返回值类型不同但赋值相容，包含参数SortedSeqList<? extends T> 
    {
        SortedSeqList<T> result = new SortedSeqList<T>(this);   //创建子类实例，深拷贝父类实例。只此一句不同
        result.addAll(list);                                //排序顺序表合并，按值插入
        return result;                                      //返回SortedSeqList<T>对象
    }

    //【实验2-2】  排序顺序表增加成员方法（也可以声明子类DifferentSortedSeqList实现）
    public int insertDifferent(T x)                        //插入不重复元素。查找不成功时，插入。覆盖
    {
        int i=0;
        if (this.isEmpty() || x.compareTo(this.get(this.n-1))>0)//compareTo(T)比较大小
            i=this.n;                                      //最大值尾插入，O(1) 
        else
            while (i<this.n && x.compareTo(this.get(i))>0) //寻找插入位置（升序）
                i++;
        if (x.compareTo(this.get(i))<0)                    //插入不重复元素
        {
            super.insert(i, x);                            //调用父类被覆盖的insert(i,x)方法，插入x作为第i个元素 
            return i;
        }
        return -1;
    }
    //author：Yeheya。2015-4-28

    
    //8.2   基于排序顺序表的二分法查找     第4版教材没有写，写数组的二分法查找了
    //二分法查找关键字为key元素，若查找成功返回下标，否则返回-1    
    public int binarySearch(T key)
    {
        return binarySearch(key, 0, this.n-1);
//    	return SortedArray.binarySearch((T)this.element, key);  //语法错误，不能将Object[]转换成T[]
    }  
    //在begin～end范围内，二分法查找关键字为key元素，若查找成功返回下标，否则返回-1。
    //若key==null，Java将抛出空对象异常；若begin、end越界，返回-1
    public int binarySearch(T key, int begin, int end)
    {
        while (begin<=end)                                 //边界有效
        {   int mid = (begin+end)/2;                       //取中间位置，当前比较元素位置
            System.out.print(this.get(mid)+"? ");          //显示比较中间结果，可省略
            if (key.compareTo(this.get(mid))==0)           //两对象相等
                return mid;                                //查找成功
            if (key.compareTo(this.get(mid))<0)            //key对象较小
                end = mid-1;                               //查找范围缩小到前半段
            else begin = mid+1;                            //查找范围缩小到后半段
        }
        return -1;                                         //查找不成功
    }
    //不能调用以下方法，编译错，因为不能将Object[]转换成T[]        
    //SortedArray.binarySearch((T)this.element, begin, end, key);
    //带比较器参数？？
    //@author：Yeheya。2014-8-9
    
    
    //第9章
    //9.5.1   顺序表的排序算法
    //注意，以下3方法，深拷贝仅复制数组，没有复制对象，操作后存在共用对象问题
/*    public SortedSeqList(T[] values)             //构造排序顺序表，由values数组提供元素
    {
        super(values);                           //构造顺序表，由values数组提供元素
        //采用一种排序算法对顺序表的this.element数组元素进行排序，算法省略
                
        Array9.insertSort(this.element);        //调用排序算法，对顺序表的数组元素进行排序
                                                 //编译错，因为不能将Object[]转换成T[]        
    }
    
    //由顺序表list构造排序顺序表。
    public SortedSeqList(SeqList<? extends T> list)    //SeqList<T>中的T，是SortedSeqList<T>类声明的T，可比较大小
    {
        super(list);                             //顺序表深拷贝，复制顺序表，未复制元素对象。
        //以下采用一种排序算法对顺序表的this.element数组元素进行排序，算法省略，需要访问SeqList<T>的成员变量element和n，因此两者的权限应设置为protected
//      Array9.insertSort((T)this.element);           //语法错误，不能把Object[]转换成T[]
        for (int i=1; i<this.n; i++)             //直接插入排序（升序）
        {
            T temp=(T)this.element[i];           //警告：强制类型转换Object到T，不安全
            int j;
            for (j=i-1; j>=0 && temp.compareTo((T)this.element[j])<0; j--)  //(T)this.element[j]，T可比较大小
                this.element[j+1] = this.element[j];
            this.element[j+1] = temp;
        }
    }*/
    
    
    //9.5.1   顺序表的排序算法
    //【实验题9-2】
    //归并两条排序顺序表（升序），将list中所有元素归并到this中，不改变list。
    //this+=list，一次归并算法
    //由于Java的对象引用模型，自动析构，不会导致类似C++重复释放存储单元空间问题，但没有复制元素
    //若list==null，抛出空对象异常
    //第4版教材方法体省略
    public void merge(SortedSeqList<? extends T> list)  
    {
        Object[] temp = this.element;
        this.element = new Object[(this.n+list.n)*2];  //扩充当前顺序表容量
        int i=0, j=0, k=0;
        while (i<this.n && j<list.n)
            if (((T)temp[i]).compareTo((T)list.element[j])<=0)
                this.element[k++]=temp[i++];
            else
            	this.element[k++]=list.element[j++];

        while (i<this.n)
            this.element[k++]=temp[i++];
        while (j<list.n)
            this.element[k++]=list.element[j++];
        this.n+=list.n;
    }
    
    //返回this和list归并（升序）后的排序顺序表，不改变this和list顺序表，一次归并算法。方法体省略
    public SortedSeqList<T> mergeWith(SortedSeqList<? extends T> list)  
    {
        SortedSeqList<T> templist = new SortedSeqList<T>((this.n+list.n)*2);
        int i=0, j=0, k=0;
        while (i<this.n && j<list.n)
            if (((T)this.element[i]).compareTo((T)list.element[j])<=0)
                templist.element[k++]=this.element[i++];
            else
                templist.element[k++]=list.element[j++];

        while (i<this.n)
            templist.element[k++]=this.element[i++];
        while (j<list.n)
            templist.element[k++]=list.element[j++];
        templist.n=this.n+list.n;
        return templist;
    }
}
    //@author：Yeheya。2014-8-19
