/***************************************************************************************************
2559번 수열

limit_time : 1s, limit_memory : 128MB

문제
매일 아침 9시에 학교에서 측정한 온도가 어떤 정수의 수열로 주어졌을 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 알아보고자 한다.

예를 들어, 아래와 같이 10일 간의 온도가 주어졌을 때, 

3 -2 -4 -9 0 3 7 13 8 -3

모든 연속적인 이틀간의 온도의 합은 아래와 같다.



이때, 온도의 합이 가장 큰 값은 21이다. 

또 다른 예로 위와 같은 온도가 주어졌을 때, 모든 연속적인 5일 간의 온도의 합은 아래와 같으며, 



이때, 온도의 합이 가장 큰 값은 31이다.

매일 측정한 온도가 정수의 수열로 주어졌을 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 계산하는 프로그램을 작성하시오. 

입력
첫째 줄에는 두 개의 정수 N과 K가 한 개의 공백을 사이에 두고 순서대로 주어진다. 첫 번째 정수 N은 온도를 측정한 전체 날짜의 수이다. N은 2 이상 100,000 이하이다. 두 번째 정수 K는 합을 구하기 위한 연속적인 날짜의 수이다. K는 1과 N 사이의 정수이다. 둘째 줄에는 매일 측정한 온도를 나타내는 N개의 정수가 빈칸을 사이에 두고 주어진다. 이 수들은 모두 -100 이상 100 이하이다. 

출력
첫째 줄에는 입력되는 온도의 수열에서 연속적인 K일의 온도의 합이 최대가 되는 값을 출력한다.

예제 입력 1 
10 2
3 -2 -4 -9 0 3 7 13 8 -3
예제 출력 1 
21
예제 입력 2 
10 5
3 -2 -4 -9 0 3 7 13 8 -3
예제 출력 2 
31
***************************************************************************************************/

package prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] prefix = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        arr[0] = 0;
        prefix[0] = 0;

        for (int n = 1; n <= N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            prefix[n] = arr[n] + prefix[n - 1];
        }

        int max = -10000000;

        for (int i = M; i <= N; i++) {
            max = Math.max(max, prefix[i] - prefix[i - M]);
        }

        System.out.println(max);
    }
}
