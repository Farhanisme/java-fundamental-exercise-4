public class linkedlisto {

    public static void main(String[] args) {
        linkedlisto list = new linkedlisto();      
        Operasi operasi = list.new Operasi();     

        System.out.println();
        // Penyisipan 4 Angka di Belakang
        System.out.println("Penyisipan 4 Angka di Belakang: 10 - 20 - 30 - 40");
        operasi.sisip(10);
        operasi.sisip(20);
        operasi.sisip(30);
        operasi.sisip(40);
        operasi.tampil();                       // Output: 10 20 30 40

        // Penyisipan 3 Angka di Depan
        System.out.println("Penyisipan 3 Angka di Depan: 5 - 3 - 1");
        operasi.sisip_depan(5);
        operasi.sisip_depan(3);
        operasi.sisip_depan(1);
        operasi.tampil();                       // Output: 1 3 5 10 20 30 40

        // Menghapus Node di Posisi ke-2
        System.out.println("Menghapus Node di Posisi 2");
        operasi.hapus(2); 
        operasi.tampil();                       // Output: 1 3 10 20 30 40
        System.out.println();
       
    }

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
                nodeBantuan.next = nodeBaru;        // Sampai menemukan node terakhir, node bantuan menunjuk ke node baru
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

        public void hapus(int posisi) {
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
            System.out.println();
        }
    }
}


