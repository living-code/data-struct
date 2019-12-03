//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月25日
//3.2.2   常量字符串类
//3.3   串的模式匹配
//【思考题3-4，实验题3-13】改错

public class MyString_replaceAll 
{
    public static void main(String args[]) 
    {
        MyString target=new MyString("AABABBABAC"), pattern=new MyString("AB"), str=new MyString("ABA");

        System.out.println("\""+target+"\".replaceAll(\""+pattern+"\", \""+str+"\")=\""+target.replaceAll(pattern, str)+"\"");
        pattern=new MyString("ABA");               //模式串
        str=new MyString("");          //替换串
        System.out.println("\""+target+"\".replaceAll(\""+pattern+"\", \""+str+"\")=\""+
                target.replaceAll(pattern, str)+"\"");
    }
}
/*
"AABABBABAC".replaceAll("AB", "ABA")="AABAABABAABAAC"//??
"AABABBABAC".replaceAll("ABA", "")="ABBC"


//图3.11，替换子串，例3.3数据
"ababdabcdabcabc".replaceFirst("abc", "xy")=ababdxydabcabc
"ababdabcdabcabc".replaceAll("abc", "xy")=ababdxydxyxy

//图3.11，替换子串，例3.4数据
"aaaa".replaceFirst("a", "ab")=abaaa
"aaaa".replaceAll("a", "ab")=abababab


//Brute-Force模式匹配算法
//MyString target=new MyString("abbabaaba"), pattern=new MyString("aba");//图3.10
//MyString target=new MyString("aabaaa"), pattern=new MyString("aab");   //最好情况
//MyString target=new MyString("aaaaaa"), pattern=new MyString("aab");     //最坏情况
//System.out.println("\""+target+"\".indexOf_BF(\""+pattern+"\")="+target.indexOf_BF(pattern));
}
*/