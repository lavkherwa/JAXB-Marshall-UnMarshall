package com.lav.jaxb.converter;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.lav.jaxb.pojo.Employee;

public class EmployeeConverter {

	public void marshallToString(Employee employee) {
		StringWriter stringWriter = new StringWriter();
		String result;

		try {

			/* Get the JAXB context for given class */
			JAXBContext context = JAXBContext.newInstance(Employee.class);

			/* Create a marshaler instance from given context */
			Marshaller marshaller = context.createMarshaller();

			/* Tell marshaler to encode the context in UTF8 */
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			/* Get the context in a stringWriter */
			marshaller.marshal(employee, stringWriter);

			/* Get data from string writer into an string object and print */
			result = stringWriter.toString();
			System.out.println(result);

		} catch (Exception e) {
			System.out.println("something went wrong" + e.getMessage());
		}

	}

	public void marshallToFile(Employee employee) {

		try {

			/* Get the JAXB context for given class */
			JAXBContext context = JAXBContext.newInstance(Employee.class);

			/* Create a marshaler instance from given context */
			Marshaller marshaller = context.createMarshaller();

			/* Tell marshaler to encode the context in UTF8 */
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			/* Get the context in a stream */
			marshaller.marshal(employee, System.out);

			/* Write the content to a file */
			marshaller.marshal(employee, new File("Employee.xml"));

		} catch (Exception e) {
			System.out.println("\n\nsomething went wrong" + e.getMessage());
		}

	}

	public void unmarshallFromFile() {

		try {

			/* Get the JAXB context for given class */
			JAXBContext context = JAXBContext.newInstance(Employee.class);

			/* Create a unmarshaler instance from given context */
			Unmarshaller unmarshaler = context.createUnmarshaller();

			/* unmarshal the context */
			Employee employee = (Employee) unmarshaler.unmarshal(new File("Employee.xml"));

			/* Display the output */
			System.out.println(employee.toString());

		} catch (Exception e) {
			System.out.println("\n\nsomething went wrong" + e.getMessage());
		}

	}

}
