//《数据结构（Java版）（第4版）试题库》，作者：叶核亚，2015年8月6日
//6.2.6   二叉树的二叉链表实现
//9.  二叉树的层次遍历与构造
//【试题6】  以层次遍历序列构造完全二叉树，层次遍历，画出使用顺序循环队列的变化图。

public class CompleteBinaryTree_level 
{
    public static void main(String[] args) 
    {
//        String[] levellist = {"A","M","B","U","L","N","C","E"};              //ambulance救护车
        String[] levellist = {"H","E","L","I","C","O","P","T","R"};      //helicopter直升飞机
        System.out.print("以层次遍历序列构造完全二叉树：  ");
        Array1.print(levellist);                         //见例1.4
        
        CompleteBinaryTree<String> cbitree = new CompleteBinaryTree<String>(levellist);
                                      //由层次遍历序列levellist构造完全二叉树
        cbitree.levelorder();      //输出二叉树cbitree的层次遍历序列
        
        //习题6
//      System.out.println("是否完全二叉树？  "+cbitree.isCompleteBinaryTree());
    }
}
/*
程序运行结果如下：   
        //ambulance救护车
以层次遍历序列构造完全二叉树：   A M B U L N C E
层次遍历二叉树：  访问A，SeqQueue(M,B)
访问M，SeqQueue(B,U,L)
访问B，SeqQueue(U,L,N,C)
访问U，SeqQueue(L,N,C,E)
访问L，SeqQueue(N,C,E)
访问N，SeqQueue(C,E)
访问C，SeqQueue(E)
访问E，SeqQueue()

                //helicopter直升飞机
以层次遍历序列构造完全二叉树：   H E L I C O P T R
层次遍历二叉树：  访问H，SeqQueue(E,L)
访问E，SeqQueue(L,I,C)
访问L，SeqQueue(I,C,O,P)
访问I，SeqQueue(C,O,P,T,R)
访问C，SeqQueue(O,P,T,R)
访问O，SeqQueue(P,T,R)
访问P，SeqQueue(T,R)
访问T，SeqQueue(R)
访问R，SeqQueue()



*/
//@author  Yeheya。2015-8-7
