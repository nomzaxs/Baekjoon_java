/***************************************************************************************************
1019번 책 페이지

limit_time : 2s, limit_memory : 128MB

문제
지민이는 전체 페이지의 수가 N인 책이 하나 있다. 첫 페이지는 1 페이지이고, 마지막 페이지는 N 페이지이다. 각 숫자가 전체 페이지 번호에서 모두 몇 번 나오는지 구해보자.

입력
첫째 줄에 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 0이 총 몇 번 나오는지, 1이 총 몇 번 나오는지, ..., 9가 총 몇 번 나오는지를 공백으로 구분해 출력한다.

예제 입력 1 
11
예제 출력 1 
1 4 1 1 1 1 1 1 1 1
예제 입력 2 
7
예제 출력 2 
0 1 1 1 1 1 1 1 0 0
예제 입력 3 
19
예제 출력 3 
1 12 2 2 2 2 2 2 2 2
예제 입력 4 
999
예제 출력 4 
189 300 300 300 300 300 300 300 300 300
예제 입력 5 
543212345
예제 출력 5 
429904664 541008121 540917467 540117067 533117017 473117011 429904664 429904664 429904664 429904664
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_1019 {
    static long N, delta;
    static long[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Long.parseLong(br.readLine());
        long t = N;
        long s = 1;
        arr = new long[10];

        delta = 1;

        while (t > 0) {
            for (int i = 0; i < 10; i++) {
                arr[i] += (t / 10 + (i > 0 ? 1 : 0)) * s;
            }

            arr[(int) (t % 10)] -= s - N % s - 1;

            for (int i = (int) (1 + t % 10); i < 10; i++) {
                arr[i] -= s;
            }

            s *= 10;
            t /= 10;
        }

        for (int i = 0; i < 10; i++) {
            sb.append(arr[i] + " ");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}