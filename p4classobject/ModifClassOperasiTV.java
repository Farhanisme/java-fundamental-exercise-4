package p4classobject;

public class ModifClassOperasiTV {
    int suara = 0;
    int terang = 0;

    public void menu() {
        System.out.println("Menu Utama: ");
        System.out.println("-----------------");
        System.out.println("1. Ganti Channel");
        System.out.println("2. Tambah Suara");
        System.out.println("3. Kurang Suara");
        System.out.println("4. Tambah Kecerahan");
        System.out.println("5. Kurang Kecerahan");
        System.out.println("-----------------");
    }

    public void ganti_channel(int c) {
        if (c == 1) {
            System.out.println("Channel anda berganti ke TVRI");
        } else if (c == 2) {
            System.out.println("Channel anda berganti ke MnC/TPI");
        } else if (c == 3) {
            System.out.println("Channel anda berganti ke INDOSIAR");
        } else if (c == 4) {
            System.out.println("Channel anda berganti ke RCTI");
        } else if (c == 5) {
            System.out.println("Channel anda berganti ke SCTV");
        } else if (c == 6) {
            System.out.println("Channel anda berganti ke ANTV");
        } else {
            System.out.println("Channel tidak tersedia");
        }
    }
    

    public void tambah_suara(int s) {
        suara += s;
        if (suara >= 100) {
            suara = 100;
            System.out.println("Suara yang ditambahkan terlalu keras");
        } else {
            System.out.println("Suara sekarang bertambah sehingga menjadi " + suara);
        }
    }

    public void kurang_suara(int s) {
        suara -= s;
        if (suara <= 0) {
            suara = 0;
            System.out.println("Suara sekarang terlalu pelan");
        } else {
            System.out.println("Suara sekarang berkurang sehingga menjadi " + suara);
        }
    }

    public void tambah_terang(int t) {
        terang += t;
        if (terang >= 100) {
            terang = 100;
            System.out.println("Gambar yang ditambahkan terlalu terang");
        } else {
            System.out.println("Gambar sekarang bertambah terang sehingga menjadi " + terang);
        }
    }

    public void kurang_terang(int t) {
        terang -= t;
        if (terang <= 0) {
            terang = 0;
            System.out.println("Gambar terlalu gelap");
        } else {
            System.out.println("Gambar sekarang berkurang sehingga menjadi " + terang);
        }
    }
}

