package p4classobject;
public class ClassUtamaTV {
    public static void main(String[] args) {
        ClassOperasiTV RemoteTV = new ClassOperasiTV();
        RemoteTV.menu();
        RemoteTV.ganti_channel(3);
        RemoteTV.ganti_channel(5);
        RemoteTV.ganti_channel(9);

        RemoteTV.tambah_suara(50);
        RemoteTV.tambah_suara(25);
        RemoteTV.tambah_suara(25);

        RemoteTV.kurang_suara(30);
        RemoteTV.kurang_suara(20);
        RemoteTV.kurang_suara(50);

        RemoteTV.tambah_terang(50);
        RemoteTV.tambah_terang(50);

        RemoteTV.kurang_terang(70);
        RemoteTV.kurang_terang(30);

    }
}
