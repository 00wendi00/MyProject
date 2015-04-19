/**
 * 文件名：NIOInterruption.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-6
 */
package 第二十一章并发;

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
 * @author 张文迪
 * 类名：NIOInterruption
 * 类说明：   这个任务嘛 ~~~  精髓  精髓
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
			sc.read(ByteBuffer.allocate(1));   //分配一个新的字节缓冲区
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
		ServerSocket server = new ServerSocket(8080);// 创建绑定到特定端口的服务器套接字
		InetSocketAddress isa = new InetSocketAddress("localhost",8080); //根据主机名和端口号创建套接字地址
		SocketChannel sc1 = SocketChannel.open(isa);  //针对面向流的连接套接字的可选择通道
		SocketChannel sc2 = SocketChannel.open(isa);  //打开套接字通道并将其连接到远程地址
		Future<?> f = exec.submit(new NIOBlocked(sc1));
							//提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future
		exec.execute(new NIOBlocked(sc2)); //在未来某个时间执行给定的命令
		exec.shutdown();    //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
		
		TimeUnit.SECONDS.sleep(1);	
		f.cancel(true);    //试图取消对此任务的执行
		//当调用 cancel 时，如果调用成功，而此任务尚未启动，则此任务将永不运行
		//用 isDone(),对 isDone()的后续调用将始终返回 true~~~
		TimeUnit.SECONDS.sleep(1);
		sc2.close();  //关闭此通道。   如果已关闭该通道，则此方法立即返回
	}
}
