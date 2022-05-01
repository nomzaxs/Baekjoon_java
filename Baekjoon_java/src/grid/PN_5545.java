/***************************************************************************************************
5545번 최고의 피자

limit_time : 1s, limit_memory : 128MB

문제
상근이는 근처 피자 가게에서 매일 저녁으로 피자를 배달해 먹는다. 주머니 사정이 얇아진 상근이는 이번 달부터는 "최고의 피자"를 구매하려고 한다. 최고의 피자란, 피자 가게에서 주문할 수 있는 피자 중 1원당 열량이 가장 높은 피자를 말한다. 최고의 피자는 여러 종류가 있을 수도 있다.

이 피자 가게는 토핑 N개에서 여러 종류를 선택해서 주문할 수 있다. 같은 종류의 토핑을 2개 이상 선택할 수는 없다. 또, 토핑을 전혀 선택하지 않을 수도 있다.

선택한 토핑은 도우 위에 올라간다. 도우의 가격은 A원이고, 토핑의 가격은 모두 B원이다. 피자의 가격은 도우와 토핑의 가격의 합계가 된다. 즉, 토핑을 k종류 (0 ≤ k ≤ N) 선택했다면, 피자의 가격은 A + B*k원이 된다. 피자의 열량은 도우와 토핑의 열량의 합이다.

도우의 가격, 토핑의 가격, 그리고 도우와 각 토핑의 열량 값이 주어졌을 때, 최고의 피자의 1원 당 열량을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 토핑의 종류의 수 N(1 ≤ N ≤ 100)이 주어진다. 둘째 줄에는 도우의 가격 A와 토핑의 가격 B가 주어진다. (1 ≤ A, B ≤ 1000) 셋째 줄에는 도우의 열량 C가 주어진다. (1 ≤ C ≤ 10000) 다음 줄부터 N개 줄에는 각 토핑의 열량 Di가 한 줄에 하나씩 주어진다. (1 ≤ Di ≤ 10000)

출력
첫째 줄에 최고의 피자의 1원 당 열량을 출력한다. 소수점 이하는 버리고 정수 값으로 출력한다.

예제 입력 1 
3
12 2
200
50
300
100
예제 출력 1 
37
예제 입력 2 
4
20 3
900
300
100
400
1300
예제 출력 2 
100
***************************************************************************************************/

package grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PN_5545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int C = Integer.parseInt(br.readLine());

        int[] D = new int[N];

        for (int n = 0; n < N; n++) {
            D[n] = Integer.parseInt(br.readLine());
        }

        int money = A;
        int sum = C;
        int max = sum / money;

        Arrays.sort(D);

        for (int i = D.length - 1; i >= 0; i--) {
            sum += D[i];
            money += B;

            if (sum / money < max) {
                break;
            }
            max = sum / money;
        }

        System.out.println(max);
    }
}