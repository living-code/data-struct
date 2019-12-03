//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月3日
//3.2.2  常量字符串类
//【例3.2】 整数类。

public class MyInteger例3_2 
{
    public static void main(String args[])
    {
        String[] str16={"-7fff", "-80", "-1", "+7f", "3e8"};//整数十六进制原码
        System.out.println("十进制，十六进制补码");   
        for (int i=0; i<str16.length; i++)
        {
            int value = MyInteger.parseInt(str16[i],16);
            System.out.println(value+"，0x"+MyInteger.toHexString(value));   
        }
    }
}
/*
程序运行结果如下：
十进制，十六进制补码
-32767，0xffff8001
-128，0xffffff80
-1，0xffffffff
127，0x0000007f
1000，0x000003e8
 */

  //@author：Yeheya。2014-10-4
