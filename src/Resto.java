

import java.util.ArrayList;

public class Resto {

    private ArrayList<Meal> foods = new ArrayList<Meal>();
    private ArrayList<Meal> drinks = new ArrayList<Meal>();
    private SettingInput input = new SettingInput();
    private String IDresto;
    private String namaResto;
    private String alamatResto;
    public String getNamaResto() {
        return namaResto;
    }

    public String getAlamatResto() {
        return alamatResto;
    }

    public String getIDresto() {
        return IDresto;
    }

    public ArrayList<Meal> getFoods() {
        return foods;
    }

    public ArrayList<Meal> getDrinks() {
        return drinks;
    }


    public Resto() {

    }
    public Resto(String IDresto, String namaResto, String alamatResto) {
        this.IDresto = IDresto;
        this.namaResto = namaResto;
        this.alamatResto = alamatResto;
    }

    public void tambahMenuMakanan(String idMakanan, String nama, double harga) {
        foods.add(new Meal(idMakanan, nama, harga));
    }

    public void tambahMenuMinuman(String idMinuman, String nama, double harga) {
        drinks.add(new Meal(idMinuman, nama, harga));
    }

    public boolean tambahMenu() {
        int userInput;
        boolean prosesTambahMenu = true;
        boolean IDisNotValid = true;
        boolean tambahMenuBerhasil = false;
        String IDmeal = null;
        String Namameal = null;
        double Harga = 0;

        while (prosesTambahMenu) {
            CLS.Clearscreen();
            Tampilan.addMenu();
            Input.pesanInput();
            userInput = input.pilihMenu(0,2);
            if (userInput == 0) {
                if(!tambahMenuBerhasil) {
                    Tampilan.batalAddresto();
                    Input.pesanInput();
                    int userInput2 = input.pilihMenu(1,2);
                    if(userInput2 == 1) {
                        CLS.Clearscreen();
                        prosesTambahMenu = false;
                        tambahMenuBerhasil = false;
                    } else if (userInput2 == 2) {
                        CLS.Clearscreen();
                    }
                } else {
                    CLS.Clearscreen();
                    prosesTambahMenu = false;
                }
            } else if (userInput == 1) {
                CLS.Clearscreen();
                Tampilan.tambahMEnu("Makanan");
                IDisNotValid = true;
                while (IDisNotValid) {
                    System.out.print("ID Makanan: ");
                    IDmeal = input.validasiID();
                    IDisNotValid = input.isIDmealValid(foods, IDmeal);
                    if (IDisNotValid) {
                        System.out.printf("ID %s sudah terdaftar.\n", IDmeal);
                        System.out.println("Gunakan ID yang lain!");
                    }
                }
                System.out.print("Nama Makanan: ");
                Namameal = input.validasiString("Nama makanan");
                System.out.print("Harga : Rp");
                Harga = input.getDouble();
                input.nextLine();
                tambahMenuMakanan(IDmeal, Namameal, Harga);
                Tampilan.tambahMenusuccess();
                tambahMenuBerhasil = true;
                input.nextLine();
            } else if (userInput == 2) {
                CLS.Clearscreen();
                Tampilan.tambahMEnu("Minuman");
                IDisNotValid = true;
                while (IDisNotValid) {
                    System.out.print("ID Minuman: ");
                    IDmeal = input.validasiID();
                    IDisNotValid = input.isIDmealValid(drinks, IDmeal);
                    if (IDisNotValid) {
                        System.out.printf("ID %s sudah terdaftar.\n", IDmeal);
                        System.out.println("Gunakan ID lain!");
                    }
                }
                System.out.print("Nama Minuman: ");
                Namameal = input.validasiString("Nama minuman");
                System.out.print("Harga : Rp");
                Harga = input.getDouble();
                input.nextLine();

                tambahMenuMinuman(IDmeal, Namameal, Harga);
                Tampilan.tambahMenusuccess();
                tambahMenuBerhasil = true;
                input.nextLine();
            }
            IDmeal = null;
            Namameal = null;
            Harga = 0;
        }
        return tambahMenuBerhasil;
    }

    public void lihatMenu() {
        boolean prosesLihatMenu = true;

        while (prosesLihatMenu) {
            CLS.Clearscreen();
            Tampilan.pilihMenu(getNamaResto(), getAlamatResto());
            Input.pesanInput();
            int userInput = input.pilihMenu(1,3);

            if (userInput == 3) {
                prosesLihatMenu = false;
                break;
            } else if (userInput == 1) { //tampil menu makanan
                CLS.Clearscreen();
                int index = 0;
                Tampilan.lihatMakananHeader(getNamaResto(), getAlamatResto());
                for (Meal element : foods) {
                    Meal makananObject = foods.get(index);
                    makananObject.toString();
                    index++;
                }
                Tampilan.tampilanLanjut();
                input.nextLine();
            } else if (userInput == 2) { //tampil menu minuman
                CLS.Clearscreen();
                int index = 0;
                Tampilan.lihatMinumanHeader(getNamaResto(), getAlamatResto());
                for (Meal element : drinks) {
                    Meal minumanObject = drinks.get(index);
                    minumanObject.toString();
                    index++;
                }
                Tampilan.lihatMinumanFooter();
                input.nextLine();
            }
        }

    }

    public boolean pemesananMenu(Pemesanan orderObject) {
        boolean prosesPemesanan = true;
        boolean menuFound = false;
        boolean orderDone = false;

        String IDresto = this.IDresto;
        String IDmeal = null;
        String namaMeal = null;
        double harga = 0;
        int Banyaknya = 0;
        double totalharga = 0;
        String choiceMenu = null;

        while (prosesPemesanan) {
            CLS.Clearscreen();
            Tampilan.pilihMenu(getNamaResto(), getAlamatResto());
            Input.pesanInput();
            int userInput = input.pilihMenu(0,2);

            if (userInput == 0) {
                if (!orderDone) {
                    Tampilan.batalPesan();
                    Input.pesanInput();
                    int userInput2 = input.pilihMenu(1,2);
                    if(userInput2 == 1) {
                        prosesPemesanan = false;
                        break;
                    }
                }else if (orderDone) {
                    prosesPemesanan = false;
                    CLS.Clearscreen();
                    Tampilan.pemesananENd();
                    input.nextLine();
                    break;
                }
            } else if (userInput == 1) {
                int index = 0;
                CLS.Clearscreen();
                Tampilan.pesanMakananHeader(getNamaResto(), getAlamatResto());
                for (Meal element : foods) { //memunculkan list makanan yang ada
                    Meal makananObject = foods.get(index);
                    makananObject.toString();
                    index++;
                }
                Tampilan.pesanMakanEnd();
                Input.pesanInput();
                choiceMenu = input.nextLine();
                // Memeriksa apakah makanan ada atau tidak
                if (choiceMenu.equals("0")) break;
                else {
                    index = 0;
                    for (Meal element : foods) {
                        Meal makananObject = foods.get(index);
                        // Kalau menu yg dicari ditemukan, masukkan ke order
                        if (makananObject.getIDmeal().equals(choiceMenu)) {
                            menuFound = true;
                            IDmeal = makananObject.getIDmeal();
                            namaMeal = makananObject.getNamaMeal();
                            harga = makananObject.getHargaMeal();

                            System.out.print("    Banyak kuantitas menu yang dipesan: ");
                            Banyaknya = input.validasiINT();
                            totalharga = harga*Banyaknya;
                            orderObject.tambahDetailpesanan(IDmeal, namaMeal, harga, Banyaknya);
                            //Memunculkan pesanan untuk saat ini
                            CLS.Clearscreen();
                            orderObject.tampilPemesanan();
                            input.nextLine();

                            orderDone = true;
                            break;
                        } else index++;
                    }
                    if (!menuFound) {
                        System.out.println("ID tidak valid!");
                        System.out.println("Press any key to continue...");
                        input.nextLine();
                    }
                }
            } else if (userInput == 2) { // Mesan minuman
                int index = 0;
                // Nunjukin minuman yang ada
                CLS.Clearscreen();
                Tampilan.pesanMinumheader(getNamaResto(), getAlamatResto());
                for (Meal element : drinks) { //memunculkan list minuman yang ada
                    Meal minumanObject = drinks.get(index);
                    minumanObject.toString();
                    index++;
                }
                Tampilan.pesanMinumEnd();
                Input.pesanInput(); //meminta user memilih minuman dengan memasukkan id
                choiceMenu = input.nextLine();
                // Memeriksa apakah minuman ada atau tidak
                if (choiceMenu.equals("0")) break;
                else {
                    index = 0;
                    for (Meal element : drinks) {
                        Meal minumanObject = drinks.get(index);
                        // Kalau menu yg dicari ditemukan
                        if (minumanObject.getIDmeal().equals(choiceMenu)) {
                            menuFound = true;
                            IDmeal = minumanObject.getIDmeal();
                            namaMeal = minumanObject.getNamaMeal();
                            harga = minumanObject.getHargaMeal();

                            System.out.print("    Banyak kuantitas menu yang dipesan: ");
                            Banyaknya = input.validasiINT();
                            totalharga = harga * Banyaknya;
                            // Memasukkan data ke objek order details
                            orderObject.tambahDetailpesanan(IDmeal, namaMeal, harga, Banyaknya);
                            //Memunculkan pesanan untuk saat ini
                            CLS.Clearscreen();
                            orderObject.tampilPemesanan();
                            input.nextLine();

                            orderDone = true;
                            break;
                        } else index++;
                    }
                    if (!menuFound) { //jika ternyata menu tidak ditemukan
                        System.out.println(" Menu tidak ditemukan!");
                        System.out.println("Press any key to continue...");
                        input.nextLine();
                    }
                }
            }
        }
        return orderDone;

    }

    /**
     * Methods: equals
     * Memeriksa apakah ada duplikat atau tidak
     * @param otherObject
     * @return
     */

    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        }
        return true;
    }

    /**
     * Method: toString
     * @return null, tapi memberikan printf toString sesuai format menu yang ada
     */
    public String toString() {
        System.out.printf("|| %-9s| %-30s| %-21s||\n", getIDresto(), getNamaResto(), getAlamatResto());
        return null;
    }

    // Methods: Getter and setter


    static class Tampilan {
        public static void pilihMenu(String namaResto, String alamatResto) {
            System.out.println("|=========================================================|");
            System.out.println("|                        FOOD RUSH                        |");
            System.out.println("|           YOUR NUMBER 1 FOOD DELIVERY SERVICE           |");
            System.out.println("|---------------------------------------------------------|");
            System.out.printf ("| %-52s||\n", namaResto);
            System.out.printf ("| Alamat  : %-52s||\n", alamatResto);
            System.out.println("----------------------------------------------------------| ");
            System.out.println("|   [1] Menu Makanan                                      |");
            System.out.println("|   [2] Menu Minuman                                      |");
            System.out.printf(" |   [3] Keluar");
            System.out.println("|=========================================================|");
        }
        public static void lihatMakananHeader(String namaResto, String alamatResto) {
            System.out.println("|=========================================================|");
            System.out.println("|                             MENU                        |");
            System.out.printf ("|%-52s||\n", namaResto);
            System.out.printf ("|Alamat  : %-52s||\n", alamatResto);
            System.out.println("| ------------------------------------------------------ -|");
            System.out.println("|   ID    |        NAMA MENU         |      HARGA         |");
            System.out.println("|---------------------------------------------------------|");
        }
        public static void tampilanLanjut() {
            System.out.println("------------------------------------------------------");
            System.out.println("press ENTER to back.... ");

        }

        public static void lihatMinumanHeader(String namaResto, String alamatResto) {
            System.out.println("|=========================================================|");
            System.out.println("|                             MENU                        |");
            System.out.printf ("|%-52s||\n", namaResto);
            System.out.printf ("|Alamat  : %-52s||\n", alamatResto);
            System.out.println("| ------------------------------------------------------ -|");
            System.out.println("|   ID    |        NAMA MENU         |      HARGA         |");
            System.out.println("|---------------------------------------------------------|");
        }
        public static void lihatMinumanFooter() {
            System.out.println("------------------------------------------------------");
            System.out.println("press ENTER to back.... ");
        }

        public static void pesanMakananHeader(String namaResto, String alamatResto) {
            System.out.println("|=========================================================|");
            System.out.println("|                        PEMESANAN                        |");
            System.out.printf ("|%-52s||\n", namaResto);
            System.out.printf ("|Alamat  : %-52s||\n", alamatResto);
            System.out.println("| ------------------------------------------------------ -|");
            System.out.println("|   ID    |        NAMA MENU         |      HARGA         |");
            System.out.println("|---------------------------------------------------------|");
        }
        public static void pesanMakanEnd() {
            System.out.println("|=========================================================|");
            System.out.println("  Masukkan ID untuk memesan (0 untuk batal)");
        }

        public static void pesanMinumheader(String namaResto, String alamatResto) {
            System.out.println("|=========================================================|");
            System.out.println("|                        PEMESANAN                        |");
            System.out.printf ("|%-52s||\n", namaResto);
            System.out.printf ("|Alamat  : %-52s||\n", alamatResto);
            System.out.println("| ------------------------------------------------------ -|");
            System.out.println("|   ID    |        NAMA MENU         |      HARGA         |");
            System.out.println("|---------------------------------------------------------|");
        }
        public static void pesanMinumEnd() {
            System.out.println("|=========================================================|");
            System.out.println("  Masukkan ID untuk memesan (0 untuk batal)");
        }

        public static void addMenu() {
            System.out.println("|=========================================================|");
            System.out.println("|                        FOOD RUSH                        |");
            System.out.println("|            YOUR NUMBER 1 FOOD DELIVERY SERVICE          |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|                           MENU                          |");
            System.out.println("```````````````````````````````````````````````````````````");
            System.out.println("| [1] Tambah nemu makanan                                 |");
            System.out.println("| [2] Tambah menu minumam                                 |");
            System.out.println("| [0] Keluar                                              |");
            System.out.println("|=========================================================|");
        }

        public static void tambahMEnu(String menu) {
            System.out.println("|=========================================================|");
            System.out.printf("|                     ADD RESTORAN: %7s                 |\n", menu);
            System.out.println("----------------------------------------------------------| ");
        }

        public static void tambahMenusuccess() {
            System.out.println("||Menu berhasil ditambahkan!       ");
        }

        public static void batalAddresto() {
            System.out.println("===============================================================");
            System.out.println(" Yakin ingin keluar? [1. YA] [2. Tidak]");

        }

        public static void batalPesan() {
            System.out.println("===============================================================");
            System.out.println(" Yakin ingin keluar? [1. YA] [2. Tidak]");
        }

        public static void pemesananENd() {
            System.out.println("Pesanan ditambahkan!");
            System.out.println("press any key to continue...");


        }
    }
}
