/**
 * Class Pemain digunakan untuk menyimpan data Pemain
 * 
 * @author Ahmad Faqih Al Ghiffary
 * @version 17 Oktober 2022
 */
public class Pemain {
    private String nama;

    /**
     * Mehtod Constructor, No parameter
     */
    public Pemain() {

    }

    /**
     * Method Constructor
     * 
     * @param nama Nama Pemain
     */
    public Pemain(String nama) {
        this.nama = nama;
    }

    /**
     * Method Accessor
     * 
     * @return Nama Pemain
     */
    public String getNama() {
        return nama;
    }

    /**
     * Method Mutator
     * 
     * @param nama Nama Pemain
     */
    public void setNama(String nama) {
        this.nama = nama;
    }
}
