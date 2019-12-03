//《数据结构（Java版）（第4版）试题库》，作者：叶核亚，2015年8月24日
//§2.3.3  排序单链表
//【实验2-10，试题2】求平均值等对排序单链表的操作。

public class SortedSinglyLists                             //对排序单链表的操作
{
    //返回list所有元素的平均值，输出计算公式和结果，每项格式为“值×值相同的元素个数”
    //第8章用 二分法查找等算法，显示ASL成功公式
    public static double average(SortedSinglyList<Integer> list)
    {
        if (list.isEmpty())
            throw new IllegalArgumentException("不能对空单链表计算平均值。"); //抛出无效参数异常
        System.out.print("(");
        Node<Integer> p=list.head.next;
        int value=p.data;                                  //记录前驱结点元素，判断后继元素是否相同
        int count=1, sum=0, length=1;                      //count记录值相同的元素个数  
        for (p=p.next;  p!=null;  p=p.next)                //遍历单链表
        {
            if (p.data==value)                             //若与前一个结点元素值相同
                count++;
            else
            {
                sum += value*count;                        //元素值求和
                System.out.print(value+"×"+count+"+");
                value = p.data;
                count=1;
            }
            length++;                             //统计单链表元素个数
        }
        sum += value*count;
        double aver=(sum+0.0)/length;          //计算平均值；实数除，预处理，避免了除数为0错误
        System.out.println(value+"×"+count+")/"+length+" = "+sum+"/"+length+" = "+aver);
        return aver;                                       //返回平均值
    }
    
    public static void main(String[] args) 
    {
        Integer[] values = {1,2,2,3,3,3,3,4};              //图8.2 二叉判定树
        average(new SortedSinglyList<Integer>(values));
    }
}
/* 
程序运行结果如下：
(1×1+2×2+3×4+4×1)/8=21/8=2.625
*/
//@author：Yeheya。2015-8-24
