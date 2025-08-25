import java.util.Scanner;

public class SegitigaPascal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan tinggi segitiga Pascal: ");
        int tinggi = input.nextInt();

        int[][] segitigaPascal = new int[tinggi][];

        for (int i = 0; i < tinggi; i++) {
            segitigaPascal[i] = new int[i + 1];
            segitigaPascal[i][0] = 1; 

            for (int j = 1; j < i; j++) {
                segitigaPascal[i][j] = segitigaPascal[i - 1][j - 1] + segitigaPascal[i - 1][j];
            }

            segitigaPascal[i][i] = 1; 
        }

        // Menampilkan segitiga Pascal
        for (int i = 0; i < tinggi; i++) {
            for (int j = 0; j < tinggi - i; j++) {
                System.out.print("   "); 
            }
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d   ", segitigaPascal[i][j]);
            }
            System.out.println(); 
        }
        input.close();

    }
}
