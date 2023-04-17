import java.util.Scanner;

public class Admin {
    private static Scanner input;
    public void admin() {
        //set username dan password admin
        String username = "admin";
        String password = "foodrush";

        // Input nama, username, dan password
        Scanner input = new Scanner(System.in);
        boolean login = false; //untuk validasi input username dan password

        while (!login) {
            CLS.clearScreen();
            System.out.println("\n===============================");
            System.out.println("---------LOG IN ADMIN----------");
            System.out.println(" Masukkan data yang diperlukan!");
            System.out.println("===============================");
            System.out.print("|Nama     : ");
            String namaAdmin = input.nextLine();
            System.out.print("|Username : ");
            String InputUsername = input.nextLine();
            System.out.print("|Password : ");
            String InputPassword = input.nextLine();

            // validasi input username dan password
            if (InputUsername.equals(username) && InputPassword.equals(password)) {
                System.out.println("\n================================================");
                System.out.println("                   LOG IN BERHASIL!               ");
                System.out.println("                  Selamat Datang, "+ namaAdmin +"!");
                System.out.println("==================================================");
                login = true;
            } else {
                System.out.println("OOPS, Username atau Password salah!");
            }
        }

    }
    public static void actionAdmin(char access){
        aksesAdmin.menuAdmin();


    }
        static class aksesAdmin{
            public static void menuAdmin(){
                System.out.println("|================================================|");
                System.out.println("|                    FOOD RUSH                   |");
                System.out.println("|       YOUR NUMBER 1 FOOD DELIVERY SERVICE      |");
                System.out.println("|------------------------------------------------|");
                System.out.println("|                    MENU ADMIN                  |");
                System.out.println("``````````````````````````````````````````````````");
                System.out.println("| [1] Lihat List Restoran                        |");
                System.out.println("| [2] Tambah Restoran                            |");
                System.out.println("| [3] Hapus Restoran                             |");
                System.out.println("| [4] Keluar                                     |");
                System.out.println("|================================================|");
            }
        }
    public static void enterMenu(){
        char access = ' ';
        while(access!='4'){
            while (!(access>='1' && access<='4')){
                System.out.print("Masukkan pilihan Anda [1][2][3][4]: ");
                String systemAccess = input.nextLine();
                if (systemAccess.length() >= 1 && !(access>='1' && access<='4'))
                    access = systemAccess.charAt(0);
                if (!(access>='1' && access<='4'))
                    System.out.println("Invalid System Access! Try again.");
            } //Validate user option

            actionAdmin(access); //Enter chosen system access

            if (access!='4')
                access = ' '; //Resetting access value to repeat menu option
        }
        System.out.println( " Successfully Logged Out.");
    }
}
