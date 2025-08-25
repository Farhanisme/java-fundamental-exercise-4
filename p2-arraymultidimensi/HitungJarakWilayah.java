import java.util.Scanner;

public class HitungJarakWilayah {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Inisialisasi data wilayah dan koordinatnya
        String[] wilayah = {"Wilayah A", "Wilayah B", "Wilayah C", "Wilayah D"};
        double[][] koordinat = {{1.0, 2.0}, {3.0, 4.0}, {5.0, 6.0}, {7.0, 8.0}};

        int jumlahWilayah = wilayah.length;

        System.out.println("Daftar Wilayah dan Koordinatnya:");
        for (int i = 0; i < jumlahWilayah; i++) {
            System.out.println(wilayah[i] + ": (" + koordinat[i][0] + ", " + koordinat[i][1] + ")");
        }

        System.out.println("Masukkan nomor wilayah pertama: ");
        int wilayahPertama = input.nextInt();
        System.out.println("Masukkan nomor wilayah kedua: ");
        int wilayahKedua = input.nextInt();

        if (wilayahPertama < 0 || wilayahPertama >= jumlahWilayah || wilayahKedua < 0 || wilayahKedua >= jumlahWilayah) {
            System.out.println("Nomor wilayah tidak valid.");
        } else {
            double deltaX = koordinat[wilayahKedua][0] - koordinat[wilayahPertama][0];
            double deltaY = koordinat[wilayahKedua][1] - koordinat[wilayahPertama][1];
            double jarak = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            System.out.println("Jarak antara " + wilayah[wilayahPertama] + " dan " + wilayah[wilayahKedua] + " adalah " + jarak + " satuan.");
        }
        input.close();
    }
}
