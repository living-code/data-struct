//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月20日
//6.3   线索二叉树

public class ThreadNode<T>                       //线索二叉树的二叉链表结点类，T指定结点的元素类型
{
    public T data;                               //数据元素
    public ThreadNode<T> left, right;            //分别指向左、右孩子结点
    public boolean ltag, rtag;                   //分别表示左、右线索标记，false表示孩子，true表示线索

    //构造结点，各参数依次指定元素、左孩子结点及左线索标记、右孩子结点及右线索标记
    public ThreadNode(T data, ThreadNode<T> left, boolean ltag, ThreadNode<T> right, boolean rtag)
    {
        this.data = data;
        this.left = left;
        this.ltag = ltag;
        this.right = right;
        this.rtag = rtag;
    }
    //构造值为data结点，默认左和右孩子结点为空，线索标志为false
    public ThreadNode(T data)
    {
        this(data, null, false, null, false);
    }
    public String toString()                     //返回结点数据域的描述字符串
    {
        return this.data.toString();
    }
    //哪里用到??
    public boolean isLeaf()                      //判断是否叶子结点
    {
        return !this.ltag && !this.rtag;         
    }
}


// @author  Yeheya。2014-7-20

/*    //可声明以下方法
    public ThreadNode()
    {
        this(null, null, 0, null, 0);
    }
    
    public boolean equals(Object obj)            //比较两个结点值是否相等，覆盖Object类的equals(obj)方法
    {
        return obj==this || obj instanceof ThreadNode && this.data.equals(((ThreadNode<T>)obj).data);
    }    
}
*/

