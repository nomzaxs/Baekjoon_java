/***************************************************************************************************
9417번 최대 GCD

limit_time : 1s, limit_memory : 128MB

문제
정수 M개가 주어졌을 때, 모든 두 수의 쌍 중에서 가장 큰 최대공약수 찾는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 N (1 < N < 100)이 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있으며, 양의 정수 M (1 < M < 100)개가 주어진다. 모든 수는 -231보다 크거나 같고, 231 -1보다 작거나 같다. 

출력
각 테스트 케이스마다, 입력으로 주어진 수의 모든 두 수의 쌍의 최대공약수 중 가장 큰 값을 출력한다.

예제 입력 1 
3
10 20 30 40
7 5 12
125 15 25
예제 출력 1 
20
1
25
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_9417 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[100];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int maxGcd = -1;
            int num = 0;

            while (st.hasMoreTokens()) {
                arr[num++] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < num; i++) {
                for (int j = i + 1; j < num; j++) {
                    int temp = gcd(arr[i], arr[j]);
                    if (maxGcd < temp) {
                        maxGcd = temp;
                    }
                }
            }

            sb.append(maxGcd + "\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static int gcd(int i, int j) {
        if (j == 0) {
            return i;
        } else {
            return gcd(j, i % j);
        }
    }
}
