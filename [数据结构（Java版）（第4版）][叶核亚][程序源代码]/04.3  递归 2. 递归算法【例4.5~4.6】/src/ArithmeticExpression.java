//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月16日
//4.3 递归
//【例4.6】 用递归算法计算算术表达式的值。

public class ArithmeticExpression                          //算术表达式（整数、不包括位运算）
{
    private String infix;                                  //中缀算术表达式字符串
    private int index;                                     //当前字符序号

    public ArithmeticExpression(String infix)              //构造方法，infix指定中缀表达式字符串
    {
        this.infix = infix;
        this.index = 0;
    }
    
    //计算从index开始的一个（子）算术表达式，返回整数值，其中进行多〈项〉加减运算
    public int intValue() 
    {
        int value1 = term();                               //计算〈项〉获得操作数1
        while (this.index < this.infix.length())           //进行多〈项〉的加减运算
        {
            char op = this.infix.charAt(this.index);
            if (op=='+' || op=='-')                        //记住运算符
            {   this.index++;
                int value2 = term();                       //计算〈项〉获得操作数2
                switch (op)                                //两〈项〉进行加减运算
                {   case '+': value1 += value2; break;     //value1存储运算结果
                    case '-': value1 -= value2; break;
                }                
            }
            else break;                                    //遇到')'时，〈项〉结束
        }
        return value1;  
    }
    
    private int term()                 //计算从index开始的一〈项〉，其中进行多〈因子〉的乘除运算
    {
        int value1 = factor();                             //计算〈因子〉获得操作数1
        while (this.index < this.infix.length())           //进行多〈因子〉的乘除运算
        {
            char op = this.infix.charAt(this.index);
            if (op=='*' || op=='/' || op=='%')             //记住运算符
            {   this.index++;
                int value2 = factor();                     //计算〈因子〉获得操作数2
                switch (op)                                //两〈因子〉进行乘除运算
                {   case '*': value1 *= value2; break;     //value1存储运算结果
                    case '/': value1 /= value2; break;     //除数为0时，Java抛出算术异常ArithmeticException: / by zero
                    case '%': value1 %= value2; break;
                }                
            }
            else break;                                    //遇到')'、'+'、'-'时，〈因子〉结束
        }
        return value1;  
    }
    
    //计算从index开始的一个〈因子〉，其中包含以()为界的子表达式，间接递归调用    
    private int factor()
    {
        if (this.infix.charAt(this.index)=='(')
        {   this.index++;                                  //跳过'('
            int value = intValue();                        //计算()括号内的子表达式，间接递归调用
            this.index++;                                  //跳过')'
            return value;
        }
        return constant(); 
    }

    private int constant()                                 //返回从index开始的一个〈常数〉
    {
        if (this.index < this.infix.length())
        {
            char op=this.infix.charAt(this.index);
            int sign=1, value=0;
            if (op=='+' || op=='-')
            {    sign = op=='-' ? -1 : 1;                  //符号位，记住正负数标记 
                 this.index++;                             //跳过符号位
            }
            while (this.index < this.infix.length())
            {
                char ch = this.infix.charAt(this.index);
                if (ch>='0' && ch<='9')
                {   value = value*10+ch-'0';               //value记住当前获得的整数值
                    this.index++;
                }
                else break;
            }
            return value*sign;                             //返回有符号的整数值
        }
        throw new NumberFormatException("\""+this.infix.substring(this.index-1)+"\"不能转换成整数");
    }
    
    public static void main(String args[])
    {
        String[] infix={"+123+10*(+53-49+20)/((-25+35)*2+10)+(-11)+0"};    //能够识别+、-作为符号
//                         "123","+123","-123","(-123)",
//                         "1+-2","1-+2","-1+((-2))","1+2+3","1*2*3","-1*-2*-3"};
//                       null,                   //运行错，Java抛出空对象异常java.lang.NullPointerException
//                       "","+1+","++",          //Java抛出异常java.lang.StringIndexOutOfBoundsException
//                       "+","-"};               //本程序抛出异常java.lang.NumberFormatException: "+"不能转换成整数
        for (int i=0; i<infix.length; i++)
            System.out.println(infix[i]+"="+new ArithmeticExpression(infix[i]).intValue());
    }    
    
    //【思考题4-5】          
/*    private int constant()                                 //返回从index开始的一个〈常数〉
    {
       if (this.index < this.infix.length())
       {
            int j=this.index;            
            char ch = this.infix.charAt(j);
            if (ch=='+' || ch=='-')
                j++;
            while (j < this.infix.length())
            {
                ch = this.infix.charAt(j);
                if (ch>='0' && ch<='9')
                    j++;
                else break;
            }
            int value=MyInteger.parseInt(this.infix.substring(this.index,j));//字符串转换为整数值
            this.index=j;
            System.out.println("this.index="+this.index+"，value="+value);
            return value;
        }
        throw new NumberFormatException("\""+this.infix.substring(this.index-1)+"\"不能转换成整数");
    }*/
}
/*
程序运行结果如下：
+123+10*(+53-49+20)/((-25+35)*2+10)+(-11)+0=120
123=123
+123=123
-123=-123
(-123)=-123
1+-2=-1
1-+2=-1
-1+(-2)=-3
1+2+3=6
1*2*3=6
-1*-2*-3=-6

若infix=null，抛出空对象异常java.lang.NullPointerException；
若infix=""，抛出异常java.lang.StringIndexOutOfBoundsException

*/
//author：Yeheya。2014-9-23


