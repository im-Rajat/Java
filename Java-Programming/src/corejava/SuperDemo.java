package corejava;


class A {
	public A() {
		System.out.println("in A");
	}
	public A(int i) {
		System.out.println("in A int");
	}
}
class B extends A {	
	public B() {
		super();		// be default called by compiler
		System.out.println("in B");
	}
	public B(int i) {
		super(i);	// super call parameterize constructor will called
		System.out.println("in B int");
	}
}

public class SuperDemo {

	public static void main(String[] args) {
		
		// A obj1 = new A();
		
		B obj2 = new B(5);
	}
}
