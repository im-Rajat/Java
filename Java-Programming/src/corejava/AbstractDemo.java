package corejava;


interface Writer {
	void write();
	//void show() {	// error
		
	//}
}

class Printer {
	public void show(Number i) {
		System.out.println(i);
	}
	// Number class is super class
	// extends by Double and Integer class
}

public class AbstractDemo {
	public static void main(String[] args) {	
		Printer p1 = new Printer();
		p1.show(5);	// Integer will work
		p1.show(5.5);	// Double also work
	}
}
