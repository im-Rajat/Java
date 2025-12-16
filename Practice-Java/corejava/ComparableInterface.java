package corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Stud implements Comparable<Stud> {
    int rollno, marks;
    String name;

    public Stud(int rollno, String name, int marks) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "Stud{" +
                "rollno=" + rollno +
                ", marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }
    public int compareTo(Stud s) {
        return marks > s.marks ? 1 : -1;
    }
}
public class ComparableInterface {
    public static void main(String[] args) {
        List<Stud> studs = new ArrayList<>();
        studs.add(new Stud(23, "Mahesh",55));
        studs.add(new Stud(34, "Sony",64));
        studs.add(new Stud(5, "Larry",25));
        studs.add(new Stud(26, "Joseph",36));
        Collections.sort(studs);
        // If later we decide to change sorting
        // Collections.sort(studs, (i, j) -> i.rollno > j.rollno ? 1 : -1);
        for (Stud s : studs) {
            System.out.println(s);
        }
    }
}
