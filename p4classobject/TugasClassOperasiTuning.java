// package p4classobject;

// import java.util.Random;
// import java.util.Scanner;

// public class TugasClassOperasiTuning {
//     boolean nyala = false;
//     boolean dituning = false;  // Tambahkan variabel untuk melacak status tuning
//     String[][] daftarChannel = new String[7][2]; // [nama channel, frekuensi]
//     String channelSekarang = "Belum ada channel";
//     double frekuensiSekarang = 0.0;

//     public TugasClassOperasiTuning() {
//         inisialisasiChannel();  // Inisialisasi channel dengan frekuensi acak
//     }

//     // Inisialisasi nama channel dan frekuensi acak
//     public void inisialisasiChannel() {
//         String[] namaChannel = {"Kompas TV", "iNews TV", "CNN Indonesia", "TVRI", "Metro TV", "Net TV", "TV One"};
//         Random acak = new Random();
        
//         for (int i = 0; i < namaChannel.length; i++) {
//             daftarChannel[i][0] = namaChannel[i];
//             daftarChannel[i][1] = String.format("%.2f", 1.00 + (acak.nextInt(45) * 0.20)); // Frekuensi acak
//         }
//     }

//     public void acakChannel() {
//         Random acak = new Random();
//         for (int i = 0; i < daftarChannel.length; i++) {
//             int indeksAcak = acak.nextInt(daftarChannel.length);
//             String[] sementara = daftarChannel[i];
//             daftarChannel[i] = daftarChannel[indeksAcak];
//             daftarChannel[indeksAcak] = sementara;
//         }
//     }

//     public void startTV() {
//         Scanner scanner = new Scanner(System.in);
//         while (true) {
//             System.out.println("------------");
//             System.out.println("| ParmanTV |");
//             System.out.println("------------");
//             System.out.println("|  (1) ON  |");
//             System.out.println("------------");
//             System.out.print("Masukkan perintah: ");
//             int pilihan = scanner.nextInt();

//             if (pilihan == 1) {
//                 nyala = true;
//                 menuUtama();
//             } else {
//                 break;
//             }
//         }
//     }

//     private void menuUtama() {
//         Scanner scanner = new Scanner(System.in);
//         while (nyala) {
//             System.out.println("\n--------------");
//             System.out.println("| Menu Utama |");
//             System.out.println("--------------");
//             System.out.println("1. Pilih Channel");
//             System.out.println("2. Setting Channel (Tuning)");
            // System.out.println("3. Setting Volume");
            // System.out.println("4. Setting Kontras");
//             System.out.println("0. OFF");
//             System.out.print("Masukkan pilihan: ");
            
//             int pilihan = scanner.nextInt();
//             switch (pilihan) {
//                 case 1:
//                     pilihChannel();
//                     break;
//                 case 2:
//                     tuningMenu();
//                     break;
//                 case 0:
//                     nyala = false;
//                     System.out.println("Kembali ke menu awal...");
//                     break;
//                 default:
//                     System.out.println("Pilihan tidak valid.");
//             }
//         }
//     }

//     private void pilihChannel() {
//         System.out.println("Saluran yang tersedia:");
        
//         // Jika tuning belum dilakukan, tampilkan hanya 3 channel pertama
//         if (!dituning) {
//             // for (int i = 0; i < 3; i++) {
//             //     if (daftarChannel[i][0] != null) {
//             //         System.out.println("Ch " + (i + 1) + " - " + daftarChannel[i][0] + " | Frekuensi: " + daftarChannel[i][1] + " MHz");
//             //     }
//             // }
//             System.out.println("Channel belum lengkap. Silakan lakukan tuning terlebih dahulu.");

//         } else {
//             // Jika tuning sudah dilakukan, tampilkan semua channel
//             for (int i = 0; i < daftarChannel.length; i++) {
//                 if (daftarChannel[i][0] != null) {
//                     System.out.println("Ch " + (i + 1) + " - " + daftarChannel[i][0] + " | Frekuensi: " + daftarChannel[i][1] + " MHz");
//                 }
//             }

//             System.out.print("Masukkan nomor channel: ");
//             Scanner scanner = new Scanner(System.in);
//             int nomorChannel = scanner.nextInt();
//                 if (nomorChannel > 0 && nomorChannel <= daftarChannel.length && daftarChannel[nomorChannel - 1][0] != null) {
//                     channelSekarang = daftarChannel[nomorChannel - 1][0];
//                     frekuensiSekarang = Double.parseDouble(daftarChannel[nomorChannel - 1][1]);
//                     System.out.println("Channel sekarang: " + channelSekarang + " | Frekuensi: " + frekuensiSekarang + " MHz");
//                 } else {
//                     System.out.println("Channel tidak valid atau belum dituning.");
//                 }
//         }
//     // if (dituning) {

//     // }
//     }

//     private void tuningMenu() {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("\n--------------");
//         System.out.println("| Tuning Mode: |");
//         System.out.println("--------------");
//         System.out.println("1. Auto-Tuning");
//         System.out.println("2. Manual Tuning");
//         System.out.print("Masukkan pilihan Anda: ");
        
//         int pilihan = scanner.nextInt();
//         if (pilihan == 1) {
//             autoTuning();
//         } else if (pilihan == 2) {
//             manualTuning();
//         } else {
//             System.out.println("Pilihan tidak valid.");
//         }
//     }

//     public void autoTuning() {
//         acakChannel();
//         System.out.println("Tuning otomatis dimulai...");
        
//         double frekuensiCari = 1.00;
//         while (frekuensiCari <= 10.00) {
//             try {
//                 Thread.sleep(100);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//             System.out.printf("Auto-Tuning (HF) %.2f MHz...\n", frekuensiCari);
            
//             boolean channelDitemukan = false;
//             for (int i = 0; i < daftarChannel.length; i++) {
//                 if (daftarChannel[i][1] != null && Math.abs(Double.parseDouble(daftarChannel[i][1]) - frekuensiCari) < 0.01) {
//                     System.out.println("\nSaluran ditemukan:");
//                     System.out.println("Saluran: " + daftarChannel[i][0] + " | Frekuensi: " + daftarChannel[i][1] + " MHz");
//                     try {
//                         Thread.sleep(150);
//                     } catch (InterruptedException e) {
//                         e.printStackTrace();
//                     }
//                     channelDitemukan = true;
//                     break;
//                 }
//             }
//             frekuensiCari += 0.20;
//             if (channelDitemukan) {
//                 System.out.println();
//             }
//         }

//         dituning = true;

//         System.out.println("Saluran yang tersedia:");
//         for (int i = 0; i < daftarChannel.length; i++) {
//             if (daftarChannel[i][0] != null) {
//                 try {
//                     Thread.sleep(150);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//                 System.out.println("Ch " + (i + 1) + " - " + daftarChannel[i][0] + " | Frekuensi: " + daftarChannel[i][1] + " MHz");
//             }
//         }
//     }    

//     private void manualTuning() {
//         Scanner scanner = new Scanner(System.in);

//         if (dituning) {
//         System.out.println("\nMasuk ke Mode Tuning Manual:");
    
//         for (int i = 0; i < daftarChannel.length; i++) {
//             if (daftarChannel[i][0] == null) {
//                 continue;
//             }
    
//             System.out.println("Channel saat ini: Ch " + (i + 1) + " - " + daftarChannel[i][0] + " | Frekuensi: " + daftarChannel[i][1] + " MHz");
//             System.out.println("1. Ubah nomor channel");
//             System.out.println("2. Simpan");
//             System.out.println("0. Keluar Manual Tuning");
//             System.out.print("Masukkan pilihan: ");
            
//             int pilihan = scanner.nextInt();
            
//             if (pilihan == 1) {  // Mengubah nomor channel
//                 System.out.print("Masukkan nomor channel baru: ");
//                 int nomorChannelBaru = scanner.nextInt();
    
//                 if (nomorChannelBaru > 0 && nomorChannelBaru <= daftarChannel.length) {
//                     if (daftarChannel[nomorChannelBaru - 1][0] != null) {
//                         System.out.println("Channel Ch " + nomorChannelBaru + " - " + daftarChannel[nomorChannelBaru - 1][0] + " sudah terisi.");
//                         System.out.println("Apakah Anda tetap ingin mengganti channel ini? (1 = Ya, 2 = Tidak, 3 = Lanjut ke channel berikutnya)");
//                         int konfirmasi = scanner.nextInt();
    
//                         if (konfirmasi == 1) {
//                             String namaSementara = daftarChannel[i][0];
//                             String frekuensiSementara = daftarChannel[i][1];
//                             daftarChannel[i][0] = daftarChannel[nomorChannelBaru - 1][0];
//                             daftarChannel[i][1] = daftarChannel[nomorChannelBaru - 1][1];
//                             daftarChannel[nomorChannelBaru - 1][0] = namaSementara;
//                             daftarChannel[nomorChannelBaru - 1][1] = frekuensiSementara;
//                             System.out.println("Channel berhasil diganti.");
//                         } else if (konfirmasi == 2) {
//                             System.out.println("Nomor channel tidak diubah. Masukkan kembali nomor channel baru:");
//                             i--;
//                             continue;
//                         } else if (konfirmasi == 3) {
//                             continue;
//                         }
//                     // } else {
//                     //     daftarChannel[nomorChannelBaru - 1][0] = daftarChannel[i][0];
//                     //     daftarChannel[nomorChannelBaru - 1][1] = daftarChannel[i][1];
//                     //     daftarChannel[i][0] = null;
//                     //     daftarChannel[i][1] = null;
//                     //     System.out.println("Channel berhasil dipindahkan.");
//                     }
//                 } else {
//                     System.out.println("Nomor channel tidak valid.");
//                 }
//             } else if (pilihan == 2) {
//                 System.out.println("Channel disimpan.");
//             } else if (pilihan == 0) {
//                 System.out.println("Keluar dari Manual Tuning.");
//                 break;
//             }
//         }
//         System.out.println("Semua channel telah diperiksa.");
//         // dituning = true;
//         System.out.println("Tuning manual selesai.");
//     } else {
//         System.out.println("Silakan lakukan tuning otomatis terlebih dahulu.");
//     }
// }
// }

package p4classobject;

import java.util.Random;
import java.util.Scanner;

public class TugasClassOperasiTuning {
    boolean nyala = false;
    boolean dituning = false;
    String[] nomorChannelTV = new String[7];
    String[] namaChannelTV = new String[7];
    double[] frekuensiChannelTV = new double[7];
    String[][] daftarChannel = new String[7][2]; // [nama channel, frekuensi]
    String channelSekarang = "Belum ada channel";
    double frekuensiSekarang = 0.0;

    public TugasClassOperasiTuning() {
        inisialisasiChannel();  // Inisialisasi channel dengan frekuensi acak
    }

    public void inisialisasiChannel() {
        String[] namaChannel = {"Kompas TV", "iNews TV", "CNN Indonesia", "TVRI", "Metro TV", "Net TV", "TV One"};
        Random acak = new Random();

        for (int i = 0; i < namaChannel.length; i++) {
            daftarChannel[i][0] = namaChannel[i];
            daftarChannel[i][1] = String.format("%.2f", 1.00 + (acak.nextInt(45) * 0.20)); // Frekuensi acak
        }
    }

    public void startTV() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("------------");
            System.out.println("| ParmanTV |");
            System.out.println("------------");
            System.out.println("|  (1) ON  |");
            System.out.println("------------");
            System.out.print("Masukkan perintah: ");
            int pilihan = scanner.nextInt();

            if (pilihan == 1) {
                nyala = true;
                menuUtama();
            } else {
                break;
            }
        }
    }

    private void menuUtama() {
        Scanner scanner = new Scanner(System.in);
        while (nyala) {
            System.out.println("\n--------------");
            System.out.println("| Menu Utama |");
            System.out.println("--------------");
            System.out.println("1. Pilih Channel");
            System.out.println("2. Setting Channel (Tuning)");
            System.out.println("3. Setting Volume");
            System.out.println("4. Setting Kontras");
            System.out.println("0. OFF");
            System.out.print("Masukkan pilihan: ");

            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    pilihChannel();
                    break;
                case 2:
                    tuningMenu();
                    break;
                case 0:
                    nyala = false;
                    System.out.println("Kembali ke menu awal...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void pilihChannel() {
        System.out.println("Daftar channel:");
        boolean adaChannel = false;
        for (int i = 0; i < namaChannelTV.length; i++) {
            if (namaChannelTV[i] != null) {
                adaChannel = true;
                System.out.println("Ch " + (i + 1) + " - " + namaChannelTV[i] + " | Frekuensi: " + frekuensiChannelTV[i] + " MHz");
            }
        }
        if (!adaChannel) {
            System.out.println("Belum ada channel yang tersedia. Silakan lakukan tuning terlebih dahulu.");
        }
    }

    private void tuningMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------");
        System.out.println("| Tuning Mode: |");
        System.out.println("--------------");
        System.out.println("1. Auto-Tuning");
        System.out.println("2. Manual Tuning");
        System.out.print("Masukkan pilihan Anda: ");

        int pilihan = scanner.nextInt();
        if (pilihan == 1) {
            autoTuning();
        } else if (pilihan == 2) {
            manualTuning();
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    public void autoTuning() {
        acakChannel();
        System.out.println("Tuning otomatis dimulai...");
        dituning = true;

        System.out.println("Saluran yang tersedia:");
        for (int i = 0; i < daftarChannel.length; i++) {
            nomorChannelTV[i] = "Ch " + (i + 1);
            namaChannelTV[i] = daftarChannel[i][0];
            frekuensiChannelTV[i] = Double.parseDouble(daftarChannel[i][1]);
            System.out.println(nomorChannelTV[i] + " - " + namaChannelTV[i] + " | Frekuensi: " + frekuensiChannelTV[i] + " MHz");
        }
    }

    private void manualTuning() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("\nMemulai Tuning Manual:");
        for (int i = 0; i < nomorChannelTV.length; i++) {
            System.out.println("Memeriksa Ch " + (i + 1));
            
            boolean channelDisimpan = false; // Indikator apakah channel sudah disimpan
            for (int j = 0; j < daftarChannel.length; j++) {
                String namaChannel = daftarChannel[j][0];
                double frekuensi = Double.parseDouble(daftarChannel[j][1]);
    
                // Menawarkan opsi simpan, tidak, lanjut ke channel berikutnya, atau keluar mode
                System.out.print("Ch " + (i + 1) + " : " + namaChannel + " (Simpan=1/Tidak=2/Lanjut ke Channel Berikutnya=3/Keluar Mode=0)? ");
                int pilihan = scanner.nextInt();
    
                if (pilihan == 1) { // Simpan pasangan nomor channel dan nama TV
                    nomorChannelTV[i] = "Ch " + (i + 1);
                    namaChannelTV[i] = namaChannel;
                    frekuensiChannelTV[i] = frekuensi;
                    System.out.println(nomorChannelTV[i] + " - " + namaChannelTV[i] + " disimpan.");
                    channelDisimpan = true;
                    break; // Lanjut ke nomor channel berikutnya setelah disimpan
                } else if (pilihan == 2) { // Tidak simpan, lanjut ke nama TV berikutnya
                    continue;
                } else if (pilihan == 3) { // Lanjut ke channel berikutnya
                    System.out.println("Ch " + (i + 1) + " dilewati.");
                    channelDisimpan = true; // Set indikator agar tidak cetak pesan channel tidak disimpan
                    break;
                } else if (pilihan == 0) { // Keluar dari mode tuning manual
                    System.out.println("Keluar dari Manual Tuning.");
                    return; // Kembali ke menu utama
                } else {
                    System.out.println("Opsi tidak valid, silakan pilih ulang.");
                }
            }
    
            // Jika tidak ada nama TV yang dipilih dan tidak disimpan
            if (!channelDisimpan) {
                System.out.println("Ch " + (i + 1) + " tidak disimpan pada channel mana pun.");
            }
        }
    
        // Menampilkan channel yang tersimpan setelah tuning selesai
        System.out.println("\nTuning Manual selesai. Channel yang tersimpan:");
        for (int i = 0; i < nomorChannelTV.length; i++) {
            if (namaChannelTV[i] != null) {
                System.out.println(nomorChannelTV[i] + " - " + namaChannelTV[i] + " | Frekuensi: " + frekuensiChannelTV[i] + " MHz");
            }
        }
    }
    
    

    private void acakChannel() {
        Random acak = new Random();
        for (int i = 0; i < daftarChannel.length; i++) {
            int indeksAcak = acak.nextInt(daftarChannel.length);
            String[] sementara = daftarChannel[i];
            daftarChannel[i] = daftarChannel[indeksAcak];
            daftarChannel[indeksAcak] = sementara;
        }
    }
}


