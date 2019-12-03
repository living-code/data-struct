//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月3日，JDK 8.05
//4.1 栈
//【例4.1】  括号匹配的语法检查。

public class Bracket
{
    //检查infix表达式中的圆括号是否匹配，若匹配，返回空串；否则返回错误信息
    public static String isMatched(String infix)
    {
        SeqStack<String> stack = new SeqStack<String>(infix.length());
                   //声明接口对象stack，引用实现Stack<T>接口的顺序栈类的实例，创建空栈
//      Stack<String> stack = new LinkedStack<String>();
        
        for (int i=0; i<infix.length(); i++)
        {    
            char ch=infix.charAt(i);
            switch(ch)
            {
                case '(': stack.push(ch+"");               //左括号入栈
                          System.out.println(stack.toString());                          
                          break;
                          
                case ')': if (stack.isEmpty() || !stack.pop().equals("("))  //遇见右括号时，出栈
                              return "期望(";                //检查出栈字符是否为左括号
            }    
        }
        return (stack.isEmpty()) ? "" : "期望)";             //返回空串表示没有错误
    }    

    public static void main(String args[])
    {
        String infix="((1+2)*3+4))("; 
        System.out.println(infix+"  ，编译错误："+Bracket.isMatched(infix));
    }
}

/*
程序多次运行时，若infix分别表示不同的表达式字符串，运行结果如下：
((1+2)*3+4) 
((1+2)*3+4  ：期望)
((1+2)*3+4))(  ，编译错误：期望(

*/

//@author：Yeheya。2014-7-3
