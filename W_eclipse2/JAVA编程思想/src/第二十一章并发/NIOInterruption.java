/**
 * �ļ�����NIOInterruption.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-6
 */
package �ڶ�ʮһ�²���;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author ���ĵ�
 * ������NIOInterruption
 * ��˵����   ��������� ~~~  ����  ����
 */
class NIOBlocked implements Runnable
{
	private final SocketChannel sc ; 
	public NIOBlocked(SocketChannel sc) {this.sc = sc;}
	public void run()
	{
		try
		{
			System.out.println("Waiting for read() in "+this);
			sc.read(ByteBuffer.allocate(1));   //����һ���µ��ֽڻ�����
		}
		catch (ClosedByInterruptException e) {
			System.out.println("ClosedByInterruptException~~~~~~~~~");
		}
		catch (AsynchronousCloseException e) {
			System.out.println("AsynchronousCloseException~~~~~~~~~");
		}
		catch (IOException e){
			throw new RuntimeException(e);
		}
		System.out.println("Exiting NIOBlocked.run()"+this);
	}
}

public class NIO Interruption
{
	public static void main(String args[]) throws Exception
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		ServerSocket server = new ServerSocket(8080);// �����󶨵��ض��˿ڵķ������׽���
		InetSocketAddress isa = new InetSocketAddress("localhost",8080); //�����������Ͷ˿ںŴ����׽��ֵ�ַ
		SocketChannel sc1 = SocketChannel.open(isa);  //����������������׽��ֵĿ�ѡ��ͨ��
		SocketChannel sc2 = SocketChannel.open(isa);  //���׽���ͨ�����������ӵ�Զ�̵�ַ
		Future<?> f = exec.submit(new NIOBlocked(sc1));
							//�ύһ�� Runnable ��������ִ�У�������һ����ʾ������� Future
		exec.execute(new NIOBlocked(sc2)); //��δ��ĳ��ʱ��ִ�и���������
		exec.shutdown();    //����һ��˳��رգ�ִ����ǰ�ύ�����񣬵�������������
		
		TimeUnit.SECONDS.sleep(1);	
		f.cancel(true);    //��ͼȡ���Դ������ִ��
		//������ cancel ʱ��������óɹ�������������δ���������������������
		//�� isDone(),�� isDone()�ĺ������ý�ʼ�շ��� true~~~
		TimeUnit.SECONDS.sleep(1);
		sc2.close();  //�رմ�ͨ����   ����ѹرո�ͨ������˷�����������
	}
}
