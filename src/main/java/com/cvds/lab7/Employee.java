package com.cvds.lab7;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String role;
	private Double salary;
	private LocalDate fecha_nacimiento;
	private int edad;

	public Employee() {

	}

	public Employee(String string, String string2, String string3, double d, String nacimiento) {
		this.firstName = string;
		this.lastName = string2;
		this.role = string3;
		this.salary = d;
		this.fecha_nacimiento = LocalDate.parse(nacimiento);
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long EmployeeId) {
		this.employeeId = EmployeeId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String FirstName) {
		this.firstName = FirstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String LastName) {
		this.lastName = LastName;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String Role) {
		this.role = Role;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double Salary) {
		this.salary = Salary;
	}

	public LocalDate getFechaNacimiento() {
		return this.fecha_nacimiento;
	}

	public void setFechaNacimiento(LocalDate Fecha) {
		this.fecha_nacimiento = Fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((fecha_nacimiento == null) ? 0 : fecha_nacimiento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (fecha_nacimiento == null) {
			if (other.fecha_nacimiento != null)
				return false;
		} else if (!fecha_nacimiento.equals(other.fecha_nacimiento))
			return false;
		return true;
	}

	public int calcular_edad() {
		// Año actual
		LocalDate fecha_actual = LocalDate.now();
		// edad
		Period diferencia = Period.between(fecha_nacimiento, fecha_actual);
		int edad = diferencia.getYears();
		return edad;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", role="
				+ role + ", salary=" + salary + ", fecha_nacimiento=" + fecha_nacimiento + ", edad=" + calcular_edad() + "]";
	}

}