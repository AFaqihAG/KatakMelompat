/**
 * Class Katak digunakan untuk menyimpan data Katak
 * 
 * @author Ahmad Faqih Al Ghiffary
 * @version 17 Oktober 2022
 */
public class Katak {
    private int posisi;
    private int skor;

    /**
     * Method Constructor, No parameter
     */
    public Katak() {

    }

    /**
     * Method Accessor
     * 
     * @return Posisi Katak pada suatu Kotak[]
     */
    public int getPosisi() {
        return posisi;
    }

    /**
     * Method Mutator
     * 
     * @param posisiBaru Posisi setelah diubah
     */
    public void setPosisi(int posisiBaru) {
        this.posisi = posisiBaru;
    }

    /**
     * Method Accessor
     * 
     * @return Skor Katak
     */
    public int getSkor() {
        return skor;
    }

    /**
     * Method Mutator
     * 
     * @param skorBaru Skor setelah diubah
     */
    public void setSkor(int skorBaru) {
        this.skor = skorBaru;
    }

    /**
     * Katak berpindah 1 kotak ke depan (posisi++)
     */
    public void loncatDekat() {
        posisi += 1;
    } 

    /**
     * Katak berpindah 2 kotak ke depan (posis += 2))
     */
    public void loncatJauh() {
        posisi += 2;
    }

    /**
     * Katak berpindah 1 kotak ke belakang (posisi--)
     */
    public void loncatDekatMundur() {
        posisi -= 1;
    }

    /**
     * Katak berpindah 2 kotak ke belakang (posisi -= 2)
     */
    public void loncatJauhMundur() {
        posisi -= 2;
    }
}