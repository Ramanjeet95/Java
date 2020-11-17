package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/*
 * Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process 
 * where the byte stream is used to recreate the actual Java object in memory. This mechanism is used to persist the object.
 * The byte stream created is platform independent. So, the object serialized on one platform can be deserialized on a different
 * platform.
 * 
 * The ObjectOutputStream class contains writeObject() method for serializing an Object.
 * The ObjectInputStream class contains readObject() method for deserializing an object.
 * Only the objects of those classes can be serialized which are implementing java.io.Serializable interface.
 * 
 * Points to remember
 * 
 * 1. If a parent class has implemented Serializable interface then child class doesn’t need to implement it but vice-versa is not true.
 * 2. Only non-static data members are saved via Serialization process.
 * 3. Static data members and transient data members are not saved via Serialization process.So, if you don’t want to save value of a non-static data member then make it transient.
 * 4. Constructor of object is never called when an object is deserialized.
 * 5. Associated objects must be implementing Serializable interface.
 * 
 * 
 * SerialVersionUID
 * The Serialization runtime associates a version number with each Serializable class called a SerialVersionUID, which is used during Deserialization to verify that sender and reciever
 * of a serialized object have loaded classes for that object which are compatible with respect to serialization. If the reciever has loaded a class for the object that has different UID
 * than that of corresponding sender’s class, the Deserialization will result in an InvalidClassException. A Serializable class can declare its own UID explicitly by declaring a field name.
 * It must be static, final and of type long.
 * 
 * i.e- ANY-ACCESS-MODIFIER static final long serialVersionUID=42L;
 */
class Employee implements Serializable
{
	private int id;
	private String name;
	private int salary;
	
	public Employee(int id, String name, int salary) 
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
		System.out.println("Employee constructor called");
	}
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getSalary() 
	{
		return salary;
	}
	public void setSalary(int salary) 
	{
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
}

class Student implements Serializable
{
	private int id;
	private String name;
	private Address address;
	
	public Student(int id, String name, Address address) 
	{
		this.id = id;
		this.name = name;
		this.address = address;
		System.out.println("Student constructor called");
	}
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public Address getAddress() 
	{
		return address;
	}

	public void setAddress(Address address) 
	{
		this.address = address;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
}

class Address
{
	private String city;
	private String state;
	private String country;
	
	public Address(String city, String state, String country) 
	{
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	public String getState() 
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getCountry() 
	{
		return country;
	}
	public void setCountry(String country) 
	{
		this.country = country;
	}
	@Override
	public String toString() 
	{
		return "city=" + city;
	}
}

public class Serialization 
{
	public static void main(String[] args)
	{
		//serializeAndReadEmployee();
		serializeAndReadStudent();
	}
	
	private static void serializeAndReadStudent()
	{
		Student s = new Student(1, "Raman", new Address("Jalandhar", "Punjab", "India"));
		FileOutputStream file;
		try 
		{
			file = new FileOutputStream("Student.txt");
			ObjectOutputStream obOut = new ObjectOutputStream(file);
			obOut.writeObject(s);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		FileInputStream file2;
		try 
		{
			file2 = new FileInputStream("Employee.txt");
			ObjectInputStream o = new ObjectInputStream(file2);
			Student e2 = (Student)o.readObject();
			System.out.println(e2);
		} 
		catch (IOException | ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		} 
		
	}

	private static void serializeAndReadEmployee()
	{
		Employee e = new Employee(1, "Raman", 115000);
		FileOutputStream file;
		try 
		{
			file = new FileOutputStream("Employee.txt");
			ObjectOutputStream o = new ObjectOutputStream(file);
			o.writeObject(e);
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		} 
		FileInputStream file2;
		try 
		{
			file2 = new FileInputStream("Employee.txt");
			ObjectInputStream o = new ObjectInputStream(file2);
			Employee e2 = (Employee)o.readObject();
			System.out.println(e2);
		} 
		catch (IOException | ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		} 
	}
}
