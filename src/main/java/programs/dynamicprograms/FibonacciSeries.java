package programs.dynamicprograms;

public class FibonacciSeries {
    static int[] arr = new int[100];
    public static void main(String[] args){
        System.out.println(fibonacciSeries(6));
    }

    private static int fibonacciSeries(int n){
        if(arr[n] == 0)
        {
            if(n<=1)
                arr[n] = n;
            else
                arr[n] = fibonacciSeries(n-1) + fibonacciSeries(n-2);
        }

        return arr[n];
    }
}
