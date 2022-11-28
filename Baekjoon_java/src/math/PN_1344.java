/***************************************************************************************************
1344번 축구

limit_time : 2s, limit_memory : 128MB

문제
홍준이는 축구 경기를 보고 있다. 그러다가 홍준이는 역시 두 팀 중 적어도 한 팀이 골을 소수로 득점할 확률이 궁금해 졌다. 축구 경기는 90분동안 이루어지고, 분석을 쉽게하기 위해서 경기를 5분 간격으로 나눴다. 처음 간격은 처음 5분이고, 두 번째 간격은 그 다음 5분, 그리고 이런식으로 나눈다. 경기가 진행되는 동안 각 간격에서 A팀이 득점할 확률과 B팀이 득점할 확률이 주어진다. 그리고, 각 간격에서 두 팀은 각각 많아야 한 골을 득점할 수 있다. 경기가 끝난 후 적어도 한 팀이 골을 소수로 득점할 확률을 구하시오.

입력
첫째 줄에 A팀이 득점할 확률, 둘째 줄에 B팀이 득점할 확률이 퍼센트 단위로 주어진다. 퍼센트 단위로 주어지는 확률은 모두 0보다 크거나 같고 100보다 작거나 같은 정수이다.

출력
첫째 줄에 적어도 한 팀이 골을 소수로 득점할 확률을 출력한다. 정답과의 절대/상대 오차가 10-6이내인 경우에 정답이다.

예제 입력 1 
50
50
예제 출력 1 
0.5265618908306351
예제 입력 2 
100
100
예제 출력 2 
0.0
예제 입력 3 
12
89
예제 출력 3 
0.6772047168840167
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_1344 {
    static int[] prim = { 2, 3, 5, 7, 11, 13, 17 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double A = Double.parseDouble(br.readLine()) / 100;
        double B = Double.parseDouble(br.readLine()) / 100;

        int[][] dp = new int[19][19];

        for (int i = 0; i < 19; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < 19; i++) {
            for (int j = 1; j < 19; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        double result = 0;

        for (int i = 0; i < 7; i++) {
            result += dp[18][prim[i]] * (Math.pow(A, prim[i]) * Math.pow((1 - A), 18 - prim[i]));
            result += dp[18][prim[i]] * (Math.pow(B, prim[i]) * Math.pow((1 - B), 18 - prim[i]));
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                result -= dp[18][prim[i]] * (Math.pow(A, prim[i]) * Math.pow((1 - A), 18 - prim[i])) * dp[18][prim[j]]
                        * (Math.pow(B, prim[j]) * Math.pow((1 - B), 18 - prim[j]));
            }
        }

        System.out.println(result);
    }
}
