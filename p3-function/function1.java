import java.util.Scanner;

public class function1 {
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        
        String[] kodeBarang = {"A", "B", "C"};
        String[] namaBarang = {"Barang A", "Barang B", "Barang C"};
        double[] hargaBarang = {100.0, 200.0, 300.0};
        int[] jumlahBeli = new int[kodeBarang.length];
        double[] diskonBarang = {0.1, 0.0, 0.0};
        
        totalHargaBelanja(input, kodeBarang, namaBarang, hargaBarang, jumlahBeli); 
        double totalHarga = hitungTotalHarga(hargaBarang, jumlahBeli);
        double diskonTerbesar = hitungDiskonTerbesar(jumlahBeli, diskonBarang); 
        double totalDiskon = hitungTotalDiskon(totalHarga, diskonTerbesar); 
        double totalSetelahDiskon = totalHarga - totalDiskon;
        
        tampilkanTotal(totalHarga, totalDiskon, totalSetelahDiskon);
        
        double jumlahBayar = inputJumlahBayar(input); 
        double kembalian = hitungKembalian(jumlahBayar, totalSetelahDiskon); 
        tampilkanKembalian(kembalian);
        
        tampilkanBarangTerbesar(jumlahBeli, hargaBarang, diskonTerbesar, namaBarang);
        
        input.close();
    }
    
    public static void totalHargaBelanja(Scanner input, String[] kodeBarang, String[] namaBarang, double[] hargaBarang, int[] jumlahBeli) { 
        for (int i = 0; i < kodeBarang.length; i++) { 
            System.out.print("Pilih jumlah " + namaBarang[i] + " (0 jika tidak beli): ");
            jumlahBeli[i] = input.nextInt();
        }
    }

    public static double hitungTotalHarga(double[] hargaBarang, int[] jumlahBeli) {
        double totalHarga = 0.0;
        for (int i = 0; i < hargaBarang.length; i++) {
            totalHarga += jumlahBeli[i] * hargaBarang[i];
        }
        return totalHarga;
    }
        
    public static double hitungDiskonTerbesar(int[] jumlahBeli, double[] diskonBarang) { 
        double diskonTerbesar = 0.0;
        for (int i = 0; i < jumlahBeli.length; i++) {
            if (jumlahBeli[i] >= 3 && diskonBarang[i] > diskonTerbesar) {
                diskonTerbesar = diskonBarang[i];
            }
        }
        return diskonTerbesar;
    }

    public static double hitungTotalDiskon(double totalHarga, double diskonTerbesar) {
        return totalHarga * diskonTerbesar;
    }
    
    public static void tampilkanTotal(double totalHarga, double totalDiskon, double totalSetelahDiskon) {
        System.out.println("Total Harga: " + totalHarga);
        System.out.println("Total Diskon: " + totalDiskon); 
        System.out.println("Total Harga Setelah Diskon: " + totalSetelahDiskon);
    }
    
    public static double inputJumlahBayar(Scanner input) {
        System.out.print("Jumlah Uang Bayar: "); 
        return input.nextDouble();
    }
        
    public static double hitungKembalian(double jumlahBayar, double totalSetelahDiskon) {
        return jumlahBayar - totalSetelahDiskon;
    }
    
    public static void tampilkanKembalian(double kembalian) {
        System.out.println("Kembalian: " + kembalian);
    }
        
    public static void tampilkanBarangTerbesar(int[] jumlahBeli, double[] hargaBarang, double diskonTerbesar, String[] namaBarang) {
        double maxJumlahBayar = 0.0;
        int indeksBarangTerbesar = -1;
        
        for (int i = 0; i < jumlahBeli.length; i++) {
            if (jumlahBeli[i] > 0) {
                double jumlahBayarBarang = jumlahBeli[i] * hargaBarang[i] * (1.0 - diskonTerbesar);
                if (jumlahBayarBarang > maxJumlahBayar) {
                    maxJumlahBayar = jumlahBayarBarang; 
                    indeksBarangTerbesar = i;
                }
            }
        }
        
        if (indeksBarangTerbesar != -1) {
            System.out.println("Barang dengan Jumlah Bayar Tertinggi: " + namaBarang[indeksBarangTerbesar]);
            System.out.println("Jumlah Bayar: " + maxJumlahBayar);
        } else {
            System.out.println("Tidak ada barang yang dibeli.");
        }
    }
}