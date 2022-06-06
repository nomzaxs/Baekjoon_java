/***************************************************************************************************
11728번 배열 합치기

limit_time : 1.5s, limit_memory : 256MB

문제
정렬되어있는 두 배열 A와 B가 주어진다. 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 배열 A의 크기 N, 배열 B의 크기 M이 주어진다. (1 ≤ N, M ≤ 1,000,000)

둘째 줄에는 배열 A의 내용이, 셋째 줄에는 배열 B의 내용이 주어진다. 배열에 들어있는 수는 절댓값이 109보다 작거나 같은 정수이다.

출력
첫째 줄에 두 배열을 합친 후 정렬한 결과를 출력한다.

예제 입력 1 
2 2
3 5
2 9
예제 출력 1 
2 3 5 9
예제 입력 2 
2 1
4 7
1
예제 출력 2 
1 4 7
예제 입력 3 
4 3
2 3 5 9
1 4 7
예제 출력 3 
1 2 3 4 5 7 9
***************************************************************************************************/

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nArr = new int[N + 1];
        int[] mArr = new int[M + 1];
        int[] sum = new int[N + M];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            nArr[n] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            mArr[m] = Integer.parseInt(st.nextToken());
        }

        int n = 0;
        int m = 0;
        int p = 0;

        while (n < N || m < M) {
            if (n < N && m < M) {
                if (nArr[n] < mArr[m]) {
                    sum[p++] = nArr[n++];
                } else {
                    sum[p++] = mArr[m++];
                }
            }

            if (n < N && m == M) {
                while (n < N) {
                    sum[p++] = nArr[n++];
                }
            }

            if (n == N && m < M) {
                while (m < M) {
                    sum[p++] = mArr[m++];
                }
            }
        }

        for (int i = 0; i < N + M; i++) {
            sb.append(sum[i] + " ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}