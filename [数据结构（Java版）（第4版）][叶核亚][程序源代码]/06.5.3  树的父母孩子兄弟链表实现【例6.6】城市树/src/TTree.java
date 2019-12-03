//ADT 树接口

//ADT Tree<T>                               	          //树抽象数据类型，T表示结点元素类型
public interface TTree<T>                                  //树接口；测试ADT Tree语法
{ 
    boolean isEmpty();                                     //判断是否空树
    int level(T key);                                      //返回关键字为key结点所在的层次
    int size();                                            //返回树的结点数
    int height();                                          //返回树的高度

    void preorder();                                       //输出树的先根次序遍历序列
    void postorder();                                      //输出树的后根次序遍历序列
    void levelorder();                                     //输出树的层次遍历序列

    TreeNode<T> insertRoot(T x);                           //插入元素x作为根结点并返回
    TreeNode<T> insertChild(TreeNode<T> p, T x, int i);    //插入x作为p结点的第i（≥0）个孩子
    void remove(TreeNode<T> p, int i);             	       //删除p结点的第i（≥0）棵子树
    void clear();                                          //删除树的所有结点

    TreeNode<T> search(T key);                             //查找并返回关键字为key的结点
    boolean contains(T key);                               //判断是否包含关键字为key元素
    T remove(T key);                                       //删除以key结点为根的子树
}
