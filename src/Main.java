import java.util.Scanner;

public class Main {
        private static Scanner input;
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
                                        loginCustomer();
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
        public static void loginCustomer(){
                input = new Scanner(System.in);
                Customer login = new Customer();
                login.regisCustomer();
                System.out.println("\n|+===========================================+|");
                System.out.println("|             W E L C O M E  B A C K!         |");
                System.out.println("|+-------------------------------------------+|");
                System.out.println("|                  LOG IN PENGGUNA            |");
                System.out.println("|+===========================================+|");

                String username = "", password = "";
                while (true){
                        boolean isValid = false;
                        while (!isValid){
                                System.out.print("Masukkan Username : ");
                                username = input.nextLine();
                                if (username.equals("0"))
                                        break;
                                System.out.print("Masukkan Password : ");
                                password = input.nextLine();

                                login = new Customer(username, password);
                                isValid = login.isValidCustomer();

                                if (!isValid)
                                        System.out.println("Username or Password is incorrect! Try again.\n");
                        } //Validate and verify manager
                        if (username.equals("0")){
                                continue;
                        }
                        beranda();
                }
        }

}

