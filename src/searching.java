import java.util.Scanner;
public class searching {
    public static void search(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Proszę podać metodę wyszukiwania anime. \n1. Przez ID\n2. Przez gatunek\n3. Wyjście");
        //wybieranie przez użytkowanika opcji wyszukiwania
        int choice= scanner.nextInt();
        switch (choice){
            case 1:
                Search.Search();
                break;
                //zmiana klasy na wyszukiwanie.
            case 2:
                filter.hasGenre=true;
                Search.Search();
                /*zmiana klasy na wyszukiwanie i ustawienie globalnej zmiennej hasgenre na true (oznacza to, że cały proram będzie
                wykorzystywał zmienną pod działanie funkcji*/
                break;
            case 3:
                Index.index();
                //wyjście do głównego menu index
                break;
            default:
                System.out.println("Podana wartość nie jest przewidzianą odpowiedzią.");
                search();
                //powrót na początek klasy, gdy jest wpisana odpowiedź inna, niż przewidywana
                break;
        }
    }
}