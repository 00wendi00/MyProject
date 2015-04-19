/**
 * 文件名：MyClass.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-9-29
 */
package 第十一章.持有对象;

import java.util.*;;

/**
 * @author 张文迪
 * 类名：MyClass
 * 类说明：  练习7.移除 子集~~~     异常  java.util.ConcurrentModificationException
 * 	这个问题是说,你不能在对一个List进行遍历的时候将其中的元素删除掉
             解决办法是,你可以先将要删除的元素用另一个list装起来,等遍历结束再remove掉
	可以这样写
	List delList = new ArrayList();//用来装需要删除的元素
	for(Information ia:list)
		if(ia.getId()==k){
			n++;
		delList.add(ia);
	}
	list.removeAll(delList);//遍历完成后执行删除
 */
public class MyClass
{
    public static void main(String args[])
    {
    	List<Object> obj = new ArrayList<Object>();
    	obj.add("222222");
    	obj.add("~~~~~");
    	obj.add("好的");
    	obj.add("尼玛");
    	
    	System.out.println(obj);
    	List<Object> obj2 = obj.subList(0,2);
    	System.out.println(obj2);
    	obj2.remove(0);
    	System.out.println(obj2);
    	System.out.println(obj);
    	obj.remove(obj2); // 一个子集，不能这样子移除~
    	System.out.println(obj);
    	System.out.println(obj2);
    	
    	//obj.removeAll(obj2);  异常  java.util.ConcurrentModificationException
    	
    	System.out.println();
    	List<Object> copy = new ArrayList<Object>(obj);
    	System.out.println(copy);
    	copy.removeAll(obj2);
    	System.out.println(obj);
    	System.out.println(copy);// 这样才能移除子集！！！
    	System.out.println(obj2);
    }
}
