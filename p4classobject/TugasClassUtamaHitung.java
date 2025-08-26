package p4classobject;

import java.util.Scanner;



public class TugasClassUtamaHitung {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] a = new int[2]; 
        
        System.out.print("Masukkan n: ");
        a[0] = scanner.nextInt(); 

        System.out.print("Masukkan r: ");
        a[1] = scanner.nextInt(); 

        TugasClassOperasiHitung hitung = new TugasClassOperasiHitung();

        hitung.faktorial(a[0]);
        hitung.tampil();

        hitung.faktorial(a[1]);
        hitung.tampil();

        hitung.kombinasi(a[0], a[1]);
        hitung.tampil();

        hitung.permutasi(a[0], a[1]);
        hitung.tampil();

    }
}
