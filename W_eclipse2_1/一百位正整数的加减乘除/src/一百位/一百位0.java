/**
 * �ļ�����һ��λ0.java
 * ��Ŀ-����һ��λ���ļӼ��˳� - һ��λ
 * ���ߣ����ĵ�
 * �������ڣ�2014-8-31
 */
package һ��λ;


/**
 * @author ���ĵ�
 * ������һ��λ
 * ��˵����
 */
                                                                   
public class һ��λ0
{
	public static void main(String args[])
	{
		
		int a[] ={8,9,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4};
		int b[] ={3,6,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,5};		
		
		int c[] = new int[101];
		int d[] = new int[101];
		int e[] = new int[201];
		int f[] = new int[201];
		
		
		
		
		
		for(int i=99;i>=0;i--)
		{	
		    c[i+1] += a[i]+b[i];
			if (c[i+1]>=10)
			{
				c[i+1]-=10;
				c[i]++;		
			}			
		}
		System.out.println("��");
		if(c[0]==0)
		{
			for(int i=1;i<101;i++)
			{
				System.out.print(c[i]);		
			}
		}
		else 
		{
			for(int i=0;i<101;i++)
			{
				System.out.print(c[i]);		
			}
		}
		System.out.println();
		
		

		
		
		
		for(int i=0;i<100;i++)
		{
			d[i+1] += a[i]-b[i];						
			if(d[i+1]<0)
			{
				d[i+1]+=10;
				d[i]--;
			}							
		}	
		System.out.println("��");
		int u=0;
		while(d[u]==0)
		{
			u++;
		}
		for(int i=u;i<101;i++)
		{
			System.out.print(d[i]);
		}			
		System.out.println();
		
		
	
		
		
		
		for(int i=0;i<100;i++)
		{	
			for(int k=0;k<100;k++)
			{
				e[k+i+2]+=a[i]*b[k];
				if(e[k+i+2]>10)
				{
					e[k+i+1]+=(e[k+i+2]/10);
					e[k+i+2]%=10;
					
				}			
			}
		}
		System.out.println("��");
		int y=0;
		while (e[y]==0)
		{
			y++;
		}
		for(int i=y;i<201;i++)
		{
			System.out.print(e[i]);				
		}
		System.out.println();
		
		
		
		
	
		
		
		
		
		for(int i=0;i<100;i++)
		{
			
		}
		System.out.println("��");									  
		
		
	}
	
}


