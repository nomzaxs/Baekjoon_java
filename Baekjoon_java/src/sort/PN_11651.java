/***************************************************************************************************
11651번 좌표 정렬하기 2

limit_time : 1s, limit_memory : 256MB

문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

예제 입력 1 
5
0 4
1 2
1 -1
2 2
3 3
예제 출력 1 
1 -1
1 2
2 2
3 3
0 4
***************************************************************************************************/

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class PN_11651 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] point = new int[N][2];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            point[n][0] = Integer.parseInt(st.nextToken());
            point[n][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(point, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        for (int i = 0; i < point.length; i++) {
            System.out.println(point[i][0] + " " + point[i][1]);
        }
    }
}