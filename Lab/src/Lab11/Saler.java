package Lab11;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Saler extends Human{
	private String company;
	private int salary;
	private String dateOfHire;
	
	static Scanner input = new Scanner(System.in);
	public Saler(){
		System.out.println("Please input the company:");
		this.company = input.next();
		System.out.println("Enter salary:");
		this.salary = input.nextInt();
		resetHireDate();
		setOccupation("Saler");
	}
	public void resetHireDate(){
		GregorianCalendar gc = new GregorianCalendar();
		this.dateOfHire = String.format("%sth %s,%s", gc.get(GregorianCalendar.DAY_OF_MONTH),
				gc.get(GregorianCalendar.MONTH),gc.get(GregorianCalendar.YEAR));
	}
	public String toString(){
		return super.toString()+String.format(" in %s \nsalary as %d hired on %s",
				company,salary,dateOfHire);
	}


}
