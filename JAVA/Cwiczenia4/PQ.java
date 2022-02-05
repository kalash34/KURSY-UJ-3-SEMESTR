public class PQ
{

    public static void main(String[] args)
    {
	

        System.out.println("Kolejka- zaimplementowana przez kopiec-wiec operacje usuwania/dodawania odbywaja sie w czasie"
        		+ " O(log n)\n - ale juz samo wypisanie elementu z przodu to tylko O(1) ");

        System.out.println("");
    	KolejkaPriorytetowa<Integer> kolejka = new KolejkaPriorytetowa<>(20);

        System.out.println("Kolejka- kolejne 20 liczb naturalnych ");
        System.out.println("");
        
        for (int i = 0; i < 20; i++)
        {
            kolejka.offer(i);
        }

        for (int i = 0; i < 20; i++)
        {
            System.out.println(kolejka.poll());
        }
        


        System.out.println("El o najwyzszym priorytecie = ");
        System.out.println(kolejka.peek());
        
        
        System.out.println();

        KolejkaPriorytetowa<String> kolejka2 = new KolejkaPriorytetowa<>(10);

        kolejka2.offer("Bar");
        kolejka2.offer("Ulica");
        kolejka2.offer("Hamburger");
        kolejka2.offer("233");
        kolejka2.offer("Pasmo Gorskie");
        kolejka2.offer("Owoce");

        System.out.println("El o najwyzszym priorytecie = ");
        System.out.println(kolejka2.peek());
        System.out.println(" ");

        for (int i = 0; i < 5; i++)
        {
            System.out.print(kolejka2.poll() + " ");
        }
        System.out.println();

        KolejkaPriorytetowa<String> q3 = new KolejkaPriorytetowa<>(10, (s1, s2) -> {
            return (s1.length() != s2.length()) ? s1.length() - s2.length() : s1.compareTo(s2);
        });

        q3.offer("Bylem");
        q3.offer("Gdzies");
        q3.offer("Stamtad");
        q3.offer("Owoc");
        q3.offer("Alalalala...");

        for (int i = 0; i < 5; i++)
        {
            System.out.println(q3.poll() + " ");
        }
        
        
        
        
    }
}
