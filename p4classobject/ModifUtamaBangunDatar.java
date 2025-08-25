package p4classobject;

public class ModifUtamaBangunDatar {
    public static void main(String[] args) {
        ModifOperasiBangunDatar operasi = new ModifOperasiBangunDatar();

        // Luas bangun datar
        operasi.luas_persegi(5);
        operasi.tampilLuas();

        operasi.luas_segitiga(6, 3);
        operasi.tampilLuas();

        operasi.persegi_panjang(4, 7);
        operasi.tampilLuas();

        operasi.luas_lingkaran(8);
        operasi.tampilLuas();

        // Volume bangun ruang
        operasi.volume_kubus(4);
        operasi.tampilVolume();

        operasi.volume_balok(3, 4, 5);
        operasi.tampilVolume();

        operasi.volume_tabung(2, 3);
        operasi.tampilVolume();

        operasi.volume_limas_segiempat(2, 3);
        operasi.tampilVolume();

        operasi.volume_kerucut(2, 3);
        operasi.tampilVolume();

        operasi.volume_bola(2);
        operasi.tampilVolume();
    }
}
