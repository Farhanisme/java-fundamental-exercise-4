import java.util.Scanner; 
 
public class PembelianBarang { 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 
         
        String[] kodeBarang = {"A", "B", "C"}; 
        String[] namaBarang = {"Barang A", "Barang B", "Barang C"}; 
        double[] hargaBarang = {100.0, 200.0, 300.0}; 
        int[] jumlahBeli = new int[kodeBarang.length];        
        double[] diskonBarang = {0.1, 0.0, 0.0};  
        double totalHarga = 0.0;         
         
        for (int i = 0; i < kodeBarang.length; i++) { 
            System.out.print("Pilih jumlah " + namaBarang[i] + " (0 jika tidak beli): "); 
            jumlahBeli[i] = input.nextInt(); 
             
            totalHarga += jumlahBeli[i] * hargaBarang[i]; 
        } 
         
        double totalDiskon = 0.0; 
        double diskonTerbesar = 0.0; 
        double totalSetelahDiskon = 0.0; 
         
        for (int i = 0; i < kodeBarang.length; i++) { 
            double diskon = diskonBarang[i]; 
            if (jumlahBeli[i] >= 3 && diskon > diskonTerbesar) { 
                diskonTerbesar = diskon; 
            } 
        } 
         
        totalDiskon = totalHarga * diskonTerbesar; 
        totalSetelahDiskon = totalHarga - totalDiskon; 
         
        System.out.println("Total Harga: " + totalHarga); 
        System.out.println("Total Diskon: " + totalDiskon); 
        System.out.println("Total Harga Setelah Diskon: " + totalSetelahDiskon); 
         
        System.out.print("Jumlah Uang Bayar: "); 
        double jumlahBayar = input.nextDouble(); 
         
        double kembalian = jumlahBayar - totalSetelahDiskon; 
        System.out.println("Kembalian: " + kembalian); 
         
        double maxJumlahBayar = 0.0; 
        int indeksBarangTerbesar = -1; 
         
        for (int i = 0; i < kodeBarang.length; i++) { 
            if (jumlahBeli[i] > 0) { 
                double jumlahBayarBarang = jumlahBeli[i] * hargaBarang[i] * (1.0 - diskonTerbesar); 
                if (jumlahBayarBarang > maxJumlahBayar) { 
                    maxJumlahBayar = jumlahBayarBarang; 
                    indeksBarangTerbesar = i; 
                } 
            } 
        } 
         
        if (indeksBarangTerbesar != -1) { 
            System.out.println("Barang dengan Jumlah Bayar Tertinggi: " + 
namaBarang[indeksBarangTerbesar]); 
            System.out.println("Jumlah Bayar: " + maxJumlahBayar); 
        } else { 
            System.out.println("Tidak ada barang yang dibeli."); 
        } 
        input.close();
    } 
} 