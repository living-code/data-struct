//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月23日
//6.5.3   树的父母孩子兄弟链表实现
//3.  树的横向凹入表示法

public class Trees
{
    //以横向凹入表示构造树，prelist数组存储树（森林）的横向凹入表示字符串序列
    //非递归算法，逐个结点添加方式，没有调用返回、插入结点方法
    public static Tree<String> create(String[] prelist)
    {
        Tree<String> tree = new Tree<String>();            //创建空树
        if (prelist.length==0)
            return tree;                                   //返回空树
        tree.root = new TreeNode<String>(prelist[0],1);    //创建根结点，层次为1
        TreeNode<String> p = tree.root;
        for (int i=1; i<prelist.length; i++)     //将prelist[i]插入作为森林中最后一棵子树的最后一个孩子
        {
            int n=0;
            while (n<prelist[i].length() && prelist[i].charAt(n)=='\t')
                n++;                             //统计prelist[i]串中'\t'前缀个数
            
            String str = prelist[i].substring(n);//结点元素，去除prelist[i]串中所有'\t'前缀
            if (n==p.level)                      //prelist[i]比p多一个'\t'前缀，插入作为p的第0个孩子
            {
                p.child = new TreeNode<String>(str, p.level+1, p, null, null);
                p = p.child;
            }
            else
            {
                while (n<p.level-1)              //prelist[i]比p的'\t'少，p向上寻找插入位置
                    p = p.parent;
                p.sibling = new TreeNode<String>(str, p.level, p.parent, null, null);//同层，插入作为p结点的下个兄弟
                p = p.sibling;
            }
        }
        return tree;
    }    
}
//@author  Yeheya。2015-3-6


