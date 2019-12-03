//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月3日
//4.2 队列

public class Queue_ex 
{
	public static void main(String args[])
	{
	    SeqQueue<Integer> que = new SeqQueue<Integer>(5);
	    que.add(new Integer(10)); 
	    que.add(new Integer(20)); 
	    System.out.println("poll : "+que.poll().toString()+"  "+que.poll().toString()+"  ");
	    System.out.println(que.toString());
	    que.add(new Integer(30)); 
	    que.add(new Integer(40)); 
	    que.add(new Integer(50)); 
	    que.add(new Integer(60)); 
	    System.out.println(que.toString());
	    que.add(new Integer(70)); 
	    System.out.println(que.toString());
	    
        LinkedQueue<Integer> q = new LinkedQueue<Integer>();
        System.out.print("add: ");
        for (int i=1; i<=5; i++)
        {
            Integer intobj = new Integer(i);
            q.add(intobj);
            System.out.print(intobj+"  ");
        }    
        System.out.println("\n"+q.toString());

        System.out.print("poll : ");
        while (!q.isEmpty())
            System.out.print(q.poll().toString()+"  ");
        System.out.println();
	}
}
/*
程序运行结果如下：
poll : 10  20  
()
(30,40,50,60)
(30,40,50,60,70)
add: 1  2  3  4  5  
(1, 2, 3, 4, 5)
poll : 1  2  3  4  5  
*/
//@author：Yeheya。2014-9-23