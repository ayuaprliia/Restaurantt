import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Pemesanan {
    // Variables
    private String idOrders;
    private String idResto;
    private String namaResto;
    private String waktuOrder;
    private double jarakResto;
    private ArrayList<detailPemesanan> listDetailPemesanans = new ArrayList<>();
    private SettingInput input = new SettingInput();
    private double totalBiaya;

    public Pemesanan() {
    }

    public Pemesanan(String idOrders, String idResto, String namaResto, double jarakResto) {
        this.idOrders = idOrders;
        this.idResto = idResto;
        this.namaResto = namaResto;
        this.jarakResto = jarakResto;
        this.waktuOrder = getOrderTime();
    }
    static class detailPemesanan extends Meal {
        // Variables
        private int totalPesan;
        private double totalHarga;

        //Constructor
        public detailPemesanan() {
            super();
        }

        public detailPemesanan(String idDish, String namaDish, double hargaDish, int totalPesan) {
            super(idDish, namaDish,hargaDish);
            this.totalPesan = totalPesan;
            totalHarga = totalPesan * hargaDish;
        }

        public String toString() {
            System.out.printf("|| %-9s| %-37s| %-4d| Rp%-11.2f| Rp%-13.2f||\n", getIDmeal(), getNamaMeal(), getTotalPesan(), getHargaMeal(), getTotalHarga());
            return null;
        }

        public int getTotalPesan() {

            return totalPesan;
        }

        public double getTotalHarga() {

            return totalHarga;
        }

    }

    // Methods

    public String getOrderTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        String orderTime = formatter.format(date);
        return orderTime;
    }

    public void tambahDetailpesanan(String idDish, String namaDish, double hargaDish, int totalPesan) {
        listDetailPemesanans.add(new detailPemesanan(idDish, namaDish,hargaDish, totalPesan));
    }

    public double subTotal() {
        int index = 0;
        double totalBiaya = 0;
        for (detailPemesanan element : listDetailPemesanans){ //menambahkan seluruh total biaya
            detailPemesanan orderDetails = listDetailPemesanans.get(index);
            totalBiaya += orderDetails.getTotalHarga();
            index++;
        }

        this.totalBiaya = totalBiaya;
        return totalBiaya;
    }
    public void tampilPesanan() {
        tampilPemesanan();
    }


    public static void strukPemesanan() {
        System.out.println("|==============================================================================");
        System.out.println("|                               RECEIPT                                        |");
    }
    public void tampilPemesanan() {
        System.out.println("-------------------------------------------------------------------------------|");
        System.out.printf("|ID Pesanan      : %-67s ||\n", idOrders);
        System.out.printf("|Nama Restoran   : %-67s ||\n", namaResto);
        System.out.printf("|Jarak           : %-5.2f km                                                            \n", jarakResto);
        System.out.printf("|Waktu Pemesanan : %-67s ||\n", waktuOrder);
        System.out.println("-------------------------------------------------------------------------------| ");
        detailPemesanan();
        System.out.printf("|| Subtotal                                                   : Rp%-12.2f ||\n", subTotal());
    }
    public void detailPemesanan() {
        System.out.println("|| ------------------------------------------------------------------------------------- || ");
        System.out.println("|| ID MENU  |             NAMA PESANAN             | QTY |     HARGA    |      TOTAL     ||");
        System.out.println("|| ------------------------------------------------------------------------------------- ||");
        int index = 0;
        for(detailPemesanan element : listDetailPemesanans) {
            detailPemesanan orderDetails = listDetailPemesanans.get(index);
            orderDetails.toString();
            index++;
        }
        System.out.println("===========================================================================================");
    }




}
