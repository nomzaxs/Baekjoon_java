/***************************************************************************************************
16935번 배열 돌리기 3

limit_time : 2s, limit_memory : 512MB

문제
크기가 N×M인 배열이 있을 때, 배열에 연산을 R번 적용하려고 한다. 연산은 총 6가지가 있다.

1번 연산은 배열을 상하 반전시키는 연산이다.

1 6 2 9 8 4 → 4 2 9 3 1 8
7 2 6 9 8 2 → 9 2 3 6 1 5
1 8 3 4 2 9 → 7 4 6 2 3 1
7 4 6 2 3 1 → 1 8 3 4 2 9
9 2 3 6 1 5 → 7 2 6 9 8 2
4 2 9 3 1 8 → 1 6 2 9 8 4
   <배열>       <연산 결과>
2번 연산은 배열을 좌우 반전시키는 연산이다.

1 6 2 9 8 4 → 4 8 9 2 6 1
7 2 6 9 8 2 → 2 8 9 6 2 7
1 8 3 4 2 9 → 9 2 4 3 8 1
7 4 6 2 3 1 → 1 3 2 6 4 7
9 2 3 6 1 5 → 5 1 6 3 2 9
4 2 9 3 1 8 → 8 1 3 9 2 4
   <배열>       <연산 결과>
3번 연산은 오른쪽으로 90도 회전시키는 연산이다.

1 6 2 9 8 4 → 4 9 7 1 7 1
7 2 6 9 8 2 → 2 2 4 8 2 6
1 8 3 4 2 9 → 9 3 6 3 6 2
7 4 6 2 3 1 → 3 6 2 4 9 9
9 2 3 6 1 5 → 1 1 3 2 8 8
4 2 9 3 1 8 → 8 5 1 9 2 4
   <배열>       <연산 결과>
4번 연산은 왼쪽으로 90도 회전시키는 연산이다.

1 6 2 9 8 4 → 4 2 9 1 5 8
7 2 6 9 8 2 → 8 8 2 3 1 1
1 8 3 4 2 9 → 9 9 4 2 6 3
7 4 6 2 3 1 → 2 6 3 6 3 9
9 2 3 6 1 5 → 6 2 8 4 2 2
4 2 9 3 1 8 → 1 7 1 7 9 4
   <배열>       <연산 결과>
5, 6번 연산을 수행하려면 배열을 크기가 N/2×M/2인 4개의 부분 배열로 나눠야 한다. 아래 그림은 크기가 6×8인 배열을 4개의 그룹으로 나눈 것이고, 1부터 4까지의 수로 나타냈다.

1 1 1 1 2 2 2 2
1 1 1 1 2 2 2 2
1 1 1 1 2 2 2 2
4 4 4 4 3 3 3 3
4 4 4 4 3 3 3 3
4 4 4 4 3 3 3 3
5번 연산은 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동시키는 연산이다.

3 2 6 3 1 2 9 7 → 2 1 3 8 3 2 6 3
9 7 8 2 1 4 5 3 → 1 3 2 8 9 7 8 2
5 9 2 1 9 6 1 8 → 4 5 1 9 5 9 2 1
2 1 3 8 6 3 9 2 → 6 3 9 2 1 2 9 7
1 3 2 8 7 9 2 1 → 7 9 2 1 1 4 5 3
4 5 1 9 8 2 1 3 → 8 2 1 3 9 6 1 8
     <배열>            <연산 결과>
6번 연산은 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동시키는 연산이다.

3 2 6 3 1 2 9 7 → 1 2 9 7 6 3 9 2
9 7 8 2 1 4 5 3 → 1 4 5 3 7 9 2 1
5 9 2 1 9 6 1 8 → 9 6 1 8 8 2 1 3
2 1 3 8 6 3 9 2 → 3 2 6 3 2 1 3 8
1 3 2 8 7 9 2 1 → 9 7 8 2 1 3 2 8
4 5 1 9 8 2 1 3 → 5 9 2 1 4 5 1 9
     <배열>            <연산 결과>
입력
첫째 줄에 배열의 크기 N, M과 수행해야 하는 연산의 수 R이 주어진다.

둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.

마지막 줄에는 수행해야 하는 연산이 주어진다. 연산은 공백으로 구분되어져 있고, 문제에서 설명한 연산 번호이며, 순서대로 적용시켜야 한다.

출력
입력으로 주어진 배열에 R개의 연산을 순서대로 수행한 결과를 출력한다.

제한
2 ≤ N, M ≤ 100
1 ≤ R ≤ 1,000
N, M은 짝수
1 ≤ Aij ≤ 108
예제 입력 1 
6 8 1
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
1
예제 출력 1 
4 5 1 9 8 2 1 3
1 3 2 8 7 9 2 1
2 1 3 8 6 3 9 2
5 9 2 1 9 6 1 8
9 7 8 2 1 4 5 3
3 2 6 3 1 2 9 7
예제 입력 2 
6 8 1
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
2
예제 출력 2 
7 9 2 1 3 6 2 3
3 5 4 1 2 8 7 9
8 1 6 9 1 2 9 5
2 9 3 6 8 3 1 2
1 2 9 7 8 2 3 1
3 1 2 8 9 1 5 4
예제 입력 3 
6 8 1
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
3
예제 출력 3 
4 1 2 5 9 3
5 3 1 9 7 2
1 2 3 2 8 6
9 8 8 1 2 3
8 7 6 9 1 1
2 9 3 6 4 2
1 2 9 1 5 9
3 1 2 8 3 7
예제 입력 4 
6 8 1
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
4
예제 출력 4 
7 3 8 2 1 3
9 5 1 9 2 1
2 4 6 3 9 2
1 1 9 6 7 8
3 2 1 8 8 9
6 8 2 3 2 1
2 7 9 1 3 5
3 9 5 2 1 4
예제 입력 5 
6 8 1
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
5
예제 출력 5 
2 1 3 8 3 2 6 3
1 3 2 8 9 7 8 2
4 5 1 9 5 9 2 1
6 3 9 2 1 2 9 7
7 9 2 1 1 4 5 3
8 2 1 3 9 6 1 8
예제 입력 6 
6 8 1
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
6
예제 출력 6 
1 2 9 7 6 3 9 2
1 4 5 3 7 9 2 1
9 6 1 8 8 2 1 3
3 2 6 3 2 1 3 8
9 7 8 2 1 3 2 8
5 9 2 1 4 5 1 9
예제 입력 7 
6 8 6
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
1 2 3 4 5 6
예제 출력 7 
3 1 2 8 9 1 5 4
1 2 9 7 8 2 3 1
2 9 3 6 8 3 1 2
8 1 6 9 1 2 9 5
3 5 4 1 2 8 7 9
7 9 2 1 3 6 2 3
***************************************************************************************************/

package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_16935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] copy;

        // 배열 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    arr = upDown(arr);
                    break;
                case 2:
                    arr = leftRight(arr);
                    break;
                case 3:
                    copy = rRotation(arr);
                    arr = copy;
                    break;
                case 4:
                    copy = lRotation(arr);
                    arr = copy;
                    break;
                case 5:
                    arr = CRR(arr);
                    break;
                case 6:
                    arr = CLR(arr);
                    break;
                default:
                    break;
            }
        }

        // 배열 출력
        for (int n = 0; n < arr.length; n++) {
            for (int m = 0; m < arr[0].length; m++) {
                sb.append(arr[n][m]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    // 반시계방향 4분할 회전
    private static int[][] CLR(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] copy = new int[N][M];

        // 1->4;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                copy[i + N / 2][j] = arr[i][j];
            }
        }

        // 4->3;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                copy[i + N / 2][j + M / 2] = arr[i + N / 2][j];
            }
        }

        // 3->2;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                copy[i][j + M / 2] = arr[i + N / 2][j + M / 2];
            }
        }

        // 2->1;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                copy[i][j] = arr[i][j + M / 2];
            }
        }

        return copy;
    }

    // 시계방향 4분할 회전
    private static int[][] CRR(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] copy = new int[N][M];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                copy[i][j] = arr[i][j];
            }
        }

        // 1->2;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                copy[i][j + M / 2] = arr[i][j];
            }
        }

        // 2->3;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                copy[i + N / 2][j + M / 2] = arr[i][j + M / 2];
            }
        }

        // 3->4;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                copy[i + N / 2][j] = arr[i + N / 2][j + M / 2];
            }
        }

        // 4->1;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                copy[i][j] = arr[i + N / 2][j];
            }
        }

        return copy;
    }

    // 왼쪽 90도 회전
    private static int[][] lRotation(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] copy = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[M - 1 - j][i] = arr[i][j];
            }
        }
        return copy;
    }

    // 오른쪽 90도 회전
    private static int[][] rRotation(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] copy = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[j][N - 1 - i] = arr[i][j];
            }
        }
        return copy;
    }

    // 좌우 반전
    private static int[][] leftRight(int[][] arr) {
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length / 2; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[i][arr[0].length - 1 - j];
                arr[i][arr[0].length - 1 - j] = temp;
            }
        }
        return arr;
    }

    // 상하 반전
    private static int[][] upDown(int[][] arr) {
        int temp = 0;

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                temp = arr[j][i];
                arr[j][i] = arr[arr.length - 1 - j][i];
                arr[arr.length - 1 - j][i] = temp;
            }
        }
        return arr;
    }
}