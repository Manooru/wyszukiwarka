import java.sql.*;
import java.util.Scanner;

public class DatabaseSearch {
    private static final String link="jdbc:mysql://localhost:3306/anime";
    private static final String user="root";
    private static final String password="";
    public static final int PAGE_SIZE = 50;

    public static void search() {
        Scanner scanner = new Scanner(System.in);
        int offset=0;
        boolean running=true;
        try (Connection conn = DriverManager.getConnection(link, user, password)) {
            while (running){
                if (filter.display=true){
                    displayRecords(conn, offset);
                }
                filter.display=true;
                System.out.println("Aby przejść do następnej strony, wpisz \"N\".\nAby przejść do poprzedniej strony, wpisz \"W\".\n Aby wyjść, wpisz \"Wyjście\".\nAby wpisać ID, napisz \"ID\".");
                String input=scanner.nextLine().trim().toLowerCase();

                switch (input){
                    case "n":
                        offset+=PAGE_SIZE;
                        break;
                    case "w":
                        if (offset>=PAGE_SIZE){
                            offset-=PAGE_SIZE;
                        }else{
                            System.out.println("Znajdujesz się obecnie na pierwszej stronie.");
                            filter.display=false;
                        }
                        break;
                    case "wyjście","wyjscie":
                        running=false;
                        Index.index();
                        break;
                    case "id":
                        filter.ID=true;
                        System.out.println("Wpisz ID");
                        filter.idn= scanner.nextInt();
                        break;
                    default:
                        System.out.println("Odpowiedź nie jest przewidywaną przez program. Proszę wpisać ponownie. ");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void displayRecords(Connection conn, int offset) throws SQLException {
        String query="";
        if (filter.hasGenre==false){
            if(filter.ID==true){

                query="SELECT * FROM animes WHERE ID="+filter.idn;
            }else {
                query = "SELECT ID, Name FROM animes LIMIT ? OFFSET ?";
            }
        }else{
            if (filter.romantyczne==true&&filter.komedia==false&&filter.akcja==false){
                query="SELECT ID, Name FROM animes LIMIT ? OFFSET ? WHERE Genre='romantyczne'";
            }else if (filter.romantyczne==false&&filter.komedia==true&&filter.akcja==false){
                query="SELECT ID, Name FROM animes LIMIT ? OFFSET ? WHERE Genre='komedia'";
            } else if (filter.romantyczne==false&&filter.komedia==false&&filter.akcja==true){
                query="SELECT ID, Name FROM animes LIMIT ? OFFSET ? WHERE Genre='akcja'";
            }
        }
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, PAGE_SIZE);
            pstmt.setInt(2, offset);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Wyświetlanie 50 wyników:");
                while (rs.next()) {
                    System.out.println("ID: "+rs.getInt("id")+", Nazwa: "+rs.getString("name"));
                }
            }
        }
    }
}