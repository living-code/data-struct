//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月28日
//10.1 集合框架
//10.1.4  映射
//【思考题10-2】 分别使用java.util中的散列映射和树映射，实现例8.3和例8.5，统计文本中各单词的出现次数。

import java.util.*;
public class Text_ex 
{
	public static void main(String[] args) 
	{
/*
		//      String text="AAAABBBCDDBBAAA";                     //例6.4数据
//      String text="CDAAAABBBDBBAAA";                     //例6.4数据，散列表没差别
        String text="class HashSet";                       //图8.12数据（同C++第3版）
//        String text="public class";                        //第3版图8.12数据
        Map<String, Integer> map = Text.charCount(text); //统计text中各字符的出现次数
        System.out.println("text=\""+text+"\"");
        System.out.println("map="+map.getClass().getName()+map.toString()+"，map.size()="+map.size());            
        System.out.println("map.keySet()="+map.keySet());  //返回关键字集合Set<K>
        System.out.println("map.values()="+map.values());
*/
    
//      String[] words ={"and", "begin", "case", "if", "and","public","class","char","count"};
//      Map<String, Integer> map = Text.wordCount(words);                //统计text中各字符的出现次数

      String wordtext="public class and begin case if and public class char count public class";
      Map<String, Integer> map = Text.wordCount(wordtext);                //统计text中各字符的出现次数
      System.out.println("map="+map.getClass().getName()+map.toString()+"，map.size()="+map.size());            
      System.out.println("map.keySet()="+map.keySet());  //返回关键字集合Set<K>
      System.out.println("map.values()="+map.values());
		
	}

}
/*
程序运行结果如下：
text="CDAAAABBBDBBAAA"
map=java.util.HashMap{A=7, B=5, C=1, D=2}
map.keySet()=[A, B, C, D]
map.values()=[7, 5, 1, 2]

text="class HashSet"
map=java.util.HashMap{ =1, a=2, c=1, s=3, S=1, t=1, e=1, H=1, h=1, l=1}
map.keySet()=[ , a, c, s, S, t, e, H, h, l]
map.values()=[1, 2, 1, 3, 1, 1, 1, 1, 1, 1]


map=java.util.HashMap{public=3, and=2, char=1, count=1, class=3, begin=1, if=1, case=1}，map.size()=8
map.keySet()=[public, and, char, count, class, begin, if, case]
map.values()=[3, 2, 1, 1, 3, 1, 1, 1]

 */
/*
map：{and=2, begin=1, case=1, if=1}
map.keySet()：[and, begin, case, if]
map.values()：[2, 1, 1, 1]

关键字相同时替换，两者都:
map：{A=1}，map.size()=1
map：{A=2}，map.size()=1
map：{A=3}，map.size()=1
map：{A=4}，map.size()=1
map：{A=4, B=1}，map.size()=2
map：{A=4, B=2}，map.size()=2
map：{A=4, B=3}，map.size()=2
map：{A=4, B=3, C=1}，map.size()=3
map：{A=4, B=3, C=1, D=1}，map.size()=4
map：{A=4, B=3, C=1, D=2}，map.size()=4
map：{A=4, B=4, C=1, D=2}，map.size()=4
map：{A=4, B=5, C=1, D=2}，map.size()=4
map：{A=5, B=5, C=1, D=2}，map.size()=4
map：{A=6, B=5, C=1, D=2}，map.size()=4
map：{A=7, B=5, C=1, D=2}，map.size()=4
map：{A=7, B=5, C=1, D=2}
map.keySet()：[A, B, C, D]
map.values()：[7, 5, 1, 2]
map：{and=2, begin=1, case=1, if=1}
map.keySet()：[and, begin, case, if]
map.values()：[2, 1, 1, 1]


java.util.HashMap{D=2, A=7, B=5, C=1}
map.keySet()：[D, A, B, C]
map.values()：[2, 7, 5, 1]
Huffman树的结点数组:(2,4,-1,-1)，(7,6,-1,-1)，(5,5,-1,-1)，(1,4,-1,-1)，(3,5,3,0)，(8,6,4,2)，(15,-1,1,5)，
Huffman编码： D：101，A：0，B：11，C：100，
将AAAABBBCDDBBAAA压缩为00001111111001011011111000，26位
将00001111111001011011111000解码为AAAABBBCDDBBAAA


java.util.TreeMap{A=7, B=5, C=1, D=2}
Huffman树的结点数组:(7,6,-1,-1)，(5,5,-1,-1)，(1,4,-1,-1)，(2,4,-1,-1)，(3,5,2,3)，(8,6,4,1)，(15,-1,0,5)，
Huffman编码： A：0，B：11，C：100，D：101，
将AAAABBBCDDBBAAA压缩为00001111111001011011111000，26位
将00001111111001011011111000解码为AAAABBBCDDBBAAA


//@author：Yeheya。2014-8-25
/*
程序运行结果如下：
AAAABBBCDDBBAAA
字符及其出现次数：((A,7))
((B,5))
((C,1))
((D,2))

public class
字符及其出现次数：((l,2))
((a,1))
((b,1))
((c,2))
((p,1))
((s,2))
(( ,1))
((u,1),(i,1))

public class CharCount
字符及其出现次数：((n,1))
((C,2),(o,1))
((p,1))
((r,1))
((s,2))
((t,1))
((u,2))
((a,2))
((b,1),( ,2))
((c,2))
((h,1))
((i,1))
((l,2))


public class HashMap_CharWeight
字符及其出现次数：((l,2))
((p,1))
(( ,2))
((r,1),(W,1))
((s,3))
((t,1))
((u,1))
((C,1))
((a,3))
((b,1))
((c,2),(H,1))
((e,1))
((g,1))
((h,3))
((i,2))


 */
//@author：Yeheya。2014-8-15
