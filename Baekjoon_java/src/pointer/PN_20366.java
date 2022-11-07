/***************************************************************************************************
20366번 같이 눈사람 만들래?

limit_time : 2s, limit_memory : 1024MB

문제
언니! 똑...똑똑...똑똑! 같이 눈사람 만들래~? ♪

언니 엘자와 동생 안나에게는 N개의 눈덩이가 있다. 각 눈덩이 i (1 ≤ i ≤ N)의 지름은 Hi 이다. 하나의 눈사람은 두 개의 눈덩이로 구성되며, 눈덩이 하나를 아래에 두고 그 눈덩이보다 크지 않은 다른 눈덩이를 쌓아올리는 방식으로 만들 수 있다. 이때, 눈사람의 키는 두 눈덩이 지름의 합과 같다.

엘자와 안나는 눈덩이 N개 중 서로 다른 4개를 골라서 눈사람을 각각 1개씩, 총 2개를 만들려고 한다. 두 자매는 두 눈사람의 키의 차이가 작을수록 두 눈사람의 사이가 좋을 것이라고 믿는다. 우리는 엘자와 안나가 가장 사이좋은 두 눈사람을 만들기 위해서 도와주려고 한다.



주어진 N개의 눈덩이를 이용하여 만들 수 있는 두 눈사람의 키 차이 중 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N (4 ≤ N ≤ 600)이 주어진다.

둘째 줄에는 각 눈덩이 i (1 ≤ i ≤ N)의 지름을 의미하는 정수 Hi (1 ≤ Hi ≤ 109)가 공백으로 구분되어 주어진다.

출력
만들 수 있는 두 눈사람의 키 차이 중 최솟값을 나타내는 정수를 출력하라.

예제 입력 1 
5
3 5 2 5 9
예제 출력 1 
1
높이가 (2, 5), (3, 5)로 구성된 눈사람 둘을 만드는 것이 최적의 경우 중 하나이다. |7-8| = 1

다른 경우로는 (2, 9), (5, 5)로 두 눈사람을 만드는 경우가 있다. |11-10| = 1
***************************************************************************************************/

package pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PN_20366 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int snow1, snow2;
        int result = 2000000010;

        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N; j++) {
                snow1 = arr[i] + arr[j];
                int p = i + 1;
                int q = j - 1;
                while (p < q) {
                    if (p == i || p == j) {
                        p++;
                        continue;
                    }
                    if (q == i || q == j) {
                        q++;
                        continue;
                    }
                    snow2 = arr[p] + arr[q];
                    result = Math.min(result, Math.abs(snow1 - snow2));
                    if (snow1 > snow2) {
                        p++;
                    } else if (snow1 < snow2) {
                        q--;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
