//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月25日
//3.2.2   常量字符串类
//java.lang.String类测试

public class String_ex 
{
    public static void main(String args[])
    {
    	//空串测试
/*    	String empty=null;                                 //空对象
        System.out.println("null="+empty);
    	empty = new String();                              //空串
        System.out.println("new String()="+empty+"，length()="+empty.length());
    	empty = "";                                        //空串
        System.out.println("\"\"="+empty+"，length()="+empty.length());
    	empty = new String("");                            //空串
        System.out.println("new String(\"\")="+empty+"，length()="+empty.length());
*/        
        //（1） 构造常量字符串
        //构造方法、取字符、求子串等，序号容错测试，串尾无'\0'
//        String s1=new String(null,0,1);//The constructor String(String) is ambiguous不明确的
        char[] value={'a','b','c','d','e','\0','f','g','h','i','j','k'};
        int begin=0, n=value.length-begin;        
        String s1=new String(value, begin, n);             //begin序号、n长度都不容错，抛出异常
        System.out.println("构造，\""+s1+"\".length()="+s1.length());        
        
        //求子串
        String s2=s1.substring(1,s1.length());            //begin、end序号不容错，抛出异常
        System.out.println("子串，\""+s2+"\".length()="+s2.length());
        
/*
        //indexOf(ch,i)，对i容错，
        char ch='k';
        i=-i;
        System.out.println("\""+s1+"\".indexOf('"+ch+"',"+i+")="+s1.indexOf(ch,i));
                                                                //对i容错，若i<0，从0开始查找
        */
        
        //test
//        System.out.println("new String()==\"\"? "+(new String()==""));
//        System.out.println("new String()==null? "+(new String()==null));
//        System.out.println("new String().length()= "+new String().length());
//      System.out.println("new String().isEmpty()? "+(new String().isEmpty()));
//      System.out.println("\"\".length()= "+"".length());
//      System.out.println("\"\".isEmpty()? "+("".isEmpty()));
        
    }
}
/*
//空串测试
null=null
new String()=，length()=0
""=，length()=0
new String("")=，length()=0

//构造方法测试
构造，"abcde fghijk".length()=12
子串，"bcde fghi".length()=8

//test
new String()==""? false
new String()==null? false
new String().length()= 0
new String().isEmpty()? true
"".length()= 0
"".isEmpty()? true
*/
