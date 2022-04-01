package programs.dynamicprograms;

public class Factorial {
    static int[] arr = new int[100];
    public static void main(String[] args){
        System.out.println(fact(6));
    }

    private static int fact(int n){
        if(arr[n] == 0){
            if(n <= 1)
                arr[n] = 1;
            else
                arr[n] = n * fact(n-1);
        }
        return arr[n];
    }
}
