/***************************************************************************************************
16283번 Farm

limit_time : 0.1s, limit_memory : 512MB

문제
목장 주인인 상배는 양과 염소들을 같이 기르고 있다. 기르는 양과 염소는 각각 한 마리 이상이다. 양과 염소는 같은 사료를 먹고, 양 한 마리는 하루에 사료를 정확히 a 그램 먹고, 염소 한 마리는 하루에 정확히 b 그램을 먹는다고 한다.

상배는 매일 아침 양과 염소가 각각 몇 마리인지를 확인하는 작업을 한다. 양과 염소가 각각 몇 마리인지 확인할 때, 양과 염소들이 돌아 다녀서 정확하게 그 수를 구하는 것이 쉽지 않았다. 대신에 양과 염소가 전체 몇 마리인지를 확인하고, 또 양과 염소가 어제 하루 동안 소비한 전체 사료의 양만 확인해서 양과 염소가 각각 몇 마리 인지를 알려고 한다.

상배가 확인한 양과 염소 전체가 n마리이고, 어제 하루 동안 소비한 전체 사료의 양이 w그램일 때, 양과 염소가 각각 몇 마리인지를 구하는 프로그램을 작성하시오. 

입력
입력은 표준입력을 사용한다. 첫 번째 줄에 네 정수 a, b, n, w가 한 줄에 주어진다. 1 ≤ a ≤ 1,000, 1 ≤ b ≤ 1,000, 2 ≤ n ≤ 1,000, 2 ≤ w ≤ 1,000,000이다.

출력
출력은 표준출력을 사용한다. 첫 번째 줄에 양의 수와 염소의 수를 각각 출력한다. 만약 가능한 해가 두 개 이상 있는 경우 혹은 가능한 해가 없을 경우, -1 을 출력한다. 

예제 입력 1 
3 4 9 32
예제 출력 1 
4 5
예제 입력 2 
3 4 8 32
예제 출력 2 
-1
예제 입력 3 
100 100 2 200
예제 출력 3 
1 1
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_16283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int num = 0;

        for (int i = 1; i < n; i++) {
            if (i * a + (n - i) * b == w) {
                cnt++;
                num = i;
            }
        }

        if (cnt == 1) {
            System.out.println(num + " " + (n - num));
        } else {
            System.out.println(-1);
        }
    }
}