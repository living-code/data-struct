//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月6日
//5.3   广义表
//5.3.3   广义表双链表示的实现
//【例5.3】广义表的双链表示及构造算法。
//（2） 由广义表表示构造广义表

public class GenList_String            //由语法图构造广义表GenList<String>类
{
    private static int i=0;
    public static GenList<String> create(String gliststr)  //返回以gliststr表示创建的广义表
    {
        i=0;
        return createsub(gliststr);
    }

    //返回从gliststr[i]开始的子串创建的子广义表，用字符串表示原子，递归方法
    private static GenList<String> createsub(String gliststr)
    {
        i++;                                               //跳过'('
        GenList<String> glist = new GenList<String>();     //构造空广义表，只有头结点
        GenNode<String> p = glist.head;                    //指向头结点
        while (i<gliststr.length())
        {
            char ch=gliststr.charAt(i);
            switch (ch)
            {
                case ',':  i++; break;
                case '(': 
                {
                    p.next=new GenNode<String>();          //创建子表结点
                    p = p.next; 
                    p.child = createsub(gliststr);         //创建子表，递归调用
                    break;
                }
                case ')':  i++; return glist;
                default :                                  //用字符串表示原子
                {
                    int j=i+1;
                    ch=gliststr.charAt(j);
                    while (ch!='(' && ch!=',' && ch!=')')
                        ch=gliststr.charAt(++j);
                    p.next=new GenNode<String>(gliststr.substring(i,j)); //创建结点
                    p = p.next; 
                    i=j;
                }
            }
        }
        return null;
    }
   
    public static void main(String args[])
    {
        String[] name={"empty","L","T","G","S"};           //广义表表名
        String[] gliststr={"()",                           //广义表描述
                           "(a,b)",
                           "(c,(a,b))",
                           "(d,(a,b),(c,(a,b)))",
                           "(and,(begin,end),(my,your,(his,her)))"};//广义表元素值是字符串
        //不行,带表名"中国(北京, 上海, 江苏(南京, 苏州), 浙江(杭州))");
        for (int i=0; i<name.length; i++)
        {
            GenList<String> glist = create(gliststr[i]);   //构造广义表
            System.out.println(name[i]+"="+glist.toString()+"，size="+glist.size()+ 
                               "，depth="+glist.depth()); 
        }      
    }
}
/*
程序运行结果如下：
empty=()，  size=0，depth=1
L=(a,b)，  size=2，depth=1
T=(c,(a,b))，  size=2，depth=2
G=(d,(a,b),(c,(a,b)))，  size=3，depth=3
S=(and,(begin,end),(my,your,(his,her)))，  size=3，depth=3


*/
//author：Yeheya。2014-10-6