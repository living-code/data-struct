//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月19日
//6.2.6   二叉树的二叉链表实现
//【例6.3】表达式二叉树。
//表达式二叉树的元素类

public class ExpData                                       //表达式二叉树的元素类
{
    int value;                                             //元素值
    char oper;                                             //单字符运算符//运算符operator
//    String oper;                                           //运算符operator

    public ExpData(int value, char oper)                   //构造方法
    {
        this.value = value;
        this.oper = oper;
    }
    public String toString()                               //返回描述字符串
    {
        return this.oper==' ' ? this.value+"" : this.oper+"";
    }
    
    //？？使用反射写个通用的，比较基本类型成员变量值是否相等。
    public boolean equals(Object obj)            //比较两个结点值是否相等，覆盖Object类的equals(obj)方法
    {
        if (obj==this)
           return true;
        if (obj instanceof ExpData)
        {
            ExpData exp = (ExpData)obj;
            return this.value==exp.value && this.oper==exp.oper;
        }
        return false;
    }
}
