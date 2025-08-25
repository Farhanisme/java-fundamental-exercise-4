import java.util.Scanner; 
 
public class NilaiMahasiswaa { 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 
         
        System.out.print("Jumlah mahasiswa: "); 
        int jumlahMahasiswa = input.nextInt(); 
         
        String[] kodeMataKuliah = new String[jumlahMahasiswa]; 
        String[] namaMataKuliah = new String[jumlahMahasiswa]; 
        double[] nilaiAbsensi = new double[jumlahMahasiswa]; 
        double[] nilaiTugas = new double[jumlahMahasiswa]; 
        double[] nilaiMid = new double[jumlahMahasiswa]; 
        double[] nilaiFinal = new double[jumlahMahasiswa]; 
        double[] nilaiAkhir = new double[jumlahMahasiswa]; 
        String[] nilaiHuruf = new String[jumlahMahasiswa]; 
         
        double maxNilaiAkhir = -1.0; 
         
        for (int i = 0; i < jumlahMahasiswa; i++) { 
            System.out.println("Mahasiswa ke-" + (i + 1)); 
             
            System.out.print("Kode Mata Kuliah: "); 
            kodeMataKuliah[i] = input.next(); 
             
            System.out.print("Nama Mata Kuliah: "); 
            namaMataKuliah[i] = input.next(); 
             
            System.out.print("Nilai Absensi: "); 
            nilaiAbsensi[i] = input.nextDouble(); 
             
            System.out.print("Nilai Tugas: "); 
            nilaiTugas[i] = input.nextDouble(); 
             
            System.out.print("Nilai Mid: "); 
            nilaiMid[i] = input.nextDouble(); 
             
            System.out.print("Nilai Final: "); 
            nilaiFinal[i] = input.nextDouble(); 
             
            nilaiAkhir[i] = (nilaiAbsensi[i] * 0.1) + (nilaiTugas[i] * 0.2) + (nilaiMid[i] * 0.3) + (nilaiFinal[i] * 0.4); 
             
            if (nilaiAkhir[i] >= 85) { 
                nilaiHuruf[i] = "A"; 
            } else if (nilaiAkhir[i] >= 70) { 
                nilaiHuruf[i] = "B"; 
            } else if (nilaiAkhir[i] >= 55) { 
                nilaiHuruf[i] = "C"; 
            } else if (nilaiAkhir[i] >= 40) { 
                nilaiHuruf[i] = "D"; 
            } else { 
                nilaiHuruf[i] = "E"; 
            } 
             
            if (nilaiAkhir[i] > maxNilaiAkhir) { 
                maxNilaiAkhir = nilaiAkhir[i]; 
            } 
        } 
         
        System.out.println("Daftar Nilai Mahasiswa:"); 
        System.out.println("-------------------------------------------------"); 
        System.out.println("Kode MK | Nama MK | Nilai Akhir | Nilai Huruf"); 
        System.out.println("-------------------------------------------------"); 
         
        for (int i = 0; i < jumlahMahasiswa; i++) { 
            System.out.println(kodeMataKuliah[i] + " | " + namaMataKuliah[i] + " | " + nilaiAkhir[i] + " | " + nilaiHuruf[i]); 
        
         
        System.out.println("-------------------------------------------------"); 
        System.out.println("Nilai Tertinggi: " + maxNilaiAkhir); 

        input.close();

        
    } 
} 

}