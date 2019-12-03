//《数据结构（Java版）（第4版）》，作者：叶核亚，2015年3月21日
//8.5.1   二叉排序树

//二叉排序树类，T或T的某个祖先类实现Comparable<T>接口
public class BinarySortTree<T extends Comparable<? super T>>
{
    public TriNode<T> root;                                //根结点，三叉链表结点结构

    public BinarySortTree()                                //构造空二叉排序树
    {
        this.root=null;
    }
    public BinarySortTree(T[] values)                      //构造二叉排序树，由values数组提供元素
    {
        this();                                            //构造空二叉排序树
        this.addAll(values);                               //插入values数组所有元素
    } 
  
    public boolean isEmpty()                               //判断是否空二叉树
    {
        return this.root==null;
    }

    //2.  查找操作
    //查找关键字为key元素，若查找成功，返回结点，否则返回null。非递归算法。//若key==null，Java抛出空对象异常
    //查找算法经过一条从根到结点的路径，非递归，查找不成功，遍历路径是从根到叶子。
    public TriNode<T> searchNode(T key)
    {
        TriNode<T> p=this.root;
        while (p!=null && key.compareTo(p.data)!=0)
        {
//            System.out.print(p.data+"? ");       //显示查找经过的结点值，可省略
            if (key.compareTo(p.data)<0)                   //若key较小
                p=p.left;                                  //进入左子树
            else
                p=p.right;                                 //进入右子树
        }
        return p!=null ? p : null;                         //若查找成功，返回结点，否则返回null
    }
    public T search(T key)                                 //查找关键字为key元素，若查找成功，返回元素，否则返回null
    {
        TriNode<T> find = this.searchNode(key);
        return find!=null ? find.data : null;
    }
    
    //3.  插入操作
    //插入元素x结点，不插入关键字重复元素和空对象，返回插入与否状态。//若x==null，Java抛出空对象异常
    public boolean add(T x)
    {
        if (this.root==null)
            this.root=new TriNode<T>(x);                   //创建根结点
        else                                               //将x插入到以root为根的二叉排序树中
        {
            TriNode<T> p=this.root, parent=null;
            while (p!=null)                                //查找确定插入位置
            {
                if (x.compareTo(p.data)==0)
                    return false;                          //查找成功，不插入关键字重复的元素
                parent = p;
                if (x.compareTo(p.data)<0)
                    p=p.left;
                else  p=p.right;
            }
            if (x.compareTo(parent.data)<0)                //插入x叶子结点作为parent的左/右孩子
                parent.left = new TriNode<T>(x, parent, null, null);
            else parent.right = new TriNode<T>(x, parent, null, null); 
        }
        return true;
    }
    //思考题：能否直接调用查找算法确定插入位置？为什么？
    
    //4.  中根次序迭代遍历
    //返回中根次序遍历二叉树所有结点的描述字符串，迭代遍历，非递归算法
    public String toString()
    {
        String str="["; 
        TriNode<T> p = this.first(this.root);              //寻找第一个访问结点，最小值
        while (p!=null)
        {
            str += p.data.toString()+" ";
            p = this.next(p);                              //返回p在中根次序下的后继结点
        }
        //也可
//        for (TriNode<T> p=this.first(this.root); p!=null; p=this.next(p)) //中根次序迭代遍历
//            str += p.data.toString()+" ";      
        return str+"]";
    }

    public void inorder()                                  //以中根次序遍历二叉树，输出所有结点元素，非递归算法
    {
        System.out.print("["); 
        TriNode<T> p = this.first(this.root);              //寻找第一个访问结点，最小值
        while (p!=null)
        {
            System.out.print(p.data.toString()+" ");
            p = this.next(p);                              //返回p在中根次序下的前驱结点
        }
        System.out.println("]");
    }

    //在以p为根的子树中，返回中根次序下第一个访问结点，即是根的最左边的子孙结点，最小值
    public TriNode<T> first(TriNode<T> p)
    {
        if (p!=null)
            while (p.left!=null)
                p = p.left;
        return p;
    }
    
    public TriNode<T> next(TriNode<T> p)                   //返回p在中根次序下的后继结点
    {
        if (p!=null)
        {
            if (p.right!=null)                             //若p有右孩子，
                return this.first(p.right);                //则p的后继是其右子树第一个访问结点
            while (p.parent!=null)                         //若p没有右孩子，向上寻找某个祖先结点
            {
                if (p.parent.left==p)                      //若p是其父母的左孩子，则p的后继是其父母
                    return p.parent;
                p=p.parent;
            }
        }
        return null;
    }

    //【思考题8-4】
    //中根次序遍历二叉树（逆序），输出所有结点元素。
    //迭代算法从中根次序下最后一个访问结点（最大值）开始，依次到达前驱结点再访问。
    public void inorderPrevious()
    {
        System.out.print("["); 
        for (TriNode<T> p=this.last(this.root);  p!=null;  p=this.previous(p)) 
            System.out.print(p.data.toString()+" ");
        System.out.println("]");
    }
    //在以p为根的子树中，返回中根次序下最后一个访问结点，即是根的最右边的子孙结点，最大值
    public TriNode<T> last(TriNode<T> p)
    {
        if (p != null)
            while (p.right != null)
                p = p.right;
        return p;
    }
    public TriNode<T> previous(TriNode<T> p)               //返回p在中根次序下的前驱结点
    {
        if (p != null)
        {
            if (p.left!=null)                              //若p有左孩子，则p的前驱是其左子树最后一个访问结点
                return this.last(p.left);
            while (p.parent!=null)                         //若p没有左孩子，向上寻找某个祖先结点
            {
                if (p.parent.right==p)                     //若p是其父母的右孩子，则p的前驱是其父母
                    return p.parent;
                p=p.parent;
            }
        }
        return null;
    }
    
    public boolean contains(T key)                         //判断是否包含关键字为key元素
    {
        return this.searchNode(key)!=null;
    }
    public void addAll(T[] values)                         //插入values数组所有元素
    {
        for (int i=0; i<values.length; i++)
            this.add(values[i]);                           //插入元素
    }
    public void clear()                                    //删除所有元素
    {
        this.root=null;                                    //Java自动释放不再被使用的存储单元
    }

    public int size()                                      //返回元素个数
    {
        return 0;//??this.set.size(); 
    }
    //【例8.4】  使用二叉排序树表示互异的排序集合。
    
    //6.  删除操作
    //删除关键字为key结点，返回被删除元素；若没找到则不删除，返回null。//非递归算法，若key==null，Java抛出空对象异常
    public T remove(T key)    
    {
        TriNode<T> p = this.searchNode(key);               //查找关键字为key元素，若查找成功，返回结点，否则返回null
        if (p!=null && p.left!=null && p.right!=null)      //找到待删除结点p，若p是2度结点
        {
            TriNode<T> insucc = this.first(p.right);       //寻找p在中根次序下的后继结点insucc
            T temp = p.data;                               //交换待删除元素，作为返回值
            p.data = insucc.data;                          //以后继结点值替换p结点值
            insucc.data = temp;
            p = insucc;                                    //转化为删除insucc，删除1、0度结点
        }
        
        if (p!=null && p==this.root)                       //p是1度或叶子结点，删除根结点，p.parent==null
        {
            if (this.root.left!=null)
                this.root = p.left;                        //以p的左孩子顶替作为新的根结点
            else
                this.root = p.right;                       //以p的右孩子顶替作为新的根结点
            if (this.root!=null)
                this.root.parent = null;
            return p.data;                                 //返回被删除根结点元素
        }
        
        if (p!=null && p==p.parent.left)                   //p是1度或叶子结点，p是父母的左孩子
            if (p.left!=null)
            {
                p.parent.left = p.left;                    //以p的左孩子顶替
                p.left.parent = p.parent;                  //p的左孩子的parent域指向p的父母
            }
            else
            {
               p.parent.left = p.right;                    //以p的右孩子顶替
                if (p.right!=null)
                    p.right.parent = p.parent;
            }
        
        if (p!=null && p==p.parent.right)                  //p是1度或叶子结点，p是父母的右孩子
            if (p.left!=null)
            {
                p.parent.right = p.left;                   //以p的左孩子顶替
                p.left.parent = p.parent;
            }
            else
            {
               p.parent.right = p.right;                  //以p的右孩子顶替
                if (p.right!=null)
                    p.right.parent = p.parent;
            }
        return p!=null ? p.data : null;
    }
    public T removeRoot()                                 //删除根结点，返回原根结点元素
    {
        return this.remove(this.root.data);
    }
    
    //【实验题8-2】
    public void printASL()                                 //输出平均查找长度ASL（查找成功）及计算公式，二叉树的层次遍历算法
    {
        System.out.print("ASL成功=(");
//        SeqQueue<TriNode<T>> que=new SeqQueue<TriNode<T>>();  //创建空队列
        LinkedQueue<TriNode<T>> que=new LinkedQueue<TriNode<T>>();
        int asl=0, n=0, count=0, level=1;
        for (TriNode<T> p=this.root;  p!=null;  p=que.poll())   //按层次遍历二叉树，根结点没有入队
        {
            if (level(p)==level)                           //若p结点层次为当前层次，则计数
                 n++;                                      //当前层的结点个数
            else
            {
                System.out.print((asl==0 ? "" : "+")+level+"*"+n);//输出上一层的计算公式
                asl+=level*n;
                count+=n;                                  //二叉树的结点个数
                level++;                                   //深一层
                n=1;
            }
            if (p.left!=null)    
                que.add(p.left);                           //p的左孩子结点入队
            if (p.right!=null)
                que.add(p.right);                          //p的右孩子结点入队
        }
        if (count==0)
            System.out.println(") = 0");
        else
        {
            System.out.print("+"+level+"*"+n);             //最后一层
            asl+=level*n;
            count+=n;
            System.out.println(")/"+count+" ="+asl+"/"+count+" ="+((asl+0.0)/count));
        }
    }   
    
    //返回p结点所在的层次，令根结点的层次为1，若空树或未查找到x返回0
    private int level(TriNode<T> p)
    { 
        int level = 0;
        while (p!=null)
        {   level++;
            p=p.parent;
        }
        return level;
    }
}
//@author：Yeheya。2015-3-20
  
