/***************************************************************************************************
13702번 이상한 술집

limit_time : 1s, limit_memory : 512MB

문제
프로그래밍 대회 전날, 은상과 친구들은 이상한 술집에 모였다. 이 술집에서 막걸리를 시키면 주전자의 용량은 똑같았으나 안에 들어 있는 막걸리 용량은 랜덤이다.  즉 한 번 주문에 막걸리 용량이 802ml 이기도 1002ml가 나오기도 한다.  은상은 막걸리 N 주전자를 주문하고, 자신을 포함한 친구들 K명에게 막걸리를 똑같은 양으로 나눠주려고 한다.  그런데 은상과 친구들은 다른 주전자의 막걸리가 섞이는 것이 싫어서, 분배 후 주전자에 막걸리가 조금 남아 있다면 그냥 막걸리를 버리기로 한다.  (즉, 한 번 주문한 막걸리에 남은 것을 모아서 친구들에게 다시 주는 경우는 없다.  예를 들어 5명이 3 주전자를 주문하여 1002, 802, 705 ml의 막걸리가 각 주전자에 담겨져 나왔고, 이것을 401ml로 동등하게 나눴을 경우 각각 주전자에서 200ml, 0m, 304ml 만큼은 버린다.) 이럴 때 K명에게 최대한의 많은 양의 막걸리를 분배할 수 있는 용량 ml는 무엇인지 출력해주세요.

입력
첫째 줄에는 은상이가 주문한 막걸리 주전자의 개수 N, 그리고 은상이를 포함한 친구들의 수 K가 주어진다. 둘째 줄부터 N개의 줄에 차례로 주전자의 용량이 주어진다. N은 10000이하의 정수이고, K는 1,000,000이하의 정수이다. 막걸리의 용량은 231 -1 보다 작거나 같은 자연수 또는 0이다. 단, 항상 N ≤ K 이다. 즉, 주전자의 개수가 사람 수보다 많을 수는 없다.

출력
첫째 줄에 K명에게 나눠줄 수 있는 최대의 막걸리 용량 ml 를 출력한다.

예제 입력 1 
2 3
702
429
예제 출력 1 
351
예제 입력 2 
4 11
427
541
774
822
예제 출력 2 
205
***************************************************************************************************/

package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_13702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        long result = 0;
        long min = 0;
        long max = 0;

        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[n]);
        }

        while (min <= max) {
            long mid = (min + max) / 2;

            if (mid == 0) {
                mid = 1;
            }

            int sum = 0;

            for (int i = 0; i < N; i++) {
                sum += (arr[i] / mid);
            }

            if (sum >= K) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(result);
    }
}
