//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月15日
//8.4.2  散列映射
//【例8.3】  采用散列映射，统计文本中各字符的出现次数。
//采用散列映射存储从指定一段文本中统计出的各字符及其出现次数。
//没有创建HuffmanTree

public class HashMap_charCount
{
    //统计text中各字符的出现次数，返回Map<String, Integer>映射，从字符串到整数的映射
    public static Map<String, Integer> charCount(String text) 
    {
        System.out.println("text=\""+text+"\"");
        HashMap<String, Integer> map = new HashMap<String, Integer>(10);//设置散列表容量为10
//        Map<String, Integer> map = new TreeMap<String, Integer>();//默认K实现Comparable< T>接口
        for (int i=0; i<text.length(); i++)                //逐个字符查找计数
        {
            String key = text.substring(i,i+1);            //获得1个字符，作为关键字
            Integer value = map.get(key);                  //获得关键字key（字符）映射的值
            int count = value==null ? 0 : value.intValue();//转换成int整数
            map.put(key, new Integer(count+1));            //增加计数，关键字相同时，替换值
        }
        map.printAll();
        return map;
    }

    public static void main(String[] args) 
    {
//        String text="AAAABBBCDDBBAAA";                     //例6.4数据
//        String text="CDAAAABBBDBBAAA";                     //例6.4数据，散列表没差别
//        String text="class Hash";                            //图8.14数据
        String text="public class";                            //图8.1数据
        System.out.println(charCount(text).toString());      //统计text中各字符的出现次数
    }
}
/* 
程序运行结果如下：
                               //图8.14数据
text="class Hash"
x=(s,2)，元素重复，未插入。
x=(a,2)，元素重复，未插入。
x=(s,3)，元素重复，未插入。
散列表，容量=10，7个元素，hash(key)=key % 10
table[0]=()
table[1]=()
table[2]=(( ,1),(H,1))
table[3]=()
table[4]=((h,1))
table[5]=((s,3))
table[6]=()
table[7]=((a,2))
table[8]=((l,1))
table[9]=((c,1))
HashSet(( ,1),(H,1),(h,1),(s,3),(a,2),(l,1),(c,1))


text="class Set"
x=(s,2)，元素重复，未插入。
散列表，容量=10，8个元素，hash(key)=key % 10
table[0]=()
table[1]=((e,1))
table[2]=(( ,1))
table[3]=((S,1))
table[4]=()
table[5]=((s,2))
table[6]=((t,1))
table[7]=((a,1))
table[8]=((l,1))
table[9]=((c,1))
HashSet((e,1),( ,1),(S,1),(s,2),(t,1),(a,1),(l,1),(c,1))


text=CDAAAABBBDBBAAA                             //例6.4数据
散列表，容量=10，hash(key)=key % 10                     //设置散列表容量为10
table[0]=()
table[1]=()
table[2]=()
table[3]=()
table[4]=()
table[5]=((A,7))
table[6]=((B,5))
table[7]=((C,1))
table[8]=((D,2))
table[9]=()
HashSet((A,7),(B,5),(C,1),(D,2))


text="public class"                              //
x=(c,2)，元素重复，未插入。
x=(l,2)，元素重复，未插入。
散列表，容量=10，8个元素，hash(key)=key % 10
table[0]=()
table[1]=()
table[2]=((p,1),( ,1))
table[3]=()
table[4]=()
table[5]=((i,1))
table[6]=()
table[7]=((u,1),(a,1))
table[8]=((b,1),(l,2))
table[9]=((c,2))
添加(s,1)
x=(s,2)，元素重复，未插入。
散列表，容量=20，9个元素，hash(key)=key % 20
table[0]=()
table[1]=()
table[2]=()
table[3]=()
table[4]=()
table[5]=((i,1))
table[6]=()
table[7]=()
table[8]=((l,2))
table[9]=()
table[10]=()
table[11]=()
table[12]=((p,1),( ,1))
table[13]=()
table[14]=()
table[15]=((s,2))
table[16]=()
table[17]=((u,1),(a,1))
table[18]=((b,1))
table[19]=((c,2))
HashSet((i,1),(l,2),(p,1),( ,1),(s,2),(u,1),(a,1),(b,1),(c,2))



 */
//@author：Yeheya。2014-10-20
