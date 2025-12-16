package corejava;


interface Abcd {
	void show();
}

public class InterfacewithAnonymousClass2 {

	public static void main(String[] args) {
		
		Abcd obj1 = () -> System.out.println("In anonymous class");
		obj1.show();
	}
}
