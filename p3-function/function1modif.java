import java.util.Scanner;

public class function1modif {
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
       
        String[] kodeBarang = {"A", "B", "C"};
        String[] namaBarang = {"Barang A", "Barang B", "Barang C"};
        double[] hargaBarang = {100.0, 200.0, 300.0};
        int[] jumlahBeli = new int[kodeBarang.length];
        double[] diskonBarang = {0.1, 0.0, 0.0};
        
        // Menampilkan pilihan barang
        tampilkanPilihanBarang(kodeBarang, namaBarang, hargaBarang);
        
        // Meminta input kode barang dan jumlah
        inputKodeBarang(input, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

        double totalHarga = hitungTotalHarga(hargaBarang, jumlahBeli);
        double diskonTerbesar = hitungDiskonTerbesar(jumlahBeli, diskonBarang); 
        double totalDiskon = hitungTotalDiskon(totalHarga, diskonTerbesar); 
        double totalSetelahDiskon = totalHarga - totalDiskon;
        
        tampilkanTotal(totalHarga, totalDiskon, totalSetelahDiskon);
        
        double jumlahBayar = inputJumlahBayar(input); 
        double kembalian = hitungKembalian(jumlahBayar, totalSetelahDiskon); 
        tampilkanKembalian(kembalian);
        
        // tampilkanBarangTerbesar(jumlahBeli, hargaBarang, diskonTerbesar, namaBarang);
        
        // Menampilkan total bayar paling tinggi dan rendah
        tampilkanTotalBayarTertinggiTerendah(jumlahBeli, hargaBarang, diskonTerbesar, namaBarang);

        input.close();
    }
    
    // Fungsi baru untuk menampilkan pilihan barang
    public static void tampilkanPilihanBarang(String[] kodeBarang, String[] namaBarang, double[] hargaBarang) {
        System.out.println("Pilihan Barang:");
        for (int i = 0; i < kodeBarang.length; i++) {
            System.out.println(kodeBarang[i] + ": " + namaBarang[i] + " - Harga: " + hargaBarang[i]);
        }
    }

    // Modifikasi fungsi untuk input kode barang dan jumlah
    public static void inputKodeBarang(Scanner input, String[] kodeBarang, String[] namaBarang, double[] hargaBarang, int[] jumlahBeli) {
        while (true) {
            System.out.print("Masukkan kode barang yang ingin dibeli (A, B, C) atau tekan 'x' untuk selesai: ");
            String kode = input.next();
            
            if (kode.equalsIgnoreCase("x")) {
                break;
            }
            
            int indeks = -1;
            for (int i = 0; i < kodeBarang.length; i++) {
                if (kode.equalsIgnoreCase(kodeBarang[i])) {
                    indeks = i;
                    break;
                }
            }
            
            if (indeks != -1) {
                System.out.print("Masukkan jumlah " + namaBarang[indeks] + ": ");
                jumlahBeli[indeks] = input.nextInt();
            } else {
                System.out.println("Kode barang tidak valid. Silakan masukkan kembali.");
            }
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
    
    // Fungsi baru untuk menampilkan total bayar paling tinggi dan rendah
    public static void tampilkanTotalBayarTertinggiTerendah(int[] jumlahBeli, double[] hargaBarang, double diskonTerbesar, String[] namaBarang) {
        double maxJumlahBayar = 0.0;
        double minJumlahBayar = hitungTotalHarga(hargaBarang, jumlahBeli);
        int indeksBarangTertinggi = -1;
        int indeksBarangTerendah = -1;

        for (int i = 0; i < jumlahBeli.length; i++) {
            if (jumlahBeli[i] > 0) {
                double jumlahBayarBarang = jumlahBeli[i] * hargaBarang[i] * (1.0 - diskonTerbesar);
                
                if (jumlahBayarBarang > maxJumlahBayar) {
                    maxJumlahBayar = jumlahBayarBarang;
                    indeksBarangTertinggi = i;
                }
                
                if (jumlahBayarBarang < minJumlahBayar) {
                    minJumlahBayar = jumlahBayarBarang;
                    indeksBarangTerendah = i;
                }
            }
        }

        if (indeksBarangTertinggi != -1) {
            System.out.println("Barang dengan Total Bayar Tertinggi: " + namaBarang[indeksBarangTertinggi]);
            System.out.println("Jumlah Bayar Tertinggi: " + maxJumlahBayar);
        }

        if (indeksBarangTerendah != -1) {
            System.out.println("Barang dengan Total Bayar Terendah: " + namaBarang[indeksBarangTerendah]);
            System.out.println("Jumlah Bayar Terendah: " + minJumlahBayar);
        }
    }
}



