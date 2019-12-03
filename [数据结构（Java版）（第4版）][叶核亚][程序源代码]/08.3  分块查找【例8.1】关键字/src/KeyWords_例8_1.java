//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月14日
//8.3 分块查找
//【例8.1】 采用扩充索引表查询Java关键字。
//排序数组，使用扩充索引表

public class KeyWords_例8_1  
{
    //排序关键字表（升序），主表
    private static String[] keywords={"abstract","assert","boolean","break","byte","case","catch",
        "char","class","continue","default","do","double","else","extends","false","final","finally",
        "float","for","if","implements","import","instanceof","int","interface","long","native","new",
        "null","package","private","protected","public","return","short","static","super","switch",
        "synchronized","this","throw","throws","transient","true","try","void","volatile","while"};

    private static class IndexItem implements Comparable<IndexItem>  //索引项，私有内部类
    {
        char first;                                        //关键字的首字符
        int begin,end;                                     //首字符相同的关键字块在主表中的始末下标
        public IndexItem(char first, int begin, int end)
        {
            this.first = first;
            this.begin = begin;
            this.end = end;
        }
        public String toString()                           //返回索引项的描述字符串
        {
            return "("+this.first+","+begin+","+end+")";
        }
        public int compareTo(IndexItem item)               //索引项比较相等和大小，实现Comparable接口
        {
            return this.first - item.first;                //仅比较首字符
        }
    }//内部类结束

    private static IndexItem[] index;                      //索引表
    static                                                 //创建扩充索引表；静态初始化块，类加载时执行一次
    {
        index = new IndexItem[23];
        for (int i=0, j=0; i<index.length && j<keywords.length; i++)
        {
            char ch=(char)('a'+i);                         //下一个首字符
            if (keywords[j].charAt(0)>ch)
                index[i]=new IndexItem(ch, -1, -1);        //创建索引项表示一个不存在的块
            else
            { 
                int begin = j++;
                while (j<keywords.length && keywords[j].charAt(0)==ch)//寻找下一个首字符不同的关键字
                    j++;
                index[i]=new IndexItem(ch, begin, j-1);    //创建索引项表示一个首字符相同的块
            }
        }
        
        System.out.print("index[]:");
        Array1.print(index);                             //输出对象数组，见例1.4
    }
    
    public static boolean isKeyword(String str)            //判断str是否为Java关键字
    {
        int i = str.charAt(0)-'a';                         //首字符对应的索引项序号
        return i>=0 && i<index.length && index[i].begin!=-1 &&
            SortedArray.binarySearch(keywords, index[i].begin, index[i].end, str)>=0;
    }//获得主表查找范围的下界//获得主表查找范围的上界   //折半查找主表的指定范围
 
    public static void main(String[] args) 
    {                                         //默认首先进行静态初始化，建立索引表
        String[] str={"and","final","length", "while","x"};
        for (int i=0; i<str.length; i++)
           System.out.println(str[i]+(isKeyword(str[i])?"":"不")+"是关键字");
    }
}

/*
程序运行结果如下：
index[]: (a,0,1) (b,2,4) (c,5,9) (d,10,12) (e,13,14) (f,15,19) (g,-1,-1) (h,-1,-1) (i,20,25) (j,-1,-1) (k,-1,-1) (l,26,26) (m,-1,-1) (n,27,29) (o,-1,-1) (p,30,33) (q,-1,-1) (r,34,34) (s,35,39) (t,40,45) (u,-1,-1) (v,46,47) (w,48,48)
abstract? assert? and不是关键字
finally? false? final? final是关键字
long? length不是关键字
while? while是关键字
x不是关键字

*/

/*
程序设计说明如下：
测试，采用排序顺序表存储关键字表，但尾插入需要遍历顺序表，效率较低。放弃。
*/
//@author：Yeheya。2014-8-14
