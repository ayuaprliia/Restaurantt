import java.util.Scanner;

public class Manager {

    public void Manager() {
        String username = "admin";
        String password = "123";
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        String inputUsername = input.nextLine();
        System.out.print("Masukkan password: ");
        String inputPassword = input.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login berhasil.");
        } else {
            System.out.println("Username atau password salah.");
        }
    }
}
