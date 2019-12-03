//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月28日
//10.1 集合框架
//10.1.4  映射
//【思考题10-2】 分别使用java.util中的散列映射和树映射，实现例8.3和例8.5，统计文本中各单词的出现次数。
//算法同【实验题8-5】

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Text                                //文本操作类
{
    //统计text中各字符的出现次数，返回Map<K,V>映射对象，字符作为关键字K，统计次数作为值V
	//算法同例8.3和例8.5
    public static Map<String, Integer> charCount(String text) 
    {
        Map<String, Integer> map = new HashMap<String, Integer>();//声明接口对象map，引用实现该接口的类的实例
//        Map<?,?> map = new HashMap<String, Integer>();//声明接口对象map，引用实现该接口的类的实例
        //散列表默认容量16，参数没有用，table=null，装填因子为0.75
//        Map<String, Integer> map = new TreeMap<String, Integer>(); //默认K实现Comparable<K>接口
        for (int i=0; i<text.length(); i++)                //逐个字符查找计数
        {
            String key = text.substring(i,i+1);            //字符作为关键字
            Integer value = map.get(key);                  //获得指定字符映射的值
            int count = value==null ? 0 : value.intValue();//转换成int整数
            map.put(key, new Integer(count+1));            //增加计数，关键字相同时，替换元素
        }
        return map;
    }	

    //将从text中统计出的各单词及其出现次数存储在散列表中。算法同上charCount(String text) 
    public static Map<String, Integer> wordCount(String[] words) 
    {
        Map<String, Integer> map = new HashMap<String, Integer>();
//        Map<String, Integer> map = new TreeMap<String, Integer>();
        for (int i=0; i<words.length; i++)
        {
            Integer iobj = (Integer)map.get(words[i]);
            int count = iobj==null ? 0 : iobj.intValue();
            map.put(words[i], new Integer(count+1));
        }
        return map;
    }

    //将从text中统计出的各单词及其出现次数存储在散列表中。算法同上charCount(String text) 
    public static Map<String, Integer> wordCount(String text)
    {
        Map<String, Integer> map = new HashMap<String, Integer>();
//        Map<String, Integer> map = new TreeMap<String, Integer>(); //默认K实现Comparable<K>接口
        int i=0; 
        while (i<text.length())                //逐个单词查找计数
        {
            int end = text.indexOf(' ',i);
            if (end==-1)
                end=text.length();
        	String key = text.substring(i,end);            //字符作为关键字
            Integer value = map.get(key);                  //获得指定字符映射的值
            int count = value==null ? 0 : value.intValue();//转换成int整数
            map.put(key, new Integer(count+1));            //增加计数，关键字相同时，替换元素
            i=end+1;
        }
        return map;
//        System.out.println("单词及其出现次数："+set.toString());
    }
}
