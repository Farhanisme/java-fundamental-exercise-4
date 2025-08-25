import java.util.Scanner;

public class Kalkulus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Tugas Praktikum 1\n");
        // Input jumlah koefisien dan konstanta
        System.out.print("Masukkan jumlah koefisien: ");
        int jumlahKoef = input.nextInt();
        
        System.out.print("Masukkan jumlah pangkat: ");
        int jumlahPangkat = input.nextInt();
        
        System.out.print("Masukkan jumlah konstanta: ");
        int jumlahKons = input.nextInt();
        
        int jumlahOperator = jumlahKoef + jumlahKons - 1;  // Jumlah operator
        
        // Deklarasi array untuk menyimpan koefisien, pangkat, konstanta, dan operator
        int[] koefisien = new int[jumlahKoef];
        int[] pangkat = new int[jumlahKoef];  
        int[] konstanta = new int[jumlahKons];
        char[] operator = new char[jumlahOperator];
        System.out.println();

        // Input koefisien
        for (int i = 0; i < jumlahKoef; i++) {
            System.out.print("Masukkan Koefisien " + (i + 1) + " : ");
            koefisien[i] = input.nextInt();
        }
        
        // Input pangkat
        for (int i = 0; i < jumlahPangkat; i++) {
            System.out.print("Masukkan Pangkat " + (i + 1) + " : ");
            pangkat[i] = input.nextInt();
        }
        
        // Bikin sisa pangkat jadi 0 kalau jumlah pangkat kurang dari jumlah koefisien
        for (int i = jumlahPangkat; i < jumlahKoef; i++) {
            pangkat[i] = 0;
        }

        // Input konstanta 
        for (int i = 0; i < jumlahKons; i++) {
            System.out.print("Masukkan Konstanta " + (i + 1) + " : ");
            konstanta[i] = input.nextInt();
        }
        
        // Input operator 
        for (int i = 0; i < jumlahOperator; i++) {
            System.out.print("Masukkan Operator " + (i + 1) + " : ");
            operator[i] = input.next().charAt(0);
        }
        System.out.println();

        // Menampilkan persamaan
        System.out.print("Persamaannya adalah: ");
        for (int i = 0; i < jumlahKoef; i++) {
            if (koefisien[i] != 0) {
                if (i > 0) System.out.print(" " + operator[i - 1] + " "); 
                System.out.print((koefisien[i]) + "x^" + pangkat[i]);
            }
        }
        
        // Tambahkan konstanta (kalau ada)
        for (int i = 0; i < jumlahKons; i++) {
            if (konstanta[i] != 0) {
                System.out.print(" " + operator[jumlahKoef - 1 + i] + " " + (konstanta[i]));
            }
        }
        System.out.println();
        
        // Menghitung turunan
        System.out.print("Turunannya adalah: ");
        for (int i = 0; i < jumlahKoef; i++) {
            if (koefisien[i] != 0 && pangkat[i] != 0) {
                int turunanKoef = koefisien[i] * pangkat[i];
                int turunanPangkat = pangkat[i] - 1;
                if (i > 0) System.out.print(" " + operator[i - 1] + " ");
                System.out.print((turunanKoef) + "x");
                if (turunanPangkat != 1) System.out.print("^" + turunanPangkat);
            }
        }
        System.out.println();
        
        // Menghitung integral
        System.out.print("Integralnya adalah: ");
        for (int i = 0; i < jumlahKoef; i++) {
            if (koefisien[i] != 0) {
                int integralPangkat = pangkat[i] + 1;
                if (koefisien[i] % integralPangkat == 0) {  // Jika habis dibagi
                    int integralKoef = koefisien[i] / integralPangkat;
                    if (i > 0) System.out.print(" " + operator[i - 1] + " ");
                    System.out.print(integralKoef + "x^" + integralPangkat);
                } else {  // Jika tidak habis dibagi, tampilkan dalam bentuk pecahan
                    if (i > 0) System.out.print(" " + operator[i - 1] + " ");
                    System.out.print(koefisien[i] + "/" + integralPangkat + "x^" + integralPangkat);
                }
            }
        }
        
        // Tambahkan konstanta ke integral (jika ada)
        for (int i = 0; i < jumlahKons; i++) {
            if (konstanta[i] != 0) {
                System.out.print(" " + operator[jumlahKoef - 1 + i] + " " + konstanta[i] + "x");
            }
        }
        System.out.println(" + C");
        
        input.close();
    }
}
