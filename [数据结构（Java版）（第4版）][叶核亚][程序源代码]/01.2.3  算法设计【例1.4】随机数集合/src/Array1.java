//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月22日，JDK 8.11
//§1.2.3   算法设计
//【例1.4】  线性存储的随机数集合。
//§8.2 二分法查找                 用随机数，不包括查找算法
//§9.1~9.4 排序                 用随机数，不包括排序算法

public class Array1 
{
    //【例1.4】  线性存储的随机数集合。
    public static void print(Object[] value)     //输出对象数组元素，静态方法。时间复杂度为O(n)
    {
/*        for (int i=0; i<value.length; i++)       //遍历数组，访问每个元素仅一次
            if (value[i]==null)
                System.out.print("null ");
            else
                System.out.print(" "+value[i].toString());//输出对象，默认执行其toString()方法
*/
        
        for (Object obj : value)                 //逐元循环，obj逐个引用value数组元素，次序同数组
            System.out.print(obj==null ? "null " : " "+obj.toString());
        System.out.println();
    }
    
    //产生n个随机数（可重复），范围是0～size-1，返回整数对象数组
    public static Integer[] randomInteger(int n, int size)
    {
        Integer[] values = new Integer[n];       //java.lang.Integer是int类型的包装类
        for (int i=0; i<values.length; i++)       //遍历数组，访问每个元素仅一次
//            values[i] = new Integer((int)(Math.random()*100));
            values[i] = (int)(Math.random()*size);   //Java自动将int整数封装成Integer对象，赋值相容
                        //java.lang.Math.random()方法产生一个0～1之间double类型的随机数
        return values;                                     //返回数组引用
    } 
    
    //8.2 二分法查找； 9.1~9.4 排序
    public static void print(int[] value)                  //输出数组元素
    {
        for (int i=0; i<value.length; i++)
            System.out.print("  "+value[i]);
        System.out.println();
    }
    
    //9.1~9.4 排序
    public static int[] randomInt(int n, int size)            //产生n个随机数，返回整型数组
    {
        int value[] = new int[n];
        for (int i=0; i<value.length; i++)
            value[i] = (int)(Math.random()*size);           //产生一个0～size-1之间的随机数
        return value;                                      //返回一个数组
    }
    //没有用到
    public static String toString(int[] value)             //返回数组元素，方法体省略
    {
        String str="";
        for (int i=0; i<value.length; i++)
            str += " "+value[i];
        return str;
    }
}
//@author：Yeheya。2014-10-26

