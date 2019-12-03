//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月15日
//8.5.2  树映射
//【例8.5】采用二叉排序树映射存储，统计文本中各字符的出现次数。

public class TreeMap_charCount
{
    //统计text中各字符的出现次数，返回Map<String, Integer>树映射，从字符串到整数的映射，
    //元素按关键字升序排序
    public static Map<String, Integer> charCount(String text) 
    {
        System.out.print("text=\""+text+"\"\n字符及其出现次数：");
        Map<String,Integer> map = new TreeMap<String,Integer>();
        for (int i=0; i<text.length(); i++)                //逐个字符查找计数，算法同例8.3
        {
            String key = text.substring(i,i+1);            //获得1个字符，作为关键字
            Integer value = map.get(key);                  //获得关键字key（字符）映射的值
            int count = value==null ? 0 : value.intValue();//转换成int整数
            map.put(key, new Integer(count+1));            //增加计数，关键字相同时，替换值
        }
        return map;
    }

    public static void main(String[] args) 
    {
//        String text="AAAABBBCDDBBAAA";           //例6.4数据
//        String text="CDAAAABBBDBBAAA";           //例6.4数据，没差别
        String text="public class";               //图8.21数据
//      String text="class HashSet";              //数据（同C++第3版）
        System.out.println(charCount(text).toString());
    }
}
/*
程序运行结果如下：
text="public class"                                //图8.21数据
字符及其出现次数：[( ,1) (a,1) (b,1) (c,2) (i,1) (l,2) (p,1) (s,2) (u,1) ]

text=CDAAAABBBDBBAAA                             //例6.4数据
字符及其出现次数：(A,7) (B,5) (C,1) (D,2) 

text=class HashSet                           //图8.12数据（同C++第3版）
字符及其出现次数：( ,1) (H,1) (S,1) (a,2) (c,1) (e,1) (h,1) (l,1) (s,3) (t,1) 

 */
//@author：Yeheya。2014-8-16
