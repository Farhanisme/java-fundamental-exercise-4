package p4classobject;

public class ClassOperasiBangunDatar {
    double nilai1, luas, nilai2;

    public void luas_persegi (double n) {
        nilai1 = n;
        luas = nilai1 * nilai1;
    }

    public void luas_segitiga (double a, double t) {
        nilai1 = a;
        nilai2 = t;
        luas = 0.5 * nilai1 * nilai2;
    }

    public void persegi_panjang (double p, double l) {
        nilai1 = p;
        nilai2 = l;
        luas = nilai1 * nilai2;
    }

    public void luas_lingkaran (double jari) {
        nilai1 = jari;
        luas = 3.14 * nilai1 * nilai1;
    }

    public void tampil() {
        System.out.println("Luas Bangun Datar: " + luas);
    }

    void L_persegi(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
