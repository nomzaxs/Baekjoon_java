/***************************************************************************************************
23351번 물 주기

limit_time : 1s, limit_memory : 512MB

문제
랑이 집사는 고양이들이 좋아한다는 캣닢을 직접 재배하려고 한다.

일직선으로 놓여진 $N$개의 화분에 캣닢이 하나씩 심어져 있다.

각 화분은 초기에 $K$만큼의 수분을 머금고 있고, 매일 아래와 같은 일이 순서대로 일어난다.

랑이 집사가 연속된 $A$개의 화분에 물을 준다. 이 때 물을 준 화분의 수분은 $B$만큼씩 증가한다.
모든 화분의 수분이 1씩 감소한다.
수분이 0이 된 화분에 있는 캣닢은 죽는다.
모든 캣닢이 살아 있는 기간이 최대한 길어지도록 물을 줄 때, 첫 캣닢이 죽는 날짜를 출력하는 프로그램을 작성하시오. 첫 날은 1일이다.

입력
첫째 줄에 자연수 $N$, $K$, $A$, $B$가 공백을 사이에 두고 주어진다. ($2 \le N \le 100$, $1 \le K \le 100$, $1 \le A \times B < N$, $A$는 $N$의 약수)

출력
모든 캣닢이 살아 있는 기간이 최대한 길어지도록 물을 줄 때, 첫 캣닢이 죽는 날짜를 출력한다.

예제 입력 1 
6 3 2 2
예제 출력 1 
5
예제 입력 2 
2 2 1 1
예제 출력 2 
3
***************************************************************************************************/

package grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_23351 {
    static int N, K, A, B, day;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = K;
        }

        day = 1;
        int p = 0;

        while (true) {
            watering(p);
            p += A;
            p %= N;

            if (decrease()) {
                break;
            }
        }

        System.out.println(day);
    }

    private static boolean decrease() {
        for (int i = 0; i < N; i++) {
            arr[i]--;

            if (arr[i] == 0) {
                return true;
            }
        }

        day++;
        return false;
    }

    private static void watering(int p) {
        for (int i = 0; i < A; i++) {
            arr[(p + i) % N] += B;
        }
    }
}
