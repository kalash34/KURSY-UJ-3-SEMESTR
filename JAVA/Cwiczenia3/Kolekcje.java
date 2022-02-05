import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

import java.util.Collections;

/*  
 * 
 * 
POROWNANIE CZASU DLA OPERACJI:

add(),
remove(),
contains(),
toArray(),


 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
ArrayList
HashSet
LinkedList
Stack
Vector
PriorityQueue
TreeSet
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class Kolekcje {
	
	public static void initializeCollection(Collection<Integer> c) {
		 final long startTime = System.nanoTime();
		 final long duration;
		
		
		Date d0 = new Date();
				
		int srodek=5000; 
		//srodkowy indeks do sprawdzenia dostepu do
		//srodkowego elementu	
		for (int i=0; i<10000; i++) {
			if(i==500) {
				c.add(-10); //element do sprawdzenia szybkosci szukania/usuwania/znajdywania
			}else {
				c.add((int)(Math.random()*20000000));
			}		
		}

        duration = System.nanoTime() - startTime; 
		Date d1 = new Date();
		System.out.println(" Zainicjowano w czasie " + (d1.getTime()-d0.getTime()) + " [ms]");

		System.out.println(" Zainicjowano w czasie " + duration + " [ns]");
	}
	/*
	public static void testCollection(Collection<Integer> c) {
		Date d0 = new Date();
		int counter = 0;
		for(int i=1; i<10000; i++) {
			int k = (int)(Math.random()*20000000);
			if (c.contains(k))
				counter++;
		}
		Date d1 = new Date();
		System.out.println(" Znaleziono " + counter + " w czasie " + (d1.getTime()-d0.getTime()) + " [ms]");
		
	}
	*/
	public static void addToCollection(Collection<Integer> c) {
		final long startTime = System.nanoTime();
		 final long duration;
		
		
		
		
		Date d0 = new Date();
		c.add((int)(Math.random()*20000000));

        duration = System.nanoTime() - startTime; 
		Date d1 = new Date();
		System.out.println(" Dodano w czasie " + (d1.getTime()-d0.getTime()) + " [ms]");
		

		System.out.println(" Dodano w czasie " + duration  + " [ns]");
		
	}

	
	public static void removeFromCollection(Collection<Integer> c) {
		
		final long startTime = System.nanoTime();
		final long duration;
		
		Date d0 = new Date();
		//int last_index = c.size()-1;
		c.remove(5000); //indeks elementu -10	
        duration = System.nanoTime() - startTime; 
		Date d1 = new Date();
		System.out.println(" Usunieto srodkowy remove(5000) w czasie " + (d1.getTime()-d0.getTime()) + " [ms]");

		System.out.println("  Usunieto srodkowy remove(5000) w czasie  " + duration  + " [ns]");
		
	}


	public static void ContainsCollection(Collection<Integer> c) {

		final long startTime = System.nanoTime();
		final long duration;
		
		Date d0 = new Date();
		c.contains(-10);
		Date d1 = new Date();

        duration = System.nanoTime() - startTime; 
		System.out.println(" Contains(-10) w czasie " + (d1.getTime()-d0.getTime()) + " [ms]");
		System.out.println(" Contains(-10) w czasie " + duration + " [ns]");
		
		
		
	}
	

	public static void toArrayCollection(Collection<Integer> c) {
		final long startTime = System.nanoTime();
		final long duration;
		
		Date d0 = new Date();
		c.toArray();
		Date d1 = new Date();

        duration = System.nanoTime() - startTime; 
		System.out.println(" toArray() w czasie " + (d1.getTime()-d0.getTime()) + " [ms]");

		System.out.println(" toArray() w czasie " + duration  + " [ns]");
		
		
	}
	
	
	public static void testArrayList() {
		ArrayList<Integer> al = new ArrayList<>();
		Kolekcje.initializeCollection(al);
		//Kolekcje.testCollection(al);
		Kolekcje.addToCollection(al);
		Kolekcje.removeFromCollection(al);
		Kolekcje.ContainsCollection(al);
		Kolekcje.toArrayCollection(al);
		
		
	}
	
	public static void testVector() {
		Vector<Integer> v = new Vector<>();
		Kolekcje.initializeCollection(v);
		//Kolekcje.testCollection(v);
		
		Kolekcje.addToCollection(v);
		Kolekcje.removeFromCollection(v);
		Kolekcje.ContainsCollection(v);
		Kolekcje.toArrayCollection(v);

	}

	public static void testTreeSet() {
		TreeSet<Integer> ts = new TreeSet<>();
		Kolekcje.initializeCollection(ts);
	//	Kolekcje.testCollection(ts);
		
		Kolekcje.addToCollection(ts);
		Kolekcje.removeFromCollection(ts);
		Kolekcje.ContainsCollection(ts);
		Kolekcje.toArrayCollection(ts);
	}
	
	public static void testHashSet() {
		HashSet<Integer> hs = new HashSet<>();
		Kolekcje.initializeCollection(hs);
	//	Kolekcje.testCollection(hs);
		
		Kolekcje.addToCollection(hs);
		Kolekcje.removeFromCollection(hs);
		Kolekcje.ContainsCollection(hs);
		Kolekcje.toArrayCollection(hs);
	}

	
	public static void testPriorityQueue() {
		PriorityQueue<Integer> ps = new PriorityQueue<>();
		Kolekcje.initializeCollection(ps);
		//Kolekcje.testCollection(ps);
		
		Kolekcje.addToCollection(ps);
		Kolekcje.removeFromCollection(ps);
		Kolekcje.ContainsCollection(ps);
		Kolekcje.toArrayCollection(ps);
	}
	
	
	public static void testStack() {
		Stack<Integer> st = new Stack<>();
		Kolekcje.initializeCollection(st);
	//	Kolekcje.testCollection(st);
		
		Kolekcje.addToCollection(st);
		Kolekcje.removeFromCollection(st);
		Kolekcje.ContainsCollection(st);
		Kolekcje.toArrayCollection(st);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
	//	SampleJConsoleConnectProgram t1 = new SampleJConsoleConnectProgram();
					
		Thread.sleep(10000);
		System.out.format("+-----------------+------+%n");
		System.out.format("| ArrayList     | 1  |%n");
		System.out.format("+-----------------+------+%n");
		Kolekcje.testArrayList();

		System.out.format("+-----------------+------+%n");
		System.gc();

		
		Thread.sleep(5000);
		System.out.format("+-----------------+------+%n");
		System.out.format("| Vector    | 2  |%n");
		System.out.format("+-----------------+------+%n");
		Kolekcje.testVector();

		System.out.format("+-----------------+------+%n");
		System.gc();
		
		
		
		
		Thread.sleep(5000);
		System.out.format("+-----------------+------+%n");
		System.out.format("| TreeSet    | 3  |%n");
		System.out.format("+-----------------+------+%n");
		Kolekcje.testTreeSet();
		System.gc();

		System.out.format("+-----------------+------+%n");
		
		
		
		
		Thread.sleep(5000);
		System.out.format("+-----------------+------+%n");
		System.out.format("| HashSet    | 4  |%n");
		System.out.format("+-----------------+------+%n");
		Kolekcje.testHashSet();
		System.gc();

		System.out.format("+-----------------+------+%n");
		
		
		
		Thread.sleep(5000);
		System.out.format("+-----------------+------+%n");
		System.out.format("| Stack    | 5    |%n");
		System.out.format("+-----------------+------+%n");
		Kolekcje.testStack();
		System.gc();
		
		
		
		
		
		Thread.sleep(5000);
		System.out.format("+-----------------+------+%n");
		System.out.format("| PriorityQueue   | 6  |%n");
		System.out.format("+-----------------+------+%n");
		Kolekcje.testPriorityQueue();
		System.gc();
		System.out.format("+-----------------+------+%n");
		
		Thread.sleep(5000);
		
	
	}
}