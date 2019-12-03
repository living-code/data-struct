//《数据结构（Java版）（第4版）》，作者：叶核亚，2015年2月7日
//3.3.2   KMP算法

public class KMP 
{
//	private static int count=0;                            //记载比较次数
	private static int[] next;                             //模式串pattern改进的next数组
	private static int[] nextk;                            //模式串pattern未改进的next数组

    //返回目标串target中首个与模式串pattern匹配的子串序号，匹配失败时返回-1
    public static int indexOf(String target, String pattern)
    {
        return indexOf(target, pattern, 0);
    }
    
    //返回目标串target从begin开始首个与模式串pattern匹配的子串序号，匹配失败时返回-1。
    //0≤begin<target.length()。对begin容错，若begin<0，从0开始；若begin序号越界，查找不成功。
    //若target、pattern为null，抛出空对象异常。
    public static int indexOf(String target, String pattern, int begin)
    {
        int n=target.length(), m=pattern.length();
        if (begin<0)                                       //对begin容错，若begin<0，从0开始
            begin = 0;
        if (n==0 || n<m || begin>=n)                       //若目标串空、较短或begin越界，不需比较
            return -1;

        int count=0;                                       //记载比较次数
        nextk = getNextk(pattern);
        print(pattern);
        System.out.print("nextk[]: ");  print(nextk);
        next = getNext(pattern);                           //返回模式串pattern改进的next数组
        System.out.print("next[]:  ");  print(next);

        int i=begin, j=0;                                  //i、j分别为目标串、模式串比较字符下标
        while (i<n && j<m)
        {
            if(j!=-1) count++;
            if (j==-1 || target.charAt(i)==pattern.charAt(j))//若当前两字符相等，则继续比较后续字符
            {
                if (j!=-1)
                    System.out.print("t"+i+"=p"+j+"，");
                i++;
                j++;
            }
            else                                           //否则，下次匹配，目标串下标i不回溯
            {
                System.out.println("t"+i+"!=p"+j+"，next["+j+"]="+next[j]);
                j=next[j];                                 //模式串下标j退回到下次比较字符序号
                if (n-i+1<m-j+1)                           //若目标串剩余子串的长度不够，不再比较，   //比第3版增加此句
                    break;
            }
        }
        System.out.println("\tKMP.count="+count);
        if (j==m)                                          //匹配成功
            return i-j;                                    //返回匹配的子串序号
        return -1;                                         //匹配失败
    }

    private static int[] getNextk(String pattern)          //返回模式串pattern的next数组
    {
        int j=0, k=-1, next[]=new int[pattern.length()];
        next[0]=-1;
        while (j<pattern.length()-1)
            if (k==-1 || pattern.charAt(j)==pattern.charAt(k))
            {
                j++;
                k++;
                next[j]=k;                                 //有待改进
            }
            else k=next[k];
        return next;
    }

    private static int[] getNext(String pattern)           //返回模式串pattern改进的next数组
    {
        int j=0, k=-1, next[]=new int[pattern.length()];
        next[0]=-1;
        while (j<pattern.length()-1)
            if (k==-1 || pattern.charAt(j)==pattern.charAt(k))
            {
                j++;
                k++;
                if (pattern.charAt(j)!=pattern.charAt(k))  //改进之处
                    next[j]=k;
                else
                    next[j]=next[k];  
            }
            else k=next[k];
        return next;
    }

    private static void print(int[] next)                  //输出next[]数组
    {
        for (int i=0; i<next.length; i++)
            System.out.print(String.format("%3d", next[i]));
        System.out.println();
    }
    private static void print(String pattern)
    {
        System.out.print("pattern: ");
        for (int i=0; i<pattern.length(); i++)
            System.out.print("  "+pattern.charAt(i));
        System.out.println();
    }

    public static void main(String args[]) 
    {
// 	      String target="abcabb", pattern="abb";             //图3.14（a）  目标串不回溯
//        String target="aacabb", pattern="aab";             //图3.14（b）  目标串不回溯
//        String target="abcdabcabbabcabc", pattern="abcabc"; //图3.15～图3.17
//        String target="abcabdabcabcaa", pattern="abcabdabcabcaa";  //表3-2，表3-4
    	
//        String target="aababcd", pattern="abcd";           //图3.11，BF用例
//        String target="aaaaa", pattern="aab";              //最坏情况，图3.12(b)BF；图3.18KMP

    	//习题解答
//        String target="aaabaaaba", pattern="aaaa";           //习3-9(2)BF，习图3.5~习图3.6
          String target="abcababcabababcababc", pattern="ababcababc"; //思考题3-6，习题解答3-10(6)，习图3.7
        
        System.out.println("KMP.indexOf(\""+target+"\", \""+pattern+"\")="+KMP.indexOf(target, pattern));
    }
}

/*
程序运行结果如下：
pattern:   a  b  b
nextk[]:  -1  0  0
next[]:   -1  0  0
t0=p0，t1=p1，t2!=p2                                         //匹配3次
t2!=p0
t3=p0，t4=p1，t5=p2，
KMP.count=7
KMP.indexOf("abcabb", "abb")=3                             //图3.14（a）  目标串不回溯


pattern:   a  a  b                                         //同表3-5
nextk[]:  -1  0  1
next[]:   -1 -1  1
t0=p0，t1=p1，t2!=p2                                         //匹配4次
t2!=p1
t3=p0，t4!=p1
t5!=p0
KMP.count=7
KMP.indexOf("aacabb", "aab")=-1                            //图3.14（b）  目标串不回溯


pattern:   a  b  c  a  b  c
nextk[]:  -1  0  0  0  1  2                                //表3-1
next[]:   -1  0  0 -1  0  0                                //表3-3
t0=p0，t1=p1，t2=p2，t3!=p3                                  //匹配4次
t4=p0，t5=p1，t6=p2，t7=p3，t8=p4，t9!=p5
t9!=p0
t10=p0，t11=p1，t12=p2，t13=p3，t14=p4，t15=p5，
KMP.count=17
KMP.indexOf("abcdabcabbabcabc", "abcabc")=10               //图3.15～图3.17


pattern:   a  b  c  a  b  d  a  b  c  a  b  c  a  a
nextk[]:  -1  0  0  0  1  2  0  1  2  3  4  5  3  4        //表3-2
next[]:   -1  0  0 -1  0  2 -1  0  0 -1  0  5 -1  4        //表3-4
KMP.count=14
KMP.indexOf("abcabdabcabcaa", "abcabdabcabcaa")=0


pattern:   a  b  c  d
nextk[]:  -1  0  0  0
next[]:   -1  0  0  0
t0=p0，t1!=p1                                               //KMP匹配3次，BF匹配4次
t1=p0，t2=p1，t3!=p2
t3=p0，t4=p1，t5=p2，t6=p3，
KMP.count=9
KMP.indexOf("aababcd", "abcd")=3                           //图3.11，BF用例

pattern:   a  a  b                                         //表3-5
nextk[]:  -1  0  1
next[]:   -1 -1  1
t0=p0，t1=p1，t2!=p2                                        //KMP匹配4次，BF匹配4次
t2=p1，t3!=p2
t3=p1，t4!=p2
	KMP.count=7
KMP.indexOf("aaaaa", "aab")=-1                             //最坏情况，图3.18，匹配不成功，比较n+m次


pattern:   a  a  a  a                                      //习题解答，习3-9(2)BF，习表3-1
nextk[]:  -1  0  1  2
next[]:   -1 -1 -1 -1

t0=p0，t1=p1，t2=p2，t3!=p3，next[3]=2                         //习图3.5（使用未改进的next数组）
t3!=p2，next[2]=1
t3!=p1，next[1]=0
t3!=p0，next[0]=-1
t4=p0，t5=p1，t6=p2，t7!=p3，next[3]=2
t7!=p2，next[2]=1
	KMP.count=12
KMP.indexOf("aaabaaaba", "aaaa")=-1

t0=p0，t1=p1，t2=p2，t3!=p3                                   //习图3.6（使用未改进的next数组）
t4=p0，t5=p1，t6=p2，t7!=p3
	KMP.count=8
KMP.indexOf("aaabaaaba", "aaaa")=-1


pattern:   a  b  a  b  c  a  b  a  b  c                    //思考题3-6，习题解答3-10(6)，习图3.7
nextk[]:  -1  0  0  1  2  0  1  2  3  4
next[]:   -1  0 -1  0  2 -1  0 -1  0  2
t0=p0，t1=p1，t2!=p2，next[2]=-1
t3=p0，t4=p1，t5=p2，t6=p3，t7=p4，t8=p5，t9=p6，t10=p7，t11=p8，t12!=p9，next[9]=2
t12=p2，t13=p3，t14=p4，t15=p5，t16=p6，t17=p7，t18=p8，t19=p9，	KMP.count=21
KMP.indexOf("abcababcabababcababc", "ababcababc")=10


*/
//@author：Yeheya。2015-2-26