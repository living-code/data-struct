//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年7月31日
//7.2.2   图的邻接表表示和实现

//邻接表表示的带权图类，T表示顶点元素类型；继承抽象图类
public class AdjListGraph<T> extends AbstractGraph<T>
{
    protected LinkedMatrix adjlist;                        //图的邻接表，结构同矩阵行的单链表
    
    //构造空图，顶点数为0，边数为0；length指定顶点顺序表容量和邻接表容量
    public AdjListGraph(int length)
    {
        super(length);                                     //构造容量为length的空顺序表
        this.adjlist = new LinkedMatrix(length, length);   //构造length×length矩阵
    }
    
    //以下构造方法的方法体同MatrixGraph类，省略
    public AdjListGraph()                                  //构造空图，顶点数为0，边数为0
    {
        this(10);                                          //顺序表和邻接矩阵的默认容量为10
    }
    public AdjListGraph(T[] vertices)                      //以vertices顶点集合构造图，边数为0
    {
        this(vertices.length);                             //构造指定容量的空图
        for (int i=0; i<vertices.length; i++)
            this.insertVertex(vertices[i]);                //插入一个顶点
    } 
    public AdjListGraph(T[] vertices, Triple[] edges)      //以vertices顶点集合和edges边集合构造图
    {
        this(vertices);
        for (int j=0; j<edges.length; j++)
            this.insertEdge(edges[j]);                     //插入一条边
    }

    public String toString()                               //返回图的顶点集合和邻接表描述字符串
    {
        return super.toString()+"出边表：\n"+this.adjlist.toString();
    }

    //（1）插入边
    public void insertEdge(int i, int j, int weight)       //插入边〈vi,vj〉，权值为weight
    {
        if (i!=j)                                          //不能表示自身环
        {
            if (weight<0 || weight>=MAX_WEIGHT)            //边的权值容错，视为无边，取值0
                weight=0;
            this.adjlist.set(i,j,weight);                  //设置第i条边单链表中〈vi,vj〉边的权值为weight。
            //若0<weight<∞，插入边或替换边的权值；若weight==0，删除该边。若i、j越界，抛出序号越界异常
        }
        else throw new IllegalArgumentException("不能插入自身环，i="+i+"，j="+j);
    }
    public void insertEdge(Triple edge)                    //插入一条边。方法体同图的邻接矩阵，省略
    {
        this.insertEdge(edge.row, edge.column, edge.value);
    }
    
    //（2）插入顶点
    public int insertVertex(T x)                           //插入元素为x的顶点，返回x顶点序号
    {
        int i = this.vertexlist.insert(x);                 //顶点顺序表尾插入顶点x，返回x顶点序号，长度加1，自动扩容
        if (i >= this.adjlist.getRows())                   //若邻接表容量不够，
            this.adjlist.setRowsColumns(i+1, i+1);         //则扩容，保持邻接表行数同图的顶点数
        return i;                                          //返回插入顶点序号
    }
    
    //（3）删除边
    public void removeEdge(int i, int j)                   //删除一条边〈vi,vj〉，忽略权值
    {
        if (i!=j)
            this.adjlist.set(new Triple(i,j,0));           //设置边的权值为0，即在第i条边单链表中删除边结点
    }
    public void removeEdge(Triple edge)                    //删除一条边。方法体同图的邻接矩阵，省略
    {
        this.removeEdge(edge.row, edge.column);
    }

    //（4）删除顶点
    public void removeVertex(int i)                        //删除顶点vi及其关联的边
    {
        int n=this.vertexCount();                          //删除之前的顶点数
        if (i>=0 && i<n)
        {
            //删除与第i条边单链表中所有结点对称的边，即在第i条以外的边单链表中，删除所有以i为终点的边
            SortedSinglyList<Triple> link = this.adjlist.rowlist.get(i);
            for (Node<Triple> p=link.head.next; p!=null; p=p.next)  //遍历第i条边单链表
                this.removeEdge(p.data.toSymmetry());               //删除与p结点对称的边

            n--;                                 //顶点数减1
            this.adjlist.rowlist.remove(i);      //删除行指针顺序表的第i条边单链表，其后单链表上移
            this.adjlist.setRowsColumns(n, n);   //设置矩阵行列数，少一行

            for (int j=0; j<n; j++)                        //遍历每条边单链表，将>i的顶点序号减1
            {
                link = this.adjlist.rowlist.get(j);
                for (Node<Triple> p=link.head.next; p!=null; p=p.next)//遍历第j条边单链表
                {   if (p.data.row > i)
                        p.data.row--; 
                    if (p.data.column > i)
                        p.data.column--;
                }
            }
            this.vertexlist.remove(i);           //删除顶点vi，i后顶点序号减1，图顶点数减1
        }
        else throw new IndexOutOfBoundsException("i="+i);//抛出序号越界异常
    }
    
    //（5） 获得邻接顶点和边的权值属性
    public int weight(int i, int j)                  //返回<vi,vj>边的权值。用于图的最小生成树、最短路径等算法
    {     
        if (i==j)
            return 0;
        int weight = this.adjlist.get(i,j);         //返回矩阵元素[i,j]值。若i、j越界，抛出序号越界异常
        return weight!=0 ? weight : MAX_WEIGHT;     //若返回0表示没有边，则边的权值返回∞
    }
    
    //返回顶点vi在vj后的后继邻接顶点序号；若j=-1，返回vi的第一个邻接顶点序号；若不存在后继邻接顶点，返回-1。用于7.3节图的遍历算法
    protected int next(int i, int j)
    {
        int n=this.vertexCount();
        if (i>=0 && i<n && j>=-1 && j<n && i!=j)
        {
            SortedSinglyList<Triple> link = this.adjlist.rowlist.get(i);//第i条排序单链表
            Node<Triple> find=link.head.next;          //单链表第0个元素
            if (j==-1)
                return find!=null ? find.data.column : -1; //返回第一个邻接顶点的序号
            find = link.search(new Triple(i,j,0));     //顺序查找<vi,vj>边的结点
            if (find!=null)                            //查找成功
            {
                find = find.next;                      //获得<vi,vj>边的后继结点
                if (find!=null)                
                    return find.data.column;           //返回后继邻接顶点序号
            }
        }
        return -1;
    }
/*
    //第10章，10.2 实现迭代器
    //10.2.2   基于迭代器的操作
    //【思考题10-4】
    public void removeVertex(int i)              //删除顶点vi及其关联的边。使用单链表迭代器遍历，没有用到删除
    {
        int n=this.vertexCount();                          //删除之前的顶点数
        if (i>=0 && i<n)
        {
            //删除与第i条边单链表中所有结点对称的边，即在第i条以外的边单链表中，删除所有以i为终点的边
            SortedSinglyList<Triple> link = this.adjlist.rowlist.get(i);//获得第i行排序单链表
            java.util.Iterator<Triple> it = link.iterator();//获得单链表迭代器对象
            while (it.hasNext())                           //遍历第i条边单链表
                this.removeEdge(it.next().toSymmetry());   //删除与p结点对称的边

            n--;                                           //顶点数减1
            this.adjlist.rowlist.remove(i);                //删除行指针顺序表的第i条边单链表，其后单链表上移
            this.adjlist.setRowsColumns(n, n);             //设置矩阵行列数，少一行

            for (int j=0; j<n; j++)                        //遍历每条边单链表，将>i的顶点序号减1
            {
                link = this.adjlist.rowlist.get(j);
//                for (Node<Triple> p=link.head.next; p!=null; p=p.next)//遍历第j条边单链表
                it = link.iterator();                      //获得第i行排序单链表迭代器对象
                while (it.hasNext())                       //遍历第i条边单链表
                {
                    Triple tri= it.next();
                    if (tri.row > i)
                        tri.row--; 
                    if (tri.column > i)
                        tri.column--;
                }
            }
            this.vertexlist.remove(i);                     //删除顶点vi，i后顶点序号减1，图顶点数减1
        }
        else throw new IndexOutOfBoundsException("i="+i);  //抛出序号越界异常
    }*/
}
//@author：Yeheya。2015-3-15