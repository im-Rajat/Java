package corejava;


class Outer {
	
	int a;
	public void show() {
		System.out.println("In show()");
	}
	
	class Inner {
		
		public void display() {
			System.out.println("In display()");
		}
	}
	
	static class InnerStatic {
		
		public void display() {
			System.out.println("In static display()");
		}
	}
}

public class InnerDemo {

	public static void main(String[] args) {
		
		Outer obj = new Outer();
		obj.show();
		
		Outer.Inner obj2 = obj.new Inner();
		
		obj2.display();
		
		Outer.InnerStatic obj3 = new Outer.InnerStatic();
		obj3.display();
	}

}
