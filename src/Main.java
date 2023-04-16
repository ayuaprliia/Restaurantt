import java.util.Scanner;

public class Main {
        //membuat tampilan awal
        public static void main(String[] args) {
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
                AdminLogin loginadmin = new AdminLogin();
                Customer customer = new Customer();
                int pilih;
                boolean isExit = false;

                do{
                        CLS.clearScreen();
                        System.out.println("\n|=======================================|");
                        System.out.println("|               FOOD RUSH               |");
                        System.out.println("|  YOUR NUMBER 1 FOOD DELIVERY SERVICE  |");
                        System.out.println("|---------------------------------------|");
                        System.out.println("| [1] Masuk sebagai Admin               |");
                        System.out.println("| [2] Masuk sebagai Pelanggan           |");
                        System.out.println("| [3] Keluar                            |");
                        System.out.println("|=======================================|");

                        System.out.print("Masukkan Pilihan Anda [1][2][3] : ");
                        pilih = input.nextInt();

                        switch (pilih) {
                                case 1:
                                        loginadmin.admin();
                                        break;
                                case 2:
                                        customer.LoginCustomer();
                                        break;
                                case 3:
                                        CLS.clearScreen();
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
                }while (!isExit);
        }
}
