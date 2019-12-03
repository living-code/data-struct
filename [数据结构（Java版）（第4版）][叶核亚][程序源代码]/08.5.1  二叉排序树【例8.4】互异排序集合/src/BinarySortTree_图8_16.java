//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月16日
//8.5.1   二叉排序树
//图8.15～图8.17，二叉排序树的插入、查找和删除操作，计算ASL成功。

class BinarySortTree_图8_16
{
    public static void main(String args[])
    {
    	//图8.15～图8.17，插入、查找
        Integer[] values={54,18,81,99,36,12,12,76,57,6,66};  //图8.15（a）
        BinarySortTree<Integer> bstree=new BinarySortTree<Integer>(values); //构造二叉排序树
        System.out.print("图8.15，");
        bstree.inorder();                                  //中根次序遍历二叉排序树，输出按关键字升序排列的元素序列
//        bstree.inorderPrevious();
        bstree.printASL();

        Integer key = 57;
        System.out.println("查找"+key+"，"+(bstree.search(key)!=null?"":"不")+"成功 ");
        key = 40;
        System.out.println("查找"+key+"，"+(bstree.search(key)!=null?"":"不")+"成功 ");
        
        System.out.print("\n图8.16，");
        System.out.print("插入"+key+"，");
        bstree.add(key);                                   //插入40，图8.16
        bstree.inorder();                                  //中根次序遍历二叉排序树
        bstree.printASL();
       
        Integer[] delete={12,36,values[0]};                //图8.20（a）（b），删除1度结点；图8.20（c），删除根，2度结点
        System.out.print("\n图8.20，删除");
        for (Integer k : delete)
            System.out.print(bstree.remove(k)+"，");
        key = values[0];             
        System.out.print("插入"+key+"，");
        bstree.add(key);
        bstree.inorder();
        bstree.printASL();
        
        while (bstree.root!=null)                          //删除根，删除全部结点
        {
            System.out.print("删除"+bstree.removeRoot()+"，");
            bstree.inorder();
        }
    }
}
/*
程序运行结果如下：
图8.15，[6 12 18 36 54 57 66 76 81 99 ]
ASL成功=(1*1+2*2+3*4+4*2+5*1)/10 =30/10 =3.0
查找57，成功 
查找40，不成功 

图8.16，插入40，[6 12 18 36 40 54 57 66 76 81 99 ]
ASL成功=(1*1+2*2+3*4+4*3+5*1)/11 =34/11 =3.090909090909091

图8.20，删除12，36，54，插入54，[6 18 40 54 57 66 76 81 99 ]
ASL成功=(1*1+2*2+3*4+4*2)/9 =25/9 =2.7777777777777777
删除57，[6 18 40 54 66 76 81 99 ]
删除66，[6 18 40 54 76 81 99 ]
删除76，[6 18 40 54 81 99 ]
删除81，[6 18 40 54 99 ]
删除99，[6 18 40 54 ]
删除18，[6 40 54 ]
删除40，[6 54 ]
删除54，[6 ]
删除6，[]

*/
//@author：Yeheya。2015-3-20
