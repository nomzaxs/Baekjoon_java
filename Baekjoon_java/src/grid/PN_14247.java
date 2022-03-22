/***************************************************************************************************
14247번 나무 자르기

limit_time : 1s, limit_memory : 512MB

문제
영선이는 나무꾼으로 나무를 구하러 오전에 산에 오른다. 산에는 n개의 나무가 있는데, 영선이는 하루에 한 나무씩 n일 산에 오르며 나무를 잘라갈 것이다. 하지만 이 산은 영험한 기운이 있어 나무들이 밤만 되면 매우 빠른 속도로 자라는데, 그 자라는 길이는 나무마다 다르다.

따라서, 어느 나무를 먼저 잘라가느냐에 따라서 총 구할 수 있는 나무의 양이 다른데,

나무의 처음 길이와 하루에 자라는 양이 주어졌을 때, 영선이가 얻을 수 있는 최대 나무양을 구하시오.

참고로, 자른 이후에도 나무는 0부터 다시 자라기 때문에 같은 나무를 여러 번 자를 수는 있다.

입력
첫째 줄에는 나무의 개수 n개가 있다.(1≤n≤100,000) 나무는 1번부터 n번까지 있다.

다음 줄에는 첫날 올라갔을 때 나무의 길이들 Hi가 n개가 순서대로 주어진다.(1≤Hi≤100,000)

그 다음 줄에는 나무들이 자라는 길이 Ai가 n개가 순서대로 주어진다.(1≤Ai≤10,000)

출력
영선이가 나무를 잘라서 구할 수 있는 최대 양을 출력하시오.

예제 입력 1 
5
1 3 2 4 6
2 7 3 4 1
예제 출력 1 
64
***************************************************************************************************/

package grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class PN_14247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] wood = new int[N][2];
        long result = 0;

        st = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            wood[n][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            wood[n][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wood, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < N; i++) {
            result += wood[i][0] + (wood[i][1] * i);
        }

        System.out.print(result);
    }
}