//《数据结构（Java版）（第4版）习题解答》，作者：叶核亚，2014年9月30日，JDK 8.25
//3.2.3   变量字符串类
//【实验3-11】 对StringBuffer串操作，StringBuffer类没有声明方法，增加功能。

public class StringBuffer_trim 
{    
    // 以下方法有什么错误？运行结果是怎样的？为什么？如何改正？
    public static StringBuffer trim_error1(StringBuffer s) //将s中所有空格删除，返回操作后的s串
    {
        int n=s.length();
        for (int i=0; i<n; i++)
            if (s.charAt(i)==' ')
                s.delete(i, i+1); 
        return s;
    }
    //【答】运行错，抛出StringIndexOutOfBoundsException异常。
    //【答】错误原因，每删除一个空格，i不加；且n--
    
    public static StringBuffer trim_error2(StringBuffer s)
    {
        int i=0, n=s.length();
        while (i<n)
            if (s.charAt(i)==' ')
                s.delete(i, i+1);
            else  i++;
        return s;
    }
    //【答】运行错，抛出StringIndexOutOfBoundsException异常。错误原因，每删除一个空格，n减1。

    //将s中所有空格删除，返回操作后的s串
    public synchronized static StringBuffer trim1(StringBuffer s)
    {
        int i=0;
        while (i<s.length())
            if (s.charAt(i)==' ')
            	s.deleteCharAt(i);
//                s.delete(i, i+1);
            else  i++;
        return s;
    }
    //【答】正确。算法效率低
    
    //习题解答
    //将s中所有空格删除，返回操作后的s串。非空格字符向前移动一次，O(n)
    public static StringBuffer trim2(StringBuffer s)
    {
        int i=0, j=0;
        while (i<s.length() && s.charAt(i)!=' ')           //i记住第1个空格下标
            i++;
        for (j=i; j<s.length(); j++)
            if (s.charAt(j)!=' ')
                s.setCharAt(i++, s.charAt(j));             //非空格字符向前移动到空格字符位置
//        s.setLength(i);                                    //设置串长度为i
        return s;
    }
       
    public static void main(String args[])
    {
//        StringBuffer sbuf1 = new StringBuffer("  a  b  c  d  ");  //以字符串常量构造串对象，容量为4+16，没有增加'\0'

        //        StringBuffer sbuf2 = new StringBuffer(sbuf1);      //拷贝构造方法
//        System.out.println("trim1(\""+sbuf1+"\")="+trim1(sbuf1));
//        System.out.println("trim2(\""+sbuf1+"\")="+trim2(sbuf1));

        StringBuffer str = new StringBuffer("   a bc d  e  f xyz");
        System.out.println("trim2(\""+str+"\")="+trim2(str));
    }
}
/*程序运行结果如下：
trim1("  a  b  c  d  ")= a b c d 
trim("  a  b  c  d  ")=abcd

trim2("   a bc d  e  f xyz")=abcdefxyz  e  f xyz           //没有设置串长度时，错误，习题解答。
trim2("   a bc d  e  f xyz")=abcdefxyz                      //正确


*/

//@author：Yeheya。2015-2-5    

