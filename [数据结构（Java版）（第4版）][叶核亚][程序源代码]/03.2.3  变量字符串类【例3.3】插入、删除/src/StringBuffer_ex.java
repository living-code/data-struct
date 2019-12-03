//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年9月30日
//3.2.3   变量字符串类
//【例3.3】  StringBuffer串的插入、删除操作。
//StringBuffer串的插入和删除操作，返回改变后的串，序号不容错

public class StringBuffer_ex 
{    
    public static void main(String args[])
    {
        //1.  构造变量字符串
//        StringBuffer sbuf1 = new StringBuffer();           //默认16
//        sbuf1 = new StringBuffer("abcd");                  //以字符串常量构造串对象，容量为4+16，没有增加'\0'
        StringBuffer sbuf = new StringBuffer(8);
        System.out.println("空串，\""+sbuf+"\"，length()="+sbuf.length()+"，capacity()="+sbuf.capacity());

        //2.  插入串    图3.9
        sbuf.insert(0, "abcdef");                          //插入串，没有用到返回值
        System.out.println("插入，\""+sbuf+"\"，length()="+sbuf.length()+"，capacity()="+sbuf.capacity());
        
        String[] str = {"xy", null};
        int i=2;                                           //序号i不容错，抛出异常
        for (int j=0; j<str.length; j++)
            System.out.println("插入，\""+sbuf+"\".insert("+i+",\""+str[j]+"\")=\""+
                sbuf.insert(i,str[j])+"\"，length()="+sbuf.length()+"，capacity()="+sbuf.capacity());
//      sb1.append(null);                  //编译错，参数的数据类型Object是String或不明确

        //3.  删除子串      图3.10   
        int[] begin={2,4,2}, end={6,10,2};
        for (int j=0; j<begin.length; j++)
            System.out.println("删除，\""+sbuf+"\".delete("+begin[j]+","+end[j]+")=\""+
                sbuf.delete(begin[j],end[j])+"\"，length()="+sbuf.length()+"，capacity()="+sbuf.capacity());

        //设置串长度
        sbuf.setLength(30);                      //加长字符串，补充'\0'，扩充容量
        System.out.println("加长，\""+sbuf+"\"，length()="+sbuf.length()+"，capacity()="+sbuf.capacity());
        sbuf.setLength(10);                      //缩短字符串
        System.out.println("缩短，\""+sbuf+"\"，length()="+sbuf.length()+"，capacity()="+sbuf.capacity());
    
    }
}
/*例3.3 程序运行结果如下：
空串，""，length()=0，capacity()=8
插入，"abcdef"，length()=6，capacity()=8
插入，"abcdef".insert(2,"xy")="abxycdef"，length()=8，capacity()=8
插入，"abxycdef".insert(2,"null")="abnullxycdef"，length()=12，capacity()=18    //扩充容量
删除，"abnullxycdef".delete(2,6)="abxycdef"，length()=8，capacity()=18
删除，"abxycdef".delete(4,10)="abxy"，length()=4，capacity()=18           //删除到串尾
删除，"abxy".delete(2,2)="abxy"，length()=4，capacity()=18                //begin==end，没有删除 
*/

//@author：Yeheya。2014-10-28    

