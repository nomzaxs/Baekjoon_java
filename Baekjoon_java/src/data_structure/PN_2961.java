/***************************************************************************************************
2961번 도영이가 만든 맛있는 음식

limit_time : 1s, limit_memory : 128MB

문제
도영이는 짜파구리 요리사로 명성을 날렸었다. 이번에는 이전에 없었던 새로운 요리에 도전을 해보려고 한다.

지금 도영이의 앞에는 재료가 N개 있다. 도영이는 각 재료의 신맛 S와 쓴맛 B를 알고 있다. 여러 재료를 이용해서 요리할 때, 그 음식의 신맛은 사용한 재료의 신맛의 곱이고, 쓴맛은 합이다.

시거나 쓴 음식을 좋아하는 사람은 많지 않다. 도영이는 재료를 적절히 섞어서 요리의 신맛과 쓴맛의 차이를 작게 만들려고 한다. 또, 물을 요리라고 할 수는 없기 때문에, 재료는 적어도 하나 사용해야 한다.

재료의 신맛과 쓴맛이 주어졌을 때, 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램을 작성하시오.

입력
첫째 줄에 재료의 개수 N(1 ≤ N ≤ 10)이 주어진다. 다음 N개 줄에는 그 재료의 신맛과 쓴맛이 공백으로 구분되어 주어진다. 모든 재료를 사용해서 요리를 만들었을 때, 그 요리의 신맛과 쓴맛은 모두 1,000,000,000보다 작은 양의 정수이다.

출력
첫째 줄에 신맛과 쓴맛의 차이가 가장 작은 요리의 차이를 출력한다. 

예제 입력 1 
1
3 10
예제 출력 1 
7
예제 입력 2 
2
3 8
5 8
예제 출력 2 
1
예제 입력 3 
4
1 7
2 6
3 8
4 9
예제 출력 3 
1
2, 3, 4번 재료를 사용한다면, 요리의 신맛은 2×3×4=24, 쓴맛은 6+8+9=23이 된다. 차이는 1이다.
***************************************************************************************************/

// 부분집합 학습 필요

package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_2961 {
    static int N;
    static int[] S;
    static int[] B;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        S = new int[N];
        B = new int[N];

        int Ssum = 0;
        int Bsum = 0;

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            S[n] = Integer.parseInt(st.nextToken());
            B[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(recur(Ssum, Bsum, 0, Integer.MAX_VALUE));
    }

    public static int recur(int Ssum, int Bsum, int cnt, int min) {
        if (cnt == N) {
            if (Ssum > Bsum && Ssum != 0) {
                min = Math.min(min, Ssum - Bsum);
            } else if (Ssum != 0) {
                min = Math.min(min, Bsum - Ssum);
            }
            return min;
        }

        min = Math.min(min, recur(Ssum, Bsum, cnt + 1, min));

        if (Ssum == 0) {
            min = Math.min(min, recur(S[cnt], Bsum + B[cnt], cnt + 1, min));
        } else {
            min = Math.min(min, recur(Ssum * S[cnt], Bsum + B[cnt], cnt + 1, min));
        }
        return min;
    }
}