import java.util.Scanner;
import java.util.ArrayList;


public class Admin {

    ArrayList<Resto> restorans = new ArrayList<>();

    private SettingInput input = new SettingInput();

    public void admin() {
        //set username dan password admin
        String username = "admin";
        String password = "foodrush";

        // Input nama, username, dan password
        Scanner input = new Scanner(System.in);
        boolean login = false; //untuk validasi input username dan password

        while (!login) {
            CLS.Clearscreen();
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
                System.out.println("\n==================================================");
                System.out.println("                   LOG IN BERHASIL!               ");
                System.out.println("               Selamat Datang, " + namaAdmin + "!");
                System.out.println("==================================================");
                login = true;
                adminAction(restorans);
            } else {
                System.out.println("OOPS, Username atau Password salah!");
            }
        }

    }

    public void adminAction(ArrayList<Resto> restorans) {
        boolean prosesAction = true;
        while(prosesAction) {
            CLS.Clearscreen();
            tampilanAdmin.menuAdmin();
            Input.pesanInput();
            int pilih = input.pilihMenu(1,4);

            if (pilih == 1) { //melihat daftar restoran yang terdata di dalam program
                CLS.Clearscreen();
                boolean prosesLihatresto = true;
                boolean isRestoValid = false;
                while (prosesLihatresto) {
                    CLS.Clearscreen();
                    tampilanAdmin.lihatRestoHeader(); //memanggil header untuk tampilan lihatResto
                    int index = 0;
                    for (Resto element : restorans) {
                        Resto restaurantObject = restorans.get(index);
                        restaurantObject.toString();
                        index++;
                    }
                    tampilanAdmin.lihatRestoranFooter();
                    Input.pesanInput();
                    String userInputIDResto = input.nextLine();
                    if (userInputIDResto.equals("0")) break;
                    else {
                        index = 0;
                        for (Resto element : restorans) {
                            Resto restaurantObject = restorans.get(index);
                            if (restaurantObject.getIDresto().equals(userInputIDResto.toUpperCase())) {
                                isRestoValid = true;
                                CLS.Clearscreen();
                                restaurantObject.lihatMenu(); //menampilkan menu dari restoran tertentu
                                break;
                            } else index++;
                        }
                        if (!isRestoValid) { // restoran yang dicari tidak terdaftar
                            System.out.println("Restoran tidak ditemukan!");
                            System.out.println("Press any key to continue....");
                            input.nextLine();
                        }
                    }
                }
            } else if (pilih == 2) { //menambahkan restoran
                CLS.Clearscreen();
                //validasi
                boolean prosesTambahResto = true;
                boolean IDisNotValid = true;
                int userInputAddRestaurant;
                String IDresto = null;
                String namaResto = null;
                String alamatResto = null;

                while (prosesTambahResto) {
                    CLS.Clearscreen();
                    tampilanAdmin.tambahRestoHeader();
                    IDisNotValid = true;
                    while (IDisNotValid) { //validasi ID yang diinput oleh admin
                        System.out.print("Masukkan ID Restoran: ");
                        IDresto = input.validasiID();
                        IDisNotValid = input.isIDrestoValid(restorans, IDresto);
                        if (IDisNotValid) {
                            System.out.printf("ID %s sudah terdaftar!\n", IDresto);
                            System.out.println("Masukkan ID Restoran");
                        }
                    }

                    System.out.print("Nama Restoran: ");
                    namaResto = input.validasiString("Nama restoran");
                    System.out.print("Alamat Restoran: ");
                    alamatResto = input.validasiString("Alamat restoran");
                    // Menambahkan elemen restoran baru ke list
                    restorans.add(new Resto(IDresto, namaResto, alamatResto));

                    Resto restaurant = restorans.get(restorans.size()-1);
                    CLS.Clearscreen();
                    boolean addMenuDone= restaurant.tambahMenu(); //menambahkan menu ke masing-masing restoran
                    if (!addMenuDone) { //hapus resto jika menu tidak ditambahkan
                        restorans.remove(restorans.size()-1);
                        break;
                    }
                    tampilanAdmin.tambahRestoEnd(); //tambah resto / keluar
                    Input.pesanInput();
                    userInputAddRestaurant = input.pilihMenu(1,2);
                    if (userInputAddRestaurant == 2) break;
                }

            } else if (pilih == 3) { //Hapus Restoran
                CLS.Clearscreen();
                boolean prosesHapusResto = true;
                boolean isRestoValid = false;

                while (prosesHapusResto) {
                    CLS.Clearscreen();
                    tampilanAdmin.hapusRestoHeader();
                    int index = 0;
                    for (Resto element : restorans) { //menampilkan sekuruh restoran
                        Resto restaurantObject = restorans.get(index);
                        restaurantObject.toString();
                        index++;
                    }
                    tampilanAdmin.hapusRestoInput();//input ID
                    Input.pesanInput();
                    String userInputResto = input.nextLine();
                    if (userInputResto.equals("0")) break;
                    else {
                        index = 0;
                        for (Resto element : restorans) { //mencari ID resto yang diinput user
                            Resto restaurantObject = restorans.get(index);
                            if (restaurantObject.getIDresto().equals(userInputResto)) {
                                //jika restoran valid
                                isRestoValid = true;
                                restorans.remove(index);
                                tampilanAdmin.hapusRestoSukses();
                                prosesHapusResto = false;
                                input.nextLine();
                                break;
                            } else index++;
                        }
                        if (!isRestoValid) { //jika resto tidak ditemukan
                            System.out.println(" Restoran tidak ditemukan!");
                            System.out.println("Press any key to continue...");
                            input.nextLine();
                        }
                    }

                }

            } else if (pilih == 4) { //back to log in menu
                CLS.Clearscreen();
                break;
            } else {
                System.out.println("System Error");
                System.exit(0);
            }
        }
    }

    static class tampilanAdmin {
        public static void menuAdmin() {
            System.out.println("|=========================================================|");
            System.out.println("|                        FOOD RUSH                        |");
            System.out.println("|            YOUR NUMBER 1 FOOD DELIVERY SERVICE          |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|                        MENU ADMIN                       |");
            System.out.println("```````````````````````````````````````````````````````````");
            System.out.println("| [1] Lihat List Restoran                                 |");
            System.out.println("| [2] Tambah Restoran                                     |");
            System.out.println("| [3] Hapus Restoran                                      |");
            System.out.println("| [4] Keluar                                              |");
            System.out.println("|=========================================================|");
        }

        public static void lihatRestoHeader() {
            System.out.println("|=========================================================|");
            System.out.println("|                        FOOD RUSH                        |");
            System.out.println("|           YOUR NUMBER 1 FOOD DELIVERY SERVICE           |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|                      LIST RESTORAN                      |");
            System.out.println("``````````````````````````````````````````````````````````");
            System.out.println("|   ID    |    NAMA RESTORAN     |          ALAMAT        |");
            System.out.println("|---------------------------------------------------------|");
        }
        public static void lihatRestoranFooter() {
            System.out.println("|=========================================================|");
            System.out.println("| Ketik ID restoran untuk lihat menu (0 untuk batal)");
        }

        public static void tambahRestoHeader() {
            System.out.println("|=========================================================|");
            System.out.println("|                        FOOD RUSH                        |");
            System.out.println("|           YOUR NUMBER 1 FOOD DELIVERY SERVICE           |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|                    TAMBAH RESTORAN                      |");
            System.out.println("``````````````````````````````````````````````````````````");

        }

        public static void tambahRestoEnd() {
            System.out.println("|=========================================================|");
            System.out.println("|                   TAMBAH RESTORAN BERHASIL!!!           |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|   [1] Tambahkan restoran lagi                           |");
            System.out.println("|   [2] Keluar                                            |");
            System.out.println("|---------------------------------------------------------|");
        }

        public static void hapusRestoHeader() {
            System.out.println("|=========================================================|");
            System.out.println("|                        FOOD RUSH                        |");
            System.out.println("|           YOUR NUMBER 1 FOOD DELIVERY SERVICE           |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|                     HAPUS RESTORAN                      |");
            System.out.println("``````````````````````````````````````````````````````````");
            System.out.println("|   ID    |    NAMA RESTORAN     |          ALAMAT        |");
            System.out.println("|---------------------------------------------------------|");
        }

        public static void hapusRestoInput() {
            System.out.println("|=========================================================|");
            System.out.println("| Masukkan ID restoran (0 untuk batal)");
        }

        public static void hapusRestoSukses() {
            System.out.println("|=========================================================|");
            System.out.println("|                   TAMBAH RESTORAN BERHASIL!!!           |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("| press any key to continue...");
        }
    }
}


