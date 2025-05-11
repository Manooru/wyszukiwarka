import java.util.Scanner;
public class Search {
    public static void Search(){
        if (filter.hasGenre==true) {
            //przepraszam za spaghetti, które jest w wyszukiwaniu przez gatunek
            System.out.println("Proszę wybrać następujące gatunki: \n1. Akcja\n2. Komedia\n3. Romantyczne\n\nWpisz 0, aby wyjść z wybrania kategorii i przejść dalej");
            search2();
        }else{ //jak użytkownik nie wyszukuje przez gatunek
            System.out.println("Proszę wybrać przez dany numer.");
            DatabaseSearch.search();
        }
    }
    public static void search2() {
        Scanner scanner = new Scanner(System.in);
        int pick;
        pick = scanner.nextInt();
        switch (pick) { //switch z wyszukiwanie przez gatunek, każda akcja się powtarza, dopóki użytkownik nie wpisze 0
            case 1:
                if(filter.komedia==true||filter.romantyczne==true){
                    System.out.println("Jedno z filtrów jest obecnie włączone. Czy wyłączyć i zamienić na obecnie wybrany?\n1 - tak\n2 - nie");
                    pick= scanner.nextInt();
                    if(pick==1){
                        filter.komedia=false;
                        filter.romantyczne=false;
                        filter.akcja=true;
                        System.out.println("Włączono akcję.");
                    }
                }else{
                    if (filter.akcja = false) { //jeśli filter nie jest włączony, to zostanie włączony, to samo jest dla reszty gatunków
                        filter.akcja = true;
                        System.out.println("Włączono akcję.");
                    } else {
                        System.out.println("Wyszukiwane przez gatunek akcji jest włączone, czy chcesz wyłączyć?\n1 - tak\n 2 - nie");
                        //funkcja z wyłączaniem do wyszukiwania gatunku, to samo występuje u innych gatunków
                        pick = scanner.nextInt();
                        if (pick == 1) {
                            filter.akcja = false;
                            System.out.println("Wyłączono akcję.");
                        }
                    }
                }
                search2();
                break;
            case 2:
                if (filter.akcja == true || filter.romantyczne == true) {
                    System.out.println("Jedno z filtrów jest obecnie włączone. Czy wyłączyć i zamienić na obecnie wybrany?\n1 - tak\n2 - nie");
                    pick= scanner.nextInt();
                    if(pick==1){
                        filter.akcja=false;
                        filter.romantyczne=false;
                        filter.komedia=true;
                        System.out.println("Włączono komedię.");
                    }
                } else {
                    if (filter.komedia = false) {
                        filter.komedia = true;
                        System.out.println("Włączono komedię.");
                    } else {
                        System.out.println("Wyszukiwanie przez gatunek komedii jest włączone, czy chcesz wyłączyć?\n1 - tak\n2 - nie");
                        pick = scanner.nextInt();
                        if (pick == 1) {
                            filter.komedia = false;
                            System.out.println("Wyłączono komedię.");
                        }
                    }
                }
                    search2();
                    break;
                    case 3:
                        if(filter.akcja==true||filter.komedia==true){
                            System.out.println("Jedno z filtrów jest obecnie włączone. Czy wyłączyć i zamienić na obecnie wybrany?\n1 - tak\n2 - nie");
                            pick= scanner.nextInt();
                            if(pick==1){
                                filter.komedia=false;
                                filter.akcja=false;
                                filter.romantyczne=true;
                                System.out.println("Włączono romantyczne.");
                            }
                        }else{
                            if (filter.romantyczne = false) {
                                filter.romantyczne = true;
                                System.out.println("Włączono romantyczne.");
                            } else {
                                System.out.println("Wyszukiwanie przez gatunek romantyczne jest włączone, czy chcesz wyłączyć?\n1 - tak\n2 - nie");
                                pick = scanner.nextInt();
                                if (pick == 1) {
                                    filter.romantyczne = false;
                                    System.out.println("Wyłączono romantyczne.");
                                }
                            }
                        }
                        search2();
                        break;
                    case 0:
                        System.out.println("Wyszukiwanie wyników...");
                        DatabaseSearch.search();
                        break;
                    default:
                        System.out.println("Wpisana wartość nie jest przeywidywaną odpowiedzią. Proszę wybrać ponownie.");
                        search2();
                        break;
        }
    }
}