package collections;

/*
 * Hashing is a technique used for storing and retrieving information as quickly as possible. It is the process of converting a given key into another value. 
 * A hash function is used to generate the new value according to a mathematical algorithm. The result of a hash function is known as a hash value or simply, a hash.
 * 
 * Hash Function - 
 * 
 * A hash function is any function that can be used to map data of arbitrary size to fixed-size values. The values returned by a hash function are called hash
 * values, hash codes, digests, or simply hashes. The values are used to index a fixed-size table called a hash table
 * 
 * Hash-code Contract - 
 * 
 * Objects that are equal (according to their equals()) must return the same hash code. It's not required for different objects to return different hash codes.
 * The general contract of hashCode() states:
 * 
 * Whenever it is invoked on the same object more than once during an execution of a Java application, hashCode() must consistently return the same value, provided 
 * no information used in equals comparisons on the object is modified. This value needs not remain consistent from one execution of an application to another execution
 * of the same application
 * 
 * If two objects are equal according to the equals(Object) method, then calling the hashCode() method on each of the two objects must produce the same value.
 * 
 * It is not required that if two objects are unequal according to the equals(java.lang.Object) method, then calling the hashCode method on each of the two objects must
 * produce distinct integer results. However, developers should be aware that producing distinct integer results for unequal objects improves the performance of hash tables
 * 
 * Hash Collisions -
 * 
 * When hash code for two different keys is same, that is called a hash code collision. There are many ways to resolve hash collisions.
 * 
 * Finding an alternate location for the hashed key is called collision resolution. There are a number of such techniques:
 * 
 * 1. Direct Chaining: Array of linked list implementation.
 * 
 * 		Separate chaining
 * 
 * Separate Chaining (Open Hashing)
 * 
 * When two or more key's hash points to the same location(hash key) or is same, we can use an array of linked lists and append the keys
 * with same hash code to the linked list(called chain) pointed by the hash key. It is called open hashing because it uses extra memory 
 * to resolve collision.
 * 
 * 2. Open Addressing: Array-based implementation.
 * 
 * 		Linear Probing
 * 		Quadratic Probing
 * 		Double Hashing
 * 
 * Linear Probing
 * In linear probing, We use a regular array instead of linked list and we search the hash table sequentially starting from the original 
 * hash location. If we reach the end of the table, wrap up from last to the first location using the following function :
 * 
 * Rehash(key) = (id + step_size) % TableSize
 * 
 * The major disadvantage of linear probing is the clustering of keys together in a consecutive pattern. This results in one part being
 * very dense, while other parts having few items. It causes long probe searches. Clustering also causes more collisions
 * 
 * Quadratic Probing
 * 
 * Start from the original hash location, and check for locations id + 12, id + 22, id + 32,.. and so on. Wrap around the
 * table if the end is reached. Clustering may also occur in the case of quadratic probing.
 * 
 * Double Hashing
 * 
 * The interval between probes is calculated using another hash function, hence the name double hashing. It reduces clustering
 * effectively.
 * 
 * A good hash function should - 
 * 
 * 1. Use only the data being hashed.
 * 2. Uses all the data being hashed.
 * 3. Be deterministic.
 * 4. Uniformly distribute data.
 * 5. Generate very different hash codes for very similar data.
 * 
 * In java, equals() and hashCode() should be overridden together. 
 */


public class Hashcode 
{
	public static void main(String[] args) 
	{
		
	}
}
