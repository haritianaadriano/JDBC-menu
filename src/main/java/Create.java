import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Create {
    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////Create Data Base////////////////////////////////////
    /**
     * this function return nothing, it executes the sql request who creates a DataBase.
     * @param dataBaseName: This parameter is the dataBaseName that the user want to make in the input.
     * @throws SQLException
     */
   public static void CreateDataBase(String dataBaseName, String passWord) {
       String url = "jdbc:postgresql://localhost:5432/";
       String user = "postgres";
       String password = passWord;


       try{
          //1. connect to posgresql
          Connection connection = DriverManager.getConnection(url, user, password);
          System.out.println("connexion successfully");
          //2. create a database
          Statement statement = connection.createStatement();
          statement.executeUpdate("CREATE DATABASE " + dataBaseName + ';');
          System.out.println("CREATE TABLE "+ dataBaseName +" successfully");
      }catch (SQLException e){
          System.out.println(e);
      }
   }

    ///////////////////////////////////////////////////////////////////////
   ////////////////////////////Create Table////////////////////////////////
    /**
     * CreateTable is the function who will execute the sql request to create a new Table
     * @param dataBaseName: the dataBaseName to connect
     * @param nameTable: the new nameTable to create
     * @param argument: the column of table with type of argument in String
     */
   public static void CreateTable(String passWord ,String dataBaseName ,String nameTable, String argument){
       String user = "postgres";
       String password = passWord;


        try{
           //1. connecting to database
           Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dataBaseName, user, password);
           System.out.println("Connection to " + dataBaseName + " successfully");
           //2. create the table
           Statement statement = connection.createStatement();
           statement.executeUpdate("CREATE TABLE "+ nameTable + " (" + argument + ";");
           System.out.println("CREATE TABLE " + nameTable + " successfully");
       }catch (SQLException e){
           System.out.println(e);
       }
   }
    ///////////////////////////////////////////////////////////////////////////////////
    /////////////////////////Menu for Create action///////////////////////////////////
    /**
     * This is a function for menu bar for Creat action
     * @param choice
     * @param way_1
     */
   public static void CreateMenu (int choice, String way_1){
       //Just variable
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter your password: ");
       String passWord = sc.nextLine();

       if (choice == 1) {
           System.out.println(way_1);
           int nextChoice = sc.nextInt();
           System.out.println("Please enter a dataBase to connect: ");
           String dataBase = sc.nextLine();

           if (nextChoice == 1) {
               System.out.println("Choose a name for new dataBase");
               System.out.println("Name: ");
               Create.CreateDataBase(dataBase, passWord);
           } else if (nextChoice == 2) {
               System.out.println("Choose your Table name: ");
               String nameOfTable = sc.nextLine();

               System.out.println("Choose your argument: ");
               String argument = sc.nextLine();
               Create.CreateTable(passWord, dataBase, nameOfTable, argument);
           }else if (nextChoice == 3){
               Menu.Menu();
           }
       }
   }

    public static void main(String[] args) {
        CreateDataBase("hello_world", "milamibosy");
    }
}
