import java.awt.Graphics;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;

public abstract class Function extends JPanel {
	
	
	public static double precision = 1.0e-5; //  - inaczej 1*10^(-5) notacja wykl
	
	abstract double f(double x);
	
	
	public double BisectionRoots(double xmin, double xmax) {
		
		double fmin = f(xmin);
		double fmax = f(xmax);
		if(fmin*fmax<0) {
			System.out.println("Zle dane");
			return 0.0;
		}
		while (Math.abs(xmax-xmin)>precision){
			double xmid = 0.5 * (xmax+xmin);
			double fmid = f(xmid);
			if(fmin*fmid<0) {
				xmax=xmid;
				fmax=fmid;
				
			}else if(fmin*fmid>0){
				xmin=xmid;
				fmin=fmid;
					
			}else {
				return xmid;
				
			}
			
			
		}
		return 0.5 *(xmax+xmin);
		
	}
		//wiki:
		//Metoda ma zastosowanie do funkcji stablicowanych w nieparzystej liczbie równo odległych punktów (wliczając końce przedziału całkowania).
		//Metoda opiera się na przybliżaniu funkcji całkowanej przez interpolację wielomianem drugiego stopnia.
		//Znając wartości y0,y1,y2 funkcji f(x) 
		//w 3 punktach x0,x1,x2 
		//przy czym x2-x1=x1-x0=h, 
		//przybliża się funkcję wielomianem Lagrange’a 
		//i całkując w przedziale [x0,x2] otrzymuje przybliżoną wartość całki:
	
		//calkowanie metoda Simpsona dla naszego przedzialu
	
	   public double calka_Simpson(double x0, double x1) {	//nasza calka dla przedzialu
	      int precyzja=100;                    				//  precyzja
	      
	      
	      double h = (x1 - x0) / (precyzja - 1);     		// rozmiar kroku
	 
	      
	      
	      //nasz wzor Simpsona h/3(f0 + 4f1 + f2)
	      
	      // 1/3 
	      double suma = 1.0 / 3.0 * (f(x0) + f(x1));

	      // 4/3 
	      for (int i = 1; i < precyzja - 1; i += 2) {
	         double x = x0 + h * i;
	         suma += 4.0 / 3.0 * f(x);
	      }

	      // 2/3 
	      for (int i = 2; i < precyzja - 1; i += 2) {
	         double x = x0 + h * i;
	         suma += 2.0 / 3.0 * f(x);
	      }

	      return suma * h;
	   }

	   //funkcja szukajaca maksymalnej wartosci na przedziale
	   // 
	   
	   
	   public double znajdz_maximum(double a, double b, double krok) {		 
		    double maximum = f(a);
		    for (double i=a; i <= b; i+=krok) { //iterujemy po przedziale
		        double wartosc = f(i);
		        if (wartosc > maximum) {
		            maximum = wartosc;
		        }
		    }
		    return maximum;
		}
	   

	   //Dodatkowa funkcjanalnosc-dla specjalnej reprezentacji funkcji jako Mapa-
	   //ktora jest objektem przechowujacym podstawowe pary klucz, wartosc-
	   //sprawdzajaca bijektywnosc funkcji na podstawie sprawdzenia rozmiaru zbiorow
	   
	    public static boolean SprawdzBijektywnosc(final Map<Integer, Integer> function) {
	    	
	        final Set<Integer> Dziedzina = new HashSet<>(function.keySet());   			//zbior kluczy
	        final Set<Integer> Przeciwdziedzina  = new HashSet<>(function.values()); 	//wartosci dla kluczy
	        
	        return Dziedzina.equals(Przeciwdziedzina);
	        
	    }


		public abstract void paintComponent(Graphics g);
	   
	
}
