import java.util.Scanner; 

public class HitungGajiPegawaiArrayModifikasi { 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 

        // Daftar departemen, jabatan, gaji pokok, tunjangan keluarga, pajak, dan tunjangan anak 
        String[] departemen = {"IT", "Keuangan", "Produksi"}; 
        String[] jabatan = {"Staff", "Supervisor", "Manager"}; 
        double[] gajiPokok = {3000, 5000, 8000}; 
        double[] tunjanganKeluarga = {1000, 1500, 2000}; 
        double pajak = 0.02; 
        double[] tunjanganAnak = {500, 600, 700}; 

        // Pakai jumlah elemen sementara
        int maxAwal = 1;
        String[] namaKaryawan = new String[maxAwal]; 
        int[] pilihanDepartemen = new int[maxAwal]; 
        int[] pilihanJabatan = new int[maxAwal]; 
        int[] pilihanStatus = new int[maxAwal]; 
        int[] jumlahAnak = new int[maxAwal]; 
        double[] totalGaji = new double[maxAwal]; 

        int karyawanKe = 0; // Menghitung karyawan ke berapa 

        // Variabel untuk menyimpan karyawan dengan gaji tertinggi dan terendah
        int indexGajiTertinggi = 0;
        int indexGajiTerendah = 0;

        do { 
            // Upgrade ukuran si array kalau sudah penuh
            if (karyawanKe >= namaKaryawan.length) { 
                int maxBaru = namaKaryawan.length * 2;  // jadi 2 kali lipat

                // buat array baru dari jumlah elemen yg sudah dikali 2
                String[] NamaKaryawanBaru = new String[maxBaru];
                int[] PilihanDepartemenBaru = new int[maxBaru];
                int[] PilihanJabatanBaru = new int[maxBaru];
                int[] PilihanStatusBaru = new int[maxBaru];
                int[] JumlahAnakBaru = new int[maxBaru];
                double[] TotalGajiBaru = new double[maxBaru];

                // Pindahin data lama ke array baru
                for (int i = 0; i < namaKaryawan.length; i++) {
                    NamaKaryawanBaru[i] = namaKaryawan[i];
                    PilihanDepartemenBaru[i] = pilihanDepartemen[i];
                    PilihanJabatanBaru[i] = pilihanJabatan[i];
                    PilihanStatusBaru[i] = pilihanStatus[i];
                    JumlahAnakBaru[i] = jumlahAnak[i];
                    TotalGajiBaru[i] = totalGaji[i];
                }

                // Ganti array lama dengan yang baru
                namaKaryawan = NamaKaryawanBaru;
                pilihanDepartemen = PilihanDepartemenBaru;
                pilihanJabatan = PilihanJabatanBaru;
                pilihanStatus = PilihanStatusBaru;
                jumlahAnak = JumlahAnakBaru;
                totalGaji = TotalGajiBaru;
            } 

            System.out.println("Data Karyawan ke-" + (karyawanKe + 1)); 
             
            // Input departemen 
            System.out.println("Pilih Departemen:"); 
            for (int i = 0; i < departemen.length; i++) { 
                System.out.println((i + 1) + ". " + departemen[i]); 
            } 
            System.out.print("Pilihan Departemen: "); 
            pilihanDepartemen[karyawanKe] = input.nextInt() - 1; // Indeks dimulai dari 0 

            // Input jabatan 
            System.out.println("Pilih Jabatan:"); 
            for (int i = 0; i < jabatan.length; i++) { 
                System.out.println((i + 1) + ". " + jabatan[i]); 
            } 
            System.out.print("Pilihan Jabatan: "); 
            pilihanJabatan[karyawanKe] = input.nextInt() - 1; // Indeks dimulai dari 0 

            // Input status pernikahan 
            System.out.println("Pilih Status Pernikahan:"); 
            System.out.println("1. Belum Menikah"); 
            System.out.println("2. Menikah"); 
            System.out.println("3. Duda/Janda"); 
            System.out.print("Pilihan Status Pernikahan: "); 
            pilihanStatus[karyawanKe] = input.nextInt(); 

            // Inisialisasi tunjangan keluarga dan anak 
            double tunjanganKeluargaPegawai = 0.0; 
            double tunjanganAnakPegawai = 0.0; 

            if (pilihanStatus[karyawanKe] == 2) { // Menikah 
                System.out.print("Jumlah Anak: "); 
                jumlahAnak[karyawanKe] = input.nextInt(); 
                if (jumlahAnak[karyawanKe] > 0 && jumlahAnak[karyawanKe] <= 3) { 
                    tunjanganKeluargaPegawai = tunjanganKeluarga[pilihanJabatan[karyawanKe]]; 
                    tunjanganAnakPegawai = tunjanganAnak[pilihanJabatan[karyawanKe]] * jumlahAnak[karyawanKe]; 
                } 
            } else if (pilihanStatus[karyawanKe] == 3) { // Duda/Janda 
                tunjanganKeluargaPegawai = tunjanganKeluarga[pilihanJabatan[karyawanKe]]; 
            } 

            // Hitung gaji 
            totalGaji[karyawanKe] = gajiPokok[pilihanJabatan[karyawanKe]] + tunjanganKeluargaPegawai + tunjanganAnakPegawai; 
            double pajakPegawai = totalGaji[karyawanKe] * pajak; 
            totalGaji[karyawanKe] -= pajakPegawai; 

            System.out.println("Total Gaji Karyawan ke-" + (karyawanKe + 1) + ": " + totalGaji[karyawanKe]); 

            // Cek apakah gaji saat ini adalah yang tertinggi atau terendah
            if (totalGaji[karyawanKe] > totalGaji[indexGajiTertinggi]) {
                indexGajiTertinggi = karyawanKe;
            }
            if (totalGaji[karyawanKe] < totalGaji[indexGajiTerendah]) {
                indexGajiTerendah = karyawanKe;
            }

            // Input nama karyawan 
            System.out.print("Nama Karyawan: "); 
            namaKaryawan[karyawanKe] = input.next(); 
             
            // Input data karyawan baru atau selesai 
            System.out.print("Input data karyawan baru? (y/n): "); 
            String lanjut = input.next(); 

            if (lanjut.equals("n") || lanjut.equals("N")) { 
                break; 
            } 

            karyawanKe++; 
        } while (true); 

        // Menampilkan data semua karyawan 
        System.out.println("Data Semua Karyawan:"); 
        for (int i = 0; i < karyawanKe; i++) { 
            System.out.println("Karyawan ke-" + (i + 1)); 
            System.out.println("Nama: " + namaKaryawan[i]); 
            System.out.println("Departemen: " + departemen[pilihanDepartemen[i]]); 
            System.out.println("Jabatan: " + jabatan[pilihanJabatan[i]]); 
            System.out.println("Jumlah Anak: " + jumlahAnak[i]); 
            System.out.println("Total Gaji: " + totalGaji[i]); 
            System.out.println(); 
        }

        // Menampilkan karyawan dengan gaji tertinggi dan terendah
        System.out.println("Karyawan dengan Gaji Tertinggi: Karyawan ke-" + (indexGajiTertinggi + 1) + " dengan total gaji: " + totalGaji[indexGajiTertinggi]);
        System.out.println("Karyawan dengan Gaji Terendah: Karyawan ke-" + (indexGajiTerendah + 1) + " dengan total gaji: " + totalGaji[indexGajiTerendah]);

        input.close();        
    } 
}
