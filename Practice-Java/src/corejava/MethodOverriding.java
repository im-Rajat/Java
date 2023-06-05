package corejava;


class MA {
	public void show() {
		System.out.println("in MA");
	}
}

class MB extends MA {
	@Override
	public void show() {
		//super.show();	// will call MA show method
		System.out.println("in MB");
	}
}

public class MethodOverriding {
	public static void main(String[] args) {
		MB obj1 = new MB();
		obj1.show();
	}
}
