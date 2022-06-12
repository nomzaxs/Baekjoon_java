/***************************************************************************************************
10807번 개수 세기

limit_time : 1s, limit_memory : 256MB

문제
총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수 N(1 ≤ N ≤ 100)이 주어진다. 둘째 줄에는 정수가 공백으로 구분되어져있다. 셋째 줄에는 찾으려고 하는 정수 v가 주어진다. 입력으로 주어지는 정수와 v는 -100보다 크거나 같으며, 100보다 작거나 같다.

출력
첫째 줄에 입력으로 주어진 N개의 정수 중에 v가 몇 개인지 출력한다.

예제 입력 1 
11
1 4 1 2 4 2 4 2 3 4 4
2
예제 출력 1 
3
예제 입력 2 
11
1 4 1 2 4 2 4 2 3 4 4
5
예제 출력 2 
0
***************************************************************************************************/

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// public class PN_10807 {
//     public static void main(String[] args) throws NumberFormatException, IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;

//         int N = Integer.parseInt(br.readLine());

//         int[] arr = new int[201];

//         st = new StringTokenizer(br.readLine());

//         for (int n = 0; n < N; n++) {
//             arr[(Integer.parseInt(st.nextToken()) + 100)]++;
//         }

//         System.out.println(arr[(Integer.parseInt(br.readLine()) + 100)]);
//     }
// }

public class PN_10807 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int v = Integer.parseInt(br.readLine());
        int res = 0;

        for (int n = 0; n < N; n++) {
            if (v == arr[n]) {
                res++;
            }
        }

        System.out.println(res);
    }
}