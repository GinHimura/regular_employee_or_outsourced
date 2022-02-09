package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> employee = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int numberEmployees = sc.nextInt();
		
		for(int i = 1; i <= numberEmployees; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");
			char outsourced = sc.next().charAt(0);
			while(outsourced != 'y' && outsourced != 'n') {
				System.out.print("Outsourced incorrect, Outsourced (y/n)? ");
			    outsourced = sc.next().charAt(0);
			}
			System.out.print("Name: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();   
			if(outsourced == 'n') {
			   employee.add(new Employee(nome, hours, valuePerHour));
			}else {
			   System.out.print("Additional charge: ");
			   double additional = sc.nextDouble();
			   employee.add(new OutsourcedEmployee(nome, hours, valuePerHour, additional));
			}
		}
		System.out.println("\nPAYMENTS:");
		for(Employee e :employee) {
			System.out.println(e.getName() 
					+ " - $" + String.format("%.2f", e.payment()));
		}
		sc.close();
	}
}
