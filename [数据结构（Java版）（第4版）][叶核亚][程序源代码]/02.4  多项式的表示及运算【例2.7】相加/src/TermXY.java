//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年9月15日
//§2.4   线性表的应用：多项式的表示及运算
//§2.4.2   二元多项式的表示及运算

public class TermXY extends TermX                          //二元多项式的一项
{
    protected int yexp;                                    //y指数

    public TermXY(int coef, int xexp, int yexp)            //构造一项
    {
        super(coef, xexp);                                 //构造父类一项，调用父类同参数构造方法
        this.yexp = yexp;
    }

    //返回二元多项式的一项对应的“系数x^指数”的省略形式字符串，省略形式要求同TermX类。覆盖父类同名方法
    public String toString()                     
    {
        String str=super.toString();                       //执行父类TermX同名方法，输出系数和x指数
        if (this.yexp>0)
            str+="y";
        if (this.yexp>1)
            str+="^"+this.yexp;
        return str;
    }   

    //按x、y指数比较大小，先比较x指数，若x指数相同，再比较y指数。重载父类同名方法
    public int compareTo(TermXY term)
    {
        if (this.xexp==term.xexp && this.yexp==term.yexp)  //两个指数对应相等
            return 0;
        return (this.xexp<term.xexp || this.xexp==term.xexp && this.yexp<term.yexp)? -1 : 1;
    }
    
    public boolean equals(Object obj)                      //按系数、x指数、y指数比较相等，覆盖父类同名方法
    {
        return this==obj || obj instanceof TermXY && super.equals(obj) && this.xexp==((TermXY)obj).yexp; 
    }    

    //习题2
    //以“系数x^指数”的省略形式构造一元多项式的一项。
    public TermXY(String termstr)
    {
        super(termstr);
        if (termstr.charAt(0)=='+')
        	termstr=termstr.substring(1);
    	int i = termstr.indexOf('y');
        if (i==-1)
        {
            this.coef = Integer.parseInt(termstr);
            this.xexp = 0;
        }
        else if (i==0)
             {
                 this.coef = 1;
                 this.xexp = 1;
             }
             else
             {
                 String sub=termstr.substring(0,i);
                 if (sub.equals("-"))
                	 this.coef=-1;
                 else
            	     this.coef = Integer.parseInt(sub);
                 i = termstr.indexOf('^');
                 if (i==-1)
            	     this.xexp=1;
                 else
                     this.xexp = Integer.parseInt(termstr.substring(i+1));
             }
    }

    public TermXY(int coef, int exp)                       //构造一项，指定默认值
    {
        this(coef, exp, 0);
    }
    public TermXY(TermXY term)                             //拷贝构造方法
    {
        this(term.coef, term.xexp, term.yexp);
    }
    public TermXY(TermX term, int yexp)                   //构造一项
    {
        this(term.coef, term.xexp, yexp);
    }
    public TermXY(TermX term)                              //构造一项
    {
        this(term.coef, term.xexp, 0);
    }
}
 /*   
    public double value(int x, int y)                       //求一项的值
    {
        return super.value(x)*Math.pow(y, this.yexp);       //Term::value(x)执行基类被覆盖的同名函数
    }
}*/