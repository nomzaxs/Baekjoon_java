/***************************************************************************************************
10974번 모든 순열

limit_time : 1s, limit_memory : 256MB

문제
N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다. 

출력
첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.

예제 입력 1 
3
예제 출력 1 
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1
***************************************************************************************************/

package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_10974 {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];

        recur(0);
    }

    public static void recur(int cur) {

        // 기저 조건
        if (cur == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + 1 + " ");
            }
            System.out.println();
            return;
        }

        // 재귀 호출
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue; // 사용중이면 건너뜀
            }
            arr[cur] = i;
            visited[i] = true; // 사용중인지
            recur(cur + 1);
            visited[i] = false; // 출력이 되면 해제
        }
    }
}