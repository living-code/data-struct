//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月3日
//3.2.3   变量字符串类
//【例3.2】 整数类。
//同Integer_测试 

public class MyInteger_ex 
{
//    public static void print(MyInteger iobj)
    public static void print(int i)
    {
        //Integer.toString(i,radix)方法，返回i整数的radix进制原码字符串，正数省略+号，负数显示-号
        String str10=MyInteger.toString(i,10);            //同toString()方法
        String str2=MyInteger.toString(i,2);
        String str8=MyInteger.toString(i,8);
        String str16=MyInteger.toString(i,16);
        System.out.print("原码（十、二、八、十六进制）"+str10+"，"+str2+"，"+str8+"，"+str16+"；");
        
        //Integer.toBinaryString(i)等方法，返回整数i的补码二、八、十六进制形式，正数省略高位0
        str2=MyInteger.toBinaryString(i);
        str8=MyInteger.toOctalString(i);
        str16="0x"+MyInteger.toHexString(i);
        System.out.println("补码（二、八、十六进制）"+str2+"，"+str8+"，"+str16);   
    }    
    public static void main(String args[])
    {
        //（1）构造方法调用Integer.parseInt(s)方法，只有十进制，s包含正负号。
        //（2）toString()方法，正数省略+号
       String[] str10={"-2147483648", "-128", "-1", "0","+127", "-32768", "2147483647"}; //整数原码形式十进制
                        //,"+","-"                           //运行错，抛出异常
        for (int i=0; i<str10.length; i++)
//            print(MyInteger.parseInt(str10[i],10));
            print(new MyInteger(str10[i]).intValue());          //功能同上句
        System.out.println(); 
       
        //（3）MyInteger.parseInt(s,radix)方法，s为radix进制原码，包含正负号；2≤radix≤36。
        String[] str16={"-80", "-1", "+7f", "-7fff"};      //整数原码形式十六进制
                        //,"0x7f"                          //运行错，NumberFormatException: For input string: "0x7f"
        for (int i=0; i<str16.length; i++)
            System.out.println(MyInteger.parseInt(str16[i],16)); 
    }
}
/*     
程序运行结果如下：
原码（十、二、八、十六进制）-2147483648，-10000000000000000000000000000000，-20000000000，-80000000；补码（二、八、十六进制）10000000000000000000000000000000，20000000000，0x80000000
原码（十、二、八、十六进制）-128，-00000000000000000000000010000000，-00000000200，-00000080；补码（二、八、十六进制）11111111111111111111111110000000，37777777600，0xffffff80
原码（十、二、八、十六进制）-1，-00000000000000000000000000000001，-00000000001，-00000001；补码（二、八、十六进制）11111111111111111111111111111111，37777777777，0xffffffff
原码（十、二、八、十六进制）0，+00000000000000000000000000000000，+00000000000，+00000000；补码（二、八、十六进制）00000000000000000000000000000000，00000000000，0x00000000
原码（十、二、八、十六进制）127，+00000000000000000000000001111111，+00000000177，+0000007f；补码（二、八、十六进制）00000000000000000000000001111111，00000000177，0x0000007f
原码（十、二、八、十六进制）-32768，-00000000000000001000000000000000，-00000100000，-00008000；补码（二、八、十六进制）11111111111111111000000000000000，37777700000，0xffff8000
原码（十、二、八、十六进制）2147483647，+01111111111111111111111111111111，+17777777777，+7fffffff；补码（二、八、十六进制）01111111111111111111111111111111，17777777777，0x7fffffff

-128
-1
127
-32767
*/
//@author：Yeheya。2015-2-28  