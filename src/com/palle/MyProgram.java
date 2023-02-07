package com.palle;

import java.util.ArrayList;

public class MyProgram {

	public static void main(String[] args) 
	{
		A a= new A();
//		a.creating();
//		a.inserting("mithun", "java", "mitunj@gmail.com");
//		a.inserting("ajay", "java", "ajay@gmail.com");
//		a.inserting("sabarish", "front end", "sab@gmail.com");
//		a.inserting("arun", "databae", "arunnarayanan@gmail.com");
//		a.inserting("krish", "python", "krishj@gmail.com");
//		a.update(3, "Arjun", ".Net", "Arjuna@gmail.com");
//		a.delete(3);
//		a.read();
		ArrayList<Student> al=a.readAll();
		
		for(Student item:al)
		{
			System.out.print(item.getSnum()+"  ");
			System.out.print(item.getName()+"  ");
			System.out.print(item.getSub()+"  ");
			System.out.print(item.getMail()+"  ");
			System.out.println();
			System.out.println("***************************");
		}

		
	}

}
