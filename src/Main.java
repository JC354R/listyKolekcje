import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //wylosuj 10 iczb z zakresu 1 - 20
        int tablicaLiczbLosowych[] = wylosujTablice(10, 1, 20);

        //wypisywanie zawartosci tablicy
        wypisz(tablicaLiczbLosowych);

        //wylosuj 10 liczb bez powtorzen z zakresu 1 - 20
        //__________________________________________________
        // kolekcja
        //List -> ArrayList
        //Set -> HashSet
        //Map -> HashMap
        //w kolekcjach: typy zlozone
        int liczba1 = 0;     //typ prosty (z malej litery) nie ma wlasnych metod
        Integer liczba2 = 0; //typ zlozony (z wielkiej litery) ma wlasne metody
        ArrayList<Integer> wylosowaneLiczby = wylosujLiczbyDoListy(10);
        wypisz(wylosowaneLiczby);
        HashSet<Integer>  zbior = wylosujLiczbyDoZbioru(10);
        wypisz(zbior);
    }

    //__________________________________________________
    //wylosuj liczby do zbioru
    private static HashSet<Integer> wylosujLiczbyDoZbioru(int ileLiczba) {
        Random random = new Random();
        HashSet<Integer> zbiorLiczblosowych = new HashSet<>();
        while(zbiorLiczblosowych.size()<ileLiczba) {
            zbiorLiczblosowych.add(random.nextInt(20) + 1);
        }
        return zbiorLiczblosowych;
    }

    private static ArrayList<Integer> wylosujLiczbyDoListy(int ileLiczb) {
        Random random = new Random();
        ArrayList<Integer> wylosowanaLista = new ArrayList<>();//nie znam rozmiaru listy
        //lista nie moze miec zmienionego rozmiaru w trakcie dzialania

        for (int i = 0; i < ileLiczb; i++) {
            //losowanie bez powtorzen
            int liczba = random.nextInt(20) + 1;
            while (wylosowanaLista.contains(liczba)) {
                liczba = random.nextInt(20) + 1;
            }
            wylosowanaLista.add(liczba);
        }
        return wylosowanaLista;
    }

    private static int[] wylosujTablice(int ileLiczb, int poczatekZakresu, int koniecZakresu) {
        Random random = new Random();
        int[] tablicaLiczbLosowych = new int[ileLiczb];
        //w tablicy: typy proste i zlozone
        //rozmiar tablicy musi byc zdefiniowany przed 1 uzyciem
        //i ni emoze sie pozniej zmienic
        for (int i = 0; i < tablicaLiczbLosowych.length; i++) {
            tablicaLiczbLosowych[i] = random.nextInt(poczatekZakresu, koniecZakresu) + 1;
        }
        return tablicaLiczbLosowych;
    }

    private static void wypisz(ArrayList<Integer> listaDoWypisania) {
        System.out.println("Wylosowana Lista");
        for (int i = 0; i < listaDoWypisania.size(); i++) {
            System.out.print(listaDoWypisania.get(i) + " ");
        }
        System.out.println();
    }

    private static void wypisz(int[] tablicaDoWypisania) {
        System.out.println("Wylosowana tablica: ");
        for (int elementTablicy : tablicaDoWypisania) {
            System.out.print(elementTablicy + " ");
        }
        System.out.println();
    }

    private static void wypisz(HashSet<Integer> zbior) {
        System.out.println("Wylosowany zbior: ");
        for (int elementzbioru : zbior) {
            System.out.print(elementzbioru + " ");
        }
    }
}
