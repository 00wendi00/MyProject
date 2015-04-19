/**
 * �ļ�����RegisteredClasses14.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����������Ϣ
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-19
 */
package ��ʮ����������Ϣ;

import java.util.*;

/*��ϰ 14 ~
 * 
*/

class Part {
	public String toString() {
		return getClass().getSimpleName();//  toString~
	}
	static List<Class<? extends Part>> partClasses = 
		new ArrayList<Class<? extends Part>>();
	static {
		// Collections.addAll() gives an "unchecked generic
		// array creation ... for varargs parameter" warning.
		partClasses.add(FuelFilter.class);
		partClasses.add(AirFilter.class);
		partClasses.add(CabinAirFilter.class);
		partClasses.add(OilFilter.class);
		partClasses.add(FanBelt.class);
		partClasses.add(PowerSteeringBelt.class);
		partClasses.add(GeneratorBelt.class);
	}
	private static Random rand = new Random();
	public static Part createRandom() {
		int n = rand.nextInt(partClasses.size());
		try {
			return partClasses.get(n).newInstance();
		} catch(InstantiationException e) {
			throw new RuntimeException(e);
		} catch(IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	} 
}

class Filter extends Part {}

class FuelFilter extends Filter {
	// Create a Class Factory for each specific type:
	public static class Factory implements typeinfo.factory.Factory<FuelFilter> {
		public FuelFilter create() { return new FuelFilter(); }
	}
}

class AirFilter extends Filter {
	public static class Factory implements typeinfo.factory.Factory<AirFilter> {
		public AirFilter create() { return new AirFilter(); }
	}
}

class CabinAirFilter extends Filter {
	public static class Factory implements typeinfo.factory.Factory<CabinAirFilter> {
		public CabinAirFilter create() { return new CabinAirFilter(); }
	}
}

class OilFilter extends Filter {
	public static class Factory implements typeinfo.factory.Factory<OilFilter> {
		public OilFilter create() { return new OilFilter(); }
	}
}

class Belt extends Part {}

class FanBelt extends Belt {
	public static class Factory implements typeinfo.factory.Factory<FanBelt> {
		public FanBelt create() { return new FanBelt(); }
	}
}

class GeneratorBelt extends Belt {
	public static class Factory implements typeinfo.factory.Factory<GeneratorBelt> {
		public GeneratorBelt create() { return new GeneratorBelt(); }
	}
}

class PowerSteeringBelt extends Belt {
	public static class Factory implements typeinfo.factory.Factory<PowerSteeringBelt> {
		public PowerSteeringBelt create() { return new PowerSteeringBelt(); }
	}
}

/**
 * @author ���ĵ�
 * ������RegisteredClasses14
 * ��˵����
 */
/**
 * @author ���ĵ�
 * ������RegisteredClasses14
 * ��˵����
 */
public class RegisteredClasses14 {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++)
			System.out.println(Part.createRandom());
	}
}
