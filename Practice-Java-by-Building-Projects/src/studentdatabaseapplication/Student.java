package studentdatabaseapplication;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // constructor
    public Student() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student Fist Name : ");
        this.firstName = scanner.nextLine();

        System.out.print("Enter Student Last Name : ");
        this.lastName = scanner.nextLine();

        System.out.print("Enter Student Grade Year : ");
        this.gradeYear = scanner.nextLine();

        setStudentID();

//        System.out.println(firstName + " " + lastName + " - " + gradeYear + " - " + studentID);


    }

    // Function to generate ID
    private void setStudentID() {
        id++;
        this.studentID =  gradeYear + "" + id;
    }

    public String getStudentID() {
        return this.studentID;
    }

    // Function to enroll in course
    public void enroll() {
        do {
            System.out.print("Enter course to enroll (Q/q to quit): ");
            Scanner scanner = new Scanner(System.in);
            String course = scanner.nextLine();

            if (course.equals("Q") || course.equals("q")) {
                break;
            }
            else {
                courses = courses + "\n\t" + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }
        } while (true);

//        System.out.println("ENROLLED IN: " + courses);
//        System.out.println("TUITION BALANCE: " + tuitionBalance);
    }

    // Funtion to view balance
    public void viewBalance() {
        System.out.println("Your Balance is: Rs." + tuitionBalance);
    }

    // Function to pay tuition balance
    public void PayTuition() {
        viewBalance();
        System.out.print("Enter your payment amount: ");
        Scanner scanner = new Scanner(System.in);
        int payment = scanner.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for payment of Rs." + payment);
        viewBalance();
    }

    // function to show data
    public String toString() {
        String name = "Name : " + firstName + " " + lastName;
        String grade = "Grade Level: " + gradeYear;
        String studentidnum = "Student ID : " + studentID;
        String allcourses = "Courses Enrolled : " + courses;
        String balance = "Balance : Rs." + tuitionBalance;

        return name + "\n" + grade + "\n" + studentidnum + "\n" + allcourses + "\n" + balance;
    }

}
