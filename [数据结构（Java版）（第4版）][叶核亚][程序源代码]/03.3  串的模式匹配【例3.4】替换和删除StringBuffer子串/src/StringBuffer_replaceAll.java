//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年6月30日
//3.3   串的模式匹配
//3.3.1 Brute-Force算法
//3.3.2 模式匹配应用
//【例3.4】  对java.lang.StringBuffer字符串进行替换和删除子串操作。
    //【思考题3-5】

public class StringBuffer_replaceAll
{
    //（1）替换子串
    //将target串中所有与pattern匹配的子串全部替换成str，返回替换后的target串
    public static StringBuffer replaceAll(StringBuffer target, String pattern, String str)
    {
        int i=target.indexOf(pattern);
        while (i!=-1)
        {
            target.delete(i, i+pattern.length());
            target.insert(i, str);
            i=target.indexOf(pattern, i+str.length());
//            i=target.indexOf(pattern, i+1);            //错
        }
        return target;
    } 

    //【思考题3-5】
    //将target串中首个与pattern匹配的子串替换成replacement，返回替换后的target串
    public static StringBuffer replaceFirst(StringBuffer target, String pattern, String replacement)
    {
        int i=target.indexOf(pattern);
        if(i!=-1)
        {
            target.delete(i, i+pattern.length());          //删除i～i+pattern.length()-1的子串
            target.insert(i, replacement);                 //在第i个字符处插入replacement串
        }
        return target;
    } 

    //删除target串中首个与pattern匹配的子串，返回删除后的target串
    public static StringBuffer deleteFirst(StringBuffer target, String pattern)
    {
        int i=target.indexOf(pattern);
        if(i!=-1)
            target.delete(i, i+pattern.length()); 
        return target;
    }
    //删除target串中所有与pattern匹配的子串，返回删除后的target串
    public static StringBuffer deleteAll(StringBuffer target, String pattern)
    {
        int i=target.indexOf(pattern);
        while (i!=-1)
        {
            target.delete(i, i+pattern.length());
            i=target.indexOf(pattern, i);
        }
        return target;
    }
    

    //【例3.4】  （2） 删除子串，每字符移动一次
    //删除target串中所有与pattern匹配的子串，返回删除后的target串
    public static StringBuffer removeAll(StringBuffer target, String pattern)
    {
        int n=target.length(), m=pattern.length();
        int empty=target.indexOf(pattern), next=empty;     //empty为首个与pattern匹配子串序号
        while (next!=-1)                                   //循环每次删除一个匹配子串
        {
            int move=next+m;                               //move为待移动子串序号
            next = target.indexOf(pattern, move);          //next为从move开始的下个匹配子串序号
            while (next>0 && move<next || next<0 && move<n)//将move～next-1之间子串向前移动到empty处
                target.setCharAt(empty++, target.charAt(move++));
        }
        if (empty!=-1)
            target.setLength(empty);                       //设置target串长度为empty        
        return target;
    }

    public static void main(String args[]) 
    {
        StringBuffer target = new StringBuffer("aaaa");    //例3.4（1）替换子串
        String pattern="a", str="ab";
        System.out.println("replaceAll(\""+target+"\", \""+pattern+"\", \""+str+"\")=\""+
                replaceAll(target, pattern, str)+"\"");

    	target = new StringBuffer("ababccdefabcabcgh");    //图3.13
        pattern="abc";
        System.out.println("removeAll(\""+target+"\", \""+pattern+"\")=\""+removeAll(target, pattern)+"\"");
        System.out.println("removeAll(\""+target+"\", \""+pattern+"\")=\""+removeAll(target, pattern)+"\"");
    }
}
/*
程序运行结果如下：
replaceAll("aaaa", "a", "ab")="abababab"                   //例3.4（1）替换子串
removeAll("ababccdefabcabcgh", "abc")="abcdefgh"           //图3.13
removeAll("abcdefgh", "abc")="defgh"


*/
/*
程序设计说明，实验题3-13解答。
1、replaceAll()方法
       如果while中语句如下，当pattern="a", replacement="ab"时，死循环。
    i=target.indexOf(pattern, i);
    如果while中语句如下，当pattern="a", replacement="aab"时，死循环。
    i=target.indexOf(pattern, i+1);
    

    
*/

