//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月12日
//6.2.6   二叉树的二叉链表实现
//【例6.1】  二叉树的构造、遍历及插入。 

public class BinaryTree_例6_1 
{
    public static void main(String args[])
    {                                                           //图6.15所示二叉树标明空子树的先根遍历序列
        String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        BinaryTree<String> bitree = new BinaryTree<String>(prelist);
        System.out.println("先根次序遍历二叉树：  "+bitree.toString());  //标明空子树
        System.out.print("中根次序遍历二叉树：  ");  bitree.inorder();
        System.out.print("后根次序遍历二叉树：  ");  bitree.postorder();
        bitree.levelorder();                               //层次遍历二叉树
        
        bitree.insert(bitree.root.left, "X", true);        //插入X结点作为B结点的左孩子，图6.11（a）
        bitree.insert(bitree.root.right, "Y", false);      //插入Y结点作为C结点的右孩子，图6.11（b）
        bitree.insert("Z");                                //插入根
        bitree.preorderTraverse();                         //输出先根次序遍历序列（标明空子树），非递归算法
        bitree.inorderTraverse();                          //输出中根次序遍历序列，非递归算法
        bitree.postorder();                                //输出后根次序遍历序列
        bitree.levelorder();                               //层次遍历二叉树
    }
}
/*
程序运行结果如下：
先根次序遍历二叉树：  A B D ∧G ∧∧∧C E ∧∧F H ∧∧∧
中根次序遍历二叉树：  D G B A E C H F 
后根次序遍历二叉树：  G D B E H F C A 
层次遍历二叉树：  A B C D E F G H 
先根次序遍历（非递归）：  Z A B X D ∧ G ∧ ∧ ∧ ∧ C E ∧ ∧ Y ∧ F H ∧ ∧ ∧ 
中根次序遍历（非递归）：  D G X B A E C Y H F Z 
G D X B E H F Y C A Z 
层次遍历二叉树：  Z A B C X E Y D F G H 



*/


//@author：Yeheya。2015-3-20