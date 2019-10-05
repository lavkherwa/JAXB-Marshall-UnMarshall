package com.lav.jaxb;

import com.lav.jaxb.converter.EmployeeConverter;
import com.lav.jaxb.pojo.Employee;

public class Main {

	public static void main(String[] args) {

		Employee employee = new Employee("i001", "Lav", "Bangalore", 2500000);

		EmployeeConverter employeeConverter = new EmployeeConverter();

		/* Show as string */
		employeeConverter.marshallToString(employee);

		/* Create a file */
		employeeConverter.marshallToFile(employee);

		/* Convert from XML to POJO */
		employeeConverter.unmarshallFromFile();

	}
}
