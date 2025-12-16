package studentdatabaseapplication;

import java.util.Scanner;

public class StudentDatabaseApp {

    public static void main(String[] args) {
        System.out.print("Enter number of student to enroll : ");
        Scanner scanner = new Scanner(System.in);
        int numOfStudents = scanner.nextInt();

        Student[] students = new Student[numOfStudents];

        for (int i = 0; i < numOfStudents; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].PayTuition();
        }

        for (int i = 0; i < numOfStudents; i++) {
            System.out.println(students[i].toString() + "\n");
        }
    }
}
