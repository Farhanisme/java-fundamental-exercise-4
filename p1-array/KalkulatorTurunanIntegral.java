import java.util.Scanner;

public class KalkulatorTurunanIntegral {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Jumlah Koefisien: ");
        int jumlahKoefisien = input.nextInt();
        
        System.out.print("Masukkan Jumlah Pangkat: ");
        int jumlahPangkat = input.nextInt();
        System.out.println("Jumlah Pangkat: " + jumlahPangkat);
        System.out.print("Masukkan Jumlah Konstanta: ");
        int jumlahKonstanta = input.nextInt();

        // Jumlah operator otomatis sesuai dengan jumlah koefisien dan konstanta
        int jumlahOperator = jumlahKoefisien + jumlahKonstanta - 1;

        // Inisialisasi array untuk menyimpan data
        int[] koefisien = new int[jumlahKoefisien];
        int[] pangkat = new int[jumlahKoefisien];  // Sesuaikan jumlah pangkat dengan jumlah koefisien
        int[] konstanta = new int[jumlahKonstanta];
        String[] operator = new String[jumlahOperator];

        System.out.println();
        // Input nilai koefisien, pangkat, konstanta, dan operator
        for (int i = 0; i < jumlahKoefisien; i++) {
            System.out.print("Masukkan Koefisien " + (i + 1) + ": ");
            koefisien[i] = input.nextInt();
        }

        for (int i = 0; i < jumlahKoefisien; i++) {  // Sesuaikan input pangkat dengan jumlah koefisien
            System.out.print("Masukkan Pangkat " + (i + 1) + ": ");
            pangkat[i] = input.nextInt();
        }

        for (int i = 0; i < jumlahKonstanta; i++) {
            System.out.print("Masukkan Konstanta " + (i + 1) + ": ");
            konstanta[i] = input.nextInt();
        }

        for (int i = 0; i < jumlahOperator; i++) {
            System.out.print("Masukkan Operator " + (i + 1) + ": ");
            operator[i] = input.next();
        }

        // Menampilkan persamaan
        System.out.print("\nPersamaannya adalah: ");
        for (int i = 0; i < jumlahKoefisien; i++) {
            System.out.print(koefisien[i] + "x^" + pangkat[i]);
            if (i < jumlahOperator) {
                System.out.print(" " + operator[i] + " ");
            }
        }
        for (int i = 0; i < jumlahKonstanta; i++) {
            System.out.print(konstanta[i]);
            if (i < jumlahKonstanta - 1) {
                System.out.print(" " + operator[i + jumlahKoefisien] + " ");  // Memperbaiki index operator konstanta
            }
        }
        System.out.println();

        // Menghitung dan menampilkan integral
        System.out.print("Integralnya adalah: ");
        for (int i = 0; i < jumlahKoefisien; i++) {
            double integralKoefisien = (double) koefisien[i] / (pangkat[i] + 1);
            int integralPangkat = pangkat[i] + 1;
            
            // Menampilkan integralKoefisien
            if (integralKoefisien == (int) integralKoefisien) {
                // Jika integralKoefisien adalah bilangan bulat
                System.out.print((int) integralKoefisien + "x^" + integralPangkat);
            } else {
                // Jika integralKoefisien adalah desimal, tampilkan dua angka di belakang koma
                System.out.printf("%.2fx^%d", integralKoefisien, integralPangkat);
            }
            
            if (i < jumlahKoefisien - 1) {
                System.out.print(" " + operator[i] + " ");
            }
        }
        
        // Menampilkan konstanta pada hasil integral
        for (int i = 0; i < jumlahKonstanta; i++) {
            System.out.print(konstanta[i] + "x");
            if (i < jumlahKonstanta - 1) {
                System.out.print(" " + operator[jumlahKoefisien + i] + " ");
            }
        }
        
        System.out.println(" + C");
        input.close();
    }
}
