import java.util.Scanner;

public class Kalkulus2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Tugas Praktikum 2 : Array 2D\n");
        
        // Masukin berapa banyak koefisien dan konstanta yang bakal dipake
        System.out.print("Masukkan jumlah koefisien: ");
        int jumlahKoef = input.nextInt();
        
        System.out.print("Masukkan jumlah pangkat: ");
        // int jumlahPangkat = input.nextInt(); // pangkat cuma buat validasi input aja
        
        System.out.print("Masukkan jumlah konstanta: ");
        int jumlahKons = input.nextInt();
        
        int jumlahOperator = jumlahKoef + jumlahKons - 1;  // Total operator yang dibutuhin
        
        // Bikin array buat nyimpen koefisien dan pangkat
        int[][] persamaan = new int[jumlahKoef][2];
        int[] konstanta = new int[jumlahKons];
        char[] operator = new char[jumlahOperator];
        
        System.out.println();
        
        // Input koefisien dan pangkat ke dalam array
        for (int i = 0; i < jumlahKoef; i++) {
            System.out.print("Masukkan Koefisien " + (i + 1) + " : ");
            persamaan[i][0] = input.nextInt(); // masukin koefisien
            
            System.out.print("Masukkan Pangkat " + (i + 1) + " : ");
            persamaan[i][1] = input.nextInt(); // masukin pangkat
        }
        
        // Masukin nilai konstan
        for (int i = 0; i < jumlahKons; i++) {
            System.out.print("Masukkan Konstanta " + (i + 1) + " : ");
            konstanta[i] = input.nextInt();
        }
        
        // Masukin operator (+ atau -)
        for (int i = 0; i < jumlahOperator; i++) {
            System.out.print("Masukkan Operator " + (i + 1) + " : ");
            operator[i] = input.next().charAt(0);
        }
        
        System.out.print("\nMasukkan nilai x: ");
        int nilaiX = input.nextInt();
        System.out.println();

        // Tampilkan persamaan, hitung hasil substitusi, dan jelasin langkah-langkahnya
        System.out.print("Persamaannya adalah: ");
        int hasilPersamaan = 0;
        for (int i = 0; i < jumlahKoef; i++) {
            int koef = persamaan[i][0];
            int pangkat = persamaan[i][1];
            int nilaiSubstitusi = koef * (int) Math.pow(nilaiX, pangkat);
            
            if (i > 0) System.out.print(" " + operator[i - 1] + " ");
            System.out.print(koef + "x^" + pangkat);
            
            // Hitung hasil akhir persamaan sesuai operator
            if (i == 0) {
                hasilPersamaan += nilaiSubstitusi;
            } else if (operator[i - 1] == '+') {
                hasilPersamaan += nilaiSubstitusi;
            } else if (operator[i - 1] == '-') {
                hasilPersamaan -= nilaiSubstitusi;
            }
        }
        
        // Tambahin konstanta ke persamaan (buat tampilan aja)
        for (int i = 0; i < jumlahKons; i++) {
            if (i > 0 || jumlahKoef > 0) System.out.print(" " + operator[jumlahKoef - 1 + i] + " ");
            System.out.print(konstanta[i]);
        }
        
        // Proses substitusi nilai x
        System.out.print("\nSubstitusi x = ");
        for (int i = 0; i < jumlahKoef; i++) {
            int koef = persamaan[i][0];
            int pangkat = persamaan[i][1];
            
            if (i > 0) System.out.print(" " + operator[i - 1] + " ");
            System.out.print(koef + "(" + nilaiX + ")^" + pangkat);
        }
        
        // Tambahin nilai konstanta ke hasil persamaan
        for (int i = 0; i < jumlahKons; i++) {
            if (operator[jumlahKoef - 1 + i] == '+') {
                hasilPersamaan += konstanta[i];
            } else {
                hasilPersamaan -= konstanta[i];
            }
        }
        
        // Tampilkan konstanta pas substitusi
        for (int i = 0; i < jumlahKons; i++) {
            System.out.print(" " + operator[jumlahKoef - 1 + i] + " " + konstanta[i]);
        }
        
        System.out.println("\nf(" + nilaiX + ") = " + hasilPersamaan);

        // Ngitung turunan dan tampilkan juga proses substitusinya
        System.out.print("\nTurunannya adalah: ");
        int hasilTurunan = 0;
        for (int i = 0; i < jumlahKoef; i++) {
            int koef = persamaan[i][0];
            int pangkat = persamaan[i][1];
            
            if (pangkat != 0) {
                int turunanKoef = koef * pangkat;
                int turunanPangkat = pangkat - 1;
                int nilaiSubstitusi = turunanKoef * (int) Math.pow(nilaiX, turunanPangkat);
                
                if (i > 0) System.out.print(" " + operator[i - 1] + " ");
                System.out.print(turunanKoef + "x");
                if (turunanPangkat != 1 && turunanPangkat != 0) {
                    System.out.print("^" + turunanPangkat);
                }
                
                // Operasikan turunan sesuai operatornya
                if (i == 0) {
                    hasilTurunan += nilaiSubstitusi;
                } else if (operator[i - 1] == '+') {
                    hasilTurunan += nilaiSubstitusi;
                } else if (operator[i - 1] == '-') {
                    hasilTurunan -= nilaiSubstitusi;
                }
            }
        }

        // Tampilkan substitusi turunan
        System.out.print("\nSubstitusi x : ");
        for (int i = 0; i < jumlahKoef; i++) {
            int koef = persamaan[i][0];
            int pangkat = persamaan[i][1];

            if (pangkat != 0) {
                int turunanKoef = koef * pangkat;
                int turunanPangkat = pangkat - 1;

                if (i > 0) System.out.print(" " + operator[i - 1] + " ");
                System.out.print(turunanKoef + "(" + nilaiX + ")");
                if (turunanPangkat != 0) {
                    System.out.print("^" + turunanPangkat);
                }
            }
        }
        System.out.println("\nf'(" + nilaiX + ") = " + hasilTurunan);
        
        // Buat nyimpen hasil pembilang dan penyebut buat tiap suku integral
        int[][] sukuIntegral = new int[jumlahKoef][2]; // Array buat nyimpen pembilang dan penyebut

        // Tampilkan bentuk integral awal
        System.out.print("\nIntegralnya adalah: ");
        for (int i = 0; i < jumlahKoef; i++) {
            int koef = persamaan[i][0];
            int pangkat = persamaan[i][1];
            int integralPangkat = pangkat + 1;

            sukuIntegral[i][0] = koef; // Nyimpen pembilang
            sukuIntegral[i][1] = integralPangkat; // Nyimpen penyebut

            // Tampilkan bentuk integral
            if (i > 0) System.out.print(" " + operator[i - 1] + " ");
            System.out.print(koef + "x^" + integralPangkat + "/" + integralPangkat);
        }
        
        // Tambahin konstanta ke integral
        for (int i = 0; i < jumlahKons; i++) {
            System.out.print(" " + operator[jumlahKoef - 1 + i] + " " + konstanta[i] + "x");
        }
        System.out.print(" + C");
        
        // Simplifikasi integral
        int pembilangTotal = sukuIntegral[0][0];
        int penyebutTotal = sukuIntegral[0][1];

        for (int i = 1; i < jumlahKoef; i++) {
            int PembilangSekarang = sukuIntegral[i][0];
            int PenyebutSekarang = sukuIntegral[i][1];

            if (operator[i - 1] == '+') {
                pembilangTotal = (pembilangTotal * PenyebutSekarang) + (PembilangSekarang * penyebutTotal);
            } else if (operator[i - 1] == '-') {
                pembilangTotal = (pembilangTotal * PenyebutSekarang) - (PembilangSekarang * penyebutTotal);
            }
            penyebutTotal *= PenyebutSekarang;
        }

        // Hitung total konstanta
        // int totalKonstanta = 0;
        // for (int i = 0; i < jumlahKons; i++) {
        //     totalKonstanta += konstanta[i];
        // }

        // Tampilkan hasil integral yang disederhanakan
        // System.out.print("\nHasil Integral: ");
        // if (pembilangTotal == 0) {
        //     System.out.println(totalKonstanta + "x + C");
        // } else if (penyebutTotal == 1) {
        //     System.out.println(pembilangTotal + "x + " + totalKonstanta + " + C");
        // } else {
        //     System.out.println(pembilangTotal + "/" + penyebutTotal + "x + " + totalKonstanta + " + C");
        // }
        
        // Substitusi hasil integral ke nilai x
        System.out.print("\nSubstitusi x : f(" + nilaiX + ") = ");
        // int hasilPembilang = pembilangTotal * nilaiX;
        // int hasilSubstitusi = hasilPembilang / penyebutTotal + totalKonstanta * nilaiX;
        
        // if (pembilangTotal == 0) {
        //     System.out.println(totalKonstanta + "(" + nilaiX + ") + C");
        // } else if (penyebutTotal == 1) {
        //     System.out.println(pembilangTotal + "(" + nilaiX + ") + " + totalKonstanta + " + C");
        // } else {
        //     System.out.println(pembilangTotal + "/" + penyebutTotal + "(" + nilaiX + ") + " + totalKonstanta + " + C");
        // }
        for (int i = 0; i < jumlahKoef; i++) {
            int koef = persamaan[i][0];
            int pangkat = persamaan[i][1];
            int integralPangkat = pangkat + 1;

            sukuIntegral[i][0] = koef; // Nyimpen pembilang
            sukuIntegral[i][1] = integralPangkat; // Nyimpen penyebut

            // Tampilkan bentuk integral
            if (i > 0) System.out.print(" " + operator[i - 1] + " ");
            System.out.print(koef + "(" + nilaiX + ")^" + integralPangkat + "/" + integralPangkat);
        }
        
        // Tambahin konstanta ke integral
        for (int i = 0; i < jumlahKons; i++) {
            System.out.print(" " + operator[jumlahKoef - 1 + i] + " " + konstanta[i] + "(" + nilaiX + ")");
        }
        System.out.print(" + C");


           // Hitung hasil integral
           double hasilIntegral = 0;
           for (int i = 0; i < jumlahKoef; i++) {
               int koef = persamaan[i][0];
               int pangkat = persamaan[i][1];
               int integralPangkat = pangkat + 1;
   
               hasilIntegral += (koef * Math.pow(nilaiX, integralPangkat)) / (double) integralPangkat;
           }
   
           // Tambahkan konstanta ke hasil integral
           for (int i = 0; i < jumlahKons; i++) {
               hasilIntegral += konstanta[i] * nilaiX;
           }
   
           System.out.println("\nf(" + nilaiX + ") = " + hasilIntegral );
   
        input.close();
    }
}
