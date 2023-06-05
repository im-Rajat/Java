package corejava;


class AC1 {
	public void show() {
		System.out.println("in AC1 show");
	}
}

public class AnonymousClass {

	public static void main(String[] args) {
		AC1 obj1 = new AC1()
				{
					public void show() {
						System.out.println("this is anonymous class");
					}
				};
		obj1.show();
	}
}
