import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.stream.Stream;

public class Cezar {

    public static void main(String[] args) throws IOException {
    	
    	//Prosta implementacja szyfru Cezara strumieniami
    		
        Scanner input = new Scanner(System.in);

        System.out.print("Podaj sciezne do pliku ");
        Path sciezka = Paths.get(input.nextLine());

        System.out.print("Sciezka pliku wyjsciowego ");
        Path zakodowana_sciezka = Paths.get(input.nextLine());

        System.out.print("Przesuniecie dla szyfru Cezara ");
        final int przesuniecie = Integer.parseInt(input.nextLine());
        
        
        //Pobierz strumien pliku wejsciowego, dla ktorego kazda linia jest mapowana przez funkcje szyfruj
        Stream<String> mapuj_strumien = Files.lines(sciezka).map(msg -> Cezar.szyfruj(msg, przesuniecie));

        //Zapisz zaszyfrowana wiadomosc do nowego pliku uzywajac zamapowanego
        // strumienia przez iterator
        
        Files.write(zakodowana_sciezka, (Iterable<String>) mapuj_strumien::iterator, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        // do pliku
        Files.lines(zakodowana_sciezka).map((fileLine) -> Cezar.rozszyfruj(fileLine, przesuniecie)) .forEach(System.out::println);
        
        
        
    }

    public static String szyfruj(String wiadomosc, int przesuniecie) {
        przesuniecie = przesuniecie % 26 + 26; //do reszty dodajemy rozmiar alfabetu - dla nas to 26
        StringBuilder wynik = new StringBuilder(wiadomosc.length());
        
        
        for (char i : wiadomosc.toCharArray()) {
            if (Character.isLetter(i)) {
                char podstawa = Character.isUpperCase(i) ? 'A' : 'a'; //sprawdzamy wielkosc liter
                
                wynik.append((char) (podstawa + (i - podstawa + przesuniecie) % 26));
            } else {
                wynik.append(i);
            }
        }
        return wynik.toString();
    }

    public static String rozszyfruj(String wdm, int przesuniecie) {
        return szyfruj(wdm, 26 - przesuniecie);
    }
}