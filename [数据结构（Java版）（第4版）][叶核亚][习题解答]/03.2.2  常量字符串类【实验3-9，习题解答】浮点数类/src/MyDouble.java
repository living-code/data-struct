//《数据结构（Java版）（第4版）习题解答与实验指导》，作者：叶核亚，2015年2月5日
//3.2.2   常量字符串类
//【实验3-9，习题解答】 浮点数类。

public final class MyDouble implements Comparable<MyDouble>//浮点数类，最终类
{
    private final double value;                            //最终变量，存储浮点数

    public MyDouble(double value)                          //由double值构造浮点数对象
    {
        this.value = value;
    }    
    
    public MyDouble(String s) throws NumberFormatException //由字符串s构造浮点数对象，s包含正负号
    {
        this.value = this.parseDouble(s);
    }

    public double doubleValue()                            //返回浮点数值
    {
        return this.value;
    }

    public String toString()                               //返回浮点数值的字符串。覆盖Object类方法
    {
        return this.value+"";                              //“+”自动将浮点数转换为字符串
    }
    
    public int compareTo(MyDouble dobj)                    //比较两个对象值大小，返回-1、0或1
    {
        return this.value<dobj.value? -1 : (this.value==dobj.value ? 0 : 1);
    }
    
    //返回实数字符串s表示的浮点数，语法图见教材图3.21（a），由数字序列和运算符构造实数
    public static double parseDouble(String s) throws NumberFormatException 
    {
        int i=0, sign=s.charAt(0)=='-' ? -1 : 1;           //sign记住符号位
        if (s.charAt(0)=='+' || s.charAt(0)=='-')          //跳过符号位
            i++;
        double value=0, power=0.1;//10.0E0;                //power表示底数为10的幂//能够将整数赋给浮点数
        while (i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')//获得整数部分值
            value = value*10+s.charAt(i++)-'0';
        if (i<s.length() && s.charAt(i)=='.')              //若是小数点
        {   i++;
            while (i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')//获得小数部分值
            {   value += (s.charAt(i)-'0')*power;
                i++;
                power*=0.1;
            }
        }
        value *=sign;
        
        if (i<s.length() && (s.charAt(i)=='E' || s.charAt(i)=='e'))  //处理阶码
        {   i++;
            power = (s.charAt(i)=='-') ? 0.1 :10;          //阶码的符号位决定指数的正负及其运算
            if (s.charAt(i)=='+' || s.charAt(i)=='-')
                i++;
            int exp=0;
            while (i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')
                exp = exp*10+s.charAt(i++)-'0';            //获得指数的绝对值
            for (int j=0; j<exp; j++)
                value*=power;
        }
        return value; 
    } 
    
    //返回实数字符串s表示的浮点数，语法图见教材图3.21（b），由整数、数字序列和运算符构造实数
    public static double toDouble(String s)
    {
        int dot=s.indexOf('.'), e=s.indexOf('E');          //寻找小数点和E
        if (e==-1)
            e=s.indexOf('e');
        if (dot==-1 && e==-1)
            return MyInteger.parseInt(s);                  //s中没有小数和阶码，返回整数

        int i=0, sign=s.charAt(0)=='-' ? -1 : 1;           //sign记住符号位
        if (s.charAt(0)=='+' || s.charAt(0)=='-')          //跳过符号位
            i++;
        
        double value=0, power=0.1;                         //power表示底为10的幂，赋值为整数
        if (dot!=-1)                                       //s中有小数部分
        {   value=MyInteger.parseInt(s.substring(i,dot));  //获得正整数部分值
            dot++;                                         //跳过小数点
            while (dot<s.length() && s.charAt(dot)>='0' && s.charAt(dot)<='9')  //获得小数部分值
            {
                value += (s.charAt(dot)-'0')*power;
                dot++;
                power*=0.1;
            }
        }
        value *=sign;
        
        if (e!=-1)                                         //处理阶码
        {   if (dot==-1)                                   //s中没有小数部分
                value=MyInteger.parseInt(s.substring(0,e));//获得整数部分值
            e++;
            power = (s.charAt(e)=='-') ? 0.1 :10;          //阶码的符号位决定指数的正负及运算
            if (s.charAt(e)=='+' || s.charAt(e)=='-')
                e++;
            int exp=MyInteger.parseInt(s.substring(e));    //获得指数部分的正整数值
            for (int j=0; j<exp; j++)
                value*=power;
        }
        return value;
    }
}
//@author：Yeheya。2015-2-5