import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//reprezentacja funkcji przez Mapę
//określąjącą wartości par <k,v> tworzących funkcję


public class JakasFunkcja2 extends Function {

	@Override
	double f(double x) {
		
		
		
		return 0;
	}
	

	public final Map<Integer, Integer> reprezentacja = new HashMap<>();
	 
	public void zbior() {
		
		System.out.println("Utworzono funkcję na zbiorze...");
			        	
	            int n=30;

	            //dziedzina to poprostu kolejne liczby naturalne {1,2,.....}
	            
	            for (int i = 1; i <= n; i++) {
	                reprezentacja.put(i, 4*i);
	            }
		

	
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
	}	
	
	
	
	
}
