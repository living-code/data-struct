//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月14日
//8.3 分块查找
//【例8.1】 判断给定字符串是否为Java关键字。

public class HashSet_KeyWords  
{
    //关键字表
    private static String[] keywords={"abstract","assert","boolean","break","byte","case","catch",
        "char","class","continue","default","do","double","else","extends","false","final","finally",
        "float","for","if","implements","import","instanceof","int","interface","long","native","new",
        "null","package","private","protected","public","return","short","static","super","switch",
        "synchronized","this","throw","throws","transient","true","try","void","volatile","while"};

    static HashSet<String> hashset;                        //散列表
    static                                                 //静态初始化，建立索引表
    {
        hashset = new HashSet<String>(keywords);           //构造散列表，由values数组提供元素
//        System.out.print("散列表：\n"+hashset.toString());        
    	hashset.printAll();
    }

    public static boolean isKeyword(String str)            //判断str是否为Java关键字
    {
       return  hashset.contains(str);
    }
        
    public static void main(String[] args) 
    {                                            //默认首先进行静态初始化，建立索引表
    	String[] str={"and","final","length", "while","x"};
        for (int i=0; i<str.length; i++)
           System.out.println(str[i]+(isKeyword(str[i])?"":"不")+"是关键字");
    }
}

/*
程序运行结果如下：
散列表：容量=65，49个元素，hash(key)=key % 65，HashSet(long,false,transient,class,try,true,native,abstract,new,assert,static,super,do,finally,byte,break,case,null,package,switch,private,synchronized,throws,char,continue,float,throw,short,instanceof,int,if,return,catch,protected,final,for,public,import,else,double,void,volatile,while,boolean,default,implements,interface,this,extends)
table[0]=()
table[1]=()
table[2]=(long)
table[3]=(false)
table[4]=()
table[5]=()
table[6]=()
table[7]=()
table[8]=(transient)
table[9]=(class)
table[10]=()
table[11]=()
table[12]=()
table[13]=()
table[14]=()
table[15]=()
table[16]=(try)
table[17]=()
table[18]=(true)
table[19]=(native)
table[20]=(abstract,new)
table[21]=()
table[22]=()
table[23]=(assert,static)
table[24]=(super)
table[25]=()
table[26]=(do,finally)
table[27]=()
table[28]=()
table[29]=()
table[30]=()
table[31]=(byte)
table[32]=(break,case)
table[33]=(null,package,switch)
table[34]=()
table[35]=()
table[36]=(private,synchronized)
table[37]=(throws)
table[38]=()
table[39]=(char,continue,float,throw)
table[40]=(short)
table[41]=(instanceof,int)
table[42]=(if)
table[43]=()
table[44]=(return)
table[45]=(catch,protected)
table[46]=()
table[47]=(final,for,public)
table[48]=()
table[49]=(import)
table[50]=(else)
table[51]=(double)
table[52]=()
table[53]=()
table[54]=(void)
table[55]=()
table[56]=(volatile)
table[57]=(while)
table[58]=()
table[59]=()
table[60]=(boolean,default,implements,interface,this)
table[61]=()
table[62]=()
table[63]=()
table[64]=(extends)
ASL成功=(1+1+1+1+1+1+1+1+2+1+2+1+1+2+1+1+2+1+2+3+1+2+1+1+2+3+4+1+1+2+1+1+1+2+1+2+3+1+1+1+1+1+1+1+2+3+4+5+1)/49 =78/49 =1.5918367346938775

and不是关键字
final是关键字
length不是关键字
while是关键字
x不是关键字



*/

