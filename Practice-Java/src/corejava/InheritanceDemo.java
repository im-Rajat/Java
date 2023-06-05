package corejava;


class CalcBasic {				// class - super, parent, base
	public int add(int i, int j) {
		return i + j;
	}
}

class CalcAdv extends CalcBasic {	// class - sub, child, derived
	public int sub(int i, int j) {
		return i - j;
	}
}

class ClacVeryAdv extends CalcAdv {
	
	public int multi(int i, int j) {
		return i * j;
	}
}

public class InheritanceDemo {

	public static void main(String[] args) {
		
		ClacVeryAdv calc1 = new ClacVeryAdv();
		System.out.println(calc1.add(5, 10));
		System.out.println(calc1.sub(10, 2));
		System.out.println(calc1.multi(4, 5));
	}
}
