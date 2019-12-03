//《数据结构（Java版）（第4版）试题库》，作者：叶核亚，2015年8月10日
//6.2.6   二叉树的二叉链表实现
//【实验题6-2】对BinaryTree<T>二叉树的操作，静态方法。

public class BinaryTree_isComplete 
{
    public static <T> boolean isCompleteBinaryTree(BinaryTree<T> bitree)  //判断是否完全二叉树
    {
       if (bitree.root==null)
           return true;
//          SeqQueue<BinaryNode<T>> que = new SeqQueue<BinaryNode<T>>(); //创建空队列
        LinkedQueue<BinaryNode<T>> que = new LinkedQueue<BinaryNode<T>>();
        que.add(bitree.root);                           //根结点入队
        BinaryNode<T> p=null;
        while (!que.isEmpty())
        {
            p = que.poll();                      //p指向出队结点
            if (p.left!=null )                   //p的非空孩子结点入队
            {
                que.add(p.left);
                if (p.right!=null)
                    que.add(p.right);
                else break;                      //发现空子树，须检测队列中是否都是叶子结点
            }
            else
                if (p.right!=null)
                    return false;                //p的左子树空而右子树不空，确定不是
                else break;                      //p是叶子，须检测队列中是否都是叶子结点
        }
        while (!que.isEmpty())                   //检测队列中是否都是叶子结点
        {
            p = que.poll();
            if (p.left!=null || p.right!=null)   //发现非叶子，确定不是
                return false;
        }
        return true;
    }

}
//@author：Yeheya。2015-8-10
