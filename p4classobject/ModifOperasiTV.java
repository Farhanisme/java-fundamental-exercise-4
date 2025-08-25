package p4classobject;

import java.util.Scanner;

public class ModifOperasiTV {
    int suara = 0;   
    int terang = 0;   
    Scanner input = new Scanner(System.in);

    public void startTV() {
        pilih_source_dan_ratio();
        menu();
    }

    public void pilih_source_dan_ratio() {
        System.out.println("Pilih Input Source TV:");
        System.out.println("1. AV");
        System.out.println("2. HDMI 1");
        System.out.println("3. HDMI 2");
        System.out.println("4. HDMI 3");
        System.out.println("5. USB");
        System.out.println("6. VGA");
        System.out.println("7. Ethernet (LAN)");
        System.out.print("Masukkan pilihan Anda: ");
        int sourcePilihan = input.nextInt();

        String source = switch (sourcePilihan) {
            case 1 -> "AV";
            case 2 -> "HDMI 1";
            case 3 -> "HDMI 2";
            case 4 -> "HDMI 3";
            case 5 -> "USB";
            case 6 -> "VGA";
            case 7 -> "Ethernet (LAN)";
            default -> "Pilihan tidak valid";
        };
        System.out.println("Input Source yang dipilih: " + source);

        System.out.println("\nPilih Ratio Gambar:");
        System.out.println("1. 4:3");
        System.out.println("2. 16:9");
        System.out.println("3. 21:9");
        System.out.println("4. 32:9");
        System.out.println("5. 1:1");
        System.out.print("Masukkan pilihan Anda: ");
        int ratioPilihan = input.nextInt();

        String ratio = switch (ratioPilihan) {
            case 1 -> "4:3";
            case 2 -> "16:9";
            case 3 -> "21:9";
            case 4 -> "32:9";
            case 5 -> "1:1";
            default -> "Pilihan tidak valid";
        };
        System.out.println("Ratio Gambar yang dipilih: " + ratio);
    }


    public void menu() {
        while (true) {
            System.out.println("\nMenu Utama: ");
            System.out.println("-----------------");
            System.out.println("1. Ganti Channel");
            System.out.println("2. Tambah Suara");
            System.out.println("3. Kurang Suara");
            System.out.println("4. Tambah Kecerahan");
            System.out.println("5. Kurang Kecerahan");
            System.out.println("6. Keluar");
            System.out.println("-----------------");
            System.out.print("Masukkan pilihan Anda: ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1 -> ganti_channel();
                case 2 -> ubah_suara(true); // Menambah suara
                case 3 -> ubah_suara(false); // Mengurangi suara
                case 4 -> ubah_kecerahan(true); // Menambah kecerahan
                case 5 -> ubah_kecerahan(false); // Mengurangi kecerahan
                case 6 -> {
                    System.out.println("Selamat menonton!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
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
            if (!channel.isEmpty()) {
                System.out.println("Channel anda berganti ke " + channel);
            }

            System.out.print("Apakah Anda ingin mengganti channel lagi? (y/n): ");
            String lanjut = input.next().trim().toLowerCase();
            if (!lanjut.equals("y")) break;
        }
    }

    public void ubah_suara(boolean tambah) {
        System.out.println("\nLevel suara sekarang: " + suara);
        System.out.print("Masukkan level suara yang ingin " + (tambah ? "ditambah" : "dikurangi") + ": ");
        int level = input.nextInt();

        if (tambah) {
            suara += level;
            if (suara > 100) {
                suara = 100;
                System.out.println("Suara yang ditambahkan terlalu keras. Level suara sekarang: " + suara);
            } else {
                System.out.println("Suara sekarang: " + suara);
            }
        } else {
            suara -= level;
            if (suara < 0) {
                suara = 0;
                System.out.println("Suara sekarang terlalu pelan. Level suara sekarang: " + suara);
            } else {
                System.out.println("Suara sekarang: " + suara);
            }
        }

        System.out.print("Apakah Anda ingin mengubah suara lagi? (y/n): ");
        String lanjut = input.next();
        if (lanjut.equals("y")) ubah_suara(tambah);
    }

    public void ubah_kecerahan(boolean tambah) {
        System.out.println("\nLevel kecerahan sekarang: " + terang);
        System.out.print("Masukkan level kecerahan yang ingin " + (tambah ? "ditambah" : "dikurangi") + ": ");
        int level = input.nextInt();

        if (tambah) {
            terang += level;
            if (terang > 100) {
                terang = 100;
                System.out.println("Kecerahan yang ditambahkan terlalu tinggi. Level kecerahan sekarang: " + terang);
            } else {
                System.out.println("Kecerahan sekarang: " + terang);
            }
        } else {
            terang -= level;
            if (terang < 0) {
                terang = 0;
                System.out.println("Kecerahan sekarang terlalu rendah. Level kecerahan sekarang: " + terang);
            } else {
                System.out.println("Kecerahan sekarang: " + terang);
            }
        }

        System.out.print("Apakah Anda ingin mengubah kecerahan lagi? (y/n): ");
        String lanjut = input.next();
        if (lanjut.equals("y")) ubah_kecerahan(tambah);
    }
}