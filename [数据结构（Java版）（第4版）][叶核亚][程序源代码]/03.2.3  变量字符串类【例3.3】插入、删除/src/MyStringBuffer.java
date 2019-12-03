//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月27日
//3.2.3   变量字符串类
    //【思考题3-3】
    //【实验3-10】    

//变量字符串类，最终类，实现序列化接口
public final class MyStringBuffer implements java.io.Serializable
{
    private char[] value;                                  //字符数组，私有成员变量
    private int n;                                         //串长度
    
    //1.  构造变量字符串
    public MyStringBuffer(int capacity)                    //构造容量为capacity的空串
    {
        this.value = new char[capacity];
        this.n = 0;
    }    
    public MyStringBuffer()                                //以默认容量构造空串
    {
        this(16);
    }
    public MyStringBuffer(String s)                        //以字符串常量构造串
    {
        this(s.length()+16);
        this.n = s.length();
        for (int i=0; i<this.n; i++)                       //复制s串所有字符
            this.value[i] = s.charAt(i);
    }
    
    public int length()                                    //返回字符串长度
    {
         return this.n;                                    //区别，value.length是数组容量
    }
    public int capacity()                                  //返回字符数组容量
    {
        return this.value.length;
    }

    public synchronized char charAt(int i)                 //返回第i个字符，0≤i<length()
    {
        if (i>=0 && i<this.n)
            return this.value[i];
        throw new StringIndexOutOfBoundsException(i);
    }
    public void setCharAt(int i, char ch)                  //设置第i个字符为ch，0≤i<length()
    {
        if (i>=0 && i<this.n)
            this.value[i] = ch;
        else throw new StringIndexOutOfBoundsException(i);
    }
    
    public synchronized String toString()  
    {
        return new String(this.value, 0, this.n);          //以value数组从0至n字符构造String串
    }
    
    public synchronized void setLength(int n)              //设置串长度为n。若数组容量不足，则扩充
    {
        if (n>0)
        {
            if (n > this.value.length)                     //若数组空间不足，则扩充
            {
                char[] temp = this.value;
                this.value = new char[n*2];                //重新申请字符数组空间
                for (int i=0; i<temp.length; i++)          //复制串
                this.value[i] = temp[i];
            }
            for (int i=this.n; i<this.value.length; i++)   //数组补空格
                this.value[i] = ' ';
            this.n = n;                                    //改变串长度，或缩短；或加长，已补空格
        }
        else throw new NegativeArraySizeException("n="+n); //抛出负数组长度异常
    }
    
    
    //2.  插入串
    //在第i个字符处插入s串，0≤i<length()。若i序号越界，抛出字符串序号越界异常；若s==null，插入"null"
    public synchronized MyStringBuffer insert(int i, String s)
    {
        if (this.n==0 && i==0 || this.n>0 && i>=0 && i<this.n)
        {
            if (s==null)  
                s = "null";
            char[] temp=this.value;
            if (this.value.length < this.n+s.length())     //若数组空间不足，则扩充
            {   this.value = new char[(this.value.length+s.length())*2]; //重新申请字符数组空间
                for (int j=0; j<i; j++)                    //复制当前串前i-1个字符
                    this.value[j] = temp[j];
            }
            for (int j=this.n-1; j>=i; j--)                //从i开始至串尾的子串向后移动，次序从后向前
                this.value[j+s.length()] = temp[j];
            for (int j=0; j<s.length(); j++)               //插入s串
                this.value[i+j] = s.charAt(j);
            this.n += s.length();
            return this;
        }
        else throw new StringIndexOutOfBoundsException("i="+i);  //抛出字符串序号越界异常
    }

    public synchronized MyStringBuffer insert(int i, boolean b)  //在i处插入变量值转换成的串
    {
        return this.insert(i, b ? "true" : "false");
    }
    public synchronized MyStringBuffer append(String s)    //添加s串
    {
        return this.insert(this.n, s);
    }

    //3.  删除子串
    //删除从begin到end-1的子串，0≤begin<length()，end≥0，begin≤end；
    //若end≥length()，删除到串尾；若begin越界，或begin>end抛出字符串序号越界异常
    public synchronized MyStringBuffer delete(int begin, int end)
    {
        if (begin>=0 && begin<this.n && end>=0 && begin<=end)
        {
            if (end>this.n)                                //end超长容错
                end=this.n;
            for(int i=0; i<this.n-end; i++)                //从end开始至串尾的子串向前移动
                this.value[begin+i] = this.value[end+i];
            this.n -= end-begin;
            return this;
        }
        else throw new StringIndexOutOfBoundsException("begin="+begin+"，end="+end+"，end-begin="+(end-begin));
    }
    //【例3.3】  StringBuffer串的插入、删除操作。
    //@author：Yeheya。2014-9-30    
    
    //【思考题3-3】
    //将从begin到end-1的子串替换为s串。可行，效率较低
    MyStringBuffer replace(int begin, int end, String s)
    {
        this.delete(begin, end);
        this.insert(begin, s);
        return this;
    }    
    
    //【实验3-10】    
//  public MyStringBuffer deleteCharAt(int i)                //删除第i个字符，方法体省略
    public MyStringBuffer reverse()                        //将this串逆转并返回
    {
        for (int i=0; i<this.n/2; i++)
        {
   	        char temp = value[i];
   	        value[i] = value[this.n-i-1];
            value[this.n-i-1] = temp;
        }
        return this;
    }
}
//@author：Yeheya。2014-10-3        
/*    //【思考题3-3】
//将从begin到end-1的子串替换为s串。每字符一次移动到位。效率较高？？
MyStringBuffer replace(int begin, int end, String s)
{
    if (begin>=0 && begin<this.n && end>=0 && begin<=end)
    {
        if (end>this.n)                                //end超长容错
            end=this.n;
        for(int i=0; i<this.n-end; i++)                //从end开始至串尾的子串向前移动
            this.value[begin+i] = this.value[end+i];

        this.n -= end-begin;
        return this;
    }
    else throw new StringIndexOutOfBoundsException("begin="+begin+"，end="+end+"，end-begin="+(end-begin));

    System.arraycopy(value, end, value, begin + n, n - end);
    s.getChars(value, begin);
    n = newCount;
    return this;

    char temp[]=this.value;
    if (this.value.length-this.n < s.length() - (end - begin))     //若当前串的数组空间不足，则扩充容量
    {
        this.value = new char[this.value.length+s.length()*2]; //重新申请字符数组空间
        for (int j=0; j<i; j++)                        //复制当前串前i-1个字符
            this.value[j] = temp[j];
    }
    for (int j=this.n-1; j>=i; j--)
        this.value[s.length()+j] = temp[j];          //从i开始向后移动n个字符
    for (int j=0; j<s.length(); j++)                 //复制字符串s
        this.value[i+j] = s.charAt(j);
    this.n += s.length();
    return this;
}*/
//@author：Yeheya。2015-1-31        

