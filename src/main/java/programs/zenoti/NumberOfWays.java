package programs.zenoti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class NumberOfWays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            String[] a = br.readLine().trim().split(" ");

            long N = Long.parseLong(a[0]);
            long K = Long.parseLong(a[1]);

            long out_ = printCountDP(N, K);
            System.out.println(out_);
            System.out.println("");
        }

        wr.close();
        br.close();
    }

    // Function returns count of ways to cover 'dist'
    static long printCountDP(long dist, long steps) {
        long[][] dp = new long[10005][105];
        long mod = (long) 1e9 + 7;

        for (int k = 1; k <= steps; k++) {
            dp[1][k] = 1;
            for (int i = 2; i <= dist; i++) {
                if (i <= k)
                    dp[i][k] = 1;
                else
                    dp[i][k] = 0;
                for (int j = i - 1; j >= Math.max(1, i - k); j--) {
                    dp[i][k] = (dp[i][k] + dp[j][k]) % mod;
                }
            }
        }

        return dp[(int) dist][(int) steps];
    }
}
