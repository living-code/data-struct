//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月25日
//3.2.2   常量字符串类
//3.3   串的模式匹配

public class MyString_ex
{
    public static void main(String args[])
    {
        //3.2.2   常量字符串类
        //（1） 构造字符串
   	    MyString s1 = new MyString();                      //构造空串""
        MyString s2 = new MyString("xyz");                 //以java.lang.String字符串常量构造串对象
        System.out.println("s1=\""+s1.toString()+"\"");
        System.out.println("s2=\""+s2.toString()+"\"");

//        MyString s3 = "xyz";                             //语法错，不能将String转换成MyString，没有自动封装功能
//        MyString[] str = {"abc","xyz"};                  //语法错，不能将String转换成MyString，没有自动封装功能
        
        char[] letters={'a','b','c','d','e','f','g','h'};  //字符数组，只能在声明时赋值，不能赋值为"abcd"
        MyString s3 = new MyString(letters,0,8);           //以字符数组构造串对象
        System.out.println("s3=\""+s3.toString()+"\"");

        letters[0]='y';                                    //数组元素改了，对串没影响
        MyString s4 = new MyString(s3);                    //拷贝构造方法
        System.out.println("s4=\""+s4.toString()+"\"");

        MyString s5=s2;                               //对象引用赋值       
        System.out.println("\""+s5.toString()+"\"==\""+s2.toString()+"\"? "+(s5==s2));
        System.out.println("\""+s3.toString()+"\"==\""+s4.toString()+"\"? "+(s3==s4));
        System.out.println("\""+s3.toString()+"\".equals(\""+s4.toString()+"\")? "+s3.equals(s4));
        System.out.println("\""+s3.toString()+"\".compareTo(\""+s4.toString()+"\")? "+s3.compareTo(s4));
        System.out.println("\""+s2.toString()+"\".equals(\""+s3.toString()+"\")? "+s2.equals(s3));
        System.out.println("\""+s2.toString()+"\".compareTo(\""+s3.toString()+"\")? "+s2.compareTo(s3));

        //（2） 求子串
        MyString s=new MyString("abcdefgh");
        System.out.println(s.substring(2,5).toString());                //cde

        //（3） 连接串
        MyString s6=new MyString("abcd"), s7=new MyString("xyz");
        System.out.println("s6.concat(s7)=\""+s6.concat(s7).toString()+"\""); //s1.concat(s2)="abcdxyz"
    }
}
/*
程序运行结果如下：
s1=""
s2="xyz"
s3="abcd"
s4="abcd"
"xyz"=="xyz"? true
"abcd"=="abcd"? false
"abcd".equals("abcd")? true
"abcd".compareTo("abcd")? 0
"xyz".equals("abcd")? false
"xyz".compareTo("abcd")? 23
"abcdxyz".startsWith("xyz")? true
"abcdxyz".endsWith("xyz")? true
"xyz".equalsIgnoreCase("XYZ")? true
"abcd".compareToIgnoreCase("ABCDEF")? -2

*/