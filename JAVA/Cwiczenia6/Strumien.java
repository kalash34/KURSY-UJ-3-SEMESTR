import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
 
public class Strumien
{   
	
	private int baza1;	//zmienne statyczne przyporzadkowane do klasy- czyli tylko pierwsza inicjalizacja ma znaczenie
	private int baza2;	//nie sa zwiazane z obiektem
	
	public Strumien(int base1, int base2) {	
		this.baza1=base1;
		this.baza2=base2;
	}
	
    public String baseConversion(String number, int sBase, int dBase)
    {
           	
    	//Parsujemy liczbe w zrodlowym systemie
    	//zwracamy liczbe w okreslonym systemie      
        return Integer.toString(Integer.parseInt(number, sBase), dBase);
    }
	
	
	//wybralem sobie kryterium => jakis string jest liczba gdy ma jakakolwiek cyfre- inaczej
    //trzeba za duzo przypadkow rozwazac
	static boolean hasNumber(String str) {

	    if(str == null || str.isEmpty()) {
	    	return false;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    boolean found = false;
	    for(char c : str.toCharArray()){
	        if(Character.isDigit(c)){
	            sb.append(c);
	            found = true;
	        } else if(found){
	            // stop
	            break;                
	        }
	    }
	    
	    return true;
				
	}
	

    public void modifyFile(String filePath)
    {
    	
    	String sciezka= filePath;
        File fileToBeModified = new File(sciezka); //tworzymy obiekt klasy plik o danej sciezce
        String oldContent = "";
        BufferedReader reader = null;   
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
                     
            //wczytywanie wszystkich linii wejsciowego pliku do oldContent            
            String line = reader.readLine();            
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
            String[] liczby=oldContent.split(" "); //wbudowana metoda, rozdzielamy przez spacje
            for(int j=0;j<liczby.length;j++) {
            	if(hasNumber(liczby[j])) {
            		liczby[j]=baseConversion(liczby[j],this.baza2,this.baza2);
            		
            	}
            }
            

                       
            StringBuilder builder = new StringBuilder();
            for(String s : liczby) {				//iterujemy po tablicy liczby
                builder.append(s);
            }
            String newContent = builder.toString();	//nowa tresc pliku do przepisania
            
            
            //String newContent = oldContent.replaceAll(oldString, newString);
             System.out.println("tutaj");
            //Przepisywanie pliku wejsciowego przez newContent
            writer = new FileWriter(fileToBeModified);           
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally //uzywamy slowa kluczowego finally aby ostatecznie zamknac strumien
        {		//jego pominiecie mogloby doprowadzic do sytuacji w ktorej nie dojdzie do zamkniecia przez blad
        		//blok znajdujacy sie w finally musi wykonac sie zawsze
        
            try
            {
                //zamykamy - to musi sie stac!!
                 
                reader.close();             

            } 
            catch (IOException e) 
            {

            	System.out.println("Nie mozna zamknac reader! ");
                e.printStackTrace();
            }
            try
            {
                //zamykamy - to musi sie stac!!
                 
                writer.close();
                

            } 
            catch (IOException e) 
            {
            	System.out.println("Nie mozna zamknac writer! ");
                e.printStackTrace();
            }
            
            
            
        }
    }
    
}