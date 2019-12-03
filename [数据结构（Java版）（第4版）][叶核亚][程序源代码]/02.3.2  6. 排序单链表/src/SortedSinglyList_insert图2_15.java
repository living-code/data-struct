//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年8月19日
//2.3 线性表的链式存储和实现
//6.  排序单链表
//图2.15 构造排序单链表

public class SortedSinglyList_insert图2_15 
{   
    public static void main(String args[])
    {
        //{41,5,67,41,97,1,26,19}   //第3版
        Integer value[]={70,20,80,70,30,60};        //第4版图2.15//自动将int包装成Integer实例
//        Integer value[]=ObjectArray.random(5);        //见例1.3
        SortedSinglyList<Integer> list1 = new SortedSinglyList<Integer>(value);
        System.out.println("list1="+list1.toString());    //图2.15
/*        
          //深拷贝与比较相等
        SinglyList<Integer> list2 = new SinglyList<Integer>(list1);   //深拷贝
        System.out.print("list2="+list2.toString());
        System.out.println("，list1.equals(list2)? "+list1.equals(list2));

        list2.set(0, new Integer(list1.get(0).intValue()+100));
        list2.remove(list2.count()-1);                     //删除最后一个元素
        list2.remove(100);                                 //序号越界，没删除
        System.out.print("list2="+list2.toString());
        System.out.println("，list1.equals(list2)? "+list1.equals(list2));*/
    }
}
    /*
      SortedSinglyList<Integer> slist1 = new SortedSinglyList<Integer>(list1);  //子类对象引用子类实例，由单链表构造排序单链表
      slist1.insert(1);                        //子类对象调用子类方法，排序单链表按值插入，覆盖
      System.out.println("slist1="+slist1.toString());//子类继承toString()
//      slist1.insert(0,90);                      //排序单链表插入，抛出异常
      
      Integer key = 55;                        //自动将int包装成Integer实例
      int find = slist1.indexOf(key);          //运行时多态，执行子类覆盖的方法
      System.out.println("slist1顺序查找 "+key+"， "+((find==-1)?"不":"")+"成功");
      
      list1.remove(1);                         //调用remove(int i)
      key = 1;                                 //自动将int包装成Integer实例
      list1.remove(key);                      //调用remove(T key)
      System.out.println("list1 删除第"+1+"个元素，删除元素"+key+"，list1="+list1.toString());
      slist1.remove(1);                         //调用remove(int i)，继承
      slist1.remove(key);                      //调用remove(T key)，继承，其中调用子类覆盖的indexOf(key)，运行时多态
      System.out.println("slist1 删除第"+1+"个元素，删除元素"+key+"，slist1="+slist1.toString());
      
      
      //5. 类型的多态，子类对象即是父类对象
      SinglyList<Integer> list2 = new SinglyList<Integer>(slist1); //单链表深拷贝，由排序单链表构造单链表
      System.out.println("list2="+list2.toString());
      SortedSinglyList<Integer> slist2 = new SortedSinglyList<Integer>(slist1); //排序单链表深拷贝
      System.out.println("slist2="+slist2.toString());
      
      //equals()，继承，父与子均可比
/*        System.out.println("list1.equals(slist1)？ "+list1.equals(slist1));  //父类equals(子)
//      System.out.println("slist1.equals(list1)？ "+slist1.equals(list1));  //子类equals(父)
//      System.out.println("slist1.equals(slist2)？ "+slist1.equals(slist2));//子类equals(子)

      //void add(list)
//      list2.add(list1);
//      System.out.println("连接list2.add(list1)，list2="+list2.toString());        
      slist2.add(slist1);                           //排序连接两条单链表，将list所有元素添加到当前单链表最后
      System.out.println("连接slist2.add(slist1)，slist2="+slist2.toString());

      //SinglyList<T> add(list)
//      System.out.println("连接list2.add(list1)="+(list2.add(list1)).toString());        
//      System.out.println("连接slist2.add(slist1)="+(slist2.add(slist1)).toString());//仍然是SeqList<T>

/*        
      SinglyList<Integer> list3 = new SortedSinglyList<Integer>(list1);  //父类对象引用子类实例，由单链表构造排序单链表
      System.out.println("单链表list4: "+list4.toString());
      System.out.println("slist2.equals(list4)？ "+slist2.equals(list4));//子类执行继承父类的equals()
      System.out.println("list4.equals(slist2)？ "+list4.equals(slist2));//子类执行继承父类的equals()
      
      
      
      
/*     


      //第9章
//      SortedSinglyList<Integer> list5 = new SortedSinglyList<Integer>(list1);  //拷贝构造方法
//      System.out.println("list5: "+list5.toString());
/*        list3.merge(list5);                           //归并两个排序单链表
      System.out.println("归并，list3: "+list3.toString());
      System.out.println("list5: "+list5.toString());
    
      SortedSinglyList<Integer> list6 = list3.mergeWith(list5);      //归并两个排序单链表
      System.out.println("归并，list3: "+list3.toString());
      System.out.println("list5: "+list5.toString());
      System.out.println("list6: "+list6.toString());
 }
}
/*
程序运行结果如下：    第2章
单链表list1: (90, 80, 70, 10, 60, 30, 50)           //单链表尾插入50
排序单链表slist2: (10, 30, 50, 50, 60, 70, 80, 90)    //排序单链表按值插入50
SortedSinglyList.indexOf(55,0)，10？30？50？50？slist2顺序查找 55， 不成功



      //第9章？？
list1: (74, 51, 48, 47, 64) 
list3: (40, 47, 67, 74, 94, 99) 
list5: (47, 48, 51, 64, 74) 
归并，list3: (40, 47, 47, 48, 51, 64, 67, 74, 74, 94, 99) 
list5: (47, 48, 51, 64, 74) 

list1: (53, 48, 92, 41, 1) 
list3: (48, 57, 60, 67, 81, 98) 
list5: (1, 41, 48, 53, 92) 
归并，list3: (48, 57, 60, 67, 81, 98) 
list5: (1, 41, 48, 53, 92) 
list6: (1, 41, 48, 48, 53, 57, 60, 67, 81, 92, 98) 
}
*/

/*
泛型类问题讨论:？？
程序调试情况如下：
      SinglyLinkedList<Object> list3 = new SinglyLinkedList<Object>();
//      SortedSinglyLinkedList<Object> list4 = new SortedSinglyLinkedList<Object>();
                                       //编译错，Object类不能作为E的实际参数，没有实现实现Comparable<E>接口
      SortedSinglyLinkedList<Integer> list4 = new SortedSinglyLinkedList<Integer>();
//      list4.insert(new Object());     //编译错，参数类型不匹配


        //10.2   实现迭代器
        Iterator<Integer> it = list1.iterator();      //获得单链表迭代器对象
        int sum=0;
        while (it.hasNext())
        {
            int value=it.next().intValue();
        	sum += value;
    	    System.out.print(value);
        	if (it.hasNext())
        	    System.out.print("+");
        }        	
        System.out.println("="+sum);
    }
}

/*
程序运行结果如下：    
lista: (A, F, B, E, C, D)
lista: (F, B, e, D)

        //深拷贝与比较相等
list1: ()
list2: ()
list1.equals(list2)? true
list1: (44, 10, 11, 20, 72)
list2: (44, 10, 11, 20, 72)
list1.equals(list2)? true
list1: (44, 10, 11, 20, 72)
list2: (144, 10, 11, 20)
list1.equals(list2)? false
44+10+11+20+72=157


*/
