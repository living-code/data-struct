//《数据结构（Java版）（第4版）试题库》，作者：叶核亚，2015年10月14日
//6.2.6   二叉树的二叉链表实现
//【实验题6-1】BinaryTree<T>二叉树类增加成员方法。
    //问题讨论，中根或后根加空子树是否能够确定一棵二叉树？

public class BinaryTreeExercise_postlist 
{

    public static void main(String[] args) 
    {                                                           //图6.15所示二叉树标明空子树的先根遍历序列
        String[] postlist={"G","D",null,"B",null,null,"E",null,null,"H",null,"F","C","A"};
        BinaryTreeExercise<String> bitree = new BinaryTreeExercise<String>(postlist);
        
        System.out.println("先根次序遍历二叉树：  "+bitree.toString());  //标明空子树
        System.out.print("中根次序遍历二叉树：  ");  bitree.inorder();
        System.out.print("后根次序遍历二叉树：  ");  bitree.postorder();
    }

}
/*
 //
先根次序遍历二叉树：  A B D ∧G ∧∧∧C E ∧∧F H ∧∧∧
中根次序遍历二叉树：  D G B A E C H F 
后根次序遍历二叉树：  G D B E H F C A 

以下算法不行
        String[] inlist={null,"B",null,"A",null,"C",null};
        BinaryTreeExercise<String> bitree = new BinaryTreeExercise<String>();
        bitree.createBinaryTree(inlist);
 *
 */
//@author：Yeheya。2015-10-14