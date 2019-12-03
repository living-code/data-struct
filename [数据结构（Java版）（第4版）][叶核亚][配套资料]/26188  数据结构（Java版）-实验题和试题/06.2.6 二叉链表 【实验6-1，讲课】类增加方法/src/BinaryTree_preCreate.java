//《数据结构（Java版）（第4版）试题库》，作者：叶核亚，2015年8月6日
//6.2.6   二叉树的二叉链表实现
//【例6.1】  二叉树的构造、遍历及插入。 
//【试题6】  构造二叉树，画出使用顺序循环队列的变化图。

public class BinaryTree_preCreate 
{
    static String[][] prelist={          //二叉树标明空子树的先根序列
        {"A","B","S",null,"T","R",null,null,null,"C",null,null, "L","O",null,"N",null,null,"G"}, //abstractlong
        {"I","N","S",null,"T",null,null,"A",null,null, "C","E","O",null,null,null,"F"},          //instanceof
        {"P","U","B","L",null,null,"I",null,null,"C",null,null, "R","E",null,"A",null,null,"K"}, //publicbreak
        {"S","Y","M","P",null,null,"A",null,null,"T",null,"H",null,null, "E","I",null,"C"},      //sympathetic 同情的
        {"T","R","A",null,"N","S",null,null,null,"I","E",null,null,null, "V",null,"O","D"},      //transientVoid
        {"U","M",null,"B","R","E",null,null,null,"L","A",null,null,null, "F",null,"O","T"}};     //umbrellaFloat雨伞
    
    public static void main(String[] args) 
    {
        BinaryTree<String> bitree = new BinaryTree<String>(prelist[5]);
        System.out.println("二叉树的先根次序遍历序列：  "+bitree.toString());  //标明空子树
        System.out.print("二叉树的中根次序遍历序列：  ");  bitree.inorder();
        System.out.print("二叉树的后根次序遍历序列：  ");  bitree.postorder();
        bitree.levelorder();                               //层次遍历二叉树
        bitree.printGenList(); 
    }
}
/*
程序运行结果如下，10~11个结点，按根值排序。  
先根次序遍历二叉树：  A B S ∧T R ∧∧∧C ∧∧L O ∧N ∧∧G ∧∧  //abstractlong，10个结点
中根次序遍历二叉树：  S R T B C A O N L G 
后根次序遍历二叉树：  R T S C B N O G L A 
层次遍历二叉树：  A B L S C O G T N R 
二叉树的广义表表示：A(B(S(∧,T(R,∧)),C),L(O(∧,N),G))

先根次序遍历二叉树：  I N S ∧T ∧∧A ∧∧C E O ∧∧∧F ∧∧     //instanceof，9个结点
中根次序遍历二叉树：  S T N A I O E C F 
后根次序遍历二叉树：  T S A N O E F C I 
层次遍历二叉树：  I N C S A E F T O 
二叉树的广义表表示：I(N(S(∧,T),A),C(E(O,∧),F))

先根次序遍历二叉树：  P U B L ∧∧I ∧∧C ∧∧R E ∧A ∧∧K ∧∧  //publicbreak，10个结点
中根次序遍历二叉树：  L B I U C P E A R K 
后根次序遍历二叉树：  L I B C U A E K R P 
层次遍历二叉树：  P U R B C E K L I A 
二叉树的广义表表示：P(U(B(L,I),C),R(E(∧,A),K))
 
先根次序遍历二叉树：  S Y M P ∧∧A ∧∧T ∧H ∧∧E I ∧C ∧∧∧   //sympathetic同情的，10个结点
中根次序遍历二叉树：  P M A Y T H S I C E 
后根次序遍历二叉树：  P A M H T Y C I E S 
层次遍历二叉树：  S Y E M T I P A H C 
二叉树的广义表表示：S(Y(M(P,A),T(∧,H)),E(I(∧,C),∧))

先根次序遍历二叉树：  T R A ∧N S ∧∧∧I E ∧∧∧V ∧O D ∧∧∧   //transientVoid
中根次序遍历二叉树：  A S N R E I T V D O 
后根次序遍历二叉树：  S N A E I R D O V T 
层次遍历二叉树：  T R V A I O N E D S 
二叉树的广义表表示：T(R(A(∧,N(S,∧)),I(E,∧)),V(∧,O(D,∧)))
 
先根次序遍历二叉树：  U M ∧B R E ∧∧∧L A ∧∧∧F ∧O T ∧∧∧   //umbrellaFloat雨伞
中根次序遍历二叉树：  M E R B A L U F T O 
后根次序遍历二叉树：  E R A L B M T O F U 
层次遍历二叉树：  U M F B O R L T E A 
二叉树的广义表表示：U(M(∧,B(R(E,∧),L(A,∧))),F(∧,O(T,∧)))

    //关键字表
    private static String[] ={"","assert","boolean","break","byte","case","catch",
        "char","class","continue","default","do","","else","extends","false","final","finally",
        "float","for","if","implements","import","int","interface","","native","new",
        "package","private","protected","public","return","short","static","super","switch",
        "synchronized","this","throw","throws","","true","try","void","volatile","while"};

*/
//@author：Yeheya。2015-8-8