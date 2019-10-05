package com.lav.jaxb.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.lav.jaxb.adapter.DateAdapter;

@XmlRootElement(name = "Employee")
@XmlType(propOrder = { "id", "name", "address", "salary", "date" })
public class Employee {

	// attribute
	private String id;

	// elements
	private String name;
	private String address;
	private float salary;
	private String dummy;

	// complex type
	private Date date;

	public Employee() {
		// No args constructor for JAXB
	}

	public Employee(String id, String name, String address, float salary, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.date = date;
	}

	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@XmlTransient
	public String getDummy() {
		return dummy;
	}

	public void setDummy(String dummy) {
		this.dummy = dummy;
	}

	@XmlElement
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + ", dummy="
				+ dummy + ", date=" + date + "]";
	}

	

}
