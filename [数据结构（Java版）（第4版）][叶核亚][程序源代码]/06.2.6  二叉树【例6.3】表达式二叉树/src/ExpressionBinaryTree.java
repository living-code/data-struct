//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月7日
//6.2.6   二叉树的二叉链表实现
//【例6.3】  创建表达式二叉树，计算表达式值。

//表达式二叉树类，继承二叉树类     
public class ExpressionBinaryTree extends BinaryTree<ExpData>
{
    public ExpressionBinaryTree()                          //构造空二叉树
    {
        super();
    }
    
    public ExpressionBinaryTree(String prefix)             //以前缀表达式prefix构造表达式二叉树
    {
        this.root = createPrefix(prefix); 
    }

    private int i=0;                             //隐藏父类声明的i；父类的i，私有权限，子类不可见
    //以从prefix的第i个字符开始的前缀表达式子串，构造子表达式二叉树，返回所建子树的根结点，递归算法
    private BinaryNode<ExpData> createPrefix(String prefix)
    { 
        BinaryNode<ExpData> p=null;
        if (i<prefix.length())
        {
            char ch = prefix.charAt(i);
/*可行            while (i<prefix.length() && ch==' ')           //跳过多余空格
            {
                i++;
                if (i<prefix.length())
                    ch = prefix.charAt(i);
            }*/
            if (ch>='0' && ch<='9')                        //遇到数字字符
            {
                int value=0;      
                while (i<prefix.length() && ch!=' ')       //将整数字符串转换为整数值，算法同例4.2
                {
                    value = value*10 + ch-'0';
                    i++;
                    if (i<prefix.length())
                        ch = prefix.charAt(i);
                }
                p = new BinaryNode<ExpData>(new ExpData(value,' '));//创建数值结点，叶子
                i++;                                       //跳过整数后的一个空格
            }
            else                                           //创建运算符结点，2度结点
            {
                p = new BinaryNode<ExpData>(new ExpData(0,prefix.charAt(i)));
                i++;
                p.left = createPrefix(prefix);             //创建左子树，递归调用
                p.right = createPrefix(prefix);            //创建右子树，递归调用
            }
        }
        return p;
    }

    public int toValue()                                   //计算算术表达式，返回整数值
    {
        return this.toValue(this.root);
    }

    //后根次序遍历并计算以p结点为根的子树，p结点的value存储运算结果；递归算法
    private int toValue(BinaryNode<ExpData> p)
    {
        if (p==null)
            return 0;
        if (!p.isLeaf())
            switch (p.data.oper)                           //非叶子结点，根据运算符分别计算
            {
                case '+': p.data.value = toValue(p.left) + toValue(p.right); break;
                case '-': p.data.value = toValue(p.left) - toValue(p.right); break;
                case '*': p.data.value = toValue(p.left) * toValue(p.right); break;
                case '/': p.data.value = toValue(p.left) / toValue(p.right); //整除，若除数为0，Java将抛出算术异常
            }
        return p.data.value;
    }
    //继承先根、中根、后根次序遍历方法，不支持插入结点、删除子树方法，省略
    
    public static void main(String args[])
    {
    //"45+(10-15)*((25+35)/(60-40))-11"};  //图6.21 表达式二叉树，

//        String prefix=" -  1 2  3";       //前缀表达式，递归算法，忽略多余字符串
        String prefix="-+45 *-10 15 /+25 35 -60 40 11";       //图6.21 前缀表达式，递归算法，忽略多余字符串
        ExpressionBinaryTree expbitree1 = new ExpressionBinaryTree(prefix);//以前缀表达式prefix构造表达式二叉树
        System.out.print("前缀表达式：  ");  expbitree1.preorder(); //输出先根次序遍历序列
        System.out.print("中缀表达式：  ");  expbitree1.inorder();  //输出中根次序遍历序列
        System.out.print("后缀表达式：  ");  expbitree1.postorder();//输出后根次序遍历序列
//        System.out.println("size="+expbitree.size());
        System.out.println("value="+expbitree1.toValue());
    }
}
/*
程序运行结果如下：
                                                           //图6.21 表达式二叉树
前缀表达式：  - + 45 * - 10 15 / + 25 35 - 60 40 11 
中缀表达式：  45 + 10 - 15 * 25 + 35 / 60 - 40 - 11 
后缀表达式：  45 10 15 - 25 35 + 60 40 - / * + 11 - 
value=19
SeqStack (45) 
SeqStack (45, 10) 
SeqStack (45, 10, 15) 
SeqStack (45, -) 
SeqStack (45, -, 25) 
SeqStack (45, -, 25, 35) 
SeqStack (45, -, +) 
SeqStack (45, -, +, 60) 
SeqStack (45, -, +, 60, 40) 
SeqStack (45, -, +, -) 
SeqStack (45, -, /) 
SeqStack (45, *) 
SeqStack (+) 
SeqStack (+, 11) 
SeqStack (-) 
前缀表达式：  - + 45 * - 10 15 / + 25 35 - 60 40 11 
中缀表达式：  45 + 10 - 15 * 25 + 35 / 60 - 40 - 11 
后缀表达式：  45 10 15 - 25 35 + 60 40 - / * + 11 - 


                                                           //例4.2 后缀表达式
前缀表达式：  - + 123 / * 10 + - 45 50 20 + * - 35 25 2 10 11 
中缀表达式：  123 + 10 * 45 - 50 + 20 / 35 - 25 * 2 + 10 - 11 
后缀表达式：  123 10 45 50 - 20 + * 35 25 - 2 * 10 + / + 11 - 
value=117

*/

//@author：Yeheya。2014-10-7
