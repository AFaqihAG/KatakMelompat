/**
 * Class KotakPermainan menampung dan mengisi Kotak dari Class Kotak[]
 *
 * @author Ahmad Faqih Al Ghiffary
 * @version 17 Oktober 2022
 */
import java.util.ArrayList;
import java.util.Collections;

public class KotakPermainan {
    private Kotak[] boardGame;
    private int jumKotak;
    private int jumKoin;
    private int jumMonster;
    private int[] nilaiKoinAcak;
    private int[] nilaiMonsterAcak;

    /**
     * Inisialisasi banyak kotak, koin, dan monster
     * 
     * @param jumKotak banyak kotak dalam permainan
     * @param kesulitan tingkat kesulitan permainan
     */
    public KotakPermainan(int jumKotak, int kesulitan) {
        this.jumKotak = jumKotak;
        /*
         * (jumKoin, jumMonster) setiap tingkat kesulitan
         * Mudah  : (4/5 kotak, 1/2 kotak)
         * Sedang : (3/4 kotak, 2/3 kotak)
         * Susah  : (2/3 kotak, 3/4 kotak)
         */
        this.jumKoin = ((5 - kesulitan) * jumKotak) / (6 - kesulitan);
        this.jumMonster = (kesulitan * jumKotak) / (kesulitan + 1);
        generateAcak();
        inisialisasiKotak();
    }

    /**
     * Inisialisasi int[] nilaiKoinAcak dan int[] nilaiMonsterAcak <p>
     * Membuat ArrayList<> ListKoin / ListMonster masing-masing terhadap nilai koin dan nilai monster <p>
     * Memasukkkan nilai Arraylist<> ListKoin sesuai dengan kesulitan <p>
     * Shuffle Arraylist<> ListKoin dan  ArrayList<> ListMonster <p>
     * Copy nilai Arraylist<> ListKoin ke int[] nilaiKoinAcak <p>
     * Copy nilai ArrayList<> ListMonster ke int[] nilaiMonsterAcak <p>
     */
    private void generateAcak() {
        //Buat objek nilaiKoinAcak
        nilaiKoinAcak = new int[jumKotak];

        //Buat ArrayList untuk menampung nilai sementara
        ArrayList<Integer> listKoin = new ArrayList<Integer>();

        //ArrayList index 0 hingga (jumKoin - 1) berisi Koin (Bernilai 1, 2, atau 3)
        for (int i = 0; i < (jumKoin / 3); i++) {
            listKoin.add(1);
        }
        for (int i = (jumKoin / 3); i < (2 * jumKoin / 3); i++) {
            listKoin.add(2);
        }
        for (int i = (2 * jumKoin / 3); i < jumKoin; i++) {
            listKoin.add(3);
        }
        //ArrayList index jumKoin hingga (jumKotak - 1) tidak berisi Koin/dianggap tidak ada (Bernilai 0)
        for (int i = jumKoin; i < jumKotak; i++) {
            listKoin.add(0);
        }
        //Shuffle ArrayList dan masukkan nilai nilaiKoinAcak berdasarkan nilai dari ArrayList  
        Collections.shuffle(listKoin);
        for (int i = 0; i < jumKotak; i++) {
            nilaiKoinAcak[i] = listKoin.get(i);
        }

        //Buat objek nilaiMonsterAcak
        nilaiMonsterAcak = new int[jumKotak];

        //Buat ArrayList untuk menampung nilai sementara
        ArrayList<Integer> listMonster = new ArrayList<Integer>();
        
        //ArrayList index 0 hingga (jumMonster - 1) berisi Monster (Bernilai 1, 2, atau 3)
        for (int i = 0; i < (jumMonster / 3); i++) {
            listMonster.add(1);
        }
        for (int i = (jumMonster / 3); i < (2 * jumMonster / 3); i++) {
            listMonster.add(2);
        }
        for (int i = (2 * jumMonster / 3); i < jumMonster; i++) {
            listMonster.add(3);
        }
        //ArrayList index jumMonster hingga (jumKotak - 1) tidak berisi Monster/dianggap tidak ada (Bernilai 0)
        for (int i = jumMonster; i < jumKotak; i++) {
            listMonster.add(0);
        }
        //Shuffle ArrayList dan masukkan nilai nilaiMonsterAcak berdasarkan nilai dari ArrayList
        Collections.shuffle(listMonster);
        for (int i = 0; i < jumKotak; i++) {
            nilaiMonsterAcak[i] = listMonster.get(i);
        }
    }

    /**
     * Inisialisasi Kotak[] boardGame <p>
     * Memasukkan masing-masing Kotak nilaiKoinAcak dan nilaiMonsterAcak kedalam Kotak[] boardGame <p>
     */
    private void inisialisasiKotak() {
        boardGame = new Kotak[jumKotak];

        for (int i = 0; i < jumKotak; i++) {
            boardGame[i] = new Kotak();
            boardGame[i].addKoin(new Koin(nilaiKoinAcak[i]));
            boardGame[i].addMonster(new Monster(nilaiMonsterAcak[i]));;
        }
    }

    /**
     * Memberitahukan ada/tidaknya koin dan monster dalam suatu kotak
     * 
     * @param posisi Menunjukkan index Kotak[] boardGame
     * @return  jika kotak ke-posisi mengandung: <p>
     *          koin dan monster: return 2 <p>
     *          koin            : return 1 <p>
     *          monster         : return -1 <p>
     *          tidak keduanya  : return 0 <p>
     */
    public int contain(int posisi) {
        if (boardGame[posisi].isThereKoin() && boardGame[posisi].isThereMonster()) {
            return 2;
        } else if (boardGame[posisi].isThereKoin()) {
            return 1;
        } else if (boardGame[posisi].isThereMonster()) {
            return -1;
        } 
        return 0;
    }
    
    /**
     * Mengambil Kotak dari Kotak[] boardGame dengan index tertentu
     * 
     * @param posisi
     * @return boardGame[posisi]
     */
    public Kotak getKotak(int posisi) {
        return boardGame[posisi];
    }   
}