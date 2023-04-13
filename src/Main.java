import java.util.*;

public class Main {
        //membuat tampilan awal
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                AdminLogin loginadmin = new AdminLogin();

                System.out.println("|=================WELCOME!==================|");
                System.out.println("|               FOOD RUSH                   |");
                System.out.println("|------YOUR NO. 1 FOOD DELIVERY SERVICE-----|");
                System.out.println("|===========================================|");
                System.out.print("Press any key to continue..."); //untuk lanjut ke menu berikutnya
                scanner.nextLine(); //membaca input user
                loginadmin.admin();


        }


}
