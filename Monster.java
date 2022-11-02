/**
 * Class Monster digunakan untuk menyimpan monster
 * 
 * @author Ahmad Faqih Al Ghiffary
 * @version 17 Oktober 2022
 */
public class Monster {
    private int nilai;
    private final String[] nama = { "Kecil", "Besar", "Raksasa" };

    /**
     * Method Constructor
     */
    public Monster() {
        nilai = 0;
    }

    /**
     * Method Constructor
     * 
     * @param nilai Monster
     */
    public Monster(int nilai) {
        this.nilai = nilai;
    }

    /**
     * Method Accessor
     * 
     * @return Nilai Monster
     */
    public int getNilai() {
        return nilai;
    }

    /**
     * Method Accessor
     * 
     * @return String Monster
     */
    public String getNama() {
        return nama[nilai - 1];
    }

    /**
     * Method Mutator
     * 
     * @param nilai baru Monster 
     */
    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}