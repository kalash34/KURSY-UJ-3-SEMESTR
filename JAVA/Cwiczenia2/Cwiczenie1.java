import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Cwiczenie1 extends JFrame {


public Cwiczenie1() {
    setLayout(new BorderLayout());
    add(new JakasFunkcja3(), BorderLayout.CENTER);
}
    
	
	public static void main(String[] args) {
		
	
		JakasFunkcja f1 = new JakasFunkcja();				
		JakasFunkcja2 f2 = new JakasFunkcja2();		
		f2.zbior();				
		JakasFunkcja3 f3 = new JakasFunkcja3();			
		System.out.println("Sprawdzamy funkcjonalnosci dla pierwszej klasy: f(x)=x^2 + 45x + 1024 \n");
		System.out.println("Bisekcja \n");
		System.out.println(f1.BisectionRoots(-10, 10));
		System.out.println("Calka Simpson \n");
		System.out.println(f1.calka_Simpson(-5.0, 5.0));
		System.out.println("maksimum \n");
		System.out.println(f1.znajdz_maximum(-5, 10, 3));
		System.out.println("Sprawdzamy funkcjonalnosci dla drugiej klasy: f(x)=x^2 + 45x + 1024 \n");
		System.out.println("Bisekcja \n");
		System.out.println(f3.BisectionRoots(-10, 10));
		System.out.println("Calka Simpson \n");
		System.out.println(f3.calka_Simpson(-4.0,4.0));
		
		
		System.out.println("Sprawdzamy funkcjonalnosci dla trzeciej klasy-bijekcja");
		System.out.println("Czy bijekcja? \n");	
		System.out.println(f2.SprawdzBijektywnosc(f2.reprezentacja));		
	    Cwiczenie1 frame = new Cwiczenie1();
	    frame.setSize(800, 800);
	    frame.setTitle("Cwiczenie1-wykresy dwoch funkcji");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);	    
	    JakasFunkcja3.drawComponent panel = f3.new drawComponent();
	    frame.add(panel);
	    frame.setVisible(true);
	    
		
		
		
		
		
		
		
		
		
	}

}
