
public class Double_ex 
{
    public static void main(String args[])
    {
        String str[]={"12345", "-0.1234567", "-12345E2", "-12345.67E-2","-12345E0"};
        for (int i=0; i<str.length; i++)
        {
            System.out.println("java.lang.Double.parseDouble(\""+str[i]+"\")="+Double.parseDouble(str[i]));
        }
    } 
}
/*
程序运行结果如下：
java.lang.Double.parseDouble("12345")=12345.0
java.lang.Double.parseDouble("-0.1234567")=-0.1234567
java.lang.Double.parseDouble("-12345E2")=-1234500.0
java.lang.Double.parseDouble("-12345.67E-2")=-123.4567
java.lang.Double.parseDouble("-12345E0")=-12345.0

*/


