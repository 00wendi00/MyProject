package 哈哈;

import java.util.Arrays;

public class Maopao 
{
	public static void main(String args[])
	{
		int[] a = {5,6,7,8,9,5,6,2,1,8};
		int tem = 0;
		for(int i = 0;i<10;i++)
		{
			for(int k = 0;k<i;k++)
			{
				if(a[i]<a[k])
				{
					tem = a[k];
					a[k] = a[i];
					a[i] = tem;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
