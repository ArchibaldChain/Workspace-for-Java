package Lab11;

import java.util.Scanner;


public class Human {
	static Scanner input = new Scanner(System.in);
	private String firstName;
	private String lastName;
	private int height;
	
	private String dateOfBirth;
	private String occupation;
	public Human(){
		System.out.println("Please input the first name:");
		this.firstName = input.next();
		System.out.println("Please input the last name:");
		this.lastName = input.next();
		System.out.println("Please input height:");
		this.height = input.nextInt();
		System.out.println("Enter date of birth in DD/MM/Year:");
		this.dateOfBirth = input.next();
		this.occupation="not-work-yet";
	}
	public String getFirst() {
		return firstName;
	}
	public String getLast() {
		return lastName;
	}
	public int getHeight() {
		return height;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String oc){
		this.occupation = oc;
	}
	public String toString(){
		return String.format("%s %s is %s born on %s work as %s", lastName,firstName,height,dateOfBirth,occupation);
	}
	public static void main(String[] args) {
		Saler human1=new Saler();
		Teacher human2=new Teacher();
		System.out.println(human1);
		System.out.println(human2);
	}

}
