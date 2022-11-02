/**
 * Class MainLompatKatak sebagai Class untuk memulai permainan
 * 
 * @author Ahmad Faqih Al Ghiffary
 * @version 17 Oktober 2022
 */
import java.util.Scanner;

public class MainLompatKatak {
    private boolean play;
    private int banyakKotak = 10;
    private int inputMenu = 0;
    private int kesulitan;
    private int besarLangkah;
    private int majuMundur;
    Scanner in = new Scanner(System.in);

    /**
     * Method Constructor
     */
    public MainLompatKatak() {

    }

    /**
     * Method Accessor
     * 
     * @return play
     */
    public boolean getPlay() {
        return play;
    }

    /**
     * Method Accessor
     * 
     * @return banyak kotak
     */
    public int getBanyakKotak() {
        return banyakKotak;
    }

    /**
     * Method Accessor
     * 
     * @return input menu
     */
    public int getInputMenu() {
        return inputMenu;
    }

    /**
     * Method Accessor
     * 
     * @return kesulitan
     */
    public int getKesulitan() {
        return kesulitan;
    }

    /**
     * Method Accessor
     * 
     * @return besar langkah
     */
    public int getBesarLangkah() {
        return besarLangkah;
    }

    /**
     * Method Accessor
     * 
     * @return maju/mundur
     */
    public int getMajuMundur() {
        return majuMundur;
    }

    /**
     * Method Mutator
     * 
     * @param play
     */
    public void setPlay(boolean play) {
        this.play = play;
    }

    /**
     * Method Mutator
     * 
     * @param banyakKotak
     */
    public void setBanyakKotak(int banyakKotak) {
        this.banyakKotak = banyakKotak;
    }

    /**
     * Menu untuk menginput nama
     * 
     * @param pemain
     */
    public void inputNama(Pemain pemain) {
        System.out.println("Masukkan nama: ");
        pemain.setNama(in.nextLine());
    }

    /**
     * Method Mutator
     * 
     * @param inputMenu
     */
    public void setInputMenu(int inputMenu) {
        this.inputMenu = inputMenu;
    }

    /**
     * Method Mutator
     * 
     * @param kesulitan
     */
    public void setKesulitan(int kesulitan) {
        this.kesulitan = kesulitan;
    }

    /**
     * Method Mutator
     * 
     * @param besarLangkah
     */
    public void setBesarLangkah(int besarLangkah) {
        this.besarLangkah = besarLangkah;
    }

    /**
     * Method Mutator
     * 
     * @param majuMundur
     */
    public void setMajuMundur(int majuMundur) {
        this.majuMundur = majuMundur;
    }

    /**
     * Menampilkan menu awal permainan
     */
    public void menuPermainan() {
        while (inputMenu != 1) {
            System.out.println("Katak Lompat Katak!");
            System.out.println("1. Masuk kedalam permainan!");
            System.out.println("2. Lihat aturan permainan");

            do {
                System.out.print("Masukkan input: ");
                inputMenu = in.nextInt();
            } while (!(inputMenu == 1 || inputMenu == 2));

            if (inputMenu == 2) {
                System.out.println("\nPada permainan ini katak akan meloncat-loncat dari satu kotak ke kotak lainnya");
                System.out.println("Katak memulai lompatan dari kotak no-0 hingga kotak terakhir");
                System.out.println(
                        "Pada setiap langkah katak dapat melompat ke kotak sebelahnya atau melompat jauh selang satu kotak");
                System.out.println("Katak dapat memilih untuk melompat maju atau mundur (jika memungkinkan)");
                System.out.println("Pada setiap lompatan, katak berkemungkinan untuk menjumpai koin atau monster");
                System.out.println("Koin akan menambah skor katak dan monster akan mengurangi skor katak");
                System.out.println("Permainan akan berakhir ketika: ");
                System.out.println(" 1. Skor katak terlalu rendah (skor < 0)");
                System.out.println(" 2. Katak telah mencapai kotak terakhir");
                System.out.println(
                        "Pada akhir permainan pemain akan diberikan ranking sesuai dengan skor yang diperoleh!\n");
            }
        }
    }

    /**
     * Menu untuk memilih kesulitan
     */
    public void inputKesulitan() {
        System.out.println("\nTentukan tingkat kesulitan: \n 1. mudah \n 2. sedang \n 3. susah");
        do {
            System.out.print("Masukkan input: ");
            kesulitan = in.nextInt();
        } while (!(kesulitan == 1 || kesulitan == 2 || kesulitan == 3));
    }

    /**
     * Memasukkan nama Pemain
     * 
     * @param pemain class Pemain
     */
    public void getPemainNama(Pemain pemain) {
        System.out.println("Masukkan nama pemain: ");
        pemain = new Pemain(in.nextLine());
    }

    /**
     * Menampilkan string yang menunjukkan keberadaan Koin/Monster pada kotak yang dilompati katak
     * 
     * @param katak class Katak
     * @param kotakpermainan class KotakPemainan
     * @param pemain class Pemain
     */
    public void lompatKoin(Katak katak, KotakPermainan kotakpermainan, Pemain pemain) {
        String koin_monster = null;
        switch (kotakpermainan.contain(katak.getPosisi())) {
            case 2:
                koin_monster = new String("koin dan monster!");
                break;

            case 1:
                koin_monster = new String("koin!");
                break;

            case 0:
                koin_monster = new String("kotak kosong!");
                break;

            case -1:
                koin_monster = new String("monster!");
                break;
        }

        System.out.println("Katak " + pemain.getNama() + " melompat ke koin " + koin_monster);
    }

    /**
     * Input menu maju atau mundur
     * 
     * @param katak class Katak
     * @param pemain class Pemain
     * @param majuMundur untuk memberi perintah kepada Katak agar maju atau mundur
     * @return
     */
    public int pilihMajuMundur(Katak katak, Pemain pemain, int majuMundur) {
        System.out.println("Apakah " + pemain.getNama() + " ingin maju/mundur");
        System.out.println("1. Maju");
        System.out.println("2. Mundur");
        System.out.println("Masukkan input (1/2): ");
        do {
            majuMundur = in.nextInt();
        } while (!(majuMundur == 1 || majuMundur == 2));

        return majuMundur;
    }

    /**
     * Input besaran langkah maju Katak
     * 
     * @param katak class Katak
     */
    public void pilihLangkahMaju(Katak katak) {
        System.out.println("Masukkan langkah maju (1/2): ");
        do {
            besarLangkah = in.nextInt();
        } while (!(besarLangkah == 1 || besarLangkah == 2));

        if (besarLangkah == 1) {
            katak.loncatDekat();
        } else {
            katak.loncatJauh();
        }
    }

    /**
     * Input besaran langkah mundur Katak
     * 
     * @param katak class Katak
     */
    public void pilihLangkahMundur(Katak katak) {
        System.out.println("Masukkan langkah mundur (1/2): ");
        do {
            besarLangkah = in.nextInt();
        } while (!(besarLangkah == 1 || besarLangkah == 2));

        if (besarLangkah == 1) {
            katak.loncatDekatMundur();
        } else {
            katak.loncatJauhMundur();
        }
    }

    /**
     * Manampilkan menu untuk Pemain mengulang permainan jika dinginkan
     * 
     * @param pemain class Pemain
     * @return Jika ingin mengulang permainan : true <p>
     *         Jika tidak ingin mengulang permainan : false
     */
    public boolean ulangPermainan(Pemain pemain) {
        String yn;
        System.out.println("Apakah " + pemain.getNama() + " ingin mengulang permainan?");
        System.out.println("Ketik 'Ya' jika " + pemain.getNama() + " ingin mengulang permainan!");
        System.out.println("Ketik 'Tidak' jika ingin keluar dari permainan.");
        do {
            yn = in.nextLine();
            if (yn.equalsIgnoreCase("Ya")) {
                return true;
            }
        } while (!(yn.equalsIgnoreCase("Ya") || yn.equalsIgnoreCase("Tidak")));
        return false;
    }

    /**
     * Tempat memulai permainan-
     * 
     * @param args
     */
    public static void main(String[] anu) {
        //Membuat objek MainLompatKatak, Pemain, Katak, KotakPermainan        
        MainLompatKatak go = new MainLompatKatak();
        Pemain pemain = new Pemain();
        Katak katak = new Katak();
        KotakPermainan kotakpermainan;
        
        go.inputNama(pemain);
        go.menuPermainan();

        //Set Play = true agar bisa memulai permainan
        go.setPlay(true);
        while (go.getPlay()) {
            //Atur posisi dan skor awal katak
            katak.setSkor(100);
            katak.setPosisi(0);

            go.inputKesulitan();

            //Buat Kotak permainan dengan banyak kotak dan kesulitan yang telah dipilih
            kotakpermainan = new KotakPermainan(go.getBanyakKotak(), go.getKesulitan());

            //Setiap selesai loop akan dicek skor dan posisi katak
            //Jika skor bernilai negatif atau posisi katak sudah mencapai kotak terakhir maka keluar loop
            while (katak.getSkor() >= 0 && katak.getPosisi() < (go.getBanyakKotak() - 1)) {
                //Jika posisi katak berada di kotak[0] atau kotak[1], katak hanya bisa melangkah maju
                //Jika posisi katak berada di kotak[banyakkotak - 2], paksa katak untuk melangkah ke kotak terakhir
                //Jika posisi katak berada di antara kedua kondisi di atas, maka diperbolehkan untuk maju / mundur
                if (katak.getPosisi() >= 2 && katak.getPosisi() <= (go.getBanyakKotak() - 3)) {
                    go.setMajuMundur(go.pilihMajuMundur(katak, pemain, go.getMajuMundur()));
                    if (go.getMajuMundur() == 1) {
                        go.pilihLangkahMaju(katak);
                    } else {
                        go.pilihLangkahMundur(katak);
                    }
                } else if (katak.getPosisi() <= 1) {
                    System.out.println("Katak hanya bisa melangkah maju");
                    go.pilihLangkahMaju(katak);
                } else if (katak.getPosisi() >= (go.getBanyakKotak() - 2)) {
                    System.out.println("Katak hanya boleh melangkah ke kotak terakhir");
                    katak.setPosisi(go.getBanyakKotak() - 1);
                }

                System.out.println("Katak sekarang berada di posisi ke-" + katak.getPosisi());

                //Tentukan isi kotak yang dilompati oleh Katak
                switch (kotakpermainan.contain(katak.getPosisi())) {
                    //Katak melompat ko kotak berisi koin dan monster
                    case 2:
                        System.out.println("Katak melompat ke koin " + kotakpermainan.getKotak(katak.getPosisi()).getKoin().getNama());
                        System.out.println("Katak melompat ke monster " + kotakpermainan.getKotak(katak.getPosisi()).getMonster().getNama());
                        System.out.println("Koin menambah skor " + pemain.getNama() + " sebesar " + 5 * kotakpermainan.getKotak(katak.getPosisi()).getKoin().getNilai());
                        System.out.println("Monster mengurangi skor " + pemain.getNama() + " sebesar " + 5 * kotakpermainan.getKotak(katak.getPosisi()).getMonster().getNilai());
                        katak.setSkor(katak.getSkor() + 5 * kotakpermainan.getKotak(katak.getPosisi()).getKoin().getNilai() - 5 * kotakpermainan.getKotak(katak.getPosisi()).getMonster().getNilai());
                        break;
                    //Katak melompat ke kotak berisi koin
                    case 1:
                        System.out.println("Katak melompat ke koin " + kotakpermainan.getKotak(katak.getPosisi()).getKoin().getNama());
                        System.out.println("Koin menambah skor " + pemain.getNama() + " sebesar " + 5 * kotakpermainan.getKotak(katak.getPosisi()).getKoin().getNilai());
                        katak.setSkor(katak.getSkor() + 5 * kotakpermainan.getKotak(katak.getPosisi()).getKoin().getNilai());
                        break;
                    //Katak melompat ke kotak kosong (tidak berisi koin dan monster)
                    case 0:
                        System.out.println("Katak melompat ke kotak kosong");
                        System.out.println("Skor anda tidak berubah");
                        break;
                    //Katak melompat ke kotak berisi monster
                    case -1:
                        System.out.println("Katak melompat ke monster " + kotakpermainan.getKotak(katak.getPosisi()).getMonster().getNama());
                        System.out.println("Monster mengurangi skor " + pemain.getNama() + " sebesar " + 5 * kotakpermainan.getKotak(katak.getPosisi()).getMonster().getNilai());
                        katak.setSkor(katak.getSkor() - 5 * kotakpermainan.getKotak(katak.getPosisi()).getMonster().getNilai());
                        break;
                }

                //Setelah melompat, Koin / Monster yang ditemukan akan hilang
                kotakpermainan.getKotak(katak.getPosisi()).getKoin().setNilai(0);
                kotakpermainan.getKotak(katak.getPosisi()).getMonster().setNilai(0);

                System.out.println("Skor sementara: " + katak.getSkor());
                System.out.println();
            }

            //Ketika keluar while loop dikarenakan skor bernilai negatif, tampilkan ini
            if (katak.getSkor() < 0) {
                System.out.println("Skor anda terlalu rendah untuk melanjutkan permainan!");
            }

            System.out.println("Skor akhir anda: " + katak.getSkor());

            //Pembagian rank berdasarkan skor akhir yang diperoleh
            if (katak.getSkor() < (100 + (go.getBanyakKotak() / 2))) {
                System.out.println("Rank : Bad!");
            } else if (katak.getSkor() < (100 + (go.getBanyakKotak()))) {
                System.out.println("Rank: Good!");
            } else {
                System.out.println("Rank: Excelent!");
            }

            //Input menu untuk mengulangi permainan jika dibutuhkan
            go.setPlay(go.ulangPermainan(pemain));
        }

        System.out.println("Terimakasih sudha bermina sdfoefisdkjfcnjkdfgksw29349t35#$%TEDGFBSWvwcq3eT)$C?>B.vblfd");
    }
}