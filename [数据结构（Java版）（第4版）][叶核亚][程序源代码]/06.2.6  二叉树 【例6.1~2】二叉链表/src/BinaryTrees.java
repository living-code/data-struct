//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月19日
//6.2.6   二叉树的二叉链表实现
//7.  二叉树的广义表表示
//【例6.2】 二叉树的广义表表示。 

public class BinaryTrees                                   //为特定二叉树增加静态方法
{    
    private static int i=0;
    //返回以广义表表示字符串genlist构造的二叉树
    public static BinaryTree<String> createByGenList(String genlist)
    {
        BinaryTree<String> bitree = new BinaryTree<String>();
        i=0;
        if (genlist.length()>0)
            bitree.root = create(genlist);                 //创建子树，子树根值是genlist[0]
        return bitree;
    }    
   
    //以从i开始的广义表表示字符串创建一棵以genlist[i]为根的子树，返回根结点，递归算法
    private static BinaryNode<String> create(String genlist)
    {
        BinaryNode<String> p = null;
        char ch=genlist.charAt(i);
        if (ch=='∧')
        {   i++;                                           //跳过'∧'
            return null;
        }
        int end=i;
        while (end<genlist.length() && ch!='(' && ch!=',' && ch!=')')
        {                                                  //一个元素占多个字符，以(或,或)分割
            end++;
            ch=genlist.charAt(end);
        }
        String str = genlist.substring(i,end);             //获得从i～end-1的子串，深拷贝
        i=end;
        p = new BinaryNode<String>(str);                   //创建叶子结点
        if (genlist.charAt(i)=='(')
        {
            i++;                                           //跳过'('
            p.left = create(genlist);                      //创建左子树，递归调用
            i++;                                           //跳过','
            p.right = create(genlist);                     //创建右子树，递归调用
            i++;                                           //跳过')'
        }
        return p;                                          //空串返回null
    }    
}


//@author：Yeheya。2014-10-7
