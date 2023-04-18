public class Meal {
    // Variables
    private String IDmeal;
    private String namaMeal;
    private double hargaMeal;

    // Constructor

    public Meal() {

    }

    public Meal(String IDmeal, String namaMeal, double hargaMeal) {
        this.IDmeal = IDmeal;
        this.namaMeal = namaMeal;
        this.hargaMeal = hargaMeal;
    }


    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        }
        return true;
    }

    public String toString() {
        System.out.printf("|| %-9s| %-37s| Rp%-12.2f||\n", getIDmeal(), getNamaMeal(), getHargaMeal());
        return null;
    }

    //  Getter dan Setter
    public String getNamaMeal() {
        return namaMeal;
    }

    public double getHargaMeal() {
        return hargaMeal;
    }

    public String getIDmeal() {
        return IDmeal;
    }
}
