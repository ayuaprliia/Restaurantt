import java.util.Scanner;
import java.util.ArrayList;

public class Main {
        private static Customer customer = new Customer();
        private static ArrayList<Resto> restorans = new ArrayList<Resto>();
        //membuat tampilan awal
        public static void main(String[] args) {
                opening();
        }

        public static void opening (){
                Scanner scanner = new Scanner(System.in);
                System.out.println("|=================WELCOME!==================|");
                System.out.println("|               FOOD RUSH                   |");
                System.out.println("|------YOUR NO. 1 FOOD DELIVERY SERVICE-----|");
                System.out.println("|===========================================|");
                System.out.print("Press any key to continue..."); //untuk lanjut ke menu berikutnya
                scanner.nextLine(); //membaca input user
                beranda();
        }

        public static void beranda(){
                Scanner input = new Scanner(System.in);
                Admin loginadmin = new Admin();
                Customer customer = new Customer();
                int pilih;
                boolean isExit = false;

                CLS.Clearscreen();
                System.out.println("\n|=======================================|");
                System.out.println("|               FOOD RUSH               |");
                System.out.println("|  YOUR NUMBER 1 FOOD DELIVERY SERVICE  |");
                System.out.println("|---------------------------------------|");
                System.out.println("| [1] Masuk sebagai Admin               |");
                System.out.println("| [2] Registrasi Akun Pelanggan Baru    |");
                System.out.println("| [3] Masuk sebagai Pelanggan           |");
                System.out.println("| [4] Keluar                            |");
                System.out.println("|=======================================|");

                System.out.print("Masukkan Pilihan Anda [1][2][3][4] : ");
                pilih = input.nextInt();

                switch (pilih) {
                        case 1:
                                loginadmin.admin();
                                break;
                        case 2:
                                customer.regisCustomer();
                                break;

                        case 3:
                                loginCustomer();
                                break;
                        case 4:
                                CLS.Clearscreen();
                                System.out.println("|======================================|");
                                System.out.println("|          ANDA MEMILIH KELUAR         |");
                                System.out.println("|              TERIMA KASIH            |");
                                System.out.println("|======================================|");
                                isExit = true;
                                break;
                        default:
                                System.out.print("Mohon Input Sesuai Arahan!");
                                break;
                }
                System.out.println();
                while (!isExit);
        }
        public static void loginCustomer(){
                Scanner input = new Scanner(System.in);
                boolean isLoggedIn = false; //untuk memeriksa apakah data saat log in sama dengan data pada saar registrasi akun
                String username, password;
                CLS.Clearscreen();
                while (!isLoggedIn) {
                        System.out.println("\n|+======================================+|");
                        System.out.println("|                 LOG IN                 | ");
                        System.out.println("|+======================================+|");
                        System.out.print("Masukkan username : ");
                        username = input.nextLine();
                        System.out.print("Masukkan password : ");
                        password = input.nextLine();

                        if (Customer.isCustomerRegistered(username)) { //untuk mengecek apakah log in berhasil atau tidak
                                isLoggedIn = Customer.login(username, password);

                                if (!isLoggedIn) { //kalau login tidak berhasil
                                        System.out.println("\n|+======================================+|");
                                        System.out.println("|     USERNAME ATAU PASSWORD SALAH!      |");
                                        System.out.println("|+======================================+|");
                                } else { //kalau log in berhasil
                                        System.out.println("\n|+======================================+|");
                                        System.out.println("|              LOG IN BERHASIL!          |");
                                        System.out.println("|+======================================+|");
                                        customer.customerAccess(restorans);
                                }
                        } else { //kalau akun belum terdaftar
                                System.out.println("\n|+======================================+|");
                                System.out.println("|          AKUN TIDAK TERDAFTAR!         |");
                                System.out.println("|  Mohon untuk melakukan registrasi akun |");
                                System.out.println("|             terlebih dahulu!           |");
                                System.out.println("|+======================================+|");
                                System.out.print("Press any key to continue..."); //untuk lanjut ke menu berikutnya
                                input.nextLine(); //membaca input user
                                beranda();
                        }
                }
        }
}

