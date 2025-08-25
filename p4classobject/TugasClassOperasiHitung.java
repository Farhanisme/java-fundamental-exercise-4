package p4classobject;

public class TugasClassOperasiHitung {
    int hasil;
    String deskripsi;

    public void faktorial(int n) {
        hasil = Faktorial(n);
        deskripsi = "Faktorial dari " + n + " (" + n + "!): " + hasil;
    }

    public void kombinasi(int n, int r) {
        hasil = Faktorial(n) / (Faktorial(r) * Faktorial(n - r));
        deskripsi = "Kombinasi dari " + n + "! dan " + r + "! adalah " + hasil;
        
    }

    // Metode untuk menghitung permutasi dan menyimpan deskripsi
    public void permutasi(int n, int r) {
        hasil = Faktorial(n) / Faktorial(n - r);
        deskripsi = "Permutasi dari " + n + "! dan " + r + "! adalah " + hasil;
    }

    public int Faktorial(int f) {
        int hasil = 1;
        for (int i = 1; i <= f; i++) {
            hasil *= i;
        }
        return hasil;
    }
    

    public void tampil() {
        System.out.println("\n" + deskripsi);
    }
}
