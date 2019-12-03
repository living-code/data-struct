//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月27日
//3.2.2   常量字符串类
//【例3.1】  String串的插入、删除操作。

public class String_insert 
{
    public static void main(String args[])
    {
        //① 插入串      图3.5
        String s1="abcdef\0", s2="xyz";                    //没有增加'\0'
        int i=3;
        String s3=s1.substring(0,i)+s2+s1.substring(i);    //返回在s1串的i处插入s2后的串
        System.out.println("insert(\""+s1+"\","+i+",\""+s2+"\")=\""+s3+"\"");

        s2=null;                                           //插入"null"
        s3=s1.substring(0,i)+s2+s1.substring(i);           //返回在s1串的i处插入s2后的串
        System.out.println("insert(\""+s1+"\","+i+",\""+s2+"\")=\""+s3+"\"");
        
        //② 删除子串      图3.6
        int begin=3, end=6;
        String s4=s3.substring(0, begin) + s3.substring(end); //删除s串中从begin到end-1处的子串，返回删除后的串，s串不变
        System.out.println("remove(\""+s3+"\","+i+","+(i+3)+")=\""+s4+"\"");
    }
}
/*
程序运行结果如下：
insert("abcdef",3,"xyz")="abcxyzdef"
insert("abcdef",3,"null")="abcnulldef"
remove("abcnulldef",3,6)="abcldef"
*/
//@author：Yeheya。2014-9-30    
