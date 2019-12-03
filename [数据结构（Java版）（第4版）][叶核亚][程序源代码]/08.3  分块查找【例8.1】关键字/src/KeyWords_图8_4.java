//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月14日
//8.3 分块查找
//【例8.1】 判断给定字符串是否为Java关键字。
//【思考题8-2】数组，索引表

public class KeyWords_图8_4  
{
    //关键字表
    private static String[] keywords={"abstract","assert","boolean","break","byte","case","catch",
        "char","class","continue","default","do","double","else","extends","false","final","finally",
        "float","for","if","implements","import","instanceof","int","interface","long","native","new",
        "null","package","private","protected","public","return","short","static","super","switch",
        "synchronized","this","throw","throws","transient","true","try","void","volatile","while"};

    private static class IndexItem implements Comparable<IndexItem>  //索引项，私有内部类
    {
        String first;                                      //关键字的首字母
        int begin;                                         //首字母相同的关键字块在主表中的起始下标
        public IndexItem(String first,int i)
        {
            this.first=first;
            begin=i; 
        }
        public String toString()                           //返回索引项的描述字符串
        {
            return "("+this.first+","+begin+")";
        }
        public int compareTo(IndexItem item)               //约定两个索引项比较大小的规则，实现Comparable接口
        {
            return this.first.compareTo(item.first);       //按首字母比较大小
        }
    }//内部类结束

    private static IndexItem index[];                      //索引表
    static                                                 //静态初始化，建立索引表
    {
        index = new IndexItem[26];
        int i=0,j=0;
        for (i=0; i<index.length && j<keywords.length; i++)
        {
            char ch=keywords[j].charAt(0);
            index[i]=new IndexItem(ch+"",j);
            j++;
            while (j<keywords.length && keywords[j].charAt(0)==ch)
                j++;
        }
        
        System.out.print("index[]:");
        Array1.print(index);                        //见例1.4
/*        for (i=0; i<index.length; i++)
            if (index[i]!=null)
                System.out.print(index[i].toString()+" ");
        System.out.println();*/
    }

    public static boolean isKeyword(String str)            //判断str是否为Java关键字
    {
        IndexItem item = new IndexItem(str.substring(0,1),-1);   //首字母对应的索引项
        int pos=SortedArray.binarySearch(index, item);               //折半查找索引表，获得索引项位置
        int begin=index[pos].begin;                                //获得主表查找范围的下界
        int end=index[pos+1].begin-1;                           //获得主表查找范围的上界
        return SortedArray.binarySearch(keywords,begin,end,str)>=0;   //折半查找主表指定范围
    }
        
    public static void main(String[] args) 
    {                                            //默认首先进行静态初始化，建立索引表
        String str="final";
        System.out.println(str+(isKeyword(str)?"":"不")+"是关键字");
        str ="length";
        System.out.println(str+(isKeyword(str)?"":"不")+"是关键字");
    }
}

/*
程序运行结果如下：
index[]:(a,0) (b,2) (c,5) (d,10) (e,13) (f,15) (i,20) (l,26) (n,27) (p,30) (r,34) (s,35) (t,40) (v,46) (w,48) 
(t,40)? (f,15)? finally? false? final? final是关键字
(t,40)? (f,15)? (n,27)? (i,20)? (l,26)? long? length不是关键字

*/

