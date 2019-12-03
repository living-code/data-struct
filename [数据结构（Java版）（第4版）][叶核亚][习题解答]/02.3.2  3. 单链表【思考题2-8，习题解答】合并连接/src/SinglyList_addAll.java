//《数据结构（Java版）（第4版）习题解答与实验指导》，作者：叶核亚，2014年12月31日，JDK 8.25
//§2.3 线性表的链式存储和实现
//3. 带头结点的单链表类
//【思考题2-8，习题解答】 合并连接单链表。
//【例2.1】  单链表作为方法参数与返回值问题讨论。

public class SinglyList_addAll 
{
	public static void main(String args[])
    {
        //(1) 连接（浅拷贝）与添加（深拷贝）
		String[] valuea={"a","b","c"}, valueb={"x","y"};
	    SinglyList<String> lista = new SinglyList<String>(valuea);
	    SinglyList<String> listb = new SinglyList<String>(valueb);
        System.out.println("lista="+lista.toString()+"\nlistb="+listb.toString());
        lista.addAll(listb);                      //2.15（a），在lista之后链接listb
        System.out.println("lista.concat(listb);");
        System.out.println("lista="+lista.toString()+"\nlistb="+listb.toString());
        listb.insert("z");
        System.out.println("listb.insert(\"z\");");
        System.out.println("lista="+lista.toString()+"\nlistb="+listb.toString());
        
/*        lista.append(listb);
        System.out.println("lista.append(listb);\nlista: "+lista.toString());
        System.out.println("listb: "+listb.toString());

        ExSinglyList<String> listc = new ExSinglyList<String>(listb);//深拷贝
	    System.out.println("listc: "+listc.toString());


	    listb.append("q");
	    System.out.println("listb.append(\"q\")\nlista: "+lista.toString());
	    System.out.println("listb: "+listb.toString());
	    
        //(2) 返回子表（深拷贝）
        ExSinglyList<String> listsub = lista.sub(0,3);
        System.out.println("listsub = lista.sub(0,3);\nlistsub: "+listsub.toString());

*/
	}
}
/*
程序运行结果如下：    
        //(1)没有设置list为空
lista=ExSinglyList(a,b,c)
listb=ExSinglyList(x,y)
lista.concat(listb);
lista=ExSinglyList(a,b,c,x,y)
listb=ExSinglyList(x,y)
listb.insert("z");                                         //作用于两条单链表
lista=ExSinglyList(a,b,c,x,y,z)
listb=ExSinglyList(x,y,z)

        //(2)没有设置list为空
lista=ExSinglyList(a,b,c)
listb=ExSinglyList(x,y)
lista.concat(listb);
lista=ExSinglyList(a,b,c,x,y)
listb=ExSinglyList()
listb.insert("z");                                         //仅作用于listb，两条单链表无关
lista=ExSinglyList(a,b,c,x,y)
listb=ExSinglyList(z)

lista: (a,b,c)
listb: (x,y)
listc: (x,y)
lista.append(listb);
lista: (a,b,c,x,y)
listb: (x,y)
listb.append("z");
lista: (a,b,c,x,y)
listb: (x,y,z)
lista.concat(listb);
lista: (a,b,c,x,y,x,y,z)
listb: ()
listb.append("q")
lista: (a,b,c,x,y,x,y,z)
listb: (q)
listsub = lista.sub(0,3);
listsub: (a,b,c)
lista.search(listsub): a
将(a,b,c,x,y,x,y,z)中(x,y)全部替换为(a,b,c)的结果是(a,b,c,a,b,c,a,b,c,z)
lista.replaceAll(listc, listsub);
lista: (a,b,c,a,b,c,a,b,c,z)
将(a,b,c,a,b,c,a,b,c,z)中(a,b,c)全部删除的结果是(z)
lista.removeAll(listsub);
lista: (z)


*/