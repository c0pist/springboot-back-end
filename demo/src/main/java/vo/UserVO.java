package vo;

import lombok.Data;

@Data

public class UserVO {
	
	int id;
	String username;
	String password;
	String firstName;
	String lastName;
	int age;
	int salary;
	
	public void setFirstName(String data) {
		firstName = data;
	}
	
	public void setLastName(String data) {
		lastName = data;
	}
	
	public void setAge(int data) {
		age = data;
	}
	
	public void setSalary(int data) {
		salary = data;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getSalary() {
		return salary;
	}
	
}

