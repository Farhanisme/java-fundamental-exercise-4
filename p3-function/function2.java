public class function2 {
    public static int faktorial(int a)
    {
    int hasil = 1; 
    for (int i = 1; i <= a; i++)
     {
        hasil*=i;
     }
     return hasil;
    }
    public static void main(String args[])
    {
        int n = 5;
        int k = 3; 
        System.out.println("nilai Faktorial n = "+faktorial(n)); 
        System.out.println("nilai Faktorial k = "+faktorial(k));
        
        int kombinasi = faktorial(n)/faktorial(k)*(faktorial(n-k)); 
        System.out.println("Kombinasi n dan k = "+kombinasi);

        int permutasi = faktorial(n)/(faktorial(n-k)); 
        System.out.println("Permutasi n dan k = "+permutasi);
    }
}