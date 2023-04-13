import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.*;
public class CustomerLogin {
    private String nama, username, password;
    private static Scanner input;
    private static ArrayList<CustomerLogin> customers = new ArrayList<>();

    public CustomerLogin(){
        this("", "", "");
    }

    public CustomerLogin(String username, String password){
        this ("", username, password);
    }

    public CustomerLogin(String nama, String username, String password){
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public String getNama(){
        return nama;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void LoginCustomer(){
        credential(); //menerima input detail data customer/pelanggan

        boolean isCustomerLoginExist = false;
        for (CustomerLogin customer : customers) {
            if (customer.nama.equals(nama)){
                isCustomerLoginExist = true;
                System.out.println("Akun sudah terdaftar!");
                break;
            }
        }//memeriksa apakah data customer cocok dengan CustomerLogin
        if (!isCustomerLoginExist){
            customers.add(this);
            System.out.println("Akun Berhasil DItambahkan!");
            AkunCustomer(); //membuat akun customer baru dan memperlihatkannya pada saat akun berhasil dibuat
        }
    }

    public void credential(){
        //menerima detail data (credential)  dan mengecek input password
        input = new Scanner(System.in);
        System.out.println("Create New Account");
        System.out.println("masukkan nama : ");
        nama = input.nextLine();
        System.out.println("masukkan username : ");
        username = input.nextLine();
        System.out.println("masukkan password : ");
        String passwordBaru = input.nextLine();
        System.out.println("masukkan ulang password :");
        String passwordUlang = input.nextLine();
        while (!passwordBaru.equals(passwordUlang)){
            System.out.println("password tidak cocok! Coba lagi.");
            System.out.println("masukkan password : ");
            passwordBaru = input.nextLine();
            System.out.println("masukkan ulang password : ");
            passwordUlang = input.nextLine();
        }
        password = passwordBaru;
    }

    public boolean isValidCustomerLogin(){
        boolean isValid = false;
        for (CustomerLogin customer : customers){
            if (customer.username.equals(username) && customer.password.equals(password))
                isValid = true;
        }
        return isValid; //memvaludasi data customer
    }

    public void AkunCustomer (){
        System.out.println("akun customer");
        int count = 1;
        for (CustomerLogin customer : customers){
            System.out.print(count + "Nama Customer :");
            System.out.println(customer.nama);
            System.out.print("Username :");
            System.out.println(customer.username);
            count++;

        }
    }
}
