package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;



public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.print("Nome do departamento: ");
		String departmentName = sc.next();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Telefone: ");
		String phone = sc.next();
		Department dept = new Department(departmentName,payDay,new Address(email,phone));
		
		System.out.print("Quantos funcionários tem o departamento? ");
		n = sc.nextInt();
		
		for (int i = 0 ; i<n ; i++) {
			System.out.println("Dados do funcionário " + (i+1) + ":");
			System.out.print("Nome: ");
			String name = sc.next();
			System.out.print("Salario: ");
			Double salary = sc.nextDouble();
			Employee employ = new Employee(name,salary);
			dept.addEmployee(employ);
			
		}
		showReport(dept);
		sc.close();
		System.out.println("");

	}
	private static void showReport(Department department) {

		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("FOLHA DE PAGAMENTO:"+"\n");
		sb.append("Departamento " + department.getName());
		sb.append(" = R$ " + String.format("%.2f", department.payroll()) + "\n");
		sb.append("Pagamento realizado no dia " + department.getPayDay() + "\n");
		sb.append("Funcionarios:\n");
		for (Employee emp : department.getEmployees()) {
			sb.append(emp.getName() + "\n");
		}
		sb.append("Para duvidas, favor entrar em contato: ");
		sb.append(department.getAddress().getEmail());

		System.out.println(sb);
	}

}
