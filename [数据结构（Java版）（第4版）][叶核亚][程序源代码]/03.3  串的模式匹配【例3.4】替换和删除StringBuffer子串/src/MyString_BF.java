//《数据结构（Java版）（第5版）》，作者：叶核亚，2015年2月7日
//3.3   串的模式匹配
//3.3.1 Brute-Force算法        

public class MyString_BF 
{
    public static void main(String args[]) 
    {
//        MyString target=new MyString("aababcd"), pattern=new MyString("abcd"); //图3.11，匹配成功
//        MyString target=new MyString("abcdabc"), pattern=new MyString("abcd"); //图3.12(a)，匹配成功，最好情况  	
//        MyString target=new MyString("aaaaa"), pattern=new MyString("aab");      //图3.12(b)，最坏情况，匹配不成功

    	//习题解答
        MyString target=new MyString("aaabaaaba"), pattern=new MyString("aaaa"); //习3-9(2)BF，习图3.4

        System.out.println("\""+target+"\".indexOf(\""+pattern+"\")="+target.indexOf(pattern));
    }
}
/*
程序运行结果如下：
t0=p0，t1!=p1                                               //匹配4次
t1=p0，t2=p1，t3!=p2
t2!=p0
t3=p0，t4=p1，t5=p2，t6=p3，	BF.count=10
"aababcd".indexOf("abcd")=3                                //图3.11，匹配成功


t0=p0，t1=p1，t2=p2，t3=p3，	BF.count=4                     //匹配1次
"abcdabc".indexOf("abcd")=0                                //图3.12(a)，匹配成功，最好情况


t0=p0，t1=p1，t2!=p2                                         //匹配n-m+1=3次
t1=p0，t2=p1，t3!=p2
t2=p0，t3=p1，t4!=p2
	BF.count=9                                              //比较(n-m+1)*m次，O(n*m)
"aaaaa".indexOf("aab")=-1                                   //图3.12(b)，最坏情况，匹配不成功


t0=p0，t1=p1，t2=p2，t3!=p3                                  //习3-9(2)BF，匹配5次，习题解答图3.4
t1=p0，t2=p1，t3!=p2，
t2=p0，t3!=p1，
t3!=p0，
t4=p0，t5=p1，t6=p2，t7!=p3，
t5=p0，t6=p1，t7!=p2，
	BF.count=17
"aaabaaaba".indexOf("aaaa")=-1


**/
//@author：Yeheya。2015-2-26
