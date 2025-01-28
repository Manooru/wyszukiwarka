import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DatabaseSearch {
    public static void search(){
        boolean didSearch=false;
        int idf=0;
        if (didSearch=false){
            idf=0;
        }else{
            idf=2;
        }
        Scanner scanner = new Scanner(System.in);
        if (filter.hasGenre=false){ //gdy uzytkownik wyszukuje przez ID
            if (didSearch=false) {
                //włączenie połączenie z bazą danych
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;

                try {
                    //ustawienie nazwy dla połączenia
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/anime";
                    String username = "root";
                    String password = "";

                    conn = DriverManager.getConnection(url, username, password);

                    String sql = "SELECT * FROM list";
                    pstmt = conn.prepareStatement(sql);

                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");

                        System.out.println("ID: " + id + ", Name: " + name);
                    } //do momentu wyświetlania listy
                    if (idf<1&&idf>13) {
                        System.out.println("\nProszę wybrać anime."); //partia wybrania anime przez ID
                        idf = scanner.nextInt();
                        switch (idf) {
                            case 1:
                                sql = "SELECT * FROM list WHERE ID=1";
                                search();
                                break;
                            case 2:
                                sql = "SELECT * FROM list WHERE ID=2";
                                search();
                                break;
                            case 3:
                                sql = "SELECT * FROM list WHERE ID=3";
                                search();
                                break;
                            case 4:
                                sql = "SELECT * FROM list WHERE ID=4";
                                search();
                                break;
                            case 5:
                                sql = "SELECT * FROM list WHERE ID=5";
                                search();
                                break;
                            case 6:
                                sql = "SELECT * FROM list WHERE ID=6";
                                search();
                                break;
                            case 7:
                                sql = "SELECT * FROM list WHERE ID=7";
                                search();
                                break;
                            case 8:
                                sql = "SELECT * FROM list WHERE ID=8";
                                search();
                                break;
                            case 9:
                                sql = "SELECT * FROM list WHERE ID=9";
                                search();
                                break;
                            case 10:
                                sql = "SELECT * FROM list WHERE ID=10";
                                search();
                                break;
                            case 11:
                                sql = "SELECT * FROM list WHERE ID=11";
                                search();
                                break;
                            case 12:
                                sql = "SELECT * FROM list WHERE ID=12";
                                search();
                                break;
                            case 13:
                                sql = "SELECT * FROM list WHERE ID=13";
                                search();
                                break;
                        }
                    } //zamknięcie połączenia
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (rs != null) rs.close();
                        if (pstmt != null) pstmt.close();
                        if (conn != null) conn.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }else{ //gdy już wyszukiwanie było zrobione, do dodania później

            }
        }else{ // do dodania później

        }
        didSearch=true;
        search();
    }
}
