//《数据结构（Java版）（第4版）习题解答》，作者：叶核亚，2015年3月20日
//8.5.1   二叉排序树
//【习题解答例8.1】判断一棵二叉树是否为二叉排序树。给出错误算法    

public class BinaryTree_isSorted_error 
{
    //判断一棵二叉树是否为二叉排序树，T必须实现Comparable<? super T>接口
    public static<T extends Comparable<? super T>> boolean isSorted(BinaryTree<T> bitree)
    {
        return isSorted(bitree.root);
    }
    //判断以p为根的子树是否为二叉排序树，递归方法，先根次序遍历
    //算法根据二叉排序树定义，有错
    private static<T extends Comparable<? super T>> boolean isSorted(BinaryNode<T> p)
    {
        if (p==null)
            return true;
        if ((p.left==null || p.left!=null && p.data.compareTo(p.left.data)>0) &&
            (p.right==null || p.right!=null && p.data.compareTo(p.right.data)<0))
            return isSorted(p.left) && isSorted(p.right);
        return false;
    }
  
    public static void main(String args[])
    {
        Integer[] prelist={6,3,1,null,4,2,null,null,5,null,null,null,8,7,null,9}; //标明空子树的先根序列
        BinaryTree<Integer> bitree = new BinaryTree<Integer>(prelist);
        bitree.inorder();
        System.out.println("是二叉排序树？ "+isSorted(bitree));
     }
}
/*
程序运行结果如下：
中根次序遍历二叉树：  1 2 4 5 3 6 7 9 8 
是二叉排序树？ true                                               //结果错误
*/    
//author：Yeheya。2015-3-21
