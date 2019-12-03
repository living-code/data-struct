//《数据结构（Java版）（第5版）》，作者：叶核亚，2014年7月17日
//§5.2.2 稀疏矩阵的压缩存储
//4.  稀疏矩阵行的单链表
//【例5.2】  稀疏矩阵的存储及运算，采用行的单链表。
//【实验题5-3】

class LinkedMatrix例5_2
{
    public static void main(String args[])
    {
        //A
        Triple[] elemsa={new Triple(0,2,11), new Triple(0,4,17),
                         new Triple(1,1,20),
                         new Triple(3,0,19), new Triple(3,2,36), new Triple(3,5,28),
                         new Triple(4,2,50)};
        LinkedMatrix mata = new LinkedMatrix(5,6,elemsa);
        System.out.print("【例5.2】 A 矩阵三元组行的单链表：\n"+mata.toString());
        mata.printMatrix();
        int i=3, j=5;
        System.out.println("MatrixA["+i+"]["+j+"]="+mata.get(i,j));
        mata.set(i,j,0);
        System.out.println("MatrixA["+i+"]["+j+"]="+mata.get(i,j));
        mata.set(i,j,18);
        System.out.println("MatrixA["+i+"]["+j+"]="+mata.get(i,j));
        mata.set(i,j,28);
        System.out.println("MatrixA["+i+"]["+j+"]="+mata.get(i,j));
//        mata.printMatrix();
       
        //B
        Triple[] elemsb={new Triple(0,2,-11), new Triple(0,4,-17),
                         new Triple(1,1,0),                //不存储值为0元素
                         new Triple(2,3,51),
                         new Triple(3,0,10),
                         new Triple(4,1,99)};
        LinkedMatrix matb = new LinkedMatrix(5,6,elemsb);
        System.out.print("\nB 矩阵三元组行的单链表：\n"+matb.toString());
        matb.printMatrix2();        
        
        //C=A，C+=B 
        LinkedMatrix matc = new LinkedMatrix(mata);        //深度拷贝，【实验题5-3】
        System.out.println("\nC=A 矩阵三元组行的单链表：\n"+matc.toString());
        matc.addAll(matb);
        System.out.println("\nC=A，C+=B 矩阵三元组行的单链表：\n"+matc.toString());
        matc.printMatrix();
        
/*        //D=A+B
        LinkedMatrix matd = mata.union(matb);              //【实验题5-3】
        System.out.println("\nD=A+B 矩阵三元组行的单链表：\n"+matd.toString());
        matd.printMatrix();
        System.out.println("D.equals(C)？"+matd.equals(matc));
        
        LinkedMatrix mate = mata.transpose();              //【实验题5-3】
        System.out.println("\nA的转置矩阵  三元组行的单链表：\n"+mate.toString());
        mate.printMatrix();*/
    }
}
/*
程序运行结果如下：
【例5.2】 A 矩阵三元组行的单链表：
0 -> PolySinglyList((0,2,11),(0,4,17))
1 -> PolySinglyList((1,1,20))
2 -> PolySinglyList()
3 -> PolySinglyList((3,0,19),(3,2,36),(3,5,28))
4 -> PolySinglyList((4,2,50))
矩阵LinkedMatrix（5×6）：
   0   0  11   0  17   0
   0  20   0   0   0   0
   0   0   0   0   0   0
  19   0  36   0   0  28
   0   0  50   0   0   0
MatrixA[3][5]=28
MatrixA[3][5]=0
MatrixA[3][5]=18
MatrixA[3][5]=28

B 矩阵三元组行的单链表：
0 -> PolySinglyList((0,2,-11),(0,4,-17))
1 -> PolySinglyList()
2 -> PolySinglyList((2,3,51))
3 -> PolySinglyList((3,0,10))
4 -> PolySinglyList((4,1,99))
矩阵LinkedMatrix（5×6）：
   0   0 -11   0 -17   0
   0   0   0   0   0   0
   0   0   0  51   0   0
  10   0   0   0   0   0
   0  99   0   0   0   0

C=A 矩阵三元组行的单链表：
0 -> PolySinglyList((0,2,11),(0,4,17))
1 -> PolySinglyList((1,1,20))
2 -> PolySinglyList()
3 -> PolySinglyList((3,0,19),(3,2,36),(3,5,28))
4 -> PolySinglyList((4,2,50))


C=A，C+=B 矩阵三元组行的单链表：
0 -> PolySinglyList()
1 -> PolySinglyList((1,1,20))
2 -> PolySinglyList((2,3,51))
3 -> PolySinglyList((3,0,29),(3,2,36),(3,5,28))
4 -> PolySinglyList((4,1,99),(4,2,50))

矩阵LinkedMatrix（5×6）：
   0   0   0   0   0   0
   0  20   0   0   0   0
   0   0   0  51   0   0
  29   0  36   0   0  28
   0  99  50   0   0   0

D=A+B 矩阵三元组行的单链表：
0 -> PolySinglyList()
1 -> PolySinglyList((1,1,20))
2 -> PolySinglyList((2,3,51))
3 -> PolySinglyList((3,0,29),(3,2,36),(3,5,28))
4 -> PolySinglyList((4,1,99),(4,2,50))

矩阵LinkedMatrix（5×6）：
   0   0   0   0   0   0
   0  20   0   0   0   0
   0   0   0  51   0   0
  29   0  36   0   0  28
   0  99  50   0   0   0
D.equals(C)？true

A的转置矩阵  三元组行的单链表：
0 -> PolySinglyList((0,3,19))
1 -> PolySinglyList((1,1,20))
2 -> PolySinglyList((2,0,11),(2,3,36),(2,4,50))
3 -> PolySinglyList()
4 -> PolySinglyList((4,0,17))
5 -> PolySinglyList((5,3,28))

矩阵LinkedMatrix（6×5）：
   0   0   0  19   0
   0  20   0   0   0
  11   0   0  36  50
   0   0   0   0   0
  17   0   0   0   0
   0   0   0  28   0

*/
//@author：Yeheya。2015-10-12
