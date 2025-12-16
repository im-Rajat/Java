package corejava;


class Calc {
	
	int num1;
	int num2;
	int result;
	
	public Calc() {
		System.out.println("Default Constructor Called");
	}
	
	public Calc(int num1, int num2) {
		System.out.println("Parameter Constructor Called");
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public void perform() {
		result = num1 + num2;
	}
}

public class ObjectDemo {
	
	public static void main(String args[]) {
		
		Calc obj = new Calc();
		obj.num1 = 2;
		obj.num2 = 8;
		
		obj.perform();
		
		System.out.println(obj.result);
		
		Calc obj2 = new Calc(4, 5);
		obj2.perform();
		
		System.out.println(obj2.result);
	}
}
