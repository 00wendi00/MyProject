/**
 * 文件名：Ex5.java
 * 项目-包：JAVA编程思想 - 第十九章枚举类型
 * 作者：张文迪
 * 创建日期：2014-11-3
 */
package 第十九章枚举类型;

/**
 * @author 张文迪
 * 类名：Ex5
 * 类说明：
 */
import java.util.*;
import static net.mindview.util.Print.*;


enum CharacterCategory 
{
	VOWEL('a', 'e', 'i', 'o', 'u') 
	{
		public String toString() { return "vowel"; }
	},
	SOMETIMES_A_VOWEL('y', 'w') 
	{
		public String toString() 
		{
			return "sometimes a vowel";
		}
	},
	CONSONANT 
	{
		public String toString() { return "consonant~~~~~~"; }
	};
	private HashSet<Character> chars = new HashSet<Character>();
	private CharacterCategory(Character...chars)  		 //Character[]
	{
		if(chars != null)
			(this.chars).addAll(Arrays.asList(chars));
	}
	public static CharacterCategory getCategory(Character c) 
	{
		if(VOWEL.chars.contains(c))
			return VOWEL;
		if(SOMETIMES_A_VOWEL.chars.contains(c))
			return SOMETIMES_A_VOWEL;
		return CONSONANT;
	}
}
public class Ex5 
{
	public static void main(String[] args) 
	{
		Random rand = new Random(47);
		for(int i = 0; i < 15; i++)
		{
			int c = rand.nextInt(10) + 'a';   //  这个转换精髓了 ~~~
			printnb((char)c + ", " + c + ": ");
				print(CharacterCategory.getCategory((char)c).toString());
		}
	}
}