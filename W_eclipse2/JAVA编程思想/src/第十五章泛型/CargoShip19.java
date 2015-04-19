/**
 * 文件名：CargoShip.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-21
 */
package 第十五章泛型;

import java.util.*;

import net.mindview.util.*;

/**
 * @author 张文迪
 * 类名：CargoShip
 * 类说明：联系 19  多层容器+多参数
 */

public class CargoShip19 extends ArrayList<Aisle>
{
	private ArrayList<CheckoutStand> checkout = new ArrayList<CheckoutStand>();
	private Office office = new Office();
	public CargoShip19(int nAisles,int nShelfs,int nProducts)
	{
		for(int i = 0;i<nAisles;i++)
			add(new Aisle(nShelfs, nProducts));
	}
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		for(Aisle a:this)
			for(Shelf s:a)
				for(Product p:s)
				{
					result.append(p);
					result.append("\n");
				}
		return result.toString();
	}
	public static void main(String args[])
	{
		System.out.println(new CargoShip19(2, 2, 3));
	}
}
class Product
{
	private final int id;
	private String description;
	private String distination;
	private double price;
	public Product(int Idnumber,String what,String whereto,double price) 
	{
		id = Idnumber;
		description = what;
		distination = whereto;
		this.price = price;
	}
	public String toString()
	{
		return id+": "+description+",distination :"+distination+" , price:$ "+price;
	}
	public void priceChang(double change)
	{
		price += change;
	}
	public static Generator<Product> generator =
		new Generator<Product>()
		{
			private Random random =  new Random(47);
			public Product next()
			{
				return new Product(random.nextInt(1000), "Test","New York",
						Math.round(random.nextDouble()*1000.0+0.99));
			}
		};
}
class Shelf extends ArrayList<Product>
{
	public Shelf(int nProducts)
	{
		Generators.fill(this, Product.generator, nProducts);
	}
}
class Aisle extends ArrayList<Shelf>
{
	public Aisle(int nShelfs,int nProducts)
	{
		for(int i = 0;i<nShelfs;i++)
			add(new Shelf(nProducts));
	}
}
class CheckoutStand {}
class Office {}
