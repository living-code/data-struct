//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月20日
//6.3.2 中序线索二叉树
//1.  中序线索二叉树类

public class ThreadBinaryTree<T>                 //中序线索二叉树类，T指定结点的元素类型
{
    public ThreadNode<T> root;                   //根结点

    public ThreadBinaryTree()                    //构造空中序线索二叉树
    {
        this.root = null;
    }

    public boolean isEmpty()                     //判断是否空二叉树
    {
        return this.root==null;
    }

    public ThreadBinaryTree(T[] prelist)    //以标明空子树的先根序列构造中序线索二叉树
    {
        this.root = create(prelist);             //以标明空子树的先根遍历序列构造二叉树，方法省略
        inorderThread(this.root);                  //二叉树中序线索化
    }
    private int i=0;
    private ThreadNode<T> create(T[] prelist)    //以标明空子树的先根遍历序列构造以prelist[i]为根的子树，返回根结点
    {
        ThreadNode<T> p = null;
        if (i<prelist.length)
        {
            T elem=prelist[i++];
            if (elem!=null)
            {
                p = new ThreadNode<T>(elem);
                p.left = create(prelist);
                p.right = create(prelist);
            }
        }
        return p;
    }
    
    //2.  中序线索化二叉树
    private ThreadNode<T> front=null;            //front指向p在中根次序下的前驱结点
    private void inorderThread(ThreadNode<T> p)    //中序线索化以p结点为根的子树
    {
        if (p!=null)
        {
            inorderThread(p.left);                 //中序线索化p的左子树
            if (p.left==null)                    //若p的左子树为空
            {
                p.ltag=true;                     //设置左线索标记
                p.left=front;                    //设置p.left为指向前驱front的线索
            }
            if (p.right==null)                   //若p的右子树为空
                p.rtag=true;                     //设置右线索标记
            if (front!=null && front.rtag) 
                front.right=p;                   //设置前驱front.right为指向后继p的线索
            front=p;                             //front记得当前p，即是p下一个访问结点的前驱
            inorderThread(p.right);                //中序线索化p的右子树
        }
    }

    //3.  中根次序遍历中序线索二叉树
    //（1） 求结点在中根次序下的后继结点
    public ThreadNode<T> inNext(ThreadNode<T> p) //返回p在中根次序下的后继结点
    {
        if (p.rtag)                              //右线索标记，则p.right指向p的后继结点
            return p.right;
        p=p.right;                               //进入p的右子树
        while (!p.ltag)                          //找到最左边的后代结点
            p=p.left;
        return p;
    }
    
    //第4版省略，习题解答
    public void inorder()                        //中根次序遍历中序线索二叉树，非递归算法
    {
        System.out.print("中根次序遍历中序线索二叉树：  ");
        ThreadNode<T> p=this.root;
        while (p!=null && !p.ltag)               //寻找根的最左边的后代结点，即第一个访问结点
            p=p.left; 
        while (p!=null)
        {
            System.out.print(p.data.toString()+" ");
            p = this.inNext(p);                  //返回p在中根次序下的后继结点
        }
        System.out.println();
    }    

    //【思考题6-5】
    public ThreadNode<T> inPrev(ThreadNode<T> p) //返回p在中根次序下的前驱结点
    {
        if (p.ltag)                              //左线索标记，则p.left指向p的前驱结点
            return p.left;
        p=p.left;                                //进入p的左子树
        while (!p.rtag)                          //找到最右边的子孙结点
            p=p.right;
        return p;
    }
    public void inorderPrevious()                //中根次序遍历中序线索二叉树，非递归算法
    {
        System.out.print("中根次序（反序）遍历中序线索二叉树：  ");
        ThreadNode<T> p=this.root;
        while (p!=null && !p.rtag)               //寻找根的最右边的后代结点
            p=p.right; 
        while (p!=null)
        {
            System.out.print(p.data.toString()+" ");
            p=inPrev(p);                         //返回p在中根次序下的前驱结点
        } 
        System.out.println();
    }    
    
    //5.  先根次序遍历中序线索二叉树
    public ThreadNode<T> preNext(ThreadNode<T> p)//返回p在先根次序下的后继结点
    {
        if (!p.ltag)                             //若p有左孩子，则p的左孩子是p的后继
            return p.left;
        while (p.rtag && p.right!=null)          //否则，p后继是p最远中序祖先的右孩子
            p=p.right;                           //沿着右线索向上，寻找到最远中序祖先
        return p.right;                          //祖先的右孩子是后继
    }
    
    //【思考题6-6】
    public void preorder()                       //先根次序遍历中序线索二叉树，非递归算法
    {
        System.out.print("先根次序遍历中序线索二叉树：  ");
        for (ThreadNode<T> p=this.root;  p!=null;  p=preNext(p))  //返回p在先根次序下的后继结点
            System.out.print(p.data.toString()+" ");
        System.out.println();
    }
    
    //【思考题6-6】
    public ThreadNode<T> postPrev(ThreadNode<T> p)//返回p在后根次序下的前驱结点
    {
        if(!p.rtag)                              //若p有右孩子，则p的右孩子是p的前驱结点
            return p.right;
        while (p.ltag && p.left!=null)           //否则，p的前驱是左兄弟或其最远中序祖先的左孩子
            p=p.left;                            //寻找最远中序祖先
        return p.left;                           //祖先的左孩子是前驱
    }
    public void postorderPrevious()              //后根次序遍历中序线索二叉树，非递归算法
    {
        System.out.print("后根次序（反序）遍历中序线索二叉树：  ");
        for (ThreadNode<T> p=this.root;  p!=null;  p=postPrev(p))  //返回p在后根次序下的前驱结点
            System.out.print(p.data.toString()+" ");
        System.out.println();
    }
  //@author  Yeheya。2014-7-20
    
}

//@author  Yeheya。2014-7-20
