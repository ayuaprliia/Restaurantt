import java.util.*;

//create a manager class to hold manager attributes

public class Manager {
    private static String shopName;
    private String name, username, password;
    private static int discountRate = 0;
    private static double minimumAmount = 0;
    private static Scanner input;
    private static ArrayList<Manager> managers = new ArrayList<>();

    public Manager() {
        this("", "", "");
    }

    public Manager(String username, String password) {
        this("", username, password);
    }

    public Manager(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public static String getShopName() {
        return shopName;
    }

    public static void setShopName(String shopName) {
        Manager.shopName = shopName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getDiscountRate() {
        return discountRate;
    }

    public static void setDiscountRate(int discountRate) {
        Manager.discountRate = discountRate;
    }

    public static double getMinimumAmount() {
        return minimumAmount;
    }

    public static void setMinimumAmount(double minimumAmount) {
        Manager.minimumAmount = minimumAmount;
    }

    public void createNewManager() {

        receiveCredentials(); //Receive input for new manager credentials

        boolean isManagerExist = false;
        for (Manager manager : managers) {
            if (manager.name.equals(name)) {
                isManagerExist = true;
                System.out.println("\nManager Account Already Exists!\n");
                break;
            }
        } //Checking whether new manager credentials match with existing manager
        if (!isManagerExist) {
            managers.add(this);
            System.out.println("New Manager Account Successfully Created.");
            displayManager();
        } //Create new manager and add to managers list if the manager does not exist
    }

    public void receiveCredentials() {
        //Receiving all manager credentials and double checking password entry
        input = new Scanner(System.in);
        System.out.println("\nCreate New Manager Account\n--------------------------");
        System.out.print("Enter manager name: ");
        name = input.nextLine();
        System.out.print("Enter new username: ");
        username = input.nextLine();
        System.out.print("Enter new password: ");
        String passwordFirstTyped = input.nextLine();
        System.out.print("Retype new password: ");
        String passwordRetyped = input.nextLine();
        while (!passwordFirstTyped.equals(passwordRetyped)) {
            System.out.println("Retyped password does not match! Try again.");
            System.out.print("Enter new password: ");
            passwordFirstTyped = input.nextLine();
            System.out.print("Retype new password: ");
            passwordRetyped = input.nextLine();
        }
        password = passwordFirstTyped;
    }

    public boolean isValidManager() {
        boolean isValid = false;
        for (Manager manager : managers) {
            if (manager.username.equals(username) && manager.password.equals(password))
                isValid = true;
        }
        return isValid; //Validating manager credentials through managers list
    }

    public void displayManager() {
        System.out.println("\nManagers List\n-------------");
        int count = 1;
        for (Manager manager : managers) {
            System.out.print(count + ". Manager Name: ");
            System.out.println(manager.name);
            System.out.print("   Manager Username: ");
            System.out.println(manager.username);
            count++;
        } //Displaying all managers in the list
    }
}