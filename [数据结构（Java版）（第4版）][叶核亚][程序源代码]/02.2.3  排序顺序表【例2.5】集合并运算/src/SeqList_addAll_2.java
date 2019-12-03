//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月15日
//§2.2.3  排序顺序表
//【例2.5】  使用线性表表示集合，实现集合运算。

//泛型及其继承性问题讨论，讨论以下两种声明的区别
//SeqList<T>类的以下方法声明，表示参数类型支持T及其子类。
//  public SeqList(SeqList<? extends T> list)      //深拷贝，元素类型支持T及其子类
//  public void addAll(SeqList<? extends T> list)  //集合并

public class SeqList_addAll_2 
{
    public static void main(String args[])
    {
        //（2） 泛型的继承性
        Object[] objs={"A", "B", 10, new Integer(20)};   //父类对象引用子类实例，类型的多态性
        SeqList<Object> listobj1 = new SeqList<Object>(objs);//T类型包含其子类实例      
        String str[]={"C","D","E"};        
        SeqList<String> lists = new SeqList<String>(str);        
        SeqList<Object> listobj2 = new SeqList<Object>(lists);
                      //SeqList<Object>构造参数是SeqList<String>，声明参数必须是SeqList<? extends T>
        listobj1.addAll(lists);                      //SeqList<Object>与SeqList<String>合并
        System.out.println("listobj1="+listobj1.toString()+"，listobj2="+listobj2.toString()+
                         "，lists="+lists.toString());
       
        //增加
        Integer[] values=Array1.randomInteger(3, 100);     //见例1.4
        SeqList<Integer> listi = new SeqList<Integer>(values);
        listobj1.addAll(listi);                      //SeqList<Object>与SeqList<Integer>合并
        System.out.println("listobj1="+listobj1.toString());       
        
        //理解“?”通配符
        SeqList<? extends Object> list1 = new SeqList<Object>(); //语法正确，list元素是Object的某个子类
        SeqList<?> list2 = listobj1;//new SeqList<Object>();          //语法正确，为上句简写
        System.out.println("list1="+list1.toString());     //list只能调用Object声明的方法，被子类覆盖，运行时多态
        System.out.println("list2="+list2.toString());
//      list1.insert("B");                                 //不能调用子类声明的方法

        //泛型及其继承性问题讨论，SeqList<? extends T>作为方法的返回值类型??
//只有声明      SeqList<T> subList(int begin, int end)
        int begin=2, end=5;
//        SeqList<Object> listsub1 = listobj1.subList(begin,end);   //语法正确
//        System.out.println("listobj1.subList("+begin+","+end+")="+listsub1.toString());

        
//如果声明      SeqList<T> subList(int begin, int end)
//或声明      SeqList<? extends T> subList(int begin, int end)         

        SeqList<?> listsub2 = listobj1.subList(begin,end);
                        //语法正确，元素类型为Object，因为SeqList类中数组元素类型为Object，运行结果同上
        System.out.println("listobj2.subList("+begin+","+end+")="+listsub2.toString());

//如果声明      SeqList<? extends T> subList(int begin, int end)         
//        SeqList<Object> listsub3=listobj1.subList(begin,end); //语法错，不能将？转换成类型
//        SeqList<String> listsub4=listobj2.subList(begin,end); //语法错
    }
}
/*
程序运行结果如下：  
listobj1=(A, B, 10, 20, C, D, E) ，listobj2=(C, D, E) ，lists=(C, D, E) 
listobj1=(A, B, 10, 20, C, D, E, 76, 70, 88) 


（1） SeqList<? extends T>不能作为返回值类型
SeqList<T>类声明以下方法，返回值类型为SeqList<T>，元素类型是T。

SeqList<T> subList(int begin, int end)              //返回从begin～end组成的子表 

以下方法声明的返回值类型为SeqList<? extends T>，希望返回SeqList的元素类型是T的某个子类，声明错误，因为不能确定?是T的哪个子类。

SeqList<? extends T> subList(int begin, int end)        //编译错，不能确定?是T的哪个子类



*/
//@author：Yeheya。2014-10-15