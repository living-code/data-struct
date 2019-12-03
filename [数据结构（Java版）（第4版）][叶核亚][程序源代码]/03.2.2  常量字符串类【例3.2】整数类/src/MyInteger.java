//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月3日
//3.2.2  常量字符串类
//【例3.2】 整数类。
//（1）声明MyInteger类
//【思考题3-2】

public class MyInteger implements Comparable<MyInteger>
{
    public static final int MIN_VALUE = 0x80000000;        //最小值常量，-2147483648
    public static final int MAX_VALUE = 0x7fffffff;        //最大值常量，2147483647
    private final int value;                               //私有最终变量，存储整数，赋值一次

    public MyInteger(int value)                            //由int整数value构造整数对象
    {
        this.value = value;
    }    
    //由十进制整数字符串s构造整数对象。构造方法只支持十进制，s包含正负号。
    public MyInteger(String s) throws NumberFormatException
    {
        this.value = this.parseInt(s, 10);
    }

    public int intValue()                                  //返回整数值
    {
        return this.value;
    }

    public String toString()                               //返回当前整数的十进制字符串。覆盖Object类方法
    {
        return this.value+"";                              //“+”自动将整数转换为十进制整数字符串
    }
    
    public boolean equals(Object obj)                      //比较对象是否相等。覆盖Object类方法
    {
        return obj instanceof Integer && this.value==((Integer)obj).intValue();
    }
    
    public int compareTo(MyInteger iobj)                   //比较两个对象值大小，返回-1、0或1
    {
        return this.value<iobj.value? -1 : (this.value==iobj.value ? 0 : 1);
    }
    
    
    //（2） 将整数字符串转换为整数
    public static int parseInt(String s) throws NumberFormatException    //将串s按十进制转换为整数
    {
        return MyInteger.parseInt(s,10);
    }
    
    //将串s按radix进制转换为整数，s指定整数的radix进制原码字符串，包含正负号，
    //2≤radix≤16，默认十进制。若不能将s转换成整数，则抛出数值格式异常
    public static int parseInt(String s, int radix) throws NumberFormatException
    {
        if (s==null) 
            throw new NumberFormatException("null");
        if (radix<2 || radix>16)
            throw new NumberFormatException("radix="+radix+"，进制超出2～16范围。");
        int value=0, i=0;
        int sign = s.charAt(0)=='-' ? -1 : 1;              //符号位，记住正负数标记 
        if (s.charAt(0)=='+' || s.charAt(0)=='-')          //跳过符号位
            if (s.length()==1)                             //只有"+"、"-"
                throw new NumberFormatException("\""+s+"\"");
            else i++;                                      //i记住当前字符序号
        while (i<s.length())                               //获得无符号的整数绝对值
        {
            char ch=s.charAt(i++);
            if (ch>='0' && ch-'0'<radix)                   //当2≤radix≤10时，radix进制要识别0～radix-1数字
                value = value*radix+ch-'0';                //value记住当前获得的整数值
            else             //当11≤radix≤16时，radix进制还要识别从'a'/'A'开始的radix-10个字母表示的整数值
                if (radix>10 && radix<=16 && ch>='a' && ch-'a'<radix-10)
                    value = value*radix+ch-'a'+10;
                else
                    if (radix>10 && radix<=16 && ch>='A' && ch-'A'<radix-10)
                        value = value*radix+ch-'A'+10;
                    else throw new NumberFormatException(radix+"进制整数不能识别"+ch);
        }
        return value*sign;                                 //返回有符号的整数值
    }

    //（3）将整数转换为radix进制字符串
    //以下补码
    public static String toHexString(int value)            //返回整数value的十六进制补码字符串。采用位运算
    {
        char[] buffer = new char[8];                       //一个int有8个十六进制位
        for (int i=buffer.length-1; i>=0; i--)             //循环执行8次，高位补0
        {
            int bit = value & 15;                          //获得十六进制的个位
            buffer[i]=(char)(bit<=9 ? bit+'0' : bit+'a'-10);   //将0～9、10～15转换为'0'～'9'、'a'～'f'
            value>>>=4;                                    //右移4位，高位填充0，即value除以16
        }
        return new String(buffer);                         //返回由字符数组构造的字符串
    }
    //以下【思考题3-2】 MyInteger类声明以下静态成员方法。
    public static String toBinaryString(int value)         //返回整数value的二进制补码字符串。采用位运算
    {
        char[] buffer = new char[32];                      //一个int有32个二进制位
        for (int i=buffer.length-1; i>=0; i--)             //循环执行32次，高位补0
        {
            buffer[i]=(char)((value & 1)+'0');             //获得个位字符存入数组。&运算符优先级低于+
            value>>>=1;                                    //value右移一位，高位以0填充，即value除以2
        }
        return new String(buffer);                         //返回由字符数组构造的字符串
    }
    public static String toOctalString(int value)          //返回整数value的八进制补码字符串。采用位运算
    {
        char[] buffer = new char[32/3+1];                  //一个int有11个八进制位
        for (int i=buffer.length-1; i>=0; i--)             //循环执行11次，高位补0
        {
            buffer[i] = (char)((value & 7)+'0');           //获得个位字符存入数组。&运算符优先级低于+
            value>>>=3;                                    //右移3位，高位以0填充，即value除以8
        }
        return new String(buffer);                         //返回由字符数组构造的字符串
    }

    //习题解答
    //返回整数value的radix进制原码字符串，有符号，高位补0；radix取值为2、4、8、10、16。采用移位运算（除radix取余法）
    public static String toString(int value, int radix)
    {
        if (radix==10) 
            return value+"";
        if (radix==2 || radix==4 || radix==8 || radix==16)
        {
            int mask, n=0;                                 //mask获得radix进制的最大数字
            for (mask=radix-1; mask>0; mask>>>=1) 
                n++;                                       //n获得mask的二进制位数，即2的n次方是radix
            mask=radix-1;

            char[] buffer = new char[(int)(32.0/n+0.5+1)]; //存储一个int表示为radix进制的各位及符号
            buffer[0]= '+';                                //符号位
            if (value<0)
            {
                buffer[0]='-';                             //负数
                if (value != MyInteger.MIN_VALUE)
                    value=-value;                          //不包含MyInteger.MIN_VALUE
            }

            //除radix取余法，余数存入buffer字符数组（逆序）；视MyInteger.MIN_VALUE为无符号
            for (int i=buffer.length-1; i>0; i--)
            {
                int bit = value & mask;                    //获得radix进制的个位数字
                buffer[i]=(char)(bit<=9 ? bit+'0' : bit+'a'-10); //将0～9、10～15转换为'0'～'9'、'a'～'f'
                value>>>=n;                                //右移n位，高位补0，即value除以radix
            }
            return new String(buffer);                     //返回由字符数组构造的字符串
        }
        throw new IllegalArgumentException("radix参数值"+radix+"表示的进制无效。"); //无效参数异常
    }   
}
//@author：Yeheya。2015-2-28

