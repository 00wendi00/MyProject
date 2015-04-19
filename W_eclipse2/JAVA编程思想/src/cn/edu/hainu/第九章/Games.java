/**
 * 文件名：Games.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第九章
 * 作者：张文迪
 * 创建日期：2014-9-24
 */
package cn.edu.hainu.第九章;



/**
 * @author 张文迪
 * 类名：Games
 * 类说明：方法的返回值为  boolean ，类型时，  返回 true为循环， false为循环终止！！！！！！
 */
interface Game{boolean move();}
interface GameFactory{Game getGame();}
class Checkers implements Game
{
	private int moves = 0;
	private static final int MOVES = 3;
	public boolean move()
	{
		System.out.println("Checkers move "+moves);
		return ++moves != MOVES;
	}  	
}
class CheckersFactory implements GameFactory
{
    public Game getGame()
    {
    	return new Checkers();
    }
}
class Chess implements Game
{
	private int moves = 0;
	private static final int MOVES = 4;
	public boolean move()
	{
		System.out.println("Chess move "+moves);
		return ++moves != MOVES;
	}
}
class ChessFactory implements GameFactory
{
	public Game getGame()
	{
		return new Chess();
	}
}
public class Games
{
    public static void playGame(GameFactory factory)
    {
    	Game s = factory.getGame();
    	while(s.move());
    }
    public static void main(String args[])
    {
    	playGame(new CheckersFactory());
    	playGame(new ChessFactory());
    }
}
