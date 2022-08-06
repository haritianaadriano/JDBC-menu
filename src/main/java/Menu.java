public class Menu {
    /**
     * Just views aspect
     */
    public static void Menu (){
       String barre = "----------------------------------------------------------------";
       String choice = "Choose a number for executing action";
       String welcome = "welcome in JDBC";
       String menu= "\n 1. Create dataBase || Create Table" +
               "\n 2. Insert values || Edit values" +
               "\n 3. Read values" +
               "\n 4. Delete values || Delete Table";

        System.out.println(barre);
        System.out.println(welcome);
        System.out.println(choice);
        System.out.println(menu);
        System.out.println(barre);
    }
}
