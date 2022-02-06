/***************************************************************************************************
1002번 터렛

limit_time : 2s, limit_memory : 128MB

문제
자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수 
\(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 \(N\)과 \(K\)가 주어진다. (1 ≤ \(N\) ≤ 10, 0 ≤ \(K\) ≤ \(N\))

출력
 
\(\binom{N}{K}\)를 출력한다.

예제 입력 1 
5 2
예제 출력 1 
10
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));
    }

    private static int factorial(int n) {
        if(n < 1){
            return 1;
        }
        else if(n == 1){
            return n;
        } else{
            return factorial(n - 1) * n;
        }
    }
}