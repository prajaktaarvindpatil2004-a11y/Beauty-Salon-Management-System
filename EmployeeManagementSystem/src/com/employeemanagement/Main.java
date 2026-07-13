package com.employeemanagement;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		EmployeeDAO dao = new EmployeeDAOImpl();

		int choice;
		do {
			System.out.println("=================== EMPLOYEE MANAGEMENT SYSTEM ====================");
			System.out.println("1.Add Employee");
			System.out.println("2.Update Employee");
			System.out.println("3.Delete Employee");
			System.out.println("4.Search Employee");
			System.out.println("5.Display All Employees");
			System.out.println("6.Exit");
			System.out.println("Enter your choice:");
			System.out.println();

			choice = sc.nextInt();

			switch (choice) {

			case 1:
				Employee e1 = new Employee();

				System.out.println("Enter Employee ID:");
				e1.setId(sc.nextInt());
				sc.nextLine();

				System.out.println("Enter Name:");
				e1.setName(sc.nextLine());

				System.out.println("Enter Department:");
				e1.setDepartment(sc.nextLine());

				System.out.println("Enter Email:");
				e1.setEmail(sc.nextLine());

				System.out.println("Enter Mobile:");
				e1.setMobile(sc.nextLine());

				dao.addEmployee(e1);
				break;

			case 2:
				Employee e2 = new Employee();

				System.out.println("Enter Employee ID:");
				e2.setId(sc.nextInt());
				sc.nextLine();

				System.out.println("Enter New Name:");
				e2.setName(sc.nextLine());

				System.out.println("Enter New Department:");
				e2.setDepartment(sc.nextLine());

				System.out.println("Enter New Email:");
				e2.setEmail(sc.nextLine());

				System.out.println("Enter New Mobile:");
				e2.setMobile(sc.nextLine());

				dao.updateEmployee(e2);
				break;

			case 3:
				System.out.print("Enter Employee ID to Delete: ");
				int deleteID = sc.nextInt();
				dao.deleteEmployee(deleteID);
				break;

			case 4:
				System.out.print("Enter Employee ID to Search: ");
				int id = sc.nextInt();

				Employee e = dao.searchEmployee(id);

				if (e != null) {
					System.out.println("\n----- Employee Details -----");
					System.out.println("ID         : " + e.getId());
					System.out.println("Name       : " + e.getName());
					System.out.println("Department : " + e.getDepartment());
					System.out.println("Email      : " + e.getEmail());
					System.out.println("Mobile     : " + e.getMobile());
				} else {
					System.out.println("Employee not found!");
				}
				break;

			case 5:
				List<Employee> list = dao.displayAllEmployees();

				if (list.isEmpty()) {
					System.out.println("No Records Found!");
				} else {

					System.out.println("\n---------------- Employee List ----------------");
					System.out.printf("%-5s %-20s %-20s %-30s %-15s\n",
							"ID", "NAME", "DEPARTMENT", "EMAIL", "MOBILE");
					System.out.println("--------------------------------------------------------------------------------");

					for (Employee emp : list) {
						System.out.printf("%-5d %-20s %-20s %-30s %-15s\n",
								emp.getId(),
								emp.getName(),
								emp.getDepartment(),
								emp.getEmail(),
								emp.getMobile());
					}
				}
				break;

			case 6:
				System.out.println("Thank You! Exiting Employee Management System...");
				break;

			default:
				System.out.println("Invalid Choice! Please Try Again.");
			}

		} while (choice != 6);

		sc.close();
	}
}