package corejava;


@FunctionalInterface
interface ID1 {
	void show();
	default void show2() {	// we can override this method also
		System.out.println("in interface show");
	}
}

class Implementor implements ID1 {
	public void show() {
		System.out.println("In Implementor");
	}
}

public class InterfaceDemo {
	public static void main(String[] args) {
		ID1 id1 = new Implementor();
		id1.show();		// print : In Implementor
		id1.show2();	// print : in interface show
	}
}
