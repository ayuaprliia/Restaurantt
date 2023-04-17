
import java.util.*;
public class Customer {
    private String nama, username, password;
    private static Scanner input;
    private static ArrayList<Customer> customers = new ArrayList<>();

    public Customer(){
        this("", "", "");
    }

    public Customer(String username, String password){
        this ("", username, password);
    }

    public Customer(String nama, String username, String password){
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

    public  void regisCustomer(){
        Scanner scanner = new Scanner(System.in);
        Main login = new Main();
        credential(); //menerima input detail data customer/pelanggan

        boolean isCustomerLoginExist = false;
        for (Customer customer : customers) {
            if (customer.nama.equals(nama)){
                isCustomerLoginExist = true;
                System.out.println("|+=========================================+|");
                System.out.println("|             Akun sudah terdaftar!         |");
                System.out.println("|+=========================================+|");
                break;

            }
        }//memeriksa apakah data customer cocok dengan CustomerLogin
        if (!isCustomerLoginExist){
            customers.add(this);
            System.out.println("|+=========================================+|");
            System.out.println("|          Akun Berhasil Ditambahkan!       |");
            System.out.println("|+=========================================+|");
        }login.beranda();
    }

    public void credential(){
        //menerima detail data (credential)  dan mengecek input password
        CLS.clearScreen();
        input = new Scanner(System.in);
        System.out.println("\n|+======================================+|");
        System.out.println("|               MEMBUAT AKUN BARU        | ");
        System.out.println("|+======================================+|");
        System.out.print("Masukkan nama : ");
        nama = input.nextLine();
        System.out.print("Masukkan username : ");
        username = input.nextLine();
        System.out.print("Masukkan password : ");
        String passwordBaru = input.nextLine();
        System.out.print("Masukkan ulang password :");
        String passwordUlang = input.nextLine();
        while (!passwordBaru.equals(passwordUlang)){
            System.out.println("|+======================================+|");
            System.out.println("|    PASSWORD TIDAK COCOK! COBA LAGI!    |");
            System.out.println("|+======================================+|");
            System.out.print("masukkan password : ");
            passwordBaru = input.nextLine();
            System.out.print("masukkan ulang password : ");
            passwordUlang = input.nextLine();
        }
        password = passwordBaru;
    }

    public boolean isValidCustomer(){
        boolean isValid = false;
        for (Customer customer : customers){
            if (customer.username.equals(username) && customer.password.equals(password))
                isValid = true;
        }
        return isValid; //memvalidasi data customer
    }
    public static boolean isCustomerRegistered(String username) {
        for (Customer customer : customers) {
            if (customer.username.equals(username))
                return true;
        }
        return false;
    }

    public static boolean login(String username, String password) {
        for (Customer customer : customers) {
            if (customer.username.equals(username) && customer.password.equals(password))
                return true;
        }
        return false;
    }

    }

