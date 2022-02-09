/***************************************************************************************************
16926번 배열 돌리기 1

limit_time : 1s, limit_memory : 512MB

문제
크기가 N×M인 배열이 있을 때, 배열을 돌려보려고 한다. 배열은 다음과 같이 반시계 방향으로 돌려야 한다.

A[1][1] ← A[1][2] ← A[1][3] ← A[1][4] ← A[1][5]
   ↓                                       ↑
A[2][1]   A[2][2] ← A[2][3] ← A[2][4]   A[2][5]
   ↓         ↓                   ↑         ↑
A[3][1]   A[3][2] → A[3][3] → A[3][4]   A[3][5]
   ↓                                       ↑
A[4][1] → A[4][2] → A[4][3] → A[4][4] → A[4][5]
예를 들어, 아래와 같은 배열을 2번 회전시키면 다음과 같이 변하게 된다.

1 2 3 4       2 3 4 8       3 4 8 6
5 6 7 8       1 7 7 6       2 7 8 2
9 8 7 6   →   5 6 8 2   →   1 7 6 3
5 4 3 2       9 5 4 3       5 9 5 4
 <시작>         <회전1>        <회전2>
배열과 정수 R이 주어졌을 때, 배열을 R번 회전시킨 결과를 구해보자.

입력
첫째 줄에 배열의 크기 N, M과 수행해야 하는 회전의 수 R이 주어진다.

둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.

출력
입력으로 주어진 배열을 R번 회전시킨 결과를 출력한다.

제한
2 ≤ N, M ≤ 300
1 ≤ R ≤ 1,000
min(N, M) mod 2 = 0
1 ≤ Aij ≤ 108
예제 입력 1 
4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
예제 출력 1 
3 4 8 12
2 11 10 16
1 7 6 15
5 9 13 14
예제 입력 2 
5 4 7
1 2 3 4
7 8 9 10
13 14 15 16
19 20 21 22
25 26 27 28
예제 출력 2 
28 27 26 25
22 9 15 19
16 8 21 13
10 14 20 7
4 3 2 1
예제 입력 3 
2 2 3
1 1
1 1
예제 출력 3 
1 1
1 1

***************************************************************************************************/

package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());    // 배열의 행
        int M = Integer.parseInt(st.nextToken());    // 배열의 열
        int R = Integer.parseInt(st.nextToken());    // 회전 수

        int[][] arr = new int[N][M];

        // 배열 입력 받기
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // R번 회전
        for(int i = 0; i < R; i++){
            arr = circle(arr, 0, 0);
        }

        // 배열 출력
        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m++){
                sb.append(arr[n][m]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    // 회전 함수
    private static int[][] circle(int[][] arr, int a, int b) {
        int num = arr[a][b];
        int r = arr.length - 1 - a;
        int c = arr[0].length - 1 - b;

        for(int i = b; i < c; i++){
            arr[a][i] = arr[a][i + 1];
        }

        for(int i = a; i < r; i++){
            arr[i][c] = arr[i + 1][c];
        }

        for(int i = c; i > b; i--){
            arr[r][i] = arr[r][i - 1];
        }

        for(int i = r; i > a; i--){
            arr[i][b] = arr[i - 1][b];
        }

        arr[a + 1][b] = num;

        if(a < (arr.length - 1) / 2 && b < (arr[0].length - 1) / 2){
            a++;
            b++;

            arr = circle(arr, a, b);
        }

        return arr;
    }
}