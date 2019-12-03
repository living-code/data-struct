//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年9月8日，JDK 8.11
//§2.2  线性表的顺序存储和实现
//§2.2.3  排序顺序表
//【例2.4】  对象信息的分类统计、查找和排序操作。

public class Student extends Object implements Comparable<Student>  //学生类
{
    String name;                                 //姓名
    int score;                                   //某门课程成绩

    public Student(String name, int score)       //构造方法
    {
        this.name = name;
        this.score = score;
    }
    
    public String toString()                     //返回对象的描述字符串，形式为“(,)”。覆盖
    {
        return "("+this.name+","+this.score+")";
    }

    public boolean equals(Object obj)            //比较对象是否相等，仅比较name，意按name识别Student对象。覆盖
    {
        return this==obj || (obj instanceof Student) &&  this.name.equals(((Student)obj).name);
                                    //调用String类的equals(Object)方法，比较两串是否相等
    }
    
    public int compareTo(Student stu)            //比较对象大小，实现Comparable<T>接口
    {
        return this.score - stu.score;           //按成绩比较对象大小
    }
}

/*  //以下正确，含义相同
    public boolean equals(Object obj)
    {
        if (this==obj)
            return true;
        if (obj instanceof Student)
            return this.name.equals(((Student)obj).name);
                                       //调用String类的equals(Object)方法，比较两串是否相等
        return false;
    }
*/
//@author：Yeheya。2014-9-8
