//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月29日
//3.2.3   变量字符串类

//StringBuffer串的插入和删除操作，返回改变后的串，序号不容错
//同StringBuffer_ex

public class MyStringBuffer_ex
{
    public static void main(String args[])
    {
        //1.  构造变量字符串
        MyStringBuffer sbuf = new MyStringBuffer(8);           //默认16
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
        sbuf.setLength(30);                      //加长字符串，补充' '，扩充容量
        System.out.println("加长，\""+sbuf+"\"，length()="+sbuf.length()+"，capacity()="+sbuf.capacity());
        sbuf.setLength(10);                      //缩短字符串
        System.out.println("缩短，\""+sbuf+"\"，length()="+sbuf.length()+"，capacity()="+sbuf.capacity());
        
        
    }
}
//@author：Yeheya。2014-10-3    
