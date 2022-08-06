import java.sql.*;
import java.util.Scanner;

public class Read {
    ///////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////Function who reads the table////////////////////////////////

    /**
     * This function reads the table component for 3 columns
     * @param passWord for postgresql or psql Shell
     * @param nameOfDataBase database to connect
     * @param nameOfTable table to read
     */
    public static void Read (String passWord, String nameOfDataBase, String nameOfTable){
        String url = "jdbc:postgresql://localhost:5432:/"+nameOfDataBase;
        String user = "postgres";
        ResultSet result = null;

        try{
            Connection connection = DriverManager.getConnection(url, user, passWord);
            Statement statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM " + nameOfTable);

            while(result.next()){
                System.out.println(result.getString(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////Menu for Read action///////////////////////////////////////
    public static void ReadMenu(int choice){
        //Just variable sector
        Scanner sc = new Scanner(System.in);

        if(choice == 3){
            System.out.println("Enter your password for postgresql or psql Shell: ");
            String password = sc.nextLine();

            System.out.println("Enter the dataBase to connect: ");
            String dataBase = sc.nextLine();

            System.out.println("Enter the table to read: ");
            String table = sc.nextLine();

            Read.Read(password, dataBase, table);

            System.out.println("Enter '3' to quit");
            int quit = sc.nextInt();
            if(quit == 3){
                Menu.Menu();
            }
        }
    }
}
