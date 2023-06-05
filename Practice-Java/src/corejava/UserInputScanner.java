package corejava;

import java.util.Scanner;

public class UserInputScanner {
	public static void main(String[] args) {
		int n = 0;
		System.out.print("Enter a number : ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println(n);
	}
}
