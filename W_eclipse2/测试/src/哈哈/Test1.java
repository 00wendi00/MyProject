package 哈哈;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//消耗内存的　方法

public class Test1 
{
	public static void main(String[] args) throws InterruptedException
	{
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 1000000; j++) {
				list.add(new HashMap<String, String>());
			}
		}

		System.out.println("Memery is alloted！");
		while(true)
		{
			Thread.sleep(50000);
		}
}
}
