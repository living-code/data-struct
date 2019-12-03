//《数据结构（Java版）（第4版）习题解答》，作者：叶核亚，2015年3月20日
//8.5.1   二叉排序树
//【习题解答例8.1】判断一棵二叉树是否为二叉排序树。给出错误算法    
//算法正确

public class BinaryTree_isSorted 
{
    private static BinaryNode<?> bfront;
//  private static BinaryNode<T> front=null;         //不行，static变量不支持泛型<T>
    
    //判断一棵二叉树是否为二叉排序树，T必须实现Comparable<? super T>接口
    public static<T extends Comparable<? super T>> boolean isSorted(BinaryTree<T> bitree)
    {
        bfront=null;
        return isSorted(bitree.root);
    }
    
    //判断以p为根的子树是否为二叉排序树，bfront引用p在中根遍历次序下的前驱结点。
    //按中根次序遍历一棵二叉树，若各元素按升序排序，则是一棵二叉排序树。
    //二叉链表存储的二叉树，中根次序遍历是递归算法。
    private static<T extends Comparable<? super T>> boolean isSorted(BinaryNode<T> p)
    {
        if (p==null)
            return true;    
        if (!isSorted(p.left))                              //判断p的左子树
            return false;    
        if (bfront!=null && p.data.compareTo((T)bfront.data)<0) 
        {
            System.out.println("front.data="+bfront.data+"，p.data="+p.data);//输出中间结果，可省略
            return false;
        }
        bfront=p;
        return isSorted(p.right);                          //判断p的右子树
    }

    //采用二叉排序树测试上述算法。适用于二叉链表存储的二叉树，递归算法
    private static TriNode<?> sfront;
    //判断一棵二叉树是否为二叉排序树，T必须实现Comparable<? super T>接口
    public static<T extends Comparable<? super T>> boolean isSorted(BinarySortTree<T> bstree)
    {
        sfront=null;
        return isSorted(bstree.root);
    }
    
    //判断以p为根的子树是否为二叉排序树，sfront引用p在中根遍历次序下的前驱结点。
    //按中根次序遍历一棵二叉树，若各元素按升序排序，则是一棵二叉排序树。递归算法。
    private static<T extends Comparable<? super T>> boolean isSorted(TriNode<T> p)
    {
        if (p==null)
            return true;    
        if (!isSorted(p.left))                             //判断p的左子树
            return false;    
        if (sfront!=null && p.data.compareTo((T)sfront.data)<0) 
            return false;
        sfront=p;
        return isSorted(p.right);                          //判断p的右子树
    }
    
    //采用二叉排序树测试上述算法。适用于三叉链表存储的二叉树，有中根迭代遍历，非递归算法。
    //判断一棵二叉树是否为二叉排序树，T必须实现Comparable<? super T>接口
    //按中根次序遍历一棵二叉树，若各元素按升序排序，则是一棵二叉排序树。递归算法。
    public static<T extends Comparable<? super T>> boolean isSorted2(BinarySortTree<T> bstree)
    {
        TriNode<?> front=null;                             //front引用p在中根遍历次序下的前驱结点
        for (TriNode<T> p=bstree.first(bstree.root);  p!=null;  p=bstree.next(p)) 
        {
            if (front!=null && p.data.compareTo((T)front.data)<0) 
            {
                System.out.println("front.data="+front.data+"，p.data="+p.data);//输出中间结果，可省略
                return false;
            }
            front=p;
        }
        return true;    
    }

    public static void main(String args[])
    {
        //【习题解答例8.1，习图8.5】，标明空子树的先根序列
        Integer[] prelist={6,3,1,null,4,2,null,null,5,null,null,null,8,7,null,9};
        BinaryTree<Integer> bitree = new BinaryTree<Integer>(prelist);
        System.out.print("【习题解答例8.1，习图8.5】中根次序遍历二叉树， ");
        bitree.inorder();
        System.out.println("是二叉排序树？ "+isSorted(bitree));

        //用完全二叉树测试，由随机数序列（完全二叉树的层次序列）构造完全二叉树
        Integer[] values=Array1.randomInteger(10,100);            //例1.4
/*        System.out.print("\n随机数序列： ");
        Array1.print(values);
        bitree = new CompleteBinaryTree<Integer>(values);
        bitree.levelorder();
        System.out.print("中根次序遍历完全二叉树， ");
        bitree.inorder();
        System.out.println("是二叉排序树？ "+isSorted(bitree));*/
        
        //用二叉排序树测试，由随机数序列构造
        System.out.print("\n随机数序列： ");
        Array1.print(values);
        BinarySortTree<Integer> bstree = new BinarySortTree<Integer>(values);
        System.out.print("中根次序遍历二叉树， ");
        bstree.inorder();
        System.out.println("二叉链表存储，递归算法，是二叉排序树？ "+isSorted(bstree));
        System.out.println("三叉链表存储，迭代算法，是二叉排序树？ "+isSorted2(bstree));
    }
}
/*
程序运行结果如下：
【习题解答例8.1，习图8.5】中根次序遍历二叉树， 1 2 4 5 3 6 7 9 8 
front.data=5，p.data=3
是二叉排序树？ false

随机数序列：  80 41 96 80 71 53 29 6 4 18
层次遍历二叉树：  80 41 96 80 71 53 29 6 4 18 
中根次序遍历完全二叉树， 6 80 4 41 18 71 80 53 96 29 
front.data=80，p.data=4
是二叉排序树？ false

随机数序列：  80 41 96 80 71 53 29 6 4 18
中根次序遍历二叉树， [4 6 18 29 41 53 71 80 96 ]
二叉链表存储，递归算法，是二叉排序树？ true
三叉链表存储，迭代算法，是二叉排序树？ true


随机数序列：  33 76 62 1 61 93 48 40 61 35
层次遍历二叉树：  33 76 62 1 61 93 48 40 61 35 
中根次序遍历完全二叉树， 40 1 61 76 35 61 33 93 62 48 
front.data=40，p.data=1
是二叉排序树？ false

随机数序列：  33 76 62 1 61 93 48 40 61 35
中根次序遍历二叉树， [1 33 35 40 48 61 62 76 93 ]
是二叉排序树？ true
*/
//author：Yeheya。2015-3-21
