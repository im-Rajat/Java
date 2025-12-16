package corejava;


class Emp {
	int eid;
	int salary;
	static String ceo;
	
	static {
		ceo = "CEO";	// call only once
	}
	
	public void show() {
		System.out.println(eid + " , " + salary + " , " + ceo);
	}
}

public class StaticDemo {

	public static void main(String args[]) {
		
		Emp e1 = new Emp();
		e1.eid = 1;
		e1.salary = 1000;
		
		Emp e2 = new Emp();
		e2.eid = 2;
		e2.salary = 2000;
		
		e1.show();
		e2.show();
	}
}
