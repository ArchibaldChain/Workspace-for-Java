package Lab11;

import java.util.Scanner;

public class Teacher extends Human{
	static Scanner input = new Scanner(System.in);
	private String university;
	private int salary;
	private String major;
	public Teacher(){
		System.out.println("Enter university:");
		this.university = input.next();
		System.out.println("Enter major:");
		this.major = input.next();
		System.out.println("Enter salary:");
		this.salary = input.nextInt();
		setOccupation("Professor");
	}
	public String toString(){
		return super.toString()+String.format(" in %s university\nmajor in %s has %d",
				university,major,salary);
	}


}
