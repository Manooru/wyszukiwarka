import java.util.Scanner;
public class Search {
    public static void Search(){
        //przepraszam za spaghetti, które jest w wyszukiwaniu przez gatunek
            System.out.println("Proszę wybrać następujące gatunki: \n1. Akcja\n2. Komedia\n3. Romantyczne\n\nWpisz 0, aby wyjść z wybrania kategorii i przejść dalej");
            search2();
    }
    public static void search2(){
        Scanner scanner=new Scanner(System.in);
        int pick;
        pick= scanner.nextInt();
        switch (pick){
            case 1:
                if(filter.akcja=false){
                    filter.akcja=true;
                }else{
                    System.out.println("Wyszukiwane przez gatunek akcji jest włączone, czy chcesz wyłączyć?\n1 - tak\n 2 - nie");
                    pick= scanner.nextInt();
                    if(pick==1){
                        filter.akcja=false;
                    }
                }
                search2();
                break;
            case 2:
                if(filter.komedia=false){
                    filter.komedia=true;
                }else{
                    System.out.println("Wyszukiwanie przez gatunek komedii jest włączone, czy chcesz wyłączyć?\n1 - tak\n2 - nie");
                    pick= scanner.nextInt();
                    if(pick==1){
                        filter.komedia=false;
                    }
                }
                search2();
                break;
            case 3:
                if(filter.romantyczne=false){
                    filter.romantyczne=true;
                }else{
                    System.out.println("Wyszukiwanie przez gatunek romantyczne jest włączone, czy chcesz wyłaczyć?\n1 - tak\n2 - nie");
                    pick= scanner.nextInt();
                    if(pick==1){
                        filter.romantyczne=false;
                    }
                }
                search2();
                break;
            case 0:
                break;
        }
    }
}