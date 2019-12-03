//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月22日
//6.4  Huffman树

public class TriElement                          //二叉树的静态三叉链表结点类
{
    int data;                                    //数据域
    int parent,left,right;                       //父母结点和左、右孩子结点下标
	
    //构造结点，各参数依次指定元素、父母结点下标、左/右孩子结点下标
	public TriElement(int data, int parent, int left, int right)
	{					
	    this.data = data;
	    this.parent = parent;
	    this.left = left;
	    this.right = right;
	}
	public TriElement(int data)                  //构造元素值为data、无父母的叶子结点
	{					
	    this(data, -1, -1, -1);
	}
    public String toString()                     //返回结点的描述字符串
    {
        return "("+this.data+","+this.parent+","+this.left+","+this.right+")";
    }
    public boolean isLeaf()                                //判断是否叶子结点
    {
        return this.left==-1 && this.right==-1;
    }
}
/* 以下没有用到
	public TriElement()
	{					
	    this(0, -1, -1, -1);
	}
    public boolean equals(Object obj)                      //比较是否相等 ，覆盖Object类的equals(obj)方法
    {                                                      //仅比较元素值
        return obj==this || obj instanceof TriElement && this.data==((TriElement)obj).data;
    }
}
*/
//@author  Yeheya。2014-7-21
