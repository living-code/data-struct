//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月20日
//6.3.2 中序线索二叉树
        //遍历

public class ThreadBinaryTree_traverse
{
    public static void main(String args[])
    {
        //图6.23所示二叉树标明空子树的先根序列
        String[] prelist = {"A","B","D",null,null,"E","G",null,null,null,"C","F",null,"H",null,null,"K"};
        ThreadBinaryTree<String> tbitree = new ThreadBinaryTree<String>(prelist);    //创建中序线索二叉树
        tbitree.preorder();                                 //先根次序遍历
        tbitree.inorder();                                  //中根次序遍历
        tbitree.inorderPrevious();                          //中根次序遍历（求前驱）
        tbitree.postorderPrevious();                        //后根次序遍历（求前驱）
    }
}
/*
程序运行结果如下：
先根次序遍历中序线索二叉树：  A B D E G C F H K 
中根次序遍历中序线索二叉树：  D B G E A F H C K 
中根次序（反序）遍历中序线索二叉树：  K C H F A E G B D 
后根次序（反序）遍历中序线索二叉树：  A C K F H B E G D 

*/
//@author  Yeheya。2015-2-11
    	