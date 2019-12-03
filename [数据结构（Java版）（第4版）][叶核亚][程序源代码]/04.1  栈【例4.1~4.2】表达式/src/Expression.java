//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月3日
//4.1 栈
//【例4.2】 使用栈计算表达式的值。
//StringBuffer

public class Expression 
{
    public static StringBuffer toPostfix(String infix)     //返回将infix中缀表达式转换成的后缀表达式
    {
        Stack<String> stack = new SeqStack<String>(infix.length());  //运算符栈，顺序栈
        StringBuffer postfix = new StringBuffer(infix.length()*2);   //后缀表达式字符串
        int i=0;
        while (i<infix.length())
        {
            char ch=infix.charAt(i); 
            switch (ch)
            {
                case '+': case '-':                        //遇到＋、－运算符
                    while (!stack.isEmpty() && !stack.peek().equals("("))//与栈顶运算符比较
                        postfix.append(stack.pop());       //出栈运算符添加到后缀表达式串
                    stack.push(ch+"");                     //当前运算符入栈
                    i++;  break;
                    
                case '*': case '/':                        //遇到*、/ 运算符
                    while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/")))
                        postfix.append(stack.pop());       //栈顶优先级高的运算符出栈
                    stack.push(ch+"");
                    i++;  break;
                    
                case '(':                                  //遇到左括号，入栈
                    stack.push(ch+"");
                    i++;  break;
                    
                case ')':
                    String out = stack.pop();              //遇到右括号，出栈，若栈空返回null
                    while (out!=null && !out.equals("("))  //直到出栈运算符为左括号
                    {   postfix.append(out);
                        out = stack.pop();
                    }
                    i++;  break;
                    
                default:                                   //遇到数字，添加到后缀表达式
                    while (i<infix.length() && ch>='0' && ch<='9')
                    {   postfix.append(ch);
                        i++;
                        if (i<infix.length())
                            ch=infix.charAt(i);
                    }
                    postfix.append(" ");                   //添加空格作为数值之间的分隔符
            }
        }
        while (!stack.isEmpty())                           //所有运算符出栈
            postfix.append(stack.pop());                   //添加到postfix串之后
        return postfix;
    }
    
    public static int toValue(StringBuffer postfix)        //计算后缀表达式的值
    {
//        LinkedStack<int> stack = new LinkedStack<int>();//语法错
        Stack<Integer> stack = new LinkedStack<Integer>(); //操作数栈，链式栈
        int value=0;
        for (int i=0; i<postfix.length(); i++)             //逐个检查后缀表达式中的字符
        {    
            char ch=postfix.charAt(i);
            if (ch>='0' && ch<='9')                        //遇到数字字符
            {
                value=0;
                while (ch!=' ')                            //将整数字符串转换为整数值
                {
                    value = value*10 + ch-'0';
                    ch = postfix.charAt(++i);
                }
                stack.push(value);                         //new Integer(value)整数对象入栈，Java自动将int整数封装成Integer对象
            }
            else
                if (ch!=' ')
                {
                    int y=stack.pop(), x=stack.pop();      //出栈两个操作数，注意出栈次序。Java自动调用intValue()方法将Integer对象转换成int整数
                    switch (ch)                            //根据运算符分别计算
                    {
                        case '+': value=x+y;  break;
                        case '-': value=x-y;  break;
                        case '*': value=x*y;  break;
                        case '/': value=x/y;  break;       //整除。若除数为0，抛出算术异常
                    }
                    System.out.print(x+(ch+"")+y+"="+value+"，");//显示运算过程
                    stack.push(value);                     //运算结果入栈
                }
        }
        return stack.pop();                                //返回运算结果
    }
    
    public static void main(String args[])
    {
        String[] infix={"123",
                        "123+10*(45-50+20)/((35-25)*2+10)-11",//例4.2 中缀表达式，没有正负号
               //不行         "+123+10*(+53-49+20)/((-25+35)*2+10)+(-11)",//例4.6 递归算法求表达式，正负号
                        "45+(10-15)*((25+35)/(60-40))-11"};  //图6.21 表达式二叉树，
        for (int i=0; i<infix.length; i++)
        {
            StringBuffer postfix = toPostfix(infix[i]);    //转换成后缀表达式
//            System.out.println("infix="+infix[i]+"\npostfix="+postfix);
            System.out.println("infix="+infix[i]+"，length()="+infix[i].length());
            System.out.println("postfix="+postfix+"，length()="+postfix.length());
            System.out.println("value="+toValue(postfix)+"\n");
        }
    }
}
/*
程序运行结果如下：
infix=123，length()=3
postfix=123 ，length()=4
value=123
                                       //例4.2中缀表达式，没有正负号
infix=123+10*(45-50+20)/((35-25)*2+10)-11，length()=35
postfix=123 10 45 50 -20 +*35 25 -2 *10 +/+11 -，length()=39
45-50=-5，-5+20=15，10*15=150，35-25=10，10*2=20，20+10=30，150/30=5，123+5=128，128-11=117，value=117

                                       //图6.21 表达式二叉树，
infix=45+(10-15)*((25+35)/(60-40))-11，length()=31
postfix=45 10 15 -25 35 +60 40 -/*+11 -，length()=31
10-15=-5，25+35=60，60-40=20，60/20=3，-5*3=-15，45+-15=30，30-11=19，value=19


infix= 121+10*(53-49+20)/((35-25)*2+10)+11/0
postfix= 121 10 53 49 -20 +*35 25 -2 *10 +/+11 0 /+
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Expression.value(Expression.java:79)
	at Expression.main(Expression.java:93)

*/
//@author：Yeheya。2014-10-7