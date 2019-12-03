//《数据结构（Java版）（第4版）习题解答》，作者：叶核亚，2015年3月20日
//8.5.1   二叉排序树
//【习题解答8-20】 二叉排序树的插入和删除操作，计算ASL成功。

class BinarySortTree_习题解答8_20
{
    public static void main(String args[])
    {
        Integer[] values={50,16,74,60,43,16,90,46,31,29,88,71,64,13,65};    //习8-20
        BinarySortTree<Integer> bstree=new BinarySortTree<Integer>(values);
        bstree.inorder();
        bstree.printASL();
        
        Integer key = bstree.removeRoot();       
        System.out.print("\n删除根"+key+"，插入"+key+"，");
        bstree.add(key);                                   //插入原根值
        bstree.inorder(); 
        bstree.printASL();
    }
}
/*
程序运行结果如下：
[13 16 29 31 43 46 50 60 64 65 71 74 88 90 ]
ASL成功=(1*1+2*2+3*4+4*4+5*2+6*1)/14 =49/14 =3.5

删除根50，插入50，[13 16 29 31 43 46 50 60 64 65 71 74 88 90 ]
ASL成功=(1*1+2*2+3*4+4*4+5*3)/14 =48/14 =3.4285714285714284


*/
//@author：Yeheya。2015-3-20
