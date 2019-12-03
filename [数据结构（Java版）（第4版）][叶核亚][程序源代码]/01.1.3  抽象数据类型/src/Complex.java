//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年9月18日，JDK 8.11
//§1.1.3   数据类型与抽象数据类型
//【实验1-1】  复数类。

public class Complex
{
    private double real,imag;                              //实部，虚部
//    public double real,imag;
    public Complex(double real, double imag)               //构造方法
    {
        this.real = real;
        this.imag = imag;
    }
    public Complex(double real)                            //构造方法重载
    {
        this(real,0);
    }
    public Complex()
    {
        this(0,0);
    }
    public Complex(Complex c)                              //拷贝构造方法，复制对象
    {
        this(c.real,c.imag);                               //c==null时，抛出空对象异常，下同
    }
    
    //若public double real,imag;，以下4个方法可省略
    public double getReal()     
    {
        return this.real;
    }
    public void setReal(double real)
    {
        this.real = real;
    }
    public double getImag()
    {
        return this.imag;
    }
    public void setImag(double imag)
    {
        this.imag = imag;
    }
    
    public String toString()                               //对象的字符串描述，
    {                                                      //覆盖Object类的toString()方法
        return "("+this.real+"+"+this.imag+"i)";
    }
    
    public void add(Complex c)                             //两个对象相加，改变当前对象
    {
        this.real += c.real;
        this.imag += c.imag;
    }
    
    public static Complex add(Complex c1, Complex c2)      //返回两个对象相加后的对象，重载，静态方法
    {
        return new Complex(c1.real+c2.real, c1.imag+c2.imag);
    }
    
    public void subtract(Complex c)                        //两个对象相减，改变当前对象
    {
        this.real -= c.real;
        this.imag -= c.imag;
    }
    
    public static Complex subtract(Complex c1, Complex c2) //返回两个对象相减后的对象，重载，静态方法
    {
        return new Complex(c1.real-c2.real, c1.imag-c2.imag);
    }
    
    public boolean equals(Object obj)                      //比较两个对象是否相等
    {                                                      //覆盖Object类的equals(obj)方法
        if (this==obj)
            return true;
        if (obj instanceof Complex)
        {
            Complex c=(Complex)obj;
            return this.real==c.real && this.imag==c.imag;
        }
        return false;
    } 
}

class Complex__ex
{
    public static void main(String args[])
    {
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(3,5);
        Complex c3 = Complex.add(c1,c2);                   //返回新创建对象
        System.out.println(c1+" + "+c2+" = "+c3);

        c1.add(c2);
        System.out.println("c1="+c1);
        System.out.println("c1==c3? "+(c1==c3));
        System.out.println("c1.equals(c3)? "+c1.equals(c3));
    } 
}

/*
程序运行结果如下：
(1.0+2.0i) + (3.0+5.0i) = (4.0+7.0i)
c1=(4.0+7.0i)
c1==c3? false
c1.equals(c3)? true

*/
