import java.util.Scanner; 
public class PembelianBarangModifikasi { 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 
        
        String[] kodeBarang = {"A", "B", "C"}; 
        String[] namaBarang = {"Barang A", "Barang B", "Barang C"}; 
        double[] hargaBarang = {100.0, 200.0, 300.0}; 
        int[] jumlahBeli = new int[kodeBarang.length];        
        double[] diskonBarang = {0.1, 0.1, 0.1};  

        System.out.println("Pilihan Barang:"); 
        for (int i = 0; i < kodeBarang.length; i++) { 
            System.out.println(kodeBarang[i] + ": " + namaBarang[i] + " - Harga: " + hargaBarang[i]); 
        }

        double totalHarga = 0.0;  
        boolean selesai = false;
        while (!selesai) { 
            System.out.print("Masukkan kode barang yang ingin dibeli (A, B, C) atau tekan 'x' untuk selesai: "); 
            String kodeInput = input.next();

            if (kodeInput.equalsIgnoreCase("x")) { 
                selesai = true;
                break;
            }

            boolean barangValid = false; 
            for (int j = 0; j < kodeBarang.length; j++) { 
                if (kodeInput.equalsIgnoreCase(kodeBarang[j])) { 
                    barangValid = true; 
                    System.out.print("Masukkan jumlah barang " + namaBarang[j] + ": "); 
                    jumlahBeli[j] = input.nextInt(); 
                    totalHarga += jumlahBeli[j] * hargaBarang[j]; 
                }
            }

            if (!barangValid) { 
                System.out.println("Kode barang tidak valid, silakan masukkan kode yang benar."); 
            }
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

        double minJumlahBayar = totalHarga; 
        int indeksBarangTermurah = -1; 
        for (int i = 0; i < kodeBarang.length; i++) { 
            if (jumlahBeli[i] > 0) { 
                double jumlahBayarBarang = jumlahBeli[i] * hargaBarang[i] * (1.0 - diskonBarang[i]); 
                if (jumlahBayarBarang < minJumlahBayar) { 
                    minJumlahBayar = jumlahBayarBarang; 
                    indeksBarangTermurah = i; 
                } 
            } 
        } 

        if (indeksBarangTermurah != -1) { 
            System.out.println("Barang dengan Jumlah Bayar Terendah: " + 
                namaBarang[indeksBarangTermurah]); 
            System.out.println("Jumlah Bayar: " + minJumlahBayar); 
        } else { 
            System.out.println("Tidak ada barang yang dibeli."); 
        } 
        input.close();
    } 
}
