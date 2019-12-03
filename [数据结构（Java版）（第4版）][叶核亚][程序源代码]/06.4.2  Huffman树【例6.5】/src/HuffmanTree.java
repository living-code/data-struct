//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月22日
//6.4  Huffman树

public class HuffmanTree                                   //Huffman树类
{
    private String charset;                                //字符集合
    private TriElement[] huftree;                          //静态三叉链表结点数组
 
    //构造Huffman树，weights指定权值集合，数组长度为叶子结点数；默认字符集合从A开始
    public HuffmanTree(int[] weights)
    {
        this.charset = "";
        for (int i=0; i<weights.length; i++)               //默认字符集合是从'A'开始的weights.length个字符
            this.charset += (char)('A'+i);    
        
        int n = weights.length;                            //叶子结点数
        this.huftree = new TriElement[2*n-1];              //n个叶子的Huffman树共有2n-1个结点
        for(int i=0; i<n; i++)                             //Huffman树初始化n个叶子结点
            this.huftree[i] = new TriElement(weights[i]);  //构造无父母的叶子结点

        for(int i=n; i<2*n-1; i++)                         //构造n-1个2度结点
        {
            int min1=Integer.MAX_VALUE, min2=min1;         //最小和次小权值，初值为整数最大值
            int x1=-1, x2=-1;                              //最小和次小权值结点下标
            for (int j=0; j<i; j++)                        //寻找两个无父母的最小权值结点下标
                if (this.huftree[j].parent==-1)            //第j个结点无父母
                    if (this.huftree[j].data<min1)         //第j个结点权值最小
                    {
                        min2 = min1;                       //min2记得次小权值
                        x2 = x1;                           //x2记得次小权值结点下标
                        min1 = this.huftree[j].data;       //min1记得最小权值
                        x1 = j;                            //x1记得最小权值结点下标
                    }
                    else
                        if (this.huftree[j].data<min2)     //第j个结点权值次小
                        {
                            min2 = huftree[j].data; 
                            x2 = j;
                        }

            this.huftree[x1].parent = i;                   //合并两棵权值最小的子树，左孩子最小
            this.huftree[x2].parent = i;
            this.huftree[i] = new TriElement(min1+min2, -1, x1, x2); //构造结点，指定值、父母、左右孩子
        }
    }
    
    private String getCode(int i)                 //返回charset第i个字符的Huffman编码字符串
    {
        int n=8;
        char hufcode[] = new char[n];                      //声明字符数组暂存Huffman编码
        int child=i, parent=this.huftree[child].parent;
        for (i=n-1; parent!=-1; i--)                       //由叶结点向上直到根结点，反序存储编码
        {
            hufcode[i] = (huftree[parent].left==child) ? '0' : '1';  //左、右孩子编码为0、1
            child = parent;
            parent = huftree[child].parent;        
        }                       
        return new String(hufcode,i+1,n-1-i);    //由hufcode数组从i+1开始的n-1-i个字符构造串
    }

    public String toString()                     //返回Huffman树的结点数组和所有字符的编码字符串
    {
        String str="Huffman树的结点数组:";
        for (int i=0; i<this.huftree.length; i++)
            str += this.huftree[i].toString()+"，";
        str += "\nHuffman编码： ";
        for (int i=0; i<this.charset.length(); i++)        //输出所有叶子结点的Huffman编码
            str+=this.charset.charAt(i)+"："+getCode(i)+"，";
        return str;
    }

    //数据压缩，将text各字符转换成Huffman编码存储，返回压缩字符串
    public String encode(String text)
    {
        String compressed="";                              //被压缩的数据，以字符串显示
        for (int i=0; i<text.length(); i++) 
            compressed += getCode(text.charAt(i)-'A');     //默认字符集是从A开始的n个字符
        return compressed;
    }

    //数据解压缩，将压缩compressed中的0/1序列进行Huffman译码，返回译码字符串
    public String decode(String compressed)
    {
        String text="";
        int node=this.huftree.length-1;               //node搜索一条从根到达叶子的路径
        for (int i=0; i<compressed.length(); i++) 
        {
            if (compressed.charAt(i)=='0')            //根据0、1分别向左或右孩子走
                node = huftree[node].left;
            else
                node = huftree[node].right;
            if (huftree[node].isLeaf())               //到达叶子结点
            {
                text += this.charset.charAt(node);    //获得一个字符
                node = this.huftree.length-1;         //node再从根结点开始
            }
        }
        return text;
    }
}

/*
程序设计说明如下。
（1）huftree声明为结点数组取可，不需要声明为顺序表，因为只有插入，没有删除和扩容等问题。
（2）构造方法中，求两个最小值不能省略min1、min2，否则没有初值，算法反而不清楚。
（3）只能采用默认字符集合，不支持以下声明，否则编码时，要查找指定字符还要花时间。
    //构造Huffman树，charset指定字符集合；weights[]指定权值集合，数组长度为叶子结点数
    public HuffmanTree(String charset, int[] weights)
    {
        if (charset==null)                       //默认字符集集合是从'A'开始的weights.length个字符        
        {……
        }
        else
            this.charset = charset;                        //指定字符集合

（4）放弃转换成二进制，要用位运算，太长，也难，且转移重点。课程设计题
（5）不能用最小堆选择最小值，因为不仅要选择最小值，同时还要记得最小值所在位置，才能建立链接关系。而最小堆只能选最小值。
*/
//@author  Yeheya。2014-7-22