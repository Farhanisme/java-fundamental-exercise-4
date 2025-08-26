package p4classobject;

public class ModifOperasiBangunDatar {
    double nilai1, luas, nilai2, volume;
    String deskripsi; // Menyimpan deskripsi operasi

    // Metode menghitung luas bangun datar
    public void luas_persegi(double n) {
        nilai1 = n;
        luas = nilai1 * nilai1;
        deskripsi = "Luas Persegi dengan sisi " + n + " adalah " + luas;
    }

    public void luas_segitiga(double a, double t) {
        nilai1 = a;
        nilai2 = t;
        luas = 0.5 * nilai1 * nilai2;
        deskripsi = "Luas Segitiga dengan alas " + a + " dan tinggi " + t + " adalah " + luas;
    }

    public void persegi_panjang(double p, double l) {
        nilai1 = p;
        nilai2 = l;
        luas = nilai1 * nilai2;
        deskripsi = "Luas Persegi Panjang dengan panjang " + p + " dan lebar " + l + " adalah " + luas;
    }

    public void luas_lingkaran(double jari) {
        nilai1 = jari;
        luas = 3.14 * nilai1 * nilai1;
        deskripsi = "Luas Lingkaran dengan jari-jari " + jari + " adalah " + luas;
    }

    // Metode menghitung volume bangun ruang
    public void volume_kubus(double s) {
        volume = s * s * s;
        deskripsi = "Volume Kubus dengan sisi " + s + " adalah " + volume;
    }

    public void volume_balok(double p, double l, double t) {
        volume = p * l * t;
        deskripsi = "Volume Balok dengan panjang " + p + ", lebar " + l + ", dan tinggi " + t + " adalah " + volume;
    }

    public void volume_tabung(double r, double t) {
        volume = 3.14 * r * r * t;
        deskripsi = "Volume Tabung dengan jari-jari " + r + " dan tinggi " + t + " adalah " + volume;
    }

    public void volume_limas_segiempat(double s, double t) {
        double luas_alas = s * s;
        volume = (1.0 / 3.0) * luas_alas * t;
        deskripsi = "Volume Limas Segiempat dengan sisi alas " + s + " dan tinggi " + t + " adalah " + volume;
    }

    public void volume_kerucut(double r, double t) {
        volume = (1.0 / 3.0) * 3.14 * r * r * t;
        deskripsi = "Volume Kerucut dengan jari-jari " + r + " dan tinggi " + t + " adalah " + volume;
    }

    public void volume_bola(double r) {
        volume = (4.0 / 3.0) * 3.14 * r * r * r;
        deskripsi = "Volume Bola dengan jari-jari " + r + " adalah " + volume;
    }

    // Metode untuk menampilkan hasil luas
    public void tampilLuas() {
        System.out.println(deskripsi);
    }

    // Metode untuk menampilkan hasil volume
    public void tampilVolume() {
        System.out.println(deskripsi);
    }
}
