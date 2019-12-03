//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月17日
//5.2.2 稀疏矩阵的压缩存储
//4.  稀疏矩阵行的单链表
//【例5.2】  采用行的单链表存储的稀疏矩阵及相加运算。

class LinkedMatrix_ex
{
    public static void main(String args[])
    {
        Triple[] elemsa={new Triple(0,2,11), new Triple(0,4,17),
                         new Triple(1,1,20),
                         new Triple(3,0,19), new Triple(3,2,36), new Triple(3,5,28),
                         new Triple(4,2,50)};
        LinkedMatrix mata = new LinkedMatrix(5,6,elemsa);
//        mata.set(new Triple(3,5,0));
        System.out.print("【例5.2】 A 矩阵三元组行的单链表：\n"+mata.toString());
        mata.printMatrix();
       
        Triple[] elemsb={new Triple(0,2,-11), new Triple(0,4,-17),
                         new Triple(1,1,0),                //不存储值为0元素
                         new Triple(2,3,51),
                         new Triple(3,0,10),
                         new Triple(4,1,99)};
        LinkedMatrix matb = new LinkedMatrix(5,6,elemsb);
        System.out.print("\nB 矩阵三元组行的单链表：\n"+matb.toString());
        matb.printMatrix();        
        mata.addAll(matb);
        System.out.println("\nA+=B 矩阵三元组行的单链表：\n"+mata.toString());
        mata.printMatrix();
 
        //@author：Yeheya。2014-10-6
        
/*        LinkedMatrix smatc=smata.plus(smatb);
        System.out.print("C=A+B "+smatc.toString());
        System.out.println("C.equals(A)？"+smatc.equals(smata));
        //深拷贝，引用测试
        smata.set(new Triple(1,4,19));        
        System.out.print("A "+smata.toString());
        System.out.println("C.equals(A)？"+smatc.equals(smata));
        
        System.out.println("\n//习题5");
        System.out.println("A转置"+smata.transpose().toString());        //习题5
*/        
    }
}
/*
程序运行结果如下：
【例5.2】 A 矩阵三元组行的单链表：
0 -> ((0,2,11),(0,4,17))
1 -> ((1,1,20))
2 -> ()
3 -> ((3,0,19),(3,2,36),(3,5,28))
4 -> ((4,2,50))
矩阵LinkedMatrix（5×6）：
   0   0  11   0  17   0
   0  20   0   0   0   0
   0   0   0   0   0   0
  19   0  36   0   0  28
   0   0  50   0   0   0

B 矩阵三元组行的单链表：
0 -> ((0,2,-11),(0,4,-17))
1 -> ()
2 -> ((2,3,51))
3 -> ((3,0,10))
4 -> ((4,1,99))
矩阵LinkedMatrix（5×6）：
   0   0 -11   0 -17   0
   0   0   0   0   0   0
   0   0   0  51   0   0
  10   0   0   0   0   0
   0  99   0   0   0   0

A+=B 矩阵三元组行的单链表：
0 -> ()
1 -> ((1,1,20))
2 -> ((2,3,51))
3 -> ((3,0,29),(3,2,36),(3,5,28))
4 -> ((4,1,99),(4,2,50))

矩阵LinkedMatrix（5×6）：
   0   0   0   0   0   0
   0  20   0   0   0   0
   0   0   0  51   0   0
  29   0  36   0   0  28
   0  99  50   0   0   0

//@author：Yeheya。2014-10-6


A 三元组行的单链表：((0,2,11), (0,4,17))((1,1,20))()((3,0,19), (3,5,28))((4,4,50))
稀疏矩阵LinkedSparseMatrix（5×6）：
   0   0  11   0  17   0
   0  20   0   0   0   0
   0   0   0   0   0   0
  19   0   0   0   0  28
   0   0   0   0  50   0
B 三元组行的单链表：((0,2,-11), (0,4,-17))()((2,3,51))((3,0,10))((4,5,99))
稀疏矩阵LinkedSparseMatrix（5×6）：
   0   0 -11   0 -17   0
   0   0   0   0   0   0
   0   0   0  51   0   0
  10   0   0   0   0   0
   0   0   0   0   0  99
C=A+B 三元组行的单链表：()((1,1,20))((2,3,51))((3,0,29), (3,5,28))((4,4,50), (4,5,99))
稀疏矩阵LinkedSparseMatrix（5×6）：
   0   0   0   0   0   0
   0  20   0   0   0   0
   0   0   0  51   0   0
  29   0   0   0   0  28
   0   0   0   0  50  99
A+=B 三元组行的单链表：()((1,1,20))((2,3,51))((3,0,29), (3,5,28))((4,4,50), (4,5,99))
稀疏矩阵LinkedSparseMatrix（5×6）：
   0   0   0   0   0   0
   0  20   0   0   0   0
   0   0   0  51   0   0
  29   0   0   0   0  28
   0   0   0   0  50  99
C.equals(A)？true
A 三元组行的单链表：()((1,1,20), (1,4,19))((2,3,51))((3,0,29), (3,5,28))((4,4,50), (4,5,99))
稀疏矩阵LinkedSparseMatrix（5×6）：
   0   0   0   0   0   0
   0  20   0   0  19   0
   0   0   0  51   0   0
  29   0   0   0   0  28
   0   0   0   0  50  99
C.equals(A)？false

//习题5
A转置三元组行的单链表：((0,3,29))((1,1,20))()((3,2,51))((4,1,19), (4,4,50))((5,3,28), (5,4,99))
稀疏矩阵LinkedSparseMatrix（6×5）：
   0   0   0  29   0
   0  20   0   0   0
   0   0   0   0   0
   0   0  51   0   0
   0  19   0   0  50
   0   0   0  28  99


*/
