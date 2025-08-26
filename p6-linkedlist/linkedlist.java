public class linkedlist {

    public class Rantai {
        int isi;                            // Isi rantai (node); bebas tipe datanya
        Rantai next;                        // Untuk pointer rantai
    }

    public class Operasi {
        Rantai head;                        // Inisialisasi node/rantai kepala

        public void sisip(int data) {        
            Rantai nodeBaru = new Rantai(); // Membuat node baru
            nodeBaru.isi = data;            // Mengisi node baru dengan data
            nodeBaru.next = null;           // Tidak menunjuk kemana-mana

            if (head == null) {
                head = nodeBaru;            
            } else {
                Rantai nodeBantuan = head;          // Node bantuan untuk mencari node kepala
                while (nodeBantuan.next != null) {  // Melakukan pencarian node terakhir
                    nodeBantuan = nodeBantuan.next; // Node bantuan menjadi apa yang ditunjuk oleh node bantuan
                }
                nodeBantuan.next = nodeBaru;        // sampai menemukan node terakhir, node bantuan menunjuk ke node baru
            }
        }

    public void sisip_depan(int data) {
        Rantai nodeBaru = new Rantai();     // Membuat node baru
        nodeBaru.isi = data;                // Mengisi node baru dengan data dari main class 
        nodeBaru.next = null;               // Tidak menunjuk kemana-mana

        if (head == null) {                 // Kalau kepala kosong
            head = nodeBaru;                // Node baru jadi kepala
        } else {
            nodeBaru.next = head;           // Node baru menunjuk ke kepala
            head = nodeBaru;
        }
    }

    public void hapus (int posisi) {
        Rantai nodeBantuan = head;
        Rantai nodeHapus = null;

        for (int i = 0; i < posisi - 1; i++) {
            nodeBantuan = nodeBantuan.next;
        }
        nodeHapus = nodeBantuan.next;           // Node yang ditunjuk oleh node bantuan menjadi rujukan node hapus
        nodeBantuan.next = nodeHapus.next;      // Node bantuan menunjuk kepada node yang ditunjuk oleh node hapus
        nodeHapus.next = null;                  // Node hapus menjadi null maka dia terhapus
    }

    public void tampil() {
        Rantai nodeBantuan = head;
        while (nodeBantuan != null) {
            System.out.print(nodeBantuan.isi + " ");
            nodeBantuan = nodeBantuan.next;
        }
        System.out.println(nodeBantuan.isi);

    }
    }
}

// bikin class node
// bikin class operasi 
    // 1. inisialisasi node kepala
