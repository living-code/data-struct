//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月21日，JDK 8.11
//§2.2  线性表的顺序存储和实现
//§2.2.2  顺序表
//【例2.1】求解Josephus环问题。
//§2.3 线性表的链式存储和实现

//注意：泛型<T>的实际参数只能是类，不能是基本类型char、int等
//import dataStructure.*;                         //声明导入指定包中的类或接口
public class Josephus
{
    //【例2.1】求解Josephus环问题。
    //创建Josephus环并求解，参数指定环长度、起始位置、计数
    public Josephus(int number, int start, int distance) 
    {
        System.out.print("Josephus("+number+","+start+","+distance+")，");
        SeqList<String> list = new SeqList<String>(number);
                       //创建顺序表实例，元素类型是字符串，构造方法参数指定顺序表容量，省略时取默认值
        for (int i=0; i<number; i++)
            list.insert((char)('A'+i)+"");                 //顺序表尾插入，O(1)
        System.out.println(list.toString());               //输出顺序表的描述字符串，O(n)

        int i = start;                                     //计数起始位置
        while (list.size()>1)                              //多于一个元素时循环，计数O(1)
        {
            i = (i+distance-1) % list.size();              //按循环方式对顺序表进行遍历
            System.out.print("删除"+list.remove(i).toString()+"，");  //删除i位置对象，O(n)
            System.out.println(list.toString());
        }
        System.out.println("被赦免者是"+list.get(0).toString());//get(0)获得元素，O(1)
    }
    
    public static void main(String args[])
    {
        //图2.2
        String values[]={"A","B","C","D","E"};
        SeqList<String> lista = new SeqList<String>(values);
 
        //【例2.1】求解Josephus环问题。
        new Josephus(5,0,2);
    }
   
    //2.3 线性表的链式存储和实现    
    //创建Josephus环并求解，参数指定环长度、起始位置、计数
/*    public Josephus(int number, int start, int distance) 
    {
        System.out.print("Josephus("+number+","+start+","+distance+")，");
        SinglyList<String> list = new SinglyList<String>();//构造空单链表
        for (int i=number-1; i>=0; i--)
            list.insert(0, (char)('A'+i)+"");              //单链表头插入，O(1)
        System.out.println(list.toString());               //输出顺序表的描述字符串，O(n)

        //以下待提高效率
        int i = start;                                     //计数起始位置
        while (list.count()>1)                             //多于一个元素时循环，计数O(1)
        {
            i = (i+distance-1) % list.count();             //按循环方式对顺序表进行遍历
            System.out.print("删除"+list.remove(i).toString()+"，");  //删除i位置对象，O(n)
            System.out.println(list.toString());
        }
        System.out.println("被赦免者是"+list.get(0).toString());//get(0)获得元素，O(1)
    }*/
}
    
/*
程序运行结果如下：
Josephus(5,0,2)，(A, B, C, D, E) 
删除B，(A, C, D, E) 
删除D，(A, C, E) 
删除A，(C, E) 
删除E，(C) 
被赦免者是C

Josephus(5,0,2)，SeqList(A, B, C, D, E) 
删除B，SeqList(A, C, D, E) 
删除D，SeqList(A, C, E) 
删除A，SeqList(C, E) 
删除E，SeqList(C) 
被赦免者是C

Josephus(5,0,2)，SinglyList(A,B,C,D,E)
删除B，SinglyList(A,C,D,E)
删除D，SinglyList(A,C,E)
删除A，SinglyList(C,E)
删除E，SinglyList(C)
被赦免者是C

*/
//@author：Yeheya。2014-9-7