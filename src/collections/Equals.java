package collections;

/*
 * In java equals() method is used to compare equality of two Objects. The equality can be compared in two ways:
 * 
 * Shallow comparison: The default implementation of equals method is defined in Java.lang.Object class which simply checks if two Object references (say x and y)
 * refer to the same Object. i.e. It checks if x == y. Since Object class has no data members that define its state, it is also known as shallow comparison.
 * 
 * Deep Comparison: Suppose a class provides its own implementation of equals() method in order to compare the Objects of that class w.r.t state of the Objects. 
 * That means data members (i.e. fields) of Objects are to be compared with one another. Such Comparison based on data members is known as deep comparison.
 * 
 * Some principles of equals() method of Object class : If some other object is equal to a given object, then it follows these rules:
 * 
 * Reflexive : for any reference value a, a.equals(a) should return true.
 * Symmetric : for any reference values a and b, if a.equals(b) should return true then b.equals(a) must return true.
 * Transitive : for any reference values a, b, and c, if a.equals(b) returns true and b.equals(c) returns true, then a.equals(c) should return true.
 * Consistent : for any reference values a and b, multiple invocations of a.equals(b) consistently return true or consistently return false, provided no information
 * used in equals comparisons on the object is modified.
 * 
 * Note: For any non-null reference value a, a.equals(null) should return false.
 * 
 * In the below example
 * 
 * // if(!(obj instanceof Geek)) return false;--> avoid.-->(a)
 * is avoided because
 * Reference obj can also refer to the Object of subclass of Geek. Line (b) ensures that it will return false if passed argument is an Object of subclass of class 
 * Employee. But the instanceof operator condition does not return false if it found the passed argument is a subclass of the class Geek. 
 * 
 */

class Employee  
{ 
    public String name; 
    public int id; 
          
    Employee(String name, int id)  
    { 
              
        this.name = name; 
        this.id = id; 
    } 
      
    @Override
    public boolean equals(Object obj) 
    { 
	    // checking if both the object references are  
	    // referring to the same object. 
	    if(this == obj) 
            return true; 
          
        // it checks if the argument is of the  
        // type Employee by comparing the classes  
        // of the passed argument and this object. 
        // if(!(obj instanceof Employee)) return false; ---> avoid. 
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
          
        // type casting of the argument.  
        Employee employee = (Employee) obj; 
          
        // comparing the state of argument with  
        // the state of 'this' Object. 
        return (employee.name == this.name && employee.id == this.id); 
    } 
      
    @Override
    public int hashCode() 
    { 
          
        // We are returning the Employee_id  
        // as a hashcode value. 
        // we can also return some  
        // other calculated value or may 
        // be memory address of the  
        // Object on which it is invoked.  
        // it depends on how you implement  
        // hashCode() method. 
        return this.id; 
    } 
      
}

public class Equals
{
	public static void main(String[] args) 
	{
		 // creating the Objects of Employee class. 
        Employee g1 = new Employee("aa", 1); 
        Employee g2 = new Employee("aa", 1); 
          
        // comparing above created Objects. 
        if(g1.hashCode() == g2.hashCode()) 
        { 
  
            if(g1.equals(g2)) 
                System.out.println("Both Objects are equal. "); 
            else
                System.out.println("Both Objects are not equal. "); 
      
        } 
        else
        System.out.println("Both Objects are not equal. "); 
	}
}
