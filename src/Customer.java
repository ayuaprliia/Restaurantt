
import java.util.*;
public class Customer {
    private boolean isCustomer = false;

    private SettingInput input = new SettingInput();
    private ArrayList<Pemesanan> listOrders = new ArrayList<Pemesanan>();

    private String nama, username, password;
    private static Scanner scanner;
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
                System.out.println("Klik ENTER untuk kembali ke beranda.....");
                scanner.nextLine();
                login.beranda();


            }
        }//memeriksa apakah data customer cocok dengan CustomerLogin
        if (!isCustomerLoginExist){
            customers.add(this);
            System.out.println("|+=========================================+|");
            System.out.println("|          Akun Berhasil Ditambahkan!       |");
            System.out.println("|+=========================================+|");
            System.out.print("Press any key to continue..."); //untuk lanjut ke menu berikutnya
            Customer.scanner.nextLine(); //membaca input user
        }login.beranda();
    }

    public void credential(){
        //menerima detail data (credential)  dan mengecek input password
        CLS.Clearscreen();
        scanner = new Scanner(System.in);
        System.out.println("\n|+======================================+|");
        System.out.println("|               MEMBUAT AKUN BARU        | ");
        System.out.println("|+======================================+|");
        System.out.print("Masukkan nama : ");
        nama = scanner.nextLine();
        System.out.print("Masukkan username : ");
        username = scanner.nextLine();
        System.out.print("Masukkan password : ");
        String passwordBaru = scanner.nextLine();
        System.out.print("Masukkan ulang password :");
        String passwordUlang = scanner.nextLine();
        while (!passwordBaru.equals(passwordUlang)){
            System.out.println("|+======================================+|");
            System.out.println("|    PASSWORD TIDAK COCOK! COBA LAGI!    |");
            System.out.println("|+======================================+|");
            System.out.print("masukkan password : ");
            passwordBaru = scanner.nextLine();
            System.out.print("masukkan ulang password : ");
            passwordUlang = scanner.nextLine();
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

    public void customerAccess(ArrayList<Resto> listRestaurant) {
        boolean runCustomerAccess = true;
        while(runCustomerAccess) {
            CLS.Clearscreen();
            tampilanCustomer.tampilanMenu();
            Input.pesanInput();
            int userInput = input.pilihMenu(0,3);

            if (userInput == 1) { // Lihat Restoran
                CLS.Clearscreen();
                boolean runLihatRestoran = true;
                boolean restaurantFound = false;
                while (runLihatRestoran) {
                    CLS.Clearscreen();
                    tampilanCustomer.tampilanListresto();
                    int index = 0;
                    for (Resto element : listRestaurant) {
                        Resto restaurantObject = listRestaurant.get(index);
                        restaurantObject.toString();
                        index++;
                    }
                    tampilanCustomer.tampilanInputLihatMenu();
                    Input.pesanInput();
                    String userInputIDResto = scanner.nextLine();
                    if (userInputIDResto.equals("0")) break;
                    else { //memeriksa apakah ID ada atau tidak dgn loop list yg ada
                        index = 0;
                        for (Resto element : listRestaurant) {
                            Resto restaurantObject = listRestaurant.get(index);
                            //jika ID ada, maka restoran ditemukan dan dapat lanjut ke melihat restoran
                            if (restaurantObject.getIDresto().equals(userInputIDResto.toUpperCase())) {
                                restaurantFound = true;
                                CLS.Clearscreen();
                                restaurantObject.lihatMenu();
                                break;
                            } else index++;
                        }
                        if (!restaurantFound) { //jika ternyata ID tidak ditemukan
                            System.out.println("ID tidak valid!");
                            System.out.println("Tekan ENTER untuk kembali.");
                            scanner.nextLine();
                        }
                    }
                }
            } else if (userInput == 2) { //Buat pesanan
                boolean runBuatPesanan = true;
                boolean restaurantFound = false;

                //Variabel yang menyimpan pilihan user
                String userInputResto = null;

                while (runBuatPesanan) {
                    CLS.Clearscreen();
                    restaurantFound = false;
                    userInputResto = null;
                    //Pilih restoran
                    tampilanCustomer.tampilanOrder();
                    int index = 0;
                    for (Resto element : listRestaurant) { //Nunjukkin restoran yang ada di list
                        Resto restaurantObject = listRestaurant.get(index);
                        restaurantObject.toString();
                        index++;
                    }
                    tampilanCustomer.tampilanOrderEnd(); //memilih resto yang ingin dipesan
                    Input.pesanInput();
                    userInputResto = scanner.nextLine();
                    // Periksa apakah ID yang diinput valid atau tidak
                    // Kalau valid, lanjut pilih menu yang ingin dipesan
                    if (userInputResto.equals("0")) break;
                    else {
                        index = 0;
                        for (Resto element : listRestaurant) { //memeriksa resto berdasarkan ID
                            Resto restaurantObject = listRestaurant.get(index);
                            if (restaurantObject.getIDresto().equals(userInputResto.toUpperCase())) {
                                restaurantFound = true;
                                System.out.print("    Jarak Anda dengan restoran ini (dalam km): ");
                                double jarak = input.getDouble();
                                String idOrder = "ORDER" + (listOrders.size()+1);
                                listOrders.add(new Pemesanan(idOrder, userInputResto.toUpperCase(), restaurantObject.getNamaResto(), jarak));
                                Pemesanan orderObject = listOrders.get(listOrders.size()-1);
                                CLS.Clearscreen();
                                boolean hasOrdered = restaurantObject.pemesananMenu(orderObject); //memanggil method untuk memesan menu pada resto yang dipilih
                                if (!hasOrdered) { //jika ternyata user tidak menambahkan order makanan apapun, hapus objek order
                                    listOrders.remove(listOrders.size()-1);
                                    scanner.nextLine();
                                    break;
                                } scanner.nextLine();
                                break;
                            } else {
                                index++;
                            }
                        }
                        if (!restaurantFound) {
                            System.out.println("    Maaf, ID Restoran yang Anda masukkan salah, nih.");
                            System.out.println("    Tekan ENTER untuk kembali.");
                            scanner.nextLine();
                        }
                    }
                }

            } else if (userInput == 3) { //Lihat pesanan
                boolean runLihatPesanan = true;
                int index = 0;

                CLS.Clearscreen();
                Pemesanan.strukPemesanan();
                while(runLihatPesanan) {
                    for (Pemesanan element : listOrders) {
                        Pemesanan orderObject = listOrders.get(index);
                        orderObject.tampilPesanan();
                        index++;
                    }
                    scanner.nextLine();
                    break;
                }

            } else if (userInput == 0) { //Kembali ke menu login
                break;
            } else {
                System.out.println("Ada masalah pada program");
                System.exit(0);
            }
        }
    }

    static class tampilanCustomer {
        public static void tampilanMenu() {
            System.out.println("|=========================================================|");
            System.out.println("|                        FOOD RUSH                        |");
            System.out.println("|            YOUR NUMBER 1 FOOD DELIVERY SERVICE          |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|                     MENU CUSTOMER                       |");
            System.out.println("```````````````````````````````````````````````````````````");
            System.out.println("| [1] Lihat List Restoran                                 |");
            System.out.println("| [2] Buat pesanan                                        |");
            System.out.println("| [3] Receipt                                             |");
            System.out.println("| [4] Keluar                                              |");
            System.out.println("|=========================================================|");
        }

        public static void tampilanListresto() {
            System.out.println("|=========================================================|");
            System.out.println("|                        FOOD RUSH                        |");
            System.out.println("|           YOUR NUMBER 1 FOOD DELIVERY SERVICE           |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|                      LIST RESTORAN                      |");
            System.out.println("``````````````````````````````````````````````````````````");
            System.out.println("|   ID    |    NAMA RESTORAN     |          ALAMAT        |");
            System.out.println("|---------------------------------------------------------|");
        }
        public static void tampilanInputLihatMenu() {
            System.out.println("|=========================================================|");
            System.out.println("| Ketik ID restoran untuk lihat menu (0 untuk batal)");
        }
        public static void tampilanOrder() {
            System.out.println("|=========================================================|");
            System.out.println("|                        FOOD RUSH                        |");
            System.out.println("|           YOUR NUMBER 1 FOOD DELIVERY SERVICE           |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|                        PEMESANAN                        |");
            System.out.println("``````````````````````````````````````````````````````````");
            System.out.println("|   ID    |    NAMA RESTORAN     |          ALAMAT        |");
            System.out.println("|---------------------------------------------------------|");
        }
        public static void tampilanOrderEnd() {
            System.out.println("|=========================================================|");
            System.out.println("| Ketik ID restoran untuk lihat menu (0 untuk batal)");
        }
    }
}


