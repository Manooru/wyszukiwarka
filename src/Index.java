import java.util.Scanner;
public class Index {
    public static void index(){ /* Przywitanie użytkownika, wybór wyszukiwania
        lub i wyjście z niego*/
        Scanner scanner=new Scanner(System.in);
        System.out.println("Witaj w wyszukiwarce anime! Co chciałbyś dziś wykonać?\n\n1. Wyszukiwanie\n2. Wyjście");
        int option=scanner.nextInt();
        switch(option){
            case 1:
                searching.search();
                break;
            case 2:
                System.out.println("Czy na pewno chciałbys opuścić program? 1/0");
                option= scanner.nextInt();
                if (option==1){
                    System.exit(0);
                } else {
                    Index.index();
                }
                break;
            default:
                System.out.println("Wybrana wartość nie jest przewidzianą odpowiedzią.");
                Index.index();
                break;
        }
    }
}
