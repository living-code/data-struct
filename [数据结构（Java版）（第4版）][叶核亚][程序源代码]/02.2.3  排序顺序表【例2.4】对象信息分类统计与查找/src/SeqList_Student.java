//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年9月8日，JDK 8.25
//§2.2  线性表的顺序存储和实现
//§2.2.3  排序顺序表
//【例2.4】  对象信息的分类统计、查找和排序操作。

public class SeqList_Student
{
    //分类统计线性表list的元素信息，分段信息存于grade数组，返回保存统计结果的数组
    public static int[] groupCount(SeqList<Student> list, int grade[])
//    public static int[] groupCount(SinglyList<Student> list, int grade[])
//    public static int[] groupCount(CirDoublyList<Student> list, int grade[])
    {
        int result[] = new int[grade.length];    //result数组保存统计结果
        for (int i=0; i<list.size(); i++)
        {
            Student stu = list.get(i);           //获得list的第i个元素，对象引用赋值
            for (int j=0; j<grade.length-1; j++)
                if (stu.score>=grade[j] && stu.score<grade[j+1]) //判断stu范围
                {
                    result[j]++;
                    break;                       //退出内层循环
                }
        }
        return result;                           //返回result数组变量引用的数组
    }
    
    //输出线性表list元素及分类统计结果
    public static void printCount(SeqList<Student> list, String titles[], int result[])
//    public static void printCount(SinglyList<Student> list, String titles[], int result[])
//    public static void printCount(CirDoublyList<Student> list, String titles[], int result[])
    {
        System.out.print("学生集合："+list.toString()+"\n共"+list.size()+"人，成绩统计：");
        for (int i=0; i<titles.length; i++)
            System.out.print(titles[i]+result[i]+"人，");
        System.out.println();        
    }
    
    public static void main(String args[])
    {
        Student group[]={new Student("王红",85), new Student("张明",75), new Student("李强",90),
                         new Student("崔小兵",80),new Student("陈新诺",60),new Student("吴宁",65)}; 
        SeqList<Student> lista = new SeqList<Student>(group);//构造顺序表，由数组提供初值
//        SinglyList<Student> lista = new SinglyList<Student>(group);//构造，由数组提供初值
//        CirDoublyList<Student> lista = new CirDoublyList<Student>(group);//构造，由数组提供初值
        lista.insert(new Student("崔小兵",70));               //尾插入
        
        int[] grade={0,60,70,80,90,100};                    //指定分段信息
        String[] titles={"不及格","及格","中等","良好","优秀"};      //字符串数组指定分类名称
        int[] result = groupCount(lista, grade);            //分类统计，返回存放统计结果的数组
        printCount(lista, titles, result);

        String name = "崔小兵";
        Student key = new Student(name,0);                  //key包含姓名，按姓名查找，比较相等
        System.out.println("\""+name+"\"的成绩是："+lista.get(lista.search(key)).score);
//        System.out.println("删除"+lista.remove(key));
        
        SeqList<Student> slistb = new SortedSeqList<Student>(lista);//由顺序表构造排序顺序表，赋值相容
//        SinglyList<Student> slistb = new SortedSinglyList<Student>(lista);//由顺序表构造排序顺序表
//        CirDoublyList<Student> slistb = new SortedDoublyList<Student>(lista);//由顺序表构造排序顺序表
        int score=70;
        key = new Student("刘曲",score);                       //key包含成绩，比较大小，按成绩排序与查找
        slistb.insert(key);                //插入在等值结点之前
        result = groupCount(slistb, grade);                //分类统计，slistb引用子类实例，赋值相容
        printCount(slistb, titles, result);                //slistb引用子类实例，赋值相容
        System.out.println("成绩为"+score+"分的学生是："+slistb.get(slistb.search(key)).name);
    }
}
/*
程序运行结果如下：
学生集合：SeqList((王红,85), (张明,75), (李强,90), (崔小兵,80), (陈新诺,60), (吴宁,65), (崔小兵,70)) 
共7人，成绩统计：不及格0人，及格2人，中等2人，良好2人，优秀1人，
"崔小兵"的成绩是：80                                               //按姓名查找“崔小兵”，找到前一个元素
删除(崔小兵,80)
学生集合：SortedSeqList((陈新诺,60), (吴宁,65), (崔小兵,70), (张明,75), (王红,85), (李强,90)) 
共6人，成绩统计：不及格0人，及格2人，中等2人，良好1人，优秀1人，
SortedSeqList.indexOf((,70),0)，(陈新诺,60)？(吴宁,65)？(崔小兵,70)？成绩为70分的学生是：崔小兵


//排序单链表、排序循环双链表
学生集合：SinglyList((王红,85),(张明,75),(李强,90),(崔小兵,80),(陈新诺,60),(吴宁,65),(崔小兵,70))
共7人，成绩统计：不及格0人，及格2人，中等2人，良好2人，优秀1人，
"崔小兵"的成绩是：80
删除(崔小兵,80)
学生集合：SortedSinglyList((陈新诺,60),(吴宁,65),(刘曲,70),(崔小兵,70),(张明,75),(王红,85),(李强,90))
共7人，成绩统计：不及格0人，及格2人，中等3人，良好1人，优秀1人，
成绩为70分的学生是：刘曲


*/
/*
2015年1月30日，校清样
下一版研究，返回顺序表
    public static SeqList<Integer> groupCount(SeqList<Student> list, int grade[])


 * */
