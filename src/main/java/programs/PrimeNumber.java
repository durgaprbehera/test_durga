package programs;

public class PrimeNumber {

    public static void main(String[] args){

        int i = 9;
        int temp =0;

        for(int j=1; j<=i; j++) {
            if(i%j==0){
                temp++;
            }
        }

        if(temp >2){
            System.out.println("Not Prime Number");
        }
        else if(temp==2)
            System.out.println("Prime");

    }
}
