import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////Function to insert values in table///////////////////////////////////////////////////////

    /**
     * This is the function who executes the action to insert value in one table
     * @param passWord your password for user in postgresql or PSQL (shell)
     * @param nameOfdataBase the dataBase to connect
     * @param nameOfTable the nameOfTable to insert the value
     * @param nameOfColumn the nameOfColumn to insert the value
     * @param values the value to insert
     */
    public static void Insert(String passWord, String nameOfdataBase, String nameOfTable, String nameOfColumn, String values){
        String url = "jdbc:postgresql://localhost:5432/"+nameOfdataBase;
        String user = "postgres";

        try{
            Connection connection = DriverManager.getConnection(url, user, passWord);
            System.out.println("Connection to " + nameOfdataBase + " successfully");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO " + nameOfTable + '(' + nameOfColumn + ')' + " VALUES " + '(' + values + ')');
            System.out.println("Insert successfully");
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////Function to edit value////////////////////////////////////////////////////////////////

    /**
     * Function who edits value in a specific column in specific id
     * @param passWord your password for psql (Shell) or postgresql
     * @param nameOfDataBase nameOfDataBase to connect
     * @param nameOfTable nameOfTable to update
     * @param nameOfColumnToUpdate nameOfColumnToUpdate just name of column that you want to update
     * @param nameOfColumnId column id
     * @param id id of the value to change
     * @param newValues new value to assign
     */
    public static void Update(String passWord, String nameOfDataBase, String nameOfTable, String nameOfColumnToUpdate, String nameOfColumnId, String id,String newValues){
        String url = "jdbc:postgresql://localhost:5432"+nameOfDataBase;
        String user = "postgres";

        try{
            Connection connection = DriverManager.getConnection(url, user, passWord);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE " + nameOfTable + " SET " + nameOfColumnToUpdate + " = " + newValues + " WHERE " + nameOfColumnId + " = " + id);
            System.out.println("UPDATE successfully");
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////Insert and Update Menu//////////////////////////////////////////////////////////

    /**
     * This is a menu for update || insert action
     * @param choice integer choice by the user
     * @param way_2 choice interface
     */
    public static void UpdateMenu (int choice, String way_2){
        //Just a variable sector
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your password for postGresql or sql Shell: ");
        String passWord = sc.nextLine();

        if(choice == 2){
            System.out.println("Enter a dataBase to connect: ");
            String dataBase = sc.nextLine();
            System.out.println(way_2);
            int nextChoice = sc.nextInt();

            if(nextChoice == 1){
                System.out.println("Enter the table to insert: ");
                String table = sc.nextLine();

                System.out.println("Enter the column to insert: ");
                String columnName = sc.nextLine();

                System.out.println("Enter the values to insert: ");
                String values = sc.nextLine();

                Update.Insert(passWord, dataBase, table, columnName, values);
            }else if(nextChoice == 2){
                System.out.println("Enter the table to update: ");
                String table = sc.nextLine();

                System.out.println("Enter the column target: ");
                String column = sc.nextLine();

                System.out.println("Enter the name of column id: ");
                String columnId = sc.nextLine();

                System.out.println("Enter the id reference: ");
                String id = sc.nextLine();

                System.out.println("Enter the new value: ");
                String newValue = sc.nextLine();

                Update.Update(passWord, dataBase, table, column, columnId, id, newValue);
            }else if(nextChoice == 3){
                Menu.Menu();
            }
        }
    }
}
