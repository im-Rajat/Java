package corejava;


public class WrapperDemo {

	public static void main(String[] args) {
		
		int i = 5;	// Primitive datatype
		Integer i1 = new Integer(5);	// Wrapper Class
		Integer i2 = new Integer(i);	// Boxing - Wrapping
		
		int j = i2.intValue();	// unboxing - unwrapping
		
		Integer value = i;	// autoboxing/autowrapping
		int k = value;	// autounboxing
		
		String str = "123";
		int n = Integer.parseInt(str);
	}
}
