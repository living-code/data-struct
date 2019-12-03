//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月11日
//4.2.5   优先队列
//【例4.4】 进程按优先级调度管理。

public class Process  implements Comparable<Process>       //进程
{
    private String name;                                   //进程名
    private int priority;                                  //优先级
                
    //构造进程，参数name、priority分别指定进程名和优先级，
    //优先级范围为1～10，1最低，10最高，默认5，超出时抛出无效参数异常
    public Process(String name, int priority)
    {
        this.name = name;
        if (priority>=1 && priority<=10)
            this.priority = priority;
        else throw new IllegalArgumentException("priority="+priority);
    }
    public Process(String name)
    {
        this(name, 5);
    }
    public String toString()
    {
        return "("+this.name+","+this.priority+")";
    }

    public int compareTo(Process p)                        //进程按优先级比较大小
    {
        return this.priority - p.priority;
    }
}

class Process_ex 
{
    public static void main(String args[])
    {
        Process process[]={new Process("A",4),new Process("B",3),new Process("C"),
                           new Process("D",4),new Process("E",10),new Process("F",1)};
        PriorityQueue<Process> que = new PriorityQueue<Process>(false); //创建空队列，降序
//        PriorityQueue2<Process> que = new PriorityQueue2<Process>(false); //第10章
        System.out.print("入队进程：");
        for (int i=0; i<process.length; i++)
        {
            que.add(process[i]);                           //进程入队
            System.out.print(process[i]+" ");
        }
        System.out.print("\n出队进程：");
        while (!que.isEmpty()) 
            System.out.print(que.poll().toString()+" ");   //出队
        System.out.println();
    }
}
    
/*
两次程序运行结果如下。
入队进程：(A,4) (B,3) (C,5) (D,4) (E,10) (F,1) 
出队进程：(E,10) (C,5) (A,4) (D,4) (B,3) (F,1)        //降序

入队进程：(A,4) (B,3) (C,5) (D,4) (E,10) (F,1)
出队进程：(F,1) (B,3) (A,4) (D,4) (C,5) (E,10)        //升序

*/

//author：Yeheya。2014-9-23

//第10章程序运行结果同上。
