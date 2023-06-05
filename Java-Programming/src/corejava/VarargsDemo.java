package corejava;


class Calculator {
	
	public int add(int ... n) {
		
		int sum = 0;
		for (int i : n) {
			sum = sum + i;
		}
		
		return sum;
	}
}

public class VarargsDemo {

	public static void main(String args[]) {
		
		Calculator calc1 = new Calculator();
		System.out.println(calc1.add(1, 2, 3));
		System.out.println(calc1.add(5, 2));
		System.out.println(calc1.add(1, 2, 3, 4, 5, 8));
	}
}
