/***************************************************************************************************
20361번 일우는 야바위꾼

limit_time : 2s, limit_memory : 1024MB

문제
전설의 야바위꾼 일우는 Shell Game으로 야바위를 한다. Shell Game은 다음과 같은 절차로 진행된다.

진행자가 N개의 컵을 일렬로 놓고, 그 중 X번째 컵에 공을 숨겨둔다.
임의의 서로 다른 두 컵의 위치를 맞바꾼다. 이 항목을 K번 수행한다. 만약, 공을 숨겨둔 컵을 움직인다면 공도 그 컵을 따라서 움직인다.
참가자는 몇 번째 컵에 공이 숨겨져 있는지 추측한다.
그 컵에 공이 숨겨져 있다면 참가자가, 그렇지 않다면 진행자가 이긴다.


수혁이는 Shell Game을 잘하고 싶다. 하지만, 일우가 진행자라면 무슨 수를 써도 이길 수 없어 수혁이는 일우의 사기도박을 의심하고 있다. 현재 우리는 수혁과 일우가 진행한 Shell Game의 모든 기록을 입수했다. 이를 바탕으로, 일우가 사기도박을 하지 않았다면 공이 몇 번째 컵에 있는지 알려주는 프로그램을 작성하자.

입력
첫째 줄에 N (3 ≤ N ≤ 200,000), X (1 ≤ X ≤ N), K (1 ≤ K ≤ 100,000)가 공백으로 구분되어 주어진다.

둘째 줄부터 K개의 줄에는 순서대로 바꾼 두 컵의 위치 Ai, Bi (1 ≤ Ai, Bi ≤ N, Ai ≠ Bi)가 공백으로 구분되어 주어진다.

주어지는 모든 입력은 정수다.

출력
일우가 사기도박을 하지 않았다면, 공이 몇 번째 위치의 컵에 있어야 하는지 정수로 출력하시오.

예제 입력 1 
3 2 4
1 3
3 2
3 1
2 3
예제 출력 1 
1
2번째 맞바꿈에서 공은 3번째 위치로 가게 된다.

3번째 맞바꿈에서 공은 1번째 위치로 가게 된다.
***************************************************************************************************/

package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_20361 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 종이컵의 수
        int N = Integer.parseInt(st.nextToken());
        // 간식이 들어있는 종이컵이 왼쪽에서 몇 번째에 있는 종이컵인지
        int X = Integer.parseInt(st.nextToken());
        // 컵의 위치를 맞바꾸는 횟수
        int K = Integer.parseInt(st.nextToken());

        // 종이컵 중에 간식이 들어있는 위치는 true, 없으면 false이다.
        boolean[] cup = new boolean[N + 1];

        // 간식이 있는 종이컵의 값을 true로 설정한다.
        cup[X] = true;

        // 종이컵 위치 바꾸는 횟수 반복
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());

            // 입력된 종이컵 바꾸기
            swap(cup, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 간식이 있는 종이컵 찾기
        for (int i = 1; i < cup.length; i++) {
            if (cup[i]) {
                sb.append(i);
            }
        }

        System.out.println(sb.toString());
    }

    // 종이컵 교환 작업
    private static void swap(boolean[] cup, int a, int b) {
        boolean idx = cup[a];
        cup[a] = cup[b];
        cup[b] = idx;
    }
}
