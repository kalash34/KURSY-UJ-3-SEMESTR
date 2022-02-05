import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.stream.Stream;


	
	


public class Zadanie8 {

	public static void main(String[] args) throws IOException {
		
			Strumien str=new Strumien(10, 2);
			

	       // System.out.println(str.baza1);
	       // System.out.println(str.baza2);
			
			/*
			 * 
			 
    FileReader fr = new FileReader("test.txt");
    BufferedReader br = new BufferedReader(fr);

    String line;
    
    while ((line = br.readLine()) != null) {
        // process the line.
    }
    br.close();
    
    
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
			
			
			
	        System.out.println("Podaj sciezke do pliku ");
	        

	        Scanner input = new Scanner(System.in);

	        String sciezka = input.nextLine();
	        
	        
	        
		 	str.modifyFile(sciezka);
         
	        System.out.println("done");
		


	}

}
