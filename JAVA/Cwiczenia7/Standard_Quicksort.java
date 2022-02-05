
public class Standard_Quicksort {

	
	
	//Standardowy Quicksort stosuje Podejscie Dziel I Zwyciezaj
	
	
	
	
	/*
	 * 
	 * 
		Srednia zlozonosc czasowa dla Quick sort to O(N log(N)).
		
		
		T(N) = Zlozonosc Czasowa dla Quick Sort dla wejscia o rozmiarze N
		
		Na kazdym kroku, wejscie rozmiaru N jest rozbijane na dwie czesci J oraz N-J
		
		
		
		T(N) = T(J) + T(N-J) + M(N)
		
		
		
		Zlozonosc Dla N elementow = 
	        Zlozonosc dla  J elementow + 
	        Zlozonosc dla N-J elementow +
	        Zlozonosc dla znalezienia pivot
		
		
		
		
	 * 
	 * 
	 * 
	 */
	
	
	public void quickSort(Integer[] arr2, int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(arr2, begin, end);

	        quickSort(arr2, begin, partitionIndex-1);
	        quickSort(arr2, partitionIndex+1, end);
	    }
	}
	
	
	
	private int partition(Integer arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;

	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}
	
	
	
	
}
