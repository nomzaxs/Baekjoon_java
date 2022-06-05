/***************************************************************************************************
2792번 보석 상자

limit_time : 1s, limit_memory : 128MB

문제
보석 공장에서 보석 상자를 유치원에 기증했다. 각각의 보석은 M가지 서로 다른 색상 중 한 색상이다. 원장 선생님은 모든 보석을 N명의 학생들에게 나누어 주려고 한다. 이때, 보석을 받지 못하는 학생이 있어도 된다. 하지만, 학생은 항상 같은 색상의 보석만 가져간다.

한 아이가 너무 많은 보석을 가져가게 되면, 다른 아이들이 질투를 한다. 원장 선생님은 이런 질투심을 수치화하는데 성공했는데, 질투심은 가장 많은 보석을 가져간 학생이 가지고 있는 보석의 개수이다. 원장 선생님은 질투심이 최소가 되게 보석을 나누어 주려고 한다.

상자에 빨간 보석이 4개 (RRRR), 파란 보석이 7개 (BBBBBBB) 있었고, 이 보석을 5명의 아이들에게 나누어 주는 경우를 생각해보자. RR, RR, BB, BB, BBB로 보석을 나누어주면 질투심은 3이 되고, 이 값보다 작게 나누어 줄 수 없다.

상자 안의 보석 정보와 학생의 수가 주어졌을 때, 질투심이 최소가 되게 보석을 나누어주는 방법을 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 아이들의 수 N과 색상의 수 M이 주어진다. (1 ≤ N ≤ 109, 1 ≤ M ≤ 300,000, M ≤ N)

다음 M개 줄에는 구간 [1, 109]에 포함되는 양의 정수가 하나씩 주어진다. K번째 줄에 주어지는 숫자는 K번 색상 보석의 개수이다.

출력
첫째 줄에 질투심의 최솟값을 출력한다.

예제 입력 1 
5 2
7
4
예제 출력 1 
3
예제 입력 2 
7 5
7
1
7
4
4
예제 출력 2 
4
***************************************************************************************************/

package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int s = 0;
        int e = 0;
        int res = 1000000001;

        int[] arr = new int[M];

        for (int m = 0; m < M; m++) {
            arr[m] = Integer.parseInt(br.readLine());
            e = Math.max(e, arr[m]);
        }

        while (s <= e) {
            int sum = 0;
            int mid = (s + e) / 2;

            if (mid == 0) {
                s = mid + 1;
                continue;
            }

            for (int i = 0; i < M; i++) {
                sum += arr[i] / mid;
                if (arr[i] % mid != 0) {
                    sum += 1;
                }
            }

            if (sum > N) {
                s = mid + 1;
            } else {
                e = mid - 1;
                res = Math.min(res, mid);
            }
        }

        System.out.println(res);
    }
}