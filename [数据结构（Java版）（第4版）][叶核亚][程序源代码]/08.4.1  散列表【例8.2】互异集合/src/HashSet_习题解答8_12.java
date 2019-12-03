//《数据结构（Java版）（第4版）习题解答》，作者：叶核亚，2015年3月19日
//8.4.1   散列表
//【习题解答8-12】构造链地址法散列表，扩充容量

public class HashSet_习题解答8_12 
{
    public static void main(String[] args) 
    {
        Integer[] values ={16,75,60,43,54,90,46,31,27,88,64,50}; //【习题解答8-12】
        System.out.print("关键字序列： ");
        Array1.print(values);                              //见例1.4
        HashSet<Integer> set = new HashSet<Integer>(10);   //构造空散列表，散列数组容量为10
        set.addAll(values);                                //插入values数组元素
        set.printAll();
    }
}
/*
程序运行结果如下：
关键字序列：  16 75 60 43 54 90 46 31 27 88 64 50
散列表，容量=10，8个元素，hash(key)=key % 10，HashSet(60,90,31,43,54,75,16,46)
table[0]=(60,90)
table[1]=(31)
table[2]=()
table[3]=(43)
table[4]=(54)
table[5]=(75)
table[6]=(16,46)
table[7]=()
table[8]=()
table[9]=()
ASL成功=(1+2+1+1+1+1+1+2)/8 =10/8 =1.25

添加27，散列表，容量=20，12个元素，hash(key)=key % 20，HashSet(60,43,64,46,27,88,90,50,31,54,75,16)
table[0]=(60)
table[1]=()
table[2]=()
table[3]=(43)
table[4]=(64)
table[5]=()
table[6]=(46)
table[7]=(27)
table[8]=(88)
table[9]=()
table[10]=(90,50)
table[11]=(31)
table[12]=()
table[13]=()
table[14]=(54)
table[15]=(75)
table[16]=(16)
table[17]=()
table[18]=()
table[19]=()
ASL成功=(1+1+1+1+1+1+1+2+1+1+1+1)/12 =13/12 =1.0833333333333333

*/
//@author：Yeheya。2015-3-19

