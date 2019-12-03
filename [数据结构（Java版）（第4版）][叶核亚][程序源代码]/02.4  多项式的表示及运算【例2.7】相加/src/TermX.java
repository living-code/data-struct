//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年9月15日
//§2.4   线性表的应用：多项式的表示及运算
//§2.4.1   一元多项式的表示及运算
//2.  一元多项式的排序单链表实现

//项类，一元多项式的一项，实现可比较接口和可相加接口
public class TermX implements Comparable<TermX>, Addible<TermX> 
{
    protected int coef, xexp;                              //系数，x指数（可为正、0）
 
    public TermX(int coef, int xexp)                       //构造一项
    {
        this.coef = coef;
        this.xexp = xexp;
    }
    public TermX(TermX term)                               //拷贝构造方法
    {
        this(term.coef, term.xexp);
    }
    
    //以“系数x^指数”的省略形式构造一元多项式的一项。
    //省略形式说明：当系数为1或-1且指数>0时，省略1，-1只写负号“-”，如x^2、-x^3；
    //当指数为0时，省略x^0，只写系数；当指数为1时，省略^1，只写x。
    public TermX(String termstr)                           
    {
        if (termstr.charAt(0)=='+')                        //去掉+号
            termstr=termstr.substring(1);
        int i = termstr.indexOf('x');
        if (i==-1)                                         //没有x，即指数为0
        {
            this.coef = Integer.parseInt(termstr);         //获得系数
            this.xexp = 0;
        }
        else                                               //有x，x之前为系数，x^之后为指数
        {
            if (i==0)                                      //以x开头，即系数为1
                this.coef = 1;
            else
            {
                String sub=termstr.substring(0,i);         //x之前子串表示系数
                if (sub.equals("-"))                       //系数只有-号，即系数为-1
                    this.coef=-1;
                else
                    this.coef = Integer.parseInt(sub);     //获得系数
            }
            i = termstr.indexOf('^');
            if (i==-1)
                 this.xexp=1;                              //没有^，即指数为1
            else
                 this.xexp = Integer.parseInt(termstr.substring(i+1));//获得指数
        }
    }

    //返回一元多项式的一项对应的“系数x^指数”的省略形式字符串，省略形式说明同TermX(String)构造方法。
    public String toString()                     
    {
        String str=this.coef>0 ? "+" : "-";                //系数的符号位
        if (this.xexp==0 || this.xexp>0 && this.coef!=1 && this.coef!=-1)
            str+=Math.abs(this.coef);                      //系数绝对值，省略系数1
        if (this.xexp>0)
            str+="x";                                      //指数为0时，省略x^0，只写系数
        if (this.xexp>1)
            str+="^"+this.xexp;                            //指数为1时，省略^1，只写x
        return str;
    }

    public int compareTo(TermX term)                       //按x指数比较两项大小，实现Comparable<T>接口
    {
        if (this.xexp == term.xexp)                        //比较相等
            return 0;                                      //比较规则与equals(Object)不同
        return this.xexp<term.xexp ? -1 : 1;               //比较大小，仅比较指数
    }
    
    public void add(TermX term)                            //若指数相同，则系数相加；实现Addible<T>接口
    {
        if (this.compareTo(term)==0)
            this.coef += term.coef;
        else
            throw new IllegalArgumentException("两项的指数不同，不能相加。");
    }
    
    public boolean removable()                             //若系数为0，则删除元素；实现Addible<T>接口
    {
        return this.coef==0;                               //不存储系数为0的项
    }
    
    //比较两项是否相等，比较系数和指数，比较规则与compareTo(term)==0不同
    public boolean equals(Object obj)
    {
        if (this==obj)
            return true;
        if (!(obj instanceof TermX))
            return false;
        TermX term=(TermX)obj;        
        return this.coef==term.coef && this.xexp==term.xexp;
    }
}
//@author：Yeheya。2014-9-16
/*要不要??
    public double value(int x)                             //求一项的值
    {
        return this.coef*Math.pow(x, this.exp);
    }
    public TermX plus(TermX term)                          //加法，＋运算符作用
    {
        TermX tmp = new TermX(this);                       //执行拷贝构造方法
        tmp.add(term);
        return tmp;
    }

*/