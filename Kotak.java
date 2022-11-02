/**
 * Class Kotak digunakan untuk menampung Class Koin dan Class Monster
 * 
 * @author Ahmad Faqih Al Ghiffary
 * @version 17 Oktober 2022
 */
public class Kotak {
    private Koin coin;
    private Monster monsta;

    /**
     * Method Constructor
     */
    public Kotak() {
        coin = new Koin();
        monsta = new Monster();
    }

    /**
     * Method Mutator
     * 
     * @param c class Koin
     */
    public void addKoin(Koin c) {
        coin = c;
    }

    /**
     * Method Mutator
     * 
     * @param m class Monster
     */
    public void addMonster(Monster m) {
        monsta = m;
    }

    /**
     * Method Accessor
     * 
     * @return coin
     */
    public Koin getKoin() {
        return coin;
    }

    /**
     * Method Accessor
     * 
     * @return monsta
     */
    public Monster getMonster() {
        return monsta;
    }

    /**
     * Cek keberadaan Koin (Nilai 0 dianggap tidak ada)
     * 
     * @return true jika ada Koin <p>
     *         false jika tidak ada Koin <p>
     */
    public boolean isThereKoin() {
        if (coin.getNilai() == 0) {
            return false;
        }
        return true;
    }

    /**
     * Cek keberadaan Monster (Nilai 0 dianggap tidak ada)
     * 
     * @return true jika ada Monster <p>
     *         false jika tidak ada Monster <p>
     */
    public boolean isThereMonster() {
        if (monsta.getNilai() == 0) {
            return false;
        }
        return true;
    }
}