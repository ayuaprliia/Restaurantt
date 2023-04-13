import java.util.*;
public class Application {
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        System.out.println("*-*-*-*-*-*Welcome to TOMS*-*-*-*-*-*\n");

        System.out.print("Enter Restaurant/Cafe Name: ");
        String shopName = input.nextLine();
        Manager.setShopName(shopName);

        Manager manager = new Manager();
        manager.createNewManager(); //Create new manager account at start, each time TOMS is executed

        String username = "", password = "";
        while (true) {
            boolean isValid = false;
            while (!isValid) {
                System.out.println("\n" + Manager.getShopName() + " Login");
                for (int i = 0; i < Manager.getShopName().length() + 6; i++)
                    System.out.print("-");
                System.out.print("\nEnter username('0' to terminate system): ");
                username = input.nextLine();
                if (username.equals("0"))
                    break;
                System.out.print("Enter password: ");
                password = input.nextLine();

                manager = new Manager(username, password);
                isValid = manager.isValidManager();

                if (!isValid)
                    System.out.println("Username or Password is incorrect! Try again.\n");
            }

        }
    }
}


