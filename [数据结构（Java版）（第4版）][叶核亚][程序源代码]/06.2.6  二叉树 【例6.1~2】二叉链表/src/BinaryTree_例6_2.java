//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月19日
//6.2.6   二叉树的二叉链表实现
//7.  二叉树的广义表表示
//【例6.2】 二叉树的广义表表示。 

public class BinaryTree_例6_2
{    
    public static void main(String args[])
    {
        String genlist;// = "AA(BB(DD(^,G),^),C(E,F(H,^)))";  //图6.18所示二叉树的广义表表示
//        genlist = "";//"A(B,C)";
        genlist = "A(B,C(D(F,G(J,^)),E(H(K,L),I(^,M))))";
        
        BinaryTree<String> bitree = BinaryTrees.createByGenList(genlist);               
        bitree.printGenList();                             //输出二叉树的广义表表示字符串 
        //习题6
//        System.out.println("是否完全二叉树？  "+bitree.isCompleteBinaryTree());  
        
        
    }
}
/*
程序运行结果如下：
二叉树的广义表表示：AA(BB(DD(^,G),^),C(E,F(H,^)))
是否完全二叉树？  false

二叉树的广义表表示：A(B,C)
是否完全二叉树？  true

二叉树的广义表表示：∧
是否完全二叉树？  true

二叉树的广义表表示：A(B,C(D(F,G(J,^)),E(H(K,L),I(^,M))))
是否完全二叉树？  false

*/

//@author：Yeheya。2014-10-7
