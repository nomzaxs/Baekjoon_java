/***************************************************************************************************
11402번 이항 계수 4

limit_time : 1s, limit_memory : 256MB

문제
자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수 
\(\binom{N}{K}\)를 \(M\)으로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 \(N\), \(K\)와 \(M\)이 주어진다. (1 ≤ \(N\) ≤ 1018, 0 ≤ \(K\) ≤ \(N\), 2 ≤ \(M\) ≤ 2,000, M은 소수)

출력

\(\binom{N}{K}\)를 \(M\)으로 나눈 나머지를 출력한다.

예제 입력 1 
5 2 3
예제 출력 1 
1
예제 입력 2 
30 10 3
예제 출력 2 
0
예제 입력 3 
30 3 3
예제 출력 3 
1
예제 입력 4 
100 45 7
예제 출력 4 
0
예제 입력 5 
100 45 13
예제 출력 5 
2
***************************************************************************************************/

package number_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_11402 {
    static long p, N, R;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());

        long[] fact = new long[(int) p + 1];
        fact[0] = 1;

        for (int i = 1; i <= p; ++i) {
            fact[i] = (i * fact[i - 1]) % p;
        }

        long ans = 1;

        while (r > 0 || n > 0) {
            N = n % p;
            R = r % p;

            if (R > N) {
                ans = 0;
                break;
            }

            // 페르마의 소정리
            ans = (ans * fact[(int) N]) % p;

            for (int i = 0; i < p - 2; i++) {
                ans = (ans * fact[(int) (N - R)] * fact[(int) R]) % p;
            }

            n /= p;
            r /= p;
        }
        ans %= p;

        System.out.println(ans);
    }
}