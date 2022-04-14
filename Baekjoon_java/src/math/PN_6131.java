/***************************************************************************************************
6131번 완전 제곱수

limit_time : 1s, limit_memory : 128MB

문제
상근이는 선영이와 함께 게임을 하고 있다. 먼저, 상근이는 두 양의 정수 A와 B를 고른다. (1 ≤ B ≤ A ≤ 500) 그 다음, 선영이는 상근이가 고른 수를 맞춰야 한다.

상근이는 선영이에게 다음과 같은 힌트를 주었다.

A의 제곱은 B의 제곱보다 N만큼 커 (1 ≤ N ≤ 1,000)

위의 힌트 조건을 만족하는 A와 B 쌍의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다.

출력
상근이의 힌트 조건을 만족하는 (A,B) 쌍의 개수를 출력한다. 

예제 입력 1 
15
예제 출력 1 
2
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_6131 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 1; i < 501; i++) {
            double A = Math.pow(i, 2);
            for (int j = 1; j < 501; j++) {
                double B = Math.pow(j, 2);

                if (A == B + N) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
