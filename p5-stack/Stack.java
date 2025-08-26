import java.util.*;

public class Stack {
    int stack[] = new int[20];
    int top;

    public void push (int data) {
        stack[top] = data;
        top++;
    }

    public int pop () {
        int data;
        data = stack[top];
        top--;
        return data;
    }

    public void tampil () {
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner baca = new Scanner(System.in);
        Stack tumpuk = new Stack();


        tumpuk.push(5);
        tumpuk.push(7);
        tumpuk.push(1);
        tumpuk.push(4);
        tumpuk.push(8);
        tumpuk.push(0);
        tumpuk.push(10);
        tumpuk.push(11);
        tumpuk.push(9);

        tumpuk.tampil();
        System.out.println();

        tumpuk.pop();
        tumpuk.tampil();
        System.out.println();

        tumpuk.pop();
        tumpuk.tampil();
        System.out.println();

        tumpuk.pop();
        tumpuk.tampil();
        System.out.println();

        for (int i = 0; i < 5; i++) {
            tumpuk.pop();
        }

        // tumpuk.tampil();
        // System.out.println();

        int n[] = new int[10];
        Random nilai = new Random();
        for (int i = 0; i < 5; i++) {
            n[i] = nilai.nextInt(10);
        }

        System.out.println("Isi array n: ");
        for (int j = 0; j < 5; j++) {
            System.out.print(n[j] + " ");
        }

        for (int i = 0; i < 5; i++) {
            tumpuk.push(n[i]);
        }

        System.out.println();
        System.out.println("Isi tumpukan stack: ");
        tumpuk.tampil();
    }
}
