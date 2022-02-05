import java.util.Comparator;




//kolejka priorytetowa za pomoca kopca- ktory zaimplementowano przy uzyciu tablicy

//podstawowe operacje



/*
 

 */


//WYKORZYSTALEM INTERFEJS COMPARATOR
//https://www.geeksforgeeks.org/comparator-interface-java/  - artykuł o interfejsie


//DODATKOWO UŻYŁEM KLASY OBJECT
//NAJWAZNIEJSZEJ KLASY W KONTEKSCIE DZIEDZICZENIA W JAVIE
//


//  https://programistajava.pl/klasa-object-poczatek-hierarchii-dziedziczenia/
//	http://journals.ecs.soton.ac.uk/java/tutorial/java/javaOO/objectclass.html

//ustalanie priorytetow dla obiektow odbywa sie przez
// wlasciwosci interfejsu comparable
// na jego podstawie ustalamy kryterium porządkowe


//https://devcave.pl/effective-java/interfejs-comparable



//Kolejka zaimplementowana jest na podstawie kopca - który z kolei implementuje na tablicy
//Artykul dlaczego mozna tak zrobic

// http://math.uni.wroc.pl/~jagiella/p2python/skrypt_html/wyklad9.html








public class KolejkaPriorytetowa<T>
{

    private int wielkosc;

    private Object H[];      		//tablica ktora reprezentuje kopiec

    public KolejkaPriorytetowa(int rozmiar)
    {
        H = new Object[rozmiar];    //inicjalizacja tablicy
    }

    private Comparator<T> comparator; //obiekt klasy comparator

    public KolejkaPriorytetowa(int rozmiar, Comparator<T> comparator)
    {
        this.comparator = comparator;
        H = new Object[rozmiar];
    }

    private T rodzic(int i)				//dostep do rodzica elementu o itym indeksie
    {
        return (T) H[ (i - 1) / 2 ];
    }

    private T lewy(int i)				//lewy syn (lewa galaz drzewa)
    {
        return (T) H[ 2 * i + 1 ];
    }

    private T prawy(int i)				//prawy syn (prawa galaz drzewa)
    {
        return (T) H[ 2 * i + 2 ];
    }
    
    //ponizej definiujemy funkcje okreslajace kryteria porzadkowe

    private boolean wiekszeLubRowne(T e1, T e2) 		// zwracamy e1>=e2 kryterium porownawcze ustala comparator
    {
        if (comparator != null)
        {
            return comparator.compare(e1, e2) >= 0;
        }

        else
        {
            return ((Comparable<T>) e1).compareTo(e2) >= 0;
        }
    }

    private boolean mniejszeOd(T e1, T e2) 				// zwracamy e1<e2 kryterium porownawcze ustala comparator
    {
        if (comparator != null)
        {
            return comparator.compare(e1, e2) < 0;
        }

        else
        {
            return ((Comparable<T>) e1).compareTo(e2) < 0;
        }
    }

    private boolean mniejszeLubRowne(T e1, T e2) 			// zwracamy e1<=e2
    {
        if (comparator != null)
        {
            return comparator.compare(e1, e2) <= 0;
        }

        else
        {
            return ((Comparable<T>) e1).compareTo(e2) <= 0;
        }
    }

    private boolean wiekszeOd(T e1, T e2)				 // zwroc e1>e2
    {
        if (comparator != null)
        {
            return comparator.compare(e1, e2) > 0;
        }

        else
        {
            return ((Comparable<T>) e1).compareTo(e2) > 0;
        }
    }

    //zamiana elementow o indeksach
    
    
    private void swap(int indeks1, int indeks2)
    {
        T temp = get(indeks1);
        H[indeks1] = H[indeks2];
        H[indeks2] = temp;
    }

    
    
    // Metoda zwracajaca element o itym indeksie
    
    private T get(int i)
    {
        return (T) H[i];
    }

    //przesuniecie do gory
    

    //przesuniecie w gore
    //najgorszy przypadek O(log n)
    // bo sumuja sie zlozonosci na galeziach drzewa
    //
    //a przechodzenie kopca == O(log n)
    
    
    private void shiftUp(int i)
    {
        while (i > 0 & wiekszeLubRowne(get(i), rodzic(i)))
        {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }
    
    
    //przesuniecie w dol
    //najgorszy przypadek O(log n)
    // bo sumuja sie zlozonosci na galeziach drzewa
    //
    //a przechodzenie kopca == O(log n)
    
    
    private void shiftDown(int i)
    {
        int max_index = i;

        if ((2 * i + 1) <= wielkosc-1 && mniejszeOd(get(max_index), lewy(i))) {
            max_index = 2 * i + 1;
        }

        if (((2 * i + 2) <= wielkosc-1) && (mniejszeOd(get(max_index), prawy(i)))) {
            max_index = 2 * i + 2;
        }

        if (i != max_index)
        {
            swap(i, max_index);
            shiftDown(max_index);
        }
    }
    
    
    
    
    //operacja offer wstawia element do kolejki

    public void offer(T data)    //wstawiamy nowy element do kolejki
    {
        if(wielkosc == H.length) {  					//jesli osiagniemy limit tablicy
            System.out.println("Kolejka jest pełna");
        }
        else
        {
            H[wielkosc] = (T) data;
            shiftUp(wielkosc);
            wielkosc++;
        }

    }
    
    //uwaga - MOJA METODA peek to rownowaznosc metody ADD z tresci zadania-
    //wynika to z tego ze we wbudowanej implementacji w JAVA
    //sa takie nazwy- i chcialem zachowac sens tych operacji
    
    
    
    

    public T peek()	//element o najwiekszym priorytecie kopiec-max   zlozonosc== O(1) - bez usuwania
    {
        return get(0);
    }

    
    //zwraca i usuwa element z przodu kolejki-czyli najwiekszy priorytet
    //calkowita zlozonosc to O(log n)
    //wynika to z faktu
    //
    
    public T poll()
    {
    	//jesli tablica kopca=0
        if(wielkosc==0)
        {
            System.out.println("Kolejka jest pusta");
            return null;
        }
        // wpp 
        else
        {
            T result = get(0);

            H[0] = H[wielkosc-1];
            wielkosc--;
            shiftDown(0);
            return result;
            
        }
    }

    public T remove(T e)
    {
       
        return e;
    }

    public void replace(T e1, T e2)
    {
        offer(e2);
        remove(e1);
    }

}