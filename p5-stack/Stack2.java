import java.util.*;

public class Stack2 {
    char stack[] = new char[50]; 
    int top;

    public void push(char data) { 
            stack[top] = data;
            top++;
    }

    public char pop() { 
            top--;
            return stack[top]; 
    }

    public void tampil() {
        while (top > 0) {
            System.out.print(pop()); 
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner baca = new Scanner(System.in);
        Stack2 tumpuk = new Stack2();
        System.out.println();
        System.out.println("Masukkan sebuah kalimat:");
        String kalimat = baca.nextLine();

        for (int i = 0; i < kalimat.length(); i++) {
            tumpuk.push(kalimat.charAt(i));
        }
        System.out.println();
        System.out.println("Kalimat yang dibalik:");
        tumpuk.tampil();
        System.out.println();
    }
}






