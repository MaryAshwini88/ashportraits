package com.ash.portraits;

class Employee {
	
    int age;
    String name; 
    int salary;
    String dep;
    
	public Employee(int age, String name, int salary, String dep) {
		super();
		this.age = age;
		this.name = name;
		this.salary = salary;
		this.dep = dep;
	}

	@Override
	public String toString() {
		return " age=" + age + ", name=" + name + ", salary=" + salary + ", dep=" + dep ;
	}
   
	

 }