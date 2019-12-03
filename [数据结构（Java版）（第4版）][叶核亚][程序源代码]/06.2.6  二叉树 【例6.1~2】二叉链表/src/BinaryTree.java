//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月19日
//6.2.6   二叉树的二叉链表实现
//2.  采用二叉链表存储的二叉树类声明
//【思考题6-2】 基于遍历的操作
//【例6.1】  二叉树的构造、遍历及插入。

public class BinaryTree<T>                       //二叉树类，二叉链表存储，T指定结点的元素类型 
{
    public  BinaryNode<T> root;                  //根结点，二叉链表结点结构

    public BinaryTree()                          //构造空二叉树
    {
        this.root=null;
    }
    public boolean isEmpty()                     //判断是否空二叉树
    {
        return this.root==null;
    }

    //3. 二叉树的插入结点
    public BinaryNode<T> insert(T x)             //插入x作为根结点，原根结点作为x的左孩子；返回插入结点
    {
        return this.root = new BinaryNode<T>(x, this.root, null);
    }
    //注意：不能声明为insertRoot(T x)，因为，该方法将被二叉排序树类覆盖。
    
    //插入x为parent结点的左/右孩子，leftChild指定孩子，取值为true（左）、false（右）；
    //parent的原左/右孩子成为x结点的左/右孩子；返回插入结点。
    //若x==null，不插入，返回null。若parent==null，Java抛出空对象异常。
    public BinaryNode<T> insert(BinaryNode<T> parent, T x, boolean leftChild)
    {
        if (x==null)
            return null;
        if (leftChild)                           //插入x为parent结点的左/右孩子，返回插入结点
            return parent.left=new BinaryNode<T>(x, parent.left, null);
        return parent.right=new BinaryNode<T>(x, null, parent.right);
    }    

    //4.  二叉树删除子树
    //删除parent结点的左或右子树，leftChild指定子树，取值为true（左）、false（右）。
    //Java自动收回被删除子树占用的存储空间。
    public void remove(BinaryNode<T> parent, boolean leftChild)
    {
        if (leftChild)
            parent.left = null;                  //若parent==null，Java抛出空对象异常
        else  parent.right = null;
    }    
    public void clear()                                    //删除二叉树的所有结点
    {
        this.root = null;
    }

    //5. 二叉树孩子优先的遍历算法
    public void preorder()                                 //输出先根次序遍历序列
    {
//        System.out.print("先根次序遍历二叉树：  ");
        preorder(this.root);                               //调用先根次序遍历二叉树的递归方法
        System.out.println();
    }    
    private void preorder(BinaryNode<T> p)                 //先根次序遍历以p结点为根的子树，递归方法
    {
        if (p!=null)                                       //若二叉树不空
        {
            System.out.print(p.data.toString()+" ");       //先访问当前结点元素
            preorder(p.left);                              //按先根次序遍历p的左子树，递归调用，参数为左孩子
            preorder(p.right);                             //按先根次序遍历p的右子树，递归调用，参数为右孩子
        }
    }
    
    public String toString()                               //返回先根次序遍历二叉树所有结点的描述字符串
    {
        return toString(this.root);
    }
    private String toString(BinaryNode<T> p)               //返回先根次序遍历以p为根的子树描述字符串，递归方法
    {
        if (p==null)
            return "∧";                                    //输出空子树标记
        return p.data.toString()+" " + toString(p.left) + toString(p.right);
    }

    public void inorder()                                  //输出中根次序遍历序列
    {
//        System.out.print("中根次序遍历二叉树：  ");
        inorder(this.root);
        System.out.println();
    }    
    private void inorder(BinaryNode<T> p)                  //中根次序遍历以p结点为根的子树，递归方法
    {
        if (p!=null)
        {
            inorder(p.left);                               //中根次序遍历p的左子树，递归调用
            System.out.print(p.data.toString()+" ");
            inorder(p.right);                              //中根次序遍历p的右子树，递归调用
        }
    }

    public void postorder()                                //输出后根次序遍历序列
    {
//        System.out.print("后根次序遍历二叉树：  ");
        postorder(this.root);
        System.out.println();
    }
    private void postorder(BinaryNode<T> p)                //后根次序遍历以p结点为根的子树，递归方法
    {
        if (p!=null)
        {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data.toString()+" ");       //后访问当前结点元素
        }
    }

    //【思考题6-2】 基于遍历的操作【习题解答】
    public int size()                                      //返回二叉树的结点数
    {
        return size(root);
    }
    public int size(BinaryNode<T> p)                       //返回以p结点为根的子树的结点数
    {
        if (p==null)
            return 0;
        return 1+size(p.left)+size(p.right);
    }

    public int height()                                    //返回二叉树的高度
    {
        return height(root);
    }
    public int height(BinaryNode<T> p)                     //返回以p结点为根的子树高度，后根次序遍历
    {
        if (p==null)
            return 0;
        int lh = height(p.left);                           //返回左子树的高度
        int rh = height(p.right);                          //返回右子树的高度
        return (lh>=rh) ? lh+1 : rh+1;                     //当前子树高度为较高子树的高度加1
    }

    //6. 构造二叉树
    //（2） 标明空子树的先根序列表示
    public BinaryTree(T[] prelist)                         //以标明空子树的先根遍历序列构造二叉树
    {
        this.root = create(prelist);
    }
    //以从i开始的标明空子树的先根序列，创建一棵以prelist[i]为根的子树，返回根结点，递归方法
    private int i=0;
    private BinaryNode<T> create(T[] prelist)
    {
        BinaryNode<T> p = null;
        if (i<prelist.length)
        {
            T elem=prelist[i];
            i++;
            if (elem!=null)                                //不能elem!="∧"，因为T不一定是String
            {
                p = new BinaryNode<T>(elem);               //创建叶子结点
                p.left = create(prelist);                  //创建p的左子树，递归调用，实际参数与形式参数相同
                p.right = create(prelist);                 //创建p的右子树，递归调用，实际参数与形式参数相同
            }
        }
        return p;
    }
    //【例6.1】  二叉树的构造、遍历及插入。
    

    //【思考题6-3】【习题解答】
    public BinaryTree(BinaryTree<T> bitree)      //拷贝构造方法，深拷贝
    {
        this.root = copy(bitree.root);
    }

    //复制以p根的子二叉树，返回新建子二叉树的根结点
    private BinaryNode<T> copy(BinaryNode<T> p)
    {
        if (p==null)
            return null;
        BinaryNode<T> q = new BinaryNode<T>(p.data);
        q.left = copy(p.left);                   //复制左子树，递归调用
        q.right = copy(p.right);                 //复制右子树，递归调用
        return q;                                //返回建立子树的根结点
    }
    
    //7.  二叉树的广义表表示
    //（1） 广义表表示
    public void printGenList()                             //输出二叉树的广义表表示字符串
    {
        System.out.print("二叉树的广义表表示：");
        printGenList(this.root);
        System.out.println();
    }
    //输出以p结点为根的一棵子树的广义表表示字符串，先根次序遍历，递归算法
    private void printGenList(BinaryNode<T> p)
    {
        if (p==null)                                       //若二叉树空
            System.out.print("∧");                         //输出空子树标记
        else            
        {   System.out.print(p.data.toString());           //访问当前结点
            if (p.left!=null || p.right!=null)             //非叶子结点，有子树
            {
                System.out.print("(");
                printGenList(p.left);                      //输出p的左子树，递归调用
                System.out.print(",");
                printGenList(p.right);                     //输出p的右子树，递归调用
                System.out.print(")");
            }
        }
    }
    //【例6.2】 二叉树的广义表表示。
    //author：Yeheya。2014-7-19
    
    //8.  二叉树孩子优先遍历的非递归算法
    public void preorderTraverse()                         //先根次序遍历二叉树的非递归算法
    {
        System.out.print("先根次序遍历（非递归）：  ");
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>(); //创建空栈
        BinaryNode<T> p = this.root;
        while (p!=null || !stack.isEmpty())                //p非空或栈非空时
            if (p!=null)
            {
                System.out.print(p.data+" ");              //访问结点
                stack.push(p);                             //p结点入栈
                p=p.left;                                  //进入左子树
            }
            else                                           //p为空且栈非空时
            {
                System.out.print("∧ ");
                p=stack.pop();                             //p指向出栈结点
                p=p.right;                                 //进入右子树
            }
        System.out.println();
    }    

    public void inorderTraverse()                         //中根次序遍历二叉树的非递归算法
    {
        System.out.print("中根次序遍历（非递归）：  ");
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();   //创建一个空栈
        BinaryNode<T> p = this.root;
        while (p!=null || !stack.isEmpty())                //p非空或栈非空时
            if (p!=null)
            {
                stack.push(p);                             //p结点入栈
                p=p.left;                                  //进入左子树
            }
            else                                           //p为空且栈非空时
            {
                p=stack.pop();                             //p指向出栈结点
                System.out.print(p.data+" ");              //访问结点
                p=p.right;                                 //进入右子树
            }
        System.out.println();
    }    

    //9. 二叉树的层次遍历
    public void levelorder()                               //按层次遍历二叉树
    {
        System.out.print("层次遍历二叉树：  ");
        SeqQueue<BinaryNode<T>> que=new SeqQueue<BinaryNode<T>>(); //创建空队列
//        LinkedQueue<BinaryNode<T>> que=new LinkedQueue<BinaryNode<T>>(); //创建空队列
        BinaryNode<T> p=this.root;                         //根结点没有入队
        while (p!=null)
        {
            System.out.print(p.data+ " ");                 //访问p结点
            if (p.left!=null)    
                que.add(p.left);                           //p的左孩子结点入队
            if (p.right!=null)
                que.add(p.right);                          //p的右孩子结点入队
            p=que.poll();                                  //p指向出队结点，若队列空返回null
        }
        System.out.println();
    }

    //也可，根结点入队，算法同图的一次广度优先搜索遍历
    public void levelorder2()                               //按层次遍历二叉树
    {
        System.out.print("层次遍历二叉树：  ");
        SeqQueue<BinaryNode<T>> que=new SeqQueue<BinaryNode<T>>(); //创建空队列
//        LinkedQueue<BinaryNode<T>> que=new LinkedQueue<BinaryNode<T>>(); //创建空队列
        if (this.root==null)
            return;
        que.add(this.root);                                //根结点入队
        while (!que.isEmpty())
        {
            BinaryNode<T> p=que.poll();                    //p指向出队结点，若队列空返回null
            System.out.print(p.data+ " ");                 //访问p结点
            if (p.left!=null)    
                que.add(p.left);                           //p的左孩子结点入队
            if (p.right!=null)
                que.add(p.right);                          //p的右孩子结点入队
        }
        System.out.println();
    }   
    
}
