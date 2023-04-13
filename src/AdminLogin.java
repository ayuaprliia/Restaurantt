import java.util.Scanner;

public class AdminLogin {
    public void admin() {
        //set username dan password admin
        String username = "admin";
        String password = "123456";

        // Input nama, username, dan password
        Scanner input = new Scanner(System.in);
        System.out.println("===============================");
        System.out.println("---------LOG IN ADMIN----------");
        System.out.println(" Masukkan data yang diperlukan!");
        System.out.println("===============================");
        System.out.print("|Nama   :");
        String namaAdmin = input.nextLine();
        System.out.print("|Username : ");
        String InputUsername = input.nextLine();
        System.out.print("|Password  : ");
        String InputPassword = input.nextLine();

        // validasi input username dan password
        if (InputUsername.equals(username) && InputPassword.equals(password)) {
            System.out.println("Selamat datang, " + namaAdmin + "!");
        } else {
            System.out.println("Username atau password salah!");
        }
    }
}
