import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SettingInput {

    // Variable
    Scanner input = new Scanner(System.in);

    // Constructor
    public SettingInput() { }

    // Methods

    /**
     * Methods: validationInteger()
     * Digunakan untuk memastikan bahwa input yang diberikan
     * sudah sesuai dengan ketentuan: harus integer
     * @return received integer (valid)
     */
    public int validasiINT() {
        int inputINT = -1;
        boolean INTvalid = false;

        Scanner input = new Scanner(System.in);

        while (!INTvalid) {
            while (true) {
                try {
                    inputINT = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Mohon hanya input berupa angka!!");
                    input.next();
                    Input.pesanInput();
                }

            }
            INTvalid = true;

        }
        return inputINT;
    }

    public int pilihMenu(int limit1, int limitn) {
        int pilih = 0;
        boolean pilihValid = false;

        while (!pilihValid) {
            pilih = validasiINT();

            if (pilih < limit1 || pilih > limitn) {
                System.out.println("Mohon input sesuai arahan!");
                Input.pesanInput();
            } else {
                pilihValid = true;
                // System.out.println("Input benar.");
            }
        }

        return pilih;
    }


    private double validasiDouble() {
        double inputDouble = 0;

        while (true) {
            try {
                inputDouble = input.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Mohon input hanya berupa angka!!");
                input.next();
                Input.pesanInput();
            }
        }
        return inputDouble;
    }

    public double getDouble() {
        double inputPayment = 0;
        boolean inputValid = false;

        while (!inputValid) {
            inputPayment = validasiDouble();

            if (inputPayment < 0) {
                System.out.println("Mohon input hanya berupa angka!!");
                Input.pesanInput();
            } else {
                inputValid = true;
            }
        }

        return inputPayment;
    }

    public String validasiID() {
        boolean IDvalid = false;
        String ID = null;
        while (!IDvalid) {
            IDvalid = true;
            ID = input.nextLine();
            if (ID.isBlank()) {
                System.out.println("    ID tidak boleh kosong");
                IDvalid = false;
            }if (!IDvalid) {
                System.out.println("    Mohon masukkan ID yang benar.");
                System.out.print("    ID:");
            }
        }
        return ID;
    }

    public boolean isIDrestoValid(ArrayList<Resto> listRestaurant, String id) {
        boolean isIDmatch = false;
        int index = 0;

        for(Resto element : listRestaurant) {
            if(element.getIDresto().equals(id)) isIDmatch = true;
        }
        return isIDmatch;
    }

    public boolean isIDmealValid(ArrayList<Meal> meals, String id) {
        boolean isIDmatch= false;
        int index = 0;

        for(Meal element : meals) {
            if(element.getIDmeal().equals(id)) isIDmatch = true;
        }
        return isIDmatch;
    }

    public String validasiString(String variable) {
        boolean Stringvalid = false;
        String string = null;
        while (!Stringvalid) {
            Stringvalid = true;
            string = input.nextLine();
            if (string.isBlank()) {
                System.out.printf("    %s tidak boleh kosong\n", variable);
                Stringvalid = false;
            }if (!Stringvalid) {
                System.out.printf("    Mohon masukkan %s yang benar.\n", variable);
                System.out.printf("    %s:", variable);
            }
        }
        return string;
    }

    /**
     * String
     */
    public String nextLine() {
        return input.nextLine();
    }

    public String next() {
        return input.next();
    }
}
