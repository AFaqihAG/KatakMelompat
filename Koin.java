/**
 * Class Koin digunakan untuk menyimpan koin
 * 
 * @author Ahmad Faqih Al Ghiffary
 * @version 17 Oktober 2022
 */
public class Koin {
    private int nilai;
    private final String[] nama = { "Kecil", "Besar", "Raksasa" };

    /**
     * Method Constructor
     */
    public Koin() {
        nilai = 0;
    }

    /**
     * Method Constructor
     * 
     * @param nilai Koin
     */
    public Koin(int nilai) {
        this.nilai = nilai;
    }

    /**
     * Method Accessor
     * 
     * @return Nilai Koin
     */
    public int getNilai() {
        return nilai;
    }

    /**
     * Method Accessor
     * 
     * @return Nama Koin
     */
    public String getNama() {
        return nama[nilai - 1];
    }

    /**
     * Method Mutator
     * 
     * @param nilai baru Koin
     */
    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}
