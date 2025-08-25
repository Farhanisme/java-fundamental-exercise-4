import java.util.Scanner;

public class function2modif {
    public static int faktorial(int a) {
        int hasil = 1;
        for (int i = 1; i <= a; i++) {
            hasil *= i;
        }
        return hasil;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        // Input jumlah elemen array n
        System.out.print("Masukkan jumlah elemen array n: ");
        int jumlahElemen = input.nextInt();
        String[] n = new String[jumlahElemen];

        // Input nilai untuk setiap elemen array n
        System.out.println("Masukkan elemen-elemen untuk array n:");
        for (int i = 0; i < jumlahElemen; i++) {
            System.out.print("Elemen ke-" + (i + 1) + ": ");
            n[i] = input.next();
        }

        // Input nilai k
        System.out.print("Masukkan nilai k: ");
        int k = input.nextInt();

        int kombinasi = faktorial(jumlahElemen) / (faktorial(k) * faktorial(jumlahElemen - k));
        int permutasi = faktorial(jumlahElemen) / faktorial(jumlahElemen - k);

        System.out.println("\nnilai Faktorial n = " + faktorial(jumlahElemen));
        System.out.println("nilai Faktorial k = " + faktorial(k));
        System.out.println("Kombinasi n dan k = " + kombinasi);
        System.out.println("Permutasi n dan k = " + permutasi);

        // Tampilkan kombinasi
        System.out.println("\nKombinasi:");
        String[] hasilKombinasi = new String[k];
        kombinasi(n, hasilKombinasi, 0, 0, k);

        // Tampilkan permutasi
        System.out.println("\nPermutasi:");
        String[] hasilPermutasi = new String[k];
        boolean[] sudahDipakai = new boolean[n.length];
        permutasi(n, hasilPermutasi, sudahDipakai, 0, k);

        input.close();
    }

    // Fungsi untuk menampilkan kombinasi
    public static void kombinasi(String[] n, String[] hasil, int indeksAwal, int indeksHasil, int k) {
        if (indeksHasil == k) {
            // Jika panjang hasil sudah mencapai k, cetak hasil dalam format "| A | B |"
            spill(hasil);
            return;
        }
        for (int i = indeksAwal; i <= n.length - (k - indeksHasil); i++) {
            hasil[indeksHasil] = n[i];
            kombinasi(n, hasil, i + 1, indeksHasil + 1, k);
        }
    }

    // Fungsi untuk menampilkan permutasi
    public static void permutasi(String[] n, String[] hasil, boolean[] sudahDipakai, int indeksHasil, int k) {
        if (indeksHasil == k) {
            // Jika panjang hasil sudah mencapai k, cetak hasil dalam format "| A | B |"
            spill(hasil);
            return;
        }
        for (int i = 0; i < n.length; i++) {
            if (!sudahDipakai[i]) {
                sudahDipakai[i] = true;
                hasil[indeksHasil] = n[i];
                permutasi(n, hasil, sudahDipakai, indeksHasil + 1, k);
                sudahDipakai[i] = false;
            }
        }
    }

    // Fungsi untuk menampilkan hasil dalam format "| A | B |"
    public static void spill(String[] hasil) {
        for (String elemen : hasil) {
            System.out.print("| " + elemen + " ");
        }
        System.out.println("|");
    }
}
