
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
*Klasa definiuje metode sortowania szybkiego sortujaca tablice porownywalnych obiektow w miejscu uzywajac wielu watkow
*do zrownoleglania sortowania
*
*Wielowatkowosc pozwala na szybsze wykonanie zadan przez rozbicie problemow na mniejsze podproblemy
*
*artykul
*
*https://medium.com/@lsmoreira77/multithreading-concurrency-performance-in-java-7df774c3b92d
*
* 
*/


public class MultiThreadQuicksort {
	
	
	
	
	
	private static final int N_THREADS = Runtime.getRuntime().availableProcessors();


	private static final int FALLBACK = 2;

	/**
	 * pool sluzacy do wykonywania sortujacych runnable
	 */
	private static Executor pool = Executors.newFixedThreadPool(N_THREADS);

	/**
	 * Metoda main uzywana do sortowania z klientow Input jest sortowany w miejscu uzywajac
	 * wielu watkow
	 * 
	 * wejscie
	 * tabllica do posortowania
	 * <T> typ obiektu sortowanego - uzywamy do porownywania interfejsu Comparable
	 *           
	 */
	
	
	public static <T extends Comparable<T>> void quicksort(T[] input) {
		final AtomicInteger count = new AtomicInteger(1);
		pool.execute(new QuicksortRunnable<T>(input, 0, input.length - 1, count));
		try {
			synchronized (count) {
				count.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 *
	 * 
	 * Sortuje sekcje tablicy quicksortem Metoda uzywana nie jest
	 * rekurencyjna tylko tworzy nowe runnable i przekazuje do
	 * ThreadPoolExecutor
	 * 
	 */
	
	
	private static class QuicksortRunnable<T extends Comparable<T>> implements
			Runnable {
		
		
		
		//sortowana tablica
		
		private final T[] values;
		
		/**
		 * Indeks startowy czesci tablicy do posortowania
		 * 
		 */
		
		private final int left;
		
		/**
		 * Koncowy indeks sortowanej czesci tablicy
		 */
		
		private final int right;
		
		/**
		 * Liczba watkow wykonujacych sie
		 */
		
		private final AtomicInteger count;

		/**
		 * Konstruktor podstawowy ustawia Runnable object
		 * 
		 * wartosci tablicy do posortowania
		 *            
		 * left- Indeks startowy czesci tablicy do posortowania
		 *            
		 *            
		 * right
		 *       Indeks koncowy czesci do posortowania
		 * count - liczba wykoujacych sie watkow
		 *            
		 */
		
		public QuicksortRunnable(T[] values, int left, int right,
				AtomicInteger count) {
			
			this.values = values;
			this.left = left;
			this.right = right;
			this.count = count;
		}

		/**
		 * 
		 * 
		 * Logika watku. Jezeli ten watek zakonczyl swoja prace
		 * sprawdza czy to samo tyczy sie pozostalych watkow
		 * Jezeli tak, notify obiekt count zeby przestac blokowac Sorter
		 * 
		 * 
		 * 
		 */
		
		
		
		
		@Override
		public void run() {
			
			quicksort(left, right);
			
			synchronized (count) {
				//
				// AtomicInteger.getDecrement() zwraca stara wartosc jezeli starsa wartosc
				// to -1 to wiemy ze aktualna wartosc to 0
				// 
				
				
				
				if (count.getAndDecrement() == 1) {
					count.notify();
				}
				
				
			}
		}

		/**
		 * 
		 * Metoda ktora sortuje. Cofa sie na rekursji jezeli
		 * jest okreslona liczba w kolejce zadan
		 * 
		 */
		
		private void quicksort(int pLeft, int pRight) {
			
			if (pLeft < pRight) {
				int storeIndex = partition(pLeft, pRight);
				if (count.get() >= FALLBACK * N_THREADS) {
					quicksort(pLeft, storeIndex - 1);
					quicksort(storeIndex + 1, pRight);
				} else {
					count.getAndAdd(2);
					pool.execute(new QuicksortRunnable<T>(values, pLeft,
							storeIndex - 1, count));
					pool.execute(new QuicksortRunnable<T>(values,
							storeIndex + 1, pRight, count));
				}
			}
			
		}

		/**
		 * 
		 * 
		 * Dzieli fragment tablicy miedzy indeksy lewy i prawy
		 * przemieszczajac wszystkie elementy mniejsze niz values[pivotIndex]
		 * przed pivot oraz rowne lub wieksze elementy poza nimi
		 * 
		 * 
		 * zwraca ostateczny indeks dla pivot
		 * 
		
		 * 
		 */
		
		
		
		private int partition(int pLeft, int pRight) {
			
			T pivotValue = values[pRight];
			int storeIndex = pLeft;
			for (int i = pLeft; i < pRight; i++) {
				if (values[i].compareTo(pivotValue) < 0) {
					swap(i, storeIndex);
					storeIndex++;
				}
				
			}
			swap(storeIndex, pRight);
			return storeIndex;
		}

		/**
		 * 
		 * METODA DO SWAPOWANIA
		 * 
		 *               indeks pierwszej wartosci do swapa z druga
		 *            
		 * 
		 * 				indeks drugiej wartosci do swapa z pierwsza
		 * 
		 */
		
		
		
		private void swap(int left, int right) {
			T temp = values[left];
			values[left] = values[right];
			values[right] = temp;
		}
	}
	
	public static void main(String[] args) {
		
		
		
		 Random rd = new Random(); // obiekt klasy random
		 
	      Integer[] arr = new Integer[1000];
	      
	      for (int i = 0; i < arr.length; i++) {
	    	  
	         arr[i] = rd.nextInt(); 
	        // System.out.println(arr[i]); 
	      }
		
		Integer[] arr2=arr; //druga taka sama tablica
		
		
		Standard_Quicksort normal=new Standard_Quicksort();
		
		
		
		Date d0 = new Date();
		MultiThreadQuicksort.quicksort(arr);

		Date d1 = new Date();
		System.out.println("Wielowatkowy Quicksort : posortowano w czasie " + (d1.getTime()-d0.getTime()) + " [ms]");
		
		

		d0 = new Date();
		normal.quickSort(arr2,0,999);

		d1 = new Date();
		System.out.println("Standardowy Quicksort : posortowano w czasie " + (d1.getTime()-d0.getTime()) + " [ms]");
		
		
		
		
		
	}
}





