/***************************************************************************************************
9095번 1, 2, 3 더하기

limit_time : 1s, limit_memory : 512MB

문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.

예제 입력 1 
3
4
7
10
예제 출력 1 
7
44
274
***************************************************************************************************/

package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_9095 {
    static int n;
    // static int cnt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());

            // cnt = 0;

            // recur(0);

            // System.out.println(cnt);

            System.out.println(recur(0));
        }
    }

    // private static void recur(int total) {
    // if (total > n) {
    // return;
    // }

    // if (total == n) {
    // cnt += 1;
    // return;
    // }

    // for (int i = 1; i < 4; i++) {
    // recur(total + i);
    // }
    // }

    private static int recur(int total) {
        int ret = 0;

        if (total > n) {
            return 0;
        }

        if (total == n) {
            return 1;
        }

        for (int i = 1; i < 4; i++) {
            ret += recur(total + i);
        }

        return ret;
    }
}
