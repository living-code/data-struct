//《数据结构（Java版）（第4版）习题解答与实验指导》，作者：叶核亚，2015年2月5日
//3.2.2   常量字符串类
//【实验3-9，习题解答】 浮点数类。

public class MyDouble_ex 
{
    public static void main(String args[])
    {
        String str[]={"12345", "-123","-0.1234567", "-12345E2", "-12345.67E-2","-12345E0"};
        for (int i=0; i<str.length; i++)
        {
            System.out.println("parseDouble(\""+str[i]+"\")="+MyDouble.parseDouble(str[i]));
            System.out.println("toDouble(\""+str[i]+"\")="+MyDouble.toDouble(str[i]));
        }
    } 
}
/*
程序运行结果如下：
parseDouble("12345")=12345.0
toDouble("12345")=12345.0
parseDouble("-0.1234567")=-0.12345670000000002
toDouble("-0.1234567")=-0.12345670000000002
parseDouble("-12345E2")=-1234500.0
toDouble("-12345E2")=-1234500.0
parseDouble("-12345.67E-2")=-123.45670000000001
toDouble("-12345.67E-2")=-123.45670000000001
parseDouble("-12345E0")=-12345.0
toDouble("-12345E0")=-12345.0
*/
