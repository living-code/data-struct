//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月3日
//4.2 队列
//【例4.3】 求解素数环问题。

public class PrimeRing 
{	
    public PrimeRing(int max)                              //求1～max素数环
    {
        SortedSeqList<Integer> primeset = createPrime(max);//排序顺序表存储素数集合
        System.out.println("素数集合: "+primeset.toString());
        
        SeqList<Integer> ring = new SeqList<Integer>(max); //顺序表，存储素数环
        ring.insert(1);                                    //素数环添加Integer(1)

        Queue<Integer> que = new SeqQueue<Integer>(max);   //创建空队列，链式队列也可
//        Queue<Integer> que = new LinkedQueue<Integer>();   //创建空队列
        for (int i=2; i<=max; i++)                         //2～max全部入队
            que.add(i);
        System.out.println("队列: "+que.toString());
 
        int i=0;
        while (!que.isEmpty()) 
        {
            int key = que.poll();                          //出队
//            System.out.print("出队: "+k+"\t");
            if (primeset.contains(ring.get(i)+key))        //判断素数，排序顺序表包含（查找）
            {
                i++;
                ring.insert(key);                          //素数环添加Integer(key)
            }
            else
                que.add(key);                              //key再次入队
//            System.out.println("队列: "+que.toString());
        }
        System.out.println("1～"+max+"素数环: "+ring.toString());
    }
    
    //返回包含2～max中所有素数的排序顺序表，也可返回循环双链表
    public SortedSeqList<Integer> createPrime(int max)
    {
        if (max<=0)
            return null;
        SortedSeqList<Integer> primeset=new SortedSeqList<Integer>(max*2);//排序顺序表存储素数
        primeset.insert(2);                                //添加已知的最小素数
        for (int key=3;  key<max*2;  key+=2)               //测试奇数，其他偶数不需测试
        {
            int i=0;
            while (i<primeset.size() && key % primeset.get(i)!=0)//用primeset中的素数测试key
                i++;
            if (i==primeset.size())                        //key是素数
                primeset.insert(key);                      //排序顺序表尾插入最大值
        }
        return primeset;
    }    
    
    public static void main(String args[])
    {
         new PrimeRing(10);
    }
}

/*
程序运行结果如下：
素数集合: SortedSeqList(2, 3, 5, 7, 11, 13, 17, 19) 
队列: SeqQueue(2,3,4,5,6,7,8,9,10)
1～10素数环: SeqList(1, 2, 3, 4, 7, 10, 9, 8, 5, 6) 


素数集合: (2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37) 
队列: SeqQueue(2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
1～20素数环: (1, 2, 3, 4, 7, 10, 13, 16, 15, 8, 9, 14, 17, 20, 11, 12, 19, 18, 5, 6) 

*/
//不能声明静态成员变量如下，因为参数要从构造方法获得。
//    static SortedSeqList<Integer> primeset; //素数集合

//@author：Yeheya。2014-10-28