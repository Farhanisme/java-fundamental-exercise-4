package p4classobject;

import java.util.Random;
import java.util.Scanner;

class Saluran {
    String namaSaluranTV;
    double frekuensiSaluranTV;
    int kekuatanSinyalSaluranTV;

    // Constructor (parameter names are different from instance variable names)
    public Saluran(String nama, double frekuensi, int kekuatanSinyal) {
        namaSaluranTV = nama;
        frekuensiSaluranTV = frekuensi;
        kekuatanSinyalSaluranTV = kekuatanSinyal;
    }

    // Getter methods
    public String getNama() {
        return namaSaluranTV;
    }

    public double getFrekuensi() {
        return frekuensiSaluranTV;
    }

    public int getKekuatanSinyal() {
        return kekuatanSinyalSaluranTV;
    }

    // Method to display information
    public void tampilkanInfo() {
        System.out.println("Saluran: " + namaSaluranTV + " | Frekuensi: " + String.format("%.2f", frekuensiSaluranTV) + " MHz | Kekuatan Sinyal: " + kekuatanSinyalSaluranTV);
    }
}

public class TugasClassOperasiTunning {
    int suara = 0;    // Level suara default
    int terang = 0;   // Level kecerahan default
    Saluran[] saluranList = new Saluran[15];  
    Saluran[] saluranDitemukan = new Saluran[15];
    int jumlahSaluran = 0;
    int jumlahDitemukan = 0;

    Scanner input = new Scanner(System.in);
    Random random = new Random();

    public TugasClassOperasiTunning() {
        muatSaluran();
    }

    private void muatSaluran() {
        saluranList[jumlahSaluran++] = new Saluran("RCTI", random.nextInt(100), random.nextInt(100));
        saluranList[jumlahSaluran++] = new Saluran("SCTV", random.nextInt(100), random.nextInt(100));
        saluranList[jumlahSaluran++] = new Saluran("Indosiar", random.nextInt(100), random.nextInt(100));
        saluranList[jumlahSaluran++] = new Saluran("Trans TV", random.nextInt(100), random.nextInt(100));
        saluranList[jumlahSaluran++] = new Saluran("TVRI", random.nextInt(100), random.nextInt(100));
        saluranList[jumlahSaluran++] = new Saluran("ANTV", random.nextInt(100), random.nextInt(100));
        saluranList[jumlahSaluran++] = new Saluran("MnC/TPI", random.nextInt(100), random.nextInt(100));
        saluranList[jumlahSaluran++] = new Saluran("Metro TV", random.nextInt(100), random.nextInt(100));
        saluranList[jumlahSaluran++] = new Saluran("Global TV", random.nextInt(100), random.nextInt(100));
        saluranList[jumlahSaluran++] = new Saluran("Net TV", random.nextInt(100), random.nextInt(100));
        saluranList[jumlahSaluran++] = new Saluran("Kompas TV", random.nextInt(100), random.nextInt(100));
        saluranList[jumlahSaluran++] = new Saluran("TV One", random.nextInt(100), random.nextInt(100));
        saluranList[jumlahSaluran++] = new Saluran("iNews TV", random.nextInt(100), random.nextInt(100));
        saluranList[jumlahSaluran++] = new Saluran("CNN Indonesia", random.nextInt(100), random.nextInt(100));


    }

    public void startTV() {
        menu();
    }

    public void menu() {
        while (true) {
            System.out.println("\n-----------------");
            System.out.println("  Menu Utama : ");
            System.out.println("-----------------");
            System.out.println("1. Ganti Channel");
            System.out.println("2. Tambah Suara");
            System.out.println("3. Kurang Suara");
            System.out.println("4. Tambah Kecerahan");
            System.out.println("5. Kurang Kecerahan");
            System.out.println("6. CH-Setting");
            System.out.println("0. Keluar");
            System.out.println("-----------------");
            System.out.print("Masukkan pilihan Anda: ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1 -> ganti_channel();
                case 2 -> ubah_suara(true);
                case 3 -> ubah_suara(false);
                case 4 -> ubah_kecerahan(true);
                case 5 -> ubah_kecerahan(false);
                case 6 -> menuTuning();
                case 0 -> {
                    System.out.println("Selamat menonton!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    public void menuTuning() {
        System.out.println("\nTuning Mode:");
        System.out.println("1. Automatic Tuning");
        System.out.println("2. Manual Tuning");
        System.out.print("Masukkan pilihan Anda: ");
        int tuningPilihan = input.nextInt();

        switch (tuningPilihan) {
            case 1 -> tuningOtomatis();
            case 2 -> tuningManual();
            default -> System.out.println("Pilihan tidak valid.");
        }
    }

    public void tuningOtomatis() {
        System.out.println("\nTuning otomatis dimulai...");
        jumlahDitemukan = 0;

        // Mengacak urutan saluran dalam saluranList
        acakSaluran(saluranList, jumlahSaluran);
        Saluran saluranPertama = null;

        for (double frekuensi = 1.00; frekuensi <= 100.00; frekuensi += 0.20) {
            String band = getBand(frekuensi);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace(); // Optional: untuk melacak kesalahan lebih lanjut
            }
            System.out.printf("Auto-Tuning (%s) %.2f MHz...\n", band, frekuensi);

            for (int i = 0; i < jumlahSaluran; i++) {
                Saluran saluran = saluranList[i];
                if (saluran.getFrekuensi() - frekuensi < 0.01 && saluran.getFrekuensi() - frekuensi > -0.01) {
                    saluranDitemukan[jumlahDitemukan++] = saluran;

                    System.out.println("\nSaluran ditemukan:");
                    saluran.tampilkanInfo();

                    if (saluranPertama == null) {
                        saluranPertama = saluran;
                    }
                    break;
                }
            }
        }

        System.out.println("\nTuning otomatis selesai.");
        if (jumlahDitemukan == 0) {
            System.out.println("Tidak ada saluran yang ditemukan.");
        } else {
            System.out.println("\nSaluran yang tersedia:");

            
            for (int i = 0; i < jumlahDitemukan; i++) {
                System.out.printf("%d. ", i + 1);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace(); // Optional: untuk melacak kesalahan lebih lanjut
                }
                saluranDitemukan[i].tampilkanInfo();
            }
            System.out.println("\nChannel sekarang: " + saluranPertama.getNama() + " | Frekuensi: " + saluranPertama.getFrekuensi() + " MHz | Kekuatan Sinyal: " + saluranPertama.getKekuatanSinyal());
        }
    }

    public String getBand(double frekuensi) {
        if (frekuensi >= 1.00 && frekuensi < 30.00) {
            return "HF";
        } else if (frekuensi >= 30.00 && frekuensi < 300.00) {
            return "VHF";
        } else {
            return "UHF";
        }
    }

    public void tuningManual() {
        System.out.print("\nMasukkan frekuensi yang ingin dicari (1-100 MHz): ");
        int frekuensi = input.nextInt();
        boolean ditemukan = false;

        for (int i = 0; i < jumlahSaluran; i++) {
            if (saluranList[i].getFrekuensi() == frekuensi) {
                System.out.println("Saluran ditemukan:");
                saluranList[i].tampilkanInfo();
                ditemukan = true;
                saluranDitemukan[jumlahDitemukan++] = saluranList[i];
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada saluran pada frekuensi tersebut.");
        }
    }

    public void ganti_channel() {
        while (true) {
            System.out.println("\nGanti ke-channel:");
            System.out.println("1. TVRI");
            System.out.println("2. MnC/TPI");
            System.out.println("3. INDOSIAR");
            System.out.println("4. RCTI");
            System.out.println("5. SCTV");
            System.out.println("6. ANTV");
            System.out.print("Masukkan nomor channel yang diinginkan: ");
            int c = input.nextInt();

            String channel = switch (c) {
                case 1 -> "TVRI";
                case 2 -> "MnC/TPI";
                case 3 -> "INDOSIAR";
                case 4 -> "RCTI";
                case 5 -> "SCTV";
                case 6 -> "ANTV";
                default -> {
                    System.out.println("Channel tidak tersedia");
                    yield "";
                }
            };
            if (c <= 6 && c >= 1) {
                System.out.println("Channel anda berganti ke " + channel);
            }

            System.out.print("Apakah Anda ingin mengganti channel lagi? (y/n): ");
            String lanjut = input.next().toLowerCase();
            if (!lanjut.equals("y")) break;
        }
    }
    

    public void ubah_suara(boolean tambah) {
        System.out.println("\nLevel suara sekarang: " + suara);
        System.out.print("Masukkan level suara yang ingin " + (tambah ? "ditambah" : "dikurangi") + ": ");
        int level = input.nextInt();

        if (tambah) {
            suara += level;
            if (suara > 100) suara = 100;
        } else {
            suara -= level;
            if (suara < 0) suara = 0;
        }
        System.out.println("Suara sekarang: " + suara);
    }

    public void ubah_kecerahan(boolean tambah) {
        System.out.println("\nLevel kecerahan sekarang: " + terang);
        System.out.print("Masukkan level kecerahan yang ingin " + (tambah ? "ditambah" : "dikurangi") + ": ");
        int level = input.nextInt();

        if (tambah) {
            terang += level;
            if (terang > 100) terang = 100;
        } else {
            terang -= level;
            if (terang < 0) terang = 0;
        }
        System.out.println("Kecerahan sekarang: " + terang);
    }

    private void acakSaluran(Saluran[] array, int panjang) {
        for (int i = 0; i < panjang; i++) {
            int j = random.nextInt(panjang);
            Saluran temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
