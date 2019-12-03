//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月14日
//8.4.1   散列表
//图8.12  改进的链地址法散列表
//构造链地址法散列表，扩充容量

public class HashSet_图8_12 
{
    public static void main(String[] args) 
    {
//        Integer[] values1 ={0,10,20,30,40,50,60,70,80,90,100,110};   //容量16，同java.util.HashSet
//        Integer[] values1 ={0,10,20,30,40,50,60,70,80,90,100,110,160};   //容量32，同java.util.HashSet
        Integer[] values ={9,4,12,14,74,6,16,96, 10};         //图8.12
        System.out.print("关键字序列： ");
        Array1.print(values);                              //见例1.4
        HashSet<Integer> set = new HashSet<Integer>(10);   //构造空散列表，散列数组容量为10
        set.addAll(values);                                //插入values数组元素
//        System.out.println("set1="+set1.toString());
        set.printAll();
//    set1.add(null);                              //插入空对象，抛出异常

        Integer key=100;                           //测试删除 2015-6-1
        Integer find = set.remove(new Integer(key));
        System.out.println("\n删除 "+key+"， "+(find!=null?"":"不")+"成功");
        if (find!=null)
        {
            System.out.println("set1="+set.toString());
            set.printAll();
        }
        set.printAll();
    }
}
/*
程序运行结果如下：
关键字序列：  9 4 12 14 74 6 16 96 10
散列表，容量=10，8个元素，hash(key)=key % 10，HashSet(12,4,14,74,6,16,96,9)
table[0]=()
table[1]=()
table[2]=(12)
table[3]=()
table[4]=(4,14,74)
table[5]=()
table[6]=(6,16,96)
table[7]=()
table[8]=()
table[9]=(9)
ASL成功=(1+1+2+3+1+2+3+1)/8 =14/8 =1.75

添加10，散列表，容量=20，9个元素，hash(key)=key % 20，HashSet(4,6,9,10,12,14,74,16,96)
table[0]=()
table[1]=()
table[2]=()
table[3]=()
table[4]=(4)
table[5]=()
table[6]=(6)
table[7]=()
table[8]=()
table[9]=(9)
table[10]=(10)
table[11]=()
table[12]=(12)
table[13]=()
table[14]=(14,74)
table[15]=()
table[16]=(16,96)
table[17]=()
table[18]=()
table[19]=()
ASL成功=(1+1+1+1+1+1+2+1+2)/9 =11/9 =1.2222222222222223

删除 14， 成功
set1=HashSet(4,6,9,10,12,74,16,96)
散列表，容量=20，8个元素，hash(key)=key % 20，HashSet(4,6,9,10,12,74,16,96)
table[0]=()
table[1]=()
table[2]=()
table[3]=()
table[4]=(4)
table[5]=()
table[6]=(6)
table[7]=()
table[8]=()
table[9]=(9)
table[10]=(10)
table[11]=()
table[12]=(12)
table[13]=()
table[14]=(74)
table[15]=()
table[16]=(16,96)
table[17]=()
table[18]=()
table[19]=()
ASL成功=(1+1+1+1+1+1+1+2)/8 =9/8 =1.125

删除 100， 不成功
散列表：容量=20，9个元素，hash(key)=key % 20，HashSet(4,6,9,10,12,14,74,16,96)
table[0]=SinglyList()
table[1]=SinglyList()
table[2]=SinglyList()
table[3]=SinglyList()
table[4]=SinglyList(4)
table[5]=SinglyList()
table[6]=SinglyList(6)
table[7]=SinglyList()
table[8]=SinglyList()
table[9]=SinglyList(9)
table[10]=SinglyList(10)
table[11]=SinglyList()
table[12]=SinglyList(12)
table[13]=SinglyList()
table[14]=SinglyList(14,74)
table[15]=SinglyList()
table[16]=SinglyList(16,96)
table[17]=SinglyList()
table[18]=SinglyList()
table[19]=SinglyList()
ASL成功=(1+1+1+1+1+1+2+1+2)/9 =11/9 =1.2222222222222223

*/
//@author：Yeheya。2015-6-1

