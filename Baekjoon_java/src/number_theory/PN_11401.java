/***************************************************************************************************
11401번 이항 계수 3

limit_time : 1s, limit_memory : 256MB

문제
자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수 
\(\binom{N}{K}\)를 1,000,000,007로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 \(N\)과 \(K\)가 주어진다. (1 ≤ \(N\) ≤ 4,000,000, 0 ≤ \(K\) ≤ \(N\))

출력

\(\binom{N}{K}\)를 1,000,000,007로 나눈 나머지를 출력한다.

예제 입력 1 
5 2
예제 출력 1 
10
***************************************************************************************************/

package number_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_11401 {
    static int p = 1000000007;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());

        long[] fact = new long[(int) n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; ++i) {
            fact[i] = (i * fact[i - 1]) % p;
        }

        long ans = fact[(int) n] * fermat((fact[(int) r] * fact[(int) (n - r)]) % p, p - 2) % p;

        System.out.println(ans);
    }

    private static long fermat(long n, long l) {
        if (l == 0)
            return 1;
        long tmp = fermat(n, l / 2);
        long ret = (tmp * tmp) % p;
        if (l % 2 == 0)
            return ret;
        else
            return (ret * n) % p;
    }
}