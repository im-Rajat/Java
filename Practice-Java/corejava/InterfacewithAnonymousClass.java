package corejava;


interface Abc {
	void show();
}

public class InterfacewithAnonymousClass {

	public static void main(String[] args) {
		
		Abc obj1 = new Abc() 
				{
					public void show() {
						System.out.println("In anonymous class");
					}
				};
		obj1.show();
	}
}
