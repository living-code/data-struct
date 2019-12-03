//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月22日，JDK 8.11
//§1.2.3   算法设计
//【例1.4】  线性存储的随机数集合。

public class Random 
{
    public static void main(String[] args) 
    {
//      Integer[] value = {new Integer(32),new Integer(15),new Integer(78),new Integer(99)}; 
//        Integer[] value = {32,15,78,99,87,34,14,19,76,46,1}; //Java自动将int包装成Integer实例
//        Object[] value1 = Array1.random(10); //语法正确

        int n=10, size=100;
        Integer[] values = Array1.randomInteger(n, size);      //通过类名调用类的静态方法
        System.out.print(n+"个元素0～"+size+"之间的随机数集合: ");
        Array1.print(values);
    }
}
/*
程序运行结果如下：
10个元素0～100之间的随机数集合:  24 93 71 65 93 83 90 67 71 23
*/
//@author：Yeheya。2014-9-7
