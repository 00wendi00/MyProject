/**
 * 文件名：ContainerComparison15.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-26
 */
package 第十六章数组;

/**
 * @author 张文迪
 * 类名：ContainerComparison15
 * 类说明：
 */
import net.mindview.util.*;
import java.util.*;
import static net.mindview.util.Print.*;

class BerylliumSphereGenerator implements Generator<BerylliumSphere> {
	public BerylliumSphere next() {
		return new BerylliumSphere();
	}		
}

public class ContainerComparison15 {
	public static void main(String[] args) {
		BerylliumSphere[] spheres = new BerylliumSphere[5];
		BerylliumSphereGenerator bsg = new BerylliumSphereGenerator();
		Generated.array(spheres, bsg);
		print(Arrays.toString(spheres));
		print(spheres[4]);
		List<BerylliumSphere> sphereList = new ArrayList<BerylliumSphere>();
		for(int i = 0; i < 5; i++)
			sphereList.add(bsg.next());
		print(sphereList);
		print(sphereList.get(4));
	}
}
