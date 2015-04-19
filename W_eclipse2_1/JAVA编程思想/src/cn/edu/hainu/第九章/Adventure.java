/**
 * �ļ�����Adventure.java
 * ��Ŀ-����JAVA���˼�� - cn.edu.hainu.�ھ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-24
 */
package cn.edu.hainu.�ھ���;

/**
 * @author ���ĵ�
 * ������Adventure
 * ��˵������ϰ 12��13
 */
interface CanFight
{
	void fight();
}
interface CanFightPeople extends CanFight
{
	
}
interface CanFightAnimale extends CanFight
{
	
}
interface CanFightCreture extends CanFightPeople,CanFightAnimale
{
	void fight();
	void fightcreture();
}

interface CanSwim
{
	void swim();
}
interface CanFly
{
	void fly();
}
interface CanClimb
{
	void climb();
}
class ActionCharacter
{
	public void fight()
	{
		System.out.println("00000000");
	}
}
class Hero extends ActionCharacter implements CanFight,CanFightCreture,CanFly,CanSwim,CanClimb
{
	public void fightcreture()
	{
		System.out.println("~~~~~");
	}
	public void swim()
	{
		System.out.println("111");
	}
	public void fly()
	{
		System.out.println("333");
	}
	public void climb()
	{
		System.out.println("444");
	}	
}
public class Adventure
{
    public static void t(CanFight x) {x.fight();}
    public static void y(CanFightCreture x) {x.fight();x.fightcreture();}
    public static void u(CanSwim x) {x.swim();}
    public static void v(CanFly x) {x.fly();}
    public static void o(CanClimb x){x.climb();}
    public static void w(ActionCharacter x) {x.fight();}
    public static void main(String args[])
    {
    	Hero h = new  Hero();
    	t(h);
    	y(h);
    	u(h);
    	v(h);
    	o(h);
    	w(h);
    }
}
