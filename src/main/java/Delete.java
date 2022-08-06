import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////Delete Data Base////////////////////////////////////
    /**
     * this function return nothing, it executes the sql request who delete a DataBase.
     * @param dataBaseName: This parameter is the dataBaseName that the user want to make in the input.
     * @throws SQLException
     */
    public static void DropDataBase(String dataBaseName, String passWord) {
        String url = "jdbc:postgresql://localhost:5432/";
        String user = "postgres";
        String password = passWord;


        try{
            //1. connect to posgresql
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("connexion successfully");
            //2. create a database
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP DATABASE " + dataBaseName + ';');
            System.out.println("DROP TABLE "+ dataBaseName +" successfully");
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    ///////////////////////////////////////////////////////////////////////
    ////////////////////////////Delete Table////////////////////////////////
    /**
     * DeleteTable is the function who will execute the sql request to delete a new Table
     * @param dataBaseName: the dataBaseName to connect
     * @param nameTable: the name of table
     * @param value: the value to delete in the table
     */
    public static void DeleteValue(String passWord ,String dataBaseName ,String nameTable, String columnName, String value){
        String user = "postgres";
        String password = passWord;


        try{
            //1. connecting to database
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dataBaseName, user, password);
            System.out.println("Connection to " + dataBaseName + " successfully");
            //2. deleting value
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM "+nameTable+" WHERE "+columnName+" = "+value+';');
            System.out.println("DELETE VALUE " + nameTable + " successfully");
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////
    /////////////////////////Menu for delete action///////////////////////////////////
    /**
     * This is a function for menu bar for delete action
     * @param choice
     * @param way_4
     */
    public static void DeleteMenu (int choice, String way_4){
        //Just variable
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String passWord = sc.nextLine();

        if (choice == 1) {
            System.out.println(way_4);
            int nextChoice = sc.nextInt();
            System.out.println("Please enter a dataBase to connect: ");
            String dataBase = sc.nextLine();

            if (nextChoice == 1) {
                System.out.println("Enter a dataBase to delete: ");
                String dataBaseD = sc.nextLine();
                Delete.DropDataBase(dataBaseD, passWord);
            } else if (nextChoice == 2) {
                System.out.println("Choose your Table name: ");
                String nameOfTable = sc.nextLine();

                System.out.println("Enter a column specific: ");
                String column = sc.nextLine();

                System.out.println("Choose the value to delete: ");
                String value = sc.nextLine();

                Delete.DeleteValue(passWord, dataBase, nameOfTable, column, value);
            }else if (nextChoice == 3){
                Menu.Menu();
            }
        }
    }

}
