//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月25日
//3.2.2   常量字符串类
    //【思考题3-1】
    //【实验3-1】MyString类增加成员方法
    //【习题解答实验题3-1】串比大小
//§3.3.1 Brute-Force算法
    //【思考题3-4】

//常量字符串类，最终类，实现可比较接口和序列化接口
public final class MyString implements Comparable<MyString>, java.io.Serializable
{
    private final char[] value;                            //字符数组，私有最终变量，只能赋值一次

    //（1） 构造字符串
    public MyString()                                      //构造空串""，串长度为0
    {
        this.value = new char[0];
    }
    
    public MyString(java.lang.String s)                    //由字符串常量构造串
    {
        this.value = new char[s.length()];                 //申请字符数组并复制s串的所有字符
        for (int i=0; i<this.value.length; i++)
            this.value[i] = s.charAt(i);
    }
    
    //以value数组从i开始的n个字符构造串，i≥0，n≥0，i+n≤value.length。
    //若i与n指定序号越界，抛出字符串序号越界异常。
    public MyString(char[] value, int i, int n)
    {
        if (i>=0 && n>=0 && i+n<=value.length)
        {
            this.value = new char[n];                      //申请字符数组并复制所有字符
            for (int j=0; j<n; j++)
                this.value[j] = value[i+j];
//        java.lang.System.arraycopy(value,0,this.value,0,value.length);  //复制数组，功能for语句
//        this.value = java.util.Arrays.copyOf(value,value.length);       //复制数组，包括申请数组空间
        }
        else  throw new StringIndexOutOfBoundsException("i="+i+"，n="+n+"，i+n="+(i+n));
    }
    public MyString(char[] value)                          //以字符数组构造串
    {
        this(value, 0, value.length);
    }
    public MyString(MyString s)                            //拷贝构造方法，深拷贝
    {
        this(s.value);
    }
    
    public int length()                                    //返回串长度，即字符数组容量
    {
        return this.value.length;
    }
    public boolean isEmpty() 
    {
        return value.length == 0;
    }
    public java.lang.String toString() 
    {
        return new String(this.value);                     //java.lang.String实现为 return this;
    }
    
    //返回第i个字符，0≤i<length()。若i越界，抛出字符串序号越界异常
    public char charAt(int i)
    {
        if (i>=0 && i<this.value.length)
            return this.value[i]; 
        throw new StringIndexOutOfBoundsException(i);
    }
    
    //（2） 求子串
    //返回序号从begin至end-1的子串，0≤begin<length()，0≤end≤length()，begin<end；
    //否则抛出字符串序号越界异常
    public MyString substring(int begin, int end)
    {
        if (begin==0 && end==this.value.length) 
            return this;
        return new MyString(this.value, begin, end-begin); //以字符数组构造串对象，若begin、end越界将抛出异常
    }
    public MyString substring(int begin)                   //返回序号从begin至串尾的子串
    {
        return substring(begin, this.value.length);
    }
    
    //（3） 连接串
    //返回this与s串连接生成的串。若s==null，插入"null"
    public MyString concat(MyString s)                   
    {
        if (s==null)  
            s = new MyString("null");
        char[] buffer = new char[this.value.length+s.length()];
        int i;
        for (i=0; i<this.value.length; i++)                //复制当前串
            buffer[i] = this.value[i];
        for (int j=0; j<s.value.length; j++)               //复制指定串s
            buffer[i+j] = s.value[j];
        return new MyString(buffer);                       //以字符数组构造串对象
    }
    
    //【思考题3-1】
    public MyString trim()                                 //返回删除所有空格后的字符串
    {
        char temp[]=new char[this.value.length];
        int j=0;
        for (int i=0; i<this.value.length; i++)
            if (this.value[i]!=' ')
                temp[j++]=this.value[i];
        return new MyString(temp,0,j);                     //以temp数组中从0开始的j个字符构造串对象
    }
    
    //（4） 比较串相等
    //第4版教材省略方法体，课件写
    //比较this与obj引用的串是否相等，覆盖Object类的equals(obj)方法
    public boolean equals(Object obj)
    {
        if (this==obj)
            return true;
        if (obj instanceof MyString)
        {   MyString s=(MyString)obj;
            if (this.value.length == s.value.length)
            {   for (int i=0; i<this.value.length; i++)
                    if (this.value[i]!=s.value[i])
                        return false;
                return true;
            }
        }
        return false;
    }    

    //（5） 比较串大小
    //比较this与str串的大小，返回两者差值，实现Comparable接口
    public int compareTo(MyString s)
    {
        for (int i=0; i<this.value.length && i<s.value.length; i++)
            if (this.value[i]!=s.value[i])
                return this.value[i] - s.value[i];       //返回两串第一个不同字符的差值
        return this.value.length - s.value.length;       //前缀子串，返回两串长度的差值
    }
    //@author：Yeheya。2014-10-1    

    //3.3   串的模式匹配
    //3.3.1  Brute-Force算法
    //1.  Brute-Force算法描述与实现
    
    //返回当前串（目标串）中首个与模式串pattern匹配的子串序号，匹配失败时返回-1
    public int indexOf(MyString pattern)
    {
        return this.indexOf(pattern, 0);
    }
    
    //返回当前串（目标串）从begin开始首个与模式串pattern匹配的子串序号，若匹配失败返回-1。
    //0≤begin<this.length()。对begin容错，若begin<0，从0开始；若begin序号越界，查找不成功。
    //若pattern==null，抛出空对象异常。
    public int indexOf(MyString pattern, int begin)
    {
        int n=this.length(), m=pattern.length();
        if (begin<0)                                       //对begin容错，若begin<0，从0开始
            begin = 0;
        if (n==0 || n<m || begin>=n)                       //若目标串空、较短或begin越界，不需比较
            return -1;
        int i=begin, j=0;                                  //i、j分别为目标串和模式串当前字符下标
        int count=0;                                       //记载比较次数
        while (i<n && j<m)
        {
            count++;
            if (this.charAt(i)==pattern.charAt(j))         //若当前两字符相等，则继续比较后续字符
            {
                System.out.print("t"+i+"=p"+j+"，");
                i++;
                j++;
            }
            else                                           //否则i、j回溯，进行下次匹配
            {
                System.out.println("t"+i+"!=p"+j+"，");
                i=i-j+1;                                   //目标串下标i，退回到下个匹配子串序号
                j=0;                                       //模式串下标j，退回到0
                if (i>n-m)                                 //若目标串剩余子串的长度<m，不再比较
                    break;
            }
        }
        System.out.println("\tBF.count="+count);
        if (j==m)                                          //匹配成功
            return i-j;                                    //返回匹配的子串序号
        return -1;                                         //匹配失败时返回-1
    }

    
    //3.3.2   模式匹配应用
    //【思考题3-4】
    //返回将this（目标串）中首个与pattern匹配的子串替换成str的字符串
    public MyString replaceFirst(MyString pattern, MyString str)
    {
        int i=this.indexOf(pattern,0);                     //返回匹配子串的序号，从0开始查找  
        if (i==-1)
            return this;                                   //匹配失败时返回当前串
        return this.substring(0,i).concat(str).concat(this.substring(i+pattern.length()));//连接3个串
    }

    //返回将this（目标串）中所有与pattern匹配的子串全部替换成s的字符串
    public MyString replaceAll(MyString pattern, MyString s)
    {
        MyString temp = new MyString(this);                //拷贝构造方法，复制当前串
        int i=this.indexOf(pattern,0);
        while (i!=-1)
        {
            temp = temp.substring(0,i).concat(s).concat(temp.substring(i+pattern.length()));
            i=temp.indexOf(pattern, i+s.length());      //从下一个字符开始再次查找匹配子串
//            i=temp.indexOf(pattern, i+1);                  	//错【思考题3-4，实验题3-13】改错
        }
        return temp;
    } 
    //@author：Yeheya。2014-10-4
   
    
    //《数据结构（Java版）（第4版）试题库》，作者：叶核亚，2015年2月5日，JDK 8.25
    //以下【实验3-1】MyString类增加成员方法
    public int indexOf(char ch)                            //返回ch字符在this串中首次出现的序号
    {
        return indexOf(ch,0);
    }    
    public int indexOf(char ch, int begin)                 //返回ch从begin开始首次出现的序号
    {
        if (begin<0)                                       //序号容错
            begin = 0;
        for (int i=begin; i<this.value.length; i++)
            if (this.value[i]==ch)
                return i;
        return -1;
    }    
    
    public MyString toLowerCase()                          //将串中的大写字母全部转换成对应的小写字母
    {
        char temp[]=new char[this.value.length];
        for (int i=0; i<this.value.length; i++)
            if (this.value[i]>='A' && this.value[i]<='Z')  //大写字母
                temp[i]=(char)(this.value[i]+'a'-'A');     //转换成对应小写字母
        return new MyString(temp);
    }
    
    public MyString toUpperCase()                          //将串中的小写字母全部转换成对应的大写字母
    {
        char temp[]=new char[this.value.length];
        for (int i=0; i<this.value.length; i++)
            if (this.value[i]>='a' && this.value[i]<='z')  //小写字母
                temp[i]=(char)(this.value[i]-('a'-'A'));   //转换成对应大写字母
        return new MyString(temp); 
    }    
    
    public char[] toCharArray()                            //返回字符数组
    {
        char[] temp = new char[this.value.length];
        for (int i=0; i<temp.length; i++)                  //复制数组
        	temp[i] = this.value[i];
        return temp;
    }
    
    public boolean startsWith(MyString prefix)             //判断prefix是否前缀子串
    {
/*        if (this.value.length<prefix.value.length)
            return false;
        for (int i=0; i<prefix.value.length; i++)
            if (this.value[i]!=prefix.value[i])
                return false;
        return true;*/
        return this.indexOf(prefix)==0;//??没试
    }
    public boolean endsWith(MyString suffix)               //判断suffix是否后缀子串
    {
/*        int j=suffix.value.length-1;
        for (int i=this.value.length-1; i>=0 && j>=0; i--,j--)
            if (this.value[i]!=suffix.value[j])
                return false;
        return j==-1;*/
        return this.indexOf(suffix)==this.length()-suffix.length();//??没试
    }
    
    public boolean equalsIgnoreCase(MyString str)          //比较this串与str串是否相等，忽略字母大小写
    {
        if (this==str)
            return true;
        if (this.value.length==str.value.length)
        {
            for (int i=0; i<this.value.length; i++)
            {
                int c1=this.value[i];
                if (c1>='a' && c1<='z') 
                    c1 -= 'a'-'A';
                int c2=str.value[i];
                if (c2>='a' && c2<='z') 
                    c2 -= 'a'-'A';
                if (c1!=c2)                          
                return false;
            }
            return true;
        }
        return false;
    }    
    
    //【习题解答实验题3-1】
    public int compareToIgnoreCase(MyString str)           //比较两个串大小，忽略字母大小写
    {
        for (int i=0; i<this.value.length && i<str.value.length; i++)
        {
            int c1=this.value[i], c2=str.value[i];
            if (c1>='a' && c1<='z') 
                c1 -= 'a'-'A';
            if (c2>='a' && c2<='z') 
                c2 -= 'a'-'A';
            if (c1!=c2)
                return this.value[i]-str.value[i];
        }
        return this.value.length-str.value.length;
    }
}

    //？？
    /*    public String(StringBuffer buffer) {
            synchronized(buffer) {
                this.value = Arrays.copyOf(buffer.getValue(), buffer.length());
            }
      */  

/*
习题3 未完成
public MyString replace(char old, char newc)      	//将串中所有old字符替换为newc字符
public int lastIndexOf(char ch)                   	//返回ch在this串中最后出现的序号
public int lastIndexOf(char ch, int begin)           	//返回ch从begin开始最后出现的序号
public int lastIndexOf(String pattern)             	//返回pattern最后匹配位置的序号
public int lastIndexOf(String pattern, int begin)
              //返回模式串pattern在this串中从begin开始向后查找最后一次匹配位置的序号
 * */


//@author：Yeheya。2015-2-5
