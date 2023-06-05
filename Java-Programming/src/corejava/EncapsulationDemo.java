package corejava;

// Encapsulation : Binding data with methods
class Student
{
	private int rollno;
	private String name;
	
	// Getters and Setters
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getRollno() {
		return rollno;
	}
}
public class EncapsulationDemo {
	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.setRollno(1);
		
		System.out.println(s1.getRollno());
	}
}
