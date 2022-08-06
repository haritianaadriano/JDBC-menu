import java.util.Scanner;

public class Main {
    static String way_1 = " 1.would you create a dataBase ?"+
                    " 2.would you create a table ?"+
                    "3. quit ?";
    static String way_2 = " 1.would you insert value ?"+
                    " 2.would you edit value ?"+
                    "3. quit ?";

    static String way_4 = " 1.would you delete value ?"+
                    " 2.would you delete table"+
                    "3. quit ?";
    /***********************************************/

    public static void main(String[] args) {
        Menu.Menu();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        Create.CreateMenu(choice, way_1);
        Read.ReadMenu(choice);
        Update.UpdateMenu(choice, way_2);
        Delete.DeleteMenu(choice, way_4);
    }
}
