import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                int pilihan = 0;

                while (pilihan != 4) {
                        System.out.println("=================WELCOME!==================");
                        System.out.println("                FOOD RUSH                 ");
                        System.out.println("------YOUR NO. 1 FOOD DELIVERY SERVICE-----");
                        System.out.println("===========================================");
                        System.out.println("|1. Tambah data");
                        System.out.println("|2. Hapus data");
                        System.out.println("|3. Lihat data");
                        System.out.println("4. Keluar");
                        System.out.print("Pilihan Anda: ");
                        pilihan = input.nextInt();

                        switch (pilihan) {
                                case 1:
                                        System.out.println("Anda memilih tambah data.");
                                        break;
                                case 2:
                                        System.out.println("Anda memilih hapus data.");
                                        break;
                                case 3:
                                        System.out.println("Anda memilih lihat data.");
                                        break;
                                case 4:
                                        System.out.println("Terima kasih.");
                                        break;
                                default:
                                        System.out.println("Pilihan tidak valid.");
                                        break;
                        }

                        System.out.println();
                }
        }
}
